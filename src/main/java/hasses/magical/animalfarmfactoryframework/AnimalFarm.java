package hasses.magical.animalfarmfactoryframework;

import java.util.List;

/*
This interface has a couple of interesting features (i believe most of you are familiar with). Like the diamond that let
us specify the class of animals for wish we intend to use this farm. Much like List's and Map's etc. In this case we
also specify that not any old Class won't do but rather a descendent of the Animal interface
 */
public interface AnimalFarm<T extends Animal> {
    T getFirst();

    List<T> getAll();

    int add(T animal);

}
