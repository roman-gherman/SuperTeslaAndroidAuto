package org.mockito.plugins;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import q5.a;

/* JADX INFO: loaded from: classes.dex */
public interface MemberAccessor {

    public interface ConstructionDispatcher {
        Object newInstance();
    }

    public interface OnConstruction {
        Object invoke(ConstructionDispatcher constructionDispatcher);
    }

    Object get(Field field, Object obj);

    Object invoke(Method method, Object obj, Object... objArr);

    default Object newInstance(Constructor<?> constructor, OnConstruction onConstruction, Object... objArr) {
        return onConstruction.invoke(new a(this, constructor, objArr));
    }

    /* JADX INFO: renamed from: newInstance, reason: merged with bridge method [inline-methods] */
    Object lambda$newInstance$0(Constructor<?> constructor, Object... objArr);

    void set(Field field, Object obj, Object obj2);
}
