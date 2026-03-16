package org.mockito.internal.stubbing.defaultanswers;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.reflection.GenericMetadataSupport;
import org.mockito.invocation.InvocationOnMock;

/* JADX INFO: loaded from: classes.dex */
final class RetrieveGenericsForDefaultAnswers {

    public interface AnswerCallback {
        Object apply(Class<?> cls);
    }

    private RetrieveGenericsForDefaultAnswers() {
    }

    private static Object delegateChains(Class<?> cls) {
        ReturnsEmptyValues returnsEmptyValues = new ReturnsEmptyValues();
        Object objReturnValueFor = returnsEmptyValues.returnValueFor(cls);
        if (objReturnValueFor == null) {
            for (Class<?> superclass = cls; superclass != null && objReturnValueFor == null; superclass = superclass.getSuperclass()) {
                for (Class<?> cls2 : superclass.getInterfaces()) {
                    objReturnValueFor = returnsEmptyValues.returnValueFor(cls2);
                    if (objReturnValueFor != null) {
                        break;
                    }
                }
            }
        }
        return objReturnValueFor == null ? new ReturnsMoreEmptyValues().returnValueFor(cls) : objReturnValueFor;
    }

    private static Class<?> findTypeFromGeneric(InvocationOnMock invocationOnMock, TypeVariable typeVariable) {
        Class<?> clsRawType = GenericMetadataSupport.inferFrom(MockUtil.getMockHandler(invocationOnMock.getMock()).getMockSettings().getTypeToMock()).resolveGenericReturnType(invocationOnMock.getMethod()).rawType();
        return clsRawType == Object.class ? findTypeFromGenericInArguments(invocationOnMock, typeVariable) : clsRawType;
    }

    private static Class<?> findTypeFromGenericInArguments(InvocationOnMock invocationOnMock, TypeVariable typeVariable) {
        Type[] genericParameterTypes = invocationOnMock.getMethod().getGenericParameterTypes();
        for (int i = 0; i < genericParameterTypes.length; i++) {
            Type type = genericParameterTypes[i];
            if (typeVariable.equals(type)) {
                Object argument = invocationOnMock.getArgument(i);
                if (argument == null) {
                    return null;
                }
                return argument.getClass();
            }
            if ((type instanceof GenericArrayType) && typeVariable.equals(((GenericArrayType) type).getGenericComponentType())) {
                return invocationOnMock.getArgument(i).getClass();
            }
        }
        return null;
    }

    public static Object returnTypeForMockWithCorrectGenerics(InvocationOnMock invocationOnMock, AnswerCallback answerCallback) {
        Class<?> returnType = invocationOnMock.getMethod().getReturnType();
        Type genericReturnType = invocationOnMock.getMethod().getGenericReturnType();
        Object objDelegateChains = (!(genericReturnType instanceof TypeVariable) || (returnType = findTypeFromGeneric(invocationOnMock, (TypeVariable) genericReturnType)) == null) ? null : delegateChains(returnType);
        if (objDelegateChains != null) {
            return objDelegateChains;
        }
        if (returnType == null) {
            return answerCallback.apply(null);
        }
        if (MockUtil.typeMockabilityOf(returnType, MockUtil.getMockSettings(invocationOnMock.getMock()).getMockMaker()).mockable()) {
            return answerCallback.apply(returnType);
        }
        return null;
    }
}
