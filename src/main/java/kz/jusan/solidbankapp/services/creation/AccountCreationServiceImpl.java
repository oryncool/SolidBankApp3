package kz.jusan.solidbankapp.services.creation;

import kz.jusan.solidbankapp.account.*;
import kz.jusan.solidbankapp.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl() {
    }

    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public String create(AccountType accountType, long BankID, int clientID, long AccountId) {
        String accountNumber = String.format("%03d%06d", 1, AccountId);
        Account account = new Account();
        account.setAccountId(accountNumber);
        account.setWithdrawAllowed(accountType.isWithdrawAllowed());
        account.setBalance(0.0);
        account.setClientId(clientID);
        account.setAccountType(accountType);
        accountDAO.save(account);
        System.out.println("Bank account created");
        return "Account was created";
    }
}
