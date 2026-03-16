package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes2.dex */
interface MACProvider {
    byte[] getMAC();

    void init();
}
