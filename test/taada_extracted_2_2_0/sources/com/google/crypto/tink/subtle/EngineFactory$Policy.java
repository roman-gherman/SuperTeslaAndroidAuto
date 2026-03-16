package com.google.crypto.tink.subtle;

import java.security.Provider;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface EngineFactory$Policy<JcePrimitiveT> {
    JcePrimitiveT getInstance(String str);

    JcePrimitiveT getInstance(String str, List<Provider> list);
}
