package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E e);

    Set<N> adjacentNodes(N n6);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n6);

    @NullableDecl
    E edgeConnectingOrNull(b bVar);

    @NullableDecl
    E edgeConnectingOrNull(N n6, N n7);

    a edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(b bVar);

    Set<E> edgesConnecting(N n6, N n7);

    boolean equals(@NullableDecl Object obj);

    boolean hasEdgeConnecting(b bVar);

    boolean hasEdgeConnecting(N n6, N n7);

    int hashCode();

    int inDegree(N n6);

    Set<E> inEdges(N n6);

    Set<E> incidentEdges(N n6);

    b incidentNodes(E e);

    boolean isDirected();

    a nodeOrder();

    Set<N> nodes();

    int outDegree(N n6);

    Set<E> outEdges(N n6);

    @Override // com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n6);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n6);
}
