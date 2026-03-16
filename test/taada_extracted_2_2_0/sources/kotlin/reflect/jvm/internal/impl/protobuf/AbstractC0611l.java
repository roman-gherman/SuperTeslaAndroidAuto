package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0611l extends AbstractC0610k implements GeneratedMessageLite$ExtendableMessageOrBuilder {
    public C0609j b = C0609j.c;
    public boolean c;

    public final void b(AbstractC0612m abstractC0612m) {
        A a6;
        if (!this.c) {
            this.b = this.b.clone();
            this.c = true;
        }
        C0609j c0609j = this.b;
        C0609j c0609j2 = abstractC0612m.f3871a;
        c0609j.getClass();
        int i = 0;
        while (true) {
            int size = c0609j2.f3869a.b.size();
            a6 = c0609j2.f3869a;
            if (i >= size) {
                break;
            }
            c0609j.h((Map.Entry) a6.b.get(i));
            i++;
        }
        Iterator it = a6.c().iterator();
        while (it.hasNext()) {
            c0609j.h((Map.Entry) it.next());
        }
    }
}
