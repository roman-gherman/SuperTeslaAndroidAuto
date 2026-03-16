package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.HdRadioArtistExperience;
import fr.sd.taada.proto.HdRadioComment;
import fr.sd.taada.proto.HdRadioCommercial;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class HdRadioPsdData extends GeneratedMessageLite<HdRadioPsdData, Builder> implements HdRadioPsdDataOrBuilder {
    public static final int ALBUM_FIELD_NUMBER = 3;
    public static final int ARTIST_EXPERIENCE_FIELD_NUMBER = 7;
    public static final int ARTIST_FIELD_NUMBER = 2;
    public static final int COMMENT_FIELD_NUMBER = 5;
    public static final int COMMERCIAL_FIELD_NUMBER = 6;
    private static final HdRadioPsdData DEFAULT_INSTANCE;
    public static final int GENRE_FIELD_NUMBER = 4;
    private static volatile Parser<HdRadioPsdData> PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private HdRadioArtistExperience artistExperience_;
    private int bitField0_;
    private HdRadioComment comment_;
    private HdRadioCommercial commercial_;
    private String title_ = "";
    private String artist_ = "";
    private String album_ = "";
    private String genre_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.HdRadioPsdData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HdRadioPsdData, Builder> implements HdRadioPsdDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlbum() {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).clearAlbum();
            return this;
        }

        public Builder clearArtist() {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).clearArtist();
            return this;
        }

        public Builder clearArtistExperience() {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).clearArtistExperience();
            return this;
        }

        public Builder clearComment() {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).clearComment();
            return this;
        }

        public Builder clearCommercial() {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).clearCommercial();
            return this;
        }

        public Builder clearGenre() {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).clearGenre();
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).clearTitle();
            return this;
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public String getAlbum() {
            return ((HdRadioPsdData) this.instance).getAlbum();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public ByteString getAlbumBytes() {
            return ((HdRadioPsdData) this.instance).getAlbumBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public String getArtist() {
            return ((HdRadioPsdData) this.instance).getArtist();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public ByteString getArtistBytes() {
            return ((HdRadioPsdData) this.instance).getArtistBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public HdRadioArtistExperience getArtistExperience() {
            return ((HdRadioPsdData) this.instance).getArtistExperience();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public HdRadioComment getComment() {
            return ((HdRadioPsdData) this.instance).getComment();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public HdRadioCommercial getCommercial() {
            return ((HdRadioPsdData) this.instance).getCommercial();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public String getGenre() {
            return ((HdRadioPsdData) this.instance).getGenre();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public ByteString getGenreBytes() {
            return ((HdRadioPsdData) this.instance).getGenreBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public String getTitle() {
            return ((HdRadioPsdData) this.instance).getTitle();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public ByteString getTitleBytes() {
            return ((HdRadioPsdData) this.instance).getTitleBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public boolean hasAlbum() {
            return ((HdRadioPsdData) this.instance).hasAlbum();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public boolean hasArtist() {
            return ((HdRadioPsdData) this.instance).hasArtist();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public boolean hasArtistExperience() {
            return ((HdRadioPsdData) this.instance).hasArtistExperience();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public boolean hasComment() {
            return ((HdRadioPsdData) this.instance).hasComment();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public boolean hasCommercial() {
            return ((HdRadioPsdData) this.instance).hasCommercial();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public boolean hasGenre() {
            return ((HdRadioPsdData) this.instance).hasGenre();
        }

        @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
        public boolean hasTitle() {
            return ((HdRadioPsdData) this.instance).hasTitle();
        }

        public Builder mergeArtistExperience(HdRadioArtistExperience hdRadioArtistExperience) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).mergeArtistExperience(hdRadioArtistExperience);
            return this;
        }

        public Builder mergeComment(HdRadioComment hdRadioComment) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).mergeComment(hdRadioComment);
            return this;
        }

        public Builder mergeCommercial(HdRadioCommercial hdRadioCommercial) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).mergeCommercial(hdRadioCommercial);
            return this;
        }

        public Builder setAlbum(String str) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setAlbum(str);
            return this;
        }

        public Builder setAlbumBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setAlbumBytes(byteString);
            return this;
        }

        public Builder setArtist(String str) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setArtist(str);
            return this;
        }

        public Builder setArtistBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setArtistBytes(byteString);
            return this;
        }

        public Builder setArtistExperience(HdRadioArtistExperience hdRadioArtistExperience) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setArtistExperience(hdRadioArtistExperience);
            return this;
        }

        public Builder setComment(HdRadioComment hdRadioComment) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setComment(hdRadioComment);
            return this;
        }

        public Builder setCommercial(HdRadioCommercial hdRadioCommercial) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setCommercial(hdRadioCommercial);
            return this;
        }

        public Builder setGenre(String str) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setGenre(str);
            return this;
        }

        public Builder setGenreBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setGenreBytes(byteString);
            return this;
        }

        public Builder setTitle(String str) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setTitle(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setTitleBytes(byteString);
            return this;
        }

        private Builder() {
            super(HdRadioPsdData.DEFAULT_INSTANCE);
        }

        public Builder setArtistExperience(HdRadioArtistExperience.Builder builder) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setArtistExperience(builder);
            return this;
        }

        public Builder setComment(HdRadioComment.Builder builder) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setComment(builder);
            return this;
        }

        public Builder setCommercial(HdRadioCommercial.Builder builder) {
            copyOnWrite();
            ((HdRadioPsdData) this.instance).setCommercial(builder);
            return this;
        }
    }

    static {
        HdRadioPsdData hdRadioPsdData = new HdRadioPsdData();
        DEFAULT_INSTANCE = hdRadioPsdData;
        GeneratedMessageLite.registerDefaultInstance(HdRadioPsdData.class, hdRadioPsdData);
    }

    private HdRadioPsdData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbum() {
        this.bitField0_ &= -5;
        this.album_ = getDefaultInstance().getAlbum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArtist() {
        this.bitField0_ &= -3;
        this.artist_ = getDefaultInstance().getArtist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArtistExperience() {
        this.artistExperience_ = null;
        this.bitField0_ &= -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearComment() {
        this.comment_ = null;
        this.bitField0_ &= -17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCommercial() {
        this.commercial_ = null;
        this.bitField0_ &= -33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGenre() {
        this.bitField0_ &= -9;
        this.genre_ = getDefaultInstance().getGenre();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.bitField0_ &= -2;
        this.title_ = getDefaultInstance().getTitle();
    }

    public static HdRadioPsdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeArtistExperience(HdRadioArtistExperience hdRadioArtistExperience) {
        hdRadioArtistExperience.getClass();
        HdRadioArtistExperience hdRadioArtistExperience2 = this.artistExperience_;
        if (hdRadioArtistExperience2 == null || hdRadioArtistExperience2 == HdRadioArtistExperience.getDefaultInstance()) {
            this.artistExperience_ = hdRadioArtistExperience;
        } else {
            this.artistExperience_ = HdRadioArtistExperience.newBuilder(this.artistExperience_).mergeFrom(hdRadioArtistExperience).buildPartial();
        }
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeComment(HdRadioComment hdRadioComment) {
        hdRadioComment.getClass();
        HdRadioComment hdRadioComment2 = this.comment_;
        if (hdRadioComment2 == null || hdRadioComment2 == HdRadioComment.getDefaultInstance()) {
            this.comment_ = hdRadioComment;
        } else {
            this.comment_ = HdRadioComment.newBuilder(this.comment_).mergeFrom(hdRadioComment).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCommercial(HdRadioCommercial hdRadioCommercial) {
        hdRadioCommercial.getClass();
        HdRadioCommercial hdRadioCommercial2 = this.commercial_;
        if (hdRadioCommercial2 == null || hdRadioCommercial2 == HdRadioCommercial.getDefaultInstance()) {
            this.commercial_ = hdRadioCommercial;
        } else {
            this.commercial_ = HdRadioCommercial.newBuilder(this.commercial_).mergeFrom(hdRadioCommercial).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HdRadioPsdData parseDelimitedFrom(InputStream inputStream) {
        return (HdRadioPsdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioPsdData parseFrom(ByteBuffer byteBuffer) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HdRadioPsdData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbum(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.album_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbumBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.album_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtist(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.artist_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtistBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.artist_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtistExperience(HdRadioArtistExperience hdRadioArtistExperience) {
        hdRadioArtistExperience.getClass();
        this.artistExperience_ = hdRadioArtistExperience;
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setComment(HdRadioComment hdRadioComment) {
        hdRadioComment.getClass();
        this.comment_ = hdRadioComment;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommercial(HdRadioCommercial hdRadioCommercial) {
        hdRadioCommercial.getClass();
        this.commercial_ = hdRadioCommercial;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGenre(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.genre_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGenreBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.genre_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.title_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HdRadioPsdData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\t\u0004\u0006\t\u0005\u0007\t\u0006", new Object[]{"bitField0_", "title_", "artist_", "album_", "genre_", "comment_", "commercial_", "artistExperience_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HdRadioPsdData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HdRadioPsdData.class) {
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

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public String getAlbum() {
        return this.album_;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public ByteString getAlbumBytes() {
        return ByteString.copyFromUtf8(this.album_);
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public String getArtist() {
        return this.artist_;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public ByteString getArtistBytes() {
        return ByteString.copyFromUtf8(this.artist_);
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public HdRadioArtistExperience getArtistExperience() {
        HdRadioArtistExperience hdRadioArtistExperience = this.artistExperience_;
        return hdRadioArtistExperience == null ? HdRadioArtistExperience.getDefaultInstance() : hdRadioArtistExperience;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public HdRadioComment getComment() {
        HdRadioComment hdRadioComment = this.comment_;
        return hdRadioComment == null ? HdRadioComment.getDefaultInstance() : hdRadioComment;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public HdRadioCommercial getCommercial() {
        HdRadioCommercial hdRadioCommercial = this.commercial_;
        return hdRadioCommercial == null ? HdRadioCommercial.getDefaultInstance() : hdRadioCommercial;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public String getGenre() {
        return this.genre_;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public ByteString getGenreBytes() {
        return ByteString.copyFromUtf8(this.genre_);
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public boolean hasAlbum() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public boolean hasArtist() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public boolean hasArtistExperience() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public boolean hasComment() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public boolean hasCommercial() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public boolean hasGenre() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioPsdDataOrBuilder
    public boolean hasTitle() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(HdRadioPsdData hdRadioPsdData) {
        return DEFAULT_INSTANCE.createBuilder(hdRadioPsdData);
    }

    public static HdRadioPsdData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioPsdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioPsdData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HdRadioPsdData parseFrom(ByteString byteString) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HdRadioPsdData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtistExperience(HdRadioArtistExperience.Builder builder) {
        this.artistExperience_ = builder.build();
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setComment(HdRadioComment.Builder builder) {
        this.comment_ = builder.build();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommercial(HdRadioCommercial.Builder builder) {
        this.commercial_ = builder.build();
        this.bitField0_ |= 32;
    }

    public static HdRadioPsdData parseFrom(byte[] bArr) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HdRadioPsdData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HdRadioPsdData parseFrom(InputStream inputStream) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioPsdData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioPsdData parseFrom(CodedInputStream codedInputStream) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HdRadioPsdData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioPsdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
