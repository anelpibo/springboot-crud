package com.heybanco.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.heybanco.model.Employee;
import com.heybanco.repository.IEmployeeJpaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repo;

    @Test
    public void saveEmployee() {
        Employee sebastianTest = new Employee("Sebastian", "Pena", "emp1234");
        Employee samanthaTest = new Employee("Samantha", "Law", "emp1235");

        repo.save(sebastianTest);
        repo.save(samanthaTest);

        repo.flush();

        assertEquals(2, repo.findAll().size());
    }

}
