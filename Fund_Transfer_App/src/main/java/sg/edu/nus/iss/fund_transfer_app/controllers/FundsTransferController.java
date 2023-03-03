package sg.edu.nus.iss.fund_transfer_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sg.edu.nus.iss.fund_transfer_app.services.FundsTransferService;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class FundsTransferController {

    @Autowired
    private FundsTransferService fundsTransferSvc;

    private final Logger logger = Logger.getLogger(FundsTransferController.class.getName());

    @GetMapping(path = {"/", "/index.html"})
    public String getForm(Model model) {
        List<String> accounts = fundsTransferSvc.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return "index";
    }
}
