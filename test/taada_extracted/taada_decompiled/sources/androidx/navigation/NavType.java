package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.utils.io.jvm.javaio.q;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.text.r;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b&\u0018\u0000 !*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006!\"#$%&B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH¦\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J'\u0010\u0015\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0015\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0015\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u0004\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001b¨\u0006'"}, d2 = {"Landroidx/navigation/NavType;", "T", "", "", "isNullableAllowed", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Z)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "LN1/m;", "put", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Object;", "previousValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "parseAndPut", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "serializeAsValue", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "Z", "()Z", "name", "Ljava/lang/String;", "getName", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class NavType<T> {
    private final boolean isNullableAllowed;
    private final String name = "nav_type";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final NavType<Integer> IntType = new NavType<Integer>() { // from class: androidx.navigation.NavType$Companion$IntType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_INT;
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Integer num) {
            put(bundle, str, num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            Object obj = bundle.get(key);
            h.d(obj, "null cannot be cast to non-null type kotlin.Int");
            return (Integer) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer parseValue(String value) {
            int i;
            h.f(value, "value");
            if (r.C(value, "0x")) {
                String strSubstring = value.substring(2);
                h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                q.c(16);
                i = Integer.parseInt(strSubstring, 16);
            } else {
                i = Integer.parseInt(value);
            }
            return Integer.valueOf(i);
        }

        public void put(Bundle bundle, String key, int value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putInt(key, value);
        }
    };
    public static final NavType<Integer> ReferenceType = new NavType<Integer>() { // from class: androidx.navigation.NavType$Companion$ReferenceType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "reference";
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Integer num) {
            put(bundle, str, num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            Object obj = bundle.get(key);
            h.d(obj, "null cannot be cast to non-null type kotlin.Int");
            return (Integer) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer parseValue(String value) {
            int i;
            h.f(value, "value");
            if (r.C(value, "0x")) {
                String strSubstring = value.substring(2);
                h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                q.c(16);
                i = Integer.parseInt(strSubstring, 16);
            } else {
                i = Integer.parseInt(value);
            }
            return Integer.valueOf(i);
        }

        public void put(Bundle bundle, String key, int value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putInt(key, value);
        }
    };
    public static final NavType<int[]> IntArrayType = new NavType<int[]>() { // from class: androidx.navigation.NavType$Companion$IntArrayType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "integer[]";
        }

        @Override // androidx.navigation.NavType
        public int[] get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (int[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, int[] value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putIntArray(key, value);
        }

        @Override // androidx.navigation.NavType
        public int[] parseValue(String value) {
            h.f(value, "value");
            return new int[]{NavType.IntType.parseValue(value).intValue()};
        }

        @Override // androidx.navigation.NavType
        public int[] parseValue(String value, int[] previousValue) {
            h.f(value, "value");
            int[] elements = parseValue(value);
            if (previousValue == null) {
                return elements;
            }
            h.f(elements, "elements");
            int length = previousValue.length;
            int length2 = elements.length;
            int[] result = Arrays.copyOf(previousValue, length + length2);
            System.arraycopy(elements, 0, result, length, length2);
            h.e(result, "result");
            return result;
        }
    };
    public static final NavType<Long> LongType = new NavType<Long>() { // from class: androidx.navigation.NavType$Companion$LongType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "long";
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Long l6) {
            put(bundle, str, l6.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            Object obj = bundle.get(key);
            h.d(obj, "null cannot be cast to non-null type kotlin.Long");
            return (Long) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long parseValue(String value) {
            String strSubstring;
            long j6;
            h.f(value, "value");
            if (r.w(value, "L")) {
                strSubstring = value.substring(0, value.length() - 1);
                h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                strSubstring = value;
            }
            if (r.C(value, "0x")) {
                String strSubstring2 = strSubstring.substring(2);
                h.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                q.c(16);
                j6 = Long.parseLong(strSubstring2, 16);
            } else {
                j6 = Long.parseLong(strSubstring);
            }
            return Long.valueOf(j6);
        }

        public void put(Bundle bundle, String key, long value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putLong(key, value);
        }
    };
    public static final NavType<long[]> LongArrayType = new NavType<long[]>() { // from class: androidx.navigation.NavType$Companion$LongArrayType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "long[]";
        }

        @Override // androidx.navigation.NavType
        public long[] get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (long[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, long[] value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putLongArray(key, value);
        }

        @Override // androidx.navigation.NavType
        public long[] parseValue(String value) {
            h.f(value, "value");
            return new long[]{NavType.LongType.parseValue(value).longValue()};
        }

        @Override // androidx.navigation.NavType
        public long[] parseValue(String value, long[] previousValue) {
            h.f(value, "value");
            long[] elements = parseValue(value);
            if (previousValue == null) {
                return elements;
            }
            h.f(elements, "elements");
            int length = previousValue.length;
            int length2 = elements.length;
            long[] result = Arrays.copyOf(previousValue, length + length2);
            System.arraycopy(elements, 0, result, length, length2);
            h.e(result, "result");
            return result;
        }
    };
    public static final NavType<Float> FloatType = new NavType<Float>() { // from class: androidx.navigation.NavType$Companion$FloatType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_FLOAT;
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Float f6) {
            put(bundle, str, f6.floatValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            Object obj = bundle.get(key);
            h.d(obj, "null cannot be cast to non-null type kotlin.Float");
            return (Float) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float parseValue(String value) {
            h.f(value, "value");
            return Float.valueOf(Float.parseFloat(value));
        }

        public void put(Bundle bundle, String key, float value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putFloat(key, value);
        }
    };
    public static final NavType<float[]> FloatArrayType = new NavType<float[]>() { // from class: androidx.navigation.NavType$Companion$FloatArrayType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "float[]";
        }

        @Override // androidx.navigation.NavType
        public float[] get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (float[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, float[] value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putFloatArray(key, value);
        }

        @Override // androidx.navigation.NavType
        public float[] parseValue(String value) {
            h.f(value, "value");
            return new float[]{NavType.FloatType.parseValue(value).floatValue()};
        }

        @Override // androidx.navigation.NavType
        public float[] parseValue(String value, float[] previousValue) {
            h.f(value, "value");
            float[] elements = parseValue(value);
            if (previousValue == null) {
                return elements;
            }
            h.f(elements, "elements");
            int length = previousValue.length;
            int length2 = elements.length;
            float[] result = Arrays.copyOf(previousValue, length + length2);
            System.arraycopy(elements, 0, result, length, length2);
            h.e(result, "result");
            return result;
        }
    };
    public static final NavType<Boolean> BoolType = new NavType<Boolean>() { // from class: androidx.navigation.NavType$Companion$BoolType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_BOOLEAN;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean parseValue(String value) {
            boolean z6;
            h.f(value, "value");
            if (value.equals("true")) {
                z6 = true;
            } else {
                if (!value.equals("false")) {
                    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                }
                z6 = false;
            }
            return Boolean.valueOf(z6);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Boolean bool) {
            put(bundle, str, bool.booleanValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (Boolean) bundle.get(key);
        }

        public void put(Bundle bundle, String key, boolean value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putBoolean(key, value);
        }
    };
    public static final NavType<boolean[]> BoolArrayType = new NavType<boolean[]>() { // from class: androidx.navigation.NavType$Companion$BoolArrayType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "boolean[]";
        }

        @Override // androidx.navigation.NavType
        public boolean[] get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (boolean[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, boolean[] value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putBooleanArray(key, value);
        }

        @Override // androidx.navigation.NavType
        public boolean[] parseValue(String value) {
            h.f(value, "value");
            return new boolean[]{NavType.BoolType.parseValue(value).booleanValue()};
        }

        @Override // androidx.navigation.NavType
        public boolean[] parseValue(String value, boolean[] previousValue) {
            h.f(value, "value");
            boolean[] elements = parseValue(value);
            if (previousValue == null) {
                return elements;
            }
            h.f(elements, "elements");
            int length = previousValue.length;
            int length2 = elements.length;
            boolean[] result = Arrays.copyOf(previousValue, length + length2);
            System.arraycopy(elements, 0, result, length, length2);
            h.e(result, "result");
            return result;
        }
    };
    public static final NavType<String> StringType = new NavType<String>() { // from class: androidx.navigation.NavType$Companion$StringType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_STRING;
        }

        @Override // androidx.navigation.NavType
        public String parseValue(String value) {
            h.f(value, "value");
            if (value.equals("null")) {
                return null;
            }
            return value;
        }

        @Override // androidx.navigation.NavType
        public String get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (String) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, String value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putString(key, value);
        }

        @Override // androidx.navigation.NavType
        public String serializeAsValue(String value) {
            String strEncode = value != null ? Uri.encode(value) : null;
            return strEncode == null ? "null" : strEncode;
        }
    };
    public static final NavType<String[]> StringArrayType = new NavType<String[]>() { // from class: androidx.navigation.NavType$Companion$StringArrayType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "string[]";
        }

        @Override // androidx.navigation.NavType
        public String[] get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (String[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, String[] value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            bundle.putStringArray(key, value);
        }

        @Override // androidx.navigation.NavType
        public String[] parseValue(String value) {
            h.f(value, "value");
            return new String[]{value};
        }

        @Override // androidx.navigation.NavType
        public String[] parseValue(String value, String[] previousValue) {
            h.f(value, "value");
            String[] elements = parseValue(value);
            if (previousValue == null) {
                return elements;
            }
            h.f(elements, "elements");
            int length = previousValue.length;
            int length2 = elements.length;
            Object[] result = Arrays.copyOf(previousValue, length + length2);
            System.arraycopy(elements, 0, result, length, length2);
            h.e(result, "result");
            return (String[]) result;
        }
    };

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType$Companion;", "", "()V", "BoolArrayType", "Landroidx/navigation/NavType;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "", "ReferenceType", "StringArrayType", "", "", "StringType", "fromArgType", "type", "packageName", "inferFromValue", "value", "inferFromValueType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @JvmStatic
        public NavType<?> fromArgType(String type, String packageName) {
            NavType<Integer> navType = NavType.IntType;
            if (h.a(navType.getName(), type)) {
                return navType;
            }
            NavType navType2 = NavType.IntArrayType;
            if (h.a(navType2.getName(), type)) {
                return navType2;
            }
            NavType<Long> navType3 = NavType.LongType;
            if (h.a(navType3.getName(), type)) {
                return navType3;
            }
            NavType navType4 = NavType.LongArrayType;
            if (h.a(navType4.getName(), type)) {
                return navType4;
            }
            NavType<Boolean> navType5 = NavType.BoolType;
            if (h.a(navType5.getName(), type)) {
                return navType5;
            }
            NavType navType6 = NavType.BoolArrayType;
            if (h.a(navType6.getName(), type)) {
                return navType6;
            }
            NavType<String> navType7 = NavType.StringType;
            if (!h.a(navType7.getName(), type)) {
                NavType navType8 = NavType.StringArrayType;
                if (h.a(navType8.getName(), type)) {
                    return navType8;
                }
                NavType<Float> navType9 = NavType.FloatType;
                if (h.a(navType9.getName(), type)) {
                    return navType9;
                }
                NavType navType10 = NavType.FloatArrayType;
                if (h.a(navType10.getName(), type)) {
                    return navType10;
                }
                NavType<Integer> navType11 = NavType.ReferenceType;
                if (h.a(navType11.getName(), type)) {
                    return navType11;
                }
                if (type != null && type.length() != 0) {
                    try {
                        String strConcat = (!r.C(type, ".") || packageName == null) ? type : packageName.concat(type);
                        if (r.w(type, "[]")) {
                            strConcat = strConcat.substring(0, strConcat.length() - 2);
                            h.e(strConcat, "this as java.lang.String…ing(startIndex, endIndex)");
                            Class<?> cls = Class.forName(strConcat);
                            if (Parcelable.class.isAssignableFrom(cls)) {
                                return new ParcelableArrayType(cls);
                            }
                            if (Serializable.class.isAssignableFrom(cls)) {
                                return new SerializableArrayType(cls);
                            }
                        } else {
                            Class<?> cls2 = Class.forName(strConcat);
                            if (Parcelable.class.isAssignableFrom(cls2)) {
                                return new ParcelableType(cls2);
                            }
                            if (Enum.class.isAssignableFrom(cls2)) {
                                return new EnumType(cls2);
                            }
                            if (Serializable.class.isAssignableFrom(cls2)) {
                                return new SerializableType(cls2);
                            }
                        }
                        throw new IllegalArgumentException(strConcat + " is not Serializable or Parcelable.");
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return navType7;
        }

        @JvmStatic
        public final NavType<Object> inferFromValue(String value) {
            h.f(value, "value");
            try {
                try {
                    try {
                        try {
                            NavType<Integer> navType = NavType.IntType;
                            navType.parseValue(value);
                            h.d(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                            return navType;
                        } catch (IllegalArgumentException unused) {
                            NavType<Boolean> navType2 = NavType.BoolType;
                            navType2.parseValue(value);
                            h.d(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                            return navType2;
                        }
                    } catch (IllegalArgumentException unused2) {
                        NavType<Long> navType3 = NavType.LongType;
                        navType3.parseValue(value);
                        h.d(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                        return navType3;
                    }
                } catch (IllegalArgumentException unused3) {
                    NavType<String> navType4 = NavType.StringType;
                    h.d(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                    return navType4;
                }
            } catch (IllegalArgumentException unused4) {
                NavType<Float> navType5 = NavType.FloatType;
                navType5.parseValue(value);
                h.d(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType5;
            }
        }

        @JvmStatic
        public final NavType<Object> inferFromValueType(Object value) {
            if (value instanceof Integer) {
                NavType<Integer> navType = NavType.IntType;
                h.d(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType;
            }
            if (value instanceof int[]) {
                NavType<int[]> navType2 = NavType.IntArrayType;
                h.d(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType2;
            }
            if (value instanceof Long) {
                NavType<Long> navType3 = NavType.LongType;
                h.d(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType3;
            }
            if (value instanceof long[]) {
                NavType<long[]> navType4 = NavType.LongArrayType;
                h.d(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType4;
            }
            if (value instanceof Float) {
                NavType<Float> navType5 = NavType.FloatType;
                h.d(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType5;
            }
            if (value instanceof float[]) {
                NavType<float[]> navType6 = NavType.FloatArrayType;
                h.d(navType6, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType6;
            }
            if (value instanceof Boolean) {
                NavType<Boolean> navType7 = NavType.BoolType;
                h.d(navType7, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType7;
            }
            if (value instanceof boolean[]) {
                NavType<boolean[]> navType8 = NavType.BoolArrayType;
                h.d(navType8, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType8;
            }
            if ((value instanceof String) || value == null) {
                NavType<String> navType9 = NavType.StringType;
                h.d(navType9, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType9;
            }
            if ((value instanceof Object[]) && (((Object[]) value) instanceof String[])) {
                NavType<String[]> navType10 = NavType.StringArrayType;
                h.d(navType10, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType10;
            }
            if (value.getClass().isArray()) {
                Class<?> componentType = value.getClass().getComponentType();
                h.c(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = value.getClass().getComponentType();
                    h.d(componentType2, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                    return new ParcelableArrayType(componentType2);
                }
            }
            if (value.getClass().isArray()) {
                Class<?> componentType3 = value.getClass().getComponentType();
                h.c(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = value.getClass().getComponentType();
                    h.d(componentType4, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    return new SerializableArrayType(componentType4);
                }
            }
            if (value instanceof Parcelable) {
                return new ParcelableType(value.getClass());
            }
            if (value instanceof Enum) {
                return new EnumType(value.getClass());
            }
            if (value instanceof Serializable) {
                return new SerializableType(value.getClass());
            }
            throw new IllegalArgumentException("Object of type " + value.getClass().getName() + " is not supported for navigation arguments.");
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "Landroid/os/Parcelable;", "D", "Landroidx/navigation/NavType;", "", "Ljava/lang/Class;", "type", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "LN1/m;", "put", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "parseValue", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "arrayType", "Ljava/lang/Class;", "getName", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(Class<D> type) {
            super(true);
            h.f(type, "type");
            if (!Parcelable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Parcelable.").toString());
            }
            try {
                this.arrayType = (Class<D[]>) Class.forName("[L" + type.getName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !ParcelableArrayType.class.equals(other.getClass())) {
                return false;
            }
            return h.a(this.arrayType, ((ParcelableArrayType) other).arrayType);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.arrayType.getName();
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public D[] get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (D[]) ((Parcelable[]) bundle.get(key));
        }

        @Override // androidx.navigation.NavType
        public D[] parseValue(String value) {
            h.f(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, D[] value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            this.arrayType.cast(value);
            bundle.putParcelableArray(key, value);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType$ParcelableType;", "D", "Landroidx/navigation/NavType;", "Ljava/lang/Class;", "type", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "LN1/m;", "put", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/Class;", "getName", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ParcelableType<D> extends NavType<D> {
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableType(Class<D> type) {
            super(true);
            h.f(type, "type");
            if (Parcelable.class.isAssignableFrom(type) || Serializable.class.isAssignableFrom(type)) {
                this.type = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Parcelable or Serializable.").toString());
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !ParcelableType.class.equals(other.getClass())) {
                return false;
            }
            return h.a(this.type, ((ParcelableType) other).type);
        }

        @Override // androidx.navigation.NavType
        public D get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (D) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        public D parseValue(String value) {
            h.f(value, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, D value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            this.type.cast(value);
            if (value == null || (value instanceof Parcelable)) {
                bundle.putParcelable(key, (Parcelable) value);
            } else if (value instanceof Serializable) {
                bundle.putSerializable(key, (Serializable) value);
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "Ljava/io/Serializable;", "D", "Landroidx/navigation/NavType;", "", "Ljava/lang/Class;", "type", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "LN1/m;", "put", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "parseValue", "(Ljava/lang/String;)[Ljava/io/Serializable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "arrayType", "Ljava/lang/Class;", "getName", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(Class<D> type) {
            super(true);
            h.f(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            try {
                this.arrayType = (Class<D[]>) Class.forName("[L" + type.getName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !SerializableArrayType.class.equals(other.getClass())) {
                return false;
            }
            return h.a(this.arrayType, ((SerializableArrayType) other).arrayType);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.arrayType.getName();
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public D[] get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (D[]) ((Serializable[]) bundle.get(key));
        }

        @Override // androidx.navigation.NavType
        public D[] parseValue(String value) {
            h.f(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, D[] value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            this.arrayType.cast(value);
            bundle.putSerializable(key, value);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0017\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001f\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010!\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/navigation/NavType$SerializableType;", "Ljava/io/Serializable;", "D", "Landroidx/navigation/NavType;", "Ljava/lang/Class;", "type", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/Class;)V", "", "nullableAllowed", "(ZLjava/lang/Class;)V", "Landroid/os/Bundle;", "bundle", "", "key", "value", "LN1/m;", "put", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "parseValue", "(Ljava/lang/String;)Ljava/io/Serializable;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/Class;", "getName", "()Ljava/lang/String;", "name", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(Class<D> type) {
            super(true);
            h.f(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            if (!type.isEnum()) {
                this.type = type;
                return;
            }
            throw new IllegalArgumentException((type + " is an Enum. You should use EnumType instead.").toString());
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof SerializableType) {
                return h.a(this.type, ((SerializableType) other).type);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        public D get(Bundle bundle, String key) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            return (D) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public D parseValue(String value) {
            h.f(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, D value) {
            h.f(bundle, "bundle");
            h.f(key, "key");
            h.f(value, "value");
            this.type.cast(value);
            bundle.putSerializable(key, value);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z6, Class<D> type) {
            super(z6);
            h.f(type, "type");
            if (Serializable.class.isAssignableFrom(type)) {
                this.type = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }
    }

    public NavType(boolean z6) {
        this.isNullableAllowed = z6;
    }

    @JvmStatic
    public static NavType<?> fromArgType(String str, String str2) {
        return INSTANCE.fromArgType(str, str2);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValue(String str) {
        return INSTANCE.inferFromValue(str);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValueType(Object obj) {
        return INSTANCE.inferFromValueType(obj);
    }

    public abstract T get(Bundle bundle, String key);

    public String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: isNullableAllowed, reason: from getter */
    public boolean getIsNullableAllowed() {
        return this.isNullableAllowed;
    }

    public final T parseAndPut(Bundle bundle, String key, String value) {
        h.f(bundle, "bundle");
        h.f(key, "key");
        h.f(value, "value");
        T value2 = parseValue(value);
        put(bundle, key, value2);
        return value2;
    }

    public abstract T parseValue(String value);

    public T parseValue(String value, T previousValue) {
        h.f(value, "value");
        return parseValue(value);
    }

    public abstract void put(Bundle bundle, String key, T value);

    public String serializeAsValue(T value) {
        return String.valueOf(value);
    }

    public String toString() {
        return getName();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\f\b\u0001\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavType$EnumType;", "D", "", "Landroidx/navigation/NavType$SerializableType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Enum;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumType(Class<D> type) {
            super(false, type);
            h.f(type, "type");
            if (type.isEnum()) {
                this.type = type;
                return;
            }
            throw new IllegalArgumentException((type + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public D parseValue(String value) {
            D d;
            h.f(value, "value");
            D[] enumConstants = this.type.getEnumConstants();
            h.e(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    d = null;
                    break;
                }
                d = enumConstants[i];
                if (r.x(d.name(), value)) {
                    break;
                }
                i++;
            }
            D d6 = d;
            if (d6 != null) {
                return d6;
            }
            StringBuilder sbM = B2.b.m("Enum value ", value, " not found for type ");
            sbM.append(this.type.getName());
            sbM.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            throw new IllegalArgumentException(sbM.toString());
        }
    }

    public final T parseAndPut(Bundle bundle, String key, String value, T previousValue) {
        h.f(bundle, "bundle");
        h.f(key, "key");
        if (!bundle.containsKey(key)) {
            throw new IllegalArgumentException("There is no previous value in this bundle.");
        }
        if (value == null) {
            return previousValue;
        }
        T value2 = parseValue(value, previousValue);
        put(bundle, key, value2);
        return value2;
    }
}
