package io.ktor.utils.io;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends kotlin.jvm.internal.i implements Function1 {
    public static final i0 b = new i0(1, 0);
    public static final i0 c = new i0(1, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3580a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(int i, int i3) {
        super(i);
        this.f3580a = i3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3580a) {
            case 0:
                Throwable it = (Throwable) obj;
                kotlin.jvm.internal.h.f(it, "it");
                break;
            default:
                Throwable it2 = (Throwable) obj;
                kotlin.jvm.internal.h.f(it2, "it");
                break;
        }
        return null;
    }
}
