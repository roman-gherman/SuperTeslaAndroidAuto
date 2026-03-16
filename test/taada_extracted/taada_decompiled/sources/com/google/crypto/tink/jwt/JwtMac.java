package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface JwtMac {
    String computeMacAndEncode(b bVar);

    c verifyMacAndDecode(String str, a aVar);
}
