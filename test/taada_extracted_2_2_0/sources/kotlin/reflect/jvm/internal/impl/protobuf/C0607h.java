package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0607h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageLite f3867a;
    public final int b;

    public C0607h(int i, MessageLite messageLite) {
        this.f3867a = messageLite;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0607h)) {
            return false;
        }
        C0607h c0607h = (C0607h) obj;
        return this.f3867a == c0607h.f3867a && this.b == c0607h.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f3867a) * 65535) + this.b;
    }
}
