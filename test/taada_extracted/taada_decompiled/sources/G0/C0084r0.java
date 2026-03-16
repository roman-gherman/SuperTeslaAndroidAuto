package G0;

import com.google.crypto.tink.proto.EncryptedKeysetOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.AbstractC0388s;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.ByteArrayInputStream;

/* JADX INFO: renamed from: G0.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0084r0 extends com.google.crypto.tink.shaded.protobuf.Q implements EncryptedKeysetOrBuilder {
    private static final C0084r0 DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile Parser<C0084r0> PARSER;
    private AbstractC0381o encryptedKeyset_ = AbstractC0381o.b;
    private r1 keysetInfo_;

    static {
        C0084r0 c0084r0 = new C0084r0();
        DEFAULT_INSTANCE = c0084r0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0084r0.class, c0084r0);
    }

    public static void t(C0084r0 c0084r0, C0379n c0379n) {
        c0084r0.getClass();
        c0084r0.encryptedKeyset_ = c0379n;
    }

    public static void u(C0084r0 c0084r0, r1 r1Var) {
        c0084r0.getClass();
        c0084r0.keysetInfo_ = r1Var;
    }

    public static C0083q0 v() {
        return (C0083q0) DEFAULT_INSTANCE.d();
    }

    public static C0084r0 w(ByteArrayInputStream byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.D d) throws com.google.crypto.tink.shaded.protobuf.V {
        com.google.crypto.tink.shaded.protobuf.Q qO = com.google.crypto.tink.shaded.protobuf.Q.o(DEFAULT_INSTANCE, AbstractC0388s.g(byteArrayInputStream), d);
        com.google.crypto.tink.shaded.protobuf.Q.c(qO);
        return (C0084r0) qO;
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 3:
                return new C0084r0();
            case 4:
                return new C0083q0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0084r0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0084r0.class) {
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

    @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
    public final AbstractC0381o getEncryptedKeyset() {
        return this.encryptedKeyset_;
    }

    @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
    public final r1 getKeysetInfo() {
        r1 r1Var = this.keysetInfo_;
        return r1Var == null ? r1.v() : r1Var;
    }

    @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
    public final boolean hasKeysetInfo() {
        return this.keysetInfo_ != null;
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
