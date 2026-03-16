package org.bouncycastle.internal.asn1.microsoft;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface MicrosoftObjectIdentifiers {
    public static final C0896n microsoft;
    public static final C0896n microsoftAppPolicies;
    public static final C0896n microsoftCaVersion;
    public static final C0896n microsoftCertTemplateV1;
    public static final C0896n microsoftCertTemplateV2;
    public static final C0896n microsoftCrlNextPublish;
    public static final C0896n microsoftPrevCaCertHash;

    static {
        C0896n c0896n = new C0896n("1.3.6.1.4.1.311");
        microsoft = c0896n;
        microsoftCertTemplateV1 = c0896n.j("20.2");
        microsoftCaVersion = c0896n.j("21.1");
        microsoftPrevCaCertHash = c0896n.j("21.2");
        microsoftCrlNextPublish = c0896n.j("21.4");
        microsoftCertTemplateV2 = c0896n.j("21.7");
        microsoftAppPolicies = c0896n.j("21.10");
    }
}
