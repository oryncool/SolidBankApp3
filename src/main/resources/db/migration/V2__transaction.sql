CREATE TABLE Transaction
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    transaction_type NVARCHAR(10) NOT NULL,
    amount           double NOT NULL,
    account_id       INTEGER NOT NULL,
    client_id        int NOT NULL
);