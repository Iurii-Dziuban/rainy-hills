package org.interview.rainyhills.contract;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface RainyHillsSoapWebserviceContract {
    String findWaterVolume(int[] hills);
}