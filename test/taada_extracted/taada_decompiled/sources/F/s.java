package f;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f3165a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static /* synthetic */ int a(int i, int i3) {
        if (i == 0 || i3 == 0) {
            throw null;
        }
        return i - i3;
    }

    public static /* synthetic */ int b(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String c(int i) {
        switch (i) {
            case 1:
                return "METHOD_HANDLE_TYPE_STATIC_PUT";
            case 2:
                return "METHOD_HANDLE_TYPE_STATIC_GET";
            case 3:
                return "METHOD_HANDLE_TYPE_INSTANCE_PUT";
            case 4:
                return "METHOD_HANDLE_TYPE_INSTANCE_GET";
            case 5:
                return "METHOD_HANDLE_TYPE_INVOKE_STATIC";
            case 6:
                return "METHOD_HANDLE_TYPE_INVOKE_INSTANCE";
            case 7:
                return "METHOD_HANDLE_TYPE_INVOKE_DIRECT";
            case 8:
                return "METHOD_HANDLE_TYPE_INVOKE_CONSTRUCTOR";
            case 9:
                return "METHOD_HANDLE_TYPE_INVOKE_INTERFACE";
            default:
                return "null";
        }
    }

    public static /* synthetic */ int[] d(int i) {
        int[] iArr = new int[i];
        System.arraycopy(f3165a, 0, iArr, 0, i);
        return iArr;
    }
}
