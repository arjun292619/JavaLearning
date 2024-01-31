package dev.lpa.filesMethods;

import java.io.File;

public class FilesExercise {
    public static void main(String[] args) {
        String filename = "files/testign.csv";
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("I cant run unless this file exists");
            return;
        }
        System.out.println("I am good to go");
    }
}
