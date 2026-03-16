package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0387r0 implements Internal$EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2913a;

    EnumC0387r0(int i) {
        this.f2913a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f2913a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
