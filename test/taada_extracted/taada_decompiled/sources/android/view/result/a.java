package android.view.result;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1573a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ a(int i, Function1 function1) {
        this.f1573a = i;
        this.b = function1;
    }

    @Override // android.view.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        switch (this.f1573a) {
            case 0:
                ActivityResultCallerKt.registerForActivityResult$lambda$0(this.b, obj);
                break;
            default:
                ActivityResultCallerKt.registerForActivityResult$lambda$1(this.b, obj);
                break;
        }
    }
}
