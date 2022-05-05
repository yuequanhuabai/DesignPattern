package consumer;

import design.Predicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test222 {

    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    // 规约方法的优势与并行化。
    @Test
    public void test24() {
        Integer reduce = menu.parallelStream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println(reduce);

    }

    @Test
    public void test23() {
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
//        Optional<Integer> reduce = list.stream().reduce(Integer::max);
//        if(reduce.isPresent()) {
//            Integer integer = reduce.get();
//            System.out.println(integer);
//        }

        Optional<Integer> reduce = list.stream().reduce((x, y) -> x > y ? x : y);
        if(reduce.isPresent()) {
            Integer integer = reduce.get();
            System.out.println(integer);
        }


    }

    @Test
    public void test22() {
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Integer reduce = list.stream().reduce(0, Integer::sum);
//        Integer reduce = list.stream().reduce(0, Integer::intValue);
        System.out.println(reduce);

    }
    @Test
    public void test21() {
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
        Integer integer=null;
        if (reduce.isPresent()) {
             integer = reduce.get();
        }
        System.out.println(integer);

    }

    @Test
    public void test20() {
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

    }

    @Test
    public void test19() {
        Optional<Dish> first = menu.stream().filter(e -> e.getCalories() < 700).findFirst();
    if(first.isPresent()){
        Dish dish = first.get();
        System.out.println(dish);
    }

    }

    @Test
    public void test18() {
        Optional<Dish> any = menu.stream().filter(e -> e.getCalories() < 700).findAny();
        if(any.isPresent()){
            Dish dish = any.get();
            System.out.println(dish);
        }
//        System.out.println(b);

    }

    @Test
    public void test17() {
        boolean b = menu.stream().noneMatch(e -> e.getCalories() > 1000);
        System.out.println(b);

    }

    @Test
    public void test16() {
        boolean b = menu.stream().allMatch(e -> e.getCalories() < 1000);
        System.out.println(b);

    }
    @Test
    public void test15() {
        boolean b = menu.stream().anyMatch(Dish::isVegetarian);
        System.out.println(b);

    }

    @Test
    public void test14() {
        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList( 3,4);
        Predicate predicate =j->Integer.parseInt(j.toString())%3==0;

        List<int[]> collect = integers2.stream().flatMap(e -> integers1.stream().filter(j -> (e + j) % 3 == 0).map(j -> new int[]{e, j})).collect(Collectors.toList());
//        List<int[][]> collect = integers1.stream().flatMap(e -> integers2.stream().map(j -> new int[][]{{e}, {j}})).collect(Collectors.toList());
        System.out.println(collect);


    }

    @Test
    public void test13() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList( 3,4);

        List<int[][]> collect = list1.stream().flatMap(e -> list2.stream().map(j -> new int[e][j])).collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void test12() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = list.stream().map(e -> e * e).collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void test11() {
        List<String> strings = Arrays.asList("Java8", "lambda", "In", "Action");
        List<String> collect = strings.stream().map(e -> e.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test10() {
        List<String> strings = Arrays.asList("Java8", "lambda", "In", "Action");
        List<Stream<String>> collect = strings.stream().map(e -> e.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test9() {
        List<String> strings = Arrays.asList("Java8", "lambda", "In", "Action");
        List<String[]> collect = strings.stream().map(e -> e.split("")).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test8() {
        List<String> strings = Arrays.asList("Java8", "lambda", "In", "Action");
        List<Integer> collect = strings.stream().map(String::length).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test7() {
        List<Dish> collect = menu.stream().filter(e -> e.getType()==(Dish.Type.MEAT)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test6() {
        List<Dish> collect2 = menu.stream().filter(e -> e.getCalories() > 300).collect(Collectors.toList());
        List<Dish> collect = menu.stream().filter(e -> e.getCalories() > 300).skip(3).collect(Collectors.toList());
        List<Dish> collect1 = menu.stream().filter(e -> e.getCalories() > 300).limit(3).collect(Collectors.toList());
        System.out.println(collect2);
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println("====");
    }




    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 2, 4);
        list.stream().filter(i->i%2==0).distinct().forEach(System.out::println);
    }

    @Test
    public void test4() {
        long count = menu.stream().filter(e -> e.getCalories() > 300).distinct().limit(3).count();
    }

    @Test
    public void test3() {
        menu.stream().filter(e -> {
            System.out.println("filtering:" + e.getName());
            return e.getCalories() > 300;
        }).map(e -> {
            System.out.println("mapping: " + e.getName());
            return e.getName();
        }).limit(3).collect(Collectors.toList());

    }

    @Test
    public void test2() {
        List<String> title = Arrays.asList("java8", "In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);

    }

    @Test
    public void test1() {
        System.out.println("===");
        List<String> collect = menu.stream().filter(e -> e.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(collect);

    }


}
