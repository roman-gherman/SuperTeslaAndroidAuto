package a3;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends AbstractC0153p {
    public final String b;

    public a0(String str) {
        this.b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void o(int r9) {
        /*
            r0 = 4
            r1 = 1
            if (r9 == r1) goto L9
            if (r9 == r0) goto L9
            java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Lb
        L9:
            java.lang.String r2 = "@NotNull method %s.%s must not return null"
        Lb:
            r3 = 3
            r4 = 2
            if (r9 == r1) goto L13
            if (r9 == r0) goto L13
            r5 = r3
            goto L14
        L13:
            r5 = r4
        L14:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
            r7 = 0
            if (r9 == r1) goto L30
            if (r9 == r4) goto L2b
            if (r9 == r3) goto L26
            if (r9 == r0) goto L30
            java.lang.String r8 = "newAttributes"
            r5[r7] = r8
            goto L32
        L26:
            java.lang.String r8 = "kotlinTypeRefiner"
            r5[r7] = r8
            goto L32
        L2b:
            java.lang.String r8 = "delegate"
            r5[r7] = r8
            goto L32
        L30:
            r5[r7] = r6
        L32:
            java.lang.String r7 = "refine"
            if (r9 == r1) goto L3e
            if (r9 == r0) goto L3b
            r5[r1] = r6
            goto L42
        L3b:
            r5[r1] = r7
            goto L42
        L3e:
            java.lang.String r6 = "toString"
            r5[r1] = r6
        L42:
            if (r9 == r1) goto L56
            if (r9 == r4) goto L52
            if (r9 == r3) goto L4f
            if (r9 == r0) goto L56
            java.lang.String r3 = "replaceAttributes"
            r5[r4] = r3
            goto L56
        L4f:
            r5[r4] = r7
            goto L56
        L52:
            java.lang.String r3 = "replaceDelegate"
            r5[r4] = r3
        L56:
            java.lang.String r2 = java.lang.String.format(r2, r5)
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r2)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r2)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.a0.o(int):void");
    }

    @Override // a3.AbstractC0153p, a3.AbstractC0162z
    /* JADX INFO: renamed from: e */
    public final AbstractC0162z h(b3.d dVar) {
        if (dVar != null) {
            return this;
        }
        o(3);
        throw null;
    }

    @Override // a3.F, a3.c0
    public final /* bridge */ /* synthetic */ c0 g(boolean z6) {
        g(z6);
        throw null;
    }

    @Override // a3.AbstractC0153p, a3.c0
    public final c0 h(b3.d dVar) {
        if (dVar != null) {
            return this;
        }
        o(3);
        throw null;
    }

    @Override // a3.F, a3.c0
    public final /* bridge */ /* synthetic */ c0 i(M m6) {
        i(m6);
        throw null;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        throw new IllegalStateException(this.b);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M m6) {
        if (m6 != null) {
            throw new IllegalStateException(this.b);
        }
        o(0);
        throw null;
    }

    @Override // a3.AbstractC0153p
    public final F l() {
        throw new IllegalStateException(this.b);
    }

    @Override // a3.AbstractC0153p
    /* JADX INFO: renamed from: m */
    public final F e(b3.d dVar) {
        if (dVar != null) {
            return this;
        }
        o(3);
        throw null;
    }

    @Override // a3.AbstractC0153p
    public final AbstractC0153p n(F f6) {
        throw new IllegalStateException(this.b);
    }

    @Override // a3.F
    public final String toString() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        o(1);
        throw null;
    }
}
