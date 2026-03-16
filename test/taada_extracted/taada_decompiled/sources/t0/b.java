package t0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.play.core.review.internal.zzf;
import com.google.android.play.core.review.internal.zzh;

/* JADX INFO: loaded from: classes.dex */
public final class b implements zzf, IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f4780a;

    public b(IBinder iBinder) {
        this.f4780a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4780a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.core.review.internal.zzf
    public final void zzc(String str, Bundle bundle, zzh zzhVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        parcelObtain.writeString(str);
        int i = AbstractC0818a.f4779a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(zzhVar);
        try {
            this.f4780a.transact(2, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
