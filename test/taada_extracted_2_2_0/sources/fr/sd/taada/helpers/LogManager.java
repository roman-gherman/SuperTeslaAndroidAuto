package fr.sd.taada.helpers;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.content.FileProvider;
import androidx.preference.PreferenceManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class LogManager {
    private static final boolean DEFAULT_LOG_ENABLED = false;
    private static final String DEFAULT_LOG_LEVEL = "DEBUG";
    private static final int DEFAULT_MAX_FILES = 7;
    private static final int DEFAULT_MAX_SIZE_MB = 10;
    private static final Set<String> FILTERED_TAGS = new HashSet(Arrays.asList("MessageHandler", "HU-TransportService_", "HU-MEDIACODEC", "MessgaeProcessor", "HU-VpnService", "HU-NewVpnService", "MessageHandler", "RawMessageData", "AAGateWay", "AA_GATEWAY_SERVER", "SSL", "NaiveTrustManager", "MessageProcessor"));
    private static final String LOG_FILE_EXTENSION = ".txt";
    private static final String LOG_FILE_PREFIX = "taada_log_";
    public static final String PREF_LOG_ENABLED = "log_collection_enabled";
    public static final String PREF_LOG_LEVEL = "log_level";
    public static final String PREF_LOG_MAX_FILES = "log_max_files";
    public static final String PREF_LOG_MAX_SIZE_MB = "log_max_size_mb";
    private static final String TAG = "LogManager";
    private static LogManager instance;
    private final Context context;
    private File currentLogFile;
    private BufferedWriter currentWriter;
    private final SimpleDateFormat dateFormat;
    private final ExecutorService executor;
    private final SimpleDateFormat fileNameFormat;
    private boolean isInitializing = false;
    private boolean isLoggingEnabled;
    private File logDirectory;
    private final SharedPreferences preferences;

    private LogManager(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.context = applicationContext;
            this.preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            initializeLogDirectory();
            loadSettings();
            setupUncaughtExceptionHandler();
        } else {
            this.context = null;
            this.preferences = null;
            this.isLoggingEnabled = false;
        }
        this.executor = Executors.newSingleThreadExecutor();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.fileNameFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    private void cleanupOldLogFiles() {
        File file = this.logDirectory;
        if (file == null || !file.exists()) {
            return;
        }
        try {
            File[] fileArrListFiles = this.logDirectory.listFiles(new d(2));
            if (fileArrListFiles == null || fileArrListFiles.length <= 7) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, fileArrListFiles);
            arrayList.sort(new e(1));
            int size = arrayList.size() - 7;
            for (int i = 0; i < size; i++) {
                File file2 = (File) arrayList.get(i);
                if (file2.delete()) {
                    file2.getName();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Erreur lors du nettoyage des anciens logs", e);
        }
    }

    private void closeCurrentLogFile() {
        BufferedWriter bufferedWriter = this.currentWriter;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.flush();
                this.currentWriter.close();
            } catch (IOException e) {
                Log.e(TAG, "Erreur lors de la fermeture du fichier de log", e);
            } finally {
                this.currentWriter = null;
            }
        }
    }

    private void createNewLogFile() {
        closeCurrentLogFile();
        this.currentLogFile = new File(this.logDirectory, LOG_FILE_PREFIX + this.fileNameFormat.format(new Date()) + LOG_FILE_EXTENSION);
        this.currentWriter = new BufferedWriter(new FileWriter(this.currentLogFile, true));
        writeLogEntry("SYSTEM", "=== NOUVELLE SESSION DE LOGS ===");
        writeLogEntry("SYSTEM", "Application: " + this.context.getPackageName());
        StringBuilder sb = new StringBuilder("Version Android: ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(" (API ");
        writeLogEntry("SYSTEM", B2.b.g(sb, ")", Build.VERSION.SDK_INT));
        writeLogEntry("SYSTEM", "Modèle: " + Build.MANUFACTURER + " " + Build.MODEL);
        writeLogEntry("SYSTEM", "=====================================");
        cleanupOldLogFiles();
    }

    private synchronized void ensureLogFileReady() {
        if (this.currentWriter == null && !this.isInitializing && this.context != null && this.isLoggingEnabled) {
            this.isInitializing = true;
            try {
                try {
                    createNewLogFile();
                    logSystemInfo();
                } catch (Exception e) {
                    Log.e(TAG, "❌ Erreur lors de l'initialisation synchrone du fichier de log", e);
                }
            } finally {
            }
        }
    }

    public static synchronized LogManager getInstance(Context context) {
        try {
            LogManager logManager = instance;
            if (logManager == null) {
                instance = new LogManager(context);
            } else if (context != null && logManager.context == null) {
                instance = new LogManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private void initializeLogDirectory() {
        if (this.context == null) {
            return;
        }
        try {
            File file = new File(this.context.getFilesDir(), "logs");
            this.logDirectory = file;
            if (file.exists() || this.logDirectory.mkdirs()) {
                this.logDirectory.getAbsolutePath();
            } else {
                Log.e(TAG, "Impossible de créer le répertoire des logs");
            }
        } catch (Exception e) {
            Log.e(TAG, "Erreur lors de l'initialisation du répertoire des logs", e);
        }
    }

    private boolean isTagFiltered(String str) {
        return FILTERED_TAGS.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$cleanupOldLogFiles$7(File file, String str) {
        return str.startsWith(LOG_FILE_PREFIX) && str.endsWith(LOG_FILE_EXTENSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$cleanupOldLogFiles$8(File file, File file2) {
        return Long.compare(file.lastModified(), file2.lastModified());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$clearAllLogs$11(File file, String str) {
        return str.startsWith(LOG_FILE_PREFIX) && str.endsWith(LOG_FILE_EXTENSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearAllLogs$12() {
        File[] fileArrListFiles;
        try {
            closeCurrentLogFile();
            File file = this.logDirectory;
            if (file != null && file.exists() && (fileArrListFiles = this.logDirectory.listFiles(new d(0))) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.delete()) {
                        file2.getName();
                    }
                }
            }
            this.isInitializing = false;
            if (this.isLoggingEnabled) {
                logInfo(TAG, "Logs effacés et nouvelle session démarrée");
            }
        } catch (Exception e) {
            Log.e(TAG, "Erreur lors de l'effacement des logs", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getLogFiles$10(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getLogFiles$9(File file, String str) {
        return str.startsWith(LOG_FILE_PREFIX) && str.endsWith(LOG_FILE_EXTENSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logDebug$2(String str, String str2) {
        writeLogEntry(DEFAULT_LOG_LEVEL, androidx.constraintlayout.core.motion.a.r("[", str, "] ", str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logError$4(String str, String str2, Throwable th) {
        writeLogEntry("ERROR", androidx.constraintlayout.core.motion.a.r("[", str, "] ", str2));
        if (th != null) {
            writeLogEntry("ERROR", "Exception: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            StringBuilder sb = new StringBuilder("Stack trace: ");
            sb.append(Log.getStackTraceString(th));
            writeLogEntry("ERROR", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logInfo$1(String str, String str2) {
        writeLogEntry("INFO", androidx.constraintlayout.core.motion.a.r("[", str, "] ", str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logWarning$3(String str, String str2) {
        writeLogEntry("WARNING", androidx.constraintlayout.core.motion.a.r("[", str, "] ", str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupUncaughtExceptionHandler$5() {
        try {
            BufferedWriter bufferedWriter = this.currentWriter;
            if (bufferedWriter != null) {
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            Log.e(TAG, "Erreur lors du flush des logs d'exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupUncaughtExceptionHandler$6(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        if (this.isLoggingEnabled) {
            logError(TAG, "EXCEPTION NON GÉRÉE dans le thread: " + thread.getName(), th);
            this.executor.execute(new b(this, 2));
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopLogging$0() {
        try {
            closeCurrentLogFile();
        } catch (Exception e) {
            Log.e(TAG, "Erreur lors de l'arrêt des logs", e);
        }
    }

    private void loadSettings() {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences != null) {
            this.isLoggingEnabled = sharedPreferences.getBoolean(PREF_LOG_ENABLED, false);
        }
        this.isLoggingEnabled = false;
    }

    private void logSystemInfo() {
        writeLogEntry("SYSTEM", "Mémoire libre: " + (Runtime.getRuntime().freeMemory() / 1048576) + " MB");
        writeLogEntry("SYSTEM", "Mémoire totale: " + (Runtime.getRuntime().totalMemory() / 1048576) + " MB");
        writeLogEntry("SYSTEM", "Mémoire max: " + (Runtime.getRuntime().maxMemory() / 1048576) + " MB");
    }

    private void setupUncaughtExceptionHandler() {
        if (this.context == null) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: fr.sd.taada.helpers.c
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                this.f3277a.lambda$setupUncaughtExceptionHandler$6(defaultUncaughtExceptionHandler, thread, th);
            }
        });
    }

    private void startLogging() {
    }

    private void stopLogging() {
        this.executor.execute(new b(this, 0));
    }

    private void writeLogEntry(String str, String str2) {
        ensureLogFileReady();
        if (this.currentWriter == null) {
            if (this.context == null) {
                return;
            }
            Log.w(TAG, "⚠️ currentWriter toujours null après ensureLogFileReady() - logging:" + this.isLoggingEnabled + " initializing:" + this.isInitializing);
            return;
        }
        try {
            this.currentWriter.write(this.dateFormat.format(new Date()) + " [" + str + "] " + str2 + "\n");
            this.currentWriter.flush();
        } catch (IOException e) {
            Log.e(TAG, "Erreur lors de l'écriture du log", e);
        }
    }

    public void addFilteredTag(String str) {
        Set<String> set = FILTERED_TAGS;
        synchronized (set) {
            set.add(str);
            logInfo(TAG, "🔇 TAG '" + str + "' ajouté à la liste des filtrés");
        }
    }

    public void clearAllFilters() {
        Set<String> set = FILTERED_TAGS;
        synchronized (set) {
            int size = set.size();
            set.clear();
            logInfo(TAG, "🔊 Tous les filtres supprimés (" + size + " TAGs démasqués)");
        }
    }

    public void clearAllLogs() {
        this.executor.execute(new b(this, 1));
    }

    public void copyLogsToClipboard(Context context) {
        if (this.isLoggingEnabled) {
            try {
                String allLogsAsText = getAllLogsAsText();
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("TaaDa Logs", allLogsAsText));
                }
            } catch (Exception e) {
                Log.e(TAG, "Erreur lors de la copie des logs", e);
            }
        }
    }

    public String getAllLogsAsText() {
        StringBuilder sb = new StringBuilder();
        for (File file : getLogFiles()) {
            sb.append("=== ");
            sb.append(file.getName());
            sb.append(" ===\n");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
            } catch (IOException e) {
                sb.append("Erreur lors de la lecture du fichier: ");
                sb.append(e.getMessage());
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Set<String> getFilteredTags() {
        HashSet hashSet;
        Set<String> set = FILTERED_TAGS;
        synchronized (set) {
            hashSet = new HashSet(set);
        }
        return hashSet;
    }

    public List<File> getLogFiles() {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        File file = this.logDirectory;
        if (file != null && file.exists() && (fileArrListFiles = this.logDirectory.listFiles(new d(1))) != null) {
            Collections.addAll(arrayList, fileArrListFiles);
            arrayList.sort(new e(0));
        }
        return arrayList;
    }

    public boolean isDebugEnabled(String str) {
        return this.isLoggingEnabled && !isTagFiltered(str);
    }

    public boolean isLoggingEnabled() {
        return this.isLoggingEnabled;
    }

    public void logDebug(String str, String str2) {
        if (!this.isLoggingEnabled || isTagFiltered(str)) {
            return;
        }
        this.executor.execute(new a(this, str, str2, 1));
    }

    public void logError(String str, String str2, Throwable th) {
        if (this.isLoggingEnabled) {
            Log.e(str, str2, th);
            this.executor.execute(new androidx.work.impl.d(this, str, str2, th, 2));
        }
    }

    public void logInfo(String str, String str2) {
        if (!this.isLoggingEnabled || isTagFiltered(str)) {
            return;
        }
        this.executor.execute(new a(this, str, str2, 2));
    }

    public void logWarning(String str, String str2) {
        if (this.isLoggingEnabled) {
            Log.w(str, str2);
            if (isTagFiltered(str)) {
                return;
            }
            this.executor.execute(new a(this, str, str2, 0));
        }
    }

    public void removeFilteredTag(String str) {
        Set<String> set = FILTERED_TAGS;
        synchronized (set) {
            try {
                if (set.remove(str)) {
                    logInfo(TAG, "🔊 TAG '" + str + "' retiré de la liste des filtrés");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void restoreDefaultFilters() throws Throwable {
        Set<String> set = FILTERED_TAGS;
        synchronized (set) {
            try {
                try {
                    set.clear();
                    set.addAll(Arrays.asList("MessageHandler", "TouchEventHandler", "HU-MEDIACODEC", "MessgaeProcessor", "CarScreen", "RESO", "CarSetup", "CAR-BUILD", "Input", "Mic", "Screen", "WebServer", "ControlSocketServer", "AAGateWay", "AA_GATEWAY_SERVER", "SSL", "NaiveTrustManager"));
                    logInfo(TAG, "🔇 Filtres par défaut restaurés (" + set.size() + " TAGs filtrés)");
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void setLoggingEnabled(boolean z6) {
        if (z6) {
            z6 = false;
        }
        if (this.isLoggingEnabled != z6) {
            this.isLoggingEnabled = z6;
            SharedPreferences sharedPreferences = this.preferences;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean(PREF_LOG_ENABLED, z6).apply();
            }
            if (z6) {
                startLogging();
                logInfo(TAG, "Collecte des logs activée".concat(this.context == null ? " (mode logcat uniquement)" : ""));
            } else {
                logInfo(TAG, "Collecte des logs désactivée (forcée par configuration)");
                stopLogging();
            }
        }
    }

    public void shareLogs(Context context) {
        if (this.isLoggingEnabled) {
            List<File> logFiles = getLogFiles();
            if (logFiles.isEmpty()) {
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", "TaaDa - Logs de diagnostic");
                intent.putExtra("android.intent.extra.TEXT", "Logs de diagnostic de l'application TaaDa\n\nApplication: " + context.getPackageName() + "\nAndroid: " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")\nAppareil: " + Build.MANUFACTURER + " " + Build.MODEL + "\nDate: " + new Date().toString() + "\n\nVeuillez décrire le problème rencontré :\n\n");
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (File file : logFiles) {
                    try {
                        arrayList.add(FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file));
                    } catch (Exception e) {
                        Log.e(TAG, "Erreur lors de la création de l'URI pour " + file.getName(), e);
                    }
                }
                if (!arrayList.isEmpty()) {
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                    intent.addFlags(1);
                }
                Intent intentCreateChooser = Intent.createChooser(intent, "Envoyer les logs");
                intentCreateChooser.addFlags(268435456);
                context.startActivity(intentCreateChooser);
            } catch (Exception e6) {
                Log.e(TAG, "Erreur lors du partage des logs", e6);
            }
        }
    }

    public void shutdown() {
        closeCurrentLogFile();
        this.executor.shutdown();
    }

    public void logError(String str, String str2) {
        logError(str, str2, null);
    }
}
