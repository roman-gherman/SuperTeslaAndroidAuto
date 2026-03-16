package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum K implements Internal$EnumLite {
    CLASS(0),
    PACKAGE(1),
    LOCAL(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466a;

    K(int i) {
        this.f466a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f466a;
    }
}
