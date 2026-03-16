package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum A implements Internal$EnumLite {
    /* JADX INFO: Fake field, exist only in values array */
    DECLARATION(0),
    /* JADX INFO: Fake field, exist only in values array */
    FAKE_OVERRIDE(1),
    /* JADX INFO: Fake field, exist only in values array */
    DELEGATION(2),
    /* JADX INFO: Fake field, exist only in values array */
    SYNTHESIZED(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f422a;

    A(int i) {
        this.f422a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f422a;
    }
}
