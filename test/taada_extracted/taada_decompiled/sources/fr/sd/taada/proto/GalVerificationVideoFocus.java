package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationVideoFocus extends GeneratedMessageLite<GalVerificationVideoFocus, Builder> implements GalVerificationVideoFocusOrBuilder {
    private static final GalVerificationVideoFocus DEFAULT_INSTANCE;
    public static final int DENY_FIELD_NUMBER = 2;
    private static volatile Parser<GalVerificationVideoFocus> PARSER = null;
    public static final int UNSOLICITED_FIELD_NUMBER = 3;
    public static final int VIDEO_FOCUS_MODE_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean deny_;
    private boolean unsolicited_;
    private byte memoizedIsInitialized = 2;
    private int videoFocusMode_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationVideoFocus$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationVideoFocus, Builder> implements GalVerificationVideoFocusOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDeny() {
            copyOnWrite();
            ((GalVerificationVideoFocus) this.instance).clearDeny();
            return this;
        }

        public Builder clearUnsolicited() {
            copyOnWrite();
            ((GalVerificationVideoFocus) this.instance).clearUnsolicited();
            return this;
        }

        public Builder clearVideoFocusMode() {
            copyOnWrite();
            ((GalVerificationVideoFocus) this.instance).clearVideoFocusMode();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
        public boolean getDeny() {
            return ((GalVerificationVideoFocus) this.instance).getDeny();
        }

        @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
        public boolean getUnsolicited() {
            return ((GalVerificationVideoFocus) this.instance).getUnsolicited();
        }

        @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
        public VideoFocusMode getVideoFocusMode() {
            return ((GalVerificationVideoFocus) this.instance).getVideoFocusMode();
        }

        @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
        public boolean hasDeny() {
            return ((GalVerificationVideoFocus) this.instance).hasDeny();
        }

        @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
        public boolean hasUnsolicited() {
            return ((GalVerificationVideoFocus) this.instance).hasUnsolicited();
        }

        @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
        public boolean hasVideoFocusMode() {
            return ((GalVerificationVideoFocus) this.instance).hasVideoFocusMode();
        }

        public Builder setDeny(boolean z6) {
            copyOnWrite();
            ((GalVerificationVideoFocus) this.instance).setDeny(z6);
            return this;
        }

        public Builder setUnsolicited(boolean z6) {
            copyOnWrite();
            ((GalVerificationVideoFocus) this.instance).setUnsolicited(z6);
            return this;
        }

        public Builder setVideoFocusMode(VideoFocusMode videoFocusMode) {
            copyOnWrite();
            ((GalVerificationVideoFocus) this.instance).setVideoFocusMode(videoFocusMode);
            return this;
        }

        private Builder() {
            super(GalVerificationVideoFocus.DEFAULT_INSTANCE);
        }
    }

    static {
        GalVerificationVideoFocus galVerificationVideoFocus = new GalVerificationVideoFocus();
        DEFAULT_INSTANCE = galVerificationVideoFocus;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationVideoFocus.class, galVerificationVideoFocus);
    }

    private GalVerificationVideoFocus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeny() {
        this.bitField0_ &= -3;
        this.deny_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnsolicited() {
        this.bitField0_ &= -5;
        this.unsolicited_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoFocusMode() {
        this.bitField0_ &= -2;
        this.videoFocusMode_ = 1;
    }

    public static GalVerificationVideoFocus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationVideoFocus parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationVideoFocus parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationVideoFocus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeny(boolean z6) {
        this.bitField0_ |= 2;
        this.deny_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnsolicited(boolean z6) {
        this.bitField0_ |= 4;
        this.unsolicited_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoFocusMode(VideoFocusMode videoFocusMode) {
        videoFocusMode.getClass();
        this.bitField0_ |= 1;
        this.videoFocusMode_ = videoFocusMode.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationVideoFocus();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\u0007\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "videoFocusMode_", VideoFocusMode.internalGetVerifier(), "deny_", "unsolicited_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationVideoFocus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationVideoFocus.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
    public boolean getDeny() {
        return this.deny_;
    }

    @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
    public boolean getUnsolicited() {
        return this.unsolicited_;
    }

    @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
    public VideoFocusMode getVideoFocusMode() {
        VideoFocusMode videoFocusModeForNumber = VideoFocusMode.forNumber(this.videoFocusMode_);
        return videoFocusModeForNumber == null ? VideoFocusMode.VIDEO_FOCUS_PROJECTED : videoFocusModeForNumber;
    }

    @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
    public boolean hasDeny() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
    public boolean hasUnsolicited() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.GalVerificationVideoFocusOrBuilder
    public boolean hasVideoFocusMode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GalVerificationVideoFocus galVerificationVideoFocus) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationVideoFocus);
    }

    public static GalVerificationVideoFocus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationVideoFocus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationVideoFocus parseFrom(ByteString byteString) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationVideoFocus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GalVerificationVideoFocus parseFrom(byte[] bArr) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationVideoFocus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationVideoFocus parseFrom(InputStream inputStream) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationVideoFocus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationVideoFocus parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationVideoFocus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationVideoFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
