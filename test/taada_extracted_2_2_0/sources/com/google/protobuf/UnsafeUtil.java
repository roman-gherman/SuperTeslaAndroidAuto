package com.google.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET;
    private static final int BYTE_ARRAY_ALIGNMENT;
    static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    static final boolean IS_BIG_ENDIAN;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
    private static final Unsafe UNSAFE = getUnsafe();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j6) {
            return (int) j6;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j6, byte[] bArr, long j7, long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j6) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, j6) : UnsafeUtil.getBooleanLittleEndian(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j6) {
            return Double.longBitsToDouble(getLong(obj, j6));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j6) {
            return Float.intBitsToFloat(getInt(obj, j6));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j6, boolean z6) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j6, z6);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j6, z6);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j6, byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j6, double d) {
            putLong(obj, j6, Double.doubleToLongBits(d));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j6, float f6) {
            putInt(obj, j6, Float.floatToIntBits(f6));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j6, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j6, long j7, long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j6) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(obj, j6) : UnsafeUtil.getByteLittleEndian(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j6, byte b) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j6, b);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j6, b);
            }
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j6, byte[] bArr, long j7, long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j6) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, j6) : UnsafeUtil.getBooleanLittleEndian(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j6) {
            return Double.longBitsToDouble(getLong(obj, j6));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j6) {
            return Float.intBitsToFloat(getInt(obj, j6));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j6, boolean z6) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j6, z6);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j6, z6);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j6, byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j6, double d) {
            putLong(obj, j6, Double.doubleToLongBits(d));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j6, float f6) {
            putInt(obj, j6, Float.floatToIntBits(f6));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j6, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j6, long j7, long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j6) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(obj, j6) : UnsafeUtil.getByteLittleEndian(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j6, byte b) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j6, b);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j6, b);
            }
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j6, byte[] bArr, long j7, long j8) {
            this.unsafe.copyMemory((Object) null, j6, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j7, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j6) {
            return this.unsafe.getBoolean(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j6) {
            return this.unsafe.getByte(j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j6) {
            return this.unsafe.getDouble(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j6) {
            return this.unsafe.getFloat(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j6) {
            return this.unsafe.getInt(j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j6) {
            return this.unsafe.getLong(j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j6, boolean z6) {
            this.unsafe.putBoolean(obj, j6, z6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j6, byte b) {
            this.unsafe.putByte(j6, b);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j6, double d) {
            this.unsafe.putDouble(obj, j6, d);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j6, float f6) {
            this.unsafe.putFloat(obj, j6, f6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j6, int i) {
            this.unsafe.putInt(j6, i);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j6, long j7) {
            this.unsafe.putLong(j6, j7);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j6, long j7, long j8) {
            this.unsafe.copyMemory(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j6, (Object) null, j7, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j6) {
            return this.unsafe.getByte(obj, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j6, byte b) {
            this.unsafe.putByte(obj, j6, b);
        }
    }

    public static abstract class MemoryAccessor {
        Unsafe unsafe;

        public MemoryAccessor(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j6, byte[] bArr, long j7, long j8);

        public abstract void copyMemory(byte[] bArr, long j6, long j7, long j8);

        public abstract boolean getBoolean(Object obj, long j6);

        public abstract byte getByte(long j6);

        public abstract byte getByte(Object obj, long j6);

        public abstract double getDouble(Object obj, long j6);

        public abstract float getFloat(Object obj, long j6);

        public abstract int getInt(long j6);

        public final int getInt(Object obj, long j6) {
            return this.unsafe.getInt(obj, j6);
        }

        public abstract long getLong(long j6);

        public final long getLong(Object obj, long j6) {
            return this.unsafe.getLong(obj, j6);
        }

        public final Object getObject(Object obj, long j6) {
            return this.unsafe.getObject(obj, j6);
        }

        public abstract Object getStaticObject(java.lang.reflect.Field field);

        public final long objectFieldOffset(java.lang.reflect.Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j6, boolean z6);

        public abstract void putByte(long j6, byte b);

        public abstract void putByte(Object obj, long j6, byte b);

        public abstract void putDouble(Object obj, long j6, double d);

        public abstract void putFloat(Object obj, long j6, float f6);

        public abstract void putInt(long j6, int i);

        public final void putInt(Object obj, long j6, int i) {
            this.unsafe.putInt(obj, j6, i);
        }

        public abstract void putLong(long j6, long j7);

        public final void putLong(Object obj, long j6, long j7) {
            this.unsafe.putLong(obj, j6, j7);
        }

        public final void putObject(Object obj, long j6, Object obj2) {
            this.unsafe.putObject(obj, j6, obj2);
        }
    }

    static {
        long jArrayBaseOffset = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = jArrayBaseOffset;
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
        BYTE_ARRAY_ALIGNMENT = (int) (jArrayBaseOffset & 7);
        IS_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private UnsafeUtil() {
    }

    public static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    private static java.lang.reflect.Field bufferAddressField() {
        java.lang.reflect.Field field;
        if (Android.isOnAndroidDevice() && (field = field(Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        java.lang.reflect.Field field2 = field(Buffer.class, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    public static void copyMemory(byte[] bArr, long j6, long j7, long j8) {
        MEMORY_ACCESSOR.copyMemory(bArr, j6, j7, j8);
    }

    private static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls2 = MEMORY_CLASS;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static java.lang.reflect.Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(java.lang.reflect.Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1L;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j6, long j7) {
        return (IS_BIG_ENDIAN ? Long.numberOfLeadingZeros(j6 ^ j7) : Long.numberOfTrailingZeros(j6 ^ j7)) >> 3;
    }

    public static boolean getBoolean(Object obj, long j6) {
        return MEMORY_ACCESSOR.getBoolean(obj, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j6) {
        return getByteBigEndian(obj, j6) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j6) {
        return getByteLittleEndian(obj, j6) != 0;
    }

    public static byte getByte(Object obj, long j6) {
        return MEMORY_ACCESSOR.getByte(obj, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j6) {
        return (byte) ((getInt(obj, (-4) & j6) >>> ((int) (((~j6) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j6) {
        return (byte) ((getInt(obj, (-4) & j6) >>> ((int) ((j6 & 3) << 3))) & 255);
    }

    public static double getDouble(Object obj, long j6) {
        return MEMORY_ACCESSOR.getDouble(obj, j6);
    }

    public static float getFloat(Object obj, long j6) {
        return MEMORY_ACCESSOR.getFloat(obj, j6);
    }

    public static int getInt(Object obj, long j6) {
        return MEMORY_ACCESSOR.getInt(obj, j6);
    }

    public static long getLong(Object obj, long j6) {
        return MEMORY_ACCESSOR.getLong(obj, j6);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    public static Object getObject(Object obj, long j6) {
        return MEMORY_ACCESSOR.getObject(obj, j6);
    }

    public static Object getStaticObject(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    public static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws IllegalAccessException {
                    for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    public static int mismatch(byte[] bArr, int i, byte[] bArr2, int i3, int i4) {
        if (i < 0 || i3 < 0 || i4 < 0 || i + i4 > bArr.length || i3 + i4 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            for (int i6 = (BYTE_ARRAY_ALIGNMENT + i) & 7; i5 < i4 && (i6 & 7) != 0; i6++) {
                if (bArr[i + i5] != bArr2[i3 + i5]) {
                    return i5;
                }
                i5++;
            }
            int i7 = ((i4 - i5) & (-8)) + i5;
            while (i5 < i7) {
                long j6 = BYTE_ARRAY_BASE_OFFSET;
                long j7 = i5;
                long j8 = getLong((Object) bArr, ((long) i) + j6 + j7);
                long j9 = getLong((Object) bArr2, j6 + ((long) i3) + j7);
                if (j8 != j9) {
                    return i5 + firstDifferingByteIndexNativeEndian(j8, j9);
                }
                i5 += 8;
            }
        }
        while (i5 < i4) {
            if (bArr[i + i5] != bArr2[i3 + i5]) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static long objectFieldOffset(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    public static void putBoolean(Object obj, long j6, boolean z6) {
        MEMORY_ACCESSOR.putBoolean(obj, j6, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j6, boolean z6) {
        putByteBigEndian(obj, j6, z6 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j6, boolean z6) {
        putByteLittleEndian(obj, j6, z6 ? (byte) 1 : (byte) 0);
    }

    public static void putByte(Object obj, long j6, byte b) {
        MEMORY_ACCESSOR.putByte(obj, j6, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j6, byte b) {
        long j7 = (-4) & j6;
        int i = getInt(obj, j7);
        int i3 = ((~((int) j6)) & 3) << 3;
        putInt(obj, j7, ((255 & b) << i3) | (i & (~(255 << i3))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j6, byte b) {
        long j7 = (-4) & j6;
        int i = (((int) j6) & 3) << 3;
        putInt(obj, j7, ((255 & b) << i) | (getInt(obj, j7) & (~(255 << i))));
    }

    public static void putDouble(Object obj, long j6, double d) {
        MEMORY_ACCESSOR.putDouble(obj, j6, d);
    }

    public static void putFloat(Object obj, long j6, float f6) {
        MEMORY_ACCESSOR.putFloat(obj, j6, f6);
    }

    public static void putInt(Object obj, long j6, int i) {
        MEMORY_ACCESSOR.putInt(obj, j6, i);
    }

    public static void putLong(Object obj, long j6, long j7) {
        MEMORY_ACCESSOR.putLong(obj, j6, j7);
    }

    public static void putObject(Object obj, long j6, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j6, obj2);
    }

    private static boolean supportsUnsafeArrayOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (Android.isOnAndroidDevice()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (bufferAddressField() == null) {
                return false;
            }
            if (Android.isOnAndroidDevice()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    public static void copyMemory(long j6, byte[] bArr, long j7, long j8) {
        MEMORY_ACCESSOR.copyMemory(j6, bArr, j7, j8);
    }

    public static boolean getBoolean(boolean[] zArr, long j6) {
        return MEMORY_ACCESSOR.getBoolean(zArr, (j6 * BOOLEAN_ARRAY_INDEX_SCALE) + BOOLEAN_ARRAY_BASE_OFFSET);
    }

    public static byte getByte(byte[] bArr, long j6) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j6);
    }

    public static double getDouble(double[] dArr, long j6) {
        return MEMORY_ACCESSOR.getDouble(dArr, (j6 * DOUBLE_ARRAY_INDEX_SCALE) + DOUBLE_ARRAY_BASE_OFFSET);
    }

    public static float getFloat(float[] fArr, long j6) {
        return MEMORY_ACCESSOR.getFloat(fArr, (j6 * FLOAT_ARRAY_INDEX_SCALE) + FLOAT_ARRAY_BASE_OFFSET);
    }

    public static int getInt(int[] iArr, long j6) {
        return MEMORY_ACCESSOR.getInt(iArr, (j6 * INT_ARRAY_INDEX_SCALE) + INT_ARRAY_BASE_OFFSET);
    }

    public static long getLong(long[] jArr, long j6) {
        return MEMORY_ACCESSOR.getLong(jArr, (j6 * LONG_ARRAY_INDEX_SCALE) + LONG_ARRAY_BASE_OFFSET);
    }

    public static Object getObject(Object[] objArr, long j6) {
        return MEMORY_ACCESSOR.getObject(objArr, (j6 * OBJECT_ARRAY_INDEX_SCALE) + OBJECT_ARRAY_BASE_OFFSET);
    }

    public static void putBoolean(boolean[] zArr, long j6, boolean z6) {
        MEMORY_ACCESSOR.putBoolean(zArr, (j6 * BOOLEAN_ARRAY_INDEX_SCALE) + BOOLEAN_ARRAY_BASE_OFFSET, z6);
    }

    public static void putByte(byte[] bArr, long j6, byte b) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j6, b);
    }

    public static void putDouble(double[] dArr, long j6, double d) {
        MEMORY_ACCESSOR.putDouble(dArr, (j6 * DOUBLE_ARRAY_INDEX_SCALE) + DOUBLE_ARRAY_BASE_OFFSET, d);
    }

    public static void putFloat(float[] fArr, long j6, float f6) {
        MEMORY_ACCESSOR.putFloat(fArr, (j6 * FLOAT_ARRAY_INDEX_SCALE) + FLOAT_ARRAY_BASE_OFFSET, f6);
    }

    public static void putInt(int[] iArr, long j6, int i) {
        MEMORY_ACCESSOR.putInt(iArr, (j6 * INT_ARRAY_INDEX_SCALE) + INT_ARRAY_BASE_OFFSET, i);
    }

    public static void putLong(long[] jArr, long j6, long j7) {
        MEMORY_ACCESSOR.putLong(jArr, (j6 * LONG_ARRAY_INDEX_SCALE) + LONG_ARRAY_BASE_OFFSET, j7);
    }

    public static void putObject(Object[] objArr, long j6, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, (j6 * OBJECT_ARRAY_INDEX_SCALE) + OBJECT_ARRAY_BASE_OFFSET, obj);
    }

    public static void copyMemory(byte[] bArr, long j6, byte[] bArr2, long j7, long j8) {
        System.arraycopy(bArr, (int) j6, bArr2, (int) j7, (int) j8);
    }

    public static byte getByte(long j6) {
        return MEMORY_ACCESSOR.getByte(j6);
    }

    public static int getInt(long j6) {
        return MEMORY_ACCESSOR.getInt(j6);
    }

    public static long getLong(long j6) {
        return MEMORY_ACCESSOR.getLong(j6);
    }

    public static void putByte(long j6, byte b) {
        MEMORY_ACCESSOR.putByte(j6, b);
    }

    public static void putInt(long j6, int i) {
        MEMORY_ACCESSOR.putInt(j6, i);
    }

    public static void putLong(long j6, long j7) {
        MEMORY_ACCESSOR.putLong(j6, j7);
    }
}
