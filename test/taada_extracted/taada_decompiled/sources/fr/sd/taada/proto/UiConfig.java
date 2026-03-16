package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.Insets;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class UiConfig extends GeneratedMessageLite<UiConfig, Builder> implements UiConfigOrBuilder {
    public static final int CONTENT_INSETS_FIELD_NUMBER = 2;
    private static final UiConfig DEFAULT_INSTANCE;
    public static final int MARGINS_FIELD_NUMBER = 1;
    private static volatile Parser<UiConfig> PARSER = null;
    public static final int STABLE_CONTENT_INSETS_FIELD_NUMBER = 3;
    public static final int UI_THEME_FIELD_NUMBER = 4;
    private int bitField0_;
    private Insets contentInsets_;
    private Insets margins_;
    private Insets stableContentInsets_;
    private int uiTheme_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.UiConfig$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<UiConfig, Builder> implements UiConfigOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearContentInsets() {
            copyOnWrite();
            ((UiConfig) this.instance).clearContentInsets();
            return this;
        }

        public Builder clearMargins() {
            copyOnWrite();
            ((UiConfig) this.instance).clearMargins();
            return this;
        }

        public Builder clearStableContentInsets() {
            copyOnWrite();
            ((UiConfig) this.instance).clearStableContentInsets();
            return this;
        }

        public Builder clearUiTheme() {
            copyOnWrite();
            ((UiConfig) this.instance).clearUiTheme();
            return this;
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public Insets getContentInsets() {
            return ((UiConfig) this.instance).getContentInsets();
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public Insets getMargins() {
            return ((UiConfig) this.instance).getMargins();
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public Insets getStableContentInsets() {
            return ((UiConfig) this.instance).getStableContentInsets();
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public UiTheme getUiTheme() {
            return ((UiConfig) this.instance).getUiTheme();
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public boolean hasContentInsets() {
            return ((UiConfig) this.instance).hasContentInsets();
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public boolean hasMargins() {
            return ((UiConfig) this.instance).hasMargins();
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public boolean hasStableContentInsets() {
            return ((UiConfig) this.instance).hasStableContentInsets();
        }

        @Override // fr.sd.taada.proto.UiConfigOrBuilder
        public boolean hasUiTheme() {
            return ((UiConfig) this.instance).hasUiTheme();
        }

        public Builder mergeContentInsets(Insets insets) {
            copyOnWrite();
            ((UiConfig) this.instance).mergeContentInsets(insets);
            return this;
        }

        public Builder mergeMargins(Insets insets) {
            copyOnWrite();
            ((UiConfig) this.instance).mergeMargins(insets);
            return this;
        }

        public Builder mergeStableContentInsets(Insets insets) {
            copyOnWrite();
            ((UiConfig) this.instance).mergeStableContentInsets(insets);
            return this;
        }

        public Builder setContentInsets(Insets insets) {
            copyOnWrite();
            ((UiConfig) this.instance).setContentInsets(insets);
            return this;
        }

        public Builder setMargins(Insets insets) {
            copyOnWrite();
            ((UiConfig) this.instance).setMargins(insets);
            return this;
        }

        public Builder setStableContentInsets(Insets insets) {
            copyOnWrite();
            ((UiConfig) this.instance).setStableContentInsets(insets);
            return this;
        }

        public Builder setUiTheme(UiTheme uiTheme) {
            copyOnWrite();
            ((UiConfig) this.instance).setUiTheme(uiTheme);
            return this;
        }

        private Builder() {
            super(UiConfig.DEFAULT_INSTANCE);
        }

        public Builder setContentInsets(Insets.Builder builder) {
            copyOnWrite();
            ((UiConfig) this.instance).setContentInsets(builder);
            return this;
        }

        public Builder setMargins(Insets.Builder builder) {
            copyOnWrite();
            ((UiConfig) this.instance).setMargins(builder);
            return this;
        }

        public Builder setStableContentInsets(Insets.Builder builder) {
            copyOnWrite();
            ((UiConfig) this.instance).setStableContentInsets(builder);
            return this;
        }
    }

    static {
        UiConfig uiConfig = new UiConfig();
        DEFAULT_INSTANCE = uiConfig;
        GeneratedMessageLite.registerDefaultInstance(UiConfig.class, uiConfig);
    }

    private UiConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContentInsets() {
        this.contentInsets_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMargins() {
        this.margins_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStableContentInsets() {
        this.stableContentInsets_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUiTheme() {
        this.bitField0_ &= -9;
        this.uiTheme_ = 0;
    }

    public static UiConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeContentInsets(Insets insets) {
        insets.getClass();
        Insets insets2 = this.contentInsets_;
        if (insets2 == null || insets2 == Insets.getDefaultInstance()) {
            this.contentInsets_ = insets;
        } else {
            this.contentInsets_ = Insets.newBuilder(this.contentInsets_).mergeFrom(insets).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMargins(Insets insets) {
        insets.getClass();
        Insets insets2 = this.margins_;
        if (insets2 == null || insets2 == Insets.getDefaultInstance()) {
            this.margins_ = insets;
        } else {
            this.margins_ = Insets.newBuilder(this.margins_).mergeFrom(insets).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStableContentInsets(Insets insets) {
        insets.getClass();
        Insets insets2 = this.stableContentInsets_;
        if (insets2 == null || insets2 == Insets.getDefaultInstance()) {
            this.stableContentInsets_ = insets;
        } else {
            this.stableContentInsets_ = Insets.newBuilder(this.stableContentInsets_).mergeFrom(insets).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UiConfig parseDelimitedFrom(InputStream inputStream) {
        return (UiConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UiConfig parseFrom(ByteBuffer byteBuffer) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UiConfig> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentInsets(Insets insets) {
        insets.getClass();
        this.contentInsets_ = insets;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMargins(Insets insets) {
        insets.getClass();
        this.margins_ = insets;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStableContentInsets(Insets insets) {
        insets.getClass();
        this.stableContentInsets_ = insets;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUiTheme(UiTheme uiTheme) {
        uiTheme.getClass();
        this.bitField0_ |= 8;
        this.uiTheme_ = uiTheme.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UiConfig();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\f\u0003", new Object[]{"bitField0_", "margins_", "contentInsets_", "stableContentInsets_", "uiTheme_", UiTheme.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UiConfig> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UiConfig.class) {
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

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public Insets getContentInsets() {
        Insets insets = this.contentInsets_;
        return insets == null ? Insets.getDefaultInstance() : insets;
    }

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public Insets getMargins() {
        Insets insets = this.margins_;
        return insets == null ? Insets.getDefaultInstance() : insets;
    }

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public Insets getStableContentInsets() {
        Insets insets = this.stableContentInsets_;
        return insets == null ? Insets.getDefaultInstance() : insets;
    }

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public UiTheme getUiTheme() {
        UiTheme uiThemeForNumber = UiTheme.forNumber(this.uiTheme_);
        return uiThemeForNumber == null ? UiTheme.UI_THEME_AUTOMATIC : uiThemeForNumber;
    }

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public boolean hasContentInsets() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public boolean hasMargins() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public boolean hasStableContentInsets() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.UiConfigOrBuilder
    public boolean hasUiTheme() {
        return (this.bitField0_ & 8) != 0;
    }

    public static Builder newBuilder(UiConfig uiConfig) {
        return DEFAULT_INSTANCE.createBuilder(uiConfig);
    }

    public static UiConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UiConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UiConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UiConfig parseFrom(ByteString byteString) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UiConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentInsets(Insets.Builder builder) {
        this.contentInsets_ = builder.build();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMargins(Insets.Builder builder) {
        this.margins_ = builder.build();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStableContentInsets(Insets.Builder builder) {
        this.stableContentInsets_ = builder.build();
        this.bitField0_ |= 4;
    }

    public static UiConfig parseFrom(byte[] bArr) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UiConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UiConfig parseFrom(InputStream inputStream) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UiConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UiConfig parseFrom(CodedInputStream codedInputStream) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UiConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UiConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
