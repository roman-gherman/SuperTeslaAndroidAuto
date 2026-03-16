package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.AudioConfiguration;
import fr.sd.taada.proto.VideoConfiguration;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaSinkService extends GeneratedMessageLite<MediaSinkService, Builder> implements MediaSinkServiceOrBuilder {
    public static final int AUDIO_CONFIGS_FIELD_NUMBER = 3;
    public static final int AUDIO_TYPE_FIELD_NUMBER = 2;
    public static final int AVAILABLE_TYPE_FIELD_NUMBER = 1;
    public static final int AVAILABLE_WHILE_IN_CALL_FIELD_NUMBER = 5;
    private static final MediaSinkService DEFAULT_INSTANCE;
    public static final int DISPLAY_ID_FIELD_NUMBER = 6;
    public static final int DISPLAY_TYPE_FIELD_NUMBER = 7;
    public static final int INITIAL_CONTENT_KEYCODE_FIELD_NUMBER = 8;
    private static volatile Parser<MediaSinkService> PARSER = null;
    public static final int VIDEO_CONFIGS_FIELD_NUMBER = 4;
    private boolean availableWhileInCall_;
    private int bitField0_;
    private int displayId_;
    private int displayType_;
    private int initialContentKeycode_;
    private byte memoizedIsInitialized = 2;
    private int availableType_ = 1;
    private int audioType_ = 1;
    private Internal.ProtobufList<AudioConfiguration> audioConfigs_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<VideoConfiguration> videoConfigs_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaSinkService$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaSinkService, Builder> implements MediaSinkServiceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAudioConfigs(Iterable<? extends AudioConfiguration> iterable) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addAllAudioConfigs(iterable);
            return this;
        }

        public Builder addAllVideoConfigs(Iterable<? extends VideoConfiguration> iterable) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addAllVideoConfigs(iterable);
            return this;
        }

        public Builder addAudioConfigs(AudioConfiguration audioConfiguration) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addAudioConfigs(audioConfiguration);
            return this;
        }

        public Builder addVideoConfigs(VideoConfiguration videoConfiguration) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addVideoConfigs(videoConfiguration);
            return this;
        }

        public Builder clearAudioConfigs() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearAudioConfigs();
            return this;
        }

        public Builder clearAudioType() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearAudioType();
            return this;
        }

        public Builder clearAvailableType() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearAvailableType();
            return this;
        }

        public Builder clearAvailableWhileInCall() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearAvailableWhileInCall();
            return this;
        }

        public Builder clearDisplayId() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearDisplayId();
            return this;
        }

        public Builder clearDisplayType() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearDisplayType();
            return this;
        }

        public Builder clearInitialContentKeycode() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearInitialContentKeycode();
            return this;
        }

        public Builder clearVideoConfigs() {
            copyOnWrite();
            ((MediaSinkService) this.instance).clearVideoConfigs();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public AudioConfiguration getAudioConfigs(int i) {
            return ((MediaSinkService) this.instance).getAudioConfigs(i);
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public int getAudioConfigsCount() {
            return ((MediaSinkService) this.instance).getAudioConfigsCount();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public List<AudioConfiguration> getAudioConfigsList() {
            return Collections.unmodifiableList(((MediaSinkService) this.instance).getAudioConfigsList());
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public AudioStreamType getAudioType() {
            return ((MediaSinkService) this.instance).getAudioType();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public MediaCodecType getAvailableType() {
            return ((MediaSinkService) this.instance).getAvailableType();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public boolean getAvailableWhileInCall() {
            return ((MediaSinkService) this.instance).getAvailableWhileInCall();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public int getDisplayId() {
            return ((MediaSinkService) this.instance).getDisplayId();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public DisplayType getDisplayType() {
            return ((MediaSinkService) this.instance).getDisplayType();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public KeyCode getInitialContentKeycode() {
            return ((MediaSinkService) this.instance).getInitialContentKeycode();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public VideoConfiguration getVideoConfigs(int i) {
            return ((MediaSinkService) this.instance).getVideoConfigs(i);
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public int getVideoConfigsCount() {
            return ((MediaSinkService) this.instance).getVideoConfigsCount();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public List<VideoConfiguration> getVideoConfigsList() {
            return Collections.unmodifiableList(((MediaSinkService) this.instance).getVideoConfigsList());
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public boolean hasAudioType() {
            return ((MediaSinkService) this.instance).hasAudioType();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public boolean hasAvailableType() {
            return ((MediaSinkService) this.instance).hasAvailableType();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public boolean hasAvailableWhileInCall() {
            return ((MediaSinkService) this.instance).hasAvailableWhileInCall();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public boolean hasDisplayId() {
            return ((MediaSinkService) this.instance).hasDisplayId();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public boolean hasDisplayType() {
            return ((MediaSinkService) this.instance).hasDisplayType();
        }

        @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
        public boolean hasInitialContentKeycode() {
            return ((MediaSinkService) this.instance).hasInitialContentKeycode();
        }

        public Builder removeAudioConfigs(int i) {
            copyOnWrite();
            ((MediaSinkService) this.instance).removeAudioConfigs(i);
            return this;
        }

        public Builder removeVideoConfigs(int i) {
            copyOnWrite();
            ((MediaSinkService) this.instance).removeVideoConfigs(i);
            return this;
        }

        public Builder setAudioConfigs(int i, AudioConfiguration audioConfiguration) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setAudioConfigs(i, audioConfiguration);
            return this;
        }

        public Builder setAudioType(AudioStreamType audioStreamType) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setAudioType(audioStreamType);
            return this;
        }

        public Builder setAvailableType(MediaCodecType mediaCodecType) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setAvailableType(mediaCodecType);
            return this;
        }

        public Builder setAvailableWhileInCall(boolean z6) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setAvailableWhileInCall(z6);
            return this;
        }

        public Builder setDisplayId(int i) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setDisplayId(i);
            return this;
        }

        public Builder setDisplayType(DisplayType displayType) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setDisplayType(displayType);
            return this;
        }

        public Builder setInitialContentKeycode(KeyCode keyCode) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setInitialContentKeycode(keyCode);
            return this;
        }

        public Builder setVideoConfigs(int i, VideoConfiguration videoConfiguration) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setVideoConfigs(i, videoConfiguration);
            return this;
        }

        private Builder() {
            super(MediaSinkService.DEFAULT_INSTANCE);
        }

        public Builder addAudioConfigs(int i, AudioConfiguration audioConfiguration) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addAudioConfigs(i, audioConfiguration);
            return this;
        }

        public Builder addVideoConfigs(int i, VideoConfiguration videoConfiguration) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addVideoConfigs(i, videoConfiguration);
            return this;
        }

        public Builder setAudioConfigs(int i, AudioConfiguration.Builder builder) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setAudioConfigs(i, builder);
            return this;
        }

        public Builder setVideoConfigs(int i, VideoConfiguration.Builder builder) {
            copyOnWrite();
            ((MediaSinkService) this.instance).setVideoConfigs(i, builder);
            return this;
        }

        public Builder addAudioConfigs(AudioConfiguration.Builder builder) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addAudioConfigs(builder);
            return this;
        }

        public Builder addVideoConfigs(VideoConfiguration.Builder builder) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addVideoConfigs(builder);
            return this;
        }

        public Builder addAudioConfigs(int i, AudioConfiguration.Builder builder) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addAudioConfigs(i, builder);
            return this;
        }

        public Builder addVideoConfigs(int i, VideoConfiguration.Builder builder) {
            copyOnWrite();
            ((MediaSinkService) this.instance).addVideoConfigs(i, builder);
            return this;
        }
    }

    static {
        MediaSinkService mediaSinkService = new MediaSinkService();
        DEFAULT_INSTANCE = mediaSinkService;
        GeneratedMessageLite.registerDefaultInstance(MediaSinkService.class, mediaSinkService);
    }

    private MediaSinkService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAudioConfigs(Iterable<? extends AudioConfiguration> iterable) {
        ensureAudioConfigsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.audioConfigs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVideoConfigs(Iterable<? extends VideoConfiguration> iterable) {
        ensureVideoConfigsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.videoConfigs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAudioConfigs(AudioConfiguration audioConfiguration) {
        audioConfiguration.getClass();
        ensureAudioConfigsIsMutable();
        this.audioConfigs_.add(audioConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVideoConfigs(VideoConfiguration videoConfiguration) {
        videoConfiguration.getClass();
        ensureVideoConfigsIsMutable();
        this.videoConfigs_.add(videoConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioConfigs() {
        this.audioConfigs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioType() {
        this.bitField0_ &= -3;
        this.audioType_ = 1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayId() {
        this.bitField0_ &= -9;
        this.displayId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayType() {
        this.bitField0_ &= -17;
        this.displayType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInitialContentKeycode() {
        this.bitField0_ &= -33;
        this.initialContentKeycode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoConfigs() {
        this.videoConfigs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAudioConfigsIsMutable() {
        if (this.audioConfigs_.isModifiable()) {
            return;
        }
        this.audioConfigs_ = GeneratedMessageLite.mutableCopy(this.audioConfigs_);
    }

    private void ensureVideoConfigsIsMutable() {
        if (this.videoConfigs_.isModifiable()) {
            return;
        }
        this.videoConfigs_ = GeneratedMessageLite.mutableCopy(this.videoConfigs_);
    }

    public static MediaSinkService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaSinkService parseDelimitedFrom(InputStream inputStream) {
        return (MediaSinkService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSinkService parseFrom(ByteBuffer byteBuffer) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaSinkService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAudioConfigs(int i) {
        ensureAudioConfigsIsMutable();
        this.audioConfigs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeVideoConfigs(int i) {
        ensureVideoConfigsIsMutable();
        this.videoConfigs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioConfigs(int i, AudioConfiguration audioConfiguration) {
        audioConfiguration.getClass();
        ensureAudioConfigsIsMutable();
        this.audioConfigs_.set(i, audioConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioType(AudioStreamType audioStreamType) {
        audioStreamType.getClass();
        this.bitField0_ |= 2;
        this.audioType_ = audioStreamType.getNumber();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayId(int i) {
        this.bitField0_ |= 8;
        this.displayId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayType(DisplayType displayType) {
        displayType.getClass();
        this.bitField0_ |= 16;
        this.displayType_ = displayType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInitialContentKeycode(KeyCode keyCode) {
        keyCode.getClass();
        this.bitField0_ |= 32;
        this.initialContentKeycode_ = keyCode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoConfigs(int i, VideoConfiguration videoConfiguration) {
        videoConfiguration.getClass();
        ensureVideoConfigsIsMutable();
        this.videoConfigs_.set(i, videoConfiguration);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaSinkService();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0001\u0001\f\u0000\u0002\f\u0001\u0003Л\u0004\u001b\u0005\u0007\u0002\u0006\u000b\u0003\u0007\f\u0004\b\f\u0005", new Object[]{"bitField0_", "availableType_", MediaCodecType.internalGetVerifier(), "audioType_", AudioStreamType.internalGetVerifier(), "audioConfigs_", AudioConfiguration.class, "videoConfigs_", VideoConfiguration.class, "availableWhileInCall_", "displayId_", "displayType_", DisplayType.internalGetVerifier(), "initialContentKeycode_", KeyCode.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaSinkService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaSinkService.class) {
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

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public AudioConfiguration getAudioConfigs(int i) {
        return this.audioConfigs_.get(i);
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public int getAudioConfigsCount() {
        return this.audioConfigs_.size();
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public List<AudioConfiguration> getAudioConfigsList() {
        return this.audioConfigs_;
    }

    public AudioConfigurationOrBuilder getAudioConfigsOrBuilder(int i) {
        return this.audioConfigs_.get(i);
    }

    public List<? extends AudioConfigurationOrBuilder> getAudioConfigsOrBuilderList() {
        return this.audioConfigs_;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public AudioStreamType getAudioType() {
        AudioStreamType audioStreamTypeForNumber = AudioStreamType.forNumber(this.audioType_);
        return audioStreamTypeForNumber == null ? AudioStreamType.AUDIO_STREAM_GUIDANCE : audioStreamTypeForNumber;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public MediaCodecType getAvailableType() {
        MediaCodecType mediaCodecTypeForNumber = MediaCodecType.forNumber(this.availableType_);
        return mediaCodecTypeForNumber == null ? MediaCodecType.MEDIA_CODEC_AUDIO_PCM : mediaCodecTypeForNumber;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public boolean getAvailableWhileInCall() {
        return this.availableWhileInCall_;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public int getDisplayId() {
        return this.displayId_;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public DisplayType getDisplayType() {
        DisplayType displayTypeForNumber = DisplayType.forNumber(this.displayType_);
        return displayTypeForNumber == null ? DisplayType.DISPLAY_TYPE_MAIN : displayTypeForNumber;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public KeyCode getInitialContentKeycode() {
        KeyCode keyCodeForNumber = KeyCode.forNumber(this.initialContentKeycode_);
        return keyCodeForNumber == null ? KeyCode.KEYCODE_UNKNOWN : keyCodeForNumber;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public VideoConfiguration getVideoConfigs(int i) {
        return this.videoConfigs_.get(i);
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public int getVideoConfigsCount() {
        return this.videoConfigs_.size();
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public List<VideoConfiguration> getVideoConfigsList() {
        return this.videoConfigs_;
    }

    public VideoConfigurationOrBuilder getVideoConfigsOrBuilder(int i) {
        return this.videoConfigs_.get(i);
    }

    public List<? extends VideoConfigurationOrBuilder> getVideoConfigsOrBuilderList() {
        return this.videoConfigs_;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public boolean hasAudioType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public boolean hasAvailableType() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public boolean hasAvailableWhileInCall() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public boolean hasDisplayId() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public boolean hasDisplayType() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSinkServiceOrBuilder
    public boolean hasInitialContentKeycode() {
        return (this.bitField0_ & 32) != 0;
    }

    public static Builder newBuilder(MediaSinkService mediaSinkService) {
        return DEFAULT_INSTANCE.createBuilder(mediaSinkService);
    }

    public static MediaSinkService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSinkService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSinkService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaSinkService parseFrom(ByteString byteString) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAudioConfigs(int i, AudioConfiguration audioConfiguration) {
        audioConfiguration.getClass();
        ensureAudioConfigsIsMutable();
        this.audioConfigs_.add(i, audioConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVideoConfigs(int i, VideoConfiguration videoConfiguration) {
        videoConfiguration.getClass();
        ensureVideoConfigsIsMutable();
        this.videoConfigs_.add(i, videoConfiguration);
    }

    public static MediaSinkService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioConfigs(int i, AudioConfiguration.Builder builder) {
        ensureAudioConfigsIsMutable();
        this.audioConfigs_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoConfigs(int i, VideoConfiguration.Builder builder) {
        ensureVideoConfigsIsMutable();
        this.videoConfigs_.set(i, builder.build());
    }

    public static MediaSinkService parseFrom(byte[] bArr) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaSinkService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAudioConfigs(AudioConfiguration.Builder builder) {
        ensureAudioConfigsIsMutable();
        this.audioConfigs_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVideoConfigs(VideoConfiguration.Builder builder) {
        ensureVideoConfigsIsMutable();
        this.videoConfigs_.add(builder.build());
    }

    public static MediaSinkService parseFrom(InputStream inputStream) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSinkService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAudioConfigs(int i, AudioConfiguration.Builder builder) {
        ensureAudioConfigsIsMutable();
        this.audioConfigs_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVideoConfigs(int i, VideoConfiguration.Builder builder) {
        ensureVideoConfigsIsMutable();
        this.videoConfigs_.add(i, builder.build());
    }

    public static MediaSinkService parseFrom(CodedInputStream codedInputStream) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaSinkService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSinkService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
