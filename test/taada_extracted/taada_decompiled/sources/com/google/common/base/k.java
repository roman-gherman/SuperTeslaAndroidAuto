package com.google.common.base;

import f.s;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterator {
    public String b;
    public final CharSequence c;
    public final i d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l f2774g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2772a = 2;
    public int e = 0;

    public k(l lVar, n nVar, CharSequence charSequence) {
        this.f2774g = lVar;
        this.d = nVar.f2777a;
        this.f2773f = nVar.c;
        this.c = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String string;
        int i = this.f2772a;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int iB = s.b(i);
        if (iB == 0) {
            return true;
        }
        if (iB == 2) {
            return false;
        }
        this.f2772a = 4;
        int i3 = this.e;
        while (true) {
            int i4 = this.e;
            if (i4 == -1) {
                this.f2772a = 3;
                string = null;
                break;
            }
            int iG = ((h) this.f2774g.f2775a).G(this.c, i4);
            CharSequence charSequence = this.c;
            if (iG == -1) {
                iG = charSequence.length();
                this.e = -1;
            } else {
                this.e = iG + 1;
            }
            int i5 = this.e;
            if (i5 == i3) {
                int i6 = i5 + 1;
                this.e = i6;
                if (i6 > charSequence.length()) {
                    this.e = -1;
                }
            } else {
                i iVar = this.d;
                if (i3 < iG) {
                    charSequence.charAt(i3);
                    iVar.getClass();
                }
                if (iG > i3) {
                    charSequence.charAt(iG - 1);
                    iVar.getClass();
                }
                int i7 = this.f2773f;
                if (i7 == 1) {
                    iG = charSequence.length();
                    this.e = -1;
                    if (iG > i3) {
                        charSequence.charAt(iG - 1);
                        iVar.getClass();
                    }
                } else {
                    this.f2773f = i7 - 1;
                }
                string = charSequence.subSequence(i3, iG).toString();
            }
        }
        this.b = string;
        if (this.f2772a == 3) {
            return false;
        }
        this.f2772a = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f2772a = 2;
        String str = this.b;
        this.b = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
