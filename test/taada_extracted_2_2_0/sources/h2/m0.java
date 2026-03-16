package h2;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function0;
import t2.AbstractC0823e;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3421a;
    public final /* synthetic */ n0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(n0 n0Var, int i) {
        super(0);
        this.f3421a = i;
        this.b = n0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3421a) {
            case 0:
                Type javaType = this.b.getJavaType();
                kotlin.jvm.internal.h.c(javaType);
                return AbstractC0823e.c(javaType);
            default:
                n0 n0Var = this.b;
                return n0Var.a(n0Var.f3423a);
        }
    }
}
