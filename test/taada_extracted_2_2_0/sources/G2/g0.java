package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum g0 implements Internal$EnumLite {
    LANGUAGE_VERSION(0),
    COMPILER_VERSION(1),
    API_VERSION(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f587a;

    g0(int i) {
        this.f587a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f587a;
    }
}
