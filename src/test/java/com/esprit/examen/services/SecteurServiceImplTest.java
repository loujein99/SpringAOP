package com.esprit.examen.services;


import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.SecteurActivite;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest

public class SecteurServiceImplTest {
    @Autowired
    ISecteurActiviteService secteurImpl;

    @Test
    @Order(1)
    public void testSaveSecateurs(){
        SecteurActivite s= secteurImpl.addSecteurActivite(SecteurActivite.builder().codeSecteurActivite("22b").libelleSecteurActivite("secteur test").build());
        Assertions.assertNotNull(s);
    }


    /*@Test
    @Order(2)
	public void testUpdateSecteur() {
    	  SecteurActivite s= secteurImpl.addSecteurActivite(SecteurActivite.builder().codeSecteurActivite("22bcc").libelleSecteurActivite("secteur test").build());
    	  s.setLibelleSecteurActivite("secteur aicha");
	      Assertions.assertEquals(5,secteurImpl.updateSecteurActivite(s).getLibelleSecteurActivite());
	    }*/


}
