package sg.edu.nus.iss.fund_transfer_app.models;

public class Account {
    private String name;
    private String accountId;
    private float balance;

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

    @Override
    public String toString() {
        return "Account{name='%s', accountId='%s', balance=%s}".formatted(name, accountId, balance);
    }
}
