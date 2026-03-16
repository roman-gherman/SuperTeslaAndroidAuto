package h2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class W extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3384a;
    public final /* synthetic */ X b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ W(X x, int i) {
        super(0);
        this.f3384a = i;
        this.b = x;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3384a) {
            case 0:
                return new V(this.b);
            default:
                X x = this.b;
                return x.i(x.h(), null, null);
        }
    }
}
