package com.ipiecoles.java.java350.repository;

import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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

}
