package test;

import pojo.Dog;

public class DogNamePredicate implements DogPredicate{
    @Override
    public boolean test(Dog dog) {
        return "DogA".equals(dog.getName());
    }
}
