package tn.esprit.tpfoyer.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    UniversiteRepository universiteRepository;

    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    public Universite retrieveUniversite(Long universiteId) {
        Optional<Universite> optionalUniversite = universiteRepository.findById(universiteId);
        if (optionalUniversite.isPresent()) {
            return optionalUniversite.get();
        } else {
            // Handle the case where Universite is not found
            throw new EntityNotFoundException("Universite not found with ID: " + universiteId);
        }
    }


    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
    }
}
