package com.ecommerce.EasyCart.Controller;

import java.security.Principal;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.EasyCart.Forms.ContactForm;
import com.ecommerce.EasyCart.Service.ContactService;
import com.ecommerce.EasyCart.View.ContactListView;


@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
    private ContactService contactService;

    @GetMapping
    public Collection<ContactListView> list(Principal p) {
        return contactService.list();
    }
    
    @PostMapping
    public ContactListView add(@Valid @RequestBody ContactForm form) {
        return contactService.add(form);
    }
    
    @GetMapping("/{contactId}")
    public ContactListView get(@PathVariable("contactId") Integer contactId) {
        return contactService.get(contactId);
    }

    @PutMapping("/{contactId}")
    public ContactListView update(
            @PathVariable("contactId") Integer contactId,
            @Valid @RequestBody ContactForm form
    ) {
        return contactService.update(contactId, form);
    }

}
