package tn.esprit.tpfoyer.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImpl implements IChambreService {

    ChambreRepository chambreRepository;

    public List<Chambre> retrieveAllChambres() {
        log.info("In Methodo retrieveAllChambres : ");
        List<Chambre> listC = chambreRepository.findAll();
        log.info("Out of retrieveAllChambres : ");

        return listC;
    }

    public Chambre retrieveChambre(Long chambreId) {
        Optional<Chambre> optionalChambre = chambreRepository.findById(chambreId);
        if (optionalChambre.isPresent()) {
            return optionalChambre.get();
        } else {
            throw new EntityNotFoundException("Chambre with id " + chambreId + " not found");
        }
    }


    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    public Chambre modifyChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }







    public List<Chambre> recupererChambresSelonTyp(TypeChambre tc)
    {
        return chambreRepository.findAllByTypeC(tc);
    }






















    public Chambre trouverchambreSelonEtudiant(long cin) {
       //

        return chambreRepository.trouverChselonEt(cin);
    }
}
