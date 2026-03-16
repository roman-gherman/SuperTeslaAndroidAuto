package G0;

import com.google.crypto.tink.proto.KeyTemplateOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0058h1 extends com.google.crypto.tink.shaded.protobuf.Q implements KeyTemplateOrBuilder {
    private static final C0058h1 DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<C0058h1> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = "";
    private AbstractC0381o value_ = AbstractC0381o.b;

    static {
        C0058h1 c0058h1 = new C0058h1();
        DEFAULT_INSTANCE = c0058h1;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0058h1.class, c0058h1);
    }

    public static void t(C0058h1 c0058h1, String str) {
        c0058h1.getClass();
        str.getClass();
        c0058h1.typeUrl_ = str;
    }

    public static void u(C0058h1 c0058h1, C0379n c0379n) {
        c0058h1.getClass();
        c0058h1.value_ = c0379n;
    }

    public static void v(C0058h1 c0058h1, A1 a12) {
        c0058h1.getClass();
        c0058h1.outputPrefixType_ = a12.getNumber();
    }

    public static C0058h1 w() {
        return DEFAULT_INSTANCE;
    }

    public static C0055g1 x() {
        return (C0055g1) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
            case 3:
                return new C0058h1();
            case 4:
                return new C0055g1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0058h1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0058h1.class) {
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

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public final A1 getOutputPrefixType() {
        A1 a1A = A1.a(this.outputPrefixType_);
        return a1A == null ? A1.UNRECOGNIZED : a1A;
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public final int getOutputPrefixTypeValue() {
        return this.outputPrefixType_;
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public final AbstractC0381o getTypeUrlBytes() {
        return AbstractC0381o.d(this.typeUrl_);
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public final AbstractC0381o getValue() {
        return this.value_;
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
