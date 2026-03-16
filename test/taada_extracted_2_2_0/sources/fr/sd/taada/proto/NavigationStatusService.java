package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationStatusService extends GeneratedMessageLite<NavigationStatusService, Builder> implements NavigationStatusServiceOrBuilder {
    private static final NavigationStatusService DEFAULT_INSTANCE;
    public static final int IMAGE_OPTIONS_FIELD_NUMBER = 3;
    public static final int MINIMUM_INTERVAL_MS_FIELD_NUMBER = 1;
    private static volatile Parser<NavigationStatusService> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private ImageOptions imageOptions_;
    private int minimumIntervalMs_;
    private byte memoizedIsInitialized = 2;
    private int type_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationStatusService$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationStatusService, Builder> implements NavigationStatusServiceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearImageOptions() {
            copyOnWrite();
            ((NavigationStatusService) this.instance).clearImageOptions();
            return this;
        }

        public Builder clearMinimumIntervalMs() {
            copyOnWrite();
            ((NavigationStatusService) this.instance).clearMinimumIntervalMs();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((NavigationStatusService) this.instance).clearType();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
        public ImageOptions getImageOptions() {
            return ((NavigationStatusService) this.instance).getImageOptions();
        }

        @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
        public int getMinimumIntervalMs() {
            return ((NavigationStatusService) this.instance).getMinimumIntervalMs();
        }

        @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
        public InstrumentClusterType getType() {
            return ((NavigationStatusService) this.instance).getType();
        }

        @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
        public boolean hasImageOptions() {
            return ((NavigationStatusService) this.instance).hasImageOptions();
        }

        @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
        public boolean hasMinimumIntervalMs() {
            return ((NavigationStatusService) this.instance).hasMinimumIntervalMs();
        }

        @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
        public boolean hasType() {
            return ((NavigationStatusService) this.instance).hasType();
        }

        public Builder mergeImageOptions(ImageOptions imageOptions) {
            copyOnWrite();
            ((NavigationStatusService) this.instance).mergeImageOptions(imageOptions);
            return this;
        }

        public Builder setImageOptions(ImageOptions imageOptions) {
            copyOnWrite();
            ((NavigationStatusService) this.instance).setImageOptions(imageOptions);
            return this;
        }

        public Builder setMinimumIntervalMs(int i) {
            copyOnWrite();
            ((NavigationStatusService) this.instance).setMinimumIntervalMs(i);
            return this;
        }

        public Builder setType(InstrumentClusterType instrumentClusterType) {
            copyOnWrite();
            ((NavigationStatusService) this.instance).setType(instrumentClusterType);
            return this;
        }

        private Builder() {
            super(NavigationStatusService.DEFAULT_INSTANCE);
        }

        public Builder setImageOptions(ImageOptions.Builder builder) {
            copyOnWrite();
            ((NavigationStatusService) this.instance).setImageOptions(builder);
            return this;
        }
    }

    public static final class ImageOptions extends GeneratedMessageLite<ImageOptions, Builder> implements ImageOptionsOrBuilder {
        public static final int COLOUR_DEPTH_BITS_FIELD_NUMBER = 3;
        private static final ImageOptions DEFAULT_INSTANCE;
        public static final int HEIGHT_FIELD_NUMBER = 1;
        private static volatile Parser<ImageOptions> PARSER = null;
        public static final int WIDTH_FIELD_NUMBER = 2;
        private int bitField0_;
        private int colourDepthBits_;
        private int height_;
        private byte memoizedIsInitialized = 2;
        private int width_;

        public static final class Builder extends GeneratedMessageLite.Builder<ImageOptions, Builder> implements ImageOptionsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearColourDepthBits() {
                copyOnWrite();
                ((ImageOptions) this.instance).clearColourDepthBits();
                return this;
            }

            public Builder clearHeight() {
                copyOnWrite();
                ((ImageOptions) this.instance).clearHeight();
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((ImageOptions) this.instance).clearWidth();
                return this;
            }

            @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
            public int getColourDepthBits() {
                return ((ImageOptions) this.instance).getColourDepthBits();
            }

            @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
            public int getHeight() {
                return ((ImageOptions) this.instance).getHeight();
            }

            @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
            public int getWidth() {
                return ((ImageOptions) this.instance).getWidth();
            }

            @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
            public boolean hasColourDepthBits() {
                return ((ImageOptions) this.instance).hasColourDepthBits();
            }

            @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
            public boolean hasHeight() {
                return ((ImageOptions) this.instance).hasHeight();
            }

            @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
            public boolean hasWidth() {
                return ((ImageOptions) this.instance).hasWidth();
            }

            public Builder setColourDepthBits(int i) {
                copyOnWrite();
                ((ImageOptions) this.instance).setColourDepthBits(i);
                return this;
            }

            public Builder setHeight(int i) {
                copyOnWrite();
                ((ImageOptions) this.instance).setHeight(i);
                return this;
            }

            public Builder setWidth(int i) {
                copyOnWrite();
                ((ImageOptions) this.instance).setWidth(i);
                return this;
            }

            private Builder() {
                super(ImageOptions.DEFAULT_INSTANCE);
            }
        }

        static {
            ImageOptions imageOptions = new ImageOptions();
            DEFAULT_INSTANCE = imageOptions;
            GeneratedMessageLite.registerDefaultInstance(ImageOptions.class, imageOptions);
        }

        private ImageOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearColourDepthBits() {
            this.bitField0_ &= -5;
            this.colourDepthBits_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.bitField0_ &= -2;
            this.height_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.bitField0_ &= -3;
            this.width_ = 0;
        }

        public static ImageOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ImageOptions parseDelimitedFrom(InputStream inputStream) {
            return (ImageOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ImageOptions parseFrom(ByteBuffer byteBuffer) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ImageOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColourDepthBits(int i) {
            this.bitField0_ |= 4;
            this.colourDepthBits_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int i) {
            this.bitField0_ |= 1;
            this.height_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int i) {
            this.bitField0_ |= 2;
            this.width_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ImageOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001Ԅ\u0000\u0002Ԅ\u0001\u0003Ԅ\u0002", new Object[]{"bitField0_", "height_", "width_", "colourDepthBits_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ImageOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ImageOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
        public int getColourDepthBits() {
            return this.colourDepthBits_;
        }

        @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
        public boolean hasColourDepthBits() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
        public boolean hasHeight() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // fr.sd.taada.proto.NavigationStatusService.ImageOptionsOrBuilder
        public boolean hasWidth() {
            return (this.bitField0_ & 2) != 0;
        }

        public static Builder newBuilder(ImageOptions imageOptions) {
            return DEFAULT_INSTANCE.createBuilder(imageOptions);
        }

        public static ImageOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImageOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ImageOptions parseFrom(ByteString byteString) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ImageOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ImageOptions parseFrom(byte[] bArr) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ImageOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ImageOptions parseFrom(InputStream inputStream) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ImageOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImageOptions parseFrom(CodedInputStream codedInputStream) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ImageOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ImageOptionsOrBuilder extends MessageLiteOrBuilder {
        int getColourDepthBits();

        int getHeight();

        int getWidth();

        boolean hasColourDepthBits();

        boolean hasHeight();

        boolean hasWidth();
    }

    public enum InstrumentClusterType implements Internal.EnumLite {
        IMAGE(1),
        ENUM(2);

        public static final int ENUM_VALUE = 2;
        public static final int IMAGE_VALUE = 1;
        private static final Internal.EnumLiteMap<InstrumentClusterType> internalValueMap = new Internal.EnumLiteMap<InstrumentClusterType>() { // from class: fr.sd.taada.proto.NavigationStatusService.InstrumentClusterType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public InstrumentClusterType findValueByNumber(int i) {
                return InstrumentClusterType.forNumber(i);
            }
        };
        private final int value;

        public static final class InstrumentClusterTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new InstrumentClusterTypeVerifier();

            private InstrumentClusterTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return InstrumentClusterType.forNumber(i) != null;
            }
        }

        InstrumentClusterType(int i) {
            this.value = i;
        }

        public static InstrumentClusterType forNumber(int i) {
            if (i == 1) {
                return IMAGE;
            }
            if (i != 2) {
                return null;
            }
            return ENUM;
        }

        public static Internal.EnumLiteMap<InstrumentClusterType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return InstrumentClusterTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static InstrumentClusterType valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NavigationStatusService navigationStatusService = new NavigationStatusService();
        DEFAULT_INSTANCE = navigationStatusService;
        GeneratedMessageLite.registerDefaultInstance(NavigationStatusService.class, navigationStatusService);
    }

    private NavigationStatusService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageOptions() {
        this.imageOptions_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinimumIntervalMs() {
        this.bitField0_ &= -2;
        this.minimumIntervalMs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -3;
        this.type_ = 1;
    }

    public static NavigationStatusService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeImageOptions(ImageOptions imageOptions) {
        imageOptions.getClass();
        ImageOptions imageOptions2 = this.imageOptions_;
        if (imageOptions2 == null || imageOptions2 == ImageOptions.getDefaultInstance()) {
            this.imageOptions_ = imageOptions;
        } else {
            this.imageOptions_ = ImageOptions.newBuilder(this.imageOptions_).mergeFrom(imageOptions).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationStatusService parseDelimitedFrom(InputStream inputStream) {
        return (NavigationStatusService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStatusService parseFrom(ByteBuffer byteBuffer) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationStatusService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageOptions(ImageOptions imageOptions) {
        imageOptions.getClass();
        this.imageOptions_ = imageOptions;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinimumIntervalMs(int i) {
        this.bitField0_ |= 1;
        this.minimumIntervalMs_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(InstrumentClusterType instrumentClusterType) {
        instrumentClusterType.getClass();
        this.bitField0_ |= 2;
        this.type_ = instrumentClusterType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationStatusService();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001Ԅ\u0000\u0002Ԍ\u0001\u0003Љ\u0002", new Object[]{"bitField0_", "minimumIntervalMs_", "type_", InstrumentClusterType.internalGetVerifier(), "imageOptions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationStatusService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationStatusService.class) {
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
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
    public ImageOptions getImageOptions() {
        ImageOptions imageOptions = this.imageOptions_;
        return imageOptions == null ? ImageOptions.getDefaultInstance() : imageOptions;
    }

    @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
    public int getMinimumIntervalMs() {
        return this.minimumIntervalMs_;
    }

    @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
    public InstrumentClusterType getType() {
        InstrumentClusterType instrumentClusterTypeForNumber = InstrumentClusterType.forNumber(this.type_);
        return instrumentClusterTypeForNumber == null ? InstrumentClusterType.IMAGE : instrumentClusterTypeForNumber;
    }

    @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
    public boolean hasImageOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
    public boolean hasMinimumIntervalMs() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationStatusServiceOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(NavigationStatusService navigationStatusService) {
        return DEFAULT_INSTANCE.createBuilder(navigationStatusService);
    }

    public static NavigationStatusService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatusService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationStatusService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationStatusService parseFrom(ByteString byteString) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationStatusService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageOptions(ImageOptions.Builder builder) {
        this.imageOptions_ = builder.build();
        this.bitField0_ |= 4;
    }

    public static NavigationStatusService parseFrom(byte[] bArr) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationStatusService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationStatusService parseFrom(InputStream inputStream) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStatusService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationStatusService parseFrom(CodedInputStream codedInputStream) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationStatusService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatusService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
