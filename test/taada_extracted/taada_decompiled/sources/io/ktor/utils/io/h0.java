package io.ktor.utils.io;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3577a;
    public final /* synthetic */ Constructor b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(Constructor constructor, int i) {
        super(1);
        this.f3577a = i;
        this.b = constructor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object objN;
        Object objN2;
        Object objN3;
        Object objN4;
        switch (this.f3577a) {
            case 0:
                Throwable e = (Throwable) obj;
                kotlin.jvm.internal.h.f(e, "e");
                try {
                    Object objNewInstance = this.b.newInstance(e.getMessage(), e);
                    kotlin.jvm.internal.h.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                    objN = (Throwable) objNewInstance;
                    break;
                } catch (Throwable th) {
                    objN = kotlin.reflect.l.n(th);
                }
                if (objN instanceof N1.g) {
                    objN = null;
                }
                return (Throwable) objN;
            case 1:
                Throwable e6 = (Throwable) obj;
                kotlin.jvm.internal.h.f(e6, "e");
                try {
                    Object objNewInstance2 = this.b.newInstance(e6);
                    kotlin.jvm.internal.h.d(objNewInstance2, "null cannot be cast to non-null type kotlin.Throwable");
                    objN2 = (Throwable) objNewInstance2;
                    break;
                } catch (Throwable th2) {
                    objN2 = kotlin.reflect.l.n(th2);
                }
                if (objN2 instanceof N1.g) {
                    objN2 = null;
                }
                return (Throwable) objN2;
            case 2:
                Throwable e7 = (Throwable) obj;
                kotlin.jvm.internal.h.f(e7, "e");
                try {
                    Object objNewInstance3 = this.b.newInstance(e7.getMessage());
                    kotlin.jvm.internal.h.d(objNewInstance3, "null cannot be cast to non-null type kotlin.Throwable");
                    Throwable th3 = (Throwable) objNewInstance3;
                    th3.initCause(e7);
                    objN3 = th3;
                    break;
                } catch (Throwable th4) {
                    objN3 = kotlin.reflect.l.n(th4);
                }
                boolean z6 = objN3 instanceof N1.g;
                Object obj2 = objN3;
                if (z6) {
                    obj2 = null;
                }
                return (Throwable) obj2;
            default:
                Throwable e8 = (Throwable) obj;
                kotlin.jvm.internal.h.f(e8, "e");
                try {
                    Object objNewInstance4 = this.b.newInstance(new Object[0]);
                    kotlin.jvm.internal.h.d(objNewInstance4, "null cannot be cast to non-null type kotlin.Throwable");
                    Throwable th5 = (Throwable) objNewInstance4;
                    th5.initCause(e8);
                    objN4 = th5;
                    break;
                } catch (Throwable th6) {
                    objN4 = kotlin.reflect.l.n(th6);
                }
                boolean z7 = objN4 instanceof N1.g;
                Object obj3 = objN4;
                if (z7) {
                    obj3 = null;
                }
                return (Throwable) obj3;
        }
    }
}
