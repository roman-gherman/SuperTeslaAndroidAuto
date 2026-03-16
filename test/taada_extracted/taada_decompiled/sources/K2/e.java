package K2;

import E1.k;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends k {
    public final String b;
    public final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String name, String desc) {
        super(9);
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(desc, "desc");
        this.b = name;
        this.c = desc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.h.a(this.b, eVar.b) && kotlin.jvm.internal.h.a(this.c, eVar.c);
    }

    @Override // E1.k
    public final String h() {
        return this.b + this.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }
}
