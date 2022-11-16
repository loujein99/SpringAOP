package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
class ReglementServiceImplTest {


    @Autowired
    IReglementService reglementService;

    @Test
    void TestRetrieveAllReglements() {

        int sizeReglements = reglementService.retrieveAllReglements().size();
        reglementService.addReglement(Reglement.builder().dateReglement(new Date()).payee(false).build());
        Assertions.assertEquals(sizeReglements+1, reglementService.retrieveAllReglements().size());
        log.info("Size:"+String.valueOf(sizeReglements));
    }

    @Test
    void TestAddReglement() {
        Reglement r =reglementService.addReglement(Reglement.builder()
                .montantPaye(20.00F)
                .payee(true).build());
        Assertions.assertNotNull(r);
        log.info("Reglement : "+r.toString());

    }

}