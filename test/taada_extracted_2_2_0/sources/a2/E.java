package A2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import z2.C0941a;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8a;
    public final /* synthetic */ G b;
    public final /* synthetic */ JavaField c;
    public final /* synthetic */ y2.f d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ E(G g6, JavaField javaField, y2.f fVar, int i) {
        super(0);
        this.f8a = i;
        this.b = g6;
        this.c = javaField;
        this.d = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f8a) {
            case 0:
                C0941a c0941a = this.b.f11a.f5204a;
                c0941a.f5187h.getInitializerConstant(this.c, this.d);
                return null;
            default:
                G g6 = this.b;
                return g6.f11a.f5204a.f5184a.createNullableLazyValue(new E(g6, this.c, this.d, 0));
        }
    }
}
