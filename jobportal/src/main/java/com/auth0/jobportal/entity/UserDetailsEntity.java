package com.auth0.jobportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.web.bind.annotation.Mapping;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_details")
public class UserDetailsEntity extends BaseEntity{

    private  String email;

    @Column(name="first_name")
    private  String firstName;

    @Column(name="last_name")
    private  String lastName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private  AddressEntity address;

    @OneToOne(mappedBy = "userDetailsEntity")
    private UsersEntity usersEntity;



}