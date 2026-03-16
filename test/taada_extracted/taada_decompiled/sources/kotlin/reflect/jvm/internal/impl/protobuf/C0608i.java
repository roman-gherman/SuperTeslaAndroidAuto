package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0608i {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3867a;

    static {
        new C0608i(0);
    }

    public C0608i() {
        this.f3867a = new HashMap();
    }

    public final void a(o oVar) {
        this.f3867a.put(new C0607h(oVar.d.f3871a, oVar.f3872a), oVar);
    }

    public C0608i(int i) {
        this.f3867a = Collections.EMPTY_MAP;
    }
}
