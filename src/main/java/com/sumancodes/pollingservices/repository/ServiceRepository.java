package com.sumancodes.pollingservices.repository;
import com.sumancodes.pollingservices.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {

}
