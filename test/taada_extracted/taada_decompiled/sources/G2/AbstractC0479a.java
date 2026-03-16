package g2;

import h2.k0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.reflect.KMutableProperty;

/* JADX INFO: renamed from: g2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0479a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean a(k0 k0Var) {
        if (k0Var instanceof KMutableProperty) {
            Field fieldA = AbstractC0480b.a(k0Var);
            if (!(fieldA != null ? fieldA.isAccessible() : true)) {
                return false;
            }
            Method methodB = AbstractC0480b.b(k0Var.getGetter());
            if (!(methodB != null ? methodB.isAccessible() : true)) {
                return false;
            }
            Method methodB2 = AbstractC0480b.b(((KMutableProperty) k0Var).getSetter());
            if (!(methodB2 != null ? methodB2.isAccessible() : true)) {
                return false;
            }
        } else {
            Field fieldA2 = AbstractC0480b.a(k0Var);
            if (!(fieldA2 != null ? fieldA2.isAccessible() : true)) {
                return false;
            }
            Method methodB3 = AbstractC0480b.b(k0Var.getGetter());
            if (!(methodB3 != null ? methodB3.isAccessible() : true)) {
                return false;
            }
        }
        return true;
    }
}
