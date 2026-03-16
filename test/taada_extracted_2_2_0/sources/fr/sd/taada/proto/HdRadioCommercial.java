package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class HdRadioCommercial extends GeneratedMessageLite<HdRadioCommercial, Builder> implements HdRadioCommercialOrBuilder {
    private static final HdRadioCommercial DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 7;
    public static final int ENCODING_FIELD_NUMBER = 1;
    private static volatile Parser<HdRadioCommercial> PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 2;
    public static final int RECEIVED_FIELD_NUMBER = 5;
    public static final int SELLER_FIELD_NUMBER = 6;
    public static final int URL_FIELD_NUMBER = 4;
    public static final int VALID_FIELD_NUMBER = 3;
    private int bitField0_;
    private int encoding_;
    private int received_;
    private String price_ = "";
    private String valid_ = "";
    private String url_ = "";
    private String seller_ = "";
    private String description_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.HdRadioCommercial$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HdRadioCommercial, Builder> implements HdRadioCommercialOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).clearDescription();
            return this;
        }

        public Builder clearEncoding() {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).clearEncoding();
            return this;
        }

        public Builder clearPrice() {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).clearPrice();
            return this;
        }

        public Builder clearReceived() {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).clearReceived();
            return this;
        }

        public Builder clearSeller() {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).clearSeller();
            return this;
        }

        public Builder clearUrl() {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).clearUrl();
            return this;
        }

        public Builder clearValid() {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).clearValid();
            return this;
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public String getDescription() {
            return ((HdRadioCommercial) this.instance).getDescription();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public ByteString getDescriptionBytes() {
            return ((HdRadioCommercial) this.instance).getDescriptionBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public int getEncoding() {
            return ((HdRadioCommercial) this.instance).getEncoding();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public String getPrice() {
            return ((HdRadioCommercial) this.instance).getPrice();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public ByteString getPriceBytes() {
            return ((HdRadioCommercial) this.instance).getPriceBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public int getReceived() {
            return ((HdRadioCommercial) this.instance).getReceived();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public String getSeller() {
            return ((HdRadioCommercial) this.instance).getSeller();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public ByteString getSellerBytes() {
            return ((HdRadioCommercial) this.instance).getSellerBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public String getUrl() {
            return ((HdRadioCommercial) this.instance).getUrl();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public ByteString getUrlBytes() {
            return ((HdRadioCommercial) this.instance).getUrlBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public String getValid() {
            return ((HdRadioCommercial) this.instance).getValid();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public ByteString getValidBytes() {
            return ((HdRadioCommercial) this.instance).getValidBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public boolean hasDescription() {
            return ((HdRadioCommercial) this.instance).hasDescription();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public boolean hasEncoding() {
            return ((HdRadioCommercial) this.instance).hasEncoding();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public boolean hasPrice() {
            return ((HdRadioCommercial) this.instance).hasPrice();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public boolean hasReceived() {
            return ((HdRadioCommercial) this.instance).hasReceived();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public boolean hasSeller() {
            return ((HdRadioCommercial) this.instance).hasSeller();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public boolean hasUrl() {
            return ((HdRadioCommercial) this.instance).hasUrl();
        }

        @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
        public boolean hasValid() {
            return ((HdRadioCommercial) this.instance).hasValid();
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setEncoding(int i) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setEncoding(i);
            return this;
        }

        public Builder setPrice(String str) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setPrice(str);
            return this;
        }

        public Builder setPriceBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setPriceBytes(byteString);
            return this;
        }

        public Builder setReceived(int i) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setReceived(i);
            return this;
        }

        public Builder setSeller(String str) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setSeller(str);
            return this;
        }

        public Builder setSellerBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setSellerBytes(byteString);
            return this;
        }

        public Builder setUrl(String str) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setUrl(str);
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setUrlBytes(byteString);
            return this;
        }

        public Builder setValid(String str) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setValid(str);
            return this;
        }

        public Builder setValidBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioCommercial) this.instance).setValidBytes(byteString);
            return this;
        }

        private Builder() {
            super(HdRadioCommercial.DEFAULT_INSTANCE);
        }
    }

    static {
        HdRadioCommercial hdRadioCommercial = new HdRadioCommercial();
        DEFAULT_INSTANCE = hdRadioCommercial;
        GeneratedMessageLite.registerDefaultInstance(HdRadioCommercial.class, hdRadioCommercial);
    }

    private HdRadioCommercial() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.bitField0_ &= -65;
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEncoding() {
        this.bitField0_ &= -2;
        this.encoding_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrice() {
        this.bitField0_ &= -3;
        this.price_ = getDefaultInstance().getPrice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReceived() {
        this.bitField0_ &= -17;
        this.received_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSeller() {
        this.bitField0_ &= -33;
        this.seller_ = getDefaultInstance().getSeller();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.bitField0_ &= -9;
        this.url_ = getDefaultInstance().getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValid() {
        this.bitField0_ &= -5;
        this.valid_ = getDefaultInstance().getValid();
    }

    public static HdRadioCommercial getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HdRadioCommercial parseDelimitedFrom(InputStream inputStream) {
        return (HdRadioCommercial) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioCommercial parseFrom(ByteBuffer byteBuffer) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HdRadioCommercial> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 64;
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncoding(int i) {
        this.bitField0_ |= 1;
        this.encoding_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrice(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.price_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPriceBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.price_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReceived(int i) {
        this.bitField0_ |= 16;
        this.received_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeller(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.seller_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSellerBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 32;
        this.seller_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.url_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValid(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.valid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValidBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.valid_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HdRadioCommercial();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0004\u0004\u0006\b\u0005\u0007\b\u0006", new Object[]{"bitField0_", "encoding_", "price_", "valid_", "url_", "received_", "seller_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HdRadioCommercial> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HdRadioCommercial.class) {
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

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public int getEncoding() {
        return this.encoding_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public String getPrice() {
        return this.price_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public ByteString getPriceBytes() {
        return ByteString.copyFromUtf8(this.price_);
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public int getReceived() {
        return this.received_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public String getSeller() {
        return this.seller_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public ByteString getSellerBytes() {
        return ByteString.copyFromUtf8(this.seller_);
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public String getUrl() {
        return this.url_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public ByteString getUrlBytes() {
        return ByteString.copyFromUtf8(this.url_);
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public String getValid() {
        return this.valid_;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public ByteString getValidBytes() {
        return ByteString.copyFromUtf8(this.valid_);
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public boolean hasDescription() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public boolean hasEncoding() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public boolean hasPrice() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public boolean hasReceived() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public boolean hasSeller() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public boolean hasUrl() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioCommercialOrBuilder
    public boolean hasValid() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(HdRadioCommercial hdRadioCommercial) {
        return DEFAULT_INSTANCE.createBuilder(hdRadioCommercial);
    }

    public static HdRadioCommercial parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioCommercial) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioCommercial parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HdRadioCommercial parseFrom(ByteString byteString) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HdRadioCommercial parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HdRadioCommercial parseFrom(byte[] bArr) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HdRadioCommercial parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HdRadioCommercial parseFrom(InputStream inputStream) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioCommercial parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioCommercial parseFrom(CodedInputStream codedInputStream) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HdRadioCommercial parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioCommercial) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
