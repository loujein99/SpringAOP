package com.esprit.examen.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FournisseurServiceImplMockitoTest {
	 @Mock
	 FournisseurRepository fournisseurRepository;
	 @InjectMocks
	    FournisseurServiceImpl fournisseurService;
	    CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
	    Fournisseur f=(Fournisseur.builder().code("203JMT4945").libelle("Firaskh").categorieFournisseur(cat).build());
	      List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>() {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
	            add(Fournisseur.builder().code("192JMT1717").libelle("Ahlem").categorieFournisseur(cat).build());
	            add(Fournisseur.builder().code("100JMT0912").libelle("kahia").categorieFournisseur(cat).build());
	        }
	    };
	    
	    @Test
	    public void FindAllFournisseurs(){
	        Mockito.when(fournisseurRepository.findAll()).thenReturn(listFournisseur);
	        List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
	        Assertions.assertNotNull(listFournisseurs);
}
	    @Test
	    public void testAddFournisseur() {
	        Mockito.when(fournisseurRepository.save(f)).thenReturn(f);
	        Fournisseur f1 = fournisseurService.addFournisseur(f);
	        Assertions.assertNotNull(f1);
	    }
}
