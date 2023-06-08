package kz.jusan.solidbankapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import kz.jusan.solidbankapp.dao.UserDAO;
import kz.jusan.solidbankapp.models.JwtRequest;
import kz.jusan.solidbankapp.models.User;
import kz.jusan.solidbankapp.models.UserDTO;
import kz.jusan.solidbankapp.security.JwtUtil;
import kz.jusan.solidbankapp.security.UserDetailsImpl;
import kz.jusan.solidbankapp.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDAO userDAO;

    @PostMapping("/register")
    public void register(@RequestBody JwtRequest jwtRequest) {
        String username = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        String role = jwtRequest.getRole();
        password = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userDAO.save(user);
    }

    @GetMapping("/login")
    public String login(@RequestBody JwtRequest jwtRequest) {
        String username = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtUtil.generateToken(userDetails);
    }

    @GetMapping("info")
    public UserDTO getInfo(HttpServletRequest request) {
        String username = getUsername(request);
        return new UserDTO(userDAO.findUserByUsername(username));
    }

    private String getUsername(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }
        String jwtToken = token.substring(7);
        String username = jwtUtil.getUsernameFromToken(jwtToken);
        return username;
    }
}
