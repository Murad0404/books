package org.example.controller;

import org.example.db.Database_Util;
import org.example.dto.Word;
import org.example.repository.WordRepository;
import org.example.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class WordController {
    public Scanner scanner = new Scanner(System.in);

    @Autowired
    public WordRepository wordRepository;

    @Autowired
    public WordService wordService;

    @Autowired
    public Database_Util databaseUtil;


    public void start() {
        databaseUtil.createTable();
        boolean t = true;
        while (t) {
            showMenu();
            int action = getAction();
            switch (action) {
                case 1:
                    createWord();
                    break;
                case 2:
                    wordService.getAllWords();
                    break;
                case 3:
                    multipleChoice();
                    break;
                case 4:
                    wordSearching();
                    break;
                case 5:
                    wordSpelling();
                    break;
                case 6:

                   // t = false;
                    break;
                default:
                    System.out.println("Mazgi");
                    t = false;

            }
        }
    }

    public int getAction() {
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        return action;
    }

    public void showMenu() {
        System.out.println("***** Menu *****");
        System.out.println("1. Add Word ");
        System.out.println("2. WordList List ");
        System.out.println("3. Multiple Choice ");
        System.out.println("4. Spelling ");
        System.out.println("5. Searching ");
        System.out.println("6. Delete by id ");
    }

    public void createWord() {
        System.out.println("soz kiritint ");
        String worduz = scanner.nextLine();
        System.out.println("tarjimasini kiritint ");
        String wordeng = scanner.nextLine();
        System.out.println("qandaydir tarif ");
        String description = scanner.nextLine();
        Word word = new Word();
        word.setWordUz(worduz);
        word.setWordEng(wordeng);
        word.setDescription(description);
        wordRepository.create(word);
    }

    public void multipleChoice(){
        Random random = new Random();
        int randomNumber = random.nextInt(1, wordRepository.getAll().size());
        //System.out.println("randaom: " + randomNumber);
        Word w = wordRepository.getById(randomNumber);
        System.out.println(w.getWordUz());

        ArrayList<Integer> variants = new ArrayList<>(wordService.multipleChoiceVariantService());

        HashMap<String, String> stringStringHashMap = new HashMap<>();

        System.out.println("a)" + wordRepository.getByIdtest(variants.get(0)).getWordEng());
        stringStringHashMap.put("a", wordRepository.getByIdtest(variants.get(0)).getWordEng());

        System.out.println("b)" + wordRepository.getByIdtest(variants.get(1)).getWordEng());
        stringStringHashMap.put("b", wordRepository.getByIdtest(variants.get(1)).getWordEng());

        System.out.println("c)" + wordRepository.getByIdtest(variants.get(2)).getWordEng());
        stringStringHashMap.put("c", wordRepository.getByIdtest(variants.get(2)).getWordEng());

        System.out.println("e)" + wordRepository.getByIdtest(variants.get(3)).getWordEng());
        stringStringHashMap.put("e", wordRepository.getByIdtest(variants.get(3)).getWordEng());

        System.out.println("vriant kiriting");
        String variant = scanner.nextLine();

        if (stringStringHashMap.get(variant).equals(w.getWordEng())) {
            System.out.println("sackses");
        } else {
            System.out.println("hato variant kiritdingiz");
        }
    }

    public void wordSpelling(){
        Random random = new Random();
        int randomNumber = random.nextInt(1, wordRepository.getAll().size());
        Word w = wordRepository.getById(randomNumber);
        System.out.println(w.getWordUz());
        System.out.println("Entre translate:");
        String worduz = scanner.nextLine();
        worduz += "%";
        Word word = wordRepository.getByWord(worduz);
        System.out.println("--->"+word.getWordEng());
    }

    public void wordSearching(){
        System.out.println("Entre word:");
        String worduz = scanner.nextLine();
        Word word = wordRepository.getByWorduzAndWordeng(worduz);
        System.out.println("--> "+word.getWordEng()+"   "+word.getWordUz()+" <--");
    }

   /** public void multipleChoiceVariant() {
        //Random random = new Random();
        ArrayList<Integer> variants = new ArrayList<>(wordService.multipleChoiceVariantService());
        System.out.println("a)" + wordRepository.getByIdtest(variants.get(0)).getWordEng());

        System.out.println("b)" + wordRepository.getByIdtest(variants.get(1)).getWordEng());

        System.out.println("c)" + wordRepository.getByIdtest(variants.get(2)).getWordEng());

        System.out.println("e)" + wordRepository.getByIdtest(variants.get(3)).getWordEng());*/

        /*for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(1, wordRepository.getAll().size());
            variants.add(randomNumber);
        }*/
        /** int randomNumber = random.nextInt(1,wordRepository.getAll().size());
         while ( 4 == variants.keySet().size()) {
         variants.put(wordRepository.getByIdtest(randomNumber).getWordUz(),randomNumber);
         }
         for (int i = 0; i < variants.keySet().size(); i++) {
         //            System.out.println(Arrays.toString(variants.keySet().toArray()));
         for (String key: variants.keySet()){
         System.out.println(key +" " + variants.get(key));
         }*/


    //}
//        if (randomNumber < 3) {
//            System.out.println("a)"+wordRepository.getByIdtest(randomNumber).getWordUz());
//
//            System.out.println("b)"+wordRepository.getByIdtest(randomNumber+1).getWordUz());
//
//            System.out.println("c)"+wordRepository.getByIdtest(randomNumber+2).getWordUz());
//
//            System.out.println("e)"+wordRepository.getByIdtest(randomNumber+3).getWordUz());
//
//        }

}

