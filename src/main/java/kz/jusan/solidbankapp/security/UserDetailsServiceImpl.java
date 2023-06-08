package kz.jusan.solidbankapp.security;

import kz.jusan.solidbankapp.dao.UserDAO;
import kz.jusan.solidbankapp.models.Role;
import kz.jusan.solidbankapp.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userDAO.findUserByUsername(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("user" + username + " is not found");
        return new UserDetailsImpl(user.get().getUsername(), user.get().getPassword(), new Role(user.get().getRole()));
    }
}
