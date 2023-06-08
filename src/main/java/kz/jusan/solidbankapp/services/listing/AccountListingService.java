package kz.jusan.solidbankapp.services.listing;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.account.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(int clientID, String accountID);
    Account getClientWithdrawAccount(int clientID, String accountID);
    List<Account> getClientAccounts(int clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
