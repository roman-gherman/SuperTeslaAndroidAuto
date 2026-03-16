package fr.sd.taada.helpers.dialogs;

import B2.b;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.net.MailTo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import f0.C0440b;
import fr.sd.taada.R;
import fr.sd.taada.helpers.LogManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackDialogHelper {
    private static final String EMAIL_SUBJECT = "TaaDa Feedback - Anonymous";
    private static final String FEEDBACK_EMAIL = "seb.duboc.dev@gmail.com";
    private static final String TAG = "FeedbackDialogHelper";
    private final Activity activity;
    private final LogManager logManager;

    public FeedbackDialogHelper(@NonNull Activity activity, @NonNull LogManager logManager) {
        this.activity = activity;
        this.logManager = logManager;
    }

    private String buildEmailBody(String str) {
        StringBuilder sbM = b.m("Feedback from TaaDa user:\n\n", str, "\n\n--- Device Info ---\nAndroid Version: ");
        sbM.append(Build.VERSION.RELEASE);
        sbM.append(" (API ");
        int i = Build.VERSION.SDK_INT;
        sbM.append(i);
        sbM.append(")\nDevice: ");
        sbM.append(Build.MANUFACTURER);
        sbM.append(" ");
        sbM.append(Build.MODEL);
        try {
            PackageInfo packageInfo = this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), 0);
            if (i >= 28) {
                sbM.append("\nApp Version: ");
                sbM.append(packageInfo.versionName);
                sbM.append(" (");
                sbM.append(packageInfo.getLongVersionCode());
                sbM.append(")");
            } else {
                sbM.append("\nApp Version: ");
                sbM.append(packageInfo.versionName);
                sbM.append(" (");
                sbM.append(packageInfo.versionCode);
                sbM.append(")");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            sbM.append("\nApp Version: Unknown");
        }
        return sbM.toString();
    }

    private ArrayList<ComponentName> getExcludedComponents(List<ResolveInfo> list) {
        ArrayList<ComponentName> arrayList = new ArrayList<>();
        for (ResolveInfo resolveInfo : list) {
            String str = resolveInfo.activityInfo.packageName;
            Locale locale = Locale.ROOT;
            if (str.toLowerCase(locale).contains("paypal") || str.toLowerCase(locale).contains("venmo") || str.toLowerCase(locale).contains("cashapp") || str.toLowerCase(locale).contains("zelle")) {
                arrayList.add(new ComponentName(str, resolveInfo.activityInfo.name));
                this.logManager.logInfo(TAG, "Excluded from chooser: ".concat(str));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFeedbackDialog$1(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
        this.logManager.logInfo(TAG, "User dismissed feedback dialog with 'later' button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFeedbackDialog$2(TextInputEditText textInputEditText, AlertDialog alertDialog, View view) {
        String strTrim = textInputEditText.getText() != null ? textInputEditText.getText().toString().trim() : "";
        if (strTrim.isEmpty()) {
            Toast.makeText(this.activity, "Veuillez entrer votre feedback", 0).show();
        } else {
            sendFeedback(strTrim);
            alertDialog.dismiss();
        }
    }

    private void sendFeedback(String str) {
        try {
            StringBuilder sb = new StringBuilder(MailTo.MAILTO_SCHEME);
            sb.append(Uri.encode(FEEDBACK_EMAIL));
            sb.append("?subject=");
            sb.append(Uri.encode(EMAIL_SUBJECT));
            String strBuildEmailBody = buildEmailBody(str);
            sb.append("&body=");
            sb.append(Uri.encode(strBuildEmailBody));
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse(sb.toString()));
            ArrayList<ComponentName> excludedComponents = getExcludedComponents(this.activity.getPackageManager().queryIntentActivities(intent, 131072));
            Intent intentCreateChooser = Intent.createChooser(intent, "Envoyer le feedback");
            if (!excludedComponents.isEmpty()) {
                intentCreateChooser.putExtra("android.intent.extra.EXCLUDE_COMPONENTS", (Parcelable[]) excludedComponents.toArray(new ComponentName[0]));
            }
            this.activity.startActivity(intentCreateChooser);
            Toast.makeText(this.activity, "Merci pour votre feedback !", 0).show();
            this.logManager.logInfo(TAG, "Feedback email intent created successfully");
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this.activity, "Aucune application email installée", 1).show();
            this.logManager.logWarning(TAG, "No email app found for feedback");
        } catch (Exception e) {
            this.logManager.logError(TAG, "Error sending feedback", e);
            Toast.makeText(this.activity, "Erreur lors de l'envoi du feedback", 0).show();
        }
    }

    public void showFeedbackDialog() {
        try {
            View viewInflate = this.activity.getLayoutInflater().inflate(R.layout.dialog_feedback, (ViewGroup) null);
            ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.closeButton);
            final TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(R.id.feedbackEditText);
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.sendFeedbackButton);
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.laterButton);
            final AlertDialog alertDialogCreate = new C0440b(this.activity).j(viewInflate).a(true).create();
            if (alertDialogCreate.getWindow() != null) {
                alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            imageButton.setOnClickListener(new androidx.navigation.b(alertDialogCreate, 4));
            materialButton2.setOnClickListener(new androidx.navigation.ui.b(1, this, alertDialogCreate));
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: d1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3118a.lambda$showFeedbackDialog$2(textInputEditText, alertDialogCreate, view);
                }
            });
            alertDialogCreate.show();
            this.logManager.logInfo(TAG, "Feedback dialog displayed");
        } catch (Exception e) {
            this.logManager.logError(TAG, "Error showing feedback dialog", e);
            Toast.makeText(this.activity, "Erreur lors de l'affichage du feedback", 0).show();
        }
    }
}
