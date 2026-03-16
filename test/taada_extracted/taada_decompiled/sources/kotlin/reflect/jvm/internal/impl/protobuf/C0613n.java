package kotlin.reflect.jvm.internal.impl.protobuf;

import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0613n implements FieldSet$FieldDescriptorLite {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3871a;
    public final M b;
    public final boolean c;

    public C0613n(int i, M m6, boolean z6) {
        this.f3871a = i;
        this.b = m6;
        this.c = z6;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3871a - ((C0613n) obj).f3871a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$FieldDescriptorLite
    public final N getLiteJavaType() {
        return this.b.f3851a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$FieldDescriptorLite
    public final M getLiteType() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$FieldDescriptorLite
    public final int getNumber() {
        return this.f3871a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$FieldDescriptorLite
    public final MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
        return ((AbstractC0610k) builder).a((p) messageLite);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$FieldDescriptorLite
    public final boolean isPacked() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$FieldDescriptorLite
    public final boolean isRepeated() {
        return this.c;
    }
}
