package org.util;

public class TestUtil {

    public static String generateRandomEmail() {
        String email = "johndoe" + System.currentTimeMillis() + "@email.com";
        System.out.println("Used email is: " + email);
        return email;
    }
}
