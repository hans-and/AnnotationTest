package hasses.magical.animalfarmfactoryframework.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
This Annotation let the AnimalFarmFactory know that any methods annotated with this should be implemented by
AnimalFarmFactoryImp int getAnimalCount().

One could argue that it would have been just as nice to let the AnimalFarm have a getAnimalCount() and letting
AnimalFarmImp implement it. This way do have a couple of advantages thou. The user of the framework can choose to not
specify any such method as in the CatFarm example (Opting for better encapsulation). The user can also name that method
to any thing he wants as in the PigFarm example.

However since this framework does not come with a compile plugin we open up for some runtime problems like:
    @AnimalCount()
    String getPigNames();
(That would of course be caught during Unit tests)

The RetentionPolicy.RUNTIME of @Retention makes this meta attribute visible during runtime. Other policy's might be useful if writing
a compiler plugin, documentation plugins etc.

The ElementType.METHOD of @Target prevents users from trying things like:
@AnimalCount()
public interface PigFarm...

 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AnimalCount {
}