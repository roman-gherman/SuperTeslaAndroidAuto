package org.mockito.internal.junit;

/* JADX INFO: loaded from: classes.dex */
class StubbingHint {
    private final StringBuilder hint;

    public StubbingHint(String str) {
        this.hint = B2.b.m("[MockitoHint] ", str, " (see javadoc for MockitoHint):");
    }

    public void appendLine(Object... objArr) {
        this.hint.append("\n[MockitoHint] ");
        for (Object obj : objArr) {
            this.hint.append(obj);
        }
    }

    public String toString() {
        return ((Object) this.hint) + "\n";
    }
}
