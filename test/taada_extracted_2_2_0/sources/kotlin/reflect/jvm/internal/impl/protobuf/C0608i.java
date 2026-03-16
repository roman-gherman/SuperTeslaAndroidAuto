package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0608i {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3868a;

    static {
        new C0608i(0);
    }

    public C0608i() {
        this.f3868a = new HashMap();
    }

    public final void a(o oVar) {
        this.f3868a.put(new C0607h(oVar.d.f3872a, oVar.f3873a), oVar);
    }

    public C0608i(int i) {
        this.f3868a = Collections.EMPTY_MAP;
    }
}
