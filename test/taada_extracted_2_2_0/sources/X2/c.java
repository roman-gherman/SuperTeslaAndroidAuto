package X2;

import G2.C0111k;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NameResolver f1414a;
    public final C0111k b;
    public final I2.a c;
    public final SourceElement d;

    public c(NameResolver nameResolver, C0111k classProto, I2.a aVar, SourceElement sourceElement) {
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(classProto, "classProto");
        kotlin.jvm.internal.h.f(sourceElement, "sourceElement");
        this.f1414a = nameResolver;
        this.b = classProto;
        this.c = aVar;
        this.d = sourceElement;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.h.a(this.f1414a, cVar.f1414a) && kotlin.jvm.internal.h.a(this.b, cVar.b) && kotlin.jvm.internal.h.a(this.c, cVar.c) && kotlin.jvm.internal.h.a(this.d, cVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f1414a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ClassData(nameResolver=" + this.f1414a + ", classProto=" + this.b + ", metadataVersion=" + this.c + ", sourceElement=" + this.d + ')';
    }
}
