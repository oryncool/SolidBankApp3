package kz.jusan.solidbankapp.account;

import jakarta.persistence.*;
import kz.jusan.solidbankapp.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "account")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "account_type")
    private AccountType accountType;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "balance")
    private double balance;
    @Column(name = "withdraw_allowed")
    private boolean withdrawAllowed;

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", id='" + accountId + '\'' +
                ", clientID='" + clientId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
