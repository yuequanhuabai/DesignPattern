package consumer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestCollection {
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

@Test
public void test2(){
//    System.out.println("Sequential sum done in:"+measureSumPerf(Parallel));

//    ParallelStream

    Integer reduce = menu.stream().filter(e -> e.getCalories() > 500)
            .sequential()
            .map(Dish::getCalories)
            .parallel()
            .reduce(0, (x, y) -> x + y);
    System.out.println(reduce);
}

public long measureSumPerf(Function<Long,Long> adder,long n){
    long fastest= Long.MAX_VALUE;

    for (int i = 0; i < 10; i++) {
        long start = System.nanoTime();

        Long sum = adder.apply(n);
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Result:"+sum);
        if(duration<fastest)fastest=duration;
    }

    return fastest;
}



    public void test1(){
        // 设置默认的线程数，默认并行为处理器数量。
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12");
        System.out.println("===");

    }


    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n)
                .reduce(0L, Long::sum);
    }


}
