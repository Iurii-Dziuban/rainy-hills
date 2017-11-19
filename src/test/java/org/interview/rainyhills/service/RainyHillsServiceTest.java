package org.interview.rainyhills.service;

import org.interview.rainyhills.ejb.RainyHillsEjb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RainyHillsServiceTest {

    @Mock
    private RainyHillsEjb rainyHillsEjb;

    @InjectMocks
    private RainyHillsService rainyHillsService;

    @Test
    public void shouldInvokeEjb() {
        rainyHillsService.findWaterVolume(new int[]{});

        BDDMockito.then(rainyHillsEjb).should().findWaterVolume(new int[]{});
    }
}
