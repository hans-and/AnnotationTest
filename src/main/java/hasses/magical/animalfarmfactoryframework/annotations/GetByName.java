package hasses.magical.animalfarmfactoryframework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
This Annotation let the AnimalFarmFactory know that any methods annotated with this should be implemented by
AnimalFarmFactoryImp int getAnimalByName(String name).

Other than that the target method taking a parameter this works just as @AnimalCount

 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface GetByName {

}
