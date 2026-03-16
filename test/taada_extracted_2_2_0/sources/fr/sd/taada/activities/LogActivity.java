package fr.sd.taada.activities;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import fr.sd.taada.R;
import fr.sd.taada.helpers.LogManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class LogActivity extends BaseLocalizedActivity implements View.OnClickListener {
    private static final String TAG = "LogActivity";
    private ImageButton buttonClear;
    private ImageButton buttonCopy;
    private ImageButton buttonRefresh;
    private ImageButton buttonShare;
    private SimpleDateFormat dateFormat;
    private LinearLayout layoutLogFiles;
    private LogManager logManager;
    private ScrollView scrollViewLogs;
    private SwitchCompat switchLogging;
    private TextView textLogContent;
    private TextView textStatus;

    private void clearAllLogs() {
        try {
            this.logManager.clearAllLogs();
            this.textLogContent.postDelayed(new h(this, 0), 500L);
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.error_clearing_logs), 0).show();
            this.logManager.logError(TAG, "Erreur lors de l'effacement des logs", e);
        }
    }

    private void copyLogsToClipboard() {
        new Thread(new h(this, 3)).start();
    }

    private void initializeViews() {
        this.switchLogging = (SwitchCompat) findViewById(R.id.switch_logging);
        this.textStatus = (TextView) findViewById(R.id.text_status);
        this.textLogContent = (TextView) findViewById(R.id.text_log_content);
        this.scrollViewLogs = (ScrollView) findViewById(R.id.scroll_view_logs);
        this.buttonRefresh = (ImageButton) findViewById(R.id.button_refresh);
        this.buttonCopy = (ImageButton) findViewById(R.id.button_copy);
        this.buttonShare = (ImageButton) findViewById(R.id.button_share);
        this.buttonClear = (ImageButton) findViewById(R.id.button_clear);
        this.layoutLogFiles = (LinearLayout) findViewById(R.id.layout_log_files);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearAllLogs$10() {
        updateUI();
        Toast.makeText(this, getString(R.string.logs_cleared), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyLogsToClipboard$6(String str) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("TaaDa Logs", str));
            Toast.makeText(this, getString(R.string.logs_copied_to_clipboard), 0).show();
            this.logManager.logInfo(TAG, "Logs copiés dans le presse-papiers");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyLogsToClipboard$7(Exception exc) {
        Toast.makeText(this, getString(R.string.error_copying_logs), 0).show();
        this.logManager.logError(TAG, "Erreur lors de la copie des logs", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyLogsToClipboard$8() {
        try {
            runOnUiThread(new i(this, this.logManager.getAllLogsAsText(), 1));
        } catch (Exception e) {
            runOnUiThread(new g(this, e, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshLogContent$2() {
        this.scrollViewLogs.fullScroll(130);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshLogContent$3(String str) {
        if (str.isEmpty()) {
            this.textLogContent.setText(getString(R.string.no_logs_available));
        } else {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 50) {
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.showing_recent_logs));
                sb.append("\n\n");
                for (int iMax = Math.max(0, strArrSplit.length - 50); iMax < strArrSplit.length; iMax++) {
                    sb.append(strArrSplit[iMax]);
                    sb.append("\n");
                }
                this.textLogContent.setText(sb.toString());
            } else {
                this.textLogContent.setText(str);
            }
        }
        this.scrollViewLogs.post(new h(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshLogContent$4(Exception exc) {
        this.textLogContent.setText(getString(R.string.error_loading_logs) + ": " + exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshLogContent$5() {
        try {
            runOnUiThread(new i(this, this.logManager.getAllLogsAsText(), 0));
        } catch (Exception e) {
            runOnUiThread(new g(this, e, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupEventListeners$0(CompoundButton compoundButton, boolean z6) {
        this.logManager.setLoggingEnabled(z6);
        updateUI();
        Toast.makeText(this, z6 ? getString(R.string.log_collection_enabled) : getString(R.string.log_collection_disabled), 0).show();
        if (z6) {
            this.textLogContent.postDelayed(new h(this, 1), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showClearLogsDialog$9(DialogInterface dialogInterface, int i) {
        clearAllLogs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUI$1(CompoundButton compoundButton, boolean z6) {
        this.logManager.setLoggingEnabled(z6);
        updateUI();
        Toast.makeText(this, z6 ? getString(R.string.log_collection_enabled) : getString(R.string.log_collection_disabled), 0).show();
        if (z6) {
            this.textLogContent.postDelayed(new h(this, 1), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLogContent() {
        new Thread(new h(this, 4)).start();
    }

    private void refreshLogFilesList() {
        this.layoutLogFiles.removeAllViews();
        List<File> logFiles = this.logManager.getLogFiles();
        if (logFiles.isEmpty()) {
            TextView textView = new TextView(this);
            textView.setText(getString(R.string.no_log_files));
            textView.setPadding(16, 8, 16, 8);
            this.layoutLogFiles.addView(textView);
            return;
        }
        for (File file : logFiles) {
            TextView textView2 = new TextView(this);
            textView2.setText(file.getName() + "\n" + getString(R.string.file_size_kb, Long.valueOf(file.length() / 1024)) + " - " + getString(R.string.last_modified, this.dateFormat.format(new Date(file.lastModified()))));
            textView2.setPadding(16, 12, 16, 12);
            textView2.setTextSize(12.0f);
            textView2.setBackground(getResources().getDrawable(R.drawable.ripple_rounded_small_button));
            this.layoutLogFiles.addView(textView2);
        }
    }

    private void setupEventListeners() {
        this.switchLogging.setOnCheckedChangeListener(new f(this, 0));
        this.buttonRefresh.setOnClickListener(this);
        this.buttonCopy.setOnClickListener(this);
        this.buttonShare.setOnClickListener(this);
        this.buttonClear.setOnClickListener(this);
    }

    private void shareLogsViaEmail() {
        try {
            this.logManager.shareLogs(this);
            this.logManager.logInfo(TAG, "Partage des logs via email initié");
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.error_sharing_logs), 0).show();
            this.logManager.logError(TAG, "Erreur lors du partage des logs", e);
        }
    }

    private void showClearLogsDialog() {
        new AlertDialog.Builder(this).setTitle(getString(R.string.clear_logs_title)).setMessage(getString(R.string.clear_logs_message)).setPositiveButton(getString(R.string.clear), new fr.sd.taada.helpers.permissions.a(this, 10)).setNegativeButton(getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
    }

    private void showLogInfo() {
        new AlertDialog.Builder(this).setTitle(getString(R.string.log_info_title)).setMessage(getString(R.string.log_info_message)).setPositiveButton(getString(R.string.understood), (DialogInterface.OnClickListener) null).show();
    }

    private void updateStatusText(boolean z6) {
        if (!z6) {
            this.textStatus.setText(getString(R.string.log_status_disabled));
            this.textStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            return;
        }
        List<File> logFiles = this.logManager.getLogFiles();
        String string = getString(R.string.log_status_enabled, Integer.valueOf(logFiles.size()));
        if (!logFiles.isEmpty()) {
            String str = this.dateFormat.format(new Date(logFiles.get(0).lastModified()));
            StringBuilder sbL = B2.b.l(string, "\n");
            sbL.append(getString(R.string.log_last_update, str));
            string = sbL.toString();
        }
        this.textStatus.setText(string);
        this.textStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
    }

    private void updateUI() {
        boolean zIsLoggingEnabled = this.logManager.isLoggingEnabled();
        this.switchLogging.setOnCheckedChangeListener(null);
        this.switchLogging.setChecked(zIsLoggingEnabled);
        this.switchLogging.setOnCheckedChangeListener(new f(this, 1));
        updateStatusText(zIsLoggingEnabled);
        this.buttonRefresh.setEnabled(zIsLoggingEnabled);
        this.buttonCopy.setEnabled(zIsLoggingEnabled);
        this.buttonShare.setEnabled(zIsLoggingEnabled);
        this.buttonClear.setEnabled(zIsLoggingEnabled);
        if (zIsLoggingEnabled) {
            refreshLogContent();
            refreshLogFilesList();
        } else {
            this.textLogContent.setText(getString(R.string.log_collection_disabled_message));
            this.layoutLogFiles.removeAllViews();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_refresh) {
            refreshLogContent();
            this.logManager.logInfo(TAG, "Logs rafraîchis manuellement");
        } else if (id == R.id.button_copy) {
            copyLogsToClipboard();
        } else if (id == R.id.button_share) {
            shareLogsViaEmail();
        } else if (id == R.id.button_clear) {
            showClearLogsDialog();
        }
    }

    @Override // fr.sd.taada.activities.BaseLocalizedActivity, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_log);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.log_management));
        }
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        this.logManager = LogManager.getInstance(this);
        initializeViews();
        setupEventListeners();
        updateUI();
        this.logManager.logInfo(TAG, "Activité de gestion des logs ouverte");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_log, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.logManager.logInfo(TAG, "Activité de gestion des logs fermée");
    }

    @Override // fr.sd.taada.activities.BaseLocalizedActivity
    public void onLanguageChanged() {
        recreate();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId == R.id.action_refresh) {
            refreshLogContent();
            return true;
        }
        if (itemId != R.id.action_info) {
            return super.onOptionsItemSelected(menuItem);
        }
        showLogInfo();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
