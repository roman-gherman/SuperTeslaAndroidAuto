package G0;

import com.google.crypto.tink.proto.KeysetInfoOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0395v0;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r1 extends com.google.crypto.tink.shaded.protobuf.Q implements KeysetInfoOrBuilder {
    private static final r1 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile Parser<r1> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal$ProtobufList<q1> keyInfo_ = C0395v0.d;
    private int primaryKeyId_;

    static {
        r1 r1Var = new r1();
        DEFAULT_INSTANCE = r1Var;
        com.google.crypto.tink.shaded.protobuf.Q.q(r1.class, r1Var);
    }

    public static void t(r1 r1Var, int i) {
        r1Var.primaryKeyId_ = i;
    }

    public static void u(r1 r1Var, q1 q1Var) {
        r1Var.getClass();
        Internal$ProtobufList<q1> internal$ProtobufList = r1Var.keyInfo_;
        if (!internal$ProtobufList.isModifiable()) {
            int size = internal$ProtobufList.size();
            r1Var.keyInfo_ = internal$ProtobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
        }
        r1Var.keyInfo_.add(q1Var);
    }

    public static r1 v() {
        return DEFAULT_INSTANCE;
    }

    public static C0079o1 w() {
        return (C0079o1) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", q1.class});
            case 3:
                return new r1();
            case 4:
                return new C0079o1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<r1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (r1.class) {
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

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
    public final q1 getKeyInfo(int i) {
        return this.keyInfo_.get(i);
    }

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
    public final int getKeyInfoCount() {
        return this.keyInfo_.size();
    }

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
    public final List getKeyInfoList() {
        return this.keyInfo_;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
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
