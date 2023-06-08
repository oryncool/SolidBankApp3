package kz.jusan.solidbankapp.dao;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.transaction.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDAO extends CrudRepository<Transaction, Integer> {
    List<Transaction> findTransactionsByAccountIdAndClientId(Account accountId, int clientId);
    void deleteTransactionByAccountId(String accountID);
}
