package D;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.IAccountAccessor;

/* JADX INFO: loaded from: classes.dex */
public final class u extends P.a implements IAccountAccessor {
    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.c);
        Parcel parcelA = a(parcelObtain, 2);
        Account account = (Account) P.b.a(parcelA, Account.CREATOR);
        parcelA.recycle();
        return account;
    }
}
