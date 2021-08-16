package com.taaza.generic.entity.manager.entities;

import lombok.*;

import javax.persistence.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMP_DETAILS")
@SecondaryTable(name = "EMP_OFFICE_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMP_ID"))
@SecondaryTable(name = "EMP_PERSONAL_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMP_ID"))
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    Long employeeId;
    @Column(name = "EMP_NAME")
    String employeeName;
    @Embedded
    EmployeeOfficialDetails officialDetails;
    @Embedded
    EmployeePersonalDetails personalDetails;

}
