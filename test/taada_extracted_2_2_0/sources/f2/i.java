package F2;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends c {
    public final /* synthetic */ k b;

    public i(k kVar) {
        this.b = kVar;
    }

    @Override // F2.c
    public final void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1.visitEnd must not be null");
        }
        this.b.f358a.d = strArr;
    }
}
