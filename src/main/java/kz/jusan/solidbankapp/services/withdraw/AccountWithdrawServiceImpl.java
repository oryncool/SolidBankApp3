package kz.jusan.solidbankapp.services.withdraw;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {

    private AccountDAO accountDAO;

    @Override
    public String withdraw(double amount, Account account) {
        account.setBalance(account.getBalance() - amount);
        accountDAO.save(account);
        String ans = amount + "$ were successfully withdrawn from account";
        return ans;
    }
}
