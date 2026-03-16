package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum k0 implements Internal$EnumLite {
    /* JADX INFO: Fake field, exist only in values array */
    INTERNAL(0),
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE(1),
    /* JADX INFO: Fake field, exist only in values array */
    PROTECTED(2),
    /* JADX INFO: Fake field, exist only in values array */
    PUBLIC(3),
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE_TO_THIS(4),
    /* JADX INFO: Fake field, exist only in values array */
    LOCAL(5);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f644a;

    k0(int i) {
        this.f644a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f644a;
    }
}
