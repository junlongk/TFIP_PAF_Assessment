# Create database -> acme_bank
CREATE DATABASE IF NOT EXISTS acme_bank;

# Use database -> acme_bank
USE acme_bank;

# Create table -> accounts
CREATE TABLE accounts (
    account_id VARCHAR(10) NOT NULL,
    name VARCHAR(20) NOT NULL,
    balance DECIMAL(6,2) NOT NULL,
    PRIMARY KEY (account_id)
);

# Populate accounts table with data from data.csv
INSERT INTO accounts (account_id, name, balance) VALUES ('V9L3Jd1BBI', 'fred', 100.00);
INSERT INTO accounts (account_id, name, balance) VALUES ('fhRq46Y6vB', 'barney', 300.00);
INSERT INTO accounts (account_id, name, balance) VALUES ('uFSFRqUpJy', 'wilma', 1000.00);
INSERT INTO accounts (account_id, name, balance) VALUES ('ckTV56axff', 'betty', 1000.00);
INSERT INTO accounts (account_id, name, balance) VALUES ('Qgcnwbshbh', 'pebbles', 50.00);
INSERT INTO accounts (account_id, name, balance) VALUES ('if9l185l18', 'bambam', 50.00);