package tn.esprit.tpfoyer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class BlocServiceImplTestCase {
    @Mock
    BlocRepository blocRepository;

    @InjectMocks
    BlocServiceImpl blocService;

    @Test
    void testRetrieveBloc() {
        // Création d’un bloc simulé
        Bloc bloc = new Bloc(1L, "Bloc A", 50, null, null);

        // Simulation du comportement du repository
        Mockito.when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Appel de la méthode du service à tester
        Bloc retrievedBloc = blocService.retrieveBloc(1L);

        // Vérification des résultats
        assertNotNull(retrievedBloc, "Le bloc ne doit pas être null");
        assertEquals("Bloc A", retrievedBloc.getNomBloc(), "Le nom du bloc doit être 'Bloc A'");
        assertEquals(50, retrievedBloc.getCapaciteBloc(), "La capacité du bloc doit être 50");
    }
}