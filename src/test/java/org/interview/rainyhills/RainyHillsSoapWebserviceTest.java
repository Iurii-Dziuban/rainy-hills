package org.interview.rainyhills;

import org.interview.rainyhills.service.RainyHillsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RainyHillsSoapWebserviceTest {

    @Mock
    private RainyHillsService service;

    @InjectMocks
    private RainyHillsSoapWebservice rainyHillsSoapWebservice;

    @Test
    public void shouldInvokeService() {
        rainyHillsSoapWebservice.findWaterVolume(new int[]{});

        BDDMockito.then(service).should().findWaterVolume(new int[]{});
    }
}
