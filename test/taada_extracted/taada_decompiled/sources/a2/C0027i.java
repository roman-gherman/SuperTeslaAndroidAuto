package A2;

import a3.AbstractC0139b;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import q2.AbstractC0765b;

/* JADX INFO: renamed from: A2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0027i extends AbstractC0139b {
    public final /* synthetic */ int c = 0;
    public final NotNullLazyValue d;
    public final /* synthetic */ AbstractC0765b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0027i(C0029k c0029k) {
        super(c0029k.f41j.f5203a.f5183a);
        this.e = c0029k;
        this.d = c0029k.f41j.f5203a.f5183a.createLazyValue(new C0026h(c0029k, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0199  */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    @Override // a3.AbstractC0147j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection a() {
        /*
            Method dump skipped, instruction units count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.C0027i.a():java.util.Collection");
    }

    @Override // a3.AbstractC0147j
    public final SupertypeLoopChecker d() {
        switch (this.c) {
            case 0:
                return ((C0029k) this.e).f41j.f5203a.f5190m;
            default:
                return n2.v.b;
        }
    }

    @Override // a3.AbstractC0139b, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        switch (this.c) {
            case 0:
                return (C0029k) this.e;
            default:
                return (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.e;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        switch (this.c) {
        }
        return (List) this.d.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        switch (this.c) {
        }
        return true;
    }

    @Override // a3.AbstractC0139b
    /* JADX INFO: renamed from: j */
    public final ClassDescriptor getDeclarationDescriptor() {
        switch (this.c) {
            case 0:
                return (C0029k) this.e;
            default:
                return (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.e;
        }
    }

    public final String toString() {
        switch (this.c) {
            case 0:
                String strB = ((C0029k) this.e).getName().b();
                kotlin.jvm.internal.h.e(strB, "name.asString()");
                return strB;
            default:
                String str = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.e).getName().f962a;
                kotlin.jvm.internal.h.e(str, "name.toString()");
                return str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0027i(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar) {
        super(gVar.f3899l.f1433a.f1418a);
        this.e = gVar;
        this.d = gVar.f3899l.f1433a.f1418a.createLazyValue(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f(gVar, 0));
    }
}
