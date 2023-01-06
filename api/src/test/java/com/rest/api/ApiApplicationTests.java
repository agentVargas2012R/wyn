package com.rest.api;

import com.rest.api.models.Contact;
import com.rest.api.services.ApiRestService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	ApiRestService apiRestService;
	Contact c = new Contact();

	@Before()
	public void setUp() {
		c.setEmail("mvargas@gmail.com");
		c.setFirstName("Mike");
		c.setLastName("Vargas");
	}

	@Test
	public void testSaveContact() {
		Contact savedContact = apiRestService.saveContact(c);
		assertTrue(savedContact.getId() != 0, "contact did not save to db correctly");
	}

	@Test
	public void testGetContacts() {
		Contact savedContact = apiRestService.saveContact(c);
		List<Contact> contactList = (List<Contact>) apiRestService.getContacts();
		assertTrue(contactList.size() > 0, "Should be able to retrieve all contacts");
	}

	@Test
	public void testGetContact() {
		Contact savedContact = apiRestService.saveContact(c);
		Contact contact = apiRestService.getContact(savedContact.getId());
		assertTrue(savedContact.getId() == contact.getId(), "Should get the contact form the db.");
	}

	@Test
	public void testDeleteContact() {
		Contact savedContact = apiRestService.saveContact(c);
		apiRestService.deleteContact(savedContact.getId());
		List<Contact> contacts = (List<Contact>) apiRestService.getContacts();
		assertTrue(contacts.size() == 0, "Should delete a contact");
	}
}
