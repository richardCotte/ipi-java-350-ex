package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    public void testGetNbAnneeAncienneteFutur() {
        LocalDate futurDate = LocalDate.now().plusYears(3);
        Employe employeTest = new Employe("", "", "", futurDate, 1000d, 1, 1.0);
        Integer nbAnnee = employeTest.getNombreAnneeAnciennete();
        Assertions.assertThat(nbAnnee).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void testGetNbAnneeAnciennetePast() {
        LocalDate pastDate = LocalDate.now().minusYears(2);
        Employe employeTest = new Employe("", "", "", pastDate, 1000d, 1, 1.0);
        Integer nbAnnee = employeTest.getNombreAnneeAnciennete();
        Assertions.assertThat(nbAnnee).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void testGetNbAnneeAncienneteActuel() {
        LocalDate actualDate = LocalDate.now();
        Employe employeTest = new Employe("", "", "", actualDate, 1000d, 1, 1.0);
        Integer nbAnnee = employeTest.getNombreAnneeAnciennete();
        Assertions.assertThat(nbAnnee).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void testGetNbAnneeAncienneteNull() {
        LocalDate nullDate = null;
        Employe employeTest = new Employe("", "", "", nullDate, 1000d, 1, 1.0);
        Integer nbAnnee = employeTest.getNombreAnneeAnciennete();
        Assertions.assertThat(nbAnnee).isGreaterThanOrEqualTo(0);
    }

}
