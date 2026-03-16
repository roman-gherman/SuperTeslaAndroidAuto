package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: loaded from: classes2.dex */
public interface DFS$NodeHandler<N, R> {
    void afterChildren(N n6);

    boolean beforeChildren(N n6);

    R result();
}
