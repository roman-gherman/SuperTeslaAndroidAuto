package fr.sd.taada.helpers;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import androidx.preference.PreferenceManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleHelper {
    private static final String DEFAULT_LANGUAGE = "en";
    public static final String LANGUAGE_AUTO = "auto";
    public static final String LANGUAGE_CZECH = "cs";
    public static final String LANGUAGE_DANISH = "da";
    public static final String LANGUAGE_DUTCH = "nl";
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_FINNISH = "fi";
    public static final String LANGUAGE_FRENCH = "fr";
    public static final String LANGUAGE_GERMAN = "de";
    public static final String LANGUAGE_GREEK = "el";
    public static final String LANGUAGE_IRISH = "ga";
    public static final String LANGUAGE_ITALIAN = "it";
    public static final String LANGUAGE_NORWEGIAN = "no";
    public static final String LANGUAGE_ROMANSH = "rm";
    public static final String LANGUAGE_SPANISH = "es";
    public static final String LANGUAGE_SWEDISH = "sv";
    private static final String PREF_LANGUAGE = "app_language";
    private static final String TAG = "LocaleHelper";

    private static Context applyLanguage(Context context, String str) {
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        Locale.setDefault(localeForLanguageTag);
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(localeForLanguageTag);
        return context.createConfigurationContext(configuration);
    }

    private static String detectSystemLanguage() {
        Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        String language = locale.getLanguage();
        locale.toString();
        return isSupportedLanguage(language) ? language : "en";
    }

    public static String getCurrentLanguage(Context context) {
        String selectedLanguage = getSelectedLanguage(context);
        return LANGUAGE_AUTO.equals(selectedLanguage) ? validateLanguage(detectSystemLanguage()) : validateLanguage(selectedLanguage);
    }

    public static String getSelectedLanguage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_LANGUAGE, LANGUAGE_AUTO);
    }

    public static String[] getSupportedLanguageNames(Context context) {
        return new String[]{"Auto (System)", "English", "Français", "Deutsch", "Italiano", "Español", "Nederlands", "Dansk", "Svenska", "Norsk", "Suomi", "Čeština", "Ελληνικά", "Gaeilge", "Rumantsch"};
    }

    public static String[] getSupportedLanguages() {
        return new String[]{LANGUAGE_AUTO, "en", LANGUAGE_FRENCH, LANGUAGE_GERMAN, LANGUAGE_ITALIAN, LANGUAGE_SPANISH, LANGUAGE_DUTCH, LANGUAGE_DANISH, LANGUAGE_SWEDISH, LANGUAGE_NORWEGIAN, LANGUAGE_FINNISH, LANGUAGE_CZECH, LANGUAGE_GREEK, LANGUAGE_IRISH, LANGUAGE_ROMANSH};
    }

    public static Context initializeLocale(Context context) {
        String selectedLanguage = getSelectedLanguage(context);
        if (LANGUAGE_AUTO.equals(selectedLanguage)) {
            selectedLanguage = detectSystemLanguage();
        }
        return applyLanguage(context, validateLanguage(selectedLanguage));
    }

    public static boolean isRTL(Context context) {
        getCurrentLanguage(context);
        return false;
    }

    public static boolean isSupportedLanguage(String str) {
        return "en".equals(str) || LANGUAGE_FRENCH.equals(str) || LANGUAGE_GERMAN.equals(str) || LANGUAGE_ITALIAN.equals(str) || LANGUAGE_SPANISH.equals(str) || LANGUAGE_DUTCH.equals(str) || LANGUAGE_DANISH.equals(str) || LANGUAGE_SWEDISH.equals(str) || LANGUAGE_NORWEGIAN.equals(str) || LANGUAGE_FINNISH.equals(str) || LANGUAGE_CZECH.equals(str) || LANGUAGE_GREEK.equals(str) || LANGUAGE_IRISH.equals(str) || LANGUAGE_ROMANSH.equals(str);
    }

    public static void setLanguage(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_LANGUAGE, str).apply();
        if (LANGUAGE_AUTO.equals(str)) {
            str = detectSystemLanguage();
        }
        applyLanguage(context, validateLanguage(str));
    }

    private static String validateLanguage(String str) {
        if (isSupportedLanguage(str)) {
            return str;
        }
        Log.w(TAG, "Language not supported: " + str + ", falling back to: en");
        return "en";
    }
}
