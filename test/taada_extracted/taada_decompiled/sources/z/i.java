package z;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends O.a implements zzaa {
    public static final /* synthetic */ int c = 0;
    public final int b;

    public i(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.b = Arrays.hashCode(bArr);
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // O.a
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.b);
            return true;
        }
        IInterface iInterfaceZzd = zzd();
        parcel2.writeNoException();
        int i3 = P.b.f1195a;
        parcel2.writeStrongBinder((O.a) iInterfaceZzd);
        return true;
    }

    public abstract byte[] c();

    public final boolean equals(Object obj) {
        IObjectWrapper iObjectWrapperZzd;
        if (obj != null && (obj instanceof zzaa)) {
            try {
                zzaa zzaaVar = (zzaa) obj;
                if (zzaaVar.zzc() == this.b && (iObjectWrapperZzd = zzaaVar.zzd()) != null) {
                    return Arrays.equals(c(), (byte[]) com.google.android.gms.dynamic.a.b(iObjectWrapperZzd));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return new com.google.android.gms.dynamic.a(c());
    }
}
