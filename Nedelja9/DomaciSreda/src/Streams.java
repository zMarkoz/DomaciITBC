import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    // 1. Zadatak

    public static List<Integer> addToDivBy3(List<Integer> numbers) {

        List<Integer> list = numbers.stream().map(x -> x % 3 == 0 ? x + 2 : x).collect(Collectors.toList());

        return list;
    }
    

    // 2. Zadatak

    public static List<Integer> filterDivBy3(List<Integer> numbers) {

        List<Integer> list = numbers.stream().map(x -> x * 2).filter(x -> x % 3 == 0).collect(Collectors.toList());

        return list;
    }


    // 3. Zadatak

    public static List<Integer> multiplay(List<Integer> numbers) {

        List<Integer> multiplay = numbers.stream().map(x -> x % 2 != 0 ? x * 2 : x).collect(Collectors.toList());
        HashSet<Integer> set = new HashSet<>(multiplay);
        ArrayList<Integer> list = new ArrayList(set);

        return list;
    }


    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(4, 3, 5, 6, 7);
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);

        System.out.println(addToDivBy3(num));

        System.out.println(filterDivBy3(num));

        System.out.println(multiplay(num));

        System.out.println(addToDivBy3(numbers));

        System.out.println(filterDivBy3(numbers));

        System.out.println(multiplay(numbers));
    }
}


