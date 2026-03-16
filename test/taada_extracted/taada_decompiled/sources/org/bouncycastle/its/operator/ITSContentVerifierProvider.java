package org.bouncycastle.its.operator;

import T3.a;
import org.bouncycastle.operator.ContentVerifier;

/* JADX INFO: loaded from: classes2.dex */
public interface ITSContentVerifierProvider {
    ContentVerifier get(int i);

    a getAssociatedCertificate();

    boolean hasAssociatedCertificate();
}
