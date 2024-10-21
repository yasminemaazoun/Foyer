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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BlocServiceImplMock {

    @Mock
    BlocRepository blocRepository;

    @InjectMocks
    BlocServiceImpl blocService;

    @Test
    void testRetrieveBloc() {
        // Arrange
        Bloc bloc = new Bloc();  // Créer un bloc pour le test
        bloc.setIdBloc(1L);
        Mockito.when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Act
        Bloc foundBloc = blocService.retrieveBloc(1L);

        // Assert
        assertNotNull(foundBloc);
        assertEquals(1L, foundBloc.getIdBloc());
        Mockito.verify(blocRepository, Mockito.times(1)).findById(1L); // Vérifier que la méthode findById a bien été appelée
    }
}
