package org.example.fp1;

import java.util.Locale;
import java.util.Optional;

public class OptionalC {
    public static void main(String[] args) {

        //testingOne();
        testingTwo();

    }
    public static void testingTwo() {
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[4]);
        if(checkNull.isPresent()){
            String word = checkNull.get();
            System.out.println(word);
        }else {
            System.out.println("word is null");
        }

    }
    public static void testingOne() {
        String[] words = new String[10];
        String word = words[5].toLowerCase();
        System.out.println(word);
    }
}
