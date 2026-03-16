package org.mockito.internal.stubbing.answers;

import java.lang.reflect.Array;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.stubbing.defaultanswers.ReturnsEmptyValues;
import org.mockito.internal.util.reflection.LenientCopyTool;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public class ClonesArguments implements Answer<Object> {
    @Override // org.mockito.stubbing.Answer
    public Object answer(InvocationOnMock invocationOnMock) {
        Object[] arguments = invocationOnMock.getArguments();
        for (int i = 0; i < arguments.length; i++) {
            Object obj = arguments[i];
            if (obj != null) {
                if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), length);
                    for (int i3 = 0; i3 < length; i3++) {
                        Array.set(objNewInstance, i3, Array.get(obj, i3));
                    }
                    arguments[i] = objNewInstance;
                } else {
                    Object objNewInstance2 = Plugins.getInstantiatorProvider().getInstantiator(null).newInstance(obj.getClass());
                    new LenientCopyTool().copyToRealObject(obj, objNewInstance2);
                    arguments[i] = objNewInstance2;
                }
            }
        }
        return new ReturnsEmptyValues().answer(invocationOnMock);
    }
}
