package k2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3711a;
    public final /* synthetic */ k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(k kVar, int i) {
        super(0);
        this.f3711a = i;
        this.b = kVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3711a) {
            case 0:
                return p.f3767k.c(this.b.b);
            default:
                return p.f3767k.c(this.b.f3720a);
        }
    }
}
