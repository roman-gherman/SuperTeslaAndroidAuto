package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
interface NetworkConnections<N, E> {
    void addInEdge(E e, N n6, boolean z6);

    void addOutEdge(E e, N n6);

    N adjacentNode(E e);

    Set<N> adjacentNodes();

    Set<E> edgesConnecting(N n6);

    Set<E> inEdges();

    Set<E> incidentEdges();

    Set<E> outEdges();

    Set<N> predecessors();

    N removeInEdge(E e, boolean z6);

    N removeOutEdge(E e);

    Set<N> successors();
}
