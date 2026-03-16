package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GenericNotificationMessage extends GeneratedMessageLite<GenericNotificationMessage, Builder> implements GenericNotificationMessageOrBuilder {
    private static final GenericNotificationMessage DEFAULT_INSTANCE;
    public static final int ICON_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<GenericNotificationMessage> PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 2;
    private int bitField0_;
    private String id_ = "";
    private String text_ = "";
    private ByteString icon_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GenericNotificationMessage$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GenericNotificationMessage, Builder> implements GenericNotificationMessageOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearIcon() {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).clearIcon();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).clearId();
            return this;
        }

        public Builder clearText() {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).clearText();
            return this;
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public ByteString getIcon() {
            return ((GenericNotificationMessage) this.instance).getIcon();
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public String getId() {
            return ((GenericNotificationMessage) this.instance).getId();
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public ByteString getIdBytes() {
            return ((GenericNotificationMessage) this.instance).getIdBytes();
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public String getText() {
            return ((GenericNotificationMessage) this.instance).getText();
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public ByteString getTextBytes() {
            return ((GenericNotificationMessage) this.instance).getTextBytes();
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public boolean hasIcon() {
            return ((GenericNotificationMessage) this.instance).hasIcon();
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public boolean hasId() {
            return ((GenericNotificationMessage) this.instance).hasId();
        }

        @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
        public boolean hasText() {
            return ((GenericNotificationMessage) this.instance).hasText();
        }

        public Builder setIcon(ByteString byteString) {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).setIcon(byteString);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setText(String str) {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).setText(str);
            return this;
        }

        public Builder setTextBytes(ByteString byteString) {
            copyOnWrite();
            ((GenericNotificationMessage) this.instance).setTextBytes(byteString);
            return this;
        }

        private Builder() {
            super(GenericNotificationMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        GenericNotificationMessage genericNotificationMessage = new GenericNotificationMessage();
        DEFAULT_INSTANCE = genericNotificationMessage;
        GeneratedMessageLite.registerDefaultInstance(GenericNotificationMessage.class, genericNotificationMessage);
    }

    private GenericNotificationMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIcon() {
        this.bitField0_ &= -5;
        this.icon_ = getDefaultInstance().getIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.bitField0_ &= -2;
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearText() {
        this.bitField0_ &= -3;
        this.text_ = getDefaultInstance().getText();
    }

    public static GenericNotificationMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GenericNotificationMessage parseDelimitedFrom(InputStream inputStream) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GenericNotificationMessage parseFrom(ByteBuffer byteBuffer) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GenericNotificationMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIcon(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.icon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.text_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.text_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GenericNotificationMessage();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"bitField0_", "id_", "text_", "icon_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GenericNotificationMessage> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GenericNotificationMessage.class) {
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

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public ByteString getIcon() {
        return this.icon_;
    }

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public String getText() {
        return this.text_;
    }

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public ByteString getTextBytes() {
        return ByteString.copyFromUtf8(this.text_);
    }

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public boolean hasIcon() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.GenericNotificationMessageOrBuilder
    public boolean hasText() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(GenericNotificationMessage genericNotificationMessage) {
        return DEFAULT_INSTANCE.createBuilder(genericNotificationMessage);
    }

    public static GenericNotificationMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GenericNotificationMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GenericNotificationMessage parseFrom(ByteString byteString) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GenericNotificationMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GenericNotificationMessage parseFrom(byte[] bArr) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GenericNotificationMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GenericNotificationMessage parseFrom(InputStream inputStream) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GenericNotificationMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GenericNotificationMessage parseFrom(CodedInputStream codedInputStream) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GenericNotificationMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
