package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1605a;
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ Location c;

    public /* synthetic */ d(Consumer consumer, Location location, int i) {
        this.f1605a = i;
        this.b = consumer;
        this.c = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1605a) {
            case 0:
                this.b.accept(this.c);
                break;
            default:
                this.b.accept(this.c);
                break;
        }
    }
}
