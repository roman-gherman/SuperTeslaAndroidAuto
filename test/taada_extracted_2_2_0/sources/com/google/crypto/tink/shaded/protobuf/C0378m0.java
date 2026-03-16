package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0378m0 implements Schema {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageLite f2899a;
    public final K0 b;
    public final E c;

    public C0378m0(K0 k02, E e, MessageLite messageLite) {
        this.b = k02;
        e.getClass();
        this.c = e;
        this.f2899a = messageLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean equals(Object obj, Object obj2) {
        K0 k02 = this.b;
        k02.getClass();
        J0 j02 = ((Q) obj).unknownFields;
        k02.getClass();
        return j02.equals(((Q) obj2).unknownFields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final int getSerializedSize(Object obj) {
        this.b.getClass();
        J0 j02 = ((Q) obj).unknownFields;
        int i = j02.d;
        if (i != -1) {
            return i;
        }
        int iZ = 0;
        for (int i3 = 0; i3 < j02.f2834a; i3++) {
            int i4 = j02.b[i3] >>> 3;
            iZ += AbstractC0398x.z(3, (AbstractC0381o) j02.c[i3]) + AbstractC0398x.H(2, i4) + (AbstractC0398x.G(1) * 2);
        }
        j02.d = iZ;
        return iZ;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final int hashCode(Object obj) {
        this.b.getClass();
        return ((Q) obj).unknownFields.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(Object obj) {
        ((F) this.c).getClass();
        androidx.constraintlayout.core.motion.a.v(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void makeImmutable(Object obj) {
        this.b.getClass();
        ((Q) obj).unknownFields.e = false;
        ((F) this.c).getClass();
        androidx.constraintlayout.core.motion.a.v(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void mergeFrom(Object obj, Object obj2) {
        AbstractC0399x0.x(this.b, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final Object newInstance() {
        MessageLite messageLite = this.f2899a;
        return messageLite instanceof Q ? ((Q) messageLite).m() : messageLite.newBuilderForType().buildPartial();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void writeTo(Object obj, Writer writer) {
        ((F) this.c).getClass();
        androidx.constraintlayout.core.motion.a.v(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void mergeFrom(Object obj, byte[] bArr, int i, int i3, C0367h c0367h) {
        Q q = (Q) obj;
        if (q.unknownFields == J0.f2833f) {
            q.unknownFields = J0.c();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void mergeFrom(Object obj, Reader reader, D d) {
        this.b.getClass();
        K0.a(obj);
        ((F) this.c).getClass();
        obj.getClass();
        throw new ClassCastException();
    }
}
