package com.ipiecoles.java.java350.repository;

import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    @Test
    public void findLastMatriculeTestEmptyList() {

        employeRepository.deleteAll();

        String result = employeRepository.findLastMatricule();

        Assertions.assertThat(result).isEqualTo(null);

    }

    @Test
    public void findLastMatriculeTestFullWithLetter() {

        employeRepository.deleteAll();

        Employe employeSimpson = employeRepository.save(new Employe("Simpson", "Hommer", "T12345", LocalDate.now(), 1000d, 1, 1.0));
        Employe employeWick = employeRepository.save(new Employe("Wick", "John", "M15697", LocalDate.now(), 1000d, 1, 1.0));
        Employe employeSparrow = employeRepository.save(new Employe("Sparrow", "Jack", "T64978", LocalDate.now(), 1000d, 1, 1.0));
        Employe employePutin = employeRepository.save(new Employe("Putin", "Vladimir", "C49785", LocalDate.now(), 1000d, 1, 1.0));

        String result = employeRepository.findLastMatricule();

        Assertions.assertThat(result).isEqualTo("64978");

    }

    @Test()
    public void avgPerformanceWhereMatriculeStartsWithTestEmptyList() {

        employeRepository.deleteAll();

        Double result = employeRepository.avgPerformanceWhereMatriculeStartsWith("T");

        Assertions.assertThat(result).isEqualTo(null);

    }

    @ParameterizedTest(name = "La moyenne de perf des matricule {0} est de {1}")
    @CsvSource({
            "T, 10.5",
            "M, 15",
            "C, 25.5",
            ","
    })
    public void avgPerformanceWhereMatriculeStartsWithTestRegularList(String letter, Double resultat) {

        employeRepository.deleteAll();

        Employe employeWick = employeRepository.save(new Employe("Wick", "John", "M15697", LocalDate.now(), 1000d, 5, 1.0));
        Employe employeRoss = employeRepository.save(new Employe("Ross", "Bob", "M54973", LocalDate.now(), 1000d, 25, 1.0));
        Employe employeSimpson = employeRepository.save(new Employe("Simpson", "Hommer", "T12345", LocalDate.now(), 1000d, 9, 1.0));
        Employe employeSparrow = employeRepository.save(new Employe("Sparrow", "Jack", "T64978", LocalDate.now(), 1000d, 12, 1.0));
        Employe employePutin = employeRepository.save(new Employe("Putin", "Vladimir", "C49785", LocalDate.now(), 1000d, 3, 1.0));
        Employe employeDepp = employeRepository.save(new Employe("Depp", "Johnny", "C94678", LocalDate.now(), 1000d, 48, 1.0));

        Double functionResult = employeRepository.avgPerformanceWhereMatriculeStartsWith(letter);

        Assertions.assertThat(functionResult).isEqualTo(resultat);

    }

    @ParameterizedTest(name = "La moyenne de perf des matricule {0} est de {1}")
    @CsvSource({
            "T, 9",
            "M, 5",
            "C, 3",
            ","
    })
    public void avgPerformanceWhereMatriculeStartsWithTestSoloList(String letter, Double resultat) {

        employeRepository.deleteAll();

        Employe employeWick = employeRepository.save(new Employe("Wick", "John", "M15697", LocalDate.now(), 1000d, 5, 1.0));
        Employe employeSimpson = employeRepository.save(new Employe("Simpson", "Hommer", "T12345", LocalDate.now(), 1000d, 9, 1.0));
        Employe employePutin = employeRepository.save(new Employe("Putin", "Vladimir", "C49785", LocalDate.now(), 1000d, 3, 1.0));

        Double functionResult = employeRepository.avgPerformanceWhereMatriculeStartsWith(letter);

        Assertions.assertThat(functionResult).isEqualTo(resultat);

    }

    @Test
    public void avgPerformanceWhereMatriculeStartsWithTestWithoutTheLetterInTheList() {

        employeRepository.deleteAll();

        Employe employeWick = employeRepository.save(new Employe("Wick", "John", "M15697", LocalDate.now(), 1000d, 5, 1.0));
        Employe employeSimpson = employeRepository.save(new Employe("Simpson", "Hommer", "M12345", LocalDate.now(), 1000d, 9, 1.0));
        Employe employePutin = employeRepository.save(new Employe("Putin", "Vladimir", "M49785", LocalDate.now(), 1000d, 3, 1.0));

        Double result = employeRepository.avgPerformanceWhereMatriculeStartsWith("T");

        Assertions.assertThat(result).isEqualTo(null);

    }

}
