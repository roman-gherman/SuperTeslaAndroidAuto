package com.google.common.graph;

/* JADX INFO: loaded from: classes.dex */
public interface MutableGraph<N> extends Graph<N> {
    boolean addNode(N n6);

    boolean putEdge(b bVar);

    boolean putEdge(N n6, N n7);

    boolean removeEdge(b bVar);

    boolean removeEdge(N n6, N n7);

    boolean removeNode(N n6);
}
