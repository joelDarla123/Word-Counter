package com.pack2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
    	String fileName = "D:/Alfido Tech/trail.txt"; // Change this to the path of your text file

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            Map<String, Integer> wordFrequency = new HashMap<>();
            int totalWords = 0;
            int totalCharacters = 0;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                totalWords += words.length;
                totalCharacters += line.length();

                for (String word : words) {
                    word = word.toLowerCase(); // Convert to lowercase to ensure case-insensitive counting
                    word = word.replaceAll("[^a-zA-Z0-9]", ""); // Remove non-alphanumeric characters
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }

            bufferedReader.close();

            // Output word count
            System.out.println("Total words: " + totalWords);

            // Output word frequency
            System.out.println("Word frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Calculate and output average word length
            double averageWordLength = (double) totalCharacters / totalWords;
            System.out.println("Average word length: " + averageWordLength);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
