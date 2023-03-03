package sg.edu.nus.iss.fund_transfer_app.models;

import java.math.BigDecimal;

public class Account {
    private String name;
    private String accountId;
    private float balance;
    private String identifier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Account{name='%s', accountId='%s', balance=%s, identifier='%s'}"
                .formatted(name, accountId, balance, identifier);
    }
}
