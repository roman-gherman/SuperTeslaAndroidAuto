package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class VersionRequestOptions extends GeneratedMessageLite<VersionRequestOptions, Builder> implements VersionRequestOptionsOrBuilder {
    private static final VersionRequestOptions DEFAULT_INSTANCE;
    private static volatile Parser<VersionRequestOptions> PARSER = null;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 1;
    private int bitField0_;
    private long snapshotVersion_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.VersionRequestOptions$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<VersionRequestOptions, Builder> implements VersionRequestOptionsOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearSnapshotVersion() {
            copyOnWrite();
            ((VersionRequestOptions) this.instance).clearSnapshotVersion();
            return this;
        }

        @Override // fr.sd.taada.proto.VersionRequestOptionsOrBuilder
        public long getSnapshotVersion() {
            return ((VersionRequestOptions) this.instance).getSnapshotVersion();
        }

        @Override // fr.sd.taada.proto.VersionRequestOptionsOrBuilder
        public boolean hasSnapshotVersion() {
            return ((VersionRequestOptions) this.instance).hasSnapshotVersion();
        }

        public Builder setSnapshotVersion(long j6) {
            copyOnWrite();
            ((VersionRequestOptions) this.instance).setSnapshotVersion(j6);
            return this;
        }

        private Builder() {
            super(VersionRequestOptions.DEFAULT_INSTANCE);
        }
    }

    static {
        VersionRequestOptions versionRequestOptions = new VersionRequestOptions();
        DEFAULT_INSTANCE = versionRequestOptions;
        GeneratedMessageLite.registerDefaultInstance(VersionRequestOptions.class, versionRequestOptions);
    }

    private VersionRequestOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSnapshotVersion() {
        this.bitField0_ &= -2;
        this.snapshotVersion_ = 0L;
    }

    public static VersionRequestOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VersionRequestOptions parseDelimitedFrom(InputStream inputStream) {
        return (VersionRequestOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VersionRequestOptions parseFrom(ByteBuffer byteBuffer) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VersionRequestOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSnapshotVersion(long j6) {
        this.bitField0_ |= 1;
        this.snapshotVersion_ = j6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new VersionRequestOptions();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002\u0000", new Object[]{"bitField0_", "snapshotVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VersionRequestOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VersionRequestOptions.class) {
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

    @Override // fr.sd.taada.proto.VersionRequestOptionsOrBuilder
    public long getSnapshotVersion() {
        return this.snapshotVersion_;
    }

    @Override // fr.sd.taada.proto.VersionRequestOptionsOrBuilder
    public boolean hasSnapshotVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(VersionRequestOptions versionRequestOptions) {
        return DEFAULT_INSTANCE.createBuilder(versionRequestOptions);
    }

    public static VersionRequestOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionRequestOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VersionRequestOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VersionRequestOptions parseFrom(ByteString byteString) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VersionRequestOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VersionRequestOptions parseFrom(byte[] bArr) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VersionRequestOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VersionRequestOptions parseFrom(InputStream inputStream) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VersionRequestOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VersionRequestOptions parseFrom(CodedInputStream codedInputStream) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VersionRequestOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionRequestOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
