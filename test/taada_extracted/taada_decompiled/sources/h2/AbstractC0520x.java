package h2;

import java.util.LinkedHashMap;

/* JADX INFO: renamed from: h2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0520x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f3450a;

    static {
        int[] iArr = new int[F2.a.values().length];
        try {
            LinkedHashMap linkedHashMap = F2.a.b;
            iArr[2] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            LinkedHashMap linkedHashMap2 = F2.a.b;
            iArr[4] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            LinkedHashMap linkedHashMap3 = F2.a.b;
            iArr[5] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            LinkedHashMap linkedHashMap4 = F2.a.b;
            iArr[3] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            LinkedHashMap linkedHashMap5 = F2.a.b;
            iArr[0] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            LinkedHashMap linkedHashMap6 = F2.a.b;
            iArr[1] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        f3450a = iArr;
    }
}
