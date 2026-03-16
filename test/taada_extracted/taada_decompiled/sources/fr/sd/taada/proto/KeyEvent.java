package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyEvent extends GeneratedMessageLite<KeyEvent, Builder> implements KeyEventOrBuilder {
    private static final KeyEvent DEFAULT_INSTANCE;
    public static final int KEYS_FIELD_NUMBER = 1;
    private static volatile Parser<KeyEvent> PARSER;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Key> keys_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.KeyEvent$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<KeyEvent, Builder> implements KeyEventOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllKeys(Iterable<? extends Key> iterable) {
            copyOnWrite();
            ((KeyEvent) this.instance).addAllKeys(iterable);
            return this;
        }

        public Builder addKeys(Key key) {
            copyOnWrite();
            ((KeyEvent) this.instance).addKeys(key);
            return this;
        }

        public Builder clearKeys() {
            copyOnWrite();
            ((KeyEvent) this.instance).clearKeys();
            return this;
        }

        @Override // fr.sd.taada.proto.KeyEventOrBuilder
        public Key getKeys(int i) {
            return ((KeyEvent) this.instance).getKeys(i);
        }

        @Override // fr.sd.taada.proto.KeyEventOrBuilder
        public int getKeysCount() {
            return ((KeyEvent) this.instance).getKeysCount();
        }

        @Override // fr.sd.taada.proto.KeyEventOrBuilder
        public List<Key> getKeysList() {
            return Collections.unmodifiableList(((KeyEvent) this.instance).getKeysList());
        }

        public Builder removeKeys(int i) {
            copyOnWrite();
            ((KeyEvent) this.instance).removeKeys(i);
            return this;
        }

        public Builder setKeys(int i, Key key) {
            copyOnWrite();
            ((KeyEvent) this.instance).setKeys(i, key);
            return this;
        }

        private Builder() {
            super(KeyEvent.DEFAULT_INSTANCE);
        }

        public Builder addKeys(int i, Key key) {
            copyOnWrite();
            ((KeyEvent) this.instance).addKeys(i, key);
            return this;
        }

        public Builder setKeys(int i, Key.Builder builder) {
            copyOnWrite();
            ((KeyEvent) this.instance).setKeys(i, builder);
            return this;
        }

        public Builder addKeys(Key.Builder builder) {
            copyOnWrite();
            ((KeyEvent) this.instance).addKeys(builder);
            return this;
        }

        public Builder addKeys(int i, Key.Builder builder) {
            copyOnWrite();
            ((KeyEvent) this.instance).addKeys(i, builder);
            return this;
        }
    }

    public static final class Key extends GeneratedMessageLite<Key, Builder> implements KeyOrBuilder {
        private static final Key DEFAULT_INSTANCE;
        public static final int DOWN_FIELD_NUMBER = 2;
        public static final int KEYCODE_FIELD_NUMBER = 1;
        public static final int LONGPRESS_FIELD_NUMBER = 4;
        public static final int METASTATE_FIELD_NUMBER = 3;
        private static volatile Parser<Key> PARSER;
        private int bitField0_;
        private boolean down_;
        private int keycode_;
        private boolean longpress_;
        private byte memoizedIsInitialized = 2;
        private int metastate_;

        public static final class Builder extends GeneratedMessageLite.Builder<Key, Builder> implements KeyOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDown() {
                copyOnWrite();
                ((Key) this.instance).clearDown();
                return this;
            }

            public Builder clearKeycode() {
                copyOnWrite();
                ((Key) this.instance).clearKeycode();
                return this;
            }

            public Builder clearLongpress() {
                copyOnWrite();
                ((Key) this.instance).clearLongpress();
                return this;
            }

            public Builder clearMetastate() {
                copyOnWrite();
                ((Key) this.instance).clearMetastate();
                return this;
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public boolean getDown() {
                return ((Key) this.instance).getDown();
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public int getKeycode() {
                return ((Key) this.instance).getKeycode();
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public boolean getLongpress() {
                return ((Key) this.instance).getLongpress();
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public int getMetastate() {
                return ((Key) this.instance).getMetastate();
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public boolean hasDown() {
                return ((Key) this.instance).hasDown();
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public boolean hasKeycode() {
                return ((Key) this.instance).hasKeycode();
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public boolean hasLongpress() {
                return ((Key) this.instance).hasLongpress();
            }

            @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
            public boolean hasMetastate() {
                return ((Key) this.instance).hasMetastate();
            }

            public Builder setDown(boolean z6) {
                copyOnWrite();
                ((Key) this.instance).setDown(z6);
                return this;
            }

            public Builder setKeycode(int i) {
                copyOnWrite();
                ((Key) this.instance).setKeycode(i);
                return this;
            }

            public Builder setLongpress(boolean z6) {
                copyOnWrite();
                ((Key) this.instance).setLongpress(z6);
                return this;
            }

            public Builder setMetastate(int i) {
                copyOnWrite();
                ((Key) this.instance).setMetastate(i);
                return this;
            }

            private Builder() {
                super(Key.DEFAULT_INSTANCE);
            }
        }

        static {
            Key key = new Key();
            DEFAULT_INSTANCE = key;
            GeneratedMessageLite.registerDefaultInstance(Key.class, key);
        }

        private Key() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDown() {
            this.bitField0_ &= -3;
            this.down_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeycode() {
            this.bitField0_ &= -2;
            this.keycode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLongpress() {
            this.bitField0_ &= -9;
            this.longpress_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetastate() {
            this.bitField0_ &= -5;
            this.metastate_ = 0;
        }

        public static Key getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Key parseDelimitedFrom(InputStream inputStream) {
            return (Key) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Key parseFrom(ByteBuffer byteBuffer) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Key> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDown(boolean z6) {
            this.bitField0_ |= 2;
            this.down_ = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeycode(int i) {
            this.bitField0_ |= 1;
            this.keycode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLongpress(boolean z6) {
            this.bitField0_ |= 8;
            this.longpress_ = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetastate(int i) {
            this.bitField0_ |= 4;
            this.metastate_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Key();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0003\u0001ԋ\u0000\u0002ԇ\u0001\u0003ԋ\u0002\u0004\u0007\u0003", new Object[]{"bitField0_", "keycode_", "down_", "metastate_", "longpress_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Key> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Key.class) {
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

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public boolean getDown() {
            return this.down_;
        }

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public int getKeycode() {
            return this.keycode_;
        }

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public boolean getLongpress() {
            return this.longpress_;
        }

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public int getMetastate() {
            return this.metastate_;
        }

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public boolean hasDown() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public boolean hasKeycode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public boolean hasLongpress() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // fr.sd.taada.proto.KeyEvent.KeyOrBuilder
        public boolean hasMetastate() {
            return (this.bitField0_ & 4) != 0;
        }

        public static Builder newBuilder(Key key) {
            return DEFAULT_INSTANCE.createBuilder(key);
        }

        public static Key parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Key) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Key parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Key parseFrom(ByteString byteString) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Key parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Key parseFrom(byte[] bArr) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Key parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Key parseFrom(InputStream inputStream) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Key parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Key parseFrom(CodedInputStream codedInputStream) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Key parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface KeyOrBuilder extends MessageLiteOrBuilder {
        boolean getDown();

        int getKeycode();

        boolean getLongpress();

        int getMetastate();

        boolean hasDown();

        boolean hasKeycode();

        boolean hasLongpress();

        boolean hasMetastate();
    }

    static {
        KeyEvent keyEvent = new KeyEvent();
        DEFAULT_INSTANCE = keyEvent;
        GeneratedMessageLite.registerDefaultInstance(KeyEvent.class, keyEvent);
    }

    private KeyEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKeys(Iterable<? extends Key> iterable) {
        ensureKeysIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.keys_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeys(Key key) {
        key.getClass();
        ensureKeysIsMutable();
        this.keys_.add(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeys() {
        this.keys_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureKeysIsMutable() {
        if (this.keys_.isModifiable()) {
            return;
        }
        this.keys_ = GeneratedMessageLite.mutableCopy(this.keys_);
    }

    public static KeyEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static KeyEvent parseDelimitedFrom(InputStream inputStream) {
        return (KeyEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeyEvent parseFrom(ByteBuffer byteBuffer) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<KeyEvent> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeKeys(int i) {
        ensureKeysIsMutable();
        this.keys_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeys(int i, Key key) {
        key.getClass();
        ensureKeysIsMutable();
        this.keys_.set(i, key);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new KeyEvent();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"keys_", Key.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeyEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (KeyEvent.class) {
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

    @Override // fr.sd.taada.proto.KeyEventOrBuilder
    public Key getKeys(int i) {
        return this.keys_.get(i);
    }

    @Override // fr.sd.taada.proto.KeyEventOrBuilder
    public int getKeysCount() {
        return this.keys_.size();
    }

    @Override // fr.sd.taada.proto.KeyEventOrBuilder
    public List<Key> getKeysList() {
        return this.keys_;
    }

    public KeyOrBuilder getKeysOrBuilder(int i) {
        return this.keys_.get(i);
    }

    public List<? extends KeyOrBuilder> getKeysOrBuilderList() {
        return this.keys_;
    }

    public static Builder newBuilder(KeyEvent keyEvent) {
        return DEFAULT_INSTANCE.createBuilder(keyEvent);
    }

    public static KeyEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KeyEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static KeyEvent parseFrom(ByteString byteString) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeys(int i, Key key) {
        key.getClass();
        ensureKeysIsMutable();
        this.keys_.add(i, key);
    }

    public static KeyEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeys(int i, Key.Builder builder) {
        ensureKeysIsMutable();
        this.keys_.set(i, builder.build());
    }

    public static KeyEvent parseFrom(byte[] bArr) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KeyEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeys(Key.Builder builder) {
        ensureKeysIsMutable();
        this.keys_.add(builder.build());
    }

    public static KeyEvent parseFrom(InputStream inputStream) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeyEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeys(int i, Key.Builder builder) {
        ensureKeysIsMutable();
        this.keys_.add(i, builder.build());
    }

    public static KeyEvent parseFrom(CodedInputStream codedInputStream) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static KeyEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
