package org.mockito.internal.util.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.bytebuddy.ClassFileVersion;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public class ModuleMemberAccessor implements MemberAccessor {
    private final MemberAccessor delegate;

    public ModuleMemberAccessor() {
        MemberAccessor reflectionMemberAccessor;
        try {
            reflectionMemberAccessor = delegate();
        } catch (Throwable unused) {
            reflectionMemberAccessor = new ReflectionMemberAccessor();
        }
        this.delegate = reflectionMemberAccessor;
    }

    private static MemberAccessor delegate() {
        return ClassFileVersion.ofThisVm().isAtLeast(ClassFileVersion.JAVA_V9) ? new InstrumentationMemberAccessor() : new ReflectionMemberAccessor();
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object get(Field field, Object obj) {
        return this.delegate.get(field, obj);
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object invoke(Method method, Object obj, Object... objArr) {
        return this.delegate.invoke(method, obj, objArr);
    }

    @Override // org.mockito.plugins.MemberAccessor
    /* JADX INFO: renamed from: newInstance */
    public Object lambda$newInstance$0(Constructor<?> constructor, Object... objArr) {
        return this.delegate.lambda$newInstance$0(constructor, objArr);
    }

    @Override // org.mockito.plugins.MemberAccessor
    public void set(Field field, Object obj, Object obj2) {
        this.delegate.set(field, obj, obj2);
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object newInstance(Constructor<?> constructor, MemberAccessor.OnConstruction onConstruction, Object... objArr) {
        return this.delegate.newInstance(constructor, onConstruction, objArr);
    }
}
