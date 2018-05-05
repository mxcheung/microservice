package au.com.maxcheung.simplecab.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import au.com.maxcheung.simplecab.service.SimpleCabRepository;
import au.com.maxcheung.simplecab.service.SimpleCabService;
import au.com.maxcheung.simplecab.service.SimpleCabServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SimpleCabServiceTest {

    private SimpleCabService simpleCabService;

    @Mock
    private SimpleCabRepository simpleCabRepository;

    @Before
    public void setup() {
        simpleCabService = new SimpleCabServiceImpl(simpleCabRepository);
    }

    @Test
    public void shouldReturnCount() {
        Date pickupDate = java.sql.Date.valueOf(LocalDate.of(2013, 12, 01));
        String medallionId = "D7D598CD99978BD012A87A76A7C891B7";
        when(simpleCabRepository.getCountByMedallionAndPickupDatetime(medallionId, pickupDate)).thenReturn(3);
        Integer count = simpleCabService.getCountByMedallionAndPickupDatetime(medallionId, pickupDate);
        assertEquals(3, count.intValue());
        verify(simpleCabRepository, times(1)).getCountByMedallionAndPickupDatetime(medallionId, pickupDate);
        verifyNoMoreInteractions(simpleCabRepository);
    }

    @Test
    public void shouldResetAllEntries() {
        simpleCabService.resetAllEntries();
        verify(simpleCabRepository, times(1)).resetAllEntries();
        verifyNoMoreInteractions(simpleCabRepository);
    }

}
