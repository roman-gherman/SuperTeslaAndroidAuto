package g1;

import N1.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.i;
import m3.AbstractC0689x;
import s1.AbstractC0809b;

/* JADX INFO: renamed from: g1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0477a extends i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3288a = 0;
    public final /* synthetic */ f b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0477a(f fVar) {
        super(1);
        this.b = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3288a) {
            case 0:
                if (((Throwable) obj) != null) {
                    AbstractC0689x.b(this.b.f3294a, null);
                }
                break;
            default:
                if (((Throwable) obj) != null) {
                    f fVar = this.b;
                    fVar.f3298j.d(AbstractC0809b.e);
                }
                break;
        }
        return m.f1129a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0477a(f fVar, r1.b bVar) {
        super(1);
        this.b = fVar;
    }
}
