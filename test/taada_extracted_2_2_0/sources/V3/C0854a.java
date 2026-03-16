package v3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: v3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0854a extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4940a;
    public final /* synthetic */ g b;
    public final /* synthetic */ C0855b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0854a(g gVar, C0855b c0855b, int i) {
        super(1);
        this.f4940a = i;
        this.b = gVar;
        this.c = c0855b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f4940a) {
            case 0:
                this.b.unlock(this.c.b);
                break;
            default:
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.f4946h;
                C0855b c0855b = this.c;
                Object obj2 = c0855b.b;
                g gVar = this.b;
                atomicReferenceFieldUpdater.set(gVar, obj2);
                gVar.unlock(c0855b.b);
                break;
        }
        return N1.m.f1129a;
    }
}
