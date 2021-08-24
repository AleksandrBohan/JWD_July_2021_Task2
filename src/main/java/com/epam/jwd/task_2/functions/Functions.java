package com.epam.jwd.task_2.functions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Functions {

   public void alphabetOrder(List <String> sortList){
      Collections.sort(sortList);
      String letter = sortList.get(0).substring(0, 1);
      boolean redline = true;
      for (int i = 0; i < sortList.size(); i++) {
         if (sortList.get(i).equals("\\s") && sortList.size() > i && sortList.get(i).equals()){
            i++;
         }
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





