package com.malvin.swagger2.swaggerapi.controller;

import com.malvin.swagger2.swaggerapi.model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){
        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContact(){
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
