package j1;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3655a;
    public final /* synthetic */ DisposableHandle b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(DisposableHandle disposableHandle, int i) {
        super(1);
        this.f3655a = i;
        this.b = disposableHandle;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3655a) {
            case 0:
                this.b.dispose();
                break;
            default:
                this.b.dispose();
                break;
        }
        return N1.m.f1129a;
    }
}
