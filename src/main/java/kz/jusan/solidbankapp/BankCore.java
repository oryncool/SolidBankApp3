package kz.jusan.solidbankapp;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.dao.UserDAO;
import kz.jusan.solidbankapp.models.User;
import kz.jusan.solidbankapp.services.creation.AccountCreationService;
import kz.jusan.solidbankapp.dao.AccountDAO;
import kz.jusan.solidbankapp.services.delete.AccountDeletionService;
import kz.jusan.solidbankapp.services.listing.AccountListingService;
import kz.jusan.solidbankapp.services.deposit.TransactionDeposit;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.dao.TransactionDAO;
import kz.jusan.solidbankapp.services.withdraw.TransactionWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BankCore {
    private static final long id = 1;
    private long lastAccountNumber = 0;
    private AccountCreationService accountCreation;
    private AccountListingService accountListingService;
    private TransactionDAO transactionDAO;
    private AccountDeletionService accountDeletionService;
    private AccountDAO accountDAO;
    private TransactionWithdraw transactionWithdraw;
    private TransactionDeposit transactionDeposit;
    private UserDAO userDAO;

    @Autowired
    public BankCore(AccountCreationService accountCreation, AccountListingService accountListingService, TransactionDAO transactionDAO, AccountDeletionService accountDeletionService, AccountDAO accountDAO, TransactionWithdraw transactionWithdraw, TransactionDeposit transactionDeposit, UserDAO userDAO) {
        this.accountCreation = accountCreation;
        this.accountListingService = accountListingService;
        this.transactionDAO = transactionDAO;
        this.accountDeletionService = accountDeletionService;
        this.accountDAO = accountDAO;
        this.transactionWithdraw = transactionWithdraw;
        this.transactionDeposit = transactionDeposit;
        this.userDAO = userDAO;
    }

    private int getUserId(String username) {
        Optional<User> user = userDAO.findUserByUsername(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("user" + username + " is not found");
        return user.get().getId();
    }

    public String createNewAccount(String accountType, String username) {
        int userId = getUserId(username);
        System.out.println(accountType);
        switch (accountType) {
            case "SAVING":
                this.incrementLastAccountNumber();
                return accountCreation.create(AccountType.SAVING, id, userId, lastAccountNumber);
            case "CHECKING":
                this.incrementLastAccountNumber();
                return accountCreation.create(AccountType.CHECKING, id, userId, lastAccountNumber);
            case "FIXED":
                this.incrementLastAccountNumber();
                return accountCreation.create(AccountType.FIXED, id, userId, lastAccountNumber);
            default:
                return "Wrong account type!";
        }
    }

    public Account getClientAccount(String username, String accountID) {
        int id = getUserId(username);
        return accountListingService.getClientAccount(id, accountID);
    }
    public Account getClientWithdrawAccount(int clientID, String accountID) {
        return accountListingService.getClientWithdrawAccount(clientID, accountID);
    }
    public List<Account> getClientAccounts(String username) {
        int id = getUserId(username);
        return accountListingService.getClientAccounts(id);
    }

    public List<Transaction> getTransactions(int accountID, String username) {
        int id = getUserId(username);
        Optional<Account> account = accountDAO.findById(accountID);
        if (account.isPresent())
            return transactionDAO.findTransactionsByAccountIdAndClientId(account.get(), id);
        return null;
    }

    public String deleteAccount(int accountID, String username) {
        int id = getUserId(username);
        Optional<Account>  account = accountDAO.findAccountByIdAndClientId(accountID, id);
        if (account.isPresent()) {
            return accountDeletionService.deleteAccount(accountID);
        }
        else return "There is no such account";
    }

    public String withdraw(String accountID, double amount, String username) {
        int id = getUserId(username);
        Account account = accountDAO.findAccountByClientIdAndAccountId(id, accountID);
        return transactionWithdraw.execute(amount, account);
    }

    public String deposit(String accountID, double amount, String username) {
        int id = getUserId(username);
        Account account = accountDAO.findAccountByClientIdAndAccountId(id, accountID);
        return transactionDeposit.execute(amount, account);
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
