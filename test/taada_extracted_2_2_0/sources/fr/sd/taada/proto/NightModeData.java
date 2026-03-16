package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NightModeData extends GeneratedMessageLite<NightModeData, Builder> implements NightModeDataOrBuilder {
    private static final NightModeData DEFAULT_INSTANCE;
    public static final int NIGHT_MODE_FIELD_NUMBER = 1;
    private static volatile Parser<NightModeData> PARSER;
    private int bitField0_;
    private boolean nightMode_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NightModeData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NightModeData, Builder> implements NightModeDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearNightMode() {
            copyOnWrite();
            ((NightModeData) this.instance).clearNightMode();
            return this;
        }

        @Override // fr.sd.taada.proto.NightModeDataOrBuilder
        public boolean getNightMode() {
            return ((NightModeData) this.instance).getNightMode();
        }

        @Override // fr.sd.taada.proto.NightModeDataOrBuilder
        public boolean hasNightMode() {
            return ((NightModeData) this.instance).hasNightMode();
        }

        public Builder setNightMode(boolean z6) {
            copyOnWrite();
            ((NightModeData) this.instance).setNightMode(z6);
            return this;
        }

        private Builder() {
            super(NightModeData.DEFAULT_INSTANCE);
        }
    }

    static {
        NightModeData nightModeData = new NightModeData();
        DEFAULT_INSTANCE = nightModeData;
        GeneratedMessageLite.registerDefaultInstance(NightModeData.class, nightModeData);
    }

    private NightModeData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNightMode() {
        this.bitField0_ &= -2;
        this.nightMode_ = false;
    }

    public static NightModeData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NightModeData parseDelimitedFrom(InputStream inputStream) {
        return (NightModeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NightModeData parseFrom(ByteBuffer byteBuffer) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NightModeData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNightMode(boolean z6) {
        this.bitField0_ |= 1;
        this.nightMode_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NightModeData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007\u0000", new Object[]{"bitField0_", "nightMode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NightModeData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NightModeData.class) {
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

    @Override // fr.sd.taada.proto.NightModeDataOrBuilder
    public boolean getNightMode() {
        return this.nightMode_;
    }

    @Override // fr.sd.taada.proto.NightModeDataOrBuilder
    public boolean hasNightMode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NightModeData nightModeData) {
        return DEFAULT_INSTANCE.createBuilder(nightModeData);
    }

    public static NightModeData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NightModeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NightModeData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NightModeData parseFrom(ByteString byteString) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NightModeData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NightModeData parseFrom(byte[] bArr) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NightModeData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NightModeData parseFrom(InputStream inputStream) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NightModeData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NightModeData parseFrom(CodedInputStream codedInputStream) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NightModeData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NightModeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
