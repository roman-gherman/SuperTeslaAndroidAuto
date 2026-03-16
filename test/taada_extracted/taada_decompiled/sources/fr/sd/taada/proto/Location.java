package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
    private static final Location DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 2;
    public static final int LONGITUDE_FIELD_NUMBER = 1;
    private static volatile Parser<Location> PARSER;
    private int bitField0_;
    private double latitude_;
    private double longitude_;
    private byte memoizedIsInitialized = 2;

    /* JADX INFO: renamed from: fr.sd.taada.proto.Location$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearLatitude() {
            copyOnWrite();
            ((Location) this.instance).clearLatitude();
            return this;
        }

        public Builder clearLongitude() {
            copyOnWrite();
            ((Location) this.instance).clearLongitude();
            return this;
        }

        @Override // fr.sd.taada.proto.LocationOrBuilder
        public double getLatitude() {
            return ((Location) this.instance).getLatitude();
        }

        @Override // fr.sd.taada.proto.LocationOrBuilder
        public double getLongitude() {
            return ((Location) this.instance).getLongitude();
        }

        @Override // fr.sd.taada.proto.LocationOrBuilder
        public boolean hasLatitude() {
            return ((Location) this.instance).hasLatitude();
        }

        @Override // fr.sd.taada.proto.LocationOrBuilder
        public boolean hasLongitude() {
            return ((Location) this.instance).hasLongitude();
        }

        public Builder setLatitude(double d) {
            copyOnWrite();
            ((Location) this.instance).setLatitude(d);
            return this;
        }

        public Builder setLongitude(double d) {
            copyOnWrite();
            ((Location) this.instance).setLongitude(d);
            return this;
        }

        private Builder() {
            super(Location.DEFAULT_INSTANCE);
        }
    }

    static {
        Location location = new Location();
        DEFAULT_INSTANCE = location;
        GeneratedMessageLite.registerDefaultInstance(Location.class, location);
    }

    private Location() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLatitude() {
        this.bitField0_ &= -3;
        this.latitude_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLongitude() {
        this.bitField0_ &= -2;
        this.longitude_ = 0.0d;
    }

    public static Location getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Location parseDelimitedFrom(InputStream inputStream) {
        return (Location) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Location parseFrom(ByteBuffer byteBuffer) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Location> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLatitude(double d) {
        this.bitField0_ |= 2;
        this.latitude_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLongitude(double d) {
        this.bitField0_ |= 1;
        this.longitude_ = d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Location();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԁ\u0000\u0002Ԁ\u0001", new Object[]{"bitField0_", "longitude_", "latitude_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Location> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Location.class) {
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

    @Override // fr.sd.taada.proto.LocationOrBuilder
    public double getLatitude() {
        return this.latitude_;
    }

    @Override // fr.sd.taada.proto.LocationOrBuilder
    public double getLongitude() {
        return this.longitude_;
    }

    @Override // fr.sd.taada.proto.LocationOrBuilder
    public boolean hasLatitude() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.LocationOrBuilder
    public boolean hasLongitude() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Location location) {
        return DEFAULT_INSTANCE.createBuilder(location);
    }

    public static Location parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Location) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Location parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Location parseFrom(ByteString byteString) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Location parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Location parseFrom(byte[] bArr) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Location parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Location parseFrom(InputStream inputStream) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Location parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Location parseFrom(CodedInputStream codedInputStream) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Location parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
