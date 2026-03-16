package G0;

import com.google.crypto.tink.proto.KeyTypeEntryOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0064j1 extends com.google.crypto.tink.shaded.protobuf.Q implements KeyTypeEntryOrBuilder {
    public static final int CATALOGUE_NAME_FIELD_NUMBER = 5;
    private static final C0064j1 DEFAULT_INSTANCE;
    public static final int KEY_MANAGER_VERSION_FIELD_NUMBER = 3;
    public static final int NEW_KEY_ALLOWED_FIELD_NUMBER = 4;
    private static volatile Parser<C0064j1> PARSER = null;
    public static final int PRIMITIVE_NAME_FIELD_NUMBER = 1;
    public static final int TYPE_URL_FIELD_NUMBER = 2;
    private int keyManagerVersion_;
    private boolean newKeyAllowed_;
    private String primitiveName_ = "";
    private String typeUrl_ = "";
    private String catalogueName_ = "";

    static {
        C0064j1 c0064j1 = new C0064j1();
        DEFAULT_INSTANCE = c0064j1;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0064j1.class, c0064j1);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"primitiveName_", "typeUrl_", "keyManagerVersion_", "newKeyAllowed_", "catalogueName_"});
            case 3:
                return new C0064j1();
            case 4:
                return new C0061i1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0064j1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0064j1.class) {
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

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public final String getCatalogueName() {
        return this.catalogueName_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public final AbstractC0381o getCatalogueNameBytes() {
        return AbstractC0381o.d(this.catalogueName_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public final int getKeyManagerVersion() {
        return this.keyManagerVersion_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public final boolean getNewKeyAllowed() {
        return this.newKeyAllowed_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public final String getPrimitiveName() {
        return this.primitiveName_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public final AbstractC0381o getPrimitiveNameBytes() {
        return AbstractC0381o.d(this.primitiveName_);
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
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
