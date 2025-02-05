package com.ibrahim.ib_shop.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "kal123"; // Change this to your test password
        String hashedPassword = encoder.encode(rawPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Hashed Password: " + hashedPassword);



        // Test if the password matches the stored hash
        String storedHash = "$2a$10$5vFjxf1jXtUQOjuxb/E5Kecg6BZ3N7z/GssldqY.EsVcxtPPR8BGO"; // Replace with your stored password
        System.out.println("Stored Password: " + storedHash);
        boolean isMatch = encoder.matches(rawPassword, storedHash);

        System.out.println("Does the password match?: " + isMatch);
    }
}

