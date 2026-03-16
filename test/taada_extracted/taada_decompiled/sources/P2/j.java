package P2;

import a3.AbstractC0162z;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends g {
    public final String b;

    public j(String str) {
        super(N1.m.f1129a);
        this.b = str;
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        return c3.j.c(c3.i.ERROR_CONSTANT_VALUE, this.b);
    }

    @Override // P2.g
    public final Object b() {
        throw new UnsupportedOperationException();
    }

    @Override // P2.g
    public final String toString() {
        return this.b;
    }
}
