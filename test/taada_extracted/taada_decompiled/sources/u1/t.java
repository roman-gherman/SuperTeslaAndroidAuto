package u1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements Comparable {
    public static final t c;
    public static final t d;
    public static final t e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t f4872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f4873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f4874h;
    public static final LinkedHashMap i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4875a;
    public final String b;

    static {
        t tVar = new t(100, "Continue");
        t tVar2 = new t(101, "Switching Protocols");
        t tVar3 = new t(102, "Processing");
        t tVar4 = new t(200, "OK");
        t tVar5 = new t(201, "Created");
        t tVar6 = new t(202, "Accepted");
        t tVar7 = new t(203, "Non-Authoritative Information");
        t tVar8 = new t(204, "No Content");
        t tVar9 = new t(205, "Reset Content");
        t tVar10 = new t(206, "Partial Content");
        t tVar11 = new t(207, "Multi-Status");
        t tVar12 = new t(300, "Multiple Choices");
        t tVar13 = new t(301, "Moved Permanently");
        c = tVar13;
        t tVar14 = new t(302, "Found");
        d = tVar14;
        t tVar15 = new t(303, "See Other");
        e = tVar15;
        t tVar16 = new t(304, "Not Modified");
        t tVar17 = new t(305, "Use Proxy");
        t tVar18 = new t(306, "Switch Proxy");
        t tVar19 = new t(307, "Temporary Redirect");
        f4872f = tVar19;
        t tVar20 = new t(308, "Permanent Redirect");
        f4873g = tVar20;
        List listY = kotlin.collections.n.y(tVar, tVar2, tVar3, tVar4, tVar5, tVar6, tVar7, tVar8, tVar9, tVar10, tVar11, tVar12, tVar13, tVar14, tVar15, tVar16, tVar17, tVar18, tVar19, tVar20, new t(400, "Bad Request"), new t(TypedValues.CycleType.TYPE_CURVE_FIT, "Unauthorized"), new t(TypedValues.CycleType.TYPE_VISIBILITY, "Payment Required"), new t(TypedValues.CycleType.TYPE_ALPHA, "Forbidden"), new t(404, "Not Found"), new t(405, "Method Not Allowed"), new t(406, "Not Acceptable"), new t(407, "Proxy Authentication Required"), new t(408, "Request Timeout"), new t(409, "Conflict"), new t(410, "Gone"), new t(411, "Length Required"), new t(412, "Precondition Failed"), new t(413, "Payload Too Large"), new t(414, "Request-URI Too Long"), new t(415, "Unsupported Media Type"), new t(TypedValues.CycleType.TYPE_PATH_ROTATE, "Requested Range Not Satisfiable"), new t(417, "Expectation Failed"), new t(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, "Unprocessable Entity"), new t(TypedValues.CycleType.TYPE_WAVE_PERIOD, "Locked"), new t(TypedValues.CycleType.TYPE_WAVE_OFFSET, "Failed Dependency"), new t(TypedValues.CycleType.TYPE_WAVE_PHASE, "Too Early"), new t(426, "Upgrade Required"), new t(429, "Too Many Requests"), new t(431, "Request Header Fields Too Large"), new t(500, "Internal Server Error"), new t(TypedValues.PositionType.TYPE_TRANSITION_EASING, "Not Implemented"), new t(TypedValues.PositionType.TYPE_DRAWPATH, "Bad Gateway"), new t(TypedValues.PositionType.TYPE_PERCENT_WIDTH, "Service Unavailable"), new t(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, "Gateway Timeout"), new t(TypedValues.PositionType.TYPE_SIZE_PERCENT, "HTTP Version Not Supported"), new t(TypedValues.PositionType.TYPE_PERCENT_X, "Variant Also Negotiates"), new t(TypedValues.PositionType.TYPE_PERCENT_Y, "Insufficient Storage"));
        f4874h = listY;
        int iF = kotlin.collections.B.F(kotlin.collections.o.D(listY));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        for (Object obj : listY) {
            linkedHashMap.put(Integer.valueOf(((t) obj).f4875a), obj);
        }
        i = linkedHashMap;
    }

    public t(int i3, String str) {
        this.f4875a = i3;
        this.b = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        t other = (t) obj;
        kotlin.jvm.internal.h.f(other, "other");
        return this.f4875a - other.f4875a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof t) && ((t) obj).f4875a == this.f4875a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4875a);
    }

    public final String toString() {
        return this.f4875a + ' ' + this.b;
    }
}
