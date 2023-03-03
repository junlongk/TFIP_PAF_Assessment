package sg.edu.nus.iss.fund_transfer_app.utils;

import sg.edu.nus.iss.fund_transfer_app.models.Account;

public class Util {

    // Create identifier for view 0
    public static String createIdentifier(Account account) {
        return "%s (%s)".formatted(account.getName(), account.getAccountId());
    }
}
