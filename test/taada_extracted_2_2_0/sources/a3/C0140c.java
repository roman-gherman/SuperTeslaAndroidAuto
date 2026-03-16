package a3;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: renamed from: a3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0140c extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f1544a;
    public final /* synthetic */ ClassicTypeSystemContext b;
    public final /* synthetic */ SimpleTypeMarker c;
    public final /* synthetic */ SimpleTypeMarker d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0140c(Q q, ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        super(0);
        this.f1544a = q;
        this.b = classicTypeSystemContext;
        this.c = simpleTypeMarker;
        this.d = simpleTypeMarker2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Boolean.valueOf(C0142e.l(this.f1544a, this.b.asArgumentList(this.c), this.d));
    }
}
