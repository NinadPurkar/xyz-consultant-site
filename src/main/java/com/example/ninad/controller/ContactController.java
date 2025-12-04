package com.example.ninad.controller;

import com.example.ninad.model.ContactForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact"; // This maps to templates/contact.html
    }

    @PostMapping("/contact")
    public String submitForm(@ModelAttribute @Valid ContactForm contactForm, BindingResult result) {
        if (result.hasErrors()) {
            return "contact";
        }

        // For now, just log the data
        System.out.println("Received contact: " + contactForm.getName() + ", " + contactForm.getPhone());

        // Redirect to home or a thank-you page
        return "index";
    }
}