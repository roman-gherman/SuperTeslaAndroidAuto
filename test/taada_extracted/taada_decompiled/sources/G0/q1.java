package G0;

import com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class q1 extends com.google.crypto.tink.shaded.protobuf.Q implements KeysetInfo$KeyInfoOrBuilder {
    private static final q1 DEFAULT_INSTANCE;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile Parser<q1> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;
    private String typeUrl_ = "";

    static {
        q1 q1Var = new q1();
        DEFAULT_INSTANCE = q1Var;
        com.google.crypto.tink.shaded.protobuf.Q.q(q1.class, q1Var);
    }

    public static void t(q1 q1Var, String str) {
        q1Var.getClass();
        str.getClass();
        q1Var.typeUrl_ = str;
    }

    public static void u(q1 q1Var, A1 a12) {
        q1Var.getClass();
        q1Var.outputPrefixType_ = a12.getNumber();
    }

    public static void v(q1 q1Var, EnumC0052f1 enumC0052f1) {
        q1Var.getClass();
        q1Var.status_ = enumC0052f1.getNumber();
    }

    public static void w(q1 q1Var, int i) {
        q1Var.keyId_ = i;
    }

    public static p1 x() {
        return (p1) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new q1();
            case 4:
                return new p1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<q1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (q1.class) {
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

    @Override // com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder
    public final int getKeyId() {
        return this.keyId_;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder
    public final A1 getOutputPrefixType() {
        A1 a1A = A1.a(this.outputPrefixType_);
        return a1A == null ? A1.UNRECOGNIZED : a1A;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder
    public final int getOutputPrefixTypeValue() {
        return this.outputPrefixType_;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder
    public final EnumC0052f1 getStatus() {
        EnumC0052f1 enumC0052f1A = EnumC0052f1.a(this.status_);
        return enumC0052f1A == null ? EnumC0052f1.UNRECOGNIZED : enumC0052f1A;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder
    public final int getStatusValue() {
        return this.status_;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfo$KeyInfoOrBuilder
    public final AbstractC0381o getTypeUrlBytes() {
        return AbstractC0381o.d(this.typeUrl_);
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
