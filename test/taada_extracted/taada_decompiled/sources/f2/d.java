package F2;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {
    public final /* synthetic */ f b;

    public d(f fVar) {
        this.b = fVar;
    }

    @Override // F2.c
    public final void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1.visitEnd must not be null");
        }
        this.b.f356a.d = strArr;
    }
}
