package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface JwtPublicKeyVerifyInternal {
    c verifyAndDecodeWithKid(String str, a aVar, Optional<String> optional);
}
