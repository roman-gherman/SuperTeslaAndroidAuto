package com.google.android.material.color;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f2342a;
    public final byte b;
    public final short c;
    public final String d;
    public final int e;

    public a(int i, int i3, String str) {
        this.d = str;
        this.e = i3;
        this.c = (short) (65535 & i);
        this.b = (byte) ((i >> 16) & 255);
        this.f2342a = (byte) ((i >> 24) & 255);
    }
}
