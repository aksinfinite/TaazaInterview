package com.taaza.generic.entity.manager.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EmployeeOfficialDetails {
    @Column(name = "OFFICE_LOCATION", table = "EMP_OFFICE_DETAILS")
    String officeLocation;
}
