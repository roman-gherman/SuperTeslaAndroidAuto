package org.bouncycastle.internal.asn1.iana;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface IANAObjectIdentifiers {
    public static final C0896n SNMPv2;
    public static final C0896n _private;
    public static final C0896n directory;
    public static final C0896n experimental;
    public static final C0896n hmacMD5;
    public static final C0896n hmacRIPEMD160;
    public static final C0896n hmacSHA1;
    public static final C0896n hmacTIGER;
    public static final C0896n internet;
    public static final C0896n ipsec;
    public static final C0896n isakmpOakley;
    public static final C0896n mail;
    public static final C0896n mgmt;
    public static final C0896n pkix;
    public static final C0896n security;
    public static final C0896n security_mechanisms;
    public static final C0896n security_nametypes;

    static {
        C0896n c0896n = new C0896n("1.3.6.1");
        internet = c0896n;
        directory = c0896n.j("1");
        mgmt = c0896n.j("2");
        experimental = c0896n.j("3");
        _private = c0896n.j("4");
        C0896n c0896nJ = c0896n.j("5");
        security = c0896nJ;
        SNMPv2 = c0896n.j("6");
        mail = c0896n.j("7");
        C0896n c0896nJ2 = c0896nJ.j("5");
        security_mechanisms = c0896nJ2;
        security_nametypes = c0896nJ.j("6");
        pkix = c0896nJ2.j("7");
        C0896n c0896nJ3 = c0896nJ2.j("8");
        ipsec = c0896nJ3;
        C0896n c0896nJ4 = c0896nJ3.j("1");
        isakmpOakley = c0896nJ4;
        hmacMD5 = c0896nJ4.j("1");
        hmacSHA1 = c0896nJ4.j("2");
        hmacTIGER = c0896nJ4.j("3");
        hmacRIPEMD160 = c0896nJ4.j("4");
    }
}
