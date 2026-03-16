package fr.sd.taada.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes2.dex */
public class AAVersionErrorActivity extends BaseLocalizedActivity {
    public static final String EXTRA_AA_VERSION = "extra_aa_version";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.projection.gearhead")));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.projection.gearhead")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(String str, View view) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:support@taada.top"));
        StringBuilder sb = new StringBuilder("TaaDa - Android Auto ");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(" Compatibility Issue");
        intent.putExtra("android.intent.extra.SUBJECT", sb.toString());
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    @Override // fr.sd.taada.activities.BaseLocalizedActivity, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_aa_version_error);
        String stringExtra = getIntent().getStringExtra(EXTRA_AA_VERSION);
        TextView textView = (TextView) findViewById(R.id.aaVersionText);
        if (stringExtra == null || stringExtra.isEmpty()) {
            textView.setText(R.string.aa_version_error_unknown_version);
        } else {
            textView.setText(getString(R.string.aa_version_error_detected_version, stringExtra));
        }
        ImageButton imageButton = (ImageButton) findViewById(R.id.btnClose);
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.btnClose2);
        final int i = 0;
        imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.activities.a
            public final /* synthetic */ AAVersionErrorActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        this.b.lambda$onCreate$0(view);
                        break;
                    case 1:
                        this.b.lambda$onCreate$1(view);
                        break;
                    default:
                        this.b.lambda$onCreate$2(view);
                        break;
                }
            }
        });
        final int i3 = 1;
        materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.activities.a
            public final /* synthetic */ AAVersionErrorActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        this.b.lambda$onCreate$0(view);
                        break;
                    case 1:
                        this.b.lambda$onCreate$1(view);
                        break;
                    default:
                        this.b.lambda$onCreate$2(view);
                        break;
                }
            }
        });
        final int i4 = 2;
        ((MaterialButton) findViewById(R.id.btnOpenPlayStore)).setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.activities.a
            public final /* synthetic */ AAVersionErrorActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        this.b.lambda$onCreate$0(view);
                        break;
                    case 1:
                        this.b.lambda$onCreate$1(view);
                        break;
                    default:
                        this.b.lambda$onCreate$2(view);
                        break;
                }
            }
        });
        ((MaterialButton) findViewById(R.id.btnContactSupport)).setOnClickListener(new androidx.navigation.ui.b(i4, this, stringExtra));
    }
}
