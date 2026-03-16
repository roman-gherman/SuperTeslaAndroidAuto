package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class DiagnosticsData extends GeneratedMessageLite<DiagnosticsData, Builder> implements DiagnosticsDataOrBuilder {
    private static final DiagnosticsData DEFAULT_INSTANCE;
    public static final int DTC_FIELD_NUMBER = 1;
    private static volatile Parser<DiagnosticsData> PARSER;
    private int bitField0_;
    private ByteString dtc_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.DiagnosticsData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<DiagnosticsData, Builder> implements DiagnosticsDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDtc() {
            copyOnWrite();
            ((DiagnosticsData) this.instance).clearDtc();
            return this;
        }

        @Override // fr.sd.taada.proto.DiagnosticsDataOrBuilder
        public ByteString getDtc() {
            return ((DiagnosticsData) this.instance).getDtc();
        }

        @Override // fr.sd.taada.proto.DiagnosticsDataOrBuilder
        public boolean hasDtc() {
            return ((DiagnosticsData) this.instance).hasDtc();
        }

        public Builder setDtc(ByteString byteString) {
            copyOnWrite();
            ((DiagnosticsData) this.instance).setDtc(byteString);
            return this;
        }

        private Builder() {
            super(DiagnosticsData.DEFAULT_INSTANCE);
        }
    }

    static {
        DiagnosticsData diagnosticsData = new DiagnosticsData();
        DEFAULT_INSTANCE = diagnosticsData;
        GeneratedMessageLite.registerDefaultInstance(DiagnosticsData.class, diagnosticsData);
    }

    private DiagnosticsData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDtc() {
        this.bitField0_ &= -2;
        this.dtc_ = getDefaultInstance().getDtc();
    }

    public static DiagnosticsData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DiagnosticsData parseDelimitedFrom(InputStream inputStream) {
        return (DiagnosticsData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DiagnosticsData parseFrom(ByteBuffer byteBuffer) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DiagnosticsData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDtc(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.dtc_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new DiagnosticsData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "dtc_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DiagnosticsData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DiagnosticsData.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.DiagnosticsDataOrBuilder
    public ByteString getDtc() {
        return this.dtc_;
    }

    @Override // fr.sd.taada.proto.DiagnosticsDataOrBuilder
    public boolean hasDtc() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(DiagnosticsData diagnosticsData) {
        return DEFAULT_INSTANCE.createBuilder(diagnosticsData);
    }

    public static DiagnosticsData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DiagnosticsData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DiagnosticsData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DiagnosticsData parseFrom(ByteString byteString) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DiagnosticsData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DiagnosticsData parseFrom(byte[] bArr) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DiagnosticsData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DiagnosticsData parseFrom(InputStream inputStream) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DiagnosticsData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DiagnosticsData parseFrom(CodedInputStream codedInputStream) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DiagnosticsData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DiagnosticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
