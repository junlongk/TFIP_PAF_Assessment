package sg.edu.nus.iss.fund_transfer_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.edu.nus.iss.fund_transfer_app.models.Account;
import sg.edu.nus.iss.fund_transfer_app.repositories.AccountsRepository;
import sg.edu.nus.iss.fund_transfer_app.utils.Converter;

import java.util.List;

@Service
public class FundsTransferService {

    @Autowired
    private AccountsRepository accountsRepo;

    // Get list of accounts for View 0
    public List<String> getAllAccounts() {
        List<Account> accountList = accountsRepo.getAllAccounts();
        return accountList.stream()
                .map(v -> Converter.accountToStr(v))
                .toList();
    }
}
