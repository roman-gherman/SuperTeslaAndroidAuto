package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N n6);

    boolean allowsSelfLoops();

    int degree(N n6);

    Set<b> edges();

    boolean hasEdgeConnecting(b bVar);

    boolean hasEdgeConnecting(N n6, N n7);

    int inDegree(N n6);

    Set<b> incidentEdges(N n6);

    boolean isDirected();

    a nodeOrder();

    Set<N> nodes();

    int outDegree(N n6);

    @Override // com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n6);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n6);
}
