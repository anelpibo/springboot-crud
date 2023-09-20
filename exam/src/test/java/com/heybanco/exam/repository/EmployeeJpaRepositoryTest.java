package com.heybanco.exam.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.heybanco.exam.model.Employee;
import com.heybanco.exam.model.Project;
import com.heybanco.exam.model.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @AutoConfigureTestDatabase (connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repoEmpl;    

    @Autowired
    private IRoleJpaRepository repoRole;

    @Autowired
    private IProjectJpaRepository repoProj;
    @Test
    public void saveEmployee() {
        Role admin = new Role("ROLE_ADMIN");
        Role dev = new Role("ROLE_DEV");

        admin = repoRole.save(admin);
        dev = repoRole.save(dev);

        Project proj1 = new Project("proj1");
        Project proj2 = new Project("proj2");
        Project proj3 = new Project("proj3");

        proj1 = repoProj.save(proj1);
        proj2 = repoProj.save(proj2);
        proj3 = repoProj.save(proj3);
        
        Employee sebastian = new Employee("Sebastian", "Law", "empl123", dev);
        Employee samantha = new Employee("Samantha", "Pena", "empl124", admin);

        sebastian.getProjects().add(proj1);
        sebastian.getProjects().add(proj2);

        samantha.getProjects().add(proj1);
        samantha.getProjects().add(proj2);
        samantha.getProjects().add(proj3);

        repoEmpl.save(sebastian);
        repoEmpl.save(samantha);

        repoEmpl.flush();

        Employee empl124 = repoEmpl.findByemployeeId("empl124");
        assertEquals("Samantha", empl124.getFirstName());
        assertEquals(2, repoEmpl.findAll().size());
        assertEquals(admin, empl124.getRole());
    }
}
