package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface CommitmentTypeIdentifier {
    public static final C0896n proofOfOrigin = PKCSObjectIdentifiers.id_cti_ets_proofOfOrigin;
    public static final C0896n proofOfReceipt = PKCSObjectIdentifiers.id_cti_ets_proofOfReceipt;
    public static final C0896n proofOfDelivery = PKCSObjectIdentifiers.id_cti_ets_proofOfDelivery;
    public static final C0896n proofOfSender = PKCSObjectIdentifiers.id_cti_ets_proofOfSender;
    public static final C0896n proofOfApproval = PKCSObjectIdentifiers.id_cti_ets_proofOfApproval;
    public static final C0896n proofOfCreation = PKCSObjectIdentifiers.id_cti_ets_proofOfCreation;
}
