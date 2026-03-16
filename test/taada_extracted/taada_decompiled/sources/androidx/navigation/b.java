package androidx.navigation;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.textfield.i;
import com.google.android.material.textfield.u;
import fr.sd.taada.helpers.resolution.ResolutionUiHandler;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1650a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f1650a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f1650a) {
            case 0:
                Navigation.createNavigateOnClickListener$lambda$1((NavDirections) this.b, view);
                break;
            case 1:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) this.b;
                EditText editText = cVar.i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    cVar.q();
                    break;
                }
                break;
            case 2:
                ((i) this.b).u();
                break;
            case 3:
                u uVar = (u) this.b;
                EditText editText2 = uVar.f2716f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = uVar.f2716f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        uVar.f2716f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        uVar.f2716f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        uVar.f2716f.setSelection(selectionEnd);
                    }
                    uVar.q();
                    break;
                }
                break;
            case 4:
                ((AlertDialog) this.b).dismiss();
                break;
            default:
                ((ResolutionUiHandler) this.b).lambda$bindViews$0(view);
                break;
        }
    }
}
