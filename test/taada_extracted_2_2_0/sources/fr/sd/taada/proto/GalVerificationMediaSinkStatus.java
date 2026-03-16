package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.Config;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationMediaSinkStatus extends GeneratedMessageLite<GalVerificationMediaSinkStatus, Builder> implements GalVerificationMediaSinkStatusOrBuilder {
    public static final int CHANNEL_FIELD_NUMBER = 1;
    private static final GalVerificationMediaSinkStatus DEFAULT_INSTANCE;
    private static volatile Parser<GalVerificationMediaSinkStatus> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private int bitField0_;
    private int channel_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationMediaSinkStatus$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationMediaSinkStatus, Builder> implements GalVerificationMediaSinkStatusOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearChannel() {
            copyOnWrite();
            ((GalVerificationMediaSinkStatus) this.instance).clearChannel();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((GalVerificationMediaSinkStatus) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
        public int getChannel() {
            return ((GalVerificationMediaSinkStatus) this.instance).getChannel();
        }

        @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
        public Config.Status getStatus() {
            return ((GalVerificationMediaSinkStatus) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
        public boolean hasChannel() {
            return ((GalVerificationMediaSinkStatus) this.instance).hasChannel();
        }

        @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
        public boolean hasStatus() {
            return ((GalVerificationMediaSinkStatus) this.instance).hasStatus();
        }

        public Builder setChannel(int i) {
            copyOnWrite();
            ((GalVerificationMediaSinkStatus) this.instance).setChannel(i);
            return this;
        }

        public Builder setStatus(Config.Status status) {
            copyOnWrite();
            ((GalVerificationMediaSinkStatus) this.instance).setStatus(status);
            return this;
        }

        private Builder() {
            super(GalVerificationMediaSinkStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        GalVerificationMediaSinkStatus galVerificationMediaSinkStatus = new GalVerificationMediaSinkStatus();
        DEFAULT_INSTANCE = galVerificationMediaSinkStatus;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationMediaSinkStatus.class, galVerificationMediaSinkStatus);
    }

    private GalVerificationMediaSinkStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannel() {
        this.bitField0_ &= -2;
        this.channel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -3;
        this.status_ = 1;
    }

    public static GalVerificationMediaSinkStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationMediaSinkStatus parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationMediaSinkStatus parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationMediaSinkStatus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannel(int i) {
        this.bitField0_ |= 1;
        this.channel_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(Config.Status status) {
        status.getClass();
        this.bitField0_ |= 2;
        this.status_ = status.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationMediaSinkStatus();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԍ\u0001", new Object[]{"bitField0_", "channel_", "status_", Config.Status.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationMediaSinkStatus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationMediaSinkStatus.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
    public int getChannel() {
        return this.channel_;
    }

    @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
    public Config.Status getStatus() {
        Config.Status statusForNumber = Config.Status.forNumber(this.status_);
        return statusForNumber == null ? Config.Status.STATUS_WAIT : statusForNumber;
    }

    @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
    public boolean hasChannel() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.GalVerificationMediaSinkStatusOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(GalVerificationMediaSinkStatus galVerificationMediaSinkStatus) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationMediaSinkStatus);
    }

    public static GalVerificationMediaSinkStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationMediaSinkStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationMediaSinkStatus parseFrom(ByteString byteString) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationMediaSinkStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GalVerificationMediaSinkStatus parseFrom(byte[] bArr) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationMediaSinkStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationMediaSinkStatus parseFrom(InputStream inputStream) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationMediaSinkStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationMediaSinkStatus parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationMediaSinkStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationMediaSinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
