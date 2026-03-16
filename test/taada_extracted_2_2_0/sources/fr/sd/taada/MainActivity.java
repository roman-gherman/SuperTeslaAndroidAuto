package fr.sd.taada;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.preference.PreferenceManager;
import fr.sd.taada.activities.BaseLocalizedActivity;
import fr.sd.taada.fragments.MainPreferenceFragment;
import fr.sd.taada.helpers.LogManager;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity extends BaseLocalizedActivity {
    private static final String TAG = "MainActivity";
    private LogManager logManager;

    @Override // fr.sd.taada.activities.BaseLocalizedActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override // fr.sd.taada.activities.BaseLocalizedActivity, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AppCompatDelegate.setDefaultNightMode(2);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        LogManager logManager = LogManager.getInstance(this);
        this.logManager = logManager;
        logManager.logDebug(TAG, "onCreate");
        if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean("hidetatusbar", true)) {
            setTheme(R.style.AppThemeNonFullScreen);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.settings);
        }
        if (findViewById(R.id.settings_container) == null || bundle != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container, new MainPreferenceFragment()).commit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.logManager.logDebug(TAG, "onDestroy");
    }

    @Override // fr.sd.taada.activities.BaseLocalizedActivity
    public void onLanguageChanged() {
        recreate();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
