package hasses.magical.animalfarms;

import hasses.magical.animalfarmfactoryframework.Animal;

import java.util.Objects;

public class Pig implements Animal {

    private String name;

    public Pig(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pig)) return false;
        Pig pig = (Pig) o;
        return Objects.equals(name, pig.name);
    }
}
