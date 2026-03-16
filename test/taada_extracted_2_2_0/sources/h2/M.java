package h2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3375a;
    public final /* synthetic */ S b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ M(S s3, int i) {
        super(0);
        this.f3375a = i;
        this.b = s3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3375a) {
            case 0:
                return s2.d.a(this.b.b);
            default:
                return new P(this.b);
        }
    }
}
