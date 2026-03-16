package w;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;

/* JADX INFO: renamed from: w.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0860a implements IGetInstallReferrerService, IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f4955a;

    public C0860a(IBinder iBinder) {
        this.f4955a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4955a;
    }

    @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
    public final Bundle c(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        int i = j.a.f3644a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain = Parcel.obtain();
        try {
            this.f4955a.transact(1, parcelObtain, parcelObtain, 0);
            parcelObtain.readException();
            parcelObtain.recycle();
            return (Bundle) (parcelObtain.readInt() == 0 ? null : (Parcelable) Bundle.CREATOR.createFromParcel(parcelObtain));
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcelObtain.recycle();
        }
    }
}
