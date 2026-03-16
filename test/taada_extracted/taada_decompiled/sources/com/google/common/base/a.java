package com.google.common.base;

import c4.AbstractC0246d;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes.dex */
public enum a extends f {
    @Override // com.google.common.base.f
    public final String b(f fVar, String str) {
        return fVar == f.d ? str.replace(SignatureVisitor.SUPER, '_') : fVar == f.f2769f ? AbstractC0246d.K0(str.replace(SignatureVisitor.SUPER, '_')) : super.b(fVar, str);
    }

    @Override // com.google.common.base.f
    public final String d(String str) {
        return AbstractC0246d.J0(str);
    }
}
