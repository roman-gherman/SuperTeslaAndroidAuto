package m;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC0629a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f4000a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4003h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f4004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f4005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f4006l;

    public i(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f4000a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f4001f = str5;
        this.f4002g = str6;
        this.f4003h = str7;
        this.i = str8;
        this.f4004j = str9;
        this.f4005k = str10;
        this.f4006l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0629a) {
            AbstractC0629a abstractC0629a = (AbstractC0629a) obj;
            Integer num = this.f4000a;
            if (num != null ? num.equals(((i) abstractC0629a).f4000a) : ((i) abstractC0629a).f4000a == null) {
                String str = this.b;
                if (str != null ? str.equals(((i) abstractC0629a).b) : ((i) abstractC0629a).b == null) {
                    String str2 = this.c;
                    if (str2 != null ? str2.equals(((i) abstractC0629a).c) : ((i) abstractC0629a).c == null) {
                        String str3 = this.d;
                        if (str3 != null ? str3.equals(((i) abstractC0629a).d) : ((i) abstractC0629a).d == null) {
                            String str4 = this.e;
                            if (str4 != null ? str4.equals(((i) abstractC0629a).e) : ((i) abstractC0629a).e == null) {
                                String str5 = this.f4001f;
                                if (str5 != null ? str5.equals(((i) abstractC0629a).f4001f) : ((i) abstractC0629a).f4001f == null) {
                                    String str6 = this.f4002g;
                                    if (str6 != null ? str6.equals(((i) abstractC0629a).f4002g) : ((i) abstractC0629a).f4002g == null) {
                                        String str7 = this.f4003h;
                                        if (str7 != null ? str7.equals(((i) abstractC0629a).f4003h) : ((i) abstractC0629a).f4003h == null) {
                                            String str8 = this.i;
                                            if (str8 != null ? str8.equals(((i) abstractC0629a).i) : ((i) abstractC0629a).i == null) {
                                                String str9 = this.f4004j;
                                                if (str9 != null ? str9.equals(((i) abstractC0629a).f4004j) : ((i) abstractC0629a).f4004j == null) {
                                                    String str10 = this.f4005k;
                                                    if (str10 != null ? str10.equals(((i) abstractC0629a).f4005k) : ((i) abstractC0629a).f4005k == null) {
                                                        String str11 = this.f4006l;
                                                        if (str11 != null ? str11.equals(((i) abstractC0629a).f4006l) : ((i) abstractC0629a).f4006l == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f4000a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f4001f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f4002g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f4003h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f4004j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f4005k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f4006l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f4000a);
        sb.append(", model=");
        sb.append(this.b);
        sb.append(", hardware=");
        sb.append(this.c);
        sb.append(", device=");
        sb.append(this.d);
        sb.append(", product=");
        sb.append(this.e);
        sb.append(", osBuild=");
        sb.append(this.f4001f);
        sb.append(", manufacturer=");
        sb.append(this.f4002g);
        sb.append(", fingerprint=");
        sb.append(this.f4003h);
        sb.append(", locale=");
        sb.append(this.i);
        sb.append(", country=");
        sb.append(this.f4004j);
        sb.append(", mccMnc=");
        sb.append(this.f4005k);
        sb.append(", applicationBuild=");
        return B2.b.h(sb, this.f4006l, "}");
    }
}
