package org.bouncycastle.cms;

import java.io.InputStream;
import w3.AbstractC0904w;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
interface CMSSecureReadable {
    AbstractC0904w getAuthAttrSet();

    C0896n getContentType();

    InputStream getInputStream();

    boolean hasAdditionalData();

    void setAuthAttrSet(AbstractC0904w abstractC0904w);
}
