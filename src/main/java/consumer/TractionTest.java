package consumer;

import org.junit.Test;
import sun.plugin2.applet.StopListener;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.StreamHandler;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.*;


public class TractionTest {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

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

    // 自定义toList
    @Test
    public void test41() {
        Stream<Dish> stream = menu.stream();
        List<Dish> collect = stream.filter(e->e.getCalories()>400).collect(new ToListCollector<Dish>());
        System.out.println(collect);
    }

    @Test
    public void test40() {
        Map<Boolean, Long> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(collect);
    }
    @Test
    public void test39() {
//        menu.stream().collect(partitioningBy(Dish::isVegetarian,partitioningBy(Dish::getType)))
    }

    @Test
    public void test38() {
        Map<Boolean, Map<Boolean, List<Dish>>> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));
        System.out.println(collect);
    }

    @Test
    public void test37() {
        Map<Boolean, Dish> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect);
    }

    @Test
    public void test36() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect = menu.stream().collect(groupingBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(collect);
    }

    @Test
    public void test35() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(collect);
    }

    @Test
    public void test34() {
        Map<Boolean, List<Dish>> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(collect);
        System.out.println("======================================");
        List<Dish> dishes = collect.get(true);
        System.out.println(dishes);
        System.out.println("-----------------------------------------------");
        List<Dish> collect1 = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(collect1);
    }

    @Test
    public void test33() {
        Map<Dish.Type, HashSet<Dish.CaloricLevel>> collect = menu.stream().collect(groupingBy(Dish::getType, mapping(d -> {
                    if (d.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (d.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                },
                toCollection(HashSet::new))
        ));
        System.out.println(collect);
    }

    @Test
    public void test32() {
        Map<Dish.Type, Set<Dish.CaloricLevel>> collect = menu.stream().collect(groupingBy(Dish::getType, mapping(d -> {
                    if (d.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (d.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                },
                toSet())
        ));
        System.out.println(collect);
    }

    @Test
    public void test31() {
        Map<Dish.Type, Integer> collect = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(collect);
    }


    @Test
    public void test30() {
        Map<Dish.Type, Dish> collect = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(collect);
    }

    @Test
    public void test29() {
        Map<Dish.Type, Dish> collect = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(collect);
    }

    @Test
    public void test28() {
        Map<Dish.Type, Dish> collect = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(collect);
    }

    @Test
    public void test27() {
//        Map<Dish.Type, Optional<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
        Map<Dish.Type, Optional<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(collect);
    }

    @Test
    public void test26() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType, Collectors.toList()));
        System.out.println(collect);
    }

    @Test
    public void test25() {
        Map<Dish.Type, Long> collect = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(collect);
    }

    @Test
    public void test24() {

        Map<Dish.Type, Map<Dish.CaloricLevel, Map<Boolean, List<Dish>>>> collect = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return Dish.CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return Dish.CaloricLevel.NORMAL;
            } else return Dish.CaloricLevel.FAT;
        }, groupingBy(Dish::isVegetarian))));
        System.out.println(collect);
    }

    @Test
    public void test23() {
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> collect = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return Dish.CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return Dish.CaloricLevel.NORMAL;
            } else return Dish.CaloricLevel.FAT;
        })));
        System.out.println(collect);
    }

    @Test
    public void test22() {
        Map<Dish.Type, Map<String, List<Dish>>> collect = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return "节食";
            } else if (dish.getCalories() <= 700) {
                return "正常";
            } else return "肥胖";
        })));
        System.out.println(collect);
    }

    @Test
    public void test21() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(collect);
    }

    @Test
    public void test20() {
        Integer integer = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println("reduce:" + integer);

        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("sum:" + sum);

    }

    @Test
    public void test19() {
        Integer collect = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(collect);

    }


    @Test
    public void test18() {
        String collect = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(collect);

    }

    @Test
    public void test17() {
        Double collect = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(collect);

    }

    @Test
    public void test16() {
        Comparator<Dish> comparing = Comparator.comparing(Dish::getCalories);
        Optional<Dish> collect = menu.stream().collect(maxBy(comparing));
        Optional<Dish> collect1 = menu.stream().collect(minBy(comparing));
        if (collect.isPresent()) {
            Dish dish = collect.get();
            System.out.println(dish.getCalories());
        }
    }

    @Test
    public void test15() {
        Integer collect = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(collect);
    }

    @Test
    public void test14() throws IOException {

        long uniqueWords = 0;

        Stream<String> lines = Files.lines(Paths.get("D:\\Users\\YuequanHuabai\\Desktop\\test.sql"), Charset.defaultCharset());
//        long count = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
//        System.out.println(count);
        lines.forEach(System.out::println);

    }

    @Test
    public void test13() {

        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        stream.limit(5).forEach(e -> System.out.println(e[0] + "," + e[1] + "," + e[2]));

    }

    @Test
    public void test12() {
//       IntStream.rangeClosed(1,100).filter(x->x%2==0).forEach(System.out::println);

        IntStream.range(1, 100).filter(x -> x % 2 == 0).forEach(System.out::println);

    }

    @Test
    public void test11() {
        int i = menu.stream().mapToInt(Dish::getCalories).max().orElse(1);
        int i1 = new ArrayList<Dish>().stream().mapToInt(Dish::getCalories).max().orElse(1);
//        System.out.println(i1);

        System.out.println(i);

    }

    @Test
    public void test10() {
        menu.stream().mapToInt(Dish::getCalories).boxed().forEach(System.out::println);

    }

    @Test
    public void test9() {
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);
    }

    //8. 找到交易额最小的交易。
    @Test
    public void test8() {
        Optional<Integer> min = transactions.stream().map(Transaction::getValue).max((x, y) -> x < y ? x : y);
    }

    //7. 所有交易中，最高的交易额时多少？
    @Test
    public void test7() {
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
    }

    // 6.打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6() {
        transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);
    }

    // 5.有没有交易员时在米兰工作的？
    @Test
    public void test5() {
//        Optional<Transaction> milan = transactions.stream().filter(e -> e.getTrader().getCity().equals("Milan")).findAny();
        boolean milan = transactions.stream().anyMatch(e -> e.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    // 4.返回所有交易员的姓名字符串，按字母顺序排序。
    @Test
    public void test4() {
//
//        Set<String> collect = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().collect(Collectors.toSet());
//        String collect = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().collect(Collectors.joining(" "));
        String collect = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().collect(Collectors.joining());
        System.out.println(collect);
    }


    // 3.查找所有来自剑桥的交易员，并按姓名排序。
    @Test
    public void test3() {
        Set<Trader> cambridge = transactions
                .stream()
                .map(e -> e.getTrader())
                .filter(e -> e.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toSet());
        System.out.println(cambridge);
        System.out.println("-===");

    }

    // 2. 交易员在哪些不同的城市工作过
    @Test
    public void test2() {
        List<String> collect = transactions.stream().map(Transaction::getTrader).map(e -> e.getCity()).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    // 1. 找出2011年发生的所有交易，并按交易额排序(从高到低)
    @Test
    public void test1() {
        List<Transaction> collect = transactions.stream().filter(e -> e.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(collect);
    }

}
