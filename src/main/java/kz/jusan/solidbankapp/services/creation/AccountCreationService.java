package kz.jusan.solidbankapp.services.creation;

import kz.jusan.solidbankapp.account.AccountType;

public interface AccountCreationService {
    String create(AccountType accountType, long BankID, int clientID, long AccountId);
}
