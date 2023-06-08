package kz.jusan.solidbankapp.transaction;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransactionType {
    WITHDRAW("WITHDRAW"),
    DEPOSIT("DEPOSIT");
    private String transactionType;

    @Override
    public String toString() {
        return transactionType;
    }
}
