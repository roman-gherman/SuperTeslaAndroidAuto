package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioFocusNotification extends GeneratedMessageLite<AudioFocusNotification, Builder> implements AudioFocusNotificationOrBuilder {
    private static final AudioFocusNotification DEFAULT_INSTANCE;
    public static final int FOCUS_STATE_FIELD_NUMBER = 1;
    private static volatile Parser<AudioFocusNotification> PARSER = null;
    public static final int UNSOLICITED_FIELD_NUMBER = 2;
    private int bitField0_;
    private int focusState_;
    private byte memoizedIsInitialized = 2;
    private boolean unsolicited_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.AudioFocusNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AudioFocusNotification, Builder> implements AudioFocusNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFocusState() {
            copyOnWrite();
            ((AudioFocusNotification) this.instance).clearFocusState();
            return this;
        }

        public Builder clearUnsolicited() {
            copyOnWrite();
            ((AudioFocusNotification) this.instance).clearUnsolicited();
            return this;
        }

        @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
        public AudioFocusStateType getFocusState() {
            return ((AudioFocusNotification) this.instance).getFocusState();
        }

        @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
        public boolean getUnsolicited() {
            return ((AudioFocusNotification) this.instance).getUnsolicited();
        }

        @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
        public boolean hasFocusState() {
            return ((AudioFocusNotification) this.instance).hasFocusState();
        }

        @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
        public boolean hasUnsolicited() {
            return ((AudioFocusNotification) this.instance).hasUnsolicited();
        }

        public Builder setFocusState(AudioFocusStateType audioFocusStateType) {
            copyOnWrite();
            ((AudioFocusNotification) this.instance).setFocusState(audioFocusStateType);
            return this;
        }

        public Builder setUnsolicited(boolean z6) {
            copyOnWrite();
            ((AudioFocusNotification) this.instance).setUnsolicited(z6);
            return this;
        }

        private Builder() {
            super(AudioFocusNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        AudioFocusNotification audioFocusNotification = new AudioFocusNotification();
        DEFAULT_INSTANCE = audioFocusNotification;
        GeneratedMessageLite.registerDefaultInstance(AudioFocusNotification.class, audioFocusNotification);
    }

    private AudioFocusNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFocusState() {
        this.bitField0_ &= -2;
        this.focusState_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnsolicited() {
        this.bitField0_ &= -3;
        this.unsolicited_ = false;
    }

    public static AudioFocusNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AudioFocusNotification parseDelimitedFrom(InputStream inputStream) {
        return (AudioFocusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AudioFocusNotification parseFrom(ByteBuffer byteBuffer) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AudioFocusNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusState(AudioFocusStateType audioFocusStateType) {
        audioFocusStateType.getClass();
        this.bitField0_ |= 1;
        this.focusState_ = audioFocusStateType.getNumber();
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
                return new AudioFocusNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\u0007\u0001", new Object[]{"bitField0_", "focusState_", AudioFocusStateType.internalGetVerifier(), "unsolicited_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AudioFocusNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AudioFocusNotification.class) {
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

    @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
    public AudioFocusStateType getFocusState() {
        AudioFocusStateType audioFocusStateTypeForNumber = AudioFocusStateType.forNumber(this.focusState_);
        return audioFocusStateTypeForNumber == null ? AudioFocusStateType.AUDIO_FOCUS_STATE_INVALID : audioFocusStateTypeForNumber;
    }

    @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
    public boolean getUnsolicited() {
        return this.unsolicited_;
    }

    @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
    public boolean hasFocusState() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.AudioFocusNotificationOrBuilder
    public boolean hasUnsolicited() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(AudioFocusNotification audioFocusNotification) {
        return DEFAULT_INSTANCE.createBuilder(audioFocusNotification);
    }

    public static AudioFocusNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AudioFocusNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AudioFocusNotification parseFrom(ByteString byteString) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AudioFocusNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AudioFocusNotification parseFrom(byte[] bArr) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AudioFocusNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AudioFocusNotification parseFrom(InputStream inputStream) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AudioFocusNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AudioFocusNotification parseFrom(CodedInputStream codedInputStream) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AudioFocusNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
