package androidx.core.app;

import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ android.app.Person f(Parcelable parcelable) {
        return (android.app.Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ android.app.Person g(Object obj) {
        return (android.app.Person) obj;
    }

    public static /* synthetic */ PrecomputedText.Params.Builder m(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ PrecomputedText p(Object obj) {
        return (PrecomputedText) obj;
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj) {
        return obj instanceof PrecomputedText;
    }
}
