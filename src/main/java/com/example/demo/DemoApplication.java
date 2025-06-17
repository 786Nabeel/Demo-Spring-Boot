package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        // Open the default URL in the browser
        try {
            String url = "http://localhost:8210"; // Default URL
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } else {
                System.out.println("Desktop is not supported. Please open the URL manually: " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}