package com.function;

import com.example.lambda.Predicate;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by seokangchun on 2015. 10. 10..
 */
@Slf4j
public class FunctionInterfaceEx {

    public static void  main(String[] args) {

        final List<Integer> numbers = Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5);

        /**
         * function<String, Integer>
         */
        //final Function<String, Integer> toInt = value -> Integer.parseInt(value);
        final Function<String, Integer> toInt = Integer::parseInt;
        log.info("toInt : {}", toInt.apply("100"));


        /**
         * Consumer<T>
         */
        //final Consumer<String> print = value -> log.info(value);
        final Consumer<String> print = log::info;
        print.accept("Hello");

        /**
         * Predicate
         */
        log.info("positive integers" + filter(numbers, i -> i > 0));
        log.info("less than 3 integers" + filter(numbers, i -> i < 3));

        /**
         * Supplier
         */
        long start = System.currentTimeMillis();
        printIfValidIndex(1, () -> getVeryExpensiveValue() );
        //printIfValidIndex(-1, () -> getVeryExpensiveValue() );
        printIfValidIndex(-1, FunctionInterfaceEx::getVeryExpensiveValue);
        printIfValidIndex(-2, () -> getVeryExpensiveValue() );
        log.info("It took {}", ((System.currentTimeMillis() - start) / 1000) + " seconds.");
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList();
        for(T input: list) {
            if(filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }

    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if(number >= 0) {
            log.info("The value is {}", valueSupplier.get());
        } else {
            log.info("Invalid");
        }
    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "long time result";
    }
}
