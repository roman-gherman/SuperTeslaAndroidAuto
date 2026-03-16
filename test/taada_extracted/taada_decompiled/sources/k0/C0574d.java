package k0;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: renamed from: k0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0574d extends ResourcesCompat.FontCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f3679a;
    public final /* synthetic */ f b;

    public C0574d(f fVar, g gVar) {
        this.b = fVar;
        this.f3679a = gVar;
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* JADX INFO: renamed from: onFontRetrievalFailed */
    public final void lambda$callbackFailAsync$1(int i) {
        this.b.f3688m = true;
        this.f3679a.a(i);
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* JADX INFO: renamed from: onFontRetrieved */
    public final void lambda$callbackSuccessAsync$0(Typeface typeface) {
        f fVar = this.b;
        fVar.f3689n = Typeface.create(typeface, fVar.c);
        fVar.f3688m = true;
        this.f3679a.b(fVar.f3689n, false);
    }
}
