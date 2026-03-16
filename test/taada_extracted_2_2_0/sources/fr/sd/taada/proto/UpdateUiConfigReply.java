package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.UiConfig;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class UpdateUiConfigReply extends GeneratedMessageLite<UpdateUiConfigReply, Builder> implements UpdateUiConfigReplyOrBuilder {
    private static final UpdateUiConfigReply DEFAULT_INSTANCE;
    private static volatile Parser<UpdateUiConfigReply> PARSER = null;
    public static final int UI_CONFIG_FIELD_NUMBER = 1;
    private int bitField0_;
    private UiConfig uiConfig_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.UpdateUiConfigReply$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<UpdateUiConfigReply, Builder> implements UpdateUiConfigReplyOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearUiConfig() {
            copyOnWrite();
            ((UpdateUiConfigReply) this.instance).clearUiConfig();
            return this;
        }

        @Override // fr.sd.taada.proto.UpdateUiConfigReplyOrBuilder
        public UiConfig getUiConfig() {
            return ((UpdateUiConfigReply) this.instance).getUiConfig();
        }

        @Override // fr.sd.taada.proto.UpdateUiConfigReplyOrBuilder
        public boolean hasUiConfig() {
            return ((UpdateUiConfigReply) this.instance).hasUiConfig();
        }

        public Builder mergeUiConfig(UiConfig uiConfig) {
            copyOnWrite();
            ((UpdateUiConfigReply) this.instance).mergeUiConfig(uiConfig);
            return this;
        }

        public Builder setUiConfig(UiConfig uiConfig) {
            copyOnWrite();
            ((UpdateUiConfigReply) this.instance).setUiConfig(uiConfig);
            return this;
        }

        private Builder() {
            super(UpdateUiConfigReply.DEFAULT_INSTANCE);
        }

        public Builder setUiConfig(UiConfig.Builder builder) {
            copyOnWrite();
            ((UpdateUiConfigReply) this.instance).setUiConfig(builder);
            return this;
        }
    }

    static {
        UpdateUiConfigReply updateUiConfigReply = new UpdateUiConfigReply();
        DEFAULT_INSTANCE = updateUiConfigReply;
        GeneratedMessageLite.registerDefaultInstance(UpdateUiConfigReply.class, updateUiConfigReply);
    }

    private UpdateUiConfigReply() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUiConfig() {
        this.uiConfig_ = null;
        this.bitField0_ &= -2;
    }

    public static UpdateUiConfigReply getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUiConfig(UiConfig uiConfig) {
        uiConfig.getClass();
        UiConfig uiConfig2 = this.uiConfig_;
        if (uiConfig2 == null || uiConfig2 == UiConfig.getDefaultInstance()) {
            this.uiConfig_ = uiConfig;
        } else {
            this.uiConfig_ = UiConfig.newBuilder(this.uiConfig_).mergeFrom(uiConfig).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateUiConfigReply parseDelimitedFrom(InputStream inputStream) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateUiConfigReply parseFrom(ByteBuffer byteBuffer) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UpdateUiConfigReply> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUiConfig(UiConfig uiConfig) {
        uiConfig.getClass();
        this.uiConfig_ = uiConfig;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UpdateUiConfigReply();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t\u0000", new Object[]{"bitField0_", "uiConfig_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UpdateUiConfigReply> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UpdateUiConfigReply.class) {
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

    @Override // fr.sd.taada.proto.UpdateUiConfigReplyOrBuilder
    public UiConfig getUiConfig() {
        UiConfig uiConfig = this.uiConfig_;
        return uiConfig == null ? UiConfig.getDefaultInstance() : uiConfig;
    }

    @Override // fr.sd.taada.proto.UpdateUiConfigReplyOrBuilder
    public boolean hasUiConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(UpdateUiConfigReply updateUiConfigReply) {
        return DEFAULT_INSTANCE.createBuilder(updateUiConfigReply);
    }

    public static UpdateUiConfigReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UpdateUiConfigReply parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UpdateUiConfigReply parseFrom(ByteString byteString) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UpdateUiConfigReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUiConfig(UiConfig.Builder builder) {
        this.uiConfig_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static UpdateUiConfigReply parseFrom(byte[] bArr) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateUiConfigReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UpdateUiConfigReply parseFrom(InputStream inputStream) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateUiConfigReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UpdateUiConfigReply parseFrom(CodedInputStream codedInputStream) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UpdateUiConfigReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateUiConfigReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
