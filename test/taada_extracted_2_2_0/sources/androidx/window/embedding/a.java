package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1673a;
    public final /* synthetic */ Set b;

    public /* synthetic */ a(Set set, int i) {
        this.f1673a = i;
        this.b = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1673a) {
            case 0:
                return EmbeddingAdapter.m72translateIntentPredicates$lambda8(this.b, (Intent) obj);
            default:
                return EmbeddingAdapter.m71translateActivityPredicates$lambda6(this.b, (Activity) obj);
        }
    }
}
