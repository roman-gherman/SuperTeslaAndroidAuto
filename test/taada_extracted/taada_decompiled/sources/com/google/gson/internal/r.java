package com.google.gson.internal;

/* JADX INFO: loaded from: classes.dex */
public final class r implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f3015a;
    public String b;

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f3015a[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3015a.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i3) {
        return new String(this.f3015a, i, i3 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.b == null) {
            this.b = new String(this.f3015a);
        }
        return this.b;
    }
}
