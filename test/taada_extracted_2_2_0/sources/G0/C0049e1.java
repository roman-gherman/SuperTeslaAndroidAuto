package G0;

import com.google.crypto.tink.proto.KeyDataOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0049e1 extends com.google.crypto.tink.shaded.protobuf.Q implements KeyDataOrBuilder {
    private static final C0049e1 DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<C0049e1> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = "";
    private AbstractC0381o value_ = AbstractC0381o.b;

    static {
        C0049e1 c0049e1 = new C0049e1();
        DEFAULT_INSTANCE = c0049e1;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0049e1.class, c0049e1);
    }

    public static void t(C0049e1 c0049e1, String str) {
        c0049e1.getClass();
        str.getClass();
        c0049e1.typeUrl_ = str;
    }

    public static void u(C0049e1 c0049e1, AbstractC0381o abstractC0381o) {
        c0049e1.getClass();
        abstractC0381o.getClass();
        c0049e1.value_ = abstractC0381o;
    }

    public static void v(C0049e1 c0049e1, EnumC0046d1 enumC0046d1) {
        c0049e1.getClass();
        c0049e1.keyMaterialType_ = enumC0046d1.getNumber();
    }

    public static C0049e1 w() {
        return DEFAULT_INSTANCE;
    }

    public static C0043c1 x() {
        return (C0043c1) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 3:
                return new C0049e1();
            case 4:
                return new C0043c1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0049e1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0049e1.class) {
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

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public final EnumC0046d1 getKeyMaterialType() {
        int i = this.keyMaterialType_;
        EnumC0046d1 enumC0046d1 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : EnumC0046d1.REMOTE : EnumC0046d1.ASYMMETRIC_PUBLIC : EnumC0046d1.ASYMMETRIC_PRIVATE : EnumC0046d1.SYMMETRIC : EnumC0046d1.UNKNOWN_KEYMATERIAL;
        return enumC0046d1 == null ? EnumC0046d1.UNRECOGNIZED : enumC0046d1;
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public final int getKeyMaterialTypeValue() {
        return this.keyMaterialType_;
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public final AbstractC0381o getTypeUrlBytes() {
        return AbstractC0381o.d(this.typeUrl_);
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
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
