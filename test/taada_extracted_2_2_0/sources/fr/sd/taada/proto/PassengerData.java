package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class PassengerData extends GeneratedMessageLite<PassengerData, Builder> implements PassengerDataOrBuilder {
    private static final PassengerData DEFAULT_INSTANCE;
    private static volatile Parser<PassengerData> PARSER = null;
    public static final int PASSENGER_PRESENT_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean passengerPresent_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.PassengerData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PassengerData, Builder> implements PassengerDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearPassengerPresent() {
            copyOnWrite();
            ((PassengerData) this.instance).clearPassengerPresent();
            return this;
        }

        @Override // fr.sd.taada.proto.PassengerDataOrBuilder
        public boolean getPassengerPresent() {
            return ((PassengerData) this.instance).getPassengerPresent();
        }

        @Override // fr.sd.taada.proto.PassengerDataOrBuilder
        public boolean hasPassengerPresent() {
            return ((PassengerData) this.instance).hasPassengerPresent();
        }

        public Builder setPassengerPresent(boolean z6) {
            copyOnWrite();
            ((PassengerData) this.instance).setPassengerPresent(z6);
            return this;
        }

        private Builder() {
            super(PassengerData.DEFAULT_INSTANCE);
        }
    }

    static {
        PassengerData passengerData = new PassengerData();
        DEFAULT_INSTANCE = passengerData;
        GeneratedMessageLite.registerDefaultInstance(PassengerData.class, passengerData);
    }

    private PassengerData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPassengerPresent() {
        this.bitField0_ &= -2;
        this.passengerPresent_ = false;
    }

    public static PassengerData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PassengerData parseDelimitedFrom(InputStream inputStream) {
        return (PassengerData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassengerData parseFrom(ByteBuffer byteBuffer) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PassengerData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPassengerPresent(boolean z6) {
        this.bitField0_ |= 1;
        this.passengerPresent_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PassengerData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007\u0000", new Object[]{"bitField0_", "passengerPresent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PassengerData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PassengerData.class) {
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

    @Override // fr.sd.taada.proto.PassengerDataOrBuilder
    public boolean getPassengerPresent() {
        return this.passengerPresent_;
    }

    @Override // fr.sd.taada.proto.PassengerDataOrBuilder
    public boolean hasPassengerPresent() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(PassengerData passengerData) {
        return DEFAULT_INSTANCE.createBuilder(passengerData);
    }

    public static PassengerData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PassengerData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PassengerData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PassengerData parseFrom(ByteString byteString) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PassengerData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PassengerData parseFrom(byte[] bArr) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassengerData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PassengerData parseFrom(InputStream inputStream) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassengerData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PassengerData parseFrom(CodedInputStream codedInputStream) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PassengerData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PassengerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
