package comparator;

import java.util.*;

public class CompareByFirstConsonant implements Comparator<String> {
    private final static Comparator<String> instance = new CompareByFirstConsonant();
    private final static String CONSONANTS = "BCDFGHJKLMNPQRSTVXZWY" +
            "bcdfghjklmnpqrstvxzwy" +
            "йцкнгшщзхъфвпрлджчсмтьб" +
            "ЙЦКНГШЩЗХЪФВПРЛДЖЧСМТЬБ";

    public static Comparator<String> getInstance() {
        return instance;
    }

    public static boolean isConsonant(Character c) {
        return CONSONANTS.indexOf(c) > -1;
    }

    private Character getFirstConsonant(String string) {
        for (int i = 0; i < string.length(); ++i)
            if (isConsonant(string.charAt(i)))
                return string.charAt(i);
        return Character.MIN_VALUE;
    }

    @Override
    public int compare(String a, String b) {
        Character consonantA = getFirstConsonant(a);
        Character consonantB = getFirstConsonant(b);
        return consonantA.compareTo(consonantB);
    }



    public static boolean startsWithVovel(String s) {
        return s.length() > 0 && !CompareByFirstConsonant.isConsonant(s.charAt(0));
    }
    public static void main(String[] args) {
        String text = "Лето gg pop uhwri adfn knшгру оыват вт аот вав";
        List<String> words = new LinkedList<String>(Arrays.asList(text.split("[\\s\\p{Punct}]+")));
        Collections.sort(words, CompareByFirstConsonant.getInstance());

        for (ListIterator<String> iterator = words.listIterator(); iterator.hasNext(); ) {
            if (!startsWithVovel(iterator.next()))
                iterator.remove();
        }

        System.out.println(words);
    }
}
