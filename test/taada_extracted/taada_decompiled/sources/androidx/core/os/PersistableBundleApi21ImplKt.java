package androidx.core.os;

import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "capacity", "Landroid/os/PersistableBundle;", "createPersistableBundle", "(I)Landroid/os/PersistableBundle;", "persistableBundle", "", "key", "value", "LN1/m;", "putValue", "(Landroid/os/PersistableBundle;Ljava/lang/String;Ljava/lang/Object;)V", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = new PersistableBundleApi21ImplKt();

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    public static final PersistableBundle createPersistableBundle(int capacity) {
        return new PersistableBundle(capacity);
    }

    @JvmStatic
    public static final void putValue(PersistableBundle persistableBundle, String key, Object value) {
        if (value == null) {
            persistableBundle.putString(key, null);
            return;
        }
        if (value instanceof Boolean) {
            PersistableBundleApi22ImplKt.putBoolean(persistableBundle, key, ((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Double) {
            persistableBundle.putDouble(key, ((Number) value).doubleValue());
            return;
        }
        if (value instanceof Integer) {
            persistableBundle.putInt(key, ((Number) value).intValue());
            return;
        }
        if (value instanceof Long) {
            persistableBundle.putLong(key, ((Number) value).longValue());
            return;
        }
        if (value instanceof String) {
            persistableBundle.putString(key, (String) value);
            return;
        }
        if (value instanceof boolean[]) {
            PersistableBundleApi22ImplKt.putBooleanArray(persistableBundle, key, (boolean[]) value);
            return;
        }
        if (value instanceof double[]) {
            persistableBundle.putDoubleArray(key, (double[]) value);
            return;
        }
        if (value instanceof int[]) {
            persistableBundle.putIntArray(key, (int[]) value);
            return;
        }
        if (value instanceof long[]) {
            persistableBundle.putLongArray(key, (long[]) value);
            return;
        }
        if (!(value instanceof Object[])) {
            throw new IllegalArgumentException("Illegal value type " + value.getClass().getCanonicalName() + " for key \"" + key + '\"');
        }
        Class<?> componentType = value.getClass().getComponentType();
        h.c(componentType);
        if (String.class.isAssignableFrom(componentType)) {
            persistableBundle.putStringArray(key, (String[]) value);
            return;
        }
        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + key + '\"');
    }
}
