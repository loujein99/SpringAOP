package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
        import static org.junit.Assert.assertEquals;
        import static org.mockito.BDDMockito.given;
        import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ProduitServiceImplTest {





    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private CategorieProduitServiceImpl categorieProduitService;

    @Test
    @Rollback(value = false)
    public void whenSavecat_shouldReturnProduct(){
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setCodeCategorie("Test Code");
        when(categorieProduitRepository.save(ArgumentMatchers.any(CategorieProduit.class))).thenReturn(categorieProduit);
        CategorieProduit created = categorieProduitService.addCategorieProduit(categorieProduit);
        assertThat(created.getCodeCategorie()).isSameAs(categorieProduit.getCodeCategorie());
        verify(categorieProduitRepository).save(categorieProduit);
    }
    @Test
    @Rollback(value = false)
    public void shouldReturnAllProducts(){
        List<CategorieProduit> categorieProduitList = new ArrayList<>();
        categorieProduitList.add( new CategorieProduit());
        given(categorieProduitRepository.findAll()).willReturn(categorieProduitList);
        List<CategorieProduit> expected = categorieProduitService.retrieveAllCategorieProduits();
        assertEquals(expected, categorieProduitList);
        verify(categorieProduitRepository).findAll();
    }
    @Test
    @Rollback(value = false)
    public void whenGivenId_shouldDeleteProduct_ifFound(){
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setLibelleCategorie("Test Libelle");
        categorieProduit.setCodeCategorie("Test Code");

        when(categorieProduitRepository.findById(categorieProduit.getIdCategorieProduit())).thenReturn(Optional.of(categorieProduit));

        categorieProduitService.deleteCategorieProduit(categorieProduit.getIdCategorieProduit());
        verify(categorieProduitRepository).deleteById(categorieProduit.getIdCategorieProduit());
    }
    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_product_doesnt_exist(){
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(89L);
        categorieProduit.setLibelleCategorie("Test Libelle");
        categorieProduit.setCodeCategorie("Test Code");

        given(categorieProduitRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        categorieProduitService.deleteCategorieProduit(categorieProduit.getIdCategorieProduit());
    }
    @Test
    public void whenGivenId_shouldUpdateProduct_ifFound() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(89L);
        categorieProduit.setLibelleCategorie("Test Libelle");
        categorieProduit.setCodeCategorie("Test Code");

        CategorieProduit newCategorieProduit = new CategorieProduit();
        categorieProduit.setLibelleCategorie("New Test Libelle");

        categorieProduitService.updateCategorieProduit(newCategorieProduit);
        verify(categorieProduitRepository).save(newCategorieProduit);
    }
    @Test
    public void whenGivenId_shouldReturnProduct_ifFound() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(89L);
        categorieProduit.setLibelleCategorie("Test Libelle");
        categorieProduit.setCodeCategorie("Test Code");

        when(categorieProduitRepository.findById(categorieProduit.getIdCategorieProduit())).thenReturn(Optional.of(categorieProduit));

        CategorieProduit expected = categorieProduitService.retrieveCategorieProduit(categorieProduit.getIdCategorieProduit());

        assertThat(expected).isSameAs(categorieProduit);
        verify(categorieProduitRepository).findById(categorieProduit.getIdCategorieProduit());
    }
    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_Product_doesnt_exist() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(89L);
        categorieProduit.setLibelleCategorie("Test Libelle");
        categorieProduit.setCodeCategorie("Test Code");

        given(categorieProduitRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        categorieProduitService.retrieveCategorieProduit(categorieProduit.getIdCategorieProduit());
    }








}