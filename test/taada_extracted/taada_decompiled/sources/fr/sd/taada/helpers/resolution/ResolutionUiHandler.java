package fr.sd.taada.helpers.resolution;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.navigation.b;
import androidx.preference.PreferenceManager;
import com.google.android.material.button.MaterialButtonToggleGroup;
import fr.sd.taada.R;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.service.ServiceRestartScheduler;

/* JADX INFO: loaded from: classes2.dex */
public class ResolutionUiHandler {
    private static final String PREF_RESOLUTION = "resolution";
    private static final String RES_1080P_VALUE = "2";
    private static final String RES_480P_VALUE = "0";
    private static final String RES_720P_VALUE = "1";
    private static final String TAG = "ResolutionUiHandler";
    private final Context context;
    private TextView experimentalLabel;
    private ImageButton infoButton;
    private final LogManager logManager;
    private MaterialButtonToggleGroup resolutionToggleGroup;
    private final ServiceRestartScheduler restartScheduler;

    public ResolutionUiHandler(@NonNull Context context, @NonNull LogManager logManager, @NonNull ServiceRestartScheduler.RestartCallback restartCallback) {
        this.context = context;
        this.logManager = logManager;
        this.restartScheduler = new ServiceRestartScheduler(logManager, restartCallback);
    }

    private void handleResolutionSelection(int i) {
        String str;
        boolean z6 = false;
        if (i == R.id.res480pButton) {
            str = RES_480P_VALUE;
        } else if (i == R.id.res1080pButton) {
            str = RES_1080P_VALUE;
            z6 = true;
        } else {
            str = RES_720P_VALUE;
        }
        saveResolutionPreference(str);
        updateExperimentalLabel(z6);
        this.restartScheduler.scheduleRestart("Resolution Change: ".concat(str), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViews$0(View view) {
        showResolutionInfoDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$1(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z6) {
        if (z6) {
            handleResolutionSelection(i);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void loadCurrentResolution() {
        /*
            r5 = this;
            android.content.Context r0 = r5.context
            android.content.SharedPreferences r0 = androidx.preference.PreferenceManager.getDefaultSharedPreferences(r0)
            java.lang.String r1 = "resolution"
            java.lang.String r2 = "1"
            java.lang.String r0 = r0.getString(r1, r2)
            int r1 = r0.hashCode()
            r3 = 1
            r4 = 0
            switch(r1) {
                case 48: goto L2a;
                case 49: goto L22;
                case 50: goto L18;
                default: goto L17;
            }
        L17:
            goto L34
        L18:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L34
            r0 = r3
            goto L35
        L22:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L34
            r0 = 2
            goto L35
        L2a:
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L34
            r0 = r4
            goto L35
        L34:
            r0 = -1
        L35:
            if (r0 == 0) goto L40
            if (r0 == r3) goto L3c
            int r0 = fr.sd.taada.R.id.res720pButton
            goto L42
        L3c:
            int r0 = fr.sd.taada.R.id.res1080pButton
            r4 = r3
            goto L42
        L40:
            int r0 = fr.sd.taada.R.id.res480pButton
        L42:
            com.google.android.material.button.MaterialButtonToggleGroup r1 = r5.resolutionToggleGroup
            int r1 = r1.getCheckedButtonId()
            if (r1 == r0) goto L4f
            com.google.android.material.button.MaterialButtonToggleGroup r1 = r5.resolutionToggleGroup
            r1.b(r0, r3)
        L4f:
            r5.updateExperimentalLabel(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.helpers.resolution.ResolutionUiHandler.loadCurrentResolution():void");
    }

    private void saveResolutionPreference(String str) {
        PreferenceManager.getDefaultSharedPreferences(this.context).edit().putString(PREF_RESOLUTION, str).apply();
        this.logManager.logInfo(TAG, "Resolution preference saved: " + str);
    }

    private void showResolutionInfoDialog() {
        new AlertDialog.Builder(this.context, R.style.AppDialogTheme).setTitle(R.string.resolution_info).setMessage(R.string.resolution_info_message).setPositiveButton(R.string.understood, (DialogInterface.OnClickListener) null).setIcon(R.drawable.ic_baseline_computer_24).show();
    }

    private void updateExperimentalLabel(boolean z6) {
        TextView textView = this.experimentalLabel;
        if (textView != null) {
            textView.setVisibility(z6 ? 0 : 4);
        }
    }

    public void bindViews(@NonNull MaterialButtonToggleGroup materialButtonToggleGroup, @NonNull TextView textView, @NonNull ImageButton imageButton) {
        this.resolutionToggleGroup = materialButtonToggleGroup;
        this.experimentalLabel = textView;
        this.infoButton = imageButton;
        imageButton.setOnClickListener(new b(this, 5));
    }

    public void initialize() {
        if (this.resolutionToggleGroup == null) {
            this.logManager.logError(TAG, "Cannot initialize: Views not bound");
            return;
        }
        loadCurrentResolution();
        MaterialButtonToggleGroup materialButtonToggleGroup = this.resolutionToggleGroup;
        materialButtonToggleGroup.c.add(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: e1.a
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i, boolean z6) {
                this.f3129a.lambda$initialize$1(materialButtonToggleGroup2, i, z6);
            }
        });
    }

    public void onDestroy() {
        this.restartScheduler.cancelRestart();
    }
}
