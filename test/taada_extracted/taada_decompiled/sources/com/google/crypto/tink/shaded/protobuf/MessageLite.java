package com.google.crypto.tink.shaded.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        Builder clone();

        boolean mergeDelimitedFrom(InputStream inputStream);

        boolean mergeDelimitedFrom(InputStream inputStream, D d);

        Builder mergeFrom(MessageLite messageLite);

        Builder mergeFrom(AbstractC0381o abstractC0381o);

        Builder mergeFrom(AbstractC0381o abstractC0381o, D d);

        Builder mergeFrom(AbstractC0388s abstractC0388s);

        Builder mergeFrom(AbstractC0388s abstractC0388s, D d);

        Builder mergeFrom(InputStream inputStream);

        Builder mergeFrom(InputStream inputStream, D d);

        Builder mergeFrom(byte[] bArr);

        Builder mergeFrom(byte[] bArr, int i, int i3);

        Builder mergeFrom(byte[] bArr, int i, int i3, D d);

        Builder mergeFrom(byte[] bArr, D d);
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    AbstractC0381o toByteString();

    void writeDelimitedTo(OutputStream outputStream);

    void writeTo(AbstractC0398x abstractC0398x);

    void writeTo(OutputStream outputStream);
}
