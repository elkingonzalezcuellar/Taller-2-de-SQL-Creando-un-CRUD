package com.myCrud.DContact.service;

import com.myCrud.DContact.dao.ContactDao;
import com.myCrud.DContact.domain.ContactDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    @Autowired // para inyectar contactDao
    private ContactDao contactDao;

    @Override
    @Transactional(readOnly = true)
    public List<ContactDomain> list() {
        return (List<ContactDomain>) contactDao.findAll();
    }
    @Override
    @Transactional
    public ContactDomain save(ContactDomain contact) {

        return contactDao.save(contact);
    }

    @Override
    @Transactional
    public ContactDomain update(Long id, ContactDomain contact) {
        contact.setId(id);
        return contactDao.save(contact);
    }

    @Transactional
    public void updateName(Long id, ContactDomain contact) {

        contactDao.updateName(id, contact.getName());
    }

    @Transactional
    public void updatePhoneNumber(Long id, ContactDomain contact) {
        contactDao.updatePhoneNumber(id, contact.getPhoneNumber());
    }

    @Transactional
    public void updateEmail(Long id, ContactDomain contact) {
        contactDao.updateEmail(id, contact.getEmail());
    }

    @Override
    @Transactional
    public void delete(ContactDomain contact) {

        contactDao.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ContactDomain> findUser(ContactDomain contact) {

        return contactDao.findById(contact.getId());
    }
}
