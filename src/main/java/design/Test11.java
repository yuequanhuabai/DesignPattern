package design;

import org.junit.Test;
import pojo.Dog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static design.Predicate.filter;

public class Test11 {

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(5, "DogA"));
        list.add(new Dog(6, "DogB"));
        list.add(new Dog(7, "DogC"));

        List<Dog> filter = filter(list, (Dog dog) -> "DogA".equals(dog.getName()));
//        List<T> filter = filter(list, (Integer i) -> i % 2 == 0);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        List<Integer> filter1 = filter(numbers, (Integer i) -> i % 2 == 0);

        System.out.println(filter1);


    }

    @Test
    public void test1(){
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(5, "DogB"));
        list.add(new Dog(6, "DogA"));
        list.add(new Dog(7, "DogC"));

        list.sort(Comparator.comparing(Dog::getName).reversed());

        System.out.println(list);

        System.out.println("=======");


    }


}
