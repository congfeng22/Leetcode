import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString151 {
    public String reverseWords(String s) {
        String[] sentence = s.split(" ");
        String temp;
        List<String> sentence2 = new ArrayList<>();
        for (String word : sentence) if (!word.equals("")) sentence2.add(word);
        for (int i=0;i<sentence2.size()/2;i++){
            temp = sentence2.get(i);
            sentence2.set(i,sentence2.get(sentence2.size()-1-i));
            sentence2.set(sentence2.size()-1-i,temp);
        }
        return String.join(" ",sentence2);
    }
}
