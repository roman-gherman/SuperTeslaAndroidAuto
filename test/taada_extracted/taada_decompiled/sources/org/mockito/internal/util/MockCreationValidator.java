package org.mockito.internal.util;

import java.util.Collection;
import java.util.Iterator;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.mock.SerializableMode;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
public class MockCreationValidator {
    public void validateConstructorUse(boolean z6, SerializableMode serializableMode) {
        if (z6 && serializableMode == SerializableMode.ACROSS_CLASSLOADERS) {
            throw Reporter.usingConstructorWithFancySerializable(serializableMode);
        }
    }

    public void validateDelegatedInstance(Class<?> cls, Object obj) {
        if (cls != null && obj != null && obj.getClass().isAssignableFrom(cls)) {
            throw Reporter.mockedTypeIsInconsistentWithDelegatedInstanceType(cls, obj);
        }
    }

    public void validateExtraInterfaces(Class<?> cls, Collection<Class<?>> collection) {
        if (collection == null) {
            return;
        }
        Iterator<Class<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (cls == it.next()) {
                throw Reporter.extraInterfacesCannotContainMockedType(cls);
            }
        }
    }

    public void validateMockedType(Class<?> cls, Object obj) {
        if (cls != null && obj != null && !cls.equals(obj.getClass())) {
            throw Reporter.mockedTypeIsInconsistentWithSpiedInstanceType(cls, obj);
        }
    }

    public void validateType(Class<?> cls, String str) {
        MockMaker.TypeMockability typeMockabilityTypeMockabilityOf = MockUtil.typeMockabilityOf(cls, str);
        if (!typeMockabilityTypeMockabilityOf.mockable()) {
            throw Reporter.cannotMockClass(cls, typeMockabilityTypeMockabilityOf.nonMockableReason());
        }
    }
}
