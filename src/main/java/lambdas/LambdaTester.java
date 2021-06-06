package lambdas;

import java.util.function.Function;

public class LambdaTester {
    public static void main(String[] args) {
        String text = "Hello world";
        Function<String, String> stringToUpper = t -> {return t.toUpperCase();};
        Function<String, String> stringToLower = t -> { return t.toLowerCase();};
        Function<String, String> stringFirstLetter = t -> {return String.valueOf(t.charAt(0));};
        Function<String, String> stringLastLetter  = t -> {return String.valueOf(t.charAt(t.length()-1));};
        System.out.println(modifyString(text, stringToUpper));
        System.out.println(modifyString(text, stringToLower));
        System.out.println(modifyString(text, stringFirstLetter));
        System.out.println(modifyString(text, stringLastLetter));
        System.out.println("-----------------");
        Function<String, Integer> stringLength = t -> {return t.length();};
        Function<String,Integer> stringCountWords = t -> {return t.split(" ").length;};
        System.out.println(modifyStringToInt(text, stringLength));
        System.out.println(modifyStringToInt(text, stringCountWords));
    }

    protected static String modifyString(String text, Function<String, String> f){
        return f.apply(text);
    }

    protected static Integer modifyStringToInt(String text, Function<String, Integer> f){
        return f.apply(text);
    }

}
