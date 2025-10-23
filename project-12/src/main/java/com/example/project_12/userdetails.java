package com.example.project_12;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class userdetails {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email address is not valid")
    @NotBlank(message = "Email address is required")
    @GmailOnly(message = "Email must be a Gmail address")
    private String email;

    @Address(message = "Address must contain 'India'")
    private String address;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
