package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: renamed from: G2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC0110j implements Internal$EnumLite {
    CLASS(0),
    INTERFACE(1),
    ENUM_CLASS(2),
    /* JADX INFO: Fake field, exist only in values array */
    ENUM_ENTRY(3),
    ANNOTATION_CLASS(4),
    /* JADX INFO: Fake field, exist only in values array */
    OBJECT(5),
    COMPANION_OBJECT(6);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f619a;

    EnumC0110j(int i) {
        this.f619a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
    public final int getNumber() {
        return this.f619a;
    }
}
