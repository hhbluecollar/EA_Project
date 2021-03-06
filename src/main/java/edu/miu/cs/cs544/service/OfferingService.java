package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.repository.OfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferingService {
    @Autowired
    private OfferingRepository offeringRepository;


    public Offering getOffer( int id) {
        return offeringRepository.findById(id).get();
    }

    public List<Offering> getOfferings() {
        return offeringRepository.findAll();
    }

    public Offering addOffering(Offering offering) {
        return offeringRepository.save(offering);
    }

    public void deleteOffering(int id) {
        Optional<Offering> deleteOffering = offeringRepository.findById(id);
        offeringRepository.delete(deleteOffering.get());

    }

    public void editOffering(Offering offering) {
        offeringRepository.save(offering);
    }

}
