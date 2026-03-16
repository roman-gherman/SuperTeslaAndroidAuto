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
@Deprecated
public final class NavigationNextTurnDistanceEvent extends GeneratedMessageLite<NavigationNextTurnDistanceEvent, Builder> implements NavigationNextTurnDistanceEventOrBuilder {
    private static final NavigationNextTurnDistanceEvent DEFAULT_INSTANCE;
    public static final int DISPLAY_DISTANCE_E3_FIELD_NUMBER = 3;
    public static final int DISPLAY_DISTANCE_UNIT_FIELD_NUMBER = 4;
    public static final int DISTANCE_METERS_FIELD_NUMBER = 1;
    private static volatile Parser<NavigationNextTurnDistanceEvent> PARSER = null;
    public static final int TIME_TO_TURN_SECONDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private int displayDistanceE3_;
    private int displayDistanceUnit_;
    private int distanceMeters_;
    private byte memoizedIsInitialized = 2;
    private int timeToTurnSeconds_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationNextTurnDistanceEvent$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationNextTurnDistanceEvent, Builder> implements NavigationNextTurnDistanceEventOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDisplayDistanceE3() {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).clearDisplayDistanceE3();
            return this;
        }

        public Builder clearDisplayDistanceUnit() {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).clearDisplayDistanceUnit();
            return this;
        }

        public Builder clearDistanceMeters() {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).clearDistanceMeters();
            return this;
        }

        public Builder clearTimeToTurnSeconds() {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).clearTimeToTurnSeconds();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public int getDisplayDistanceE3() {
            return ((NavigationNextTurnDistanceEvent) this.instance).getDisplayDistanceE3();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public DistanceUnits getDisplayDistanceUnit() {
            return ((NavigationNextTurnDistanceEvent) this.instance).getDisplayDistanceUnit();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public int getDistanceMeters() {
            return ((NavigationNextTurnDistanceEvent) this.instance).getDistanceMeters();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public int getTimeToTurnSeconds() {
            return ((NavigationNextTurnDistanceEvent) this.instance).getTimeToTurnSeconds();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public boolean hasDisplayDistanceE3() {
            return ((NavigationNextTurnDistanceEvent) this.instance).hasDisplayDistanceE3();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public boolean hasDisplayDistanceUnit() {
            return ((NavigationNextTurnDistanceEvent) this.instance).hasDisplayDistanceUnit();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public boolean hasDistanceMeters() {
            return ((NavigationNextTurnDistanceEvent) this.instance).hasDistanceMeters();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
        public boolean hasTimeToTurnSeconds() {
            return ((NavigationNextTurnDistanceEvent) this.instance).hasTimeToTurnSeconds();
        }

        public Builder setDisplayDistanceE3(int i) {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).setDisplayDistanceE3(i);
            return this;
        }

        public Builder setDisplayDistanceUnit(DistanceUnits distanceUnits) {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).setDisplayDistanceUnit(distanceUnits);
            return this;
        }

        public Builder setDistanceMeters(int i) {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).setDistanceMeters(i);
            return this;
        }

        public Builder setTimeToTurnSeconds(int i) {
            copyOnWrite();
            ((NavigationNextTurnDistanceEvent) this.instance).setTimeToTurnSeconds(i);
            return this;
        }

        private Builder() {
            super(NavigationNextTurnDistanceEvent.DEFAULT_INSTANCE);
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
        private static final Internal.EnumLiteMap<DistanceUnits> internalValueMap = new Internal.EnumLiteMap<DistanceUnits>() { // from class: fr.sd.taada.proto.NavigationNextTurnDistanceEvent.DistanceUnits.1
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
        NavigationNextTurnDistanceEvent navigationNextTurnDistanceEvent = new NavigationNextTurnDistanceEvent();
        DEFAULT_INSTANCE = navigationNextTurnDistanceEvent;
        GeneratedMessageLite.registerDefaultInstance(NavigationNextTurnDistanceEvent.class, navigationNextTurnDistanceEvent);
    }

    private NavigationNextTurnDistanceEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayDistanceE3() {
        this.bitField0_ &= -5;
        this.displayDistanceE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayDistanceUnit() {
        this.bitField0_ &= -9;
        this.displayDistanceUnit_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDistanceMeters() {
        this.bitField0_ &= -2;
        this.distanceMeters_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeToTurnSeconds() {
        this.bitField0_ &= -3;
        this.timeToTurnSeconds_ = 0;
    }

    public static NavigationNextTurnDistanceEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationNextTurnDistanceEvent parseDelimitedFrom(InputStream inputStream) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(ByteBuffer byteBuffer) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationNextTurnDistanceEvent> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayDistanceE3(int i) {
        this.bitField0_ |= 4;
        this.displayDistanceE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayDistanceUnit(DistanceUnits distanceUnits) {
        distanceUnits.getClass();
        this.bitField0_ |= 8;
        this.displayDistanceUnit_ = distanceUnits.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDistanceMeters(int i) {
        this.bitField0_ |= 1;
        this.distanceMeters_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeToTurnSeconds(int i) {
        this.bitField0_ |= 2;
        this.timeToTurnSeconds_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationNextTurnDistanceEvent();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001\u0003\u0004\u0002\u0004\f\u0003", new Object[]{"bitField0_", "distanceMeters_", "timeToTurnSeconds_", "displayDistanceE3_", "displayDistanceUnit_", DistanceUnits.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationNextTurnDistanceEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationNextTurnDistanceEvent.class) {
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

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public int getDisplayDistanceE3() {
        return this.displayDistanceE3_;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public DistanceUnits getDisplayDistanceUnit() {
        DistanceUnits distanceUnitsForNumber = DistanceUnits.forNumber(this.displayDistanceUnit_);
        return distanceUnitsForNumber == null ? DistanceUnits.UNKNOWN_DISTANCE_UNIT : distanceUnitsForNumber;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public int getDistanceMeters() {
        return this.distanceMeters_;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public int getTimeToTurnSeconds() {
        return this.timeToTurnSeconds_;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public boolean hasDisplayDistanceE3() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public boolean hasDisplayDistanceUnit() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public boolean hasDistanceMeters() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnDistanceEventOrBuilder
    public boolean hasTimeToTurnSeconds() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(NavigationNextTurnDistanceEvent navigationNextTurnDistanceEvent) {
        return DEFAULT_INSTANCE.createBuilder(navigationNextTurnDistanceEvent);
    }

    public static NavigationNextTurnDistanceEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(ByteString byteString) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(byte[] bArr) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(InputStream inputStream) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(CodedInputStream codedInputStream) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationNextTurnDistanceEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnDistanceEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
