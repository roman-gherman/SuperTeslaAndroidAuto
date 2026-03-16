package a3;

import A2.C0022d;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: a3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0147j implements TypeConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1553a;
    public final NotNullLazyValue b;

    public AbstractC0147j(StorageManager storageManager) {
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        this.b = storageManager.createLazyValueWithPostCompute(new C0022d(this, 10), C0145h.f1551a, new C0146i(this, 2));
    }

    public abstract Collection a();

    public abstract AbstractC0162z b();

    public Collection c() {
        return kotlin.collections.u.f3804a;
    }

    public abstract SupertypeLoopChecker d();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final List getSupertypes() {
        return ((C0144g) this.b.invoke()).b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TypeConstructor) && obj.hashCode() == hashCode()) {
            TypeConstructor typeConstructor = (TypeConstructor) obj;
            if (typeConstructor.getParameters().size() == getParameters().size()) {
                ClassifierDescriptor declarationDescriptor = getDeclarationDescriptor();
                ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
                if (declarationDescriptor2 == null || c3.j.f(declarationDescriptor) || N2.f.o(declarationDescriptor) || c3.j.f(declarationDescriptor2) || N2.f.o(declarationDescriptor2)) {
                    return false;
                }
                return f(declarationDescriptor2);
            }
        }
        return false;
    }

    public abstract boolean f(ClassifierDescriptor classifierDescriptor);

    public List g(List list) {
        return list;
    }

    public void h(AbstractC0162z type) {
        kotlin.jvm.internal.h.f(type, "type");
    }

    public final int hashCode() {
        int i = this.f1553a;
        if (i != 0) {
            return i;
        }
        ClassifierDescriptor declarationDescriptor = getDeclarationDescriptor();
        int iIdentityHashCode = (c3.j.f(declarationDescriptor) || N2.f.o(declarationDescriptor)) ? System.identityHashCode(this) : N2.f.g(declarationDescriptor).f961a.hashCode();
        this.f1553a = iIdentityHashCode;
        return iIdentityHashCode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final TypeConstructor refine(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new C0143f(this, kotlinTypeRefiner);
    }
}
