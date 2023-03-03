package sg.edu.nus.iss.fund_transfer_app.utils;

import jakarta.json.Json;
import sg.edu.nus.iss.fund_transfer_app.models.Account;
import sg.edu.nus.iss.fund_transfer_app.models.Transfer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    // Create identifier for view 0
    public static String createIdentifier(Account account) {
        return "%s (%s)".formatted(account.getName(), account.getAccountId());
    }

    public static String transferToStr(Transfer transfer) {
        SimpleDateFormat formatter = new SimpleDateFormat();
        Date date = new Date();

        return Json.createObjectBuilder()
                .add("transactionId", transfer.getTransactionId())
                .add("date", formatter.format(date))
                .add("from_account", transfer.getAccountFromId())
                .add("to_account", transfer.getAccountToId())
                .add("amount", transfer.getAmount())
                .build()
                .toString();
    }
}
