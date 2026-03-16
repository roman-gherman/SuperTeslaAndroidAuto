package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.GpsSatellite;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GpsSatelliteData extends GeneratedMessageLite<GpsSatelliteData, Builder> implements GpsSatelliteDataOrBuilder {
    private static final GpsSatelliteData DEFAULT_INSTANCE;
    public static final int NUMBER_IN_USE_FIELD_NUMBER = 1;
    public static final int NUMBER_IN_VIEW_FIELD_NUMBER = 2;
    private static volatile Parser<GpsSatelliteData> PARSER = null;
    public static final int SATELLITES_FIELD_NUMBER = 3;
    private int bitField0_;
    private int numberInUse_;
    private int numberInView_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<GpsSatellite> satellites_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.GpsSatelliteData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GpsSatelliteData, Builder> implements GpsSatelliteDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllSatellites(Iterable<? extends GpsSatellite> iterable) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).addAllSatellites(iterable);
            return this;
        }

        public Builder addSatellites(GpsSatellite gpsSatellite) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).addSatellites(gpsSatellite);
            return this;
        }

        public Builder clearNumberInUse() {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).clearNumberInUse();
            return this;
        }

        public Builder clearNumberInView() {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).clearNumberInView();
            return this;
        }

        public Builder clearSatellites() {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).clearSatellites();
            return this;
        }

        @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
        public int getNumberInUse() {
            return ((GpsSatelliteData) this.instance).getNumberInUse();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
        public int getNumberInView() {
            return ((GpsSatelliteData) this.instance).getNumberInView();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
        public GpsSatellite getSatellites(int i) {
            return ((GpsSatelliteData) this.instance).getSatellites(i);
        }

        @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
        public int getSatellitesCount() {
            return ((GpsSatelliteData) this.instance).getSatellitesCount();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
        public List<GpsSatellite> getSatellitesList() {
            return Collections.unmodifiableList(((GpsSatelliteData) this.instance).getSatellitesList());
        }

        @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
        public boolean hasNumberInUse() {
            return ((GpsSatelliteData) this.instance).hasNumberInUse();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
        public boolean hasNumberInView() {
            return ((GpsSatelliteData) this.instance).hasNumberInView();
        }

        public Builder removeSatellites(int i) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).removeSatellites(i);
            return this;
        }

        public Builder setNumberInUse(int i) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).setNumberInUse(i);
            return this;
        }

        public Builder setNumberInView(int i) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).setNumberInView(i);
            return this;
        }

        public Builder setSatellites(int i, GpsSatellite gpsSatellite) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).setSatellites(i, gpsSatellite);
            return this;
        }

        private Builder() {
            super(GpsSatelliteData.DEFAULT_INSTANCE);
        }

        public Builder addSatellites(int i, GpsSatellite gpsSatellite) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).addSatellites(i, gpsSatellite);
            return this;
        }

        public Builder setSatellites(int i, GpsSatellite.Builder builder) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).setSatellites(i, builder);
            return this;
        }

        public Builder addSatellites(GpsSatellite.Builder builder) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).addSatellites(builder);
            return this;
        }

        public Builder addSatellites(int i, GpsSatellite.Builder builder) {
            copyOnWrite();
            ((GpsSatelliteData) this.instance).addSatellites(i, builder);
            return this;
        }
    }

    static {
        GpsSatelliteData gpsSatelliteData = new GpsSatelliteData();
        DEFAULT_INSTANCE = gpsSatelliteData;
        GeneratedMessageLite.registerDefaultInstance(GpsSatelliteData.class, gpsSatelliteData);
    }

    private GpsSatelliteData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSatellites(Iterable<? extends GpsSatellite> iterable) {
        ensureSatellitesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.satellites_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSatellites(GpsSatellite gpsSatellite) {
        gpsSatellite.getClass();
        ensureSatellitesIsMutable();
        this.satellites_.add(gpsSatellite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumberInUse() {
        this.bitField0_ &= -2;
        this.numberInUse_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumberInView() {
        this.bitField0_ &= -3;
        this.numberInView_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSatellites() {
        this.satellites_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSatellitesIsMutable() {
        if (this.satellites_.isModifiable()) {
            return;
        }
        this.satellites_ = GeneratedMessageLite.mutableCopy(this.satellites_);
    }

    public static GpsSatelliteData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GpsSatelliteData parseDelimitedFrom(InputStream inputStream) {
        return (GpsSatelliteData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GpsSatelliteData parseFrom(ByteBuffer byteBuffer) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GpsSatelliteData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSatellites(int i) {
        ensureSatellitesIsMutable();
        this.satellites_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumberInUse(int i) {
        this.bitField0_ |= 1;
        this.numberInUse_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumberInView(int i) {
        this.bitField0_ |= 2;
        this.numberInView_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSatellites(int i, GpsSatellite gpsSatellite) {
        gpsSatellite.getClass();
        ensureSatellitesIsMutable();
        this.satellites_.set(i, gpsSatellite);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GpsSatelliteData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Ԅ\u0000\u0002\u0004\u0001\u0003Л", new Object[]{"bitField0_", "numberInUse_", "numberInView_", "satellites_", GpsSatellite.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GpsSatelliteData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GpsSatelliteData.class) {
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

    @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
    public int getNumberInUse() {
        return this.numberInUse_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
    public int getNumberInView() {
        return this.numberInView_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
    public GpsSatellite getSatellites(int i) {
        return this.satellites_.get(i);
    }

    @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
    public int getSatellitesCount() {
        return this.satellites_.size();
    }

    @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
    public List<GpsSatellite> getSatellitesList() {
        return this.satellites_;
    }

    public GpsSatelliteOrBuilder getSatellitesOrBuilder(int i) {
        return this.satellites_.get(i);
    }

    public List<? extends GpsSatelliteOrBuilder> getSatellitesOrBuilderList() {
        return this.satellites_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
    public boolean hasNumberInUse() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteDataOrBuilder
    public boolean hasNumberInView() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(GpsSatelliteData gpsSatelliteData) {
        return DEFAULT_INSTANCE.createBuilder(gpsSatelliteData);
    }

    public static GpsSatelliteData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatelliteData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GpsSatelliteData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GpsSatelliteData parseFrom(ByteString byteString) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSatellites(int i, GpsSatellite gpsSatellite) {
        gpsSatellite.getClass();
        ensureSatellitesIsMutable();
        this.satellites_.add(i, gpsSatellite);
    }

    public static GpsSatelliteData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSatellites(int i, GpsSatellite.Builder builder) {
        ensureSatellitesIsMutable();
        this.satellites_.set(i, builder.build());
    }

    public static GpsSatelliteData parseFrom(byte[] bArr) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GpsSatelliteData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSatellites(GpsSatellite.Builder builder) {
        ensureSatellitesIsMutable();
        this.satellites_.add(builder.build());
    }

    public static GpsSatelliteData parseFrom(InputStream inputStream) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GpsSatelliteData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSatellites(int i, GpsSatellite.Builder builder) {
        ensureSatellitesIsMutable();
        this.satellites_.add(i, builder.build());
    }

    public static GpsSatelliteData parseFrom(CodedInputStream codedInputStream) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GpsSatelliteData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatelliteData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
