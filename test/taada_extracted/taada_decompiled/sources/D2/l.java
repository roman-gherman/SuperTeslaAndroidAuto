package D2;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f257a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(int i, String str, String str2) {
        super(1);
        this.f257a = i;
        this.b = str;
        this.c = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f257a) {
            case 0:
                t function = (t) obj;
                kotlin.jvm.internal.h.f(function, "$this$function");
                e eVar = m.b;
                String str = this.b;
                function.a(str, eVar);
                e eVar2 = m.f258a;
                function.a(this.c, eVar, eVar, eVar2, eVar2);
                function.c(str, eVar2);
                break;
            case 1:
                t function2 = (t) obj;
                kotlin.jvm.internal.h.f(function2, "$this$function");
                e eVar3 = m.b;
                String str2 = this.b;
                function2.a(str2, eVar3);
                function2.a(this.c, eVar3, eVar3, eVar3);
                function2.c(str2, eVar3);
                break;
            case 2:
                t function3 = (t) obj;
                kotlin.jvm.internal.h.f(function3, "$this$function");
                e eVar4 = m.b;
                String str3 = this.b;
                function3.a(str3, eVar4);
                e eVar5 = m.c;
                e eVar6 = m.f258a;
                function3.a(this.c, eVar4, eVar4, eVar5, eVar6);
                function3.c(str3, eVar6);
                break;
            case 3:
                t function4 = (t) obj;
                kotlin.jvm.internal.h.f(function4, "$this$function");
                e eVar7 = m.b;
                String str4 = this.b;
                function4.a(str4, eVar7);
                e eVar8 = m.c;
                function4.a(str4, eVar8);
                e eVar9 = m.f258a;
                function4.a(this.c, eVar7, eVar8, eVar8, eVar9);
                function4.c(str4, eVar9);
                break;
            case 4:
                t function5 = (t) obj;
                kotlin.jvm.internal.h.f(function5, "$this$function");
                e eVar10 = m.c;
                function5.a(this.b, eVar10);
                function5.c(this.c, m.b, eVar10);
                break;
            default:
                t function6 = (t) obj;
                kotlin.jvm.internal.h.f(function6, "$this$function");
                function6.a(this.b, m.f258a);
                function6.c(this.c, m.b, m.c);
                break;
        }
        return N1.m.f1129a;
    }
}
