package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream, C0608i c0608i);

    MessageType parseFrom(InputStream inputStream, C0608i c0608i);

    MessageType parseFrom(AbstractC0604e abstractC0604e, C0608i c0608i);

    MessageType parsePartialFrom(C0605f c0605f, C0608i c0608i);
}
