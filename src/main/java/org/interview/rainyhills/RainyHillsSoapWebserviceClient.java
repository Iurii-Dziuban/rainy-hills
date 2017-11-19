package org.interview.rainyhills;

import org.interview.rainyhills.contract.RainyHillsSoapWebserviceContract;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Arrays;

public class RainyHillsSoapWebserviceClient {

    public static void main(String[] args) {
        String endPointAddress = "http://localhost:8080/rainy-hills/RainyHillsSoapWebservice";
        QName serviceName = new QName("http://rainyhills.interview.crxmarkets.org/", "RainyHillsSoapWebserviceService");

        try {
            URL wsdlURL = new URL(endPointAddress + "?wsdl");
            Service service = Service.create(wsdlURL, serviceName);
            RainyHillsSoapWebserviceContract proxy = service.getPort(RainyHillsSoapWebserviceContract.class);
            int[] hills = {2, 1, 0, 3};
            System.out.println("Calculating water volume for " + Arrays.toString(hills));
            System.out.println("Volume is " + proxy.findWaterVolume(hills));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
