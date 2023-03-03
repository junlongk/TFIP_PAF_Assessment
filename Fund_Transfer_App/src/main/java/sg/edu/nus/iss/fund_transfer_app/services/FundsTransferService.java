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
}
