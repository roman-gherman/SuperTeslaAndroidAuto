package g2;

import h2.AbstractC0514q;
import h2.k0;
import h2.x0;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.h;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: renamed from: g2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0480b {
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, kotlin.Lazy] */
    public static final Field a(KProperty kProperty) {
        h.f(kProperty, "<this>");
        k0 k0VarC = x0.c(kProperty);
        if (k0VarC != null) {
            return (Field) k0VarC.f3415j.getValue();
        }
        return null;
    }

    public static final Method b(KFunction kFunction) {
        Caller callerB;
        h.f(kFunction, "<this>");
        AbstractC0514q abstractC0514qA = x0.a(kFunction);
        Member member = (abstractC0514qA == null || (callerB = abstractC0514qA.b()) == null) ? null : callerB.getMember();
        if (member instanceof Method) {
            return (Method) member;
        }
        return null;
    }
}
