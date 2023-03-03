package sg.edu.nus.iss.fund_transfer_app.repositories;

public class Queries {
    public static final String SQL_GET_ALL_ACCOUNTS = """
            select * from accounts
            """;

    public static final String SQL_GET_ACCOUNT_BY_ID = """
            select * from accounts where account_id = ?
            """;

    public static final String SQL_GET_ACCOUNT_BALANCE = """
            select balance from accounts where account_id = ?
            """;

    public static final String SQL_WITHDRAW_FROM_ACCOUNT = """
            update accounts set balance = balance - ? where account_id = ?
            """;

    public static final String SQL_DEPOSIT_INTO_ACCOUNT = """
            update accounts set balance = balance + ? where account_id = ?
            """;
}
