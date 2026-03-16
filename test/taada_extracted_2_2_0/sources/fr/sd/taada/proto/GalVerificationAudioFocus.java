package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationAudioFocus extends GeneratedMessageLite<GalVerificationAudioFocus, Builder> implements GalVerificationAudioFocusOrBuilder {
    public static final int AUDIO_FOCUS_STATE_FIELD_NUMBER = 1;
    public static final int CHANNEL_FIELD_NUMBER = 2;
    private static final GalVerificationAudioFocus DEFAULT_INSTANCE;
    private static volatile Parser<GalVerificationAudioFocus> PARSER = null;
    public static final int UNSOLICITED_FIELD_NUMBER = 3;
    private int audioFocusState_;
    private int bitField0_;
    private int channel_;
    private byte memoizedIsInitialized = 2;
    private boolean unsolicited_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationAudioFocus$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationAudioFocus, Builder> implements GalVerificationAudioFocusOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAudioFocusState() {
            copyOnWrite();
            ((GalVerificationAudioFocus) this.instance).clearAudioFocusState();
            return this;
        }

        public Builder clearChannel() {
            copyOnWrite();
            ((GalVerificationAudioFocus) this.instance).clearChannel();
            return this;
        }

        public Builder clearUnsolicited() {
            copyOnWrite();
            ((GalVerificationAudioFocus) this.instance).clearUnsolicited();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
        public AudioFocusStateType getAudioFocusState() {
            return ((GalVerificationAudioFocus) this.instance).getAudioFocusState();
        }

        @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
        public int getChannel() {
            return ((GalVerificationAudioFocus) this.instance).getChannel();
        }

        @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
        public boolean getUnsolicited() {
            return ((GalVerificationAudioFocus) this.instance).getUnsolicited();
        }

        @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
        public boolean hasAudioFocusState() {
            return ((GalVerificationAudioFocus) this.instance).hasAudioFocusState();
        }

        @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
        public boolean hasChannel() {
            return ((GalVerificationAudioFocus) this.instance).hasChannel();
        }

        @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
        public boolean hasUnsolicited() {
            return ((GalVerificationAudioFocus) this.instance).hasUnsolicited();
        }

        public Builder setAudioFocusState(AudioFocusStateType audioFocusStateType) {
            copyOnWrite();
            ((GalVerificationAudioFocus) this.instance).setAudioFocusState(audioFocusStateType);
            return this;
        }

        public Builder setChannel(int i) {
            copyOnWrite();
            ((GalVerificationAudioFocus) this.instance).setChannel(i);
            return this;
        }

        public Builder setUnsolicited(boolean z6) {
            copyOnWrite();
            ((GalVerificationAudioFocus) this.instance).setUnsolicited(z6);
            return this;
        }

        private Builder() {
            super(GalVerificationAudioFocus.DEFAULT_INSTANCE);
        }
    }

    static {
        GalVerificationAudioFocus galVerificationAudioFocus = new GalVerificationAudioFocus();
        DEFAULT_INSTANCE = galVerificationAudioFocus;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationAudioFocus.class, galVerificationAudioFocus);
    }

    private GalVerificationAudioFocus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioFocusState() {
        this.bitField0_ &= -2;
        this.audioFocusState_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannel() {
        this.bitField0_ &= -3;
        this.channel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnsolicited() {
        this.bitField0_ &= -5;
        this.unsolicited_ = false;
    }

    public static GalVerificationAudioFocus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationAudioFocus parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationAudioFocus parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationAudioFocus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioFocusState(AudioFocusStateType audioFocusStateType) {
        audioFocusStateType.getClass();
        this.bitField0_ |= 1;
        this.audioFocusState_ = audioFocusStateType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannel(int i) {
        this.bitField0_ |= 2;
        this.channel_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnsolicited(boolean z6) {
        this.bitField0_ |= 4;
        this.unsolicited_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationAudioFocus();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001Ԍ\u0000\u0002Ԅ\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "audioFocusState_", AudioFocusStateType.internalGetVerifier(), "channel_", "unsolicited_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationAudioFocus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationAudioFocus.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
    public AudioFocusStateType getAudioFocusState() {
        AudioFocusStateType audioFocusStateTypeForNumber = AudioFocusStateType.forNumber(this.audioFocusState_);
        return audioFocusStateTypeForNumber == null ? AudioFocusStateType.AUDIO_FOCUS_STATE_INVALID : audioFocusStateTypeForNumber;
    }

    @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
    public int getChannel() {
        return this.channel_;
    }

    @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
    public boolean getUnsolicited() {
        return this.unsolicited_;
    }

    @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
    public boolean hasAudioFocusState() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
    public boolean hasChannel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GalVerificationAudioFocusOrBuilder
    public boolean hasUnsolicited() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(GalVerificationAudioFocus galVerificationAudioFocus) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationAudioFocus);
    }

    public static GalVerificationAudioFocus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationAudioFocus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationAudioFocus parseFrom(ByteString byteString) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationAudioFocus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GalVerificationAudioFocus parseFrom(byte[] bArr) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationAudioFocus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationAudioFocus parseFrom(InputStream inputStream) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationAudioFocus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationAudioFocus parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationAudioFocus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationAudioFocus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
