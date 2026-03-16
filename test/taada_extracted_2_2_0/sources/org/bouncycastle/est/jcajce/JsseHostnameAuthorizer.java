package org.bouncycastle.est.jcajce;

import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public interface JsseHostnameAuthorizer {
    boolean verified(String str, SSLSession sSLSession);
}
