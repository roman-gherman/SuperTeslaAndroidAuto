package org.bouncycastle.asn1.x509;

import H3.b;
import H3.c;

/* JADX INFO: loaded from: classes2.dex */
public interface NameConstraintValidator {
    void addExcludedSubtree(c cVar);

    void checkExcluded(b bVar);

    void checkPermitted(b bVar);

    void intersectEmptyPermittedSubtree(int i);

    void intersectPermittedSubtree(c cVar);

    void intersectPermittedSubtree(c[] cVarArr);
}
