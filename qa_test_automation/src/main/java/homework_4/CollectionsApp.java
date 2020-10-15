package homework_4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsApp {
    public static void main(String[] args) {
        List<Integer> sequentialNumbers = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
        List<Integer> randomOrderCollection = getCollectionInRandomOrder(sequentialNumbers);
        checkForDuplicates(randomOrderCollection);

        List<Integer> divisibleBy2 = takeAndRemoveDivisibleBy(randomOrderCollection, 2);
        List<Integer> divisibleBy3 = takeAndRemoveDivisibleBy(randomOrderCollection, 3);
        List<Integer> divisibleBy5 = takeAndRemoveDivisibleBy(randomOrderCollection, 5);
        List<Integer> divisibleBy7 = takeAndRemoveDivisibleBy(randomOrderCollection, 7);
    }

    private static List<Integer> getCollectionInRandomOrder(List<Integer> sourceCollection){
        List<Integer> resultCollection = new ArrayList<>(sourceCollection);
        Collections.shuffle(resultCollection);
        return resultCollection;
    }

    public static void checkForDuplicates(List<Integer> sourceCollection){
        Set<Integer> uniqueValuesOnly = new HashSet<Integer>(sourceCollection);
        if(uniqueValuesOnly.size() != sourceCollection.size()){
            System.out.println("There are duplications in collection");
        } else {
            System.out.println("All values in collection are unique");
        }
    }

    public static List<Integer> takeAndRemoveDivisibleBy(List<Integer> sourceCollection, int divisor) {
        List<Integer> divisibleValues = sourceCollection
                .stream()
                .filter(number -> number % divisor == 0)
                .collect(Collectors.toList());
        sourceCollection.removeAll(divisibleValues);
        return divisibleValues;
    }
}
