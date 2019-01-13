package hasses.magical.animalfarms;

import hasses.magical.animalfarmfactoryframework.AnimalFarm;
import hasses.magical.animalfarmfactoryframework.annotations.GetByFixedName;
import hasses.magical.animalfarmfactoryframework.annotations.GetByName;

/**
 * We bind this interface to class Cat (making it a cat farm). We also make use of the annotations to let:
 * @see hasses.magical.animalfarmfactoryframework.AnimalFarmFactory bind any calls to the proxy instansiation of this
 * interface be relayed to the right method in:
 * @see hasses.magical.animalfarmfactoryframework.AnimalFarmImp
 */
public interface CatFarm extends AnimalFarm<Cat> {

    @GetByFixedName(fixedName = "MissElliot")
    Cat getCatNamedMissElliot();

    @GetByFixedName(fixedName = "Crazze")
    Cat getCatNamedCrazze();

    @GetByName
    Cat getCatByName(String name);

}
