package sg.edu.nus.iss.fund_transfer_app.models;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Transfer implements Serializable {

    public static final long serialVersionUID = 1L;
    private String transactionId;

//    @NotNull(message = "Please specify an account to transfer to!")
//    @Size(min = 10, max = 10)
    private String accountToId;

//    @NotNull(message = "Please specify an account to transfer from!")
//    @Size(min = 10, max = 10)
    private String accountFromId;

    private float accountFromBalance;

//    @NotNull
//    @DecimalMin(value = "2", message = "Must be 2 decimals")
//    @Min(value = 10, message = "Minimum transfer amount is $10")
    private float amount;

    private String comments;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(String accountToId) {
        this.accountToId = accountToId;
    }

    public String getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(String accountFromId) {
        this.accountFromId = accountFromId;
    }

    public float getAccountFromBalance() {
        return accountFromBalance;
    }

    public void setAccountFromBalance(float accountFromBalance) {
        this.accountFromBalance = accountFromBalance;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Transfer{transactionId='%s', accountToId='%s', accountFromId='%s', accountFromBalance=%s, amount=%s, comments='%s'}"
                .formatted(transactionId, accountToId, accountFromId, accountFromBalance, amount, comments);
    }
}
