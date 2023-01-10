package in.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.boot.binding.Contact;
import in.boot.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;
	
	
	//post http://localhost:8080/contact/
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact) {
	System.out.println(contact.getContactEmail());
		String status=service.saveContact(contact);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<Contact> getAllContacts(){
		return service.getAllContacts();
	}
	//Get http://localhost:8080/contact/101
	@GetMapping("/contact/{contactId}")
	public Contact  getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
	}
	
	// put http://localhost:8080/cotact/
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}
	
	// Delete http://localhost:8080/contact/101
	@DeleteMapping("/contact/{contactId}")
	public String deletecontact(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}
	
}
