package androidx.room.util;

import android.util.Log;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.jvm.internal.h;
import kotlin.text.i;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000f\"\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ljava/lang/StringBuilder;", "newStringBuilder", "()Ljava/lang/StringBuilder;", "builder", "", "count", "LN1/m;", "appendPlaceholders", "(Ljava/lang/StringBuilder;I)V", "", "input", "", "splitToIntList", "(Ljava/lang/String;)Ljava/util/List;", "joinIntoString", "(Ljava/util/List;)Ljava/lang/String;", "", "EMPTY_STRING_ARRAY", "[Ljava/lang/String;", "getEMPTY_STRING_ARRAY$annotations", "()V", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder builder, int i) {
        h.f(builder, "builder");
        for (int i3 = 0; i3 < i; i3++) {
            builder.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            if (i3 < i - 1) {
                builder.append(",");
            }
        }
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return m.V(list, ",", null, null, null, 62);
        }
        return null;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        Integer numValueOf;
        if (str == null) {
            return null;
        }
        List listQ = i.Q(str, new char[]{','});
        ArrayList arrayList = new ArrayList();
        Iterator it = listQ.iterator();
        while (it.hasNext()) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException e) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e);
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }
}
