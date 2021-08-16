package com.taaza.generic.entity.manager.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeePersonalDetails {
    @Column(name = "HOME_ADDRESS", table = "EMP_PERSONAL_DETAILS")
    String homeAddress;
}
