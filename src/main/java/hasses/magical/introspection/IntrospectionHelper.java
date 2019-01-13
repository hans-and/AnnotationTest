package hasses.magical.introspection;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 *I haven't checked but my guess is that there is a third party library doing this and much more, but for the sake of
 * this example this should bee easy to follow and seems to work for my test
 */
public class IntrospectionHelper {

    /**
     * @param methodA candidate for comparing
     * @param methodB
     * @return true if method A and B has same: name, returnType and Arguments
     */
    public boolean isSameSignature(Method methodA, Method methodB) {

        return hasSameParamSignatureAndReturnType(methodA, methodB) && hasSameMethodName(methodA, methodB);
    }



    private boolean hasSameParamSignature(Method methodA, Method methodB) {
        boolean result = false;
        if (allAssigned(methodA, methodB)) {
            List<Type> parameterTypesA = Arrays.asList(methodA.getParameterTypes());
            List<Type> parameterTypesB = Arrays.asList(methodB.getParameterTypes());
            if (parameterTypesA.size() == parameterTypesB.size()) {
                result = true;
                for (int i = 0; i < parameterTypesB.size(); i++) {
                    if (!parameterTypesA.get(i).equals(parameterTypesB.get(i))) {
                        result = false;
                        break;
                    }
                }
            }

        }
        return result;
    }

    private boolean hasSameMethodName(Method methodA, Method methodB) {
        if (!allAssigned(methodA, methodB)) {
            return false;
        }
        return methodA.getName().equals(methodB.getName());
    }

    private boolean hasSameParamSignatureAndReturnType(Method methodA, Method methodB) {

        return hasSameParamSignature(methodA, methodB) && hasSameReturnType(methodA, methodB);
    }

    private boolean hasSameReturnType(Method methodA, Method methodB) {
        boolean result = false;
        if (allAssigned(methodA, methodB)) {

            Type rtA = methodA.getReturnType();
            Type rtB = methodB.getReturnType();
            if (allIsNull(rtA, rtB)) {
                result = true;
            } else {
                if (allAssigned(rtA, rtB)) {
                    result = rtA.equals(rtB);
                }
            }
        }

        return result;
    }


    private boolean allAssigned(Object... objects) {
        if (objects == null || objects.length == 0) {
            return false;
        }
        for (Object o : objects) {
            if (o == null) {
                return false;
            }
        }
        return true;
    }

    private boolean allIsNull(Object... objects) {
        if (objects == null || objects.length == 0) {
            return true;
        }
        for (Object o : objects) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }
}
