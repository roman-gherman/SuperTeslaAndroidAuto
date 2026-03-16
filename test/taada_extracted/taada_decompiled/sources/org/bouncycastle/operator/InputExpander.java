package org.bouncycastle.operator;

import H3.a;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface InputExpander {
    a getAlgorithmIdentifier();

    InputStream getInputStream(InputStream inputStream);
}
