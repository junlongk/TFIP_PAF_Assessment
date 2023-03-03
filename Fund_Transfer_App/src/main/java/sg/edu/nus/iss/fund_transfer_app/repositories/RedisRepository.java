package sg.edu.nus.iss.fund_transfer_app.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import sg.edu.nus.iss.fund_transfer_app.models.Transfer;
import sg.edu.nus.iss.fund_transfer_app.utils.Util;

@Repository
public class RedisRepository {

    @Autowired
    @Qualifier("transfers")
    private RedisTemplate<String, String> redisTemplate;

    public void saveTransfer(Transfer transfer) {
        redisTemplate.opsForValue().set(transfer.getTransactionId(),
                Util.transferToStr(transfer));
    }
}
