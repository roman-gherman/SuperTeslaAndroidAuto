package l;

import com.google.android.datatransport.runtime.EncodedDestination;
import io.ktor.utils.io.Z;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import k.C0569b;

/* JADX INFO: renamed from: l.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0614a implements EncodedDestination {
    public static final String c;
    public static final Set d;
    public static final C0614a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3950a;
    public final String b;

    static {
        String strR = Z.r("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        c = strR;
        Z.r("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        Z.r("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C0569b("proto"), new C0569b("json"))));
        e = new C0614a(strR, null);
    }

    public C0614a(String str, String str2) {
        this.f3950a = str;
        this.b = str2;
    }

    public static C0614a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new C0614a(str2, str3);
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public final byte[] getExtras() {
        String str = this.f3950a;
        String str2 = this.b;
        if (str2 == null && str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        return androidx.constraintlayout.core.motion.a.r("1$", str, "\\", str2).getBytes(Charset.forName("UTF-8"));
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public final String getName() {
        return "cct";
    }

    @Override // com.google.android.datatransport.runtime.EncodedDestination
    public final Set getSupportedEncodings() {
        return d;
    }
}
