package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0400y implements Writer, SchemaFactory {
    public static final N b = new N(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2926a;

    public C0400y(AbstractC0398x abstractC0398x) {
        Charset charset = T.f2849a;
        this.f2926a = abstractC0398x;
        abstractC0398x.c = this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.SchemaFactory
    public Schema createSchema(Class cls) {
        Class cls2;
        Class cls3 = AbstractC0399x0.f2925a;
        if (!Q.class.isAssignableFrom(cls) && (cls2 = AbstractC0399x0.f2925a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
        MessageInfo messageInfoMessageInfoFor = ((C0362e0) this.f2926a).messageInfoFor(cls);
        if (messageInfoMessageInfoFor.isMessageSetWireFormat()) {
            if (Q.class.isAssignableFrom(cls)) {
                return new C0378m0(AbstractC0399x0.d, G.f2813a, messageInfoMessageInfoFor.getDefaultInstance());
            }
            K0 k02 = AbstractC0399x0.b;
            E e = G.b;
            if (e != null) {
                return new C0378m0(k02, e, messageInfoMessageInfoFor.getDefaultInstance());
            }
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        boolean zIsAssignableFrom = Q.class.isAssignableFrom(cls);
        EnumC0391t0 enumC0391t0 = EnumC0391t0.f2916a;
        if (zIsAssignableFrom) {
            return messageInfoMessageInfoFor.getSyntax() == enumC0391t0 ? C0376l0.u(messageInfoMessageInfoFor, AbstractC0386q0.b, AbstractC0356b0.b, AbstractC0399x0.d, G.f2813a, AbstractC0372j0.b) : C0376l0.u(messageInfoMessageInfoFor, AbstractC0386q0.b, AbstractC0356b0.b, AbstractC0399x0.d, null, AbstractC0372j0.b);
        }
        if (messageInfoMessageInfoFor.getSyntax() != enumC0391t0) {
            return C0376l0.u(messageInfoMessageInfoFor, AbstractC0386q0.f2908a, AbstractC0356b0.f2865a, AbstractC0399x0.c, null, AbstractC0372j0.f2883a);
        }
        NewInstanceSchema newInstanceSchema = AbstractC0386q0.f2908a;
        Z z6 = AbstractC0356b0.f2865a;
        K0 k03 = AbstractC0399x0.b;
        E e6 = G.b;
        if (e6 != null) {
            return C0376l0.u(messageInfoMessageInfoFor, newInstanceSchema, z6, k03, e6, AbstractC0372j0.f2883a);
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public e1 fieldOrder() {
        return e1.f2877a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBool(int i, boolean z6) {
        ((AbstractC0398x) this.f2926a).M(i, z6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBoolList(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.M(i, ((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Boolean) list.get(i5)).getClass();
            Logger logger = AbstractC0398x.d;
            i4++;
        }
        abstractC0398x.f0(i4);
        while (i3 < list.size()) {
            abstractC0398x.L(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBytes(int i, AbstractC0381o abstractC0381o) {
        ((AbstractC0398x) this.f2926a).O(i, abstractC0381o);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBytesList(int i, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((AbstractC0398x) this.f2926a).O(i, (AbstractC0381o) list.get(i3));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeDouble(int i, double d) {
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        abstractC0398x.getClass();
        abstractC0398x.S(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeDoubleList(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                double dDoubleValue = ((Double) list.get(i3)).doubleValue();
                abstractC0398x.getClass();
                abstractC0398x.S(i, Double.doubleToRawLongBits(dDoubleValue));
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Double) list.get(i5)).getClass();
            Logger logger = AbstractC0398x.d;
            i4 += 8;
        }
        abstractC0398x.f0(i4);
        while (i3 < list.size()) {
            abstractC0398x.T(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeEndGroup(int i) {
        ((AbstractC0398x) this.f2926a).d0(i, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeEnum(int i, int i3) {
        ((AbstractC0398x) this.f2926a).U(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeEnumList(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.U(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int iE = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iE += AbstractC0398x.E(((Integer) list.get(i4)).intValue());
        }
        abstractC0398x.f0(iE);
        while (i3 < list.size()) {
            abstractC0398x.V(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed32(int i, int i3) {
        ((AbstractC0398x) this.f2926a).Q(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed32List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.Q(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            Logger logger = AbstractC0398x.d;
            i4 += 4;
        }
        abstractC0398x.f0(i4);
        while (i3 < list.size()) {
            abstractC0398x.R(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed64(int i, long j6) {
        ((AbstractC0398x) this.f2926a).S(i, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed64List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.S(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            Logger logger = AbstractC0398x.d;
            i4 += 8;
        }
        abstractC0398x.f0(i4);
        while (i3 < list.size()) {
            abstractC0398x.T(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFloat(int i, float f6) {
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        abstractC0398x.getClass();
        abstractC0398x.Q(i, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFloatList(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                float fFloatValue = ((Float) list.get(i3)).floatValue();
                abstractC0398x.getClass();
                abstractC0398x.Q(i, Float.floatToRawIntBits(fFloatValue));
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Float) list.get(i5)).getClass();
            Logger logger = AbstractC0398x.d;
            i4 += 4;
        }
        abstractC0398x.f0(i4);
        while (i3 < list.size()) {
            abstractC0398x.R(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroup(int i, Object obj) {
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        abstractC0398x.d0(i, 3);
        ((MessageLite) obj).writeTo(abstractC0398x);
        abstractC0398x.d0(i, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroupList(int i, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeGroup(i, list.get(i3));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt32(int i, int i3) {
        ((AbstractC0398x) this.f2926a).U(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt32List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.U(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int iE = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iE += AbstractC0398x.E(((Integer) list.get(i4)).intValue());
        }
        abstractC0398x.f0(iE);
        while (i3 < list.size()) {
            abstractC0398x.V(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt64(int i, long j6) {
        ((AbstractC0398x) this.f2926a).g0(i, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt64List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.g0(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int iJ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iJ += AbstractC0398x.J(((Long) list.get(i4)).longValue());
        }
        abstractC0398x.f0(iJ);
        while (i3 < list.size()) {
            abstractC0398x.h0(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMap(int i, C0364f0 c0364f0, Map map) {
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        abstractC0398x.getClass();
        for (Map.Entry entry : map.entrySet()) {
            abstractC0398x.d0(i, 2);
            abstractC0398x.f0(C0366g0.a(c0364f0, entry.getKey(), entry.getValue()));
            C0366g0.b(abstractC0398x, c0364f0, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessage(int i, Object obj) {
        ((AbstractC0398x) this.f2926a).W(i, (MessageLite) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessageList(int i, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeMessage(i, list.get(i3));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessageSetItem(int i, Object obj) {
        boolean z6 = obj instanceof AbstractC0381o;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (z6) {
            abstractC0398x.a0(i, (AbstractC0381o) obj);
        } else {
            abstractC0398x.Z(i, (MessageLite) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed32(int i, int i3) {
        ((AbstractC0398x) this.f2926a).Q(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed32List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.Q(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            Logger logger = AbstractC0398x.d;
            i4 += 4;
        }
        abstractC0398x.f0(i4);
        while (i3 < list.size()) {
            abstractC0398x.R(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed64(int i, long j6) {
        ((AbstractC0398x) this.f2926a).S(i, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed64List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.S(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            Logger logger = AbstractC0398x.d;
            i4 += 8;
        }
        abstractC0398x.f0(i4);
        while (i3 < list.size()) {
            abstractC0398x.T(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt32(int i, int i3) {
        ((AbstractC0398x) this.f2926a).e0(i, (i3 >> 31) ^ (i3 << 1));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt32List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                abstractC0398x.e0(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int I = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int iIntValue2 = ((Integer) list.get(i4)).intValue();
            I += AbstractC0398x.I((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        abstractC0398x.f0(I);
        while (i3 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i3)).intValue();
            abstractC0398x.f0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt64(int i, long j6) {
        ((AbstractC0398x) this.f2926a).g0(i, (j6 >> 63) ^ (j6 << 1));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt64List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                abstractC0398x.g0(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int iJ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            long jLongValue2 = ((Long) list.get(i4)).longValue();
            iJ += AbstractC0398x.J((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        abstractC0398x.f0(iJ);
        while (i3 < list.size()) {
            long jLongValue3 = ((Long) list.get(i3)).longValue();
            abstractC0398x.h0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeStartGroup(int i) {
        ((AbstractC0398x) this.f2926a).d0(i, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeString(int i, String str) {
        ((AbstractC0398x) this.f2926a).b0(i, str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeStringList(int i, List list) {
        boolean z6 = list instanceof LazyStringList;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.b0(i, (String) list.get(i3));
                i3++;
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i3 < list.size()) {
            Object raw = lazyStringList.getRaw(i3);
            if (raw instanceof String) {
                abstractC0398x.b0(i, (String) raw);
            } else {
                abstractC0398x.O(i, (AbstractC0381o) raw);
            }
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt32(int i, int i3) {
        ((AbstractC0398x) this.f2926a).e0(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt32List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.e0(i, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int I = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            I += AbstractC0398x.I(((Integer) list.get(i4)).intValue());
        }
        abstractC0398x.f0(I);
        while (i3 < list.size()) {
            abstractC0398x.f0(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt64(int i, long j6) {
        ((AbstractC0398x) this.f2926a).g0(i, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt64List(int i, List list, boolean z6) {
        int i3 = 0;
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        if (!z6) {
            while (i3 < list.size()) {
                abstractC0398x.g0(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        abstractC0398x.d0(i, 2);
        int iJ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iJ += AbstractC0398x.J(((Long) list.get(i4)).longValue());
        }
        abstractC0398x.f0(iJ);
        while (i3 < list.size()) {
            abstractC0398x.h0(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessage(int i, Object obj, Schema schema) {
        ((AbstractC0398x) this.f2926a).X(i, (MessageLite) obj, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroupList(int i, List list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeGroup(i, list.get(i3), schema);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessageList(int i, List list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeMessage(i, list.get(i3), schema);
        }
    }

    public C0400y() {
        MessageInfoFactory messageInfoFactory;
        try {
            messageInfoFactory = (MessageInfoFactory) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            messageInfoFactory = b;
        }
        MessageInfoFactory[] messageInfoFactoryArr = {N.b, messageInfoFactory};
        C0362e0 c0362e0 = new C0362e0();
        c0362e0.f2876a = messageInfoFactoryArr;
        Charset charset = T.f2849a;
        this.f2926a = c0362e0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroup(int i, Object obj, Schema schema) {
        AbstractC0398x abstractC0398x = (AbstractC0398x) this.f2926a;
        abstractC0398x.d0(i, 3);
        schema.writeTo((MessageLite) obj, abstractC0398x.c);
        abstractC0398x.d0(i, 4);
    }
}
