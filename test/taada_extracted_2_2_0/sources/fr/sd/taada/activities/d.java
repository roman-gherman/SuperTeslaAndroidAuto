package fr.sd.taada.activities;

import android.view.MenuItem;
import android.view.result.ActivityResult;
import android.view.result.ActivityResultCallback;
import com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener;
import fr.sd.taada.helpers.demo.DemoModeUiHandler;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements NavigationBarView$OnItemSelectedListener, DemoModeUiHandler.ServiceStateProvider, ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3262a;
    public final /* synthetic */ HomeActivity b;

    public /* synthetic */ d(HomeActivity homeActivity, int i) {
        this.f3262a = i;
        this.b = homeActivity;
    }

    @Override // fr.sd.taada.helpers.demo.DemoModeUiHandler.ServiceStateProvider
    public Boolean isServiceRunning() {
        return this.b.lambda$initializeManagers$3();
    }

    @Override // android.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.f3262a) {
            case 2:
                this.b.lambda$registerPermissionLauncher$23((Map) obj);
                break;
            case 3:
                this.b.lambda$registerSettingsLauncher$24((ActivityResult) obj);
                break;
            default:
                this.b.lambda$registerVpnActivityResultLauncher$25((ActivityResult) obj);
                break;
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return this.b.lambda$setupNavigation$1(menuItem);
    }
}
