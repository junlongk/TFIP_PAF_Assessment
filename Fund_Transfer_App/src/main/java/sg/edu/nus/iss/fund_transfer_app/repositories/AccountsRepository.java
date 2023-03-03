package sg.edu.nus.iss.fund_transfer_app.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sg.edu.nus.iss.fund_transfer_app.models.Account;

import java.util.List;
import java.util.logging.Logger;

import static sg.edu.nus.iss.fund_transfer_app.repositories.Queries.SQL_GET_ALL_ACCOUNTS;

@Repository
public class AccountsRepository {

    private final Logger logger = Logger.getLogger(AccountsRepository.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired @Qualifier("transfers")
    private RedisTemplate<String, String> redisTemplate;

    // Get list of all accounts
    public List<Account> getAllAccounts() {
        List<Account> result;
        result = jdbcTemplate.query(SQL_GET_ALL_ACCOUNTS,
                BeanPropertyRowMapper.newInstance(Account.class));
        return result;
    }
}
