package kz.jusan.solidbankapp.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRequest {
    private AccountType accountType;
    private String accountID;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;
}
