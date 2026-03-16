package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum Q implements Internal$EnumLite {
    IN(0),
    OUT(1),
    INV(2),
    STAR(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f476a;

    Q(int i) {
        this.f476a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f476a;
    }
}
