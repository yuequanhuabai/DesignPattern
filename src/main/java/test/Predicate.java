package test;

import java.util.Collection;

@FunctionalInterface
public interface Predicate <T>{
    boolean test(T t);

//    boolean test1(T t);

//    static <T>Collection<T> filter (Collection<T>c,Predicate<T> p);

}
