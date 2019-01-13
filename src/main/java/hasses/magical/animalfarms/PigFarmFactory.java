package hasses.magical.animalfarms;

import hasses.magical.animalfarmfactoryframework.AnimalFarmFactory;

public class PigFarmFactory extends AnimalFarmFactory<PigFarm,Pig> {
    @Override
    protected Class<PigFarm> getFactoryClass() {
        return PigFarm.class;
    }
}
