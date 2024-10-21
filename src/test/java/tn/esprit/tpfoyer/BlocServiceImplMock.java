package tn.esprit.tpfoyer;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class BlocServiceImplMock {
    @Mock
    BlocRepository blocRepository;

    @InjectMocks
    BlocServiceImpl blocService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testRetrieveAllBlocs() {
        // Arrange
        List<Bloc> blocs = new ArrayList<>();
        blocs.add(new Bloc(1, "Bloc A", 100, null, null));
        blocs.add(new Bloc(2, "Bloc B", 150, null, null));
        when(blocRepository.findAll()).thenReturn(blocs);

        // Act
        List<Bloc> result = blocService.retrieveAllBlocs();

        // Assert
        assertEquals(2, result.size());
        verify(blocRepository, times(1)).findAll();
    }

 

    @Test
    void testAddBloc() {
        // Arrange
        Bloc bloc = new Bloc(1, "Bloc C", 120, null, null);
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // Act
        Bloc result = blocService.addBloc(bloc);

        // Assert
        assertEquals("Bloc C", result.getNomBloc());
        verify(blocRepository, times(1)).save(bloc);
    }

    @Test
    void testRetrieveBloc() {
        // Arrange
        Bloc bloc = new Bloc(1, "Bloc D", 100, null, null);
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Act
        Bloc result = blocService.retrieveBloc(1L);

        // Assert
        assertEquals("Bloc D", result.getNomBloc());
        verify(blocRepository, times(1)).findById(1L);
    }

    @Test
    void testRemoveBloc() {
        // Act
        blocService.removeBloc(1L);

        // Assert
        verify(blocRepository, times(1)).deleteById(1L);
    }


}
