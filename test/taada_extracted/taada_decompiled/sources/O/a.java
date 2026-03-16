package O;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.billingclient.api.B;
import com.google.android.gms.internal.play_billing.AbstractC0270d;
import t0.AbstractC0818a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1173a;

    public boolean a(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        int i = this.f1173a;
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
        switch (this.f1173a) {
            case 1:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i3)) {
                    return true;
                }
                return a(i, parcel, parcel2);
            case 2:
            default:
                return super.onTransact(i, parcel, parcel2, i3);
            case 3:
                if (i > 16777215) {
                    if (!super.onTransact(i, parcel, parcel2, i3)) {
                    }
                    return true;
                }
                parcel.enforceInterface(getInterfaceDescriptor());
                B b = (B) this;
                if (i != 1) {
                    return false;
                }
                int i4 = parcel.readInt();
                int i5 = AbstractC0270d.f2074a;
                int iDataAvail = parcel.dataAvail();
                if (iDataAvail > 0) {
                    throw new BadParcelableException(B2.b.c(iDataAvail, "Parcel data not fully consumed, unread size: "));
                }
                b.zza(i4);
                return true;
            case 4:
                if (i > 16777215) {
                    if (!super.onTransact(i, parcel, parcel2, i3)) {
                    }
                    return true;
                }
                parcel.enforceInterface(getInterfaceDescriptor());
                com.google.android.play.core.review.e eVar = (com.google.android.play.core.review.e) this;
                if (i != 2) {
                    return false;
                }
                Parcelable.Creator creator = Bundle.CREATOR;
                int i6 = AbstractC0818a.f4779a;
                Bundle bundle = (Bundle) (parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel));
                int iDataAvail2 = parcel.dataAvail();
                if (iDataAvail2 > 0) {
                    throw new BadParcelableException(B2.b.c(iDataAvail2, "Parcel data not fully consumed, unread size: "));
                }
                eVar.zzb(bundle);
                return true;
        }
    }

    public a(String str) {
        this.f1173a = 1;
        attachInterface(this, str);
    }
}
