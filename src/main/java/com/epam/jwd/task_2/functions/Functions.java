package com.epam.jwd.task_2.functions;



import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Functions {

   public List<String> function5_reverse(List<String> wordsList) throws IOException, WrongFileName {
      List<java.lang.String> parseSentences = new ArrayList<>();
      List<java.lang.String>parser = new SentenceParser()
              .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(), parseSentences);

      for (int i = 0; i<parser.size(); i++){
         reverseWords(parser.get(i));
      }
      return wordsList;
      /*Declaring Variables
      To use any variable in a Java program, you must first declare it.*/
   }

   public void reverseWords(String sentence) throws IOException, WrongFileName {
      String sentenceWithoutSpaces = sentence.trim();
      List<String> wordsList = new ArrayList<>();
      new WordParser().sentenceParser(sentenceWithoutSpaces, wordsList);

      Collections.swap(wordsList, 0, wordsList.size()-3);
      for (String line : wordsList){
         System.out.println(line);
      }

   }

   public void alphabetOrder(List <String> sortList){
      Collections.sort(sortList);
      String letter = sortList.get(0).substring(0, 1);
      boolean redline = true;
      for (int i = 0; i < sortList.size(); i++) {
         if(!sortList.get(i).substring(0, 1).equals(letter)){
            redline = true;
            letter = sortList.get(i).substring(0, 1);
         }
         if(redline){
            System.out.println("\t"+sortList.get(i));
         } else {
            System.out.println(sortList.get(i));
         }
         redline = false;
      }
   }

   public String formatText12(String incomingText, int sizeOfWords) {
      StringBuilder sb = new StringBuilder();


      if ((incomingText.length() / sizeOfWords != 0) && isVowel(incomingText)) {
         sb.append(incomingText).append(" ");
      }


      String outText = sb.toString().trim();
      return outText;
   }

   public static boolean isVowel(String incomingText) {
      switch ((char)Character.toLowerCase(incomingText.charAt(0))) {
         case 'a':
         case 'e':
         case 'i':
         case 'o':
         case 'u':
         case 'y':
            return true;
         default:
            return false;

      }
   }

}





