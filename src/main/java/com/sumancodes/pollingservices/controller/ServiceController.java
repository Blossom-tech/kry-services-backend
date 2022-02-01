package com.sumancodes.pollingservices.controller;

import com.sumancodes.pollingservices.model.Service;
import com.sumancodes.pollingservices.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServiceImpl serviceImpl;

    @PostMapping("/add")
    public String add(@RequestBody Service service) {
        serviceImpl.save(service);
        return "New Service is added";
    }

    @GetMapping("/getAll")
    public List<Service> list(){
        return serviceImpl.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> get(@PathVariable Integer id) {
        try {
            Service service=serviceImpl.get(id);
            return new ResponseEntity<Service>(service,HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> update(@RequestBody Service service,@PathVariable Integer id){
        try{
            Service existingService=serviceImpl.get(id);
            serviceImpl.save(service);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        serviceImpl.delete(id);
        return "Deleted Service with id "+id;
    }



}
