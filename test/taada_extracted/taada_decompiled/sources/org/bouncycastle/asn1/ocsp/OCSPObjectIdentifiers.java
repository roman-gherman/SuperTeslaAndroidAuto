package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface OCSPObjectIdentifiers {
    public static final C0896n id_pkix_ocsp;
    public static final C0896n id_pkix_ocsp_archive_cutoff;
    public static final C0896n id_pkix_ocsp_basic;
    public static final C0896n id_pkix_ocsp_crl;
    public static final C0896n id_pkix_ocsp_extended_revoke;
    public static final C0896n id_pkix_ocsp_nocheck;
    public static final C0896n id_pkix_ocsp_nonce;
    public static final C0896n id_pkix_ocsp_pref_sig_algs;
    public static final C0896n id_pkix_ocsp_response;
    public static final C0896n id_pkix_ocsp_service_locator;

    static {
        C0896n c0896n = X509ObjectIdentifiers.id_ad_ocsp;
        id_pkix_ocsp = c0896n;
        id_pkix_ocsp_basic = c0896n.j("1");
        id_pkix_ocsp_nonce = c0896n.j("2");
        id_pkix_ocsp_crl = c0896n.j("3");
        id_pkix_ocsp_response = c0896n.j("4");
        id_pkix_ocsp_nocheck = c0896n.j("5");
        id_pkix_ocsp_archive_cutoff = c0896n.j("6");
        id_pkix_ocsp_service_locator = c0896n.j("7");
        id_pkix_ocsp_pref_sig_algs = c0896n.j("8");
        id_pkix_ocsp_extended_revoke = c0896n.j("9");
    }
}
