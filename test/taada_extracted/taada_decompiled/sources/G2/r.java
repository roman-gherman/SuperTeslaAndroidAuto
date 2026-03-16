package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public enum r implements Internal$EnumLite {
    AT_MOST_ONCE(0),
    EXACTLY_ONCE(1),
    AT_LEAST_ONCE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f655a;

    r(int i) {
        this.f655a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f655a;
    }
}
