package com.epam.jwd.task_2.functions;



import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;


public class Functions {

   private Map<Integer, String> sentenceOrderMap = new TreeMap<>();

   public Map<Integer, String> sentenceOrder() throws IOException {
      int sizeBefore = 0;
      int sizeAfter = 0;

      List<String> sentenceOrderList = new ArrayList<>();

      List<String> wordsList = new ArrayList<>();

      List<String> originalText = new ArrayList<>();

      List<String> originalSentence = new ArrayList<>();

      List<String>parser = new SentenceParser()
              .parseSentences("ProgramFile.txt",
                      SentenceParser.getSentenceParser(),
                      sentenceOrderList, originalText);

      //new PunctuationMarksParser().parseText(sentenceOrderList);

      for (int i = 0; i<parser.size(); i++){
           sizeBefore = wordsList.size();

         new WordParser().sentenceParser(parser.get(i), wordsList, originalSentence);
         wordsList.removeIf(item -> item == null || "".equals(item));
           sizeAfter = wordsList.size();
         int realSize = sizeAfter-sizeBefore;

         sentenceOrderMap.put(realSize, parser.get(i));


      }
      return sentenceOrderMap;

   }

   public void reverseWords(String sentence) throws IOException {
      String sentenceWithoutSpaces = sentence.trim();
      List<String> wordsList = new ArrayList<>();
      List<String> originalSentence = new ArrayList<>();
      new WordParser().sentenceParser(sentenceWithoutSpaces, wordsList, originalSentence);
      wordsList.removeIf(item -> item == null || "".equals(item));
      Collections.swap(wordsList, 0, wordsList.size()-1);
      for (String line : wordsList){
         System.out.println(line);
      }
   }

   public void alphabetOrder(List <String> sortList){
      Collections.sort(sortList);
      String letter = " Letter".substring(0, 1);
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
      switch (Character.toLowerCase(incomingText.charAt(0))) {
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

   public Map<Integer, String> getSentenceOrderMap() {
      return sentenceOrderMap;
   }

   public void setSentenceOrderMap(Map<Integer, String> sentenceOrderMap) {
      this.sentenceOrderMap = sentenceOrderMap;
   }
}





