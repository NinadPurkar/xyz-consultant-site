package com.example.ninad.controller;

import com.example.ninad.model.ContactForm;
import com.example.ninad.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

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

        String name = contactForm.getName();
        String phone = contactForm.getPhone();
        emailService.sendContactInfo(name,phone);
        // For now, just log the data
        System.out.println("Received contact: " + contactForm.getName() + ", " + contactForm.getPhone());

        // Redirect to home or a thank-you page
        return "redirect:/thank-you";
    }

    @GetMapping("/thank-you")
    public String showThankYouPage() {
        return "thank-you"; // this maps to thank-you.html in /templates
    }
}