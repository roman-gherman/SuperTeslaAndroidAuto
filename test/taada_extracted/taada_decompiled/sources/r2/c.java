package R2;

import C5.f;
import j3.p;
import java.io.Serializable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import m2.C0663o;
import m2.EnumC0658j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends p {
    public final /* synthetic */ int b = 2;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Serializable d;

    public c(String str, v vVar) {
        this.d = str;
        this.c = vVar;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // j3.p, kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler
    public void afterChildren(Object obj) {
        switch (this.b) {
            case 0:
                CallableMemberDescriptor current = (CallableMemberDescriptor) obj;
                h.f(current, "current");
                v vVar = (v) this.c;
                if (vVar.f3816a == null && ((Boolean) ((i) this.d).invoke(current)).booleanValue()) {
                    vVar.f3816a = current;
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler
    public final boolean beforeChildren(Object obj) {
        switch (this.b) {
            case 0:
                CallableMemberDescriptor current = (CallableMemberDescriptor) obj;
                h.f(current, "current");
                return ((v) this.c).f3816a == null;
            case 1:
                boolean zBooleanValue = ((Boolean) this.c.invoke(obj)).booleanValue();
                boolean[] zArr = (boolean[]) this.d;
                if (zBooleanValue) {
                    zArr[0] = true;
                }
                return !zArr[0];
            default:
                ClassDescriptor javaClassDescriptor = (ClassDescriptor) obj;
                h.f(javaClassDescriptor, "javaClassDescriptor");
                String strB0 = f.b0(javaClassDescriptor, (String) this.d);
                boolean zContains = C0663o.b.contains(strB0);
                v vVar = (v) this.c;
                if (zContains) {
                    vVar.f3816a = EnumC0658j.f4092a;
                } else if (C0663o.c.contains(strB0)) {
                    vVar.f3816a = EnumC0658j.b;
                } else if (C0663o.f4099a.contains(strB0)) {
                    vVar.f3816a = EnumC0658j.d;
                }
                return vVar.f3816a == null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler
    public final Object result() {
        switch (this.b) {
            case 0:
                return (CallableMemberDescriptor) ((v) this.c).f3816a;
            case 1:
                return Boolean.valueOf(((boolean[]) this.d)[0]);
            default:
                EnumC0658j enumC0658j = (EnumC0658j) ((v) this.c).f3816a;
                return enumC0658j == null ? EnumC0658j.c : enumC0658j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1 function1, boolean[] zArr) {
        this.c = function1;
        this.d = zArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(v vVar, Function1 function1) {
        this.c = vVar;
        this.d = (i) function1;
    }
}
