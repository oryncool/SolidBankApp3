package kz.jusan.solidbankapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import kz.jusan.solidbankapp.BankCore;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.security.JwtUtil;
import kz.jusan.solidbankapp.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@SecurityRequirement(name = "basicauth")
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {


    @Autowired
    private final BankCore bankCore;
    @Autowired
    private JwtUtil jwtUtil;

    private String getUsername(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }
        String jwtToken = token.substring(7);
        String username = jwtUtil.getUsernameFromToken(jwtToken);
        return username;
    }

    @GetMapping()
    public List<Account> getAccounts(HttpServletRequest request) {
        String username = getUsername(request);
        return bankCore.getClientAccounts(username);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable String id, HttpServletRequest request) {
        String username = getUsername(request);
        return bankCore.getClientAccount(username, id);
    }

    @PostMapping()
    public String createAccount(@RequestBody String accountType, HttpServletRequest request) {
        String username = getUsername(request);
        return bankCore.createNewAccount(accountType, username);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id, HttpServletRequest request){
        String username = getUsername(request);
        return bankCore.deleteAccount(id, username);
    }
    @GetMapping("/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable int id, HttpServletRequest request) {
        String username = getUsername(request);
        return bankCore.getTransactions(id, username);
    }

    @PostMapping("/{id}/withdraw")
    public String withdraw(@PathVariable String id, @RequestBody double amount, HttpServletRequest request) {
        String username = getUsername(request);
        return bankCore.withdraw(id, amount, username);
    }

    @PostMapping("/{id}/deposit")
    public String deposit(@PathVariable String id, @RequestBody double amount, HttpServletRequest request) {
        String username = getUsername(request);
        return bankCore.deposit(id, amount, username);
    }
}
