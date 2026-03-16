package y1;

import h2.C0522z;
import kotlin.jvm.internal.h;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: renamed from: y1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0929a extends Exception implements CopyableThrowable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f5128a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0929a(KClass type) {
        super("Type " + ((C0522z) type).b.getName() + " is excluded so couldn't be used in receive");
        h.f(type, "type");
        this.f5128a = type;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable createCopy() {
        C0929a c0929a = new C0929a(this.f5128a);
        c0929a.initCause(this);
        return c0929a;
    }
}
