package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoFocusNotification extends GeneratedMessageLite<VideoFocusNotification, Builder> implements VideoFocusNotificationOrBuilder {
    private static final VideoFocusNotification DEFAULT_INSTANCE;
    public static final int FOCUS_FIELD_NUMBER = 1;
    private static volatile Parser<VideoFocusNotification> PARSER = null;
    public static final int UNSOLICITED_FIELD_NUMBER = 2;
    private int bitField0_;
    private int focus_ = 1;
    private boolean unsolicited_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.VideoFocusNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<VideoFocusNotification, Builder> implements VideoFocusNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFocus() {
            copyOnWrite();
            ((VideoFocusNotification) this.instance).clearFocus();
            return this;
        }

        public Builder clearUnsolicited() {
            copyOnWrite();
            ((VideoFocusNotification) this.instance).clearUnsolicited();
            return this;
        }

        @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
        public VideoFocusMode getFocus() {
            return ((VideoFocusNotification) this.instance).getFocus();
        }

        @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
        public boolean getUnsolicited() {
            return ((VideoFocusNotification) this.instance).getUnsolicited();
        }

        @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
        public boolean hasFocus() {
            return ((VideoFocusNotification) this.instance).hasFocus();
        }

        @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
        public boolean hasUnsolicited() {
            return ((VideoFocusNotification) this.instance).hasUnsolicited();
        }

        public Builder setFocus(VideoFocusMode videoFocusMode) {
            copyOnWrite();
            ((VideoFocusNotification) this.instance).setFocus(videoFocusMode);
            return this;
        }

        public Builder setUnsolicited(boolean z6) {
            copyOnWrite();
            ((VideoFocusNotification) this.instance).setUnsolicited(z6);
            return this;
        }

        private Builder() {
            super(VideoFocusNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        VideoFocusNotification videoFocusNotification = new VideoFocusNotification();
        DEFAULT_INSTANCE = videoFocusNotification;
        GeneratedMessageLite.registerDefaultInstance(VideoFocusNotification.class, videoFocusNotification);
    }

    private VideoFocusNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFocus() {
        this.bitField0_ &= -2;
        this.focus_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnsolicited() {
        this.bitField0_ &= -3;
        this.unsolicited_ = false;
    }

    public static VideoFocusNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VideoFocusNotification parseDelimitedFrom(InputStream inputStream) {
        return (VideoFocusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VideoFocusNotification parseFrom(ByteBuffer byteBuffer) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VideoFocusNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(VideoFocusMode videoFocusMode) {
        videoFocusMode.getClass();
        this.bitField0_ |= 1;
        this.focus_ = videoFocusMode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnsolicited(boolean z6) {
        this.bitField0_ |= 2;
        this.unsolicited_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new VideoFocusNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001", new Object[]{"bitField0_", "focus_", VideoFocusMode.internalGetVerifier(), "unsolicited_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VideoFocusNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VideoFocusNotification.class) {
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

    @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
    public VideoFocusMode getFocus() {
        VideoFocusMode videoFocusModeForNumber = VideoFocusMode.forNumber(this.focus_);
        return videoFocusModeForNumber == null ? VideoFocusMode.VIDEO_FOCUS_PROJECTED : videoFocusModeForNumber;
    }

    @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
    public boolean getUnsolicited() {
        return this.unsolicited_;
    }

    @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
    public boolean hasFocus() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.VideoFocusNotificationOrBuilder
    public boolean hasUnsolicited() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(VideoFocusNotification videoFocusNotification) {
        return DEFAULT_INSTANCE.createBuilder(videoFocusNotification);
    }

    public static VideoFocusNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VideoFocusNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VideoFocusNotification parseFrom(ByteString byteString) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VideoFocusNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VideoFocusNotification parseFrom(byte[] bArr) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VideoFocusNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VideoFocusNotification parseFrom(InputStream inputStream) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VideoFocusNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VideoFocusNotification parseFrom(CodedInputStream codedInputStream) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VideoFocusNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
