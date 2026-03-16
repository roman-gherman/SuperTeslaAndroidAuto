package fr.sd.taada.fragments;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.result.ActivityResultCallback;
import android.view.result.ActivityResultLauncher;
import android.view.result.contract.ActivityResultContracts;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import fr.sd.taada.R;
import fr.sd.taada.TransporterService;
import fr.sd.taada.activities.BaseLocalizedActivity;
import fr.sd.taada.helpers.EmptyListPreference;
import fr.sd.taada.helpers.LocaleHelper;
import fr.sd.taada.helpers.MemoryTestRunner;
import fr.sd.taada.helpers.permissions.b;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class MainPreferenceFragment extends PreferenceFragmentCompat {
    private boolean f8589m0;
    private Preference f8590n0;
    private ActivityResultLauncher f8591o0 = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.1
        @Override // android.view.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainPreferenceFragment.this.m2618v2((Map) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setupMemoryDiagnosticPreferences$0(MemoryTestRunner.TestCallback testCallback, Preference preference) {
        MemoryTestRunner.runMemoryDiagnostic(getContext(), testCallback);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupMemoryDiagnosticPreferences$1(MemoryTestRunner.TestCallback testCallback, DialogInterface dialogInterface, int i) {
        MemoryTestRunner.runMemoryStressTest(getContext(), testCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setupMemoryDiagnosticPreferences$2(MemoryTestRunner.TestCallback testCallback, Preference preference) {
        new AlertDialog.Builder(getContext()).setTitle("⚡ Stress Test Mémoire").setMessage("Ce test peut temporairement ralentir votre appareil.\nÊtes-vous sûr de vouloir continuer ?").setPositiveButton("Continuer", new b(4, this, testCallback)).setNegativeButton("Annuler", (DialogInterface.OnClickListener) null).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setupMemoryDiagnosticPreferences$3(MemoryTestRunner.TestCallback testCallback, Preference preference) {
        MemoryTestRunner.runMemoryCleanup(getContext(), testCallback);
        return true;
    }

    private boolean m2620t2(boolean z6) {
        if (Settings.canDrawOverlays(getContext()) && Settings.System.canWrite(getContext())) {
            return true;
        }
        if (z6) {
            if (!Settings.canDrawOverlays(getContext())) {
                m2638E2(R.string.alert_need_draw_over_other_apps);
            } else if (!Settings.System.canWrite(getContext())) {
                Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
                startActivityForResult(intent, R.string.System_settings_desc);
            }
        }
        return false;
    }

    public static boolean m2641B2(String str) {
        return !str.equalsIgnoreCase("");
    }

    private void setupMemoryDiagnosticPreferences() {
        final MemoryTestRunner.TestCallback testCallback = new MemoryTestRunner.TestCallback() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.12
            @Override // fr.sd.taada.helpers.MemoryTestRunner.TestCallback
            public void onTestComplete(String str) {
                Toast.makeText(MainPreferenceFragment.this.getContext(), str, 1).show();
            }

            @Override // fr.sd.taada.helpers.MemoryTestRunner.TestCallback
            public void onTestError(String str) {
                Toast.makeText(MainPreferenceFragment.this.getContext(), str, 1).show();
            }

            @Override // fr.sd.taada.helpers.MemoryTestRunner.TestCallback
            public void onTestStart(String str) {
                Toast.makeText(MainPreferenceFragment.this.getContext(), str, 0).show();
            }
        };
        Preference preferenceFindPreference = findPreference("memory_diagnostic");
        if (preferenceFindPreference != null) {
            final int i = 0;
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: fr.sd.taada.fragments.a
                public final /* synthetic */ MainPreferenceFragment b;

                {
                    this.b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    switch (i) {
                        case 0:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$0(testCallback, preference);
                        case 1:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$2(testCallback, preference);
                        default:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$3(testCallback, preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference2 = findPreference("memory_stress_test");
        if (preferenceFindPreference2 != null) {
            final int i3 = 1;
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: fr.sd.taada.fragments.a
                public final /* synthetic */ MainPreferenceFragment b;

                {
                    this.b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    switch (i3) {
                        case 0:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$0(testCallback, preference);
                        case 1:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$2(testCallback, preference);
                        default:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$3(testCallback, preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference("memory_cleanup");
        if (preferenceFindPreference3 != null) {
            final int i4 = 2;
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: fr.sd.taada.fragments.a
                public final /* synthetic */ MainPreferenceFragment b;

                {
                    this.b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    switch (i4) {
                        case 0:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$0(testCallback, preference);
                        case 1:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$2(testCallback, preference);
                        default:
                            return this.b.lambda$setupMemoryDiagnosticPreferences$3(testCallback, preference);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguageSummary(ListPreference listPreference) {
        String selectedLanguage = LocaleHelper.getSelectedLanguage(getContext());
        String[] stringArray = getResources().getStringArray(R.array.language_values);
        String[] stringArray2 = getResources().getStringArray(R.array.language_entries);
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(selectedLanguage)) {
                listPreference.setSummary(stringArray2[i]);
                return;
            }
        }
        listPreference.setSummary(selectedLanguage);
    }

    public void m2614z2(int i, DialogInterface dialogInterface, int i3) {
        Intent intent;
        StringBuilder sb;
        if (i == R.string.alert_need_draw_over_other_apps) {
            intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            sb = new StringBuilder();
        } else {
            intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            sb = new StringBuilder();
        }
        sb.append("package:");
        sb.append(getActivity().getPackageName());
        getActivity().startActivityForResult(intent.setData(Uri.parse(sb.toString())), i);
        dialogInterface.dismiss();
    }

    public boolean m2615y2(Preference preference) {
        Context context = getContext();
        Intent intent = new Intent(context, (Class<?>) TransporterService.class);
        if (context != null) {
            context.startForegroundService(intent);
        }
        return true;
    }

    public boolean m2616x2(Preference preference, Object obj) {
        EmptyListPreference emptyListPreference = (EmptyListPreference) preference;
        emptyListPreference.setValues((Set) obj);
        m2637F2(emptyListPreference);
        return true;
    }

    public boolean m2617w2(Preference preference) {
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            m2636G2((EmptyListPreference) preference);
            return true;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setFlags(268435456);
        intent.setData(Uri.fromParts("package", getContext().getPackageName(), null));
        startActivity(intent);
        return false;
    }

    public void m2618v2(Map map) {
        map.entrySet().forEach(new Consumer() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MainPreferenceFragment.this.m2619u2((Map.Entry) obj);
            }
        });
    }

    public void m2619u2(Map.Entry entry) {
        System.out.println("Key : " + ((String) entry.getKey()) + " Value : " + entry.getValue());
        if (((Boolean) entry.getValue()).booleanValue()) {
            m2636G2((MultiSelectListPreference) this.f8590n0);
            return;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), (String) entry.getKey())) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{(String) entry.getKey()}, 2);
        } else {
            if (((Boolean) entry.getValue()).booleanValue() || entry.getKey() != "android.permission.BLUETOOTH_CONNECT") {
                return;
            }
            m2637F2(null);
        }
    }

    public void m2635H2() {
        Preference preferenceFindPreference = getPreferenceScreen().findPreference("permissions_status");
        if (preferenceFindPreference != null) {
            if (m2620t2(false)) {
                preferenceFindPreference.setSummary(getString(R.string.status_all_permissions_granted));
                preferenceFindPreference.setIcon(R.drawable.ic_green_done_24);
            } else {
                preferenceFindPreference.setSummary(getString(R.string.status_denied_permissions));
                preferenceFindPreference.setIcon(R.drawable.ic_red_report_problem_24);
                preferenceFindPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.11
                    @Override // androidx.preference.Preference.OnPreferenceChangeListener
                    public final boolean onPreferenceChange(Preference preference, Object obj) {
                        return MainPreferenceFragment.this.m2639D2(preference);
                    }
                });
                m2620t2(true);
            }
        }
    }

    public void m2636G2(MultiSelectListPreference multiSelectListPreference) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && !defaultAdapter.isEnabled()) {
            Intent intent = new Intent();
            intent.setAction("android.bluetooth.adapter.action.REQUEST_ENABLE");
            startActivityForResult(intent, 90);
            return;
        }
        if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(getContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            defaultAdapter.getBondedDevices().size();
            String[] strArr = new String[defaultAdapter.getBondedDevices().size()];
            String[] strArr2 = new String[defaultAdapter.getBondedDevices().size()];
            int i = 0;
            for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                if (bluetoothDevice.getName() == null || "".equalsIgnoreCase(bluetoothDevice.getName())) {
                    strArr[i] = "UNKNOWN";
                } else {
                    strArr[i] = bluetoothDevice.getName();
                }
                strArr2[i] = bluetoothDevice.getAddress();
                i++;
            }
            multiSelectListPreference.setEntries(strArr);
            multiSelectListPreference.setEntryValues(strArr2);
        }
    }

    public void m2637F2(final MultiSelectListPreference multiSelectListPreference) {
        int i;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(getContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
            i = R.string.nobt;
        } else {
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                if (multiSelectListPreference != null) {
                    Set set = (Set) multiSelectListPreference.getValues().stream().filter(new Predicate() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.9
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return MainPreferenceFragment.m2641B2((String) obj);
                        }
                    }).collect(Collectors.toSet());
                    if (set.size() > 0) {
                        multiSelectListPreference.setSummary((CharSequence) set.stream().map(new Function() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.10
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return MainPreferenceFragment.this.m2640C2(multiSelectListPreference, (String) obj);
                            }
                        }).collect(Collectors.joining(", ")));
                        return;
                    } else {
                        multiSelectListPreference.setSummary(R.string.settings_bluetooth_selected_bluetooth_devices_description);
                        return;
                    }
                }
                return;
            }
            i = R.string.settings_bluetooth_selected_bluetooth_devices_turn_on;
        }
        multiSelectListPreference.setSummary(i);
    }

    public void m2638E2(final int i) {
        if (this.f8589m0) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppDialogTheme);
        builder.setTitle(getActivity().getResources().getString(R.string.alert_permission_denied_title));
        builder.setMessage(getActivity().getResources().getString(i));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MainPreferenceFragment.this.m2614z2(i, dialogInterface, i3);
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MainPreferenceFragment.this.m2642A2(dialogInterface);
            }
        });
        this.f8589m0 = true;
        builder.show();
    }

    public boolean m2639D2(Preference preference) {
        m2620t2(true);
        return true;
    }

    public CharSequence m2640C2(MultiSelectListPreference multiSelectListPreference, String str) {
        int iFindIndexOfValue = multiSelectListPreference.findIndexOfValue(str);
        return iFindIndexOfValue >= 0 ? multiSelectListPreference.getEntries()[iFindIndexOfValue] : getString(R.string.settings_bluetooth_selected_bluetooth_devices_forgotten_device);
    }

    public void m2642A2(DialogInterface dialogInterface) {
        this.f8589m0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i3, Intent intent) {
        super.onActivityResult(i, i3, intent);
        if (i == 90 && i3 == -1) {
            m2636G2((MultiSelectListPreference) getPreferenceScreen().findPreference("selected_bluetooth_devices"));
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        addPreferencesFromResource(R.xml.preferences);
        setupMemoryDiagnosticPreferences();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) super.onCreateView(layoutInflater, viewGroup, bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        ListPreference listPreference = (ListPreference) preferenceScreen.findPreference("app_language");
        if (listPreference != null) {
            updateLanguageSummary(listPreference);
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.3
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    LocaleHelper.setLanguage(MainPreferenceFragment.this.getContext(), (String) obj);
                    MainPreferenceFragment.this.updateLanguageSummary((ListPreference) preference);
                    if (MainPreferenceFragment.this.getActivity() instanceof BaseLocalizedActivity) {
                        ((BaseLocalizedActivity) MainPreferenceFragment.this.getActivity()).triggerLanguageChange();
                        return true;
                    }
                    if (MainPreferenceFragment.this.getActivity() == null) {
                        return true;
                    }
                    MainPreferenceFragment.this.getActivity().recreate();
                    return true;
                }
            });
        }
        Preference preferenceFindPreference = preferenceScreen.findPreference("selected_bluetooth_devices");
        this.f8590n0 = preferenceFindPreference;
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.4
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return MainPreferenceFragment.this.m2617w2(preference);
                }
            });
            this.f8590n0.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.5
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return MainPreferenceFragment.this.m2616x2(preference, obj);
                }
            });
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("start_service_manually");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: fr.sd.taada.fragments.MainPreferenceFragment.6
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return MainPreferenceFragment.this.m2615y2(preference);
                }
            });
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            this.f8591o0.launch(new String[]{"android.permission.RECORD_AUDIO", "android.permission.BLUETOOTH_CONNECT", "android.permission.POST_NOTIFICATIONS"});
            return linearLayout;
        }
        if (i >= 31) {
            this.f8591o0.launch(new String[]{"android.permission.RECORD_AUDIO", "android.permission.BLUETOOTH_CONNECT"});
            return linearLayout;
        }
        this.f8591o0.launch(new String[]{"android.permission.RECORD_AUDIO"});
        return linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m2636G2((EmptyListPreference) this.f8590n0);
        m2637F2((MultiSelectListPreference) getPreferenceScreen().findPreference("selected_bluetooth_devices"));
        m2635H2();
    }
}
