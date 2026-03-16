package z;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes.dex */
public class f extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlertDialog f5163a;
    public DialogInterface.OnCancelListener b;
    public AlertDialog c;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = this.f5163a;
        if (alertDialog != null) {
            return alertDialog;
        }
        setShowsDialog(false);
        if (this.c == null) {
            Context context = getContext();
            D.j.c(context);
            this.c = new AlertDialog.Builder(context).create();
        }
        return this.c;
    }
}
