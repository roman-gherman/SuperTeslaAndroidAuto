package u1;

import io.ktor.util.StringValues;
import java.util.List;
import java.util.Map;
import o2.AbstractC0737a;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends AbstractC0737a {
    public /* synthetic */ m() {
        this(8);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final StringValues build() {
        return new n((Map) this.f4280a);
    }

    @Override // o2.AbstractC0737a
    public final void c(String str) {
        List list = q.f4870a;
        int i = 0;
        int i3 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            int i4 = i3 + 1;
            if (kotlin.jvm.internal.h.h(cCharAt, 32) <= 0 || kotlin.text.i.E("\"(),/:;<=>?@[\\]{}", cCharAt)) {
                StringBuilder sbM = B2.b.m("Header name '", str, "' contains illegal character '");
                sbM.append(str.charAt(i3));
                sbM.append("' (code ");
                sbM.append(str.charAt(i3) & 255);
                sbM.append(')');
                throw new u(sbM.toString());
            }
            i++;
            i3 = i4;
        }
    }

    @Override // o2.AbstractC0737a
    public final void d(String value) {
        kotlin.jvm.internal.h.f(value, "value");
        List list = q.f4870a;
        int i = 0;
        int i3 = 0;
        while (i < value.length()) {
            char cCharAt = value.charAt(i);
            int i4 = i3 + 1;
            if (kotlin.jvm.internal.h.h(cCharAt, 32) < 0 && cCharAt != '\t') {
                StringBuilder sbM = B2.b.m("Header value '", value, "' contains illegal character '");
                sbM.append(value.charAt(i3));
                sbM.append("' (code ");
                sbM.append(value.charAt(i3) & 255);
                sbM.append(')');
                throw new u(sbM.toString());
            }
            i++;
            i3 = i4;
        }
    }

    public m(int i) {
        super(i);
    }
}
