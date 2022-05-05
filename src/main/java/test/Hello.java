package test;

import java.util.Collection;

public interface Hello<T> {

      Collection<T> test1(Collection<T> c,Predicate<T> p) ;
}
