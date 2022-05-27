package com.myCrud.DContact.dao;


import com.myCrud.DContact.domain.ContactDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ContactDao extends CrudRepository<ContactDomain, Long> {

    @Modifying
    @Query("update ContactDomain conct set conct.name = :name where conct.id = :id")
    public void updateName(
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );
    @Modifying
    @Query("update ContactDomain conct set conct.phoneNumber = :phoneNumber where conct.id = :id")
    public void updatePhoneNumber(
            @Param(value = "id") Long id,
            @Param(value = "phoneNumber") String phoneNumber
    );

    @Modifying
    @Query("update ContactDomain conct set conct.email = :email where conct.id = :id")
    public void updateEmail(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );
}
