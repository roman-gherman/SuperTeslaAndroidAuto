package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class HdRadioComment extends GeneratedMessageLite<HdRadioComment, Builder> implements HdRadioCommentOrBuilder {
    private static final HdRadioComment DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 1;
    private static volatile Parser<HdRadioComment> PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 2;
    private int bitField0_;
    private String description_ = "";
    private String text_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.HdRadioComment$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HdRadioComment, Builder> implements HdRadioCommentOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((HdRadioComment) this.instance).clearDescription();
            return this;
        }

        public Builder clearText() {
            copyOnWrite();
            ((HdRadioComment) this.instance).clearText();
            return this;
        }

        @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
        public String getDescription() {
            return ((HdRadioComment) this.instance).getDescription();
        }

        @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
        public ByteString getDescriptionBytes() {
            return ((HdRadioComment) this.instance).getDescriptionBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
        public String getText() {
            return ((HdRadioComment) this.instance).getText();
        }

        @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
        public ByteString getTextBytes() {
            return ((HdRadioComment) this.instance).getTextBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
        public boolean hasDescription() {
            return ((HdRadioComment) this.instance).hasDescription();
        }

        @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
        public boolean hasText() {
            return ((HdRadioComment) this.instance).hasText();
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((HdRadioComment) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioComment) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setText(String str) {
            copyOnWrite();
            ((HdRadioComment) this.instance).setText(str);
            return this;
        }

        public Builder setTextBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioComment) this.instance).setTextBytes(byteString);
            return this;
        }

        private Builder() {
            super(HdRadioComment.DEFAULT_INSTANCE);
        }
    }

    static {
        HdRadioComment hdRadioComment = new HdRadioComment();
        DEFAULT_INSTANCE = hdRadioComment;
        GeneratedMessageLite.registerDefaultInstance(HdRadioComment.class, hdRadioComment);
    }

    private HdRadioComment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.bitField0_ &= -2;
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearText() {
        this.bitField0_ &= -3;
        this.text_ = getDefaultInstance().getText();
    }

    public static HdRadioComment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HdRadioComment parseDelimitedFrom(InputStream inputStream) {
        return (HdRadioComment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioComment parseFrom(ByteBuffer byteBuffer) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HdRadioComment> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.description_ = byteString.toStringUtf8();
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
                return new HdRadioComment();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"bitField0_", "description_", "text_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HdRadioComment> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HdRadioComment.class) {
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

    @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
    public String getText() {
        return this.text_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
    public ByteString getTextBytes() {
        return ByteString.copyFromUtf8(this.text_);
    }

    @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
    public boolean hasDescription() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioCommentOrBuilder
    public boolean hasText() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(HdRadioComment hdRadioComment) {
        return DEFAULT_INSTANCE.createBuilder(hdRadioComment);
    }

    public static HdRadioComment parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioComment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioComment parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HdRadioComment parseFrom(ByteString byteString) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HdRadioComment parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HdRadioComment parseFrom(byte[] bArr) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HdRadioComment parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HdRadioComment parseFrom(InputStream inputStream) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioComment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioComment parseFrom(CodedInputStream codedInputStream) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HdRadioComment parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
