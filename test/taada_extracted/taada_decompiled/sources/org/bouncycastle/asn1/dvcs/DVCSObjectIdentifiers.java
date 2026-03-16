package org.bouncycastle.asn1.dvcs;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface DVCSObjectIdentifiers {
    public static final C0896n id_aa_dvcs_dvc;
    public static final C0896n id_ad_dvcs;
    public static final C0896n id_ct_DVCSRequestData;
    public static final C0896n id_ct_DVCSResponseData;
    public static final C0896n id_kp_dvcs;
    public static final C0896n id_pkix;
    public static final C0896n id_smime;

    static {
        C0896n c0896n = new C0896n("1.3.6.1.5.5.7");
        id_pkix = c0896n;
        C0896n c0896n2 = new C0896n("1.2.840.113549.1.9.16");
        id_smime = c0896n2;
        id_ad_dvcs = c0896n.j("48.4");
        id_kp_dvcs = c0896n.j("3.10");
        id_ct_DVCSRequestData = c0896n2.j("1.7");
        id_ct_DVCSResponseData = c0896n2.j("1.8");
        id_aa_dvcs_dvc = c0896n2.j("2.29");
    }
}
