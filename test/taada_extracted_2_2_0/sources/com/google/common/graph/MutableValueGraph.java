package com.google.common.graph;

/* JADX INFO: loaded from: classes.dex */
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    boolean addNode(N n6);

    V putEdgeValue(b bVar, V v6);

    V putEdgeValue(N n6, N n7, V v6);

    V removeEdge(b bVar);

    V removeEdge(N n6, N n7);

    boolean removeNode(N n6);
}
