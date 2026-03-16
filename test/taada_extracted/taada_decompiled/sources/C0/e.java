package C0;

import G0.EnumC0046d1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f143a;
    public final Map b;
    public final Class c;

    public e(Class cls, D0.c... cVarArr) {
        this.f143a = cls;
        HashMap map = new HashMap();
        for (D0.c cVar : cVarArr) {
            boolean zContainsKey = map.containsKey(cVar.f226a);
            Class cls2 = cVar.f226a;
            if (zContainsKey) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls2, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
            }
            map.put(cls2, cVar);
        }
        if (cVarArr.length > 0) {
            this.c = cVarArr[0].f226a;
        } else {
            this.c = Void.class;
        }
        this.b = Collections.unmodifiableMap(map);
    }

    public int a() {
        return 1;
    }

    public abstract String b();

    public final Object c(MessageLite messageLite, Class cls) {
        D0.c cVar = (D0.c) this.b.get(cls);
        if (cVar != null) {
            return cVar.a(messageLite);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract d d();

    public abstract EnumC0046d1 e();

    public abstract MessageLite f(AbstractC0381o abstractC0381o);

    public abstract void g(MessageLite messageLite);
}
