import hasses.magical.animalfarms.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AnimalFarmFactoryTest {

    private PigFarm pigFarm;

    private CatFarm catFarm;

    @org.junit.Before
    public void init() {

        pigFarm = new PigFarmFactory().newFarmInstance(getSomePigs());
        catFarm = new CatFarmFactory().newFarmInstance(getSomeCats());
    }

    @org.junit.Test
    public void testPigFarm() {
        testPigFarmGetFirst();
        testGetPigMrBacon();
        String newPigName = "Mr Pink";
        testNumbersAndAdd(newPigName);
        testGetPigByName(newPigName);
        List<Pig> allPigs = testGetAllPigs();
        testGetFirstPig(allPigs.get(0));
    }

    private void testGetFirstPig(Pig candidate) {
        Pig firstPig = pigFarm.getFirst();
        Assert.assertEquals(firstPig, candidate);
    }


    private List<Pig> testGetAllPigs() {
        List<Pig> result = pigFarm.getAll();
        Assert.assertEquals(result.size(), pigFarm.getPigCount());
        return result;
    }

    private void testGetPigByName(String newPigName) {
        Pig lpig = pigFarm.getPigByName(newPigName);
        Assert.assertEquals(newPigName, lpig.getName());
    }

    private void testGetPigMrBacon() {
        Pig mrBacon = pigFarm.getPigNamedMrBacon();
        Assert.assertEquals("MrBacon", mrBacon.getName());
    }

    private void testPigFarmGetFirst() {
        Pig pig = pigFarm.getFirst();
        Assert.assertNotNull(pig);
    }


    private void testNumbersAndAdd(String pName) {
        int noOfPigs = pigFarm.getPigCount();
        pigFarm.add(new Pig(pName));
        int moreNoOfPigs = pigFarm.getPigCount();
        Assert.assertEquals(noOfPigs, moreNoOfPigs - 1);
    }


    private List<Pig> getSomePigs() {
        List<Pig> pigs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            pigs.add(new Pig("Piglet" + (i + 1)));
        }
        pigs.add(new Pig("MrBacon"));
        return pigs;
    }

    @org.junit.Test
    public void testCatFarm() {
        Cat crazze = catFarm.getCatNamedCrazze();
        Assert.assertEquals("Crazze", crazze.getName());
        Cat missElliot = catFarm.getCatNamedMissElliot();
        Assert.assertEquals("MissElliot", missElliot.getName());
        Cat pelle = catFarm.getCatByName("Pelle");
        Assert.assertEquals("Pelle", pelle.getName());
    }

    private List<Cat> getSomeCats() {
        List<Cat> cats = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            cats.add(new Cat("Måns" + (i + 1)));
        }
        cats.add(new Cat("Pelle"));
        cats.add(new Cat("Gullan av Arkadien"));
        cats.add(new Cat("Sally"));
        cats.add(new Cat("Crazze"));
        cats.add(new Cat("Mjau"));
        cats.add(new Cat("MissElliot"));
        return cats;
    }
}