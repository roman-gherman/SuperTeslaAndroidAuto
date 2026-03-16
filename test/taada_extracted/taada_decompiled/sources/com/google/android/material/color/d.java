package com.google.android.material.color;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f2345a;
    public final short b;
    public final int c;

    public d(short s3, short s6, int i) {
        this.f2345a = s3;
        this.b = s6;
        this.c = i;
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(g.h(this.f2345a));
        byteArrayOutputStream.write(g.h(this.b));
        byteArrayOutputStream.write(g.a(this.c));
    }
}
