package M0;

import com.google.gson.D;
import com.google.gson.E;
import com.google.gson.TypeAdapterFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public final class l implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1004a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l(Object obj, int i) {
        this.f1004a = i;
        this.b = obj;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final E create(com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        switch (this.f1004a) {
            case 0:
                if (aVar.f3041a == Number.class) {
                    return (d) this.b;
                }
                return null;
            case 1:
                if (aVar.f3041a == Object.class) {
                    return new m(mVar, (D) this.b);
                }
                return null;
            default:
                Class cls = aVar.f3041a;
                if (cls == Calendar.class || cls == GregorianCalendar.class) {
                    return (u) this.b;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f1004a) {
            case 2:
                return "Factory[type=" + Calendar.class.getName() + Marker.ANY_NON_NULL_MARKER + GregorianCalendar.class.getName() + ",adapter=" + ((u) this.b) + "]";
            default:
                return super.toString();
        }
    }
}
