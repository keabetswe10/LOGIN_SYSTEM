/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.register_login1;
import javax.swing.JOptionPane;
/**
 *
 * @author Keabetswe malwa
 */

public class RegisterLoginSystem {
    private static String firstname;
    private static String lastname;
    private static String username;
    private static String password;
    
    // Maximum length for the username
    private static final int MAX_USERNAME_LENGTH = 20;

    public static void main(String[] args) {
        // Register a new user
        register();

        // Login with registered credentials
        login();
    }

    private static void register() {
        firstname = JOptionPane.showInputDialog("Enter a firstname:");
        lastname = JOptionPane.showInputDialog("Enter a lastname:");
        username = JOptionPane.showInputDialog("Enter a username (maximum " + MAX_USERNAME_LENGTH + " characters):");
        password = JOptionPane.showInputDialog("Create a password:");

        // Check if any field is empty
        if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields");
            register(); // Allows the user to input all fields that are required
        } else {
            // Check username length
            if (username.length() > MAX_USERNAME_LENGTH) {
                JOptionPane.showMessageDialog(null, "Username exceeds maximum length of " + MAX_USERNAME_LENGTH + " characters.");
                register(); // Re-prompt for username
            } else {
                // Check password strength
                if (!isStrongPassword(password)) {
                    JOptionPane.showMessageDialog(null, "Please enter a stronger password.");
                    register(); // Re-prompt for password
                } else {
                    JOptionPane.showMessageDialog(null, "Registration successful. You can now login.");
                }
            }
        }
    }

    private static void login() {
        String inputUsername = JOptionPane.showInputDialog("Enter your username:");
        String inputPassword = JOptionPane.showInputDialog("Enter your password:");

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome, " + inputUsername + "!");
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password. Please try again.");
            login(); // Recursive call for reattempting login
        }
    }

    // Function to check if a password is strong
    private static boolean isStrongPassword(String password) {
        // Add your password strength criteria here
        // For simplicity, let's just check the length
        return password.length() >= 8;
    }
}

 
        