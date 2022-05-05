package test;

import pojo.Dog;

import java.util.Collection;

public class Hello1 implements Hello<Dog>{

    @Override
    public Collection<Dog> test1(Collection<Dog> c, Predicate<Dog> p) {

        return null;
    }
}
