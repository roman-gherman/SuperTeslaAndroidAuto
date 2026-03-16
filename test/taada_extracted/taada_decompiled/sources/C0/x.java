package C0;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class x extends RuntimeException {
    public x(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }

    public x() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
