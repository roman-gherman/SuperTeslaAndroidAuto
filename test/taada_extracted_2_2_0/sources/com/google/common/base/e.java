package com.google.common.base;

import c4.AbstractC0246d;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes.dex */
public enum e extends f {
    @Override // com.google.common.base.f
    public final String b(f fVar, String str) {
        return fVar == f.c ? AbstractC0246d.J0(str.replace('_', SignatureVisitor.SUPER)) : fVar == f.d ? AbstractC0246d.J0(str) : super.b(fVar, str);
    }

    @Override // com.google.common.base.f
    public final String d(String str) {
        return AbstractC0246d.K0(str);
    }
}
