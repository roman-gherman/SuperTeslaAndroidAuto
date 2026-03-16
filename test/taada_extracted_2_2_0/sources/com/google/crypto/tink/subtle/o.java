package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o implements EngineFactory$Policy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2965a;
    public final EngineWrapper b;

    public /* synthetic */ o(EngineWrapper engineWrapper, int i) {
        this.f2965a = i;
        this.b = engineWrapper;
    }

    @Override // com.google.crypto.tink.subtle.EngineFactory$Policy
    public final Object getInstance(String str) throws GeneralSecurityException {
        switch (this.f2965a) {
            case 0:
                String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 2; i++) {
                    Provider provider = Security.getProvider(strArr[i]);
                    if (provider != null) {
                        arrayList.add(provider);
                    }
                }
                Iterator it = arrayList.iterator();
                Exception exc = null;
                while (true) {
                    boolean zHasNext = it.hasNext();
                    EngineWrapper engineWrapper = this.b;
                    if (!zHasNext) {
                        return engineWrapper.getInstance(str, null);
                    }
                    try {
                        return engineWrapper.getInstance(str, (Provider) it.next());
                    } catch (Exception e) {
                        if (exc == null) {
                            exc = e;
                        }
                    }
                }
                break;
            case 1:
                return this.b.getInstance(str, null);
            default:
                String[] strArr2 = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < 3; i3++) {
                    Provider provider2 = Security.getProvider(strArr2[i3]);
                    if (provider2 != null) {
                        arrayList2.add(provider2);
                    }
                }
                Iterator it2 = arrayList2.iterator();
                Exception exc2 = null;
                while (it2.hasNext()) {
                    try {
                        return this.b.getInstance(str, (Provider) it2.next());
                    } catch (Exception e6) {
                        if (exc2 == null) {
                            exc2 = e6;
                        }
                    }
                }
                throw new GeneralSecurityException("No good Provider found.", exc2);
        }
    }

    @Override // com.google.crypto.tink.subtle.EngineFactory$Policy
    public final Object getInstance(String str, List list) {
        switch (this.f2965a) {
            case 0:
                return getInstance(str);
            case 1:
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        return this.b.getInstance(str, (Provider) it.next());
                    } catch (Exception unused) {
                    }
                }
                return getInstance(str);
            default:
                return getInstance(str);
        }
    }
}
