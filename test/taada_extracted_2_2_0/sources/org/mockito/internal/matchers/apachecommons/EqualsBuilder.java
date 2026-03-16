package org.mockito.internal.matchers.apachecommons;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
class EqualsBuilder {
    private boolean isEquals = true;

    private static boolean reflectionAppend(Object obj, Object obj2, Class<?> cls, EqualsBuilder equalsBuilder, boolean z6, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        List listAsList = strArr != null ? Arrays.asList(strArr) : Collections.EMPTY_LIST;
        MemberAccessor memberAccessor = Plugins.getMemberAccessor();
        for (int i = 0; i < declaredFields.length && equalsBuilder.isEquals; i++) {
            Field field = declaredFields[i];
            if (!listAsList.contains(field.getName()) && field.getName().indexOf(36) == -1 && ((z6 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    equalsBuilder.append(memberAccessor.get(field, obj), memberAccessor.get(field, obj2));
                } catch (IllegalAccessException | RuntimeException unused) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean reflectionEquals(Object obj, Object obj2) {
        return reflectionEquals(obj, obj2, false, null, null);
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            setEquals(false);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if ((obj instanceof BigDecimal) && (obj2 instanceof BigDecimal)) {
                this.isEquals = ((BigDecimal) obj).compareTo((BigDecimal) obj2) == 0;
                return this;
            }
            this.isEquals = obj.equals(obj2);
            return this;
        }
        if (obj.getClass() != obj2.getClass()) {
            setEquals(false);
            return this;
        }
        if (obj instanceof long[]) {
            append((long[]) obj, (long[]) obj2);
            return this;
        }
        if (obj instanceof int[]) {
            append((int[]) obj, (int[]) obj2);
            return this;
        }
        if (obj instanceof short[]) {
            append((short[]) obj, (short[]) obj2);
            return this;
        }
        if (obj instanceof char[]) {
            append((char[]) obj, (char[]) obj2);
            return this;
        }
        if (obj instanceof byte[]) {
            append((byte[]) obj, (byte[]) obj2);
            return this;
        }
        if (obj instanceof double[]) {
            append((double[]) obj, (double[]) obj2);
            return this;
        }
        if (obj instanceof float[]) {
            append((float[]) obj, (float[]) obj2);
            return this;
        }
        if (obj instanceof boolean[]) {
            append((boolean[]) obj, (boolean[]) obj2);
            return this;
        }
        append((Object[]) obj, (Object[]) obj2);
        return this;
    }

    public EqualsBuilder appendSuper(boolean z6) {
        this.isEquals = z6 & this.isEquals;
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    public void setEquals(boolean z6) {
        this.isEquals = z6;
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String[] strArr) {
        return reflectionEquals(obj, obj2, false, null, strArr);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z6) {
        return reflectionEquals(obj, obj2, z6, null, null);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z6, Class<?> cls) {
        return reflectionEquals(obj, obj2, z6, cls, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean reflectionEquals(java.lang.Object r9, java.lang.Object r10, boolean r11, java.lang.Class<?> r12, java.lang.String[] r13) {
        /*
            if (r9 != r10) goto L4
            r0 = 1
            return r0
        L4:
            r6 = 0
            if (r9 == 0) goto L59
            if (r10 != 0) goto La
            goto L59
        La:
            java.lang.Class r2 = r9.getClass()
            java.lang.Class r3 = r10.getClass()
            boolean r4 = r2.isInstance(r10)
            if (r4 == 0) goto L1f
            boolean r4 = r3.isInstance(r9)
            if (r4 != 0) goto L2d
            goto L2c
        L1f:
            boolean r4 = r3.isInstance(r9)
            if (r4 == 0) goto L59
            boolean r4 = r2.isInstance(r10)
            if (r4 != 0) goto L2c
            goto L2d
        L2c:
            r2 = r3
        L2d:
            org.mockito.internal.matchers.apachecommons.EqualsBuilder r3 = new org.mockito.internal.matchers.apachecommons.EqualsBuilder
            r3.<init>()
            r0 = r9
            r1 = r10
            r4 = r11
            r5 = r13
            boolean r7 = reflectionAppend(r0, r1, r2, r3, r4, r5)
            if (r7 == 0) goto L3d
            return r6
        L3d:
            java.lang.Class r0 = r2.getSuperclass()
            if (r0 == 0) goto L54
            if (r2 == r12) goto L54
            java.lang.Class r2 = r2.getSuperclass()
            r0 = r9
            r1 = r10
            r4 = r11
            r5 = r13
            boolean r8 = reflectionAppend(r0, r1, r2, r3, r4, r5)
            if (r8 == 0) goto L3d
            return r6
        L54:
            boolean r0 = r3.isEquals()
            return r0
        L59:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.matchers.apachecommons.EqualsBuilder.reflectionEquals(java.lang.Object, java.lang.Object, boolean, java.lang.Class, java.lang.String[]):boolean");
    }

    public EqualsBuilder append(long j6, long j7) {
        this.isEquals = (j6 == j7) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(int i, int i3) {
        this.isEquals = (i == i3) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(short s3, short s6) {
        this.isEquals = (s3 == s6) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(char c, char c6) {
        this.isEquals = (c == c6) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(byte b, byte b2) {
        this.isEquals = (b == b2) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(double d, double d6) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d), Double.doubleToLongBits(d6));
    }

    public EqualsBuilder append(float f6, float f7) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f6), Float.floatToIntBits(f7));
    }

    public EqualsBuilder append(boolean z6, boolean z7) {
        this.isEquals = (z6 == z7) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (this.isEquals && objArr != objArr2) {
            if (objArr != null && objArr2 != null) {
                if (objArr.length != objArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < objArr.length && this.isEquals; i++) {
                    append(objArr[i], objArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (this.isEquals && jArr != jArr2) {
            if (jArr != null && jArr2 != null) {
                if (jArr.length != jArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < jArr.length && this.isEquals; i++) {
                    append(jArr[i], jArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (this.isEquals && iArr != iArr2) {
            if (iArr != null && iArr2 != null) {
                if (iArr.length != iArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < iArr.length && this.isEquals; i++) {
                    append(iArr[i], iArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (this.isEquals && sArr != sArr2) {
            if (sArr != null && sArr2 != null) {
                if (sArr.length != sArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < sArr.length && this.isEquals; i++) {
                    append(sArr[i], sArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (this.isEquals && cArr != cArr2) {
            if (cArr != null && cArr2 != null) {
                if (cArr.length != cArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < cArr.length && this.isEquals; i++) {
                    append(cArr[i], cArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.isEquals && bArr != bArr2) {
            if (bArr != null && bArr2 != null) {
                if (bArr.length != bArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < bArr.length && this.isEquals; i++) {
                    append(bArr[i], bArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (this.isEquals && dArr != dArr2) {
            if (dArr != null && dArr2 != null) {
                if (dArr.length != dArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < dArr.length && this.isEquals; i++) {
                    append(dArr[i], dArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (this.isEquals && fArr != fArr2) {
            if (fArr != null && fArr2 != null) {
                if (fArr.length != fArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < fArr.length && this.isEquals; i++) {
                    append(fArr[i], fArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.isEquals && zArr != zArr2) {
            if (zArr != null && zArr2 != null) {
                if (zArr.length != zArr2.length) {
                    setEquals(false);
                    return this;
                }
                for (int i = 0; i < zArr.length && this.isEquals; i++) {
                    append(zArr[i], zArr2[i]);
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }
}
