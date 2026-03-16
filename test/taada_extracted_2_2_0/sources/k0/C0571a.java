package k0;

import android.graphics.Typeface;

/* JADX INFO: renamed from: k0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0571a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f3679a;
    public final B.g b;
    public boolean c;

    public C0571a(B.g gVar, Typeface typeface) {
        this.f3679a = typeface;
        this.b = gVar;
    }

    @Override // k0.g
    public final void a(int i) {
        if (this.c) {
            return;
        }
        this.b.apply(this.f3679a);
    }

    @Override // k0.g
    public final void b(Typeface typeface, boolean z6) {
        if (this.c) {
            return;
        }
        this.b.apply(typeface);
    }
}
