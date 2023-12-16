package org.example;


import org.example.controller.WordController;
import org.example.db.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        WordController wordController = (WordController) context.getBean("wordController");
        wordController.start();

        /** kutubhona projekt ish task */

        /**
         Console + spring JDBC
         ** Menu **
         1. Add Word
         2. WordList List
         3. Multiple Choice
         4. Spelling
         5. Searching
         6. Delete by id

         1. Add word
         Enter word: Book
         Enter Translate: Kitob
         Enter description: I love reading book.

         2. WordList
         1. Book -> Kitob -> I love reading book.
         3. Multiple Choice
         Book
         a. ruchka
         b. kitob
         c. asaaa
         d. dasda
         Enter your answer (0 - stop):

         4. Spelling
         Kitob
         Entre translate: bok  ->
         Entre translate: book

         5.   Searching
         Enter word (including both)
         */

    }
}