package com.rest.api.services;

import com.rest.api.exceptions.ContactNotFoundException;
import com.rest.api.models.Contact;
import com.rest.api.respository.ContactRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiRestService {

    @Autowired
    ContactRepository contactRepository;

    private List<Contact> contacts = new ArrayList<Contact>();

    @Transactional
    public List<Contact> getContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Transactional
    public Contact getContact(long id) throws ContactNotFoundException {
        try {
            Contact contact = contactRepository.findById(id).get();
            return contact;
        } catch(Throwable t){
            throw new ContactNotFoundException("Contact could not be located.", t);
        }
    }

    @Transactional
    public void updateContact(Contact contact) throws ContactNotFoundException {
        try {
            Contact c = contactRepository.findById(contact.getId()).get();
            c.setLastName(contact.getLastName());
            c.setFirstName(contact.getFirstName());
            c.setEmail(contact.getEmail());
            contactRepository.save(c);
        } catch(Throwable t) {
            throw new ContactNotFoundException("Contact could not be updated.", t);
        }
    }

    @Transactional
    public Contact saveContact(Contact contact) {
        contact.setId(contacts.size() + 1);
        return contactRepository.save(contact);
    }

    @Transactional
    public void deleteContact(long id) {;
        try {
            Contact contact = this.getContact(id);
            contactRepository.delete(contact);
        } catch(Throwable t){
            throw new ContactNotFoundException("Contact could not be updated.", t);
        }
    }
}
