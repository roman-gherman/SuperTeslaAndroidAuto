package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioFocusRequestNotification extends GeneratedMessageLite<AudioFocusRequestNotification, Builder> implements AudioFocusRequestNotificationOrBuilder {
    private static final AudioFocusRequestNotification DEFAULT_INSTANCE;
    private static volatile Parser<AudioFocusRequestNotification> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int request_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.AudioFocusRequestNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AudioFocusRequestNotification, Builder> implements AudioFocusRequestNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRequest() {
            copyOnWrite();
            ((AudioFocusRequestNotification) this.instance).clearRequest();
            return this;
        }

        @Override // fr.sd.taada.proto.AudioFocusRequestNotificationOrBuilder
        public AudioFocusRequestType getRequest() {
            return ((AudioFocusRequestNotification) this.instance).getRequest();
        }

        @Override // fr.sd.taada.proto.AudioFocusRequestNotificationOrBuilder
        public boolean hasRequest() {
            return ((AudioFocusRequestNotification) this.instance).hasRequest();
        }

        public Builder setRequest(AudioFocusRequestType audioFocusRequestType) {
            copyOnWrite();
            ((AudioFocusRequestNotification) this.instance).setRequest(audioFocusRequestType);
            return this;
        }

        private Builder() {
            super(AudioFocusRequestNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        AudioFocusRequestNotification audioFocusRequestNotification = new AudioFocusRequestNotification();
        DEFAULT_INSTANCE = audioFocusRequestNotification;
        GeneratedMessageLite.registerDefaultInstance(AudioFocusRequestNotification.class, audioFocusRequestNotification);
    }

    private AudioFocusRequestNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.bitField0_ &= -2;
        this.request_ = 1;
    }

    public static AudioFocusRequestNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AudioFocusRequestNotification parseDelimitedFrom(InputStream inputStream) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AudioFocusRequestNotification parseFrom(ByteBuffer byteBuffer) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AudioFocusRequestNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequest(AudioFocusRequestType audioFocusRequestType) {
        audioFocusRequestType.getClass();
        this.bitField0_ |= 1;
        this.request_ = audioFocusRequestType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AudioFocusRequestNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "request_", AudioFocusRequestType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AudioFocusRequestNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AudioFocusRequestNotification.class) {
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

    @Override // fr.sd.taada.proto.AudioFocusRequestNotificationOrBuilder
    public AudioFocusRequestType getRequest() {
        AudioFocusRequestType audioFocusRequestTypeForNumber = AudioFocusRequestType.forNumber(this.request_);
        return audioFocusRequestTypeForNumber == null ? AudioFocusRequestType.AUDIO_FOCUS_GAIN : audioFocusRequestTypeForNumber;
    }

    @Override // fr.sd.taada.proto.AudioFocusRequestNotificationOrBuilder
    public boolean hasRequest() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(AudioFocusRequestNotification audioFocusRequestNotification) {
        return DEFAULT_INSTANCE.createBuilder(audioFocusRequestNotification);
    }

    public static AudioFocusRequestNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AudioFocusRequestNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AudioFocusRequestNotification parseFrom(ByteString byteString) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AudioFocusRequestNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AudioFocusRequestNotification parseFrom(byte[] bArr) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AudioFocusRequestNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AudioFocusRequestNotification parseFrom(InputStream inputStream) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AudioFocusRequestNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AudioFocusRequestNotification parseFrom(CodedInputStream codedInputStream) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AudioFocusRequestNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
