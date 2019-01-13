package hasses.magical.animalfarmfactoryframework;

import java.util.List;

/**
 * Implement all AnimalFarm method's + methods that can be used by a proxy Instantiations  of interfaces extending
 * AnimalFarm and making use of the hasses.magical.animalfarmfactoryframework.annotations.*
 * @see hasses.magical.animalfarms.PigFarm or
 * @see hasses.magical.animalfarms.CatFarm for known impementations
 * @see AnimalFarmFactory for details on how java.lang.reflect.Proxy.newProxyInstance is used for creating a instance of
 * such interfaces
 * @param <T>
 */
public class AnimalFarmImp<T extends Animal> implements AnimalFarm {


    List<T> fAnimals;

    public AnimalFarmImp(List<T> animals) {
        fAnimals = animals;
    }

    int getAnimalCount() {
        return fAnimals.size();
    }

    @Override
    public T getFirst() {
        if (fAnimals.iterator().hasNext()) {
            return fAnimals.iterator().next();
        } else {
            return null;
        }
    }

    @Override
    public List getAll() {
        return fAnimals;
    }


    @Override
    public int add(Animal animal) {
        fAnimals.add((T)animal);
        return fAnimals.size();
    }



    T getAnimalByName(String name) {
        for (T lAnimal : fAnimals) {
            if (lAnimal.getName().equalsIgnoreCase(name)) {
                return lAnimal;
            }
        }
        return null;
    }


}
