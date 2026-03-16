package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationRoad extends GeneratedMessageLite<NavigationRoad, Builder> implements NavigationRoadOrBuilder {
    private static final NavigationRoad DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<NavigationRoad> PARSER;
    private int bitField0_;
    private String name_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationRoad$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationRoad, Builder> implements NavigationRoadOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearName() {
            copyOnWrite();
            ((NavigationRoad) this.instance).clearName();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationRoadOrBuilder
        public String getName() {
            return ((NavigationRoad) this.instance).getName();
        }

        @Override // fr.sd.taada.proto.NavigationRoadOrBuilder
        public ByteString getNameBytes() {
            return ((NavigationRoad) this.instance).getNameBytes();
        }

        @Override // fr.sd.taada.proto.NavigationRoadOrBuilder
        public boolean hasName() {
            return ((NavigationRoad) this.instance).hasName();
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((NavigationRoad) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((NavigationRoad) this.instance).setNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(NavigationRoad.DEFAULT_INSTANCE);
        }
    }

    static {
        NavigationRoad navigationRoad = new NavigationRoad();
        DEFAULT_INSTANCE = navigationRoad;
        GeneratedMessageLite.registerDefaultInstance(NavigationRoad.class, navigationRoad);
    }

    private NavigationRoad() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    public static NavigationRoad getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationRoad parseDelimitedFrom(InputStream inputStream) {
        return (NavigationRoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationRoad parseFrom(ByteBuffer byteBuffer) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationRoad> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.name_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationRoad();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationRoad> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationRoad.class) {
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

    @Override // fr.sd.taada.proto.NavigationRoadOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // fr.sd.taada.proto.NavigationRoadOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // fr.sd.taada.proto.NavigationRoadOrBuilder
    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavigationRoad navigationRoad) {
        return DEFAULT_INSTANCE.createBuilder(navigationRoad);
    }

    public static NavigationRoad parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationRoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationRoad parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationRoad parseFrom(ByteString byteString) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationRoad parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationRoad parseFrom(byte[] bArr) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationRoad parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationRoad parseFrom(InputStream inputStream) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationRoad parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationRoad parseFrom(CodedInputStream codedInputStream) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationRoad parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationRoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
