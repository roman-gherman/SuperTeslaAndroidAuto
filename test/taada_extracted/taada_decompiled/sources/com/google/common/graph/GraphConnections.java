package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
interface GraphConnections<N, V> {
    void addPredecessor(N n6, V v6);

    V addSuccessor(N n6, V v6);

    Set<N> adjacentNodes();

    Set<N> predecessors();

    void removePredecessor(N n6);

    V removeSuccessor(N n6);

    Set<N> successors();

    @NullableDecl
    V value(N n6);
}
