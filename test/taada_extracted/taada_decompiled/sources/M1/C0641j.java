package m1;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: m1.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0641j extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r1.b f4055a;
    public int b;
    public int c;
    public /* synthetic */ Object d;

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        C0641j c0641j = new C0641j(2, continuation);
        c0641j.d = obj;
        return c0641j;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0641j) create((r1.b) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(8:6|55|7|30|34|(2:39|(1:(1:48)(1:47))(1:43))(1:38)|49|50)(2:9|10))(1:11))(2:12|(2:14|15)(2:16|(1:51)(3:21|(1:24)|28)))|25|53|26|(6:29|30|34|(2:39|(1:(2:45|48)(0))(0))(0)|49|50)|28) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c9, code lost:
    
        r0 = r1;
        r2 = r5;
        r1 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f7  */
    @Override // U1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.C0641j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
