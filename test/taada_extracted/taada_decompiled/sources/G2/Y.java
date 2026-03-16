package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum Y implements Internal$EnumLite {
    IN(0),
    OUT(1),
    INV(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f526a;

    Y(int i) {
        this.f526a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f526a;
    }
}
