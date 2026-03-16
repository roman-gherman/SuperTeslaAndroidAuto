package q2;

import a3.b0;
import java.util.List;
import k2.C0587f;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: q2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0764a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4588a;
    public final /* synthetic */ AbstractC0765b b;

    public /* synthetic */ C0764a(AbstractC0765b abstractC0765b, int i) {
        this.f4588a = i;
        this.b = abstractC0765b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AbstractC0765b abstractC0765b = this.b;
        switch (this.f4588a) {
            case 0:
                MemberScope unsubstitutedMemberScope = abstractC0765b.getUnsubstitutedMemberScope();
                C0587f c0587f = new C0587f(this, 1);
                c3.g gVar = b0.f1543a;
                if (c3.j.f(abstractC0765b)) {
                    return c3.j.c(c3.i.UNABLE_TO_SUBSTITUTE_TYPE, abstractC0765b.toString());
                }
                TypeConstructor typeConstructor = abstractC0765b.getTypeConstructor();
                if (typeConstructor == null) {
                    b0.a(12);
                    throw null;
                }
                if (unsubstitutedMemberScope == null) {
                    b0.a(13);
                    throw null;
                }
                List listE = b0.e(typeConstructor.getParameters());
                a3.M.b.getClass();
                return a3.C.e(a3.M.c, typeConstructor, listE, false, unsubstitutedMemberScope, c0587f);
            case 1:
                return new U2.i(abstractC0765b.getUnsubstitutedMemberScope());
            default:
                return new w(abstractC0765b);
        }
    }
}
