package hasses.magical.animalfarms;

import hasses.magical.animalfarmfactoryframework.AnimalFarm;
import hasses.magical.animalfarmfactoryframework.annotations.GetByFixedName;
import hasses.magical.animalfarmfactoryframework.annotations.GetByName;
import hasses.magical.animalfarmfactoryframework.annotations.AnimalCount;

public interface PigFarm extends AnimalFarm<Pig> {

    @AnimalCount()
    int getPigCount();

    @GetByFixedName(fixedName = "MrBacon")
    Pig getPigNamedMrBacon();

    @GetByName
    Pig getPigByName(String name);
}
