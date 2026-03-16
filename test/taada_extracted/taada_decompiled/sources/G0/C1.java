package G0;

import com.google.crypto.tink.proto.RegistryConfigOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0395v0;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class C1 extends com.google.crypto.tink.shaded.protobuf.Q implements RegistryConfigOrBuilder {
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    private static final C1 DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    private static volatile Parser<C1> PARSER;
    private String configName_ = "";
    private Internal$ProtobufList<C0064j1> entry_ = C0395v0.d;

    static {
        C1 c12 = new C1();
        DEFAULT_INSTANCE = c12;
        com.google.crypto.tink.shaded.protobuf.Q.q(C1.class, c12);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"configName_", "entry_", C0064j1.class});
            case 3:
                return new C1();
            case 4:
                return new B1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C1.class) {
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

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public final String getConfigName() {
        return this.configName_;
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public final AbstractC0381o getConfigNameBytes() {
        return AbstractC0381o.d(this.configName_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public final C0064j1 getEntry(int i) {
        return this.entry_.get(i);
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public final int getEntryCount() {
        return this.entry_.size();
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public final List getEntryList() {
        return this.entry_;
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
