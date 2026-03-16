package u0;

import java.util.HashMap;

/* JADX INFO: renamed from: u0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0831a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f4845a;
    public static final HashMap b;

    static {
        HashMap map = new HashMap();
        f4845a = map;
        HashMap map2 = new HashMap();
        b = map2;
        map.put(-1, "The Play Store app is either not installed or not the official version.");
        map.put(-2, "Call first requestReviewFlow to get the ReviewInfo.");
        map.put(-100, "Retry with an exponential backoff. Consider filing a bug if fails consistently.");
        map2.put(-1, "PLAY_STORE_NOT_FOUND");
        map2.put(-2, "INVALID_REQUEST");
        map2.put(-100, "INTERNAL_ERROR");
    }
}
