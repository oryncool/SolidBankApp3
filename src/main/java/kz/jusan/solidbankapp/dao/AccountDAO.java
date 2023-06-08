package kz.jusan.solidbankapp.dao;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface AccountDAO extends CrudRepository<Account, Integer> {
    List<Account> findAccountsByClientId(int clientID);
    List<Account> findAccountsByAccountType(AccountType accountType);
    Account findAccountByClientIdAndAccountId(int clientID, String accountID);
    Optional<Account> findAccountByIdAndClientId(int accountId, int clientId);
    Account findAccountById(int id);
    void deleteAccountById(int id);
}
