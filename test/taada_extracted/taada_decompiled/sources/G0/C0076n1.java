package G0;

import com.google.crypto.tink.proto.KeysetOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0388s;
import com.google.crypto.tink.shaded.protobuf.C0395v0;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.ByteArrayInputStream;
import java.util.List;

/* JADX INFO: renamed from: G0.n1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0076n1 extends com.google.crypto.tink.shaded.protobuf.Q implements KeysetOrBuilder {
    private static final C0076n1 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<C0076n1> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal$ProtobufList<C0073m1> key_ = C0395v0.d;
    private int primaryKeyId_;

    static {
        C0076n1 c0076n1 = new C0076n1();
        DEFAULT_INSTANCE = c0076n1;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0076n1.class, c0076n1);
    }

    public static void t(C0076n1 c0076n1, int i) {
        c0076n1.primaryKeyId_ = i;
    }

    public static void u(C0076n1 c0076n1, C0073m1 c0073m1) {
        c0076n1.getClass();
        Internal$ProtobufList<C0073m1> internal$ProtobufList = c0076n1.key_;
        if (!internal$ProtobufList.isModifiable()) {
            int size = internal$ProtobufList.size();
            c0076n1.key_ = internal$ProtobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
        }
        c0076n1.key_.add(c0073m1);
    }

    public static C0067k1 v() {
        return (C0067k1) DEFAULT_INSTANCE.d();
    }

    public static C0076n1 w(ByteArrayInputStream byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.D d) throws com.google.crypto.tink.shaded.protobuf.V {
        com.google.crypto.tink.shaded.protobuf.Q qO = com.google.crypto.tink.shaded.protobuf.Q.o(DEFAULT_INSTANCE, AbstractC0388s.g(byteArrayInputStream), d);
        com.google.crypto.tink.shaded.protobuf.Q.c(qO);
        return (C0076n1) qO;
    }

    public static C0076n1 x(byte[] bArr, com.google.crypto.tink.shaded.protobuf.D d) {
        com.google.crypto.tink.shaded.protobuf.Q qP = com.google.crypto.tink.shaded.protobuf.Q.p(DEFAULT_INSTANCE, bArr, 0, bArr.length, d);
        com.google.crypto.tink.shaded.protobuf.Q.c(qP);
        return (C0076n1) qP;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q
    public final Object e(int i) {
        Parser p5;
        switch (f.s.b(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", C0073m1.class});
            case 3:
                return new C0076n1();
            case 4:
                return new C0067k1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0076n1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0076n1.class) {
                    try {
                        p5 = PARSER;
                        if (p5 == null) {
                            p5 = new com.google.crypto.tink.shaded.protobuf.P(DEFAULT_INSTANCE);
                            PARSER = p5;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return p5;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public final C0073m1 getKey(int i) {
        return this.key_.get(i);
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public final int getKeyCount() {
        return this.key_.size();
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public final List getKeyList() {
        return this.key_;
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public final int getPrimaryKeyId() {
        return this.primaryKeyId_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLite
    public final /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLite
    public final /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }
}
