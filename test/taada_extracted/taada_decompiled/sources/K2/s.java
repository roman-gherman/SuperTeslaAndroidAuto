package k2;

/* JADX INFO: loaded from: classes2.dex */
public enum s {
    /* JADX INFO: Fake field, exist only in values array */
    UBYTE(L2.b.e("kotlin/UByte", false)),
    /* JADX INFO: Fake field, exist only in values array */
    USHORT(L2.b.e("kotlin/UShort", false)),
    /* JADX INFO: Fake field, exist only in values array */
    UINT(L2.b.e("kotlin/UInt", false)),
    /* JADX INFO: Fake field, exist only in values array */
    ULONG(L2.b.e("kotlin/ULong", false));


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.b f3776a;
    public final L2.f b;
    public final L2.b c;

    s(L2.b bVar) {
        this.f3776a = bVar;
        L2.f fVarI = bVar.i();
        kotlin.jvm.internal.h.e(fVarI, "classId.shortClassName");
        this.b = fVarI;
        this.c = new L2.b(bVar.g(), L2.f.e(fVarI.b() + "Array"));
    }
}
