package softuni.winelovers.service.services.implementations;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import softuni.winelovers.service.services.HashingService;

@Service
public class HashingServiceImpl implements HashingService {

    @Override
    public String hash(String str) {
        return DigestUtils.md2Hex(str);
    }
}
