package com.hestalis.generator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Daniel on 2016-07-07.
 */
public class PasswordEncoderGenerator {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("test"));
    }
}
