import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {

        Consumer<String> printTheParts = sentence -> {
            String[] parts = sentence.split(" ");
            for(String s : parts){
                System.out.println(s);
            }
        };
        printTheParts.accept("Let's split this up into an array");



        System.out.println("--------------");



        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        printWordsForEach.accept("Let's split this up into an array");



        System.out.println("--------------");



        Consumer<String> printWordsConcise = sentence ->
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));

        printWordsConcise.accept("Let's split this up into an array");



        System.out.println("--------------");


        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));



        System.out.println("--------------");



        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));



        System.out.println("--------------");


        Supplier<String> iLoveJava = () -> "I love Java";
        System.out.println(iLoveJava.get());
    }
    public static String everySecondCharacter(UnaryOperator<String> func, String source){
        return func.apply(source);
    }
}
