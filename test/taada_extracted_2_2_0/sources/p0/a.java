package P0;

import com.google.gson.E;
import com.google.gson.w;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class a extends E {
    public static final M0.a c = new M0.a(3);
    public static final M0.a d = new M0.a(4);
    public static final M0.a e = new M0.a(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1196a;
    public final Object b;

    public a(int i) {
        this.f1196a = i;
        switch (i) {
            case 1:
                this.b = new SimpleDateFormat("hh:mm:ss a");
                break;
            default:
                this.b = new SimpleDateFormat("MMM d, yyyy");
                break;
        }
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        Date date;
        Time time;
        switch (this.f1196a) {
            case 0:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU = bVar.u();
                try {
                    synchronized (this) {
                        date = ((SimpleDateFormat) this.b).parse(strU);
                        break;
                    }
                    return new java.sql.Date(date.getTime());
                } catch (ParseException e6) {
                    StringBuilder sbM = B2.b.m("Failed parsing '", strU, "' as SQL Date; at path ");
                    sbM.append(bVar.i());
                    throw new w(sbM.toString(), e6);
                }
            case 1:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU2 = bVar.u();
                try {
                    synchronized (this) {
                        time = new Time(((SimpleDateFormat) this.b).parse(strU2).getTime());
                        break;
                    }
                    return time;
                } catch (ParseException e7) {
                    StringBuilder sbM2 = B2.b.m("Failed parsing '", strU2, "' as SQL Time; at path ");
                    sbM2.append(bVar.i());
                    throw new w(sbM2.toString(), e7);
                }
            default:
                Date date2 = (Date) ((E) this.b).a(bVar);
                if (date2 != null) {
                    return new Timestamp(date2.getTime());
                }
                return null;
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        String str;
        String str2;
        switch (this.f1196a) {
            case 0:
                java.sql.Date date = (java.sql.Date) obj;
                if (date == null) {
                    cVar.i();
                    return;
                }
                synchronized (this) {
                    str = ((SimpleDateFormat) this.b).format((Date) date);
                    break;
                }
                cVar.p(str);
                return;
            case 1:
                Time time = (Time) obj;
                if (time == null) {
                    cVar.i();
                    return;
                }
                synchronized (this) {
                    str2 = ((SimpleDateFormat) this.b).format((Date) time);
                    break;
                }
                cVar.p(str2);
                return;
            default:
                ((E) this.b).b(cVar, (Timestamp) obj);
                return;
        }
    }

    public a(E e6) {
        this.f1196a = 2;
        this.b = e6;
    }
}
