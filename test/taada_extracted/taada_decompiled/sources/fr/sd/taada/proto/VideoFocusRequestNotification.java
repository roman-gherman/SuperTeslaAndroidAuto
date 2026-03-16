package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoFocusRequestNotification extends GeneratedMessageLite<VideoFocusRequestNotification, Builder> implements VideoFocusRequestNotificationOrBuilder {
    private static final VideoFocusRequestNotification DEFAULT_INSTANCE;
    public static final int DISP_CHANNEL_ID_FIELD_NUMBER = 1;
    public static final int MODE_FIELD_NUMBER = 2;
    private static volatile Parser<VideoFocusRequestNotification> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    private int bitField0_;
    private int dispChannelId_;
    private int mode_ = 1;
    private int reason_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.VideoFocusRequestNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<VideoFocusRequestNotification, Builder> implements VideoFocusRequestNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Deprecated
        public Builder clearDispChannelId() {
            copyOnWrite();
            ((VideoFocusRequestNotification) this.instance).clearDispChannelId();
            return this;
        }

        public Builder clearMode() {
            copyOnWrite();
            ((VideoFocusRequestNotification) this.instance).clearMode();
            return this;
        }

        public Builder clearReason() {
            copyOnWrite();
            ((VideoFocusRequestNotification) this.instance).clearReason();
            return this;
        }

        @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
        @Deprecated
        public int getDispChannelId() {
            return ((VideoFocusRequestNotification) this.instance).getDispChannelId();
        }

        @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
        public VideoFocusMode getMode() {
            return ((VideoFocusRequestNotification) this.instance).getMode();
        }

        @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
        public VideoFocusReason getReason() {
            return ((VideoFocusRequestNotification) this.instance).getReason();
        }

        @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
        @Deprecated
        public boolean hasDispChannelId() {
            return ((VideoFocusRequestNotification) this.instance).hasDispChannelId();
        }

        @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
        public boolean hasMode() {
            return ((VideoFocusRequestNotification) this.instance).hasMode();
        }

        @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
        public boolean hasReason() {
            return ((VideoFocusRequestNotification) this.instance).hasReason();
        }

        @Deprecated
        public Builder setDispChannelId(int i) {
            copyOnWrite();
            ((VideoFocusRequestNotification) this.instance).setDispChannelId(i);
            return this;
        }

        public Builder setMode(VideoFocusMode videoFocusMode) {
            copyOnWrite();
            ((VideoFocusRequestNotification) this.instance).setMode(videoFocusMode);
            return this;
        }

        public Builder setReason(VideoFocusReason videoFocusReason) {
            copyOnWrite();
            ((VideoFocusRequestNotification) this.instance).setReason(videoFocusReason);
            return this;
        }

        private Builder() {
            super(VideoFocusRequestNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        VideoFocusRequestNotification videoFocusRequestNotification = new VideoFocusRequestNotification();
        DEFAULT_INSTANCE = videoFocusRequestNotification;
        GeneratedMessageLite.registerDefaultInstance(VideoFocusRequestNotification.class, videoFocusRequestNotification);
    }

    private VideoFocusRequestNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispChannelId() {
        this.bitField0_ &= -2;
        this.dispChannelId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMode() {
        this.bitField0_ &= -3;
        this.mode_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.bitField0_ &= -5;
        this.reason_ = 0;
    }

    public static VideoFocusRequestNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VideoFocusRequestNotification parseDelimitedFrom(InputStream inputStream) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VideoFocusRequestNotification parseFrom(ByteBuffer byteBuffer) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VideoFocusRequestNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispChannelId(int i) {
        this.bitField0_ |= 1;
        this.dispChannelId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(VideoFocusMode videoFocusMode) {
        videoFocusMode.getClass();
        this.bitField0_ |= 2;
        this.mode_ = videoFocusMode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(VideoFocusReason videoFocusReason) {
        videoFocusReason.getClass();
        this.bitField0_ |= 4;
        this.reason_ = videoFocusReason.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new VideoFocusRequestNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\f\u0001\u0003\f\u0002", new Object[]{"bitField0_", "dispChannelId_", "mode_", VideoFocusMode.internalGetVerifier(), "reason_", VideoFocusReason.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VideoFocusRequestNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VideoFocusRequestNotification.class) {
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

    @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
    @Deprecated
    public int getDispChannelId() {
        return this.dispChannelId_;
    }

    @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
    public VideoFocusMode getMode() {
        VideoFocusMode videoFocusModeForNumber = VideoFocusMode.forNumber(this.mode_);
        return videoFocusModeForNumber == null ? VideoFocusMode.VIDEO_FOCUS_PROJECTED : videoFocusModeForNumber;
    }

    @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
    public VideoFocusReason getReason() {
        VideoFocusReason videoFocusReasonForNumber = VideoFocusReason.forNumber(this.reason_);
        return videoFocusReasonForNumber == null ? VideoFocusReason.UNKNOWN : videoFocusReasonForNumber;
    }

    @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
    @Deprecated
    public boolean hasDispChannelId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
    public boolean hasMode() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.VideoFocusRequestNotificationOrBuilder
    public boolean hasReason() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(VideoFocusRequestNotification videoFocusRequestNotification) {
        return DEFAULT_INSTANCE.createBuilder(videoFocusRequestNotification);
    }

    public static VideoFocusRequestNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VideoFocusRequestNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VideoFocusRequestNotification parseFrom(ByteString byteString) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VideoFocusRequestNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VideoFocusRequestNotification parseFrom(byte[] bArr) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VideoFocusRequestNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VideoFocusRequestNotification parseFrom(InputStream inputStream) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VideoFocusRequestNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VideoFocusRequestNotification parseFrom(CodedInputStream codedInputStream) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VideoFocusRequestNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
