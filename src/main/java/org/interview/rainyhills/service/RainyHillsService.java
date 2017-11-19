package org.interview.rainyhills.service;

import org.interview.rainyhills.contract.RainyHillsContract;
import org.interview.rainyhills.contract.RainyHillsServiceContract;

import javax.ejb.EJB;

/**
 * Service layer
 */
public class RainyHillsService implements RainyHillsServiceContract {

    @EJB
    private RainyHillsContract rainyHillsEjb;

    @Override
    public long findWaterVolume(int[] hills) {
        return rainyHillsEjb.findWaterVolume(hills);
    }
}
