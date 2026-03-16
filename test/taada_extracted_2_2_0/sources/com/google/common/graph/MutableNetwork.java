package com.google.common.graph;

/* JADX INFO: loaded from: classes.dex */
public interface MutableNetwork<N, E> extends Network<N, E> {
    boolean addEdge(b bVar, E e);

    boolean addEdge(N n6, N n7, E e);

    boolean addNode(N n6);

    boolean removeEdge(E e);

    boolean removeNode(N n6);
}
