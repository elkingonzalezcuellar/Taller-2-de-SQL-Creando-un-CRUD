package com.myCrud.DContact.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "contact")
public class ContactDomain implements Serializable {
    private  static  final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Phone_Contact")
    private Long id;
    @Column(name = "full_name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column (name = "date_of_Birth")
    private Date  dateOfBirth;
}
