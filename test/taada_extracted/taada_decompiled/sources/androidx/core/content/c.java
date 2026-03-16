package androidx.core.content;

import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1598a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f1598a = i;
        this.b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1598a) {
            case 0:
                return ((ComponentName) this.b).equals((ComponentName) obj);
            default:
                return UriMatcherCompat.lambda$asPredicate$0((UriMatcher) this.b, (Uri) obj);
        }
    }
}
