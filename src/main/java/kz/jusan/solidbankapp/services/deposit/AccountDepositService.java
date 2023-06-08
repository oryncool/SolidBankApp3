package kz.jusan.solidbankapp.services.deposit;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountWithdraw;

public interface AccountDepositService {
    String deposit(double amount, Account account);
}
