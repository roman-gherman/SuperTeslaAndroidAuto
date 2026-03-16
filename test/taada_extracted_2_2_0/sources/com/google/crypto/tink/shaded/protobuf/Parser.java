package com.google.crypto.tink.shaded.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream);

    MessageType parseDelimitedFrom(InputStream inputStream, D d);

    MessageType parseFrom(AbstractC0381o abstractC0381o);

    MessageType parseFrom(AbstractC0381o abstractC0381o, D d);

    MessageType parseFrom(AbstractC0388s abstractC0388s);

    MessageType parseFrom(AbstractC0388s abstractC0388s, D d);

    MessageType parseFrom(InputStream inputStream);

    MessageType parseFrom(InputStream inputStream, D d);

    MessageType parseFrom(ByteBuffer byteBuffer);

    MessageType parseFrom(ByteBuffer byteBuffer, D d);

    MessageType parseFrom(byte[] bArr);

    MessageType parseFrom(byte[] bArr, int i, int i3);

    MessageType parseFrom(byte[] bArr, int i, int i3, D d);

    MessageType parseFrom(byte[] bArr, D d);

    MessageType parsePartialDelimitedFrom(InputStream inputStream);

    MessageType parsePartialDelimitedFrom(InputStream inputStream, D d);

    MessageType parsePartialFrom(AbstractC0381o abstractC0381o);

    MessageType parsePartialFrom(AbstractC0381o abstractC0381o, D d);

    MessageType parsePartialFrom(AbstractC0388s abstractC0388s);

    MessageType parsePartialFrom(AbstractC0388s abstractC0388s, D d);

    MessageType parsePartialFrom(InputStream inputStream);

    MessageType parsePartialFrom(InputStream inputStream, D d);

    MessageType parsePartialFrom(byte[] bArr);

    MessageType parsePartialFrom(byte[] bArr, int i, int i3);

    MessageType parsePartialFrom(byte[] bArr, int i, int i3, D d);

    MessageType parsePartialFrom(byte[] bArr, D d);
}
