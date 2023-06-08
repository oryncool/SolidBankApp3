CREATE TABLE Account
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    account_id       NVARCHAR(10) NOT NULL,
    client_id        INTEGER NOT NULL,
    account_type     NVARCHAR(10) NOT NULL,
    balance          DOUBLE  NOT NULL,
    withdraw_allowed BOOLEAN NOT NULL
);