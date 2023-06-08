package kz.jusan.solidbankapp.services.withdraw;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.dao.AccountDAO;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.transaction.TransactionType;
import kz.jusan.solidbankapp.dao.TransactionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;
    public String execute(double amount, Account account) {
        if (account == null) return "wrong account id!";
        if (!account.isWithdrawAllowed()) return "this is a fixed account, withdraw is forbidden";
        if (amount <= 0) return "incorrect amount of money";
        if (account.getBalance() < amount) {
            return "Current balance of account is less than required for withdraw";
        }
        Transaction transaction = new Transaction(null, TransactionType.WITHDRAW, amount, account, account.getClientId());
        transactionDAO.save(transaction);
        return accountWithdrawService.withdraw(amount, account);
    }
}
