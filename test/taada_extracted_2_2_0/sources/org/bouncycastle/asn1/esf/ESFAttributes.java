package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface ESFAttributes {
    public static final C0896n sigPolicyId = PKCSObjectIdentifiers.id_aa_ets_sigPolicyId;
    public static final C0896n commitmentType = PKCSObjectIdentifiers.id_aa_ets_commitmentType;
    public static final C0896n signerLocation = PKCSObjectIdentifiers.id_aa_ets_signerLocation;
    public static final C0896n signerAttr = PKCSObjectIdentifiers.id_aa_ets_signerAttr;
    public static final C0896n otherSigCert = PKCSObjectIdentifiers.id_aa_ets_otherSigCert;
    public static final C0896n contentTimestamp = PKCSObjectIdentifiers.id_aa_ets_contentTimestamp;
    public static final C0896n certificateRefs = PKCSObjectIdentifiers.id_aa_ets_certificateRefs;
    public static final C0896n revocationRefs = PKCSObjectIdentifiers.id_aa_ets_revocationRefs;
    public static final C0896n certValues = PKCSObjectIdentifiers.id_aa_ets_certValues;
    public static final C0896n revocationValues = PKCSObjectIdentifiers.id_aa_ets_revocationValues;
    public static final C0896n escTimeStamp = PKCSObjectIdentifiers.id_aa_ets_escTimeStamp;
    public static final C0896n certCRLTimestamp = PKCSObjectIdentifiers.id_aa_ets_certCRLTimestamp;
    public static final C0896n archiveTimestamp = PKCSObjectIdentifiers.id_aa_ets_archiveTimestamp;
    public static final C0896n archiveTimestampV2 = PKCSObjectIdentifiers.id_aa.j("48");
}
