package au.com.maxcheung.simplecab.repository;

import java.util.Date;

public interface SimpleCabRepository {

    Integer getCountByMedallionAndPickupDatetime(String medallionId, Date pickupDate);

    void clearCache();

    Integer loadCSV(String filepath);

    void clearCabTripData();

}
