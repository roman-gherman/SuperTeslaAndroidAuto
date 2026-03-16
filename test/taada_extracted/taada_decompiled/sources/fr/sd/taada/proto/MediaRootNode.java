package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.MediaSource;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaRootNode extends GeneratedMessageLite<MediaRootNode, Builder> implements MediaRootNodeOrBuilder {
    private static final MediaRootNode DEFAULT_INSTANCE;
    public static final int MEDIA_SOURCES_FIELD_NUMBER = 2;
    private static volatile Parser<MediaRootNode> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String path_ = "";
    private Internal.ProtobufList<MediaSource> mediaSources_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaRootNode$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaRootNode, Builder> implements MediaRootNodeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllMediaSources(Iterable<? extends MediaSource> iterable) {
            copyOnWrite();
            ((MediaRootNode) this.instance).addAllMediaSources(iterable);
            return this;
        }

        public Builder addMediaSources(MediaSource mediaSource) {
            copyOnWrite();
            ((MediaRootNode) this.instance).addMediaSources(mediaSource);
            return this;
        }

        public Builder clearMediaSources() {
            copyOnWrite();
            ((MediaRootNode) this.instance).clearMediaSources();
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((MediaRootNode) this.instance).clearPath();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
        public MediaSource getMediaSources(int i) {
            return ((MediaRootNode) this.instance).getMediaSources(i);
        }

        @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
        public int getMediaSourcesCount() {
            return ((MediaRootNode) this.instance).getMediaSourcesCount();
        }

        @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
        public List<MediaSource> getMediaSourcesList() {
            return Collections.unmodifiableList(((MediaRootNode) this.instance).getMediaSourcesList());
        }

        @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
        public String getPath() {
            return ((MediaRootNode) this.instance).getPath();
        }

        @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
        public ByteString getPathBytes() {
            return ((MediaRootNode) this.instance).getPathBytes();
        }

        @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
        public boolean hasPath() {
            return ((MediaRootNode) this.instance).hasPath();
        }

        public Builder removeMediaSources(int i) {
            copyOnWrite();
            ((MediaRootNode) this.instance).removeMediaSources(i);
            return this;
        }

        public Builder setMediaSources(int i, MediaSource mediaSource) {
            copyOnWrite();
            ((MediaRootNode) this.instance).setMediaSources(i, mediaSource);
            return this;
        }

        public Builder setPath(String str) {
            copyOnWrite();
            ((MediaRootNode) this.instance).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaRootNode) this.instance).setPathBytes(byteString);
            return this;
        }

        private Builder() {
            super(MediaRootNode.DEFAULT_INSTANCE);
        }

        public Builder addMediaSources(int i, MediaSource mediaSource) {
            copyOnWrite();
            ((MediaRootNode) this.instance).addMediaSources(i, mediaSource);
            return this;
        }

        public Builder setMediaSources(int i, MediaSource.Builder builder) {
            copyOnWrite();
            ((MediaRootNode) this.instance).setMediaSources(i, builder);
            return this;
        }

        public Builder addMediaSources(MediaSource.Builder builder) {
            copyOnWrite();
            ((MediaRootNode) this.instance).addMediaSources(builder);
            return this;
        }

        public Builder addMediaSources(int i, MediaSource.Builder builder) {
            copyOnWrite();
            ((MediaRootNode) this.instance).addMediaSources(i, builder);
            return this;
        }
    }

    static {
        MediaRootNode mediaRootNode = new MediaRootNode();
        DEFAULT_INSTANCE = mediaRootNode;
        GeneratedMessageLite.registerDefaultInstance(MediaRootNode.class, mediaRootNode);
    }

    private MediaRootNode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMediaSources(Iterable<? extends MediaSource> iterable) {
        ensureMediaSourcesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.mediaSources_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMediaSources(MediaSource mediaSource) {
        mediaSource.getClass();
        ensureMediaSourcesIsMutable();
        this.mediaSources_.add(mediaSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaSources() {
        this.mediaSources_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.bitField0_ &= -2;
        this.path_ = getDefaultInstance().getPath();
    }

    private void ensureMediaSourcesIsMutable() {
        if (this.mediaSources_.isModifiable()) {
            return;
        }
        this.mediaSources_ = GeneratedMessageLite.mutableCopy(this.mediaSources_);
    }

    public static MediaRootNode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaRootNode parseDelimitedFrom(InputStream inputStream) {
        return (MediaRootNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaRootNode parseFrom(ByteBuffer byteBuffer) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaRootNode> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMediaSources(int i) {
        ensureMediaSourcesIsMutable();
        this.mediaSources_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSources(int i, MediaSource mediaSource) {
        mediaSource.getClass();
        ensureMediaSourcesIsMutable();
        this.mediaSources_.set(i, mediaSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPath(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.path_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.path_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaRootNode();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001Ԉ\u0000\u0002Л", new Object[]{"bitField0_", "path_", "mediaSources_", MediaSource.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaRootNode> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaRootNode.class) {
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

    @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
    public MediaSource getMediaSources(int i) {
        return this.mediaSources_.get(i);
    }

    @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
    public int getMediaSourcesCount() {
        return this.mediaSources_.size();
    }

    @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
    public List<MediaSource> getMediaSourcesList() {
        return this.mediaSources_;
    }

    public MediaSourceOrBuilder getMediaSourcesOrBuilder(int i) {
        return this.mediaSources_.get(i);
    }

    public List<? extends MediaSourceOrBuilder> getMediaSourcesOrBuilderList() {
        return this.mediaSources_;
    }

    @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // fr.sd.taada.proto.MediaRootNodeOrBuilder
    public boolean hasPath() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MediaRootNode mediaRootNode) {
        return DEFAULT_INSTANCE.createBuilder(mediaRootNode);
    }

    public static MediaRootNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaRootNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaRootNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaRootNode parseFrom(ByteString byteString) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMediaSources(int i, MediaSource mediaSource) {
        mediaSource.getClass();
        ensureMediaSourcesIsMutable();
        this.mediaSources_.add(i, mediaSource);
    }

    public static MediaRootNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSources(int i, MediaSource.Builder builder) {
        ensureMediaSourcesIsMutable();
        this.mediaSources_.set(i, builder.build());
    }

    public static MediaRootNode parseFrom(byte[] bArr) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaRootNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMediaSources(MediaSource.Builder builder) {
        ensureMediaSourcesIsMutable();
        this.mediaSources_.add(builder.build());
    }

    public static MediaRootNode parseFrom(InputStream inputStream) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaRootNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMediaSources(int i, MediaSource.Builder builder) {
        ensureMediaSourcesIsMutable();
        this.mediaSources_.add(i, builder.build());
    }

    public static MediaRootNode parseFrom(CodedInputStream codedInputStream) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaRootNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaRootNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
