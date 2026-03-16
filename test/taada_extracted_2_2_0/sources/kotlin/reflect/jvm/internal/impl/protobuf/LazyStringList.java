package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(AbstractC0604e abstractC0604e);

    AbstractC0604e getByteString(int i);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
