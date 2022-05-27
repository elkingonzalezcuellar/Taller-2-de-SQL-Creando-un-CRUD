package com.myCrud.DContact.service;

import com.myCrud.DContact.domain.ContactDomain;

import java.util.List;
import java.util.Optional;

public interface IContactService {


    public ContactDomain save(ContactDomain contact);

    public ContactDomain update(Long id, ContactDomain contact);
    public List<ContactDomain> list();

    public void delete(ContactDomain contact);

    public Optional<ContactDomain> findUser(ContactDomain contact);
}
