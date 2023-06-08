package kz.jusan.solidbankapp.services.deposit;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDAO accountDAO;

    @Override
    public String deposit (double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
        accountDAO.save(account);
        String ans =  amount + "$ were successfully deposited to your account";
        return ans;
    }
}
