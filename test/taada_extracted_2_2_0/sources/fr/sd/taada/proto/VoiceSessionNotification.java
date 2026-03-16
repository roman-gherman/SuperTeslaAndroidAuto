package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class VoiceSessionNotification extends GeneratedMessageLite<VoiceSessionNotification, Builder> implements VoiceSessionNotificationOrBuilder {
    private static final VoiceSessionNotification DEFAULT_INSTANCE;
    private static volatile Parser<VoiceSessionNotification> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.VoiceSessionNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<VoiceSessionNotification, Builder> implements VoiceSessionNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((VoiceSessionNotification) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.VoiceSessionNotificationOrBuilder
        public VoiceSessionStatus getStatus() {
            return ((VoiceSessionNotification) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.VoiceSessionNotificationOrBuilder
        public boolean hasStatus() {
            return ((VoiceSessionNotification) this.instance).hasStatus();
        }

        public Builder setStatus(VoiceSessionStatus voiceSessionStatus) {
            copyOnWrite();
            ((VoiceSessionNotification) this.instance).setStatus(voiceSessionStatus);
            return this;
        }

        private Builder() {
            super(VoiceSessionNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        VoiceSessionNotification voiceSessionNotification = new VoiceSessionNotification();
        DEFAULT_INSTANCE = voiceSessionNotification;
        GeneratedMessageLite.registerDefaultInstance(VoiceSessionNotification.class, voiceSessionNotification);
    }

    private VoiceSessionNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    public static VoiceSessionNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VoiceSessionNotification parseDelimitedFrom(InputStream inputStream) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VoiceSessionNotification parseFrom(ByteBuffer byteBuffer) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VoiceSessionNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(VoiceSessionStatus voiceSessionStatus) {
        voiceSessionStatus.getClass();
        this.bitField0_ |= 1;
        this.status_ = voiceSessionStatus.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new VoiceSessionNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"bitField0_", "status_", VoiceSessionStatus.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VoiceSessionNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VoiceSessionNotification.class) {
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

    @Override // fr.sd.taada.proto.VoiceSessionNotificationOrBuilder
    public VoiceSessionStatus getStatus() {
        VoiceSessionStatus voiceSessionStatusForNumber = VoiceSessionStatus.forNumber(this.status_);
        return voiceSessionStatusForNumber == null ? VoiceSessionStatus.VOICE_SESSION_START : voiceSessionStatusForNumber;
    }

    @Override // fr.sd.taada.proto.VoiceSessionNotificationOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(VoiceSessionNotification voiceSessionNotification) {
        return DEFAULT_INSTANCE.createBuilder(voiceSessionNotification);
    }

    public static VoiceSessionNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VoiceSessionNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VoiceSessionNotification parseFrom(ByteString byteString) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VoiceSessionNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VoiceSessionNotification parseFrom(byte[] bArr) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VoiceSessionNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VoiceSessionNotification parseFrom(InputStream inputStream) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VoiceSessionNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VoiceSessionNotification parseFrom(CodedInputStream codedInputStream) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VoiceSessionNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VoiceSessionNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
