package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface ValueGraph<N, V> extends BaseGraph<N> {
    @Override // com.google.common.graph.BaseGraph
    Set<N> adjacentNodes(N n6);

    @Override // com.google.common.graph.BaseGraph
    boolean allowsSelfLoops();

    Graph<N> asGraph();

    @Override // com.google.common.graph.BaseGraph
    int degree(N n6);

    @NullableDecl
    V edgeValueOrDefault(b bVar, @NullableDecl V v6);

    @NullableDecl
    V edgeValueOrDefault(N n6, N n7, @NullableDecl V v6);

    @Override // com.google.common.graph.BaseGraph
    Set<b> edges();

    boolean equals(@NullableDecl Object obj);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(b bVar);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(N n6, N n7);

    int hashCode();

    @Override // com.google.common.graph.BaseGraph
    int inDegree(N n6);

    @Override // com.google.common.graph.BaseGraph
    Set<b> incidentEdges(N n6);

    @Override // com.google.common.graph.BaseGraph
    boolean isDirected();

    @Override // com.google.common.graph.BaseGraph
    a nodeOrder();

    @Override // com.google.common.graph.BaseGraph
    Set<N> nodes();

    @Override // com.google.common.graph.BaseGraph
    int outDegree(N n6);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n6);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n6);
}
