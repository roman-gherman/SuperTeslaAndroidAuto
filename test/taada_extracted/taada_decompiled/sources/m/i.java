package m;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC0629a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f3999a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4002h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f4003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f4004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f4005l;

    public i(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f3999a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f4000f = str5;
        this.f4001g = str6;
        this.f4002h = str7;
        this.i = str8;
        this.f4003j = str9;
        this.f4004k = str10;
        this.f4005l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0629a) {
            AbstractC0629a abstractC0629a = (AbstractC0629a) obj;
            Integer num = this.f3999a;
            if (num != null ? num.equals(((i) abstractC0629a).f3999a) : ((i) abstractC0629a).f3999a == null) {
                String str = this.b;
                if (str != null ? str.equals(((i) abstractC0629a).b) : ((i) abstractC0629a).b == null) {
                    String str2 = this.c;
                    if (str2 != null ? str2.equals(((i) abstractC0629a).c) : ((i) abstractC0629a).c == null) {
                        String str3 = this.d;
                        if (str3 != null ? str3.equals(((i) abstractC0629a).d) : ((i) abstractC0629a).d == null) {
                            String str4 = this.e;
                            if (str4 != null ? str4.equals(((i) abstractC0629a).e) : ((i) abstractC0629a).e == null) {
                                String str5 = this.f4000f;
                                if (str5 != null ? str5.equals(((i) abstractC0629a).f4000f) : ((i) abstractC0629a).f4000f == null) {
                                    String str6 = this.f4001g;
                                    if (str6 != null ? str6.equals(((i) abstractC0629a).f4001g) : ((i) abstractC0629a).f4001g == null) {
                                        String str7 = this.f4002h;
                                        if (str7 != null ? str7.equals(((i) abstractC0629a).f4002h) : ((i) abstractC0629a).f4002h == null) {
                                            String str8 = this.i;
                                            if (str8 != null ? str8.equals(((i) abstractC0629a).i) : ((i) abstractC0629a).i == null) {
                                                String str9 = this.f4003j;
                                                if (str9 != null ? str9.equals(((i) abstractC0629a).f4003j) : ((i) abstractC0629a).f4003j == null) {
                                                    String str10 = this.f4004k;
                                                    if (str10 != null ? str10.equals(((i) abstractC0629a).f4004k) : ((i) abstractC0629a).f4004k == null) {
                                                        String str11 = this.f4005l;
                                                        if (str11 != null ? str11.equals(((i) abstractC0629a).f4005l) : ((i) abstractC0629a).f4005l == null) {
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
        Integer num = this.f3999a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f4000f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f4001g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f4002h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f4003j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f4004k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f4005l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f3999a);
        sb.append(", model=");
        sb.append(this.b);
        sb.append(", hardware=");
        sb.append(this.c);
        sb.append(", device=");
        sb.append(this.d);
        sb.append(", product=");
        sb.append(this.e);
        sb.append(", osBuild=");
        sb.append(this.f4000f);
        sb.append(", manufacturer=");
        sb.append(this.f4001g);
        sb.append(", fingerprint=");
        sb.append(this.f4002h);
        sb.append(", locale=");
        sb.append(this.i);
        sb.append(", country=");
        sb.append(this.f4003j);
        sb.append(", mccMnc=");
        sb.append(this.f4004k);
        sb.append(", applicationBuild=");
        return B2.b.h(sb, this.f4005l, "}");
    }
}
