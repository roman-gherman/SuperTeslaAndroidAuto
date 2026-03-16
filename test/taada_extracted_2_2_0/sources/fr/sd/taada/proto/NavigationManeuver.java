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
public final class NavigationManeuver extends GeneratedMessageLite<NavigationManeuver, Builder> implements NavigationManeuverOrBuilder {
    private static final NavigationManeuver DEFAULT_INSTANCE;
    private static volatile Parser<NavigationManeuver> PARSER = null;
    public static final int ROUNDABOUT_EXIT_ANGLE_FIELD_NUMBER = 3;
    public static final int ROUNDABOUT_EXIT_NUMBER_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int roundaboutExitAngle_;
    private int roundaboutExitNumber_;
    private int type_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationManeuver$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationManeuver, Builder> implements NavigationManeuverOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRoundaboutExitAngle() {
            copyOnWrite();
            ((NavigationManeuver) this.instance).clearRoundaboutExitAngle();
            return this;
        }

        public Builder clearRoundaboutExitNumber() {
            copyOnWrite();
            ((NavigationManeuver) this.instance).clearRoundaboutExitNumber();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((NavigationManeuver) this.instance).clearType();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
        public int getRoundaboutExitAngle() {
            return ((NavigationManeuver) this.instance).getRoundaboutExitAngle();
        }

        @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
        public int getRoundaboutExitNumber() {
            return ((NavigationManeuver) this.instance).getRoundaboutExitNumber();
        }

        @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
        public NavigationType getType() {
            return ((NavigationManeuver) this.instance).getType();
        }

        @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
        public boolean hasRoundaboutExitAngle() {
            return ((NavigationManeuver) this.instance).hasRoundaboutExitAngle();
        }

        @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
        public boolean hasRoundaboutExitNumber() {
            return ((NavigationManeuver) this.instance).hasRoundaboutExitNumber();
        }

        @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
        public boolean hasType() {
            return ((NavigationManeuver) this.instance).hasType();
        }

        public Builder setRoundaboutExitAngle(int i) {
            copyOnWrite();
            ((NavigationManeuver) this.instance).setRoundaboutExitAngle(i);
            return this;
        }

        public Builder setRoundaboutExitNumber(int i) {
            copyOnWrite();
            ((NavigationManeuver) this.instance).setRoundaboutExitNumber(i);
            return this;
        }

        public Builder setType(NavigationType navigationType) {
            copyOnWrite();
            ((NavigationManeuver) this.instance).setType(navigationType);
            return this;
        }

        private Builder() {
            super(NavigationManeuver.DEFAULT_INSTANCE);
        }
    }

    public enum NavigationType implements Internal.EnumLite {
        UNKNOWN(0),
        DEPART(1),
        NAME_CHANGE(2),
        KEEP_LEFT(3),
        KEEP_RIGHT(4),
        TURN_SLIGHT_LEFT(5),
        TURN_SLIGHT_RIGHT(6),
        TURN_NORMAL_LEFT(7),
        TURN_NORMAL_RIGHT(8),
        TURN_SHARP_LEFT(9),
        TURN_SHARP_RIGHT(10),
        U_TURN_LEFT(11),
        U_TURN_RIGHT(12),
        ON_RAMP_SLIGHT_LEFT(13),
        ON_RAMP_SLIGHT_RIGHT(14),
        ON_RAMP_NORMAL_LEFT(15),
        ON_RAMP_NORMAL_RIGHT(16),
        ON_RAMP_SHARP_LEFT(17),
        ON_RAMP_SHARP_RIGHT(18),
        ON_RAMP_U_TURN_LEFT(19),
        ON_RAMP_U_TURN_RIGHT(20),
        OFF_RAMP_SLIGHT_LEFT(21),
        OFF_RAMP_SLIGHT_RIGHT(22),
        OFF_RAMP_NORMAL_LEFT(23),
        OFF_RAMP_NORMAL_RIGHT(24),
        FORK_LEFT(25),
        FORK_RIGHT(26),
        MERGE_LEFT(27),
        MERGE_RIGHT(28),
        MERGE_SIDE_UNSPECIFIED(29),
        ROUNDABOUT_ENTER(30),
        ROUNDABOUT_EXIT(31),
        ROUNDABOUT_ENTER_AND_EXIT_CW(32),
        ROUNDABOUT_ENTER_AND_EXIT_CW_WITH_ANGLE(33),
        ROUNDABOUT_ENTER_AND_EXIT_CCW(34),
        ROUNDABOUT_ENTER_AND_EXIT_CCW_WITH_ANGLE(35),
        STRAIGHT(36),
        FERRY_BOAT(37),
        FERRY_TRAIN(38),
        DESTINATION(39),
        DESTINATION_STRAIGHT(40),
        DESTINATION_LEFT(41),
        DESTINATION_RIGHT(42);

        public static final int DEPART_VALUE = 1;
        public static final int DESTINATION_LEFT_VALUE = 41;
        public static final int DESTINATION_RIGHT_VALUE = 42;
        public static final int DESTINATION_STRAIGHT_VALUE = 40;
        public static final int DESTINATION_VALUE = 39;
        public static final int FERRY_BOAT_VALUE = 37;
        public static final int FERRY_TRAIN_VALUE = 38;
        public static final int FORK_LEFT_VALUE = 25;
        public static final int FORK_RIGHT_VALUE = 26;
        public static final int KEEP_LEFT_VALUE = 3;
        public static final int KEEP_RIGHT_VALUE = 4;
        public static final int MERGE_LEFT_VALUE = 27;
        public static final int MERGE_RIGHT_VALUE = 28;
        public static final int MERGE_SIDE_UNSPECIFIED_VALUE = 29;
        public static final int NAME_CHANGE_VALUE = 2;
        public static final int OFF_RAMP_NORMAL_LEFT_VALUE = 23;
        public static final int OFF_RAMP_NORMAL_RIGHT_VALUE = 24;
        public static final int OFF_RAMP_SLIGHT_LEFT_VALUE = 21;
        public static final int OFF_RAMP_SLIGHT_RIGHT_VALUE = 22;
        public static final int ON_RAMP_NORMAL_LEFT_VALUE = 15;
        public static final int ON_RAMP_NORMAL_RIGHT_VALUE = 16;
        public static final int ON_RAMP_SHARP_LEFT_VALUE = 17;
        public static final int ON_RAMP_SHARP_RIGHT_VALUE = 18;
        public static final int ON_RAMP_SLIGHT_LEFT_VALUE = 13;
        public static final int ON_RAMP_SLIGHT_RIGHT_VALUE = 14;
        public static final int ON_RAMP_U_TURN_LEFT_VALUE = 19;
        public static final int ON_RAMP_U_TURN_RIGHT_VALUE = 20;
        public static final int ROUNDABOUT_ENTER_AND_EXIT_CCW_VALUE = 34;
        public static final int ROUNDABOUT_ENTER_AND_EXIT_CCW_WITH_ANGLE_VALUE = 35;
        public static final int ROUNDABOUT_ENTER_AND_EXIT_CW_VALUE = 32;
        public static final int ROUNDABOUT_ENTER_AND_EXIT_CW_WITH_ANGLE_VALUE = 33;
        public static final int ROUNDABOUT_ENTER_VALUE = 30;
        public static final int ROUNDABOUT_EXIT_VALUE = 31;
        public static final int STRAIGHT_VALUE = 36;
        public static final int TURN_NORMAL_LEFT_VALUE = 7;
        public static final int TURN_NORMAL_RIGHT_VALUE = 8;
        public static final int TURN_SHARP_LEFT_VALUE = 9;
        public static final int TURN_SHARP_RIGHT_VALUE = 10;
        public static final int TURN_SLIGHT_LEFT_VALUE = 5;
        public static final int TURN_SLIGHT_RIGHT_VALUE = 6;
        public static final int UNKNOWN_VALUE = 0;
        public static final int U_TURN_LEFT_VALUE = 11;
        public static final int U_TURN_RIGHT_VALUE = 12;
        private static final Internal.EnumLiteMap<NavigationType> internalValueMap = new Internal.EnumLiteMap<NavigationType>() { // from class: fr.sd.taada.proto.NavigationManeuver.NavigationType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public NavigationType findValueByNumber(int i) {
                return NavigationType.forNumber(i);
            }
        };
        private final int value;

        public static final class NavigationTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new NavigationTypeVerifier();

            private NavigationTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return NavigationType.forNumber(i) != null;
            }
        }

        NavigationType(int i) {
            this.value = i;
        }

        public static NavigationType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return DEPART;
                case 2:
                    return NAME_CHANGE;
                case 3:
                    return KEEP_LEFT;
                case 4:
                    return KEEP_RIGHT;
                case 5:
                    return TURN_SLIGHT_LEFT;
                case 6:
                    return TURN_SLIGHT_RIGHT;
                case 7:
                    return TURN_NORMAL_LEFT;
                case 8:
                    return TURN_NORMAL_RIGHT;
                case 9:
                    return TURN_SHARP_LEFT;
                case 10:
                    return TURN_SHARP_RIGHT;
                case 11:
                    return U_TURN_LEFT;
                case 12:
                    return U_TURN_RIGHT;
                case 13:
                    return ON_RAMP_SLIGHT_LEFT;
                case 14:
                    return ON_RAMP_SLIGHT_RIGHT;
                case 15:
                    return ON_RAMP_NORMAL_LEFT;
                case 16:
                    return ON_RAMP_NORMAL_RIGHT;
                case 17:
                    return ON_RAMP_SHARP_LEFT;
                case 18:
                    return ON_RAMP_SHARP_RIGHT;
                case 19:
                    return ON_RAMP_U_TURN_LEFT;
                case 20:
                    return ON_RAMP_U_TURN_RIGHT;
                case 21:
                    return OFF_RAMP_SLIGHT_LEFT;
                case 22:
                    return OFF_RAMP_SLIGHT_RIGHT;
                case 23:
                    return OFF_RAMP_NORMAL_LEFT;
                case 24:
                    return OFF_RAMP_NORMAL_RIGHT;
                case 25:
                    return FORK_LEFT;
                case 26:
                    return FORK_RIGHT;
                case 27:
                    return MERGE_LEFT;
                case 28:
                    return MERGE_RIGHT;
                case 29:
                    return MERGE_SIDE_UNSPECIFIED;
                case 30:
                    return ROUNDABOUT_ENTER;
                case 31:
                    return ROUNDABOUT_EXIT;
                case 32:
                    return ROUNDABOUT_ENTER_AND_EXIT_CW;
                case 33:
                    return ROUNDABOUT_ENTER_AND_EXIT_CW_WITH_ANGLE;
                case 34:
                    return ROUNDABOUT_ENTER_AND_EXIT_CCW;
                case 35:
                    return ROUNDABOUT_ENTER_AND_EXIT_CCW_WITH_ANGLE;
                case 36:
                    return STRAIGHT;
                case 37:
                    return FERRY_BOAT;
                case 38:
                    return FERRY_TRAIN;
                case 39:
                    return DESTINATION;
                case 40:
                    return DESTINATION_STRAIGHT;
                case 41:
                    return DESTINATION_LEFT;
                case 42:
                    return DESTINATION_RIGHT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<NavigationType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return NavigationTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NavigationType valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NavigationManeuver navigationManeuver = new NavigationManeuver();
        DEFAULT_INSTANCE = navigationManeuver;
        GeneratedMessageLite.registerDefaultInstance(NavigationManeuver.class, navigationManeuver);
    }

    private NavigationManeuver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoundaboutExitAngle() {
        this.bitField0_ &= -5;
        this.roundaboutExitAngle_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoundaboutExitNumber() {
        this.bitField0_ &= -3;
        this.roundaboutExitNumber_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = 0;
    }

    public static NavigationManeuver getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationManeuver parseDelimitedFrom(InputStream inputStream) {
        return (NavigationManeuver) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationManeuver parseFrom(ByteBuffer byteBuffer) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationManeuver> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoundaboutExitAngle(int i) {
        this.bitField0_ |= 4;
        this.roundaboutExitAngle_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoundaboutExitNumber(int i) {
        this.bitField0_ |= 2;
        this.roundaboutExitNumber_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(NavigationType navigationType) {
        navigationType.getClass();
        this.bitField0_ |= 1;
        this.type_ = navigationType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationManeuver();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "type_", NavigationType.internalGetVerifier(), "roundaboutExitNumber_", "roundaboutExitAngle_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationManeuver> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationManeuver.class) {
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

    @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
    public int getRoundaboutExitAngle() {
        return this.roundaboutExitAngle_;
    }

    @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
    public int getRoundaboutExitNumber() {
        return this.roundaboutExitNumber_;
    }

    @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
    public NavigationType getType() {
        NavigationType navigationTypeForNumber = NavigationType.forNumber(this.type_);
        return navigationTypeForNumber == null ? NavigationType.UNKNOWN : navigationTypeForNumber;
    }

    @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
    public boolean hasRoundaboutExitAngle() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
    public boolean hasRoundaboutExitNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationManeuverOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavigationManeuver navigationManeuver) {
        return DEFAULT_INSTANCE.createBuilder(navigationManeuver);
    }

    public static NavigationManeuver parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationManeuver) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationManeuver parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationManeuver parseFrom(ByteString byteString) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationManeuver parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationManeuver parseFrom(byte[] bArr) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationManeuver parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationManeuver parseFrom(InputStream inputStream) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationManeuver parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationManeuver parseFrom(CodedInputStream codedInputStream) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationManeuver parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationManeuver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
