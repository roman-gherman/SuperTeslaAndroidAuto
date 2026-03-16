package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GenericNotificationSubscribe extends GeneratedMessageLite<GenericNotificationSubscribe, Builder> implements GenericNotificationSubscribeOrBuilder {
    private static final GenericNotificationSubscribe DEFAULT_INSTANCE;
    private static volatile Parser<GenericNotificationSubscribe> PARSER;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GenericNotificationSubscribe$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GenericNotificationSubscribe, Builder> implements GenericNotificationSubscribeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(GenericNotificationSubscribe.DEFAULT_INSTANCE);
        }
    }

    static {
        GenericNotificationSubscribe genericNotificationSubscribe = new GenericNotificationSubscribe();
        DEFAULT_INSTANCE = genericNotificationSubscribe;
        GeneratedMessageLite.registerDefaultInstance(GenericNotificationSubscribe.class, genericNotificationSubscribe);
    }

    private GenericNotificationSubscribe() {
    }

    public static GenericNotificationSubscribe getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GenericNotificationSubscribe parseDelimitedFrom(InputStream inputStream) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GenericNotificationSubscribe parseFrom(ByteBuffer byteBuffer) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GenericNotificationSubscribe> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GenericNotificationSubscribe();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GenericNotificationSubscribe> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GenericNotificationSubscribe.class) {
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

    public static Builder newBuilder(GenericNotificationSubscribe genericNotificationSubscribe) {
        return DEFAULT_INSTANCE.createBuilder(genericNotificationSubscribe);
    }

    public static GenericNotificationSubscribe parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GenericNotificationSubscribe parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GenericNotificationSubscribe parseFrom(ByteString byteString) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GenericNotificationSubscribe parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GenericNotificationSubscribe parseFrom(byte[] bArr) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GenericNotificationSubscribe parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GenericNotificationSubscribe parseFrom(InputStream inputStream) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GenericNotificationSubscribe parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GenericNotificationSubscribe parseFrom(CodedInputStream codedInputStream) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GenericNotificationSubscribe parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GenericNotificationSubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
