package com.rest.api.controllers;

import com.rest.api.models.Contact;
import com.rest.api.services.ApiRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiRestController {

    @Autowired
    ApiRestService apiRestService;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return apiRestService.getContacts();
    }

    @GetMapping("/contacts/{contactId}")
    public Contact getContact(@PathVariable long contactId) {
        return apiRestService.getContact(contactId);
    }

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {
         return apiRestService.saveContact(contact);
    }

    @PutMapping("/contacts")
    public void putContact(@RequestBody Contact contact) {
        apiRestService.updateContact(contact);
    }

    @DeleteMapping("/contacts/{contactId}")
    public String deleteContact(@PathVariable long contactId) {
        apiRestService.deleteContact(contactId);
        return "Deleted contact Id: " + contactId;
    }
}
