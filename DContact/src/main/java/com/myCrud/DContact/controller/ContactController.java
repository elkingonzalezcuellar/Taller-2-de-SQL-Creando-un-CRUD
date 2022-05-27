package com.myCrud.DContact.controller;

import com.myCrud.DContact.domain.ContactDomain;
import com.myCrud.DContact.service.ContactService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contacts")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/getAll")
    public List<ContactDomain> list(){
        return contactService.list();

    }
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<ContactDomain> deleteContact( ContactDomain contact){
        contactService.delete(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @PostMapping("/add")
    public String add(@RequestBody ContactDomain contact){
        contactService.save(contact);
        return "New Contact is added";
    }



}
