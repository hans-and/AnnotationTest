package hasses.magical.animalfarms;

import hasses.magical.animalfarmfactoryframework.AnimalFarmFactory;

/**
 * This could have been done in many other ways. One obvious approach being sending the in Class as a parameter to
 * AnimalFarmFactory making that class non abstract.
 */
public class CatFarmFactory extends AnimalFarmFactory<CatFarm,Cat> {
    @Override
    protected Class<CatFarm> getFactoryClass() {
        return CatFarm.class;
    }
}
