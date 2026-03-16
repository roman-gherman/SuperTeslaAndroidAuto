package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationDistance extends GeneratedMessageLite<NavigationDistance, Builder> implements NavigationDistanceOrBuilder {
    private static final NavigationDistance DEFAULT_INSTANCE;
    public static final int DISPLAY_UNITS_FIELD_NUMBER = 3;
    public static final int DISPLAY_VALUE_FIELD_NUMBER = 2;
    public static final int METERS_FIELD_NUMBER = 1;
    private static volatile Parser<NavigationDistance> PARSER;
    private int bitField0_;
    private int displayUnits_;
    private String displayValue_ = "";
    private int meters_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationDistance$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationDistance, Builder> implements NavigationDistanceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDisplayUnits() {
            copyOnWrite();
            ((NavigationDistance) this.instance).clearDisplayUnits();
            return this;
        }

        public Builder clearDisplayValue() {
            copyOnWrite();
            ((NavigationDistance) this.instance).clearDisplayValue();
            return this;
        }

        public Builder clearMeters() {
            copyOnWrite();
            ((NavigationDistance) this.instance).clearMeters();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
        public DistanceUnits getDisplayUnits() {
            return ((NavigationDistance) this.instance).getDisplayUnits();
        }

        @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
        public String getDisplayValue() {
            return ((NavigationDistance) this.instance).getDisplayValue();
        }

        @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
        public ByteString getDisplayValueBytes() {
            return ((NavigationDistance) this.instance).getDisplayValueBytes();
        }

        @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
        public int getMeters() {
            return ((NavigationDistance) this.instance).getMeters();
        }

        @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
        public boolean hasDisplayUnits() {
            return ((NavigationDistance) this.instance).hasDisplayUnits();
        }

        @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
        public boolean hasDisplayValue() {
            return ((NavigationDistance) this.instance).hasDisplayValue();
        }

        @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
        public boolean hasMeters() {
            return ((NavigationDistance) this.instance).hasMeters();
        }

        public Builder setDisplayUnits(DistanceUnits distanceUnits) {
            copyOnWrite();
            ((NavigationDistance) this.instance).setDisplayUnits(distanceUnits);
            return this;
        }

        public Builder setDisplayValue(String str) {
            copyOnWrite();
            ((NavigationDistance) this.instance).setDisplayValue(str);
            return this;
        }

        public Builder setDisplayValueBytes(ByteString byteString) {
            copyOnWrite();
            ((NavigationDistance) this.instance).setDisplayValueBytes(byteString);
            return this;
        }

        public Builder setMeters(int i) {
            copyOnWrite();
            ((NavigationDistance) this.instance).setMeters(i);
            return this;
        }

        private Builder() {
            super(NavigationDistance.DEFAULT_INSTANCE);
        }
    }

    public enum DistanceUnits implements Internal.EnumLite {
        UNKNOWN_DISTANCE_UNIT(0),
        METERS(1),
        KILOMETERS(2),
        KILOMETERS_P1(3),
        MILES(4),
        MILES_P1(5),
        FEET(6),
        YARDS(7);

        public static final int FEET_VALUE = 6;
        public static final int KILOMETERS_P1_VALUE = 3;
        public static final int KILOMETERS_VALUE = 2;
        public static final int METERS_VALUE = 1;
        public static final int MILES_P1_VALUE = 5;
        public static final int MILES_VALUE = 4;
        public static final int UNKNOWN_DISTANCE_UNIT_VALUE = 0;
        public static final int YARDS_VALUE = 7;
        private static final Internal.EnumLiteMap<DistanceUnits> internalValueMap = new Internal.EnumLiteMap<DistanceUnits>() { // from class: fr.sd.taada.proto.NavigationDistance.DistanceUnits.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public DistanceUnits findValueByNumber(int i) {
                return DistanceUnits.forNumber(i);
            }
        };
        private final int value;

        public static final class DistanceUnitsVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new DistanceUnitsVerifier();

            private DistanceUnitsVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return DistanceUnits.forNumber(i) != null;
            }
        }

        DistanceUnits(int i) {
            this.value = i;
        }

        public static DistanceUnits forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_DISTANCE_UNIT;
                case 1:
                    return METERS;
                case 2:
                    return KILOMETERS;
                case 3:
                    return KILOMETERS_P1;
                case 4:
                    return MILES;
                case 5:
                    return MILES_P1;
                case 6:
                    return FEET;
                case 7:
                    return YARDS;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<DistanceUnits> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DistanceUnitsVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DistanceUnits valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NavigationDistance navigationDistance = new NavigationDistance();
        DEFAULT_INSTANCE = navigationDistance;
        GeneratedMessageLite.registerDefaultInstance(NavigationDistance.class, navigationDistance);
    }

    private NavigationDistance() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayUnits() {
        this.bitField0_ &= -5;
        this.displayUnits_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayValue() {
        this.bitField0_ &= -3;
        this.displayValue_ = getDefaultInstance().getDisplayValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMeters() {
        this.bitField0_ &= -2;
        this.meters_ = 0;
    }

    public static NavigationDistance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationDistance parseDelimitedFrom(InputStream inputStream) {
        return (NavigationDistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationDistance parseFrom(ByteBuffer byteBuffer) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationDistance> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayUnits(DistanceUnits distanceUnits) {
        distanceUnits.getClass();
        this.bitField0_ |= 4;
        this.displayUnits_ = distanceUnits.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayValue(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.displayValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayValueBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.displayValue_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMeters(int i) {
        this.bitField0_ |= 1;
        this.meters_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationDistance();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\f\u0002", new Object[]{"bitField0_", "meters_", "displayValue_", "displayUnits_", DistanceUnits.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationDistance> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationDistance.class) {
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

    @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
    public DistanceUnits getDisplayUnits() {
        DistanceUnits distanceUnitsForNumber = DistanceUnits.forNumber(this.displayUnits_);
        return distanceUnitsForNumber == null ? DistanceUnits.UNKNOWN_DISTANCE_UNIT : distanceUnitsForNumber;
    }

    @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
    public String getDisplayValue() {
        return this.displayValue_;
    }

    @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
    public ByteString getDisplayValueBytes() {
        return ByteString.copyFromUtf8(this.displayValue_);
    }

    @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
    public int getMeters() {
        return this.meters_;
    }

    @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
    public boolean hasDisplayUnits() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
    public boolean hasDisplayValue() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationDistanceOrBuilder
    public boolean hasMeters() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavigationDistance navigationDistance) {
        return DEFAULT_INSTANCE.createBuilder(navigationDistance);
    }

    public static NavigationDistance parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationDistance parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationDistance parseFrom(ByteString byteString) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationDistance parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationDistance parseFrom(byte[] bArr) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationDistance parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationDistance parseFrom(InputStream inputStream) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationDistance parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationDistance parseFrom(CodedInputStream codedInputStream) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationDistance parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
