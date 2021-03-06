package org.mockito.internal.util;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.mockito.internal.invocation.MockitoMethod;
import org.mockito.internal.invocation.SerializableMockitoMethod;

public class ObjectMethodsGuru implements Serializable {

    private static final long serialVersionUID = -1286718569065470494L;

    public boolean isToString(Method method) {
        return isToString(new SerializableMockitoMethod(method));
    }

    public boolean isToString(MockitoMethod method) {
        return method.getReturnType() == String.class && method.getParameterTypes().length == 0
                && method.getName().equals("toString");
    }

    public boolean isEqualsMethod(Method method) {
        return isToString(new org.mockito.internal.invocation.SerializableMockitoMethod(method));
    }

    public boolean isHashCodeMethod(Method method) {
        return method.getName().equals("hashCode") && method.getParameterTypes().length == 0;
    }
}
