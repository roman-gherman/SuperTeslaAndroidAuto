package M0;

import com.google.gson.D;
import com.google.gson.E;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class d extends E {
    public static final a c = new a(1);
    public static final l d = new l(new d(D.b), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f993a = 0;
    public final Serializable b;

    public d() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.i.f3002a >= 9) {
            arrayList.add(com.google.gson.internal.d.h(2, 2));
        }
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        Date dateB;
        switch (this.f993a) {
            case 0:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU = bVar.u();
                synchronized (((ArrayList) this.b)) {
                    try {
                        Iterator it = ((ArrayList) this.b).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                try {
                                    dateB = N0.a.b(strU, new ParsePosition(0));
                                } catch (ParseException e) {
                                    StringBuilder sbM = B2.b.m("Failed parsing '", strU, "' as Date; at path ");
                                    sbM.append(bVar.i());
                                    throw new com.google.gson.w(sbM.toString(), e);
                                }
                                break;
                            } else {
                                try {
                                    dateB = ((DateFormat) it.next()).parse(strU);
                                } catch (ParseException unused) {
                                }
                            }
                        }
                    } finally {
                    }
                }
                return dateB;
            default:
                int iW = bVar.w();
                int iB = f.s.b(iW);
                if (iB == 5 || iB == 6) {
                    return ((D) this.b).readNumber(bVar);
                }
                if (iB == 8) {
                    bVar.s();
                    return null;
                }
                throw new com.google.gson.w("Expecting number, got: " + androidx.constraintlayout.core.motion.a.C(iW) + "; at path " + bVar.getPath());
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        String str;
        switch (this.f993a) {
            case 0:
                Date date = (Date) obj;
                if (date == null) {
                    cVar.i();
                    return;
                }
                DateFormat dateFormat = (DateFormat) ((ArrayList) this.b).get(0);
                synchronized (((ArrayList) this.b)) {
                    str = dateFormat.format(date);
                    break;
                }
                cVar.p(str);
                return;
            default:
                cVar.o((Number) obj);
                return;
        }
    }

    public d(D d6) {
        this.b = d6;
    }
}
