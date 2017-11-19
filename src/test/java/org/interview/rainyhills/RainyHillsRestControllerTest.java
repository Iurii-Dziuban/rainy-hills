package org.interview.rainyhills;

import org.interview.rainyhills.service.RainyHillsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class RainyHillsRestControllerTest {

    @Mock
    private RainyHillsService service;

    @InjectMocks
    private RainyHillsRestController rainyHillsRestController;

    @Test
    public void shouldInvokeService() {
        rainyHillsRestController.getVolume(new ArrayList<Integer>());

        BDDMockito.then(service).should().findWaterVolume(new int[]{});
    }
}
