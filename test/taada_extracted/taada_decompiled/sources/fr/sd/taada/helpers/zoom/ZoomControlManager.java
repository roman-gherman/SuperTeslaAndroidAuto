package fr.sd.taada.helpers.zoom;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;
import com.google.android.material.button.MaterialButton;
import fr.sd.taada.R;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.service.ServiceRestartScheduler;

/* JADX INFO: loaded from: classes2.dex */
public class ZoomControlManager {
    private static final int DEFAULT_DPI = 120;
    private static final int DPI_STEP = 10;
    private static final long HAPTIC_DURATION_MS = 30;
    private static final int MAX_DPI = 300;
    private static final int MAX_PROGRESS = 20;
    private static final int MIN_DPI = 100;
    private static final String PREF_DPI = "dpi";
    private static final int RECOMMENDED_DPI = 120;
    private static final int RECOMMENDED_PROGRESS = 2;
    private static final String TAG = "ZoomControlManager";
    private final ZoomControlCallback callback;
    private final Context context;
    private boolean isIndicatorPositioned = false;
    private final LogManager logManager;
    private View recommendedIndicator;
    private final ServiceRestartScheduler restartScheduler;
    private MaterialButton zoomDecreaseButton;
    private MaterialButton zoomIncreaseButton;
    private SeekBar zoomSeekBar;
    private TextView zoomValueText;

    public interface ZoomControlCallback {
        boolean areAllPermissionsGranted();

        boolean isServiceRunning();

        void onServiceRestartRequired();
    }

    public ZoomControlManager(@NonNull Context context, @NonNull LogManager logManager, @NonNull final ZoomControlCallback zoomControlCallback) {
        this.context = context;
        this.logManager = logManager;
        this.callback = zoomControlCallback;
        this.restartScheduler = new ServiceRestartScheduler(logManager, new ServiceRestartScheduler.RestartCallback() { // from class: fr.sd.taada.helpers.zoom.ZoomControlManager.1
            @Override // fr.sd.taada.helpers.service.ServiceRestartScheduler.RestartCallback
            public boolean areAllPermissionsGranted() {
                return zoomControlCallback.areAllPermissionsGranted();
            }

            @Override // fr.sd.taada.helpers.service.ServiceRestartScheduler.RestartCallback
            public boolean isServiceRunning() {
                return zoomControlCallback.isServiceRunning();
            }

            @Override // fr.sd.taada.helpers.service.ServiceRestartScheduler.RestartCallback
            public void onServiceRestartRequired() {
                zoomControlCallback.onServiceRestartRequired();
            }
        });
    }

    private void applyIndicatorPosition(int i) {
        this.recommendedIndicator.setX(i);
        this.recommendedIndicator.setVisibility(0);
        this.isIndicatorPositioned = true;
    }

    private int calculateIndicatorPosition() {
        int width = this.zoomSeekBar.getWidth();
        return Math.max(0, Math.min((this.zoomSeekBar.getPaddingLeft() + ((int) (((width - r1) - this.zoomSeekBar.getPaddingRight()) * 0.1f))) - (this.recommendedIndicator.getWidth() / 2), width - this.recommendedIndicator.getWidth()));
    }

    private boolean canPositionImmediately() {
        return this.zoomSeekBar.getWidth() > 0 && this.recommendedIndicator.getWidth() > 0;
    }

    private boolean canPositionIndicator() {
        return (this.recommendedIndicator == null || this.zoomSeekBar == null) ? false : true;
    }

    private int dpiToProgress(int i) {
        return Math.max(0, Math.min(20, ((Math.round(i / 10.0f) * 10) - 100) / 10));
    }

    private boolean hasValidSeekBarDimensions() {
        if ((this.zoomSeekBar.getWidth() - this.zoomSeekBar.getPaddingLeft()) - this.zoomSeekBar.getPaddingRight() > 0) {
            return true;
        }
        this.logManager.logWarning(TAG, "SeekBar not ready for positioning indicator");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleDeferredPositioning$2() {
        if (this.isIndicatorPositioned || this.zoomSeekBar.getWidth() <= 0) {
            return;
        }
        positionIndicatorImmediately();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupZoomControlListeners$0(View view) {
        int iMax = Math.max(100, getCurrentDpiValue() - 10);
        updateZoomValueWithoutRestart(iMax);
        updateZoomUI(iMax);
        performHapticFeedback();
        this.restartScheduler.scheduleRestart("Zoom Decrease", 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupZoomControlListeners$1(View view) {
        int iMin = Math.min(MAX_DPI, getCurrentDpiValue() + 10);
        updateZoomValueWithoutRestart(iMin);
        updateZoomUI(iMin);
        performHapticFeedback();
        this.restartScheduler.scheduleRestart("Zoom Increase", 2000L);
    }

    private void logPositioningResult(int i) {
        int width = this.zoomSeekBar.getWidth();
        int paddingLeft = (width - this.zoomSeekBar.getPaddingLeft()) - this.zoomSeekBar.getPaddingRight();
        this.logManager.logDebug(TAG, "Recommended indicator positioned at " + i + "px for DPI 120 (SeekBar width: " + width + ", effective: " + paddingLeft + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performHapticFeedback() {
        try {
            Vibrator vibrator = (Vibrator) this.context.getSystemService("vibrator");
            if (vibrator == null || !vibrator.hasVibrator()) {
                return;
            }
            vibrator.vibrate(VibrationEffect.createOneShot(HAPTIC_DURATION_MS, -1));
        } catch (Exception e) {
            this.logManager.logError(TAG, "Could not perform haptic feedback", e);
        }
    }

    private void positionIndicatorImmediately() {
        if (canPositionIndicator() && hasValidSeekBarDimensions()) {
            int iCalculateIndicatorPosition = calculateIndicatorPosition();
            applyIndicatorPosition(iCalculateIndicatorPosition);
            logPositioningResult(iCalculateIndicatorPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void positionRecommendedIndicator() {
        if (!canPositionIndicator()) {
            this.logManager.logWarning(TAG, "Cannot position indicator: null components");
            return;
        }
        if (shouldSkipRepositioning()) {
            this.logManager.logDebug(TAG, "Indicator already positioned, skipping");
        } else if (canPositionImmediately()) {
            positionIndicatorImmediately();
        } else {
            scheduleDeferredPositioning();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int progressToDpi(int i) {
        return (i * 10) + 100;
    }

    private void scheduleDeferredPositioning() {
        if (this.isIndicatorPositioned) {
            return;
        }
        this.zoomSeekBar.post(new b(this, 1));
    }

    private void setupZoomControlListeners() {
        this.zoomSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: fr.sd.taada.helpers.zoom.ZoomControlManager.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z6) {
                if (z6) {
                    int iProgressToDpi = ZoomControlManager.this.progressToDpi(i);
                    ZoomControlManager.this.updateZoomValueWithoutRestart(iProgressToDpi);
                    ZoomControlManager.this.updateZoomDisplayText(iProgressToDpi);
                    ZoomControlManager.this.performHapticFeedback();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                ZoomControlManager.this.restartScheduler.cancelRestart();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                ZoomControlManager.this.restartScheduler.scheduleRestart("Zoom Slider Change", 2000L);
            }
        });
        final int i = 0;
        this.zoomDecreaseButton.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.helpers.zoom.a
            public final /* synthetic */ ZoomControlManager b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        this.b.lambda$setupZoomControlListeners$0(view);
                        break;
                    default:
                        this.b.lambda$setupZoomControlListeners$1(view);
                        break;
                }
            }
        });
        final int i3 = 1;
        this.zoomIncreaseButton.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.helpers.zoom.a
            public final /* synthetic */ ZoomControlManager b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        this.b.lambda$setupZoomControlListeners$0(view);
                        break;
                    default:
                        this.b.lambda$setupZoomControlListeners$1(view);
                        break;
                }
            }
        });
    }

    private boolean shouldSkipRepositioning() {
        return this.isIndicatorPositioned && this.zoomSeekBar.getWidth() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZoomDisplayText(int i) {
        this.zoomValueText.setText(this.context.getString(R.string.zoom_current_value, Integer.valueOf(i)));
    }

    private void updateZoomUI(int i) {
        updateZoomDisplayText(i);
        this.zoomSeekBar.setProgress(dpiToProgress(i));
        if (this.isIndicatorPositioned) {
            return;
        }
        this.zoomSeekBar.post(new b(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZoomValueWithoutRestart(int i) {
        PreferenceManager.getDefaultSharedPreferences(this.context).edit().putInt(PREF_DPI, i).apply();
        this.logManager.logDebug(TAG, "Interface size updated: DPI " + i + " (" + i + "%)");
    }

    public void bindViews(@NonNull TextView textView, @NonNull SeekBar seekBar, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull View view) {
        this.zoomValueText = textView;
        this.zoomSeekBar = seekBar;
        this.zoomDecreaseButton = materialButton;
        this.zoomIncreaseButton = materialButton2;
        this.recommendedIndicator = view;
    }

    public int getCurrentDpiValue() {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getInt(PREF_DPI, 120);
    }

    public void initialize() {
        if (this.zoomSeekBar == null || this.zoomValueText == null) {
            this.logManager.logWarning(TAG, "Cannot initialize: views not bound");
        } else {
            updateZoomUI(getCurrentDpiValue());
            setupZoomControlListeners();
        }
    }

    public void onDestroy() {
        this.restartScheduler.cancelRestart();
    }
}
