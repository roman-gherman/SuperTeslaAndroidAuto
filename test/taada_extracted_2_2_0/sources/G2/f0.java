package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum f0 implements Internal$EnumLite {
    WARNING(0),
    ERROR(1),
    HIDDEN(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f586a;

    f0(int i) {
        this.f586a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f586a;
    }
}
