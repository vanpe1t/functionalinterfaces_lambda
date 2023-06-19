import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };

        System.out.println(predicate.test(2));
        System.out.println(predicate.test(-1));

        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Hello " + s);
                System.out.println(stringBuilder.toString());
            }
        };
        stringConsumer.accept("Ivan");

        Function<Double, Long> doubleLongFunction = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };

        System.out.println(doubleLongFunction.apply(12.5));

        Supplier<Integer> integerSupplier =  new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 10);
            }
        };

        System.out.println(integerSupplier.get());

        Supplier<Integer> integerSupplier1 = () -> (int) (Math.random() * 10);
        System.out.println(integerSupplier1.get());

        Function<Integer, Integer> IfTrue = (i) -> {
            return i + 1;
        };

        Function<Integer, Integer> IfFalse = (i) -> {
            return i - 1;
        };

        Predicate<Integer> predicateNew = (i) -> {
            return i > 0;
        };

        Function<Integer, Integer> function = ternaryOperator(predicateNew, IfTrue, IfFalse);
        System.out.println(function.apply(-10));

    }

    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
                                                        Function<? super T, ? extends U> ifTrue,
                                                        Function<? super T, ? extends U> ifFalse) {
        return (res) -> {
            U result = condition.test(res) ? ifFalse.apply(res) : ifTrue.apply(res);
            return result;
        };
    }

}
