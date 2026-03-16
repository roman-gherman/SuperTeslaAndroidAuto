package org.bouncycastle.asn1.x509.qualified;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface ETSIQCObjectIdentifiers {
    public static final C0896n id_etsi_qcs_QcCClegislation;
    public static final C0896n id_etsi_qcs_QcType;
    public static final C0896n id_etsi_qct_eseal;
    public static final C0896n id_etsi_qct_esign;
    public static final C0896n id_etsi_qct_web;
    public static final C0896n id_etsi_qcs_QcCompliance = new C0896n("0.4.0.1862.1.1");
    public static final C0896n id_etsi_qcs_LimiteValue = new C0896n("0.4.0.1862.1.2");
    public static final C0896n id_etsi_qcs_RetentionPeriod = new C0896n("0.4.0.1862.1.3");
    public static final C0896n id_etsi_qcs_QcSSCD = new C0896n("0.4.0.1862.1.4");
    public static final C0896n id_etsi_qcs_QcPds = new C0896n("0.4.0.1862.1.5");

    static {
        C0896n c0896n = new C0896n("0.4.0.1862.1.6");
        id_etsi_qcs_QcType = c0896n;
        id_etsi_qct_esign = c0896n.j("1");
        id_etsi_qct_eseal = c0896n.j("2");
        id_etsi_qct_web = c0896n.j("3");
        id_etsi_qcs_QcCClegislation = new C0896n("0.4.0.1862.1.7");
    }
}
