package sg.edu.nus.iss.fund_transfer_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.edu.nus.iss.fund_transfer_app.models.Transfer;
import sg.edu.nus.iss.fund_transfer_app.repositories.RedisRepository;

@Service
public class LogAuditService {

    @Autowired
    private RedisRepository redisRepo;

    public void logTransaction (Transfer transfer) {
        redisRepo.saveTransfer(transfer);
    }
}
