package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes.dex */
@Immutable
interface HpkeKemPrivateKey {
    I0.a getSerializedPrivate();

    I0.a getSerializedPublic();
}
