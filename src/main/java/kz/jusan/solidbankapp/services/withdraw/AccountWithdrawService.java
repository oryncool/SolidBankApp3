package kz.jusan.solidbankapp.services.withdraw;

import kz.jusan.solidbankapp.account.Account;

public interface AccountWithdrawService {

    String withdraw (double amount, Account account);
}
