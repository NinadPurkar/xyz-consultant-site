package com.example.ninad.model;

import jakarta.validation.constraints.NotEmpty;

public class ContactForm {
    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Phone is required")
    private String phone;

    //Getters and Setters
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
