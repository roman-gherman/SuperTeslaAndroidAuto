package fr.sd.taada.activities;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import fr.sd.taada.helpers.LocaleHelper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseLocalizedActivity extends AppCompatActivity {
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleHelper.initializeLocale(context));
    }

    public void changeLanguage(String str) {
        LocaleHelper.setLanguage(this, str);
        onLanguageChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LocaleHelper.initializeLocale(this);
    }

    public void onLanguageChanged() {
        recreate();
    }

    public void triggerLanguageChange() {
        onLanguageChanged();
    }
}
