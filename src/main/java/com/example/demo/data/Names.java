package com.example.demo.data;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Names {

    private static HashMap<String, String> map, fileNames;

    static {

        map = new HashMap<>();
        fileNames = new HashMap<>();
        map.put("Nabeel", "IT");
        map.put("Shaheer", "IT");
        map.put("Razib", "CS");

    }

    public static void getData() {
        File file = new File("Names.txt");
        try {

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                String[] names = name.split(" ");
                fileNames.put(names[0], names[1]);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSection(String id) {
        return map.get(id);
    }

    public static String getSectionFromFile(String name) {
        getData();
        for (HashMap.Entry<String, String> entry : fileNames.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return fileNames.get(name);
    }

}
