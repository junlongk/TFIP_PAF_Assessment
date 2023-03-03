package sg.edu.nus.iss.fund_transfer_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.edu.nus.iss.fund_transfer_app.models.Account;
import sg.edu.nus.iss.fund_transfer_app.repositories.AccountsRepository;
import sg.edu.nus.iss.fund_transfer_app.utils.Util;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FundsTransferService {

    private final Logger logger = Logger.getLogger(FundsTransferService.class.getName());

    @Autowired
    private AccountsRepository accountsRepo;

    // Get list of all accounts
    public List<Account> getAllAccounts() {
        // Get list of accounts and create identifier for view 0
        List<Account> accountList = accountsRepo.getAllAccounts()
                .stream()
                .peek(acc -> {
                    String identifier = Util.createIdentifier(acc);
                    acc.setIdentifier(identifier);
                })
                .toList();

        for (Account a: accountList) {
            // logger.info("Accounts retrieved: %s".formatted(a));
            System.out.printf("Accounts retrieved: %s\n".formatted(a));
        }

        return accountList;
    }

    // C0 - Check if account exist
    public boolean c0Check (String accountFromId, String accountToId) {
        return accountsRepo.checkAccountExists(accountFromId) &&
                accountsRepo.checkAccountExists(accountToId);
    }

    // C1 - Check length of account id, should be 10 chars
    public boolean c1Check (String accountFromId, String accountToId) {
        if (accountFromId != null && accountToId != null)
            return accountFromId.length() == 10 && accountToId.length() == 10;
        else
            return false;
    }

    // C2 - From account should not be same as to account
    public boolean c2Check (String accountFromId, String accountToId) {
        if (accountFromId != null && accountToId != null)
            return !accountFromId.equals(accountToId);
        else
            return false;
    }

    // C3 - Transfer amount is not 0 or negative number
    public boolean c3Check (float amount) {
        return amount > 0;
    }

    // C4 - Minimum transfer amount is $10
    public boolean c4Check (float amount) {
        return amount >= 10;
    }

    // C5 - Check for sufficient funds on from account
    public boolean c5Check (String accountFromId, float amount) {
        float accountBalance = accountsRepo.getAccountBalance(accountFromId);
        return accountBalance - amount >= 0;
    }
}
