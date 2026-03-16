package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.collections.E;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3909a;
    public final /* synthetic */ j b;
    public final /* synthetic */ l c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(j jVar, l lVar, int i) {
        super(0);
        this.f3909a = i;
        this.b = jVar;
        this.c = lVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3909a) {
            case 0:
                return E.w(this.b.f3912a.keySet(), this.c.h());
            default:
                return E.w(this.b.b.keySet(), this.c.i());
        }
    }
}
