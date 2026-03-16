package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface DFS$Neighbors<N> {
    @NotNull
    Iterable<? extends N> getNeighbors(N n6);
}
