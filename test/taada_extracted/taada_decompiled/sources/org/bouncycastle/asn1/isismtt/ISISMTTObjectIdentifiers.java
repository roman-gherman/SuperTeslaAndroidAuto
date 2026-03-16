package org.bouncycastle.asn1.isismtt;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface ISISMTTObjectIdentifiers {
    public static final C0896n id_isismtt;
    public static final C0896n id_isismtt_at;
    public static final C0896n id_isismtt_at_PKReference;
    public static final C0896n id_isismtt_at_additionalInformation;
    public static final C0896n id_isismtt_at_admission;
    public static final C0896n id_isismtt_at_certHash;
    public static final C0896n id_isismtt_at_certInDirSince;
    public static final C0896n id_isismtt_at_dateOfCertGen;
    public static final C0896n id_isismtt_at_declarationOfMajority;
    public static final C0896n id_isismtt_at_iCCSN;
    public static final C0896n id_isismtt_at_liabilityLimitationFlag;
    public static final C0896n id_isismtt_at_monetaryLimit;
    public static final C0896n id_isismtt_at_nameAtBirth;
    public static final C0896n id_isismtt_at_namingAuthorities;
    public static final C0896n id_isismtt_at_procuration;
    public static final C0896n id_isismtt_at_requestedCertificate;
    public static final C0896n id_isismtt_at_restriction;
    public static final C0896n id_isismtt_at_retrieveIfAllowed;
    public static final C0896n id_isismtt_cp;
    public static final C0896n id_isismtt_cp_accredited;

    static {
        C0896n c0896n = new C0896n("1.3.36.8");
        id_isismtt = c0896n;
        C0896n c0896nJ = c0896n.j("1");
        id_isismtt_cp = c0896nJ;
        id_isismtt_cp_accredited = c0896nJ.j("1");
        C0896n c0896nJ2 = c0896n.j("3");
        id_isismtt_at = c0896nJ2;
        id_isismtt_at_dateOfCertGen = c0896nJ2.j("1");
        id_isismtt_at_procuration = c0896nJ2.j("2");
        id_isismtt_at_admission = c0896nJ2.j("3");
        id_isismtt_at_monetaryLimit = c0896nJ2.j("4");
        id_isismtt_at_declarationOfMajority = c0896nJ2.j("5");
        id_isismtt_at_iCCSN = c0896nJ2.j("6");
        id_isismtt_at_PKReference = c0896nJ2.j("7");
        id_isismtt_at_restriction = c0896nJ2.j("8");
        id_isismtt_at_retrieveIfAllowed = c0896nJ2.j("9");
        id_isismtt_at_requestedCertificate = c0896nJ2.j("10");
        id_isismtt_at_namingAuthorities = c0896nJ2.j("11");
        id_isismtt_at_certInDirSince = c0896nJ2.j("12");
        id_isismtt_at_certHash = c0896nJ2.j("13");
        id_isismtt_at_nameAtBirth = c0896nJ2.j("14");
        id_isismtt_at_additionalInformation = c0896nJ2.j("15");
        id_isismtt_at_liabilityLimitationFlag = new C0896n("0.2.262.1.10.12.0");
    }
}
