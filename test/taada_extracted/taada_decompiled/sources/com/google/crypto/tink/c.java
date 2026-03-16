package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c implements KeyManagerRegistry$KeyManagerContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0.e f2792a;

    public c(C0.e eVar) {
        this.f2792a = eVar;
    }

    @Override // com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer
    public final Class getImplementingClass() {
        return this.f2792a.getClass();
    }

    @Override // com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer
    public final KeyManager getKeyManager(Class cls) throws GeneralSecurityException {
        try {
            return new B.h(this.f2792a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer
    public final KeyManager getUntypedKeyManager() {
        C0.e eVar = this.f2792a;
        return new B.h(eVar, eVar.c);
    }

    @Override // com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer
    public final MessageLite parseKey(AbstractC0381o abstractC0381o) {
        C0.e eVar = this.f2792a;
        MessageLite messageLiteF = eVar.f(abstractC0381o);
        eVar.g(messageLiteF);
        return messageLiteF;
    }

    @Override // com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer
    public final Class publicKeyManagerClassOrNull() {
        return null;
    }

    @Override // com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer
    public final Set supportedPrimitives() {
        return this.f2792a.b.keySet();
    }
}
