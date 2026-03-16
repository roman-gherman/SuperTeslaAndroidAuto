package org.bouncycastle.asn1.icao;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface ICAOObjectIdentifiers {
    public static final C0896n id_icao;
    public static final C0896n id_icao_aaProtocolObject;
    public static final C0896n id_icao_cscaMasterList;
    public static final C0896n id_icao_cscaMasterListSigningKey;
    public static final C0896n id_icao_documentTypeList;
    public static final C0896n id_icao_extensions;
    public static final C0896n id_icao_extensions_namechangekeyrollover;
    public static final C0896n id_icao_ldsSecurityObject;
    public static final C0896n id_icao_mrtd;
    public static final C0896n id_icao_mrtd_security;

    static {
        C0896n c0896n = new C0896n("2.23.136");
        id_icao = c0896n;
        C0896n c0896nJ = c0896n.j("1");
        id_icao_mrtd = c0896nJ;
        C0896n c0896nJ2 = c0896nJ.j("1");
        id_icao_mrtd_security = c0896nJ2;
        id_icao_ldsSecurityObject = c0896nJ2.j("1");
        id_icao_cscaMasterList = c0896nJ2.j("2");
        id_icao_cscaMasterListSigningKey = c0896nJ2.j("3");
        id_icao_documentTypeList = c0896nJ2.j("4");
        id_icao_aaProtocolObject = c0896nJ2.j("5");
        C0896n c0896nJ3 = c0896nJ2.j("6");
        id_icao_extensions = c0896nJ3;
        id_icao_extensions_namechangekeyrollover = c0896nJ3.j("1");
    }
}
