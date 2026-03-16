package k0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: renamed from: k0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0575e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3680a;
    public final /* synthetic */ TextPaint b;
    public final /* synthetic */ g c;
    public final /* synthetic */ f d;

    public C0575e(f fVar, Context context, TextPaint textPaint, g gVar) {
        this.d = fVar;
        this.f3680a = context;
        this.b = textPaint;
        this.c = gVar;
    }

    @Override // k0.g
    public final void a(int i) {
        this.c.a(i);
    }

    @Override // k0.g
    public final void b(Typeface typeface, boolean z6) {
        this.d.f(this.f3680a, this.b, typeface);
        this.c.b(typeface, z6);
    }
}
