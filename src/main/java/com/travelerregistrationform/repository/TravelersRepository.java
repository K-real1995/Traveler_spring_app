package com.travelerregistrationform.repository;

import com.travelerregistrationform.model.TravelersModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TravelersRepository extends JpaRepository<TravelersModel, Integer> {
}
