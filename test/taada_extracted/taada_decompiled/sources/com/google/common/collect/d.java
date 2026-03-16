package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Comparable, Serializable {
    private static final long serialVersionUID = 0;

    public abstract int a(d dVar);

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        try {
            return a((d) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
