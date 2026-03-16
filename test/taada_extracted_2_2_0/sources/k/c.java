package K;

import android.os.Parcel;
import android.os.Parcelable;
import c4.AbstractC0246d;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iM0 = AbstractC0246d.M0(parcel);
        int iQ0 = 0;
        int iQ02 = 0;
        int iQ03 = 0;
        int iQ04 = 0;
        boolean zL0 = false;
        String strA = null;
        ArrayList arrayListB = null;
        String strA2 = null;
        String strA3 = null;
        String strA4 = null;
        String strA5 = null;
        long jR0 = 0;
        long jR02 = 0;
        long jR03 = 0;
        float fN0 = 0.0f;
        while (parcel.dataPosition() < iM0) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iQ0 = AbstractC0246d.q0(parcel, i);
                    break;
                case 2:
                    jR0 = AbstractC0246d.r0(parcel, i);
                    break;
                case 3:
                case 7:
                case '\t':
                default:
                    AbstractC0246d.B0(parcel, i);
                    break;
                case 4:
                    strA = AbstractC0246d.A(parcel, i);
                    break;
                case 5:
                    iQ03 = AbstractC0246d.q0(parcel, i);
                    break;
                case 6:
                    arrayListB = AbstractC0246d.B(parcel, i);
                    break;
                case '\b':
                    jR02 = AbstractC0246d.r0(parcel, i);
                    break;
                case '\n':
                    strA3 = AbstractC0246d.A(parcel, i);
                    break;
                case 11:
                    iQ02 = AbstractC0246d.q0(parcel, i);
                    break;
                case '\f':
                    strA2 = AbstractC0246d.A(parcel, i);
                    break;
                case '\r':
                    strA4 = AbstractC0246d.A(parcel, i);
                    break;
                case 14:
                    iQ04 = AbstractC0246d.q0(parcel, i);
                    break;
                case 15:
                    fN0 = AbstractC0246d.n0(parcel, i);
                    break;
                case 16:
                    jR03 = AbstractC0246d.r0(parcel, i);
                    break;
                case 17:
                    strA5 = AbstractC0246d.A(parcel, i);
                    break;
                case 18:
                    zL0 = AbstractC0246d.l0(parcel, i);
                    break;
            }
        }
        AbstractC0246d.J(parcel, iM0);
        return new WakeLockEvent(iQ0, jR0, iQ02, strA, iQ03, arrayListB, strA2, jR02, iQ04, strA3, strA4, fN0, jR03, strA5, zL0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
