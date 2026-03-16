package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import l.d;
import n.c;
import n.f;

/* JADX INFO: loaded from: classes.dex */
public class CctBackendFactory implements BackendFactory {
    @Override // com.google.android.datatransport.runtime.backends.BackendFactory
    public TransportBackend create(f fVar) {
        c cVar = (c) fVar;
        return new d(cVar.f4160a, cVar.b, cVar.c);
    }
}
