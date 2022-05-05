package consumer;

import pojo.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Test111 {


    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i :
                list) {
            c.accept(i);

        }
    }




    public static <T> void con(List<T> list, Consumer<T> c) {

        BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction = Integer::parseInt;

        BiFunction<List, Object, Boolean> listObjectBooleanBiFunction = List::contains;
        List<String> sList = new ArrayList<>();

        Supplier<Dog>  supplier= Dog::new;
        Dog dog = supplier.get();

        Supplier<Dog> supply = () -> new Dog();
        Dog dog1 = supply.get();


    }


    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {

        List<R> result = new ArrayList<>();
        for (T s :
                list) {
            result.add(f.apply(s));
        }
        return result;
    }




    public static void main(String[] args) {

//        forEach(
//                Arrays.asList(1,2,3,4,5),
//                (Integer i)-> System.out.println(i)
//        );

//        List<Integer> map = map(Arrays.asList("args","asdfkasldf","asdfxc","asdf23"), (String s) -> s.length());
//
//        System.out.println(map);

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(i);
//        }
//        System.out.println(list);

        IntPredicate evenNumber = (int i) -> i % 2 == 0;
        boolean test = evenNumber.test(100);


    }


}
