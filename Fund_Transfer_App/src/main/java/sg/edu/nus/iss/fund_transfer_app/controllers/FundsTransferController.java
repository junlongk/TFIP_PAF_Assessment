package sg.edu.nus.iss.fund_transfer_app.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.edu.nus.iss.fund_transfer_app.exception.TransferException;
import sg.edu.nus.iss.fund_transfer_app.models.Account;
import sg.edu.nus.iss.fund_transfer_app.models.Transfer;
import sg.edu.nus.iss.fund_transfer_app.services.FundsTransferService;
import sg.edu.nus.iss.fund_transfer_app.services.LogAuditService;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class FundsTransferController {

    private final Logger logger = Logger.getLogger(FundsTransferController.class.getName());

    @Autowired
    private FundsTransferService fundsTransferSvc;

    @Autowired
    private LogAuditService logAuditSvc;

    @GetMapping(path = {"/", "/index.html"})
    public String getForm(Model model) {
        List<Account> accounts = fundsTransferSvc.getAllAccounts();
        model.addAttribute("accounts", accounts);
        model.addAttribute("transfer", new Transfer());
        return "index";
    }

    @PostMapping(path = "/transfer")
    public String postTransfer(@Valid Transfer transfer,
                               BindingResult bindingResult,
                               Model model) throws TransferException {

        System.out.printf("Account from: %s\n".formatted(transfer.getAccountFromId()));
        System.out.printf("Account to: %s\n".formatted(transfer.getAccountToId()));
        System.out.printf("Amount: %f\n".formatted(transfer.getAmount()));
        System.out.printf("Comments: %s\n".formatted(transfer.getComments()));

        // C0 check - both accounts should exist
        if (!fundsTransferSvc.c0Check(transfer.getAccountFromId(),
                transfer.getAccountToId()))
            bindingResult.addError(new ObjectError("globalError",
                    "C0 - Both accounts must exist"));

        // C1 check - length of account id should be 10 chars
        if (!fundsTransferSvc.c1Check(transfer.getAccountFromId(),
                transfer.getAccountToId()))
            bindingResult.addError(new ObjectError("globalError",
                    "C1 - Length of account id is not 10 characters"));

        // C2 check - From account should not be the same as to account
        if (!fundsTransferSvc.c2Check(transfer.getAccountFromId(),
                transfer.getAccountToId()))
            bindingResult.addError(new ObjectError("globalError",
                    "C2 - Both account id is the same"));

        // C3 check - Transfer amount is not 0 or negative number
        if (!fundsTransferSvc.c3Check(transfer.getAmount()))
            bindingResult.addError(new ObjectError("globalError",
                    "C3 - Transfer amount must not be 0 or negative number"));

        // C4 check - Minimum transfer amount is $10
        if (!fundsTransferSvc.c4Check(transfer.getAmount()))
            bindingResult.addError(new ObjectError("globalError",
                    "C4 - Minimum transfer amount is $10"));

        // C5 check - The from account should have sufficient funds
        if (!fundsTransferSvc.c5Check(transfer.getAccountFromId(),
                transfer.getAmount()))
            bindingResult.addError(new ObjectError("globalError",
                    "C5 - Insufficient funds to perform the transfer"));

        if (bindingResult.hasErrors()) {
            model.addAttribute("transfer", transfer);
            return "index";
        }

        Transfer success = fundsTransferSvc.performTransfer(transfer);
        logAuditSvc.logTransaction(success);

        return "transfer";
    }
}
