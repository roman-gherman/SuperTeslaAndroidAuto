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
public final class TirePressureData extends GeneratedMessageLite<TirePressureData, Builder> implements TirePressureDataOrBuilder {
    private static final TirePressureData DEFAULT_INSTANCE;
    private static volatile Parser<TirePressureData> PARSER = null;
    public static final int TIRE_PRESSURES_E2_FIELD_NUMBER = 1;
    private Internal.IntList tirePressuresE2_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.TirePressureData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TirePressureData, Builder> implements TirePressureDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTirePressuresE2(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((TirePressureData) this.instance).addAllTirePressuresE2(iterable);
            return this;
        }

        public Builder addTirePressuresE2(int i) {
            copyOnWrite();
            ((TirePressureData) this.instance).addTirePressuresE2(i);
            return this;
        }

        public Builder clearTirePressuresE2() {
            copyOnWrite();
            ((TirePressureData) this.instance).clearTirePressuresE2();
            return this;
        }

        @Override // fr.sd.taada.proto.TirePressureDataOrBuilder
        public int getTirePressuresE2(int i) {
            return ((TirePressureData) this.instance).getTirePressuresE2(i);
        }

        @Override // fr.sd.taada.proto.TirePressureDataOrBuilder
        public int getTirePressuresE2Count() {
            return ((TirePressureData) this.instance).getTirePressuresE2Count();
        }

        @Override // fr.sd.taada.proto.TirePressureDataOrBuilder
        public List<Integer> getTirePressuresE2List() {
            return Collections.unmodifiableList(((TirePressureData) this.instance).getTirePressuresE2List());
        }

        public Builder setTirePressuresE2(int i, int i3) {
            copyOnWrite();
            ((TirePressureData) this.instance).setTirePressuresE2(i, i3);
            return this;
        }

        private Builder() {
            super(TirePressureData.DEFAULT_INSTANCE);
        }
    }

    static {
        TirePressureData tirePressureData = new TirePressureData();
        DEFAULT_INSTANCE = tirePressureData;
        GeneratedMessageLite.registerDefaultInstance(TirePressureData.class, tirePressureData);
    }

    private TirePressureData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTirePressuresE2(Iterable<? extends Integer> iterable) {
        ensureTirePressuresE2IsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.tirePressuresE2_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTirePressuresE2(int i) {
        ensureTirePressuresE2IsMutable();
        this.tirePressuresE2_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTirePressuresE2() {
        this.tirePressuresE2_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureTirePressuresE2IsMutable() {
        if (this.tirePressuresE2_.isModifiable()) {
            return;
        }
        this.tirePressuresE2_ = GeneratedMessageLite.mutableCopy(this.tirePressuresE2_);
    }

    public static TirePressureData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TirePressureData parseDelimitedFrom(InputStream inputStream) {
        return (TirePressureData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TirePressureData parseFrom(ByteBuffer byteBuffer) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TirePressureData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTirePressuresE2(int i, int i3) {
        ensureTirePressuresE2IsMutable();
        this.tirePressuresE2_.setInt(i, i3);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TirePressureData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", new Object[]{"tirePressuresE2_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TirePressureData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TirePressureData.class) {
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

    @Override // fr.sd.taada.proto.TirePressureDataOrBuilder
    public int getTirePressuresE2(int i) {
        return this.tirePressuresE2_.getInt(i);
    }

    @Override // fr.sd.taada.proto.TirePressureDataOrBuilder
    public int getTirePressuresE2Count() {
        return this.tirePressuresE2_.size();
    }

    @Override // fr.sd.taada.proto.TirePressureDataOrBuilder
    public List<Integer> getTirePressuresE2List() {
        return this.tirePressuresE2_;
    }

    public static Builder newBuilder(TirePressureData tirePressureData) {
        return DEFAULT_INSTANCE.createBuilder(tirePressureData);
    }

    public static TirePressureData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TirePressureData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TirePressureData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TirePressureData parseFrom(ByteString byteString) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TirePressureData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TirePressureData parseFrom(byte[] bArr) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TirePressureData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TirePressureData parseFrom(InputStream inputStream) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TirePressureData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TirePressureData parseFrom(CodedInputStream codedInputStream) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TirePressureData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TirePressureData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
