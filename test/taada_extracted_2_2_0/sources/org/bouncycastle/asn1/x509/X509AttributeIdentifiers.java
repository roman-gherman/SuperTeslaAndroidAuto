package org.bouncycastle.asn1.x509;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface X509AttributeIdentifiers {
    public static final C0896n RoleSyntax = new C0896n("2.5.4.72");
    public static final C0896n id_aca;
    public static final C0896n id_aca_accessIdentity;
    public static final C0896n id_aca_authenticationInfo;
    public static final C0896n id_aca_chargingIdentity;
    public static final C0896n id_aca_encAttrs;
    public static final C0896n id_aca_group;
    public static final C0896n id_at_clearance;
    public static final C0896n id_at_privateKeyStatement;
    public static final C0896n id_at_role;
    public static final C0896n id_ce_targetInformation;
    public static final C0896n id_pe_aaControls;
    public static final C0896n id_pe_ac_auditIdentity;
    public static final C0896n id_pe_ac_proxying;

    static {
        C0896n c0896n = X509ObjectIdentifiers.id_pe;
        id_pe_ac_auditIdentity = c0896n.j("4");
        id_pe_aaControls = c0896n.j("6");
        id_pe_ac_proxying = c0896n.j("10");
        id_ce_targetInformation = X509ObjectIdentifiers.id_ce.j("55");
        C0896n c0896nJ = X509ObjectIdentifiers.id_pkix.j("10");
        id_aca = c0896nJ;
        id_aca_authenticationInfo = c0896nJ.j("1");
        id_aca_accessIdentity = c0896nJ.j("2");
        id_aca_chargingIdentity = c0896nJ.j("3");
        id_aca_group = c0896nJ.j("4");
        id_aca_encAttrs = c0896nJ.j("6");
        id_at_role = new C0896n("2.5.4.72");
        id_at_clearance = new C0896n("2.5.1.5.55");
        id_at_privateKeyStatement = new C0896n("1.3.6.1.4.1.22112.2.1");
    }
}
