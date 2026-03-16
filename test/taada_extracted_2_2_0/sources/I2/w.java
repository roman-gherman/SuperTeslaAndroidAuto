package i2;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements Caller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f3480a = new w();

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final /* bridge */ /* synthetic */ Member getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final List getParameterTypes() {
        return kotlin.collections.u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        Class TYPE = Void.TYPE;
        kotlin.jvm.internal.h.e(TYPE, "TYPE");
        return TYPE;
    }
}
