package androidx.core.content;

import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1597a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(String str, int i) {
        this.f1597a = i;
        this.b = str;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1597a) {
            case 0:
                return IntentSanitizer.Builder.lambda$allowExtraOutput$16(this.b, (Uri) obj);
            case 1:
                return this.b.equals((String) obj);
            case 2:
                return IntentSanitizer.Builder.lambda$allowComponentWithPackage$9(this.b, (ComponentName) obj);
            case 3:
                return IntentSanitizer.Builder.lambda$allowDataWithAuthority$8(this.b, (Uri) obj);
            case 4:
                return IntentSanitizer.Builder.lambda$allowClipDataUriWithAuthority$11(this.b, (Uri) obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtraStreamUriWithAuthority$15(this.b, (Uri) obj);
        }
    }
}
