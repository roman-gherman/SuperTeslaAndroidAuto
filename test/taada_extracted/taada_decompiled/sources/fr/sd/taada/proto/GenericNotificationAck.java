package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GenericNotificationAck extends GeneratedMessageLite<GenericNotificationAck, Builder> implements GenericNotificationAckOrBuilder {
    private static final GenericNotificationAck DEFAULT_INSTANCE;
    public static final int HANDLED_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<GenericNotificationAck> PARSER;
    private int bitField0_;
    private boolean handled_;
    private String id_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.GenericNotificationAck$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GenericNotificationAck, Builder> implements GenericNotificationAckOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearHandled() {
            copyOnWrite();
            ((GenericNotificationAck) this.instance).clearHandled();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((GenericNotificationAck) this.instance).clearId();
            return this;
        }

        @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
        public boolean getHandled() {
            return ((GenericNotificationAck) this.instance).getHandled();
        }

        @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
        public String getId() {
            return ((GenericNotificationAck) this.instance).getId();
        }

        @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
        public ByteString getIdBytes() {
            return ((GenericNotificationAck) this.instance).getIdBytes();
        }

        @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
        public boolean hasHandled() {
            return ((GenericNotificationAck) this.instance).hasHandled();
        }

        @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
        public boolean hasId() {
            return ((GenericNotificationAck) this.instance).hasId();
        }

        public Builder setHandled(boolean z6) {
            copyOnWrite();
            ((GenericNotificationAck) this.instance).setHandled(z6);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((GenericNotificationAck) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            copyOnWrite();
            ((GenericNotificationAck) this.instance).setIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(GenericNotificationAck.DEFAULT_INSTANCE);
        }
    }

    static {
        GenericNotificationAck genericNotificationAck = new GenericNotificationAck();
        DEFAULT_INSTANCE = genericNotificationAck;
        GeneratedMessageLite.registerDefaultInstance(GenericNotificationAck.class, genericNotificationAck);
    }

    private GenericNotificationAck() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHandled() {
        this.bitField0_ &= -3;
        this.handled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.bitField0_ &= -2;
        this.id_ = getDefaultInstance().getId();
    }

    public static GenericNotificationAck getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GenericNotificationAck parseDelimitedFrom(InputStream inputStream) {
        return (GenericNotificationAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GenericNotificationAck parseFrom(ByteBuffer byteBuffer) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GenericNotificationAck> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandled(boolean z6) {
        this.bitField0_ |= 2;
        this.handled_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.id_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GenericNotificationAck();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001", new Object[]{"bitField0_", "id_", "handled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GenericNotificationAck> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GenericNotificationAck.class) {
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

    @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
    public boolean getHandled() {
        return this.handled_;
    }

    @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
    public boolean hasHandled() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GenericNotificationAckOrBuilder
    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GenericNotificationAck genericNotificationAck) {
        return DEFAULT_INSTANCE.createBuilder(genericNotificationAck);
    }

    public static GenericNotificationAck parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GenericNotificationAck parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GenericNotificationAck parseFrom(ByteString byteString) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GenericNotificationAck parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GenericNotificationAck parseFrom(byte[] bArr) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GenericNotificationAck parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GenericNotificationAck parseFrom(InputStream inputStream) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GenericNotificationAck parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GenericNotificationAck parseFrom(CodedInputStream codedInputStream) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GenericNotificationAck parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
