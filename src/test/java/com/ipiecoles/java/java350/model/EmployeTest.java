package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EmployeTest {

    @ParameterizedTest(name = "Un employe avec  {0} est valide pour le test")
    @CsvSource({
            "3, 0",
            "-2, 2",
            "0, 0"
    })
    void testGetNbAnneeAnciennete(Integer anciennete, Integer resultat) {
        LocalDate dateEmbauche = LocalDate.now().plusYears(anciennete);
        Employe employeTest = new Employe("", "", "", dateEmbauche, 1000d, 1, 1.0);
        Integer nbAnnee = employeTest.getNombreAnneeAnciennete();
        Assertions.assertThat(nbAnnee).isEqualTo(resultat);
    }

    @Test
    public void testGetNbAnneeAncienneteNull() {
        LocalDate nullDate = null;
        Employe employeTest = new Employe("", "", "", nullDate, 1000d, 1, 1.0);
        Integer nbAnnee = employeTest.getNombreAnneeAnciennete();
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    @ParameterizedTest(name = "matricule {0}, ancienneté {1}, taux activité {2}, performance {3} => prime {4}")
    @CsvSource({
            "'M12345', 0, 1.0, 1, 1700.0",
            "'M12345', 2, 1.0, 1, 1900.0",
            "'T12345', 0, 1.0, 1, 1000.0",
            "'T12345', 1, 1.0, 1, 1100.0",
            ", 0, 1.0, 1, 1000.0",
            "'T12345', 0, 1.0,, 1000.0",
            "'T12345', 0, 1.0, 3, 3300.0",
            "'T12345', 4, 1.0, 3, 3700.0",
            "'T12345', 0, 0.5, 1, 500.0"
    })
    public void testPrimeManagerSansAnceiennetePleinTemps(
            String matricule,
            Integer nbAnneeAnciennete,
            Double tauxActivite,
            Integer performance,
            Double primeCalculee
    ) {

        Employe testEmploye = new Employe("Doe", "John",
                matricule, LocalDate.now().minusYears(nbAnneeAnciennete), 2000d, performance, tauxActivite);

        Double prime = testEmploye.getPrimeAnnuelle();

        Assertions.assertThat(prime).isEqualTo(primeCalculee);

    }

}
