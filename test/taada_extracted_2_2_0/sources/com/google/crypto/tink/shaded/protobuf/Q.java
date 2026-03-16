package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q extends AbstractC0357c {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, Q> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected J0 unknownFields;

    public Q() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = J0.f2833f;
    }

    public static void c(Q q) throws V {
        if (!i(q, true)) {
            throw new V(new I0().getMessage());
        }
    }

    public static Q f(Class cls) {
        Q q = defaultInstanceMap.get(cls);
        if (q == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                q = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (q != null) {
            return q;
        }
        Q defaultInstanceForType = ((Q) S0.b(cls)).getDefaultInstanceForType();
        if (defaultInstanceForType == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, defaultInstanceForType);
        return defaultInstanceForType;
    }

    public static Object h(Method method, MessageLite messageLite, Object... objArr) {
        try {
            return method.invoke(messageLite, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean i(Q q, boolean z6) {
        byte bByteValue = ((Byte) q.e(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        C0393u0 c0393u0 = C0393u0.c;
        c0393u0.getClass();
        boolean zIsInitialized = c0393u0.a(q.getClass()).isInitialized(q);
        if (z6) {
            q.e(2);
        }
        return zIsInitialized;
    }

    public static Q n(Q q, AbstractC0381o abstractC0381o, D d) throws V {
        AbstractC0388s abstractC0388sH = abstractC0381o.h();
        Q qO = o(q, abstractC0388sH, d);
        abstractC0388sH.a(0);
        c(qO);
        return qO;
    }

    public static Q o(Q q, AbstractC0388s abstractC0388s, D d) throws V {
        Q qM = q.m();
        try {
            C0393u0 c0393u0 = C0393u0.c;
            c0393u0.getClass();
            Schema schemaA = c0393u0.a(qM.getClass());
            C0390t c0390t = abstractC0388s.b;
            if (c0390t == null) {
                c0390t = new C0390t(abstractC0388s);
            }
            schemaA.mergeFrom(qM, c0390t, d);
            schemaA.makeImmutable(qM);
            return qM;
        } catch (I0 e) {
            throw new V(e.getMessage());
        } catch (V e6) {
            if (e6.f2850a) {
                throw new V(e6.getMessage(), e6);
            }
            throw e6;
        } catch (IOException e7) {
            if (e7.getCause() instanceof V) {
                throw ((V) e7.getCause());
            }
            throw new V(e7.getMessage(), e7);
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof V) {
                throw ((V) e8.getCause());
            }
            throw e8;
        }
    }

    public static Q p(Q q, byte[] bArr, int i, int i3, D d) throws V {
        Q qM = q.m();
        try {
            C0393u0 c0393u0 = C0393u0.c;
            c0393u0.getClass();
            Schema schemaA = c0393u0.a(qM.getClass());
            schemaA.mergeFrom(qM, bArr, i, i + i3, new C0367h(d));
            schemaA.makeImmutable(qM);
            return qM;
        } catch (I0 e) {
            throw new V(e.getMessage());
        } catch (V e6) {
            if (e6.f2850a) {
                throw new V(e6.getMessage(), e6);
            }
            throw e6;
        } catch (IOException e7) {
            if (e7.getCause() instanceof V) {
                throw ((V) e7.getCause());
            }
            throw new V(e7.getMessage(), e7);
        } catch (IndexOutOfBoundsException unused) {
            throw V.g();
        }
    }

    public static void q(Class cls, Q q) {
        q.k();
        defaultInstanceMap.put(cls, q);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0357c
    public final int a(Schema schema) {
        int serializedSize;
        int serializedSize2;
        if (j()) {
            if (schema == null) {
                C0393u0 c0393u0 = C0393u0.c;
                c0393u0.getClass();
                serializedSize2 = c0393u0.a(getClass()).getSerializedSize(this);
            } else {
                serializedSize2 = schema.getSerializedSize(this);
            }
            if (serializedSize2 >= 0) {
                return serializedSize2;
            }
            throw new IllegalStateException(B2.b.c(serializedSize2, "serialized size must be non-negative, was "));
        }
        int i = this.memoizedSerializedSize;
        if ((i & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i & Integer.MAX_VALUE;
        }
        if (schema == null) {
            C0393u0 c0393u02 = C0393u0.c;
            c0393u02.getClass();
            serializedSize = c0393u02.a(getClass()).getSerializedSize(this);
        } else {
            serializedSize = schema.getSerializedSize(this);
        }
        r(serializedSize);
        return serializedSize;
    }

    public final O d() {
        return (O) e(5);
    }

    public abstract Object e(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0393u0 c0393u0 = C0393u0.c;
        c0393u0.getClass();
        return c0393u0.a(getClass()).equals(this, (Q) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Q getDefaultInstanceForType() {
        return (Q) e(6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final Parser getParserForType() {
        return (Parser) e(7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final int getSerializedSize() {
        return a(null);
    }

    public final int hashCode() {
        if (j()) {
            C0393u0 c0393u0 = C0393u0.c;
            c0393u0.getClass();
            return c0393u0.a(getClass()).hashCode(this);
        }
        if (this.memoizedHashCode == 0) {
            C0393u0 c0393u02 = C0393u0.c;
            c0393u02.getClass();
            this.memoizedHashCode = c0393u02.a(getClass()).hashCode(this);
        }
        return this.memoizedHashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return i(this, true);
    }

    public final boolean j() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    public final void k() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final O newBuilderForType() {
        return (O) e(5);
    }

    public final Q m() {
        return (Q) e(4);
    }

    public final void r(int i) {
        if (i < 0) {
            throw new IllegalStateException(B2.b.c(i, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final O toBuilder() {
        O o6 = (O) e(5);
        o6.r(this);
        return o6;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = AbstractC0374k0.f2885a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        AbstractC0374k0.c(this, sb, 0);
        return sb.toString();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final void writeTo(AbstractC0398x abstractC0398x) {
        C0393u0 c0393u0 = C0393u0.c;
        c0393u0.getClass();
        Schema schemaA = c0393u0.a(getClass());
        C0400y c0400y = abstractC0398x.c;
        if (c0400y == null) {
            c0400y = new C0400y(abstractC0398x);
        }
        schemaA.writeTo(this, c0400y);
    }
}
