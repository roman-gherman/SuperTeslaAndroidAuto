package org.bouncycastle.operator;

import H3.a;

/* JADX INFO: loaded from: classes2.dex */
public interface ContentVerifierProvider {
    ContentVerifier get(a aVar);

    J3.a getAssociatedCertificate();

    boolean hasAssociatedCertificate();
}
