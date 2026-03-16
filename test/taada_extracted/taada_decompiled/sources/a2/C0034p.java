package A2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;

/* JADX INFO: renamed from: A2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0034p extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f56a;
    public final /* synthetic */ r b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0034p(r rVar, int i) {
        super(0);
        this.f56a = i;
        this.b = rVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f56a) {
            case 0:
                Collection<JavaField> fields = this.b.f59n.getFields();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fields) {
                    if (((JavaField) obj).isEnumEntry()) {
                        arrayList.add(obj);
                    }
                }
                int iF = kotlin.collections.B.F(kotlin.collections.o.D(arrayList));
                if (iF < 16) {
                    iF = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
                for (Object obj2 : arrayList) {
                    linkedHashMap.put(((JavaField) obj2).getName(), obj2);
                }
                return linkedHashMap;
            case 1:
                return kotlin.collections.m.s0(this.b.f59n.getInnerClassNames());
            default:
                r rVar = this.b;
                return kotlin.collections.E.w(rVar.getFunctionNames(), rVar.getVariableNames());
        }
    }
}
