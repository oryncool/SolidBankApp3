package kz.jusan.solidbankapp.transaction;

import jakarta.persistence.*;
import kz.jusan.solidbankapp.account.Account;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="transaction")
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "transaction_type")
    private TransactionType transactionType;
    @Column(name = "amount")
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account accountId;
    @Column(name = "client_id")
    private int clientId;
}
