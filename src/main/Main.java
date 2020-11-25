package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> mapOfWords = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя файла или полный путь");
        try {
            String path = reader.readLine();
        }
        catch (IOException e) {
            System.out.println("h1");
        }
    }
}
