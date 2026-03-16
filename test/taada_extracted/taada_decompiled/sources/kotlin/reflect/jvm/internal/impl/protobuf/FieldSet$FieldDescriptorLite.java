package kotlin.reflect.jvm.internal.impl.protobuf;

import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$FieldDescriptorLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public interface FieldSet$FieldDescriptorLite<T extends FieldSet$FieldDescriptorLite<T>> extends Comparable<T> {
    N getLiteJavaType();

    M getLiteType();

    int getNumber();

    MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

    boolean isPacked();

    boolean isRepeated();
}
