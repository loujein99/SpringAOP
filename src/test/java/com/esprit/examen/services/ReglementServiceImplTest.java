package com.esprit.examen.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class ReglementServiceImplTest {
    @Mock
    SecteurActiviteRepository activiteRepository;

    @InjectMocks
    SecteurActiviteServiceImpl activiteServiceImpl;

    SecteurActivite secteurActivite = new SecteurActivite(1L,"pc" , "moez" ,null );
    SecteurActivite secteurActivite1 = new SecteurActivite(1L,"pc1" , "moez1" ,null );
    SecteurActivite secteurActivite2 = new SecteurActivite(1L,"pc2" , "moez2" ,null );
    ArrayList<SecteurActivite> list = new ArrayList<SecteurActivite>() {
        {
            add(secteurActivite1);
            add(secteurActivite2);
        }
    };



    @Test
    void retrieveSecteurTest() {
        Mockito.when(activiteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteurActivite));
        SecteurActivite sec1 = activiteServiceImpl.retrieveSecteurActivite(1L);
        Assertions.assertNotNull(sec1);
        log.info("Retrieve secteur marche !");
        verify(activiteRepository).findById(Mockito.anyLong());

    }

    @Test
    void createSecteurTest(){
        activiteServiceImpl.addSecteurActivite(secteurActivite);
        log.info("Add secteur marche");
        verify(activiteRepository, times(1)).save(secteurActivite);

    }

    @Test
    void updateSecteurTest(){



        when(activiteRepository.save(secteurActivite)).thenReturn(secteurActivite);
        assertNotNull(secteurActivite);
        assertEquals(secteurActivite, activiteServiceImpl.updateSecteurActivite(secteurActivite));
        log.info("Update secteur marche !");

    }
    @Test
    void deleteSecteurTest(){
        activiteServiceImpl.deleteSecteurActivite(
                secteurActivite2.getIdSecteurActivite());
        Assertions.assertNotNull(list);
        log.info("delete secteur marche !");


    }

}
