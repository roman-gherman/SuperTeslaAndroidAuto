package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends r implements KProperty0 {
    @Override // kotlin.jvm.internal.b
    public final KCallable computeReflected() {
        return w.f3817a.e(this);
    }

    @Override // kotlin.reflect.KProperty0
    public final Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ((r3.j) this).get();
    }

    @Override // kotlin.reflect.KProperty
    public final KProperty0.Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }
}
