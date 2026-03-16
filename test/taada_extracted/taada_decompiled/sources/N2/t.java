package n2;

import A2.C0022d;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import q2.AbstractC0765b;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    public static final v e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f4257f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0765b f4258a;
    public final Object b;
    public final b3.d c;
    public final NotNullLazyValue d;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3817a;
        f4257f = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(t.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
        e = new v(4);
    }

    public t(AbstractC0765b abstractC0765b, StorageManager storageManager, Function1 function1, b3.d dVar) {
        this.f4258a = abstractC0765b;
        this.b = function1;
        this.c = dVar;
        this.d = storageManager.createLazyValue(new C0022d(this, 27));
    }
}
