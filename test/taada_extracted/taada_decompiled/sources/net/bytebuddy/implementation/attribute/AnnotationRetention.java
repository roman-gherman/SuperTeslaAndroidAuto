package net.bytebuddy.implementation.attribute;

/* JADX INFO: loaded from: classes2.dex */
public enum AnnotationRetention {
    ENABLED(true),
    DISABLED(false);

    private final boolean enabled;

    AnnotationRetention(boolean z6) {
        this.enabled = z6;
    }

    public static AnnotationRetention of(boolean z6) {
        return z6 ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
