package k2;

/* JADX INFO: loaded from: classes2.dex */
public enum r {
    UBYTEARRAY(L2.b.e("kotlin/UByteArray", false)),
    USHORTARRAY(L2.b.e("kotlin/UShortArray", false)),
    UINTARRAY(L2.b.e("kotlin/UIntArray", false)),
    ULONGARRAY(L2.b.e("kotlin/ULongArray", false));


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.f f3776a;

    r(L2.b bVar) {
        L2.f fVarI = bVar.i();
        kotlin.jvm.internal.h.e(fVarI, "classId.shortClassName");
        this.f3776a = fVarI;
    }
}
