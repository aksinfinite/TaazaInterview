package com.taaza.generic.entity.manager;

import com.taaza.generic.entity.manager.entities.EmployeeDetails;
import com.taaza.generic.entity.manager.entities.EmployeeDetailsRepo;
import com.taaza.generic.entity.manager.entities.EmployeeOfficialDetails;
import com.taaza.generic.entity.manager.entities.EmployeePersonalDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EntityManagerTests {
    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;

    @Test
    void insertDataIntoOfficeDetailsUsingEmpDetailsMapping(){
        EmployeeDetails employeeDetails = EmployeeDetails.builder()
                .officialDetails(
                        EmployeeOfficialDetails.builder()
                                .officeLocation("Bangalore").build())
                .build();
        employeeDetailsRepo.saveAndFlush(employeeDetails);
        assertEquals(employeeDetails.getOfficialDetails().getOfficeLocation(), (employeeDetailsRepo.findAll().get(0)).getOfficialDetails().getOfficeLocation());
    }
    @Test
    void insertDataIntoPersonalDetailsUsingEmpDetails(){
        EmployeeDetails employeeDetails = EmployeeDetails.builder()
                .personalDetails(
                        EmployeePersonalDetails.builder()
                                .homeAddress("Bangalore").build())
                .build();
        employeeDetailsRepo.saveAndFlush(employeeDetails);
        assertEquals(employeeDetails.getPersonalDetails().getHomeAddress(), (employeeDetailsRepo.findAll().get(0)).getPersonalDetails().getHomeAddress());
    }

    @Test
    void insertDataIntoEmpDetails(){
        EmployeeDetails employeeDetails = EmployeeDetails.builder()
                .officialDetails(EmployeeOfficialDetails.builder()
                        .officeLocation("Home").build())
                .personalDetails(
                        EmployeePersonalDetails.builder()
                                .homeAddress("London").build())
                .employeeName("Akhil")
                .build();
        employeeDetailsRepo.saveAndFlush(employeeDetails);
        assertEquals(employeeDetails.getPersonalDetails().getHomeAddress(), (employeeDetailsRepo.findAll().get(0)).getPersonalDetails().getHomeAddress());
        assertEquals(employeeDetails.getOfficialDetails().getOfficeLocation(), (employeeDetailsRepo.findAll().get(0)).getOfficialDetails().getOfficeLocation());
        assertEquals(employeeDetails.getEmployeeName(), employeeDetailsRepo.findAll().get(0).getEmployeeName());
        assertNotNull(employeeDetailsRepo.findAll().get(0).getEmployeeId());
    }
}
