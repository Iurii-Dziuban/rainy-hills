package org.interview.rainyhills;

import org.interview.rainyhills.contract.RainyHillsServiceContract;
import org.interview.rainyhills.contract.RainyHillsSoapWebserviceContract;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class RainyHillsSoapWebservice implements RainyHillsSoapWebserviceContract {

    @Inject
    private RainyHillsServiceContract rainyHillsService;

    @WebMethod
    @Override
    public String findWaterVolume(int[] hills) {
        return " " + rainyHillsService.findWaterVolume(hills);
    }
}