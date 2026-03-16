package androidx.window.embedding;

import android.util.Pair;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1675a;
    public final /* synthetic */ EmbeddingAdapter b;
    public final /* synthetic */ Set c;

    public /* synthetic */ c(EmbeddingAdapter embeddingAdapter, Set set, int i) {
        this.f1675a = i;
        this.b = embeddingAdapter;
        this.c = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1675a) {
            case 0:
                return EmbeddingAdapter.m70translateActivityPairPredicates$lambda1(this.b, this.c, (Pair) obj);
            default:
                return EmbeddingAdapter.m69translateActivityIntentPredicates$lambda3(this.b, this.c, (Pair) obj);
        }
    }
}
