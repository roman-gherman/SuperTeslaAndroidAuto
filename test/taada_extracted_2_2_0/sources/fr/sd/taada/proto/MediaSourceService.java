package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.AudioConfiguration;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaSourceService extends GeneratedMessageLite<MediaSourceService, Builder> implements MediaSourceServiceOrBuilder {
    public static final int AUDIO_CONFIG_FIELD_NUMBER = 2;
    public static final int AVAILABLE_TYPE_FIELD_NUMBER = 1;
    public static final int AVAILABLE_WHILE_IN_CALL_FIELD_NUMBER = 3;
    private static final MediaSourceService DEFAULT_INSTANCE;
    private static volatile Parser<MediaSourceService> PARSER;
    private AudioConfiguration audioConfig_;
    private boolean availableWhileInCall_;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int availableType_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaSourceService$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaSourceService, Builder> implements MediaSourceServiceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAudioConfig() {
            copyOnWrite();
            ((MediaSourceService) this.instance).clearAudioConfig();
            return this;
        }

        public Builder clearAvailableType() {
            copyOnWrite();
            ((MediaSourceService) this.instance).clearAvailableType();
            return this;
        }

        public Builder clearAvailableWhileInCall() {
            copyOnWrite();
            ((MediaSourceService) this.instance).clearAvailableWhileInCall();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
        public AudioConfiguration getAudioConfig() {
            return ((MediaSourceService) this.instance).getAudioConfig();
        }

        @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
        public MediaCodecType getAvailableType() {
            return ((MediaSourceService) this.instance).getAvailableType();
        }

        @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
        public boolean getAvailableWhileInCall() {
            return ((MediaSourceService) this.instance).getAvailableWhileInCall();
        }

        @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
        public boolean hasAudioConfig() {
            return ((MediaSourceService) this.instance).hasAudioConfig();
        }

        @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
        public boolean hasAvailableType() {
            return ((MediaSourceService) this.instance).hasAvailableType();
        }

        @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
        public boolean hasAvailableWhileInCall() {
            return ((MediaSourceService) this.instance).hasAvailableWhileInCall();
        }

        public Builder mergeAudioConfig(AudioConfiguration audioConfiguration) {
            copyOnWrite();
            ((MediaSourceService) this.instance).mergeAudioConfig(audioConfiguration);
            return this;
        }

        public Builder setAudioConfig(AudioConfiguration audioConfiguration) {
            copyOnWrite();
            ((MediaSourceService) this.instance).setAudioConfig(audioConfiguration);
            return this;
        }

        public Builder setAvailableType(MediaCodecType mediaCodecType) {
            copyOnWrite();
            ((MediaSourceService) this.instance).setAvailableType(mediaCodecType);
            return this;
        }

        public Builder setAvailableWhileInCall(boolean z6) {
            copyOnWrite();
            ((MediaSourceService) this.instance).setAvailableWhileInCall(z6);
            return this;
        }

        private Builder() {
            super(MediaSourceService.DEFAULT_INSTANCE);
        }

        public Builder setAudioConfig(AudioConfiguration.Builder builder) {
            copyOnWrite();
            ((MediaSourceService) this.instance).setAudioConfig(builder);
            return this;
        }
    }

    static {
        MediaSourceService mediaSourceService = new MediaSourceService();
        DEFAULT_INSTANCE = mediaSourceService;
        GeneratedMessageLite.registerDefaultInstance(MediaSourceService.class, mediaSourceService);
    }

    private MediaSourceService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioConfig() {
        this.audioConfig_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAvailableType() {
        this.bitField0_ &= -2;
        this.availableType_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAvailableWhileInCall() {
        this.bitField0_ &= -5;
        this.availableWhileInCall_ = false;
    }

    public static MediaSourceService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAudioConfig(AudioConfiguration audioConfiguration) {
        audioConfiguration.getClass();
        AudioConfiguration audioConfiguration2 = this.audioConfig_;
        if (audioConfiguration2 == null || audioConfiguration2 == AudioConfiguration.getDefaultInstance()) {
            this.audioConfig_ = audioConfiguration;
        } else {
            this.audioConfig_ = AudioConfiguration.newBuilder(this.audioConfig_).mergeFrom(audioConfiguration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaSourceService parseDelimitedFrom(InputStream inputStream) {
        return (MediaSourceService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSourceService parseFrom(ByteBuffer byteBuffer) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaSourceService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioConfig(AudioConfiguration audioConfiguration) {
        audioConfiguration.getClass();
        this.audioConfig_ = audioConfiguration;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvailableType(MediaCodecType mediaCodecType) {
        mediaCodecType.getClass();
        this.bitField0_ |= 1;
        this.availableType_ = mediaCodecType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvailableWhileInCall(boolean z6) {
        this.bitField0_ |= 4;
        this.availableWhileInCall_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaSourceService();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001\f\u0000\u0002Љ\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "availableType_", MediaCodecType.internalGetVerifier(), "audioConfig_", "availableWhileInCall_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaSourceService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaSourceService.class) {
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

    @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
    public AudioConfiguration getAudioConfig() {
        AudioConfiguration audioConfiguration = this.audioConfig_;
        return audioConfiguration == null ? AudioConfiguration.getDefaultInstance() : audioConfiguration;
    }

    @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
    public MediaCodecType getAvailableType() {
        MediaCodecType mediaCodecTypeForNumber = MediaCodecType.forNumber(this.availableType_);
        return mediaCodecTypeForNumber == null ? MediaCodecType.MEDIA_CODEC_AUDIO_PCM : mediaCodecTypeForNumber;
    }

    @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
    public boolean getAvailableWhileInCall() {
        return this.availableWhileInCall_;
    }

    @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
    public boolean hasAudioConfig() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
    public boolean hasAvailableType() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSourceServiceOrBuilder
    public boolean hasAvailableWhileInCall() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(MediaSourceService mediaSourceService) {
        return DEFAULT_INSTANCE.createBuilder(mediaSourceService);
    }

    public static MediaSourceService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSourceService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaSourceService parseFrom(ByteString byteString) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaSourceService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioConfig(AudioConfiguration.Builder builder) {
        this.audioConfig_ = builder.build();
        this.bitField0_ |= 2;
    }

    public static MediaSourceService parseFrom(byte[] bArr) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaSourceService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaSourceService parseFrom(InputStream inputStream) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSourceService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSourceService parseFrom(CodedInputStream codedInputStream) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaSourceService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
