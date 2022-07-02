package com.travelerregistrationform.service;

import com.travelerregistrationform.model.TravelersModel;
import com.travelerregistrationform.repository.TravelersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelersService {
    @Autowired
    private final TravelersRepository travelersRepository;

    public TravelersService(TravelersRepository travelersRepository) {
        this.travelersRepository = travelersRepository;
    }

    public TravelersModel registerTraveler(String name, String email, Integer phone, String place){
        if ((name == null || place == null || email == null) && phone == null) {
            return null;
        } else {
            TravelersModel travelersModel = new TravelersModel();
            travelersModel.setName(name);
            travelersModel.setEmail(email);
            travelersModel.setPhone(phone);
            travelersModel.setPlace(place);

            return travelersRepository.save(travelersModel);
        }
    }
}
