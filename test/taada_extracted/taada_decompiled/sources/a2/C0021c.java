package A2;

import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;

/* JADX INFO: renamed from: A2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0021c implements DeclaredMemberIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0021c f30a = new C0021c();

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final JavaField findFieldByName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Collection findMethodsByName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return kotlin.collections.u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final JavaRecordComponent findRecordComponentByName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Set getFieldNames() {
        return kotlin.collections.w.f3806a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Set getMethodNames() {
        return kotlin.collections.w.f3806a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Set getRecordComponentNames() {
        return kotlin.collections.w.f3806a;
    }
}
