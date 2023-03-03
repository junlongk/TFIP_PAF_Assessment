package sg.edu.nus.iss.fund_transfer_app.utils;

import sg.edu.nus.iss.fund_transfer_app.models.Account;

public class Converter {

    // Account object to String containing name & accountId
    public static String accountToStr(Account account) {
        return "%s (%s)".formatted(account.getName(), account.getAccountId());
    }
}
