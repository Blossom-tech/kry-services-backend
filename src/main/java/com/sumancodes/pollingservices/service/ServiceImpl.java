package com.sumancodes.pollingservices.service;

import com.sumancodes.pollingservices.model.Service;
import com.sumancodes.pollingservices.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl {

    @Autowired
    private ServiceRepository serviceRepository;

    public void save(Service service){
        serviceRepository.save(service);
    }

    public List<Service> listAll() {
        List<Service> serviceObj = serviceRepository.findAll();
        List<Service> serviceRes = new ArrayList<Service>();
        for (Service obj: serviceObj) {
            if(getStatus(obj.getUrl()) == 200) {
                obj.setStatus("OK");
            } else {
                obj.setStatus("FAIL");
            }
            serviceRes.add(obj);
            System.out.println(getStatus(obj.getUrl()));
        }
        return serviceRes;
    }
    public Integer getStatus(String apiAdress) {
        int code = 0;
        try {
            URL url = new URL(apiAdress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            code = connection.getResponseCode();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return code;
    }

    public Service get(Integer id) {
        return serviceRepository.findById(id).get();
    }

    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }


}
