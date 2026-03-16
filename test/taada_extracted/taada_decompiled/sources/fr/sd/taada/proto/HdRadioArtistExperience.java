package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class HdRadioArtistExperience extends GeneratedMessageLite<HdRadioArtistExperience, Builder> implements HdRadioArtistExperienceOrBuilder {
    private static final HdRadioArtistExperience DEFAULT_INSTANCE;
    public static final int IMAGE_FIELD_NUMBER = 1;
    private static volatile Parser<HdRadioArtistExperience> PARSER;
    private int bitField0_;
    private ByteString image_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.HdRadioArtistExperience$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HdRadioArtistExperience, Builder> implements HdRadioArtistExperienceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearImage() {
            copyOnWrite();
            ((HdRadioArtistExperience) this.instance).clearImage();
            return this;
        }

        @Override // fr.sd.taada.proto.HdRadioArtistExperienceOrBuilder
        public ByteString getImage() {
            return ((HdRadioArtistExperience) this.instance).getImage();
        }

        @Override // fr.sd.taada.proto.HdRadioArtistExperienceOrBuilder
        public boolean hasImage() {
            return ((HdRadioArtistExperience) this.instance).hasImage();
        }

        public Builder setImage(ByteString byteString) {
            copyOnWrite();
            ((HdRadioArtistExperience) this.instance).setImage(byteString);
            return this;
        }

        private Builder() {
            super(HdRadioArtistExperience.DEFAULT_INSTANCE);
        }
    }

    static {
        HdRadioArtistExperience hdRadioArtistExperience = new HdRadioArtistExperience();
        DEFAULT_INSTANCE = hdRadioArtistExperience;
        GeneratedMessageLite.registerDefaultInstance(HdRadioArtistExperience.class, hdRadioArtistExperience);
    }

    private HdRadioArtistExperience() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImage() {
        this.bitField0_ &= -2;
        this.image_ = getDefaultInstance().getImage();
    }

    public static HdRadioArtistExperience getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HdRadioArtistExperience parseDelimitedFrom(InputStream inputStream) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioArtistExperience parseFrom(ByteBuffer byteBuffer) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HdRadioArtistExperience> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImage(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.image_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HdRadioArtistExperience();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "image_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HdRadioArtistExperience> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HdRadioArtistExperience.class) {
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

    @Override // fr.sd.taada.proto.HdRadioArtistExperienceOrBuilder
    public ByteString getImage() {
        return this.image_;
    }

    @Override // fr.sd.taada.proto.HdRadioArtistExperienceOrBuilder
    public boolean hasImage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(HdRadioArtistExperience hdRadioArtistExperience) {
        return DEFAULT_INSTANCE.createBuilder(hdRadioArtistExperience);
    }

    public static HdRadioArtistExperience parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioArtistExperience parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HdRadioArtistExperience parseFrom(ByteString byteString) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HdRadioArtistExperience parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HdRadioArtistExperience parseFrom(byte[] bArr) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HdRadioArtistExperience parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HdRadioArtistExperience parseFrom(InputStream inputStream) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioArtistExperience parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioArtistExperience parseFrom(CodedInputStream codedInputStream) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HdRadioArtistExperience parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioArtistExperience) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
