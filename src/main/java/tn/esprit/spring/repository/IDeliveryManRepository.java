package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.DeliveryMan;
@Repository
public interface IDeliveryManRepository extends CrudRepository<DeliveryMan, Long>{

}
