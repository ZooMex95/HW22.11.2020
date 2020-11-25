package main;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args)  {
        HashMap<String, Integer> mapOfWords = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        try {
            fileToList(list);
        }
        catch (NoSuchFileException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        printList(list);
        System.out.println("------------------------------");
        Collections.sort(list);
        printList(list);
        System.out.println("------------------------------");
        listToMap(list,mapOfWords);
        printMap(mapOfWords);
        System.out.println("------------------------------");
        getMaxValue(mapOfWords);




    }
    public static String getPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла или полный путь");
        String path = scanner.nextLine();
        scanner.close();
        return path;
    }

    public static void printList(ArrayList<String> list) {
        for (String s:list
             ) {
            System.out.println(s);
        }
    }

    public static void printMap(HashMap<String, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Слово: " + entry.getKey() + " Повторений: "
                    + entry.getValue());
        }
    }

    public static void fileToList(ArrayList<String> list) throws NoSuchFileException, IOException {
        String str = "";
        Scanner scanner = new Scanner(Paths.get(getPath()));
        scanner.useDelimiter("\\s|\\..|,.|\\n|\\.|-.|\\(|:|\\)|\\*|\\t|$|\\r|@|№|\\d");
        while(scanner.hasNext()){
            str = scanner.next();
            if(!str.equals("")) {
                list.add(str);
            }
        }
        for (String s:list
        ) {
            System.out.println(s);
        }

        scanner.close();
    }

    public static void listToMap(ArrayList<String> list, HashMap<String, Integer> map) {
        for (String s:list
             ) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s,1);
            }
        }
    }

    public static void getMaxValue(HashMap<String, Integer> map) {
        int maxValue = 0;
        Collection<Integer> values = map.values();
        for (int i:values
             ) {
            if (i > maxValue) {
                maxValue = i;
            }
        }

        for (Map.Entry entry: map.entrySet()
             ) {
            if (Objects.equals(maxValue, entry.getValue())) {
                System.out.println("Слово: " + entry.getKey() + " Повторений: "
                        + entry.getValue());

            }
        }

    }
}
