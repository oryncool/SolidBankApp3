package kz.jusan.solidbankapp.services.listing;

import  kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountListingServiceImpl implements AccountListingService{
    private AccountDAO accountDAO;

    public Account getClientAccount(int clientID, String accountID) {
        return accountDAO.findAccountByClientIdAndAccountId(clientID, accountID);
    }
    public Account getClientWithdrawAccount(int clientID, String accountID) {
        Account account = accountDAO.findAccountByClientIdAndAccountId(clientID, accountID);
        if (account.isWithdrawAllowed()) return account;
        return null;
    }
    public List<Account> getClientAccounts(int clientID) {
        return accountDAO.findAccountsByClientId(clientID);
    }
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.findAccountsByAccountType(accountType);
    }
}
