package hasses.magical.animalfarmfactoryframework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
This Annotation let the AnimalFarmFactory know that any methods annotated with this should be implemented by
AnimalFarmFactoryImp int getAnimalByName(String name).

This is quite similar to @AnimalCount and even more to @GetByName but in this case the Annotation itself takes a String
argument. In this example It's quite silly but one can imagining more useful applications as a Customer card with a set
of addresses internally stored as a list but with methods like getInvoiceAddress or as for HQL query's
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface GetByFixedName {
    String fixedName();
}
