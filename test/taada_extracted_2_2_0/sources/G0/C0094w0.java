package G0;

import com.google.crypto.tink.proto.HmacKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0094w0 extends com.google.crypto.tink.shaded.protobuf.Q implements HmacKeyOrBuilder {
    private static final C0094w0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<C0094w0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0381o keyValue_ = AbstractC0381o.b;
    private A0 params_;
    private int version_;

    static {
        C0094w0 c0094w0 = new C0094w0();
        DEFAULT_INSTANCE = c0094w0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0094w0.class, c0094w0);
    }

    public static void t(C0094w0 c0094w0) {
        c0094w0.version_ = 0;
    }

    public static void u(C0094w0 c0094w0, A0 a02) {
        c0094w0.getClass();
        a02.getClass();
        c0094w0.params_ = a02;
    }

    public static void v(C0094w0 c0094w0, C0379n c0379n) {
        c0094w0.getClass();
        c0094w0.keyValue_ = c0379n;
    }

    public static C0094w0 w() {
        return DEFAULT_INSTANCE;
    }

    public static C0092v0 x() {
        return (C0092v0) DEFAULT_INSTANCE.d();
    }

    public static C0094w0 y(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0094w0) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 3:
                return new C0094w0();
            case 4:
                return new C0092v0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0094w0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0094w0.class) {
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

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public final AbstractC0381o getKeyValue() {
        return this.keyValue_;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public final A0 getParams() {
        A0 a02 = this.params_;
        return a02 == null ? A0.v() : a02;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public final boolean hasParams() {
        return this.params_ != null;
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
