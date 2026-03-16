package m3;

/* JADX INFO: renamed from: m3.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0688w extends S1.a {
    public static final C0687v b = new C0687v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4148a;

    public C0688w(String str) {
        super(b);
        this.f4148a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0688w) && kotlin.jvm.internal.h.a(this.f4148a, ((C0688w) obj).f4148a);
    }

    public final int hashCode() {
        return this.f4148a.hashCode();
    }

    public final String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("CoroutineName("), this.f4148a, ')');
    }
}
