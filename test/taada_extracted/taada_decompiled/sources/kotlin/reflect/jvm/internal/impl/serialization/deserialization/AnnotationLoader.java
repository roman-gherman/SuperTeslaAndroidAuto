package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import G2.C0120u;
import G2.H;
import G2.U;
import G2.Z;
import G2.d0;
import X2.a;
import X2.p;
import X2.r;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface AnnotationLoader<A> {
    @NotNull
    List<A> loadCallableAnnotations(@NotNull r rVar, @NotNull MessageLite messageLite, @NotNull a aVar);

    @NotNull
    List<A> loadClassAnnotations(@NotNull p pVar);

    @NotNull
    List<A> loadEnumEntryAnnotations(@NotNull r rVar, @NotNull C0120u c0120u);

    @NotNull
    List<A> loadExtensionReceiverParameterAnnotations(@NotNull r rVar, @NotNull MessageLite messageLite, @NotNull a aVar);

    @NotNull
    List<A> loadPropertyBackingFieldAnnotations(@NotNull r rVar, @NotNull H h3);

    @NotNull
    List<A> loadPropertyDelegateFieldAnnotations(@NotNull r rVar, @NotNull H h3);

    @NotNull
    List<A> loadTypeAnnotations(@NotNull U u, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadTypeParameterAnnotations(@NotNull Z z6, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadValueParameterAnnotations(@NotNull r rVar, @NotNull MessageLite messageLite, @NotNull a aVar, int i, @NotNull d0 d0Var);
}
