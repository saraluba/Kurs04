import java.util.HashMap;

public class Counter {
    public static void main(String[] args) {
        String text = "This is a test text";
        String[] word = text.split("");
        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            if(!word[i].isBlank()) {
                if (!counter.containsKey(word[i])) {
                    counter.put(word[i], 1);
                } else {
                    counter.put(word[i], counter.get(word[i]) + 1);
                }
            }
        }

        for (String key: counter.keySet()) {
            String value = counter.get(key).toString();
            System.out.print(key+ "-"+ value +" ");
        }
    }
}
