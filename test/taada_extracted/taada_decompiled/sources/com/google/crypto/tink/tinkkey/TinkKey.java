package com.google.crypto.tink.tinkkey;

import com.google.crypto.tink.f;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes.dex */
@Immutable
@Deprecated
public interface TinkKey {
    f getKeyTemplate();

    boolean hasSecret();
}
