package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.ComponentActivity;
import android.view.result.ActivityResult;
import android.view.result.ActivityResultCallback;
import android.view.result.ActivityResultLauncher;
import android.view.result.IntentSenderRequest;
import android.view.result.contract.ActivityResultContracts;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;

/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityResultLauncher f1823a;
    public ActivityResultLauncher b;
    public ResultReceiver c;
    public ResultReceiver d;

    @Override // android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final int i = 0;
        this.f1823a = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.J
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // android.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i) {
                    case 0:
                        ProxyBillingActivityV2 proxyBillingActivityV2 = this.b;
                        proxyBillingActivityV2.getClass();
                        Intent data = activityResult.getData();
                        int i3 = AbstractC0289j0.c(data, "ProxyBillingActivityV2").f1844a;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.c;
                        if (resultReceiver != null) {
                            resultReceiver.send(i3, data == null ? null : data.getExtras());
                        }
                        if (activityResult.getResultCode() != -1 || i3 != 0) {
                            AbstractC0289j0.f("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + activityResult.getResultCode() + " and billing's responseCode: " + i3);
                        }
                        proxyBillingActivityV2.finish();
                        break;
                    default:
                        ProxyBillingActivityV2 proxyBillingActivityV22 = this.b;
                        proxyBillingActivityV22.getClass();
                        Intent data2 = activityResult.getData();
                        int i4 = AbstractC0289j0.c(data2, "ProxyBillingActivityV2").f1844a;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV22.d;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i4, data2 == null ? null : data2.getExtras());
                        }
                        if (activityResult.getResultCode() != -1 || i4 != 0) {
                            AbstractC0289j0.f("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + activityResult.getResultCode() + " and billing's responseCode: " + i4);
                        }
                        proxyBillingActivityV22.finish();
                        break;
                }
            }
        });
        final int i3 = 1;
        this.b = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.J
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // android.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i3) {
                    case 0:
                        ProxyBillingActivityV2 proxyBillingActivityV2 = this.b;
                        proxyBillingActivityV2.getClass();
                        Intent data = activityResult.getData();
                        int i32 = AbstractC0289j0.c(data, "ProxyBillingActivityV2").f1844a;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.c;
                        if (resultReceiver != null) {
                            resultReceiver.send(i32, data == null ? null : data.getExtras());
                        }
                        if (activityResult.getResultCode() != -1 || i32 != 0) {
                            AbstractC0289j0.f("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + activityResult.getResultCode() + " and billing's responseCode: " + i32);
                        }
                        proxyBillingActivityV2.finish();
                        break;
                    default:
                        ProxyBillingActivityV2 proxyBillingActivityV22 = this.b;
                        proxyBillingActivityV22.getClass();
                        Intent data2 = activityResult.getData();
                        int i4 = AbstractC0289j0.c(data2, "ProxyBillingActivityV2").f1844a;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV22.d;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i4, data2 == null ? null : data2.getExtras());
                        }
                        if (activityResult.getResultCode() != -1 || i4 != 0) {
                            AbstractC0289j0.f("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + activityResult.getResultCode() + " and billing's responseCode: " + i4);
                        }
                        proxyBillingActivityV22.finish();
                        break;
                }
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.c = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            } else {
                if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                    this.d = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
                    return;
                }
                return;
            }
        }
        AbstractC0289j0.e("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.c = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.f1823a.launch(new IntentSenderRequest.Builder(pendingIntent).build());
        } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.d = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.b.launch(new IntentSenderRequest.Builder(pendingIntent2).build());
        }
    }

    @Override // android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.c;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.d;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}
