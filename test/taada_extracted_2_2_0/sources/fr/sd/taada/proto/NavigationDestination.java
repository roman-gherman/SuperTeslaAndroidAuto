package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationDestination extends GeneratedMessageLite<NavigationDestination, Builder> implements NavigationDestinationOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 1;
    private static final NavigationDestination DEFAULT_INSTANCE;
    private static volatile Parser<NavigationDestination> PARSER;
    private String address_ = "";
    private int bitField0_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationDestination$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationDestination, Builder> implements NavigationDestinationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAddress() {
            copyOnWrite();
            ((NavigationDestination) this.instance).clearAddress();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationDestinationOrBuilder
        public String getAddress() {
            return ((NavigationDestination) this.instance).getAddress();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationOrBuilder
        public ByteString getAddressBytes() {
            return ((NavigationDestination) this.instance).getAddressBytes();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationOrBuilder
        public boolean hasAddress() {
            return ((NavigationDestination) this.instance).hasAddress();
        }

        public Builder setAddress(String str) {
            copyOnWrite();
            ((NavigationDestination) this.instance).setAddress(str);
            return this;
        }

        public Builder setAddressBytes(ByteString byteString) {
            copyOnWrite();
            ((NavigationDestination) this.instance).setAddressBytes(byteString);
            return this;
        }

        private Builder() {
            super(NavigationDestination.DEFAULT_INSTANCE);
        }
    }

    static {
        NavigationDestination navigationDestination = new NavigationDestination();
        DEFAULT_INSTANCE = navigationDestination;
        GeneratedMessageLite.registerDefaultInstance(NavigationDestination.class, navigationDestination);
    }

    private NavigationDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddress() {
        this.bitField0_ &= -2;
        this.address_ = getDefaultInstance().getAddress();
    }

    public static NavigationDestination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationDestination parseDelimitedFrom(InputStream inputStream) {
        return (NavigationDestination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationDestination parseFrom(ByteBuffer byteBuffer) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationDestination> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddress(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.address_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.address_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationDestination();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "address_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationDestination> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationDestination.class) {
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

    @Override // fr.sd.taada.proto.NavigationDestinationOrBuilder
    public String getAddress() {
        return this.address_;
    }

    @Override // fr.sd.taada.proto.NavigationDestinationOrBuilder
    public ByteString getAddressBytes() {
        return ByteString.copyFromUtf8(this.address_);
    }

    @Override // fr.sd.taada.proto.NavigationDestinationOrBuilder
    public boolean hasAddress() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavigationDestination navigationDestination) {
        return DEFAULT_INSTANCE.createBuilder(navigationDestination);
    }

    public static NavigationDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationDestination parseFrom(ByteString byteString) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationDestination parseFrom(byte[] bArr) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationDestination parseFrom(InputStream inputStream) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationDestination parseFrom(CodedInputStream codedInputStream) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
