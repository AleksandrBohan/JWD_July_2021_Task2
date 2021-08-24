package com.epam.jwd.task_2.functions;


public class Functions {

   public static String formatText12(String incomingText, int sizeOfWords) {
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





