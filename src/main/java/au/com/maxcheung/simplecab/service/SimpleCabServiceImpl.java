package au.com.maxcheung.simplecab.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleCabServiceImpl implements SimpleCabService {

    private static final Logger log = LoggerFactory.getLogger(SimpleCabServiceImpl.class);


    private final SimpleCabRepository simpleCabRepository;
    
    
    @Autowired
    public SimpleCabServiceImpl(final SimpleCabRepository simpleCabRepository) {
        this.simpleCabRepository = simpleCabRepository;
    }

    public Integer getCountByMedallionAndPickupDatetime(String medallionId, Date pickupDate) {
        log.info("getCountByMedallionAndPickupDatetime medallionId : {} pickupDate : {} ", medallionId, pickupDate);
        return simpleCabRepository.getCountByMedallionAndPickupDatetime(medallionId, pickupDate);
    }

    @Override
    public Integer loadCSV(String filepath) {
        return simpleCabRepository.loadCSV(filepath);
    }

    
    @Override
    public void resetAllEntries() {
        simpleCabRepository.resetAllEntries();
    }


    @Override
    public Map<String, Integer> getCountByMedallionsAndPickupDatetime(List<String> medallionIds, Date pickupDate) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (String medallionId : medallionIds) {
            result.put(medallionId,  simpleCabRepository.getCountByMedallionAndPickupDatetime(medallionId, pickupDate));
        }
        return result;
    }

}
