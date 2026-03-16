package C0;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f144a = new g();

    public static F0.c a(com.google.crypto.tink.l lVar) {
        com.google.crypto.tink.e eVar;
        ArrayList arrayList = new ArrayList();
        F0.a aVar = F0.a.b;
        F0.a aVar2 = lVar.c;
        Iterator it = lVar.f2803a.values().iterator();
        while (it.hasNext()) {
            for (com.google.crypto.tink.j jVar : (List) it.next()) {
                int iOrdinal = jVar.d.ordinal();
                if (iOrdinal == 1) {
                    eVar = com.google.crypto.tink.e.c;
                } else if (iOrdinal == 2) {
                    eVar = com.google.crypto.tink.e.d;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    eVar = com.google.crypto.tink.e.e;
                }
                String strSubstring = jVar.f2800g;
                if (strSubstring.startsWith("type.googleapis.com/google.crypto.")) {
                    strSubstring = strSubstring.substring(34);
                }
                arrayList.add(new F0.b(eVar, jVar.f2799f, strSubstring, jVar.e.name()));
            }
        }
        com.google.crypto.tink.j jVar2 = lVar.b;
        Integer numValueOf = jVar2 != null ? Integer.valueOf(jVar2.f2799f) : null;
        if (numValueOf != null) {
            try {
                int iIntValue = numValueOf.intValue();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (((F0.b) it2.next()).b == iIntValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
        return new F0.c(aVar2, Collections.unmodifiableList(arrayList), numValueOf);
    }
}
