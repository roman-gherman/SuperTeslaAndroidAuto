package org.bouncycastle.internal.asn1.edec;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface EdECObjectIdentifiers {
    public static final C0896n id_Ed25519;
    public static final C0896n id_Ed448;
    public static final C0896n id_X25519;
    public static final C0896n id_X448;
    public static final C0896n id_edwards_curve_algs;

    static {
        C0896n c0896n = new C0896n("1.3.101");
        id_edwards_curve_algs = c0896n;
        id_X25519 = c0896n.j("110").n();
        id_X448 = c0896n.j("111").n();
        id_Ed25519 = c0896n.j("112").n();
        id_Ed448 = c0896n.j("113").n();
    }
}
