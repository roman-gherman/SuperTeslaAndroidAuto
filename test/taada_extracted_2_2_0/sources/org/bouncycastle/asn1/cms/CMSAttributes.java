package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface CMSAttributes {
    public static final C0896n contentType = PKCSObjectIdentifiers.pkcs_9_at_contentType;
    public static final C0896n messageDigest = PKCSObjectIdentifiers.pkcs_9_at_messageDigest;
    public static final C0896n signingTime = PKCSObjectIdentifiers.pkcs_9_at_signingTime;
    public static final C0896n counterSignature = PKCSObjectIdentifiers.pkcs_9_at_counterSignature;
    public static final C0896n binarySigningTime = PKCSObjectIdentifiers.pkcs_9_at_binarySigningTime;
    public static final C0896n contentHint = PKCSObjectIdentifiers.id_aa_contentHint;
    public static final C0896n cmsAlgorithmProtect = PKCSObjectIdentifiers.id_aa_cmsAlgorithmProtect;
}
