package W3;

import I3.c;
import O3.b;
import c4.AbstractC0243a;
import c4.C0245c;
import g5.e;
import java.util.Enumeration;
import java.util.HashMap;
import w3.C0896n;
import x3.AbstractC0925a;
import z3.AbstractC0947a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1399a;

    static {
        HashMap map = new HashMap();
        Enumeration enumerationElements = b.e.elements();
        while (enumerationElements.hasMoreElements()) {
            String str = (String) enumerationElements.nextElement();
            C0896n c0896n = (C0896n) I3.b.f792a.get(e.b(str));
            c cVar = null;
            c cVar2 = c0896n == null ? null : (c) I3.b.b.get(c0896n);
            if (cVar2 == null) {
                C0896n c0896n2 = (C0896n) D3.b.f269a.get(e.b(str));
                cVar2 = c0896n2 == null ? null : (c) D3.b.b.get(c0896n2);
            }
            if (cVar2 == null) {
                C0896n c0896n3 = (C0896n) B3.a.f127a.get(e.c(str));
                cVar2 = c0896n3 != null ? (c) D3.b.b.get(c0896n3) : null;
            }
            if (cVar2 == null) {
                C0896n c0896n4 = (C0896n) E3.a.f319a.get(e.b(str));
                cVar2 = c0896n4 == null ? null : (c) E3.a.b.get(c0896n4);
            }
            if (cVar2 == null) {
                C0896n c0896n5 = (C0896n) AbstractC0925a.f5125a.get(e.b(str));
                cVar2 = c0896n5 == null ? null : (c) AbstractC0925a.b.get(c0896n5);
            }
            if (cVar2 == null) {
                C0896n c0896n6 = (C0896n) AbstractC0947a.f5205a.get(str);
                cVar2 = c0896n6 == null ? null : (c) AbstractC0947a.b.get(c0896n6);
            }
            if (cVar2 == null) {
                C0896n c0896n7 = (C0896n) A3.b.f80a.get(e.b(str));
                if (c0896n7 != null) {
                    cVar = (c) A3.b.b.get(c0896n7);
                }
            } else {
                cVar = cVar2;
            }
            if (cVar != null) {
                AbstractC0243a abstractC0243aB = cVar.b();
                if (abstractC0243aB.f1777a.getDimension() == 1) {
                    map.put(abstractC0243aB, ((c) b.f1191a.get(e.b(str))).b());
                }
            }
        }
        AbstractC0243a abstractC0243aB2 = ((c) b.f1191a.get(e.b("Curve25519"))).b();
        map.put(new C0245c(abstractC0243aB2.f1777a.getCharacteristic(), abstractC0243aB2.b.G0(), abstractC0243aB2.c.G0(), abstractC0243aB2.d, abstractC0243aB2.e, true), abstractC0243aB2);
        f1399a = map;
    }
}
