package kotlin.jvm.internal;

import java.util.Objects;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public class k extends j {
    public k(KClass kClass, String str, String str2) {
        super(b.NO_RECEIVER, ((ClassBasedDeclarationContainer) kClass).getJClass(), str, str2, !Objects.nonNull(kClass) ? 1 : 0);
    }

    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }

    public k(Class cls, String str, String str2) {
        super(b.NO_RECEIVER, cls, str, str2, 0);
    }
}
