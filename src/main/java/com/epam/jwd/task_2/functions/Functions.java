package com.epam.jwd.task_2.functions;

import com.epam.jwd.task_2.parsers.WordParser;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;


public class Functions {

   private List<String> sentenceOrderList = new ArrayList<>();

   private List<String> wordsList = new ArrayList<>();

   private List<String> originalText = new ArrayList<>();

   private List<String> originalSentence = new ArrayList<>();

   public  <K, V extends Comparable<? super K>>
   Map<Integer, String> sortMapByValue(Map<Integer, String> map) {

      Map<Integer,String> orderMap = new LinkedHashMap<>();
      Stream<Map.Entry<Integer, String>> st = map.entrySet().stream();

      st.sorted(Comparator.comparing(e -> e.getKey()))
              .forEach(e ->orderMap.put(e.getKey(),e.getValue()));

      orderMap.entrySet()
              .stream()
              .forEach(System.out::println);


      return orderMap;
   }

   public void reverseWords(String sentence) {
      String sentenceWithoutSpaces = sentence.trim();

      new WordParser().sentenceParser(sentenceWithoutSpaces, wordsList, originalSentence);

      wordsList.removeIf(item -> item == null || "".equals(item));

      Collections.swap(wordsList, 0, wordsList.size()-1);

      for (String line : wordsList){
         System.out.print("  " + line + "  ");
      }
   }


   public String formatText(String incomingText, int sizeOfWords) {
      StringBuilder sb = new StringBuilder();

      if ((incomingText.length() / sizeOfWords != 0)
              && isVowel(incomingText)) {

         sb.append(incomingText).append(" ");

      }

      String outText = sb.toString();

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

   public List<String> getSentenceOrderList() {
      return sentenceOrderList;
   }

   public void setSentenceOrderList(List<String> sentenceOrderList) {
      this.sentenceOrderList = sentenceOrderList;
   }

   public List<String> getWordsList() {
      return wordsList;
   }

   public void setWordsList(List<String> wordsList) {
      this.wordsList = wordsList;
   }

   public List<String> getOriginalText() {
      return originalText;
   }

   public void setOriginalText(List<String> originalText) {
      this.originalText = originalText;
   }

   public List<String> getOriginalSentence() {
      return originalSentence;
   }

   public void setOriginalSentence(List<String> originalSentence) {
      this.originalSentence = originalSentence;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Functions functions = (Functions) o;
      return Objects.equals(sentenceOrderList, functions.sentenceOrderList) &&
              Objects.equals(wordsList, functions.wordsList) &&
              Objects.equals(originalText, functions.originalText) &&
              Objects.equals(originalSentence, functions.originalSentence);

   }

   @Override
   public int hashCode() {
      return Objects.hash(sentenceOrderList, wordsList, originalText, originalSentence);
   }

   @Override
   public String toString() {
      return "Functions{" +
              "sentenceOrderList=" + sentenceOrderList +
              ", wordsList=" + wordsList +
              ", originalText=" + originalText +
              ", originalSentence=" + originalSentence +
              '}';
   }
}





