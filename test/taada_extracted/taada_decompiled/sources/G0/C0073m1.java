package G0;

import com.google.crypto.tink.proto.Keyset$KeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0073m1 extends com.google.crypto.tink.shaded.protobuf.Q implements Keyset$KeyOrBuilder {
    private static final C0073m1 DEFAULT_INSTANCE;
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile Parser<C0073m1> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private C0049e1 keyData_;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;

    static {
        C0073m1 c0073m1 = new C0073m1();
        DEFAULT_INSTANCE = c0073m1;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0073m1.class, c0073m1);
    }

    public static void t(C0073m1 c0073m1, C0049e1 c0049e1) {
        c0073m1.getClass();
        c0049e1.getClass();
        c0073m1.keyData_ = c0049e1;
    }

    public static void u(C0073m1 c0073m1, A1 a12) {
        c0073m1.getClass();
        c0073m1.outputPrefixType_ = a12.getNumber();
    }

    public static void v(C0073m1 c0073m1) {
        EnumC0052f1 enumC0052f1 = EnumC0052f1.ENABLED;
        c0073m1.getClass();
        c0073m1.status_ = enumC0052f1.getNumber();
    }

    public static void w(C0073m1 c0073m1, int i) {
        c0073m1.keyId_ = i;
    }

    public static C0070l1 x() {
        return (C0070l1) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new C0073m1();
            case 4:
                return new C0070l1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0073m1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0073m1.class) {
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

    @Override // com.google.crypto.tink.proto.Keyset$KeyOrBuilder
    public final C0049e1 getKeyData() {
        C0049e1 c0049e1 = this.keyData_;
        return c0049e1 == null ? C0049e1.w() : c0049e1;
    }

    @Override // com.google.crypto.tink.proto.Keyset$KeyOrBuilder
    public final int getKeyId() {
        return this.keyId_;
    }

    @Override // com.google.crypto.tink.proto.Keyset$KeyOrBuilder
    public final A1 getOutputPrefixType() {
        A1 a1A = A1.a(this.outputPrefixType_);
        return a1A == null ? A1.UNRECOGNIZED : a1A;
    }

    @Override // com.google.crypto.tink.proto.Keyset$KeyOrBuilder
    public final int getOutputPrefixTypeValue() {
        return this.outputPrefixType_;
    }

    @Override // com.google.crypto.tink.proto.Keyset$KeyOrBuilder
    public final EnumC0052f1 getStatus() {
        EnumC0052f1 enumC0052f1A = EnumC0052f1.a(this.status_);
        return enumC0052f1A == null ? EnumC0052f1.UNRECOGNIZED : enumC0052f1A;
    }

    @Override // com.google.crypto.tink.proto.Keyset$KeyOrBuilder
    public final int getStatusValue() {
        return this.status_;
    }

    @Override // com.google.crypto.tink.proto.Keyset$KeyOrBuilder
    public final boolean hasKeyData() {
        return this.keyData_ != null;
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
