package au.com.maxcheung.simplecab.service;

import java.util.Date;

public interface SimpleCabRepository {

    Integer getCountByMedallionAndPickupDatetime(String medallionId, Date pickupDate);

    void resetAllEntries();

}
