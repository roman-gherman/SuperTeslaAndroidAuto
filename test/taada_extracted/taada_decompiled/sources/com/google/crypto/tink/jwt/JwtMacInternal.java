package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
@Immutable
interface JwtMacInternal {
    String computeMacAndEncodeWithKid(b bVar, Optional<String> optional);

    c verifyMacAndDecodeWithKid(String str, a aVar, Optional<String> optional);
}
