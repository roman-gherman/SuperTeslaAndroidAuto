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
public final class NavigationNextTurnEvent extends GeneratedMessageLite<NavigationNextTurnEvent, Builder> implements NavigationNextTurnEventOrBuilder {
    private static final NavigationNextTurnEvent DEFAULT_INSTANCE;
    public static final int EVENT_FIELD_NUMBER = 3;
    public static final int IMAGE_FIELD_NUMBER = 4;
    private static volatile Parser<NavigationNextTurnEvent> PARSER = null;
    public static final int ROAD_FIELD_NUMBER = 1;
    public static final int TURN_ANGLE_FIELD_NUMBER = 6;
    public static final int TURN_NUMBER_FIELD_NUMBER = 5;
    public static final int TURN_SIDE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int event_;
    private int turnAngle_;
    private int turnNumber_;
    private byte memoizedIsInitialized = 2;
    private String road_ = "";
    private int turnSide_ = 1;
    private ByteString image_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationNextTurnEvent$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationNextTurnEvent, Builder> implements NavigationNextTurnEventOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearEvent() {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).clearEvent();
            return this;
        }

        public Builder clearImage() {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).clearImage();
            return this;
        }

        public Builder clearRoad() {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).clearRoad();
            return this;
        }

        public Builder clearTurnAngle() {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).clearTurnAngle();
            return this;
        }

        public Builder clearTurnNumber() {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).clearTurnNumber();
            return this;
        }

        public Builder clearTurnSide() {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).clearTurnSide();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public NextTurnEnum getEvent() {
            return ((NavigationNextTurnEvent) this.instance).getEvent();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public ByteString getImage() {
            return ((NavigationNextTurnEvent) this.instance).getImage();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public String getRoad() {
            return ((NavigationNextTurnEvent) this.instance).getRoad();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public ByteString getRoadBytes() {
            return ((NavigationNextTurnEvent) this.instance).getRoadBytes();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public int getTurnAngle() {
            return ((NavigationNextTurnEvent) this.instance).getTurnAngle();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public int getTurnNumber() {
            return ((NavigationNextTurnEvent) this.instance).getTurnNumber();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public TurnSide getTurnSide() {
            return ((NavigationNextTurnEvent) this.instance).getTurnSide();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public boolean hasEvent() {
            return ((NavigationNextTurnEvent) this.instance).hasEvent();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public boolean hasImage() {
            return ((NavigationNextTurnEvent) this.instance).hasImage();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public boolean hasRoad() {
            return ((NavigationNextTurnEvent) this.instance).hasRoad();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public boolean hasTurnAngle() {
            return ((NavigationNextTurnEvent) this.instance).hasTurnAngle();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public boolean hasTurnNumber() {
            return ((NavigationNextTurnEvent) this.instance).hasTurnNumber();
        }

        @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
        public boolean hasTurnSide() {
            return ((NavigationNextTurnEvent) this.instance).hasTurnSide();
        }

        public Builder setEvent(NextTurnEnum nextTurnEnum) {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).setEvent(nextTurnEnum);
            return this;
        }

        public Builder setImage(ByteString byteString) {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).setImage(byteString);
            return this;
        }

        public Builder setRoad(String str) {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).setRoad(str);
            return this;
        }

        public Builder setRoadBytes(ByteString byteString) {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).setRoadBytes(byteString);
            return this;
        }

        public Builder setTurnAngle(int i) {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).setTurnAngle(i);
            return this;
        }

        public Builder setTurnNumber(int i) {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).setTurnNumber(i);
            return this;
        }

        public Builder setTurnSide(TurnSide turnSide) {
            copyOnWrite();
            ((NavigationNextTurnEvent) this.instance).setTurnSide(turnSide);
            return this;
        }

        private Builder() {
            super(NavigationNextTurnEvent.DEFAULT_INSTANCE);
        }
    }

    public enum NextTurnEnum implements Internal.EnumLite {
        UNKNOWN(0),
        DEPART(1),
        NAME_CHANGE(2),
        SLIGHT_TURN(3),
        TURN(4),
        SHARP_TURN(5),
        U_TURN(6),
        ON_RAMP(7),
        OFF_RAMP(8),
        FORK(9),
        MERGE(10),
        ROUNDABOUT_ENTER(11),
        ROUNDABOUT_EXIT(12),
        ROUNDABOUT_ENTER_AND_EXIT(13),
        STRAIGHT(14),
        FERRY_BOAT(16),
        FERRY_TRAIN(17),
        DESTINATION(19);

        public static final int DEPART_VALUE = 1;
        public static final int DESTINATION_VALUE = 19;
        public static final int FERRY_BOAT_VALUE = 16;
        public static final int FERRY_TRAIN_VALUE = 17;
        public static final int FORK_VALUE = 9;
        public static final int MERGE_VALUE = 10;
        public static final int NAME_CHANGE_VALUE = 2;
        public static final int OFF_RAMP_VALUE = 8;
        public static final int ON_RAMP_VALUE = 7;
        public static final int ROUNDABOUT_ENTER_AND_EXIT_VALUE = 13;
        public static final int ROUNDABOUT_ENTER_VALUE = 11;
        public static final int ROUNDABOUT_EXIT_VALUE = 12;
        public static final int SHARP_TURN_VALUE = 5;
        public static final int SLIGHT_TURN_VALUE = 3;
        public static final int STRAIGHT_VALUE = 14;
        public static final int TURN_VALUE = 4;
        public static final int UNKNOWN_VALUE = 0;
        public static final int U_TURN_VALUE = 6;
        private static final Internal.EnumLiteMap<NextTurnEnum> internalValueMap = new Internal.EnumLiteMap<NextTurnEnum>() { // from class: fr.sd.taada.proto.NavigationNextTurnEvent.NextTurnEnum.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public NextTurnEnum findValueByNumber(int i) {
                return NextTurnEnum.forNumber(i);
            }
        };
        private final int value;

        public static final class NextTurnEnumVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new NextTurnEnumVerifier();

            private NextTurnEnumVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return NextTurnEnum.forNumber(i) != null;
            }
        }

        NextTurnEnum(int i) {
            this.value = i;
        }

        public static NextTurnEnum forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return DEPART;
                case 2:
                    return NAME_CHANGE;
                case 3:
                    return SLIGHT_TURN;
                case 4:
                    return TURN;
                case 5:
                    return SHARP_TURN;
                case 6:
                    return U_TURN;
                case 7:
                    return ON_RAMP;
                case 8:
                    return OFF_RAMP;
                case 9:
                    return FORK;
                case 10:
                    return MERGE;
                case 11:
                    return ROUNDABOUT_ENTER;
                case 12:
                    return ROUNDABOUT_EXIT;
                case 13:
                    return ROUNDABOUT_ENTER_AND_EXIT;
                case 14:
                    return STRAIGHT;
                case 15:
                case 18:
                default:
                    return null;
                case 16:
                    return FERRY_BOAT;
                case 17:
                    return FERRY_TRAIN;
                case 19:
                    return DESTINATION;
            }
        }

        public static Internal.EnumLiteMap<NextTurnEnum> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return NextTurnEnumVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NextTurnEnum valueOf(int i) {
            return forNumber(i);
        }
    }

    public enum TurnSide implements Internal.EnumLite {
        LEFT(1),
        RIGHT(2),
        UNSPECIFIED(3);

        public static final int LEFT_VALUE = 1;
        public static final int RIGHT_VALUE = 2;
        public static final int UNSPECIFIED_VALUE = 3;
        private static final Internal.EnumLiteMap<TurnSide> internalValueMap = new Internal.EnumLiteMap<TurnSide>() { // from class: fr.sd.taada.proto.NavigationNextTurnEvent.TurnSide.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TurnSide findValueByNumber(int i) {
                return TurnSide.forNumber(i);
            }
        };
        private final int value;

        public static final class TurnSideVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new TurnSideVerifier();

            private TurnSideVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return TurnSide.forNumber(i) != null;
            }
        }

        TurnSide(int i) {
            this.value = i;
        }

        public static TurnSide forNumber(int i) {
            if (i == 1) {
                return LEFT;
            }
            if (i == 2) {
                return RIGHT;
            }
            if (i != 3) {
                return null;
            }
            return UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<TurnSide> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TurnSideVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TurnSide valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NavigationNextTurnEvent navigationNextTurnEvent = new NavigationNextTurnEvent();
        DEFAULT_INSTANCE = navigationNextTurnEvent;
        GeneratedMessageLite.registerDefaultInstance(NavigationNextTurnEvent.class, navigationNextTurnEvent);
    }

    private NavigationNextTurnEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvent() {
        this.bitField0_ &= -5;
        this.event_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImage() {
        this.bitField0_ &= -9;
        this.image_ = getDefaultInstance().getImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoad() {
        this.bitField0_ &= -2;
        this.road_ = getDefaultInstance().getRoad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTurnAngle() {
        this.bitField0_ &= -33;
        this.turnAngle_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTurnNumber() {
        this.bitField0_ &= -17;
        this.turnNumber_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTurnSide() {
        this.bitField0_ &= -3;
        this.turnSide_ = 1;
    }

    public static NavigationNextTurnEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationNextTurnEvent parseDelimitedFrom(InputStream inputStream) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationNextTurnEvent parseFrom(ByteBuffer byteBuffer) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationNextTurnEvent> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEvent(NextTurnEnum nextTurnEnum) {
        nextTurnEnum.getClass();
        this.bitField0_ |= 4;
        this.event_ = nextTurnEnum.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImage(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.image_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoad(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.road_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoadBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.road_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTurnAngle(int i) {
        this.bitField0_ |= 32;
        this.turnAngle_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTurnNumber(int i) {
        this.bitField0_ |= 16;
        this.turnNumber_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTurnSide(TurnSide turnSide) {
        turnSide.getClass();
        this.bitField0_ |= 2;
        this.turnSide_ = turnSide.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationNextTurnEvent();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\f\u0001\u0003\f\u0002\u0004\n\u0003\u0005\u0004\u0004\u0006\u0004\u0005", new Object[]{"bitField0_", "road_", "turnSide_", TurnSide.internalGetVerifier(), "event_", NextTurnEnum.internalGetVerifier(), "image_", "turnNumber_", "turnAngle_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationNextTurnEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationNextTurnEvent.class) {
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

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public NextTurnEnum getEvent() {
        NextTurnEnum nextTurnEnumForNumber = NextTurnEnum.forNumber(this.event_);
        return nextTurnEnumForNumber == null ? NextTurnEnum.UNKNOWN : nextTurnEnumForNumber;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public ByteString getImage() {
        return this.image_;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public String getRoad() {
        return this.road_;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public ByteString getRoadBytes() {
        return ByteString.copyFromUtf8(this.road_);
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public int getTurnAngle() {
        return this.turnAngle_;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public int getTurnNumber() {
        return this.turnNumber_;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public TurnSide getTurnSide() {
        TurnSide turnSideForNumber = TurnSide.forNumber(this.turnSide_);
        return turnSideForNumber == null ? TurnSide.LEFT : turnSideForNumber;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public boolean hasEvent() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public boolean hasImage() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public boolean hasRoad() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public boolean hasTurnAngle() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public boolean hasTurnNumber() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationNextTurnEventOrBuilder
    public boolean hasTurnSide() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(NavigationNextTurnEvent navigationNextTurnEvent) {
        return DEFAULT_INSTANCE.createBuilder(navigationNextTurnEvent);
    }

    public static NavigationNextTurnEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationNextTurnEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationNextTurnEvent parseFrom(ByteString byteString) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationNextTurnEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationNextTurnEvent parseFrom(byte[] bArr) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationNextTurnEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationNextTurnEvent parseFrom(InputStream inputStream) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationNextTurnEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationNextTurnEvent parseFrom(CodedInputStream codedInputStream) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationNextTurnEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationNextTurnEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
