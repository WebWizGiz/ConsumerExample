package predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NumberFilterService {
    private Predicate<Integer> isEven;
    private BiPredicate<Integer, Integer> isEvenAndGreaterThan;

    //constructor
    public NumberFilterService() {
        this.isEven = n -> n % 2 == 0;  //means if ist true it returns true
        this.isEvenAndGreaterThan = (n, threshold) -> isEven.test(n) && n > threshold;   //it checks 2 conditions even and threshold, then create a stream
    }

    //method to filter numbers
    public List<Integer> filterNumbers(List<Integer> numbers, int threshold) {
        /*
         * numbers: [1,2,3,4,5,6,7,8] , threshold: 4
         * numbersStream: [1,2,3,4,5,6,7,8]
         * filteredNumbersStream: [6, 8]
         * filteredNumbers: [6, 8]
         * */

        /*
        *
        Stream<Integer> numbersStream = numbers.stream();
        List<Integer> filteredNumbersStream = (List<Integer>) numbersStream.filter(n -> isEvenAndGreaterThan.test(n, threshold));
        List<Integer> filteredNumbers = filteredNumbersStream.collect(Collectors.toList());

        return filteredNumbers;
        *
        * */

        return numbers.stream()
                .filter(n -> isEvenAndGreaterThan.test(n, threshold))
                .collect(Collectors.toList());
    }
}
