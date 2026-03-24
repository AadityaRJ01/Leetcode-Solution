import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList(
            'q','w','e','r','t','y','u','i','o','p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList(
            'a','s','d','f','g','h','j','k','l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList(
            'z','x','c','v','b','n','m'));
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            
            Set<Character> row = row1.contains(lower.charAt(0)) ? row1 :
                                 row2.contains(lower.charAt(0)) ? row2 : row3;
            
            boolean valid = true;
            
            for (char c : lower.toCharArray()) {
                if (!row.contains(c)) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) result.add(word);
        }
        
        return result.toArray(new String[0]);
    }
}