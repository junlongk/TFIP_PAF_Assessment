package sg.edu.nus.iss.fund_transfer_app.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import sg.edu.nus.iss.fund_transfer_app.models.Account;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static sg.edu.nus.iss.fund_transfer_app.repositories.Queries.*;

@Repository
public class AccountsRepository {

    private final Logger logger = Logger.getLogger(AccountsRepository.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get list of all accounts
    public List<Account> getAllAccounts() {
        List<Account> result;
        result = jdbcTemplate.query(SQL_GET_ALL_ACCOUNTS,
                BeanPropertyRowMapper.newInstance(Account.class));
        return result;
    }

    // Check if account exists via accountId
    public boolean checkAccountExists(String accountId) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_ACCOUNT_BY_ID, accountId);

        return rs.next();
    }

    // Check account balance via accountId
    public Optional<Float> getAccountBalance(String accountId) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_ACCOUNT_BALANCE, accountId);

        return Optional.ofNullable(
                rs.next() ? rs.getFloat("balance") : null);
    }

    // Withdraw from account
    public boolean withdraw(float amount, String accountId) {
       int updated = jdbcTemplate.update(SQL_WITHDRAW_FROM_ACCOUNT, new PreparedStatementSetter() {
                   @Override
                   public void setValues(PreparedStatement ps) throws SQLException {
                       ps.setFloat(1, amount);
                       ps.setString(2, accountId);
                   }
               });
        System.out.printf("Withdraw done!");
       return updated > 0;
    }

    // Deposit into account
    public boolean deposit(float amount, String accountId) {
        int updated = jdbcTemplate.update(SQL_DEPOSIT_INTO_ACCOUNT, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setFloat(1, amount);
                ps.setString(2, accountId);
            }
        });
        System.out.printf("Deposit done!");
        return updated > 0;
    }
}
