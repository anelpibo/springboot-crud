package com.heybanco.exam.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.heybanco.exam.model.Employee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @AutoConfigureTestDatabase (connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repoEmpl;
    @Test
    public void saveEmployee() {
        Employee sebastian = new Employee("Sebastian", "Law", "empl123");
        Employee samantha = new Employee("Samantha", "Pena", "empl124");

        repoEmpl.save(sebastian);
        repoEmpl.save(samantha);

        repoEmpl.flush();

        assertEquals(2, repoEmpl.findAll().size());

    }
}
