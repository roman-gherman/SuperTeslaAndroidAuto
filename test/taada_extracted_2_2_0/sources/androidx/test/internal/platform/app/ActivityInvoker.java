package androidx.test.internal.platform.app;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.test.platform.app.InstrumentationRegistry;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityInvoker {

    /* JADX INFO: renamed from: androidx.test.internal.platform.app.ActivityInvoker$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Intent $default$getIntentForActivity(ActivityInvoker activityInvoker, Class cls) {
            Intent intentMakeMainActivity = Intent.makeMainActivity(new ComponentName(InstrumentationRegistry.getInstrumentation().getTargetContext(), (Class<?>) cls));
            return InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageManager().resolveActivity(intentMakeMainActivity, 0) != null ? intentMakeMainActivity : Intent.makeMainActivity(new ComponentName(InstrumentationRegistry.getInstrumentation().getContext(), (Class<?>) cls));
        }
    }

    void finishActivity(Activity activity);

    Instrumentation.ActivityResult getActivityResult();

    Intent getIntentForActivity(Class<? extends Activity> cls);

    void pauseActivity(Activity activity);

    void recreateActivity(Activity activity);

    void resumeActivity(Activity activity);

    void startActivity(Intent intent);

    void startActivity(Intent intent, Bundle bundle);

    void startActivityForResult(Intent intent);

    void startActivityForResult(Intent intent, Bundle bundle);

    void stopActivity(Activity activity);
}
