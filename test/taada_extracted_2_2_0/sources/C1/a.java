package C1;

import f.s;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f161a = TimeZone.getTimeZone("GMT");

    public static final b a(Long l6) {
        Calendar calendar = Calendar.getInstance(f161a, Locale.ROOT);
        h.c(calendar);
        if (l6 != null) {
            calendar.setTimeInMillis(l6.longValue());
        }
        int i = calendar.get(16) + calendar.get(15);
        return new b(calendar.get(13), calendar.get(12), calendar.get(11), s.d(7)[(calendar.get(7) + 5) % 7], calendar.get(5), calendar.get(6), s.d(12)[calendar.get(2)], calendar.get(1), calendar.getTimeInMillis() + ((long) i));
    }
}
