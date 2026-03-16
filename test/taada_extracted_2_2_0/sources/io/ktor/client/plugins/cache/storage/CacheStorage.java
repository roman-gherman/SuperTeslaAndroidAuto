package io.ktor.client.plugins.cache.storage;

import N1.m;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import n1.AbstractC0697b;
import n1.C0696a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u1.C0835D;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CacheStorage;", "", "Lu1/D;", "url", "Ln1/b;", "data", "LN1/m;", "store", "(Lu1/D;Ln1/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lu1/D;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lu1/D;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "n1/a", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CacheStorage {

    @NotNull
    public static final C0696a Companion = C0696a.f4224a;

    @Nullable
    Object find(@NotNull C0835D c0835d, @NotNull Map<String, String> map, @NotNull Continuation<? super AbstractC0697b> continuation);

    @Nullable
    Object findAll(@NotNull C0835D c0835d, @NotNull Continuation<? super Set<AbstractC0697b>> continuation);

    @Nullable
    Object store(@NotNull C0835D c0835d, @NotNull AbstractC0697b abstractC0697b, @NotNull Continuation<? super m> continuation);
}
