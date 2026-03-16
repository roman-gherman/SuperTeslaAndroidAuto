package com.google.common.collect;

/* JADX INFO: loaded from: classes.dex */
interface LinkedHashMultimap$ValueSetLink<K, V> {
    LinkedHashMultimap$ValueSetLink<K, V> getPredecessorInValueSet();

    LinkedHashMultimap$ValueSetLink<K, V> getSuccessorInValueSet();

    void setPredecessorInValueSet(LinkedHashMultimap$ValueSetLink<K, V> linkedHashMultimap$ValueSetLink);

    void setSuccessorInValueSet(LinkedHashMultimap$ValueSetLink<K, V> linkedHashMultimap$ValueSetLink);
}
