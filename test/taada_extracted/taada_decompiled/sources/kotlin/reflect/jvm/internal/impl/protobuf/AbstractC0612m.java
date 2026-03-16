package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0612m extends p implements GeneratedMessageLite$ExtendableMessageOrBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0609j f3870a;

    public AbstractC0612m() {
        this.f3870a = new C0609j();
    }

    public final int c() {
        A a6;
        int i = 0;
        int iD = 0;
        while (true) {
            a6 = this.f3870a.f3868a;
            if (i >= a6.b.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) a6.b.get(i);
            iD += C0609j.d((FieldSet$FieldDescriptorLite) entry.getKey(), entry.getValue());
            i++;
        }
        for (Map.Entry entry2 : a6.c()) {
            iD += C0609j.d((FieldSet$FieldDescriptorLite) entry2.getKey(), entry2.getValue());
        }
        return iD;
    }

    public final Object d(o oVar) {
        h(oVar);
        A a6 = this.f3870a.f3868a;
        C0613n c0613n = oVar.d;
        Object obj = a6.get(c0613n);
        if (obj == null) {
            return oVar.b;
        }
        if (!c0613n.c) {
            return oVar.a(obj);
        }
        if (c0613n.b.f3851a != N.ENUM) {
            return obj;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(oVar.a(it.next()));
        }
        return arrayList;
    }

    public final boolean e(o oVar) {
        h(oVar);
        C0609j c0609j = this.f3870a;
        c0609j.getClass();
        C0613n c0613n = oVar.d;
        if (c0613n.c) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return c0609j.f3868a.get(c0613n) != null;
    }

    public final void f() {
        this.f3870a.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(kotlin.reflect.jvm.internal.impl.protobuf.C0605f r9, kotlin.reflect.jvm.internal.impl.protobuf.C0606g r10, kotlin.reflect.jvm.internal.impl.protobuf.C0608i r11, int r12) throws kotlin.reflect.jvm.internal.impl.protobuf.r {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m.g(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.g, kotlin.reflect.jvm.internal.impl.protobuf.i, int):boolean");
    }

    public final void h(o oVar) {
        if (oVar.f3872a != getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public AbstractC0612m(AbstractC0611l abstractC0611l) {
        abstractC0611l.b.g();
        abstractC0611l.c = false;
        this.f3870a = abstractC0611l.b;
    }
}
