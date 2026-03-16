package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DoorData extends GeneratedMessageLite<DoorData, Builder> implements DoorDataOrBuilder {
    private static final DoorData DEFAULT_INSTANCE;
    public static final int DOOR_OPEN_FIELD_NUMBER = 3;
    public static final int HOOD_OPEN_FIELD_NUMBER = 1;
    private static volatile Parser<DoorData> PARSER = null;
    public static final int TRUNK_OPEN_FIELD_NUMBER = 2;
    private int bitField0_;
    private Internal.BooleanList doorOpen_ = GeneratedMessageLite.emptyBooleanList();
    private boolean hoodOpen_;
    private boolean trunkOpen_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.DoorData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<DoorData, Builder> implements DoorDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDoorOpen(Iterable<? extends Boolean> iterable) {
            copyOnWrite();
            ((DoorData) this.instance).addAllDoorOpen(iterable);
            return this;
        }

        public Builder addDoorOpen(boolean z6) {
            copyOnWrite();
            ((DoorData) this.instance).addDoorOpen(z6);
            return this;
        }

        public Builder clearDoorOpen() {
            copyOnWrite();
            ((DoorData) this.instance).clearDoorOpen();
            return this;
        }

        public Builder clearHoodOpen() {
            copyOnWrite();
            ((DoorData) this.instance).clearHoodOpen();
            return this;
        }

        public Builder clearTrunkOpen() {
            copyOnWrite();
            ((DoorData) this.instance).clearTrunkOpen();
            return this;
        }

        @Override // fr.sd.taada.proto.DoorDataOrBuilder
        public boolean getDoorOpen(int i) {
            return ((DoorData) this.instance).getDoorOpen(i);
        }

        @Override // fr.sd.taada.proto.DoorDataOrBuilder
        public int getDoorOpenCount() {
            return ((DoorData) this.instance).getDoorOpenCount();
        }

        @Override // fr.sd.taada.proto.DoorDataOrBuilder
        public List<Boolean> getDoorOpenList() {
            return Collections.unmodifiableList(((DoorData) this.instance).getDoorOpenList());
        }

        @Override // fr.sd.taada.proto.DoorDataOrBuilder
        public boolean getHoodOpen() {
            return ((DoorData) this.instance).getHoodOpen();
        }

        @Override // fr.sd.taada.proto.DoorDataOrBuilder
        public boolean getTrunkOpen() {
            return ((DoorData) this.instance).getTrunkOpen();
        }

        @Override // fr.sd.taada.proto.DoorDataOrBuilder
        public boolean hasHoodOpen() {
            return ((DoorData) this.instance).hasHoodOpen();
        }

        @Override // fr.sd.taada.proto.DoorDataOrBuilder
        public boolean hasTrunkOpen() {
            return ((DoorData) this.instance).hasTrunkOpen();
        }

        public Builder setDoorOpen(int i, boolean z6) {
            copyOnWrite();
            ((DoorData) this.instance).setDoorOpen(i, z6);
            return this;
        }

        public Builder setHoodOpen(boolean z6) {
            copyOnWrite();
            ((DoorData) this.instance).setHoodOpen(z6);
            return this;
        }

        public Builder setTrunkOpen(boolean z6) {
            copyOnWrite();
            ((DoorData) this.instance).setTrunkOpen(z6);
            return this;
        }

        private Builder() {
            super(DoorData.DEFAULT_INSTANCE);
        }
    }

    static {
        DoorData doorData = new DoorData();
        DEFAULT_INSTANCE = doorData;
        GeneratedMessageLite.registerDefaultInstance(DoorData.class, doorData);
    }

    private DoorData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDoorOpen(Iterable<? extends Boolean> iterable) {
        ensureDoorOpenIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.doorOpen_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDoorOpen(boolean z6) {
        ensureDoorOpenIsMutable();
        this.doorOpen_.addBoolean(z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDoorOpen() {
        this.doorOpen_ = GeneratedMessageLite.emptyBooleanList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHoodOpen() {
        this.bitField0_ &= -2;
        this.hoodOpen_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunkOpen() {
        this.bitField0_ &= -3;
        this.trunkOpen_ = false;
    }

    private void ensureDoorOpenIsMutable() {
        if (this.doorOpen_.isModifiable()) {
            return;
        }
        this.doorOpen_ = GeneratedMessageLite.mutableCopy(this.doorOpen_);
    }

    public static DoorData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DoorData parseDelimitedFrom(InputStream inputStream) {
        return (DoorData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DoorData parseFrom(ByteBuffer byteBuffer) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DoorData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDoorOpen(int i, boolean z6) {
        ensureDoorOpenIsMutable();
        this.doorOpen_.setBoolean(i, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHoodOpen(boolean z6) {
        this.bitField0_ |= 1;
        this.hoodOpen_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunkOpen(boolean z6) {
        this.bitField0_ |= 2;
        this.trunkOpen_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new DoorData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u0019", new Object[]{"bitField0_", "hoodOpen_", "trunkOpen_", "doorOpen_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DoorData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DoorData.class) {
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

    @Override // fr.sd.taada.proto.DoorDataOrBuilder
    public boolean getDoorOpen(int i) {
        return this.doorOpen_.getBoolean(i);
    }

    @Override // fr.sd.taada.proto.DoorDataOrBuilder
    public int getDoorOpenCount() {
        return this.doorOpen_.size();
    }

    @Override // fr.sd.taada.proto.DoorDataOrBuilder
    public List<Boolean> getDoorOpenList() {
        return this.doorOpen_;
    }

    @Override // fr.sd.taada.proto.DoorDataOrBuilder
    public boolean getHoodOpen() {
        return this.hoodOpen_;
    }

    @Override // fr.sd.taada.proto.DoorDataOrBuilder
    public boolean getTrunkOpen() {
        return this.trunkOpen_;
    }

    @Override // fr.sd.taada.proto.DoorDataOrBuilder
    public boolean hasHoodOpen() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.DoorDataOrBuilder
    public boolean hasTrunkOpen() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(DoorData doorData) {
        return DEFAULT_INSTANCE.createBuilder(doorData);
    }

    public static DoorData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoorData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DoorData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DoorData parseFrom(ByteString byteString) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DoorData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DoorData parseFrom(byte[] bArr) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DoorData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DoorData parseFrom(InputStream inputStream) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DoorData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DoorData parseFrom(CodedInputStream codedInputStream) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DoorData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
