package com.google.android.gms.common.moduleinstall;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new h(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1971a;
    public final int b;
    public final Long c;
    public final Long d;
    public final int e;

    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    public ModuleInstallStatusUpdate(int i, int i3, Long l6, Long l7, int i4) {
        this.f1971a = i;
        this.b = i3;
        this.c = l6;
        this.d = l7;
        this.e = i4;
        if (l6 != null && l7 != null && l7.longValue() != 0 && l7.longValue() == 0) {
            throw new IllegalArgumentException("Given Long is zero");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1971a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        Long l6 = this.c;
        if (l6 != null) {
            AbstractC0132a.u0(parcel, 3, 8);
            parcel.writeLong(l6.longValue());
        }
        Long l7 = this.d;
        if (l7 != null) {
            AbstractC0132a.u0(parcel, 4, 8);
            parcel.writeLong(l7.longValue());
        }
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e);
        AbstractC0132a.t0(parcel, iS0);
    }
}
