package org.example.service;

import org.example.dto.Word;
import org.example.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordService {

    @Autowired
    public WordRepository wordRepository;
    public void getAllWords(){
        List<Word> wordList = wordRepository.getAll();
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }

  /**  public List<String> randomTestWord() {
        List<String> stringList = new LinkedList<>();
        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();
        while (randomNumbers.size() < 4) {
            int randomNumber = random.nextInt(wordRepository.getAll().size());
           // stringList.add(wordRepository.getByIdWordeng(randomNumber));

        }
        return stringList;
    }

    public Set<Integer> randomTestWordUz() {
        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();
        while (randomNumbers.size() < 1) {
            int randomNumber = random.nextInt(wordRepository.getAll().size());
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }*/

  public LinkedHashSet<Integer> multipleChoiceVariantService() {
      Random random = new Random();
      LinkedHashSet<Integer> variants = new LinkedHashSet<>();
      while (variants.size() == 4) {
      }
      for (int i = 0; i < 15; i++) {
          int randomNumber = random.nextInt(1, wordRepository.getAll().size());
          variants.add(randomNumber);
      }
      return variants;
  }
}
