package androidx.profileinstaller;

import android.content.Context;
import fr.sd.taada.helpers.MemoryDiagnostic;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1660a = 1;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Context context, int i, String str) {
        this.c = context;
        this.d = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1660a) {
            case 0:
                ((DeviceProfileWriter) this.c).lambda$result$0(this.b, this.d);
                break;
            default:
                MemoryDiagnostic.lambda$showToastSafe$0((Context) this.c, (String) this.d, this.b);
                break;
        }
    }

    public /* synthetic */ a(DeviceProfileWriter deviceProfileWriter, int i, Object obj) {
        this.c = deviceProfileWriter;
        this.b = i;
        this.d = obj;
    }
}
