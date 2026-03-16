package R0;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.SpecialEffectsController;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.u;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener;
import com.google.android.material.textfield.i;
import com.tenjin.android.store.TenjinDatasource$TenjinCallback;
import fr.sd.taada.helpers.ReviewRequestManager;
import fr.sd.taada.helpers.permissions.PermissionCallback;
import fr.sd.taada.helpers.service.ServiceStartHandler;
import io.ktor.utils.io.b0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.functions.Function2;
import m.n;
import org.mockito.internal.util.Supplier;
import s.j;
import s.k;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements TenjinDatasource$TenjinCallback, Interpolator, InputConnectionCompat.OnCommitContentListener, FragmentResultListener, CancellationSignal.OnCancelListener, NavigationBarView$OnItemSelectedListener, SupportSQLiteOpenHelper.Factory, AccessibilityManagerCompat.TouchExplorationStateChangeListener, PermissionCallback, OnCompleteListener, Function, Supplier, SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1242a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1242a = i;
        this.b = obj;
    }

    @Override // com.google.android.datatransport.runtime.retries.Function
    public Object apply(Object obj) throws IOException {
        l.b bVar = (l.b) obj;
        l.d dVar = (l.d) this.b;
        URL url = bVar.f3951a;
        if (Log.isLoggable("TRuntime.".concat("CctTransportBackend"), 4)) {
            String.format("Making request to: %s", url);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) bVar.f3951a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(dVar.f3955g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.8 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = bVar.c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    dVar.f3953a.encode(bVar.b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    if (Log.isLoggable("TRuntime.".concat("CctTransportBackend"), 4)) {
                        String.format("Status Code: %d", numValueOf);
                    }
                    b0.j(httpURLConnection.getHeaderField("Content-Type"), "CctTransportBackend", "Content-Type: %s");
                    b0.j(httpURLConnection.getHeaderField("Content-Encoding"), "CctTransportBackend", "Content-Encoding: %s");
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new l.c(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new l.c(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            l.c cVar = new l.c(responseCode, null, n.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f4013a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return cVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (com.google.firebase.encoders.a e) {
            e = e;
            b0.k("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new l.c(400, null, 0L);
        } catch (ConnectException e6) {
            e = e6;
            b0.k("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new l.c(500, null, 0L);
        } catch (UnknownHostException e7) {
            e = e7;
            b0.k("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new l.c(500, null, 0L);
        } catch (IOException e8) {
            e = e8;
            b0.k("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new l.c(400, null, 0L);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.create$lambda$0((Context) this.b, configuration);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.f1242a) {
            case 12:
                return ((ClientHealthMetricsStore) this.b).loadClientMetrics();
            case 13:
                return Integer.valueOf(((EventStore) this.b).cleanUp());
            case 14:
                ((j) this.b).i.resetClientMetrics();
                return null;
            default:
                k kVar = (k) this.b;
                Iterator<u> it = kVar.b.loadActiveContexts().iterator();
                while (it.hasNext()) {
                    kVar.c.schedule(it.next(), 1);
                }
                return null;
        }
    }

    @Override // org.mockito.internal.util.Supplier
    public Object get() {
        return ((Field) this.b).getGenericType();
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f6) {
        return Transition.lambda$getInterpolator$0((String) this.b, f6);
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        SpecialEffectsController.Operation._init_$lambda$0((SpecialEffectsController.Operation) this.b);
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.b, inputContentInfoCompat, i, bundle);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(com.google.android.gms.tasks.b bVar) {
        ((ReviewRequestManager) this.b).lambda$processPendingReviewRequest$0(bVar);
    }

    @Override // com.tenjin.android.store.TenjinDatasource$TenjinCallback
    public void onEventsLoaded(List list) {
        h hVar = (h) this.b;
        hVar.getClass();
        if (list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            X0.a aVar = (X0.a) it.next();
            aVar.b.put("retry_items", Integer.toString(list.size()));
            new e(hVar, aVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @Override // fr.sd.taada.helpers.permissions.PermissionCallback
    public void onFlowComplete(boolean z6) {
        ((ServiceStartHandler) this.b).lambda$handleServiceStart$0(z6);
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public void onFragmentResult(String str, Bundle bundle) {
        FragmentKt.setFragmentResultListener$lambda$0((Function2) this.b, str, bundle);
    }

    @Override // com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$6((NavController) this.b, menuItem);
    }

    @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean z6) {
        i iVar = (i) this.b;
        AutoCompleteTextView autoCompleteTextView = iVar.f2662h;
        if (autoCompleteTextView == null || C5.f.K(autoCompleteTextView)) {
            return;
        }
        ViewCompat.setImportantForAccessibility(iVar.d, z6 ? 2 : 1);
    }
}
