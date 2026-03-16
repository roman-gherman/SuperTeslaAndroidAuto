package b3;

import a3.AbstractC0162z;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.w;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r extends kotlin.jvm.internal.e implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1710a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i, int i3, Object obj) {
        super(i, obj);
        this.f1710a = i3;
    }

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        switch (this.f1710a) {
            case 0:
                return "isStrictSupertype";
            default:
                return "equalTypes";
        }
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        switch (this.f1710a) {
            case 0:
                return w.f3818a.b(s.class);
            default:
                return w.f3818a.b(j.class);
        }
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        switch (this.f1710a) {
            case 0:
                return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            default:
                return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        switch (this.f1710a) {
            case 0:
                AbstractC0162z p02 = (AbstractC0162z) obj;
                AbstractC0162z p12 = (AbstractC0162z) obj2;
                kotlin.jvm.internal.h.f(p02, "p0");
                kotlin.jvm.internal.h.f(p12, "p1");
                ((s) this.receiver).getClass();
                NewKotlinTypeChecker.Companion.getClass();
                j jVar = i.b;
                return Boolean.valueOf(jVar.isSubtypeOf(p02, p12) && !jVar.isSubtypeOf(p12, p02));
            default:
                AbstractC0162z p03 = (AbstractC0162z) obj;
                AbstractC0162z p13 = (AbstractC0162z) obj2;
                kotlin.jvm.internal.h.f(p03, "p0");
                kotlin.jvm.internal.h.f(p13, "p1");
                return Boolean.valueOf(((j) this.receiver).equalTypes(p03, p13));
        }
    }
}
