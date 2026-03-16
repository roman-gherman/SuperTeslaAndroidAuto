package org.mockito.internal.util.collections;

import org.mockito.internal.util.MockUtil;

/* JADX INFO: loaded from: classes.dex */
public class HashCodeAndEqualsMockWrapper {
    private final Object mockInstance;

    public HashCodeAndEqualsMockWrapper(Object obj) {
        this.mockInstance = obj;
    }

    public static HashCodeAndEqualsMockWrapper of(Object obj) {
        return new HashCodeAndEqualsMockWrapper(obj);
    }

    private String typeInstanceString() {
        return this.mockInstance.getClass().getSimpleName() + "(" + System.identityHashCode(this.mockInstance) + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HashCodeAndEqualsMockWrapper) && this.mockInstance == ((HashCodeAndEqualsMockWrapper) obj).mockInstance;
    }

    public Object get() {
        return this.mockInstance;
    }

    public int hashCode() {
        return System.identityHashCode(this.mockInstance);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HashCodeAndEqualsMockWrapper{mockInstance=");
        sb.append(MockUtil.isMock(this.mockInstance) ? MockUtil.getMockName(this.mockInstance) : typeInstanceString());
        sb.append('}');
        return sb.toString();
    }
}
