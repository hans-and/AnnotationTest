package hasses.magical.animalfarmfactoryframework;

import hasses.magical.animalfarmfactoryframework.annotations.GetByFixedName;
import hasses.magical.animalfarmfactoryframework.annotations.GetByName;
import hasses.magical.animalfarmfactoryframework.annotations.AnimalCount;
import hasses.magical.introspection.IntrospectionHelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * The newProxyInstance method of Proxy returns a class that safely can be cast to the class T.
 * As long as our InvocationHandler, sent in as an Argument can handel any methods in class T.
 * In this example we implement the InvocationHandler anonymously (makes sense since that interface only has one method)
 *
 * When that method is called we go thru the annotations of the method where supposed to emulate and see if it matches
 * any of the annotations we have available implementations for. In a sane real world application we should of course
 * checked that return types and argument matches and thrown some fancy exceptions on mismatch.
 *
 * If the method does not have Annotations or at least no one that we recognize whe start examine if our internalFarm
 * has a method exactly matching the one where supposed to emulate, and if so uses that.
 *
 * And lastly if there is no match we throw an exception
 *
 * @param <T> The Class/Interface of Animal farm we are implementing
 * @param <A> The Class of Animal's handled by the farm
 */
public abstract class AnimalFarmFactory<T extends AnimalFarm, A extends Animal> {

    private final IntrospectionHelper introspectionHelper = new IntrospectionHelper();


    public AnimalFarmFactory() {

    }

    public T newFarmInstance(List<A> animals) {
        T result;
        final AnimalFarmImp internalFarm = new AnimalFarmImp(animals);
        result = (T) java.lang.reflect.Proxy.newProxyInstance(getFactoryClass().getClassLoader(),
                new Class[]{getFactoryClass()}, new java.lang.reflect.InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        for (Annotation lAnnotation : method.getAnnotations()) {
                            if (lAnnotation instanceof AnimalCount) {
                                return internalFarm.getAnimalCount();
                            }else if (lAnnotation instanceof GetByFixedName) {
                                String name = ((GetByFixedName) lAnnotation).fixedName();
                                return internalFarm.getAnimalByName(name);
                            }else if (lAnnotation instanceof GetByName) {
                                return internalFarm.getAnimalByName((String) args[0]);
                            }
                        }
                        for (Method lMethod : internalFarm.getClass().getMethods()) {
                            if (introspectionHelper.isSameSignature(lMethod, method)) {
                                return lMethod.invoke(internalFarm, args);
                            }
                        }

                        throw new RuntimeException("Unable to invoke:"+method+" of: "+proxy);
                    }
                }


        );
        return result;
    }

    protected abstract Class<T> getFactoryClass();

}
