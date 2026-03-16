package M0;

import com.google.gson.E;
import com.google.gson.internal.ObjectConstructor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b extends E {
    public static final a d = new a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f991a = 2;
    public final Object b;
    public final Object c;

    public b(f fVar, int i, int i3) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Objects.requireNonNull(fVar);
        this.c = fVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i3));
        }
        if (com.google.gson.internal.i.f3002a >= 9) {
            arrayList.add(com.google.gson.internal.d.h(i, i3));
        }
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        Date dateB;
        switch (this.f991a) {
            case 0:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                bVar.a();
                while (bVar.j()) {
                    arrayList.add(((E) ((k) this.b).c).a(bVar));
                }
                bVar.e();
                int size = arrayList.size();
                Class cls = (Class) this.c;
                if (!cls.isPrimitive()) {
                    return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
                }
                Object objNewInstance = Array.newInstance((Class<?>) cls, size);
                for (int i = 0; i < size; i++) {
                    Array.set(objNewInstance, i, arrayList.get(i));
                }
                return objNewInstance;
            case 1:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                Collection collection = (Collection) ((ObjectConstructor) this.c).construct();
                bVar.a();
                while (bVar.j()) {
                    collection.add(((E) ((k) this.b).c).a(bVar));
                }
                bVar.e();
                return collection;
            case 2:
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
                return ((f) this.c).a(dateB);
            default:
                Object objA = ((v) this.b).c.a(bVar);
                if (objA != null) {
                    Class cls2 = (Class) this.c;
                    if (!cls2.isInstance(objA)) {
                        throw new com.google.gson.w("Expected a " + cls2.getName() + " but was " + objA.getClass().getName() + "; at path " + bVar.i());
                    }
                }
                return objA;
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        String str;
        switch (this.f991a) {
            case 0:
                if (obj == null) {
                    cVar.i();
                    return;
                }
                cVar.b();
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    ((k) this.b).b(cVar, Array.get(obj, i));
                }
                cVar.e();
                return;
            case 1:
                Collection collection = (Collection) obj;
                if (collection == null) {
                    cVar.i();
                    return;
                }
                cVar.b();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    ((k) this.b).b(cVar, it.next());
                }
                cVar.e();
                return;
            case 2:
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
                ((v) this.b).c.b(cVar, obj);
                return;
        }
    }

    public String toString() {
        switch (this.f991a) {
            case 2:
                DateFormat dateFormat = (DateFormat) ((ArrayList) this.b).get(0);
                if (dateFormat instanceof SimpleDateFormat) {
                    return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
                }
                return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
            default:
                return super.toString();
        }
    }

    public b(v vVar, Class cls) {
        this.b = vVar;
        this.c = cls;
    }

    public b(com.google.gson.m mVar, E e, Class cls) {
        this.b = new k(mVar, e, cls);
        this.c = cls;
    }

    public b(com.google.gson.m mVar, Type type, E e, ObjectConstructor objectConstructor) {
        this.b = new k(mVar, e, type);
        this.c = objectConstructor;
    }
}
