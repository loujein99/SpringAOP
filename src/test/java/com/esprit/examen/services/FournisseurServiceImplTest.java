package com.esprit.examen.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class FournisseurServiceImplTest {
	 @Autowired
	 IFournisseurService fournisseurService;
	 @Test
	 @Order(1)
	 public void testSaveFournisseur(){
	  CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
	  Fournisseur f= fournisseurService.addFournisseur(Fournisseur.builder().code("203JMT4945").libelle("Firaskh").categorieFournisseur(cat).build());
	  Assertions.assertNotNull(f);
	    }
	   @Test
	    @Order(2)
	   public void testRetrieveAllFournisseurs() {
	     int listFournisseurs = fournisseurService.retrieveAllFournisseurs().size();
	     CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
	     fournisseurService.addFournisseur(fournisseurService.addFournisseur(Fournisseur.builder().code("192JMT1717").libelle("Ahlem").categorieFournisseur(cat).build()));
	     Assertions.assertEquals(listFournisseurs+1, fournisseurService.retrieveAllFournisseurs().size());
	    }
	   @Test
	    @Order(3)
	    public void testUpdateFournisseur() {
	        CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
	        Fournisseur f= fournisseurService.addFournisseur(Fournisseur.builder().code("100JMT0912").libelle("Kahia").categorieFournisseur(cat).build());
	        f.setLibelle("KahiaSabri");
	        Assertions.assertEquals("KahiaSabri",fournisseurService.updateFournisseur(f).getLibelle());
	   }
}
