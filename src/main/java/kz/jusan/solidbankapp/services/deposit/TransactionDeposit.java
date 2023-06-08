package kz.jusan.solidbankapp.services.deposit;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.transaction.TransactionType;
import kz.jusan.solidbankapp.dao.TransactionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public String execute (double amount, Account account) {
        if (account == null) return "wrong account id!";
        if (amount <= 0) return "incorrect amount of money";
        Transaction transaction = new Transaction(null, TransactionType.DEPOSIT, amount, account, account.getClientId());
        transactionDAO.save(transaction);
        return accountDepositService.deposit(amount, account);
    }
}
