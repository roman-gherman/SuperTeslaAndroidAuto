package androidx.navigation.ui;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import fr.sd.taada.activities.AAVersionErrorActivity;
import fr.sd.taada.activities.HomeActivity;
import fr.sd.taada.helpers.dialogs.FeedbackDialogHelper;
import fr.sd.taada.helpers.permissions.PermissionItem;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1658a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f1658a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f1658a) {
            case 0:
                NavigationUI.setupWithNavController$lambda$1((NavController) this.b, (AppBarConfiguration) this.c, view);
                break;
            case 1:
                ((FeedbackDialogHelper) this.b).lambda$showFeedbackDialog$1((AlertDialog) this.c, view);
                break;
            case 2:
                ((AAVersionErrorActivity) this.b).lambda$onCreate$3((String) this.c, view);
                break;
            default:
                ((HomeActivity) this.b).lambda$populatePermissionsDropdown$27((PermissionItem) this.c, view);
                break;
        }
    }
}
