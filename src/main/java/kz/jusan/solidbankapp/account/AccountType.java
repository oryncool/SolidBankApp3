package kz.jusan.solidbankapp.account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountType {
    CHECKING("CHECKING"),
    SAVING("SAVING"),
    FIXED("FIXED");

    private final String accountType;

    public boolean isWithdrawAllowed() {
        return this != FIXED;
    }

    @Override
    public String toString() {
        return accountType;
    }


}
