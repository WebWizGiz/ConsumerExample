package operators.unary_operator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SequenceGenerator {
    private UnaryOperator<Integer> incrementByStep;    // --> Function<T, T> : 'T' is always the same
    private BinaryOperator<Integer> add;               // --> BiFunction<T, T> : 'T' is always the same

    //constructor
    public SequenceGenerator(int step) {
        this.incrementByStep = n -> n + step;
        this.add = Integer :: sum;
        // this.add = (x, y) -> x+y;
    }

    // method to generate and sum sequence
    public int generateAndSum(int start, int count){
        // Stream.iterate: Belirli bir başlangıç değeri ile başlayan bir dizi oluşturur.
        // limit: Belirli bir sayıda öğe ile sınırlar.
        // reduce: Bir akışı birleştirerek tek bir değer üretir.
        return Stream.iterate(start, incrementByStep)
                .limit(count)
                .reduce(0, add);
    }
}
