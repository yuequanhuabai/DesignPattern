package test;

import pojo.Dog;

public class DogAgePredicate implements DogPredicate{

    @Override
    public boolean test(Dog dog) {
        return dog.getAge()>5;
    }
}
