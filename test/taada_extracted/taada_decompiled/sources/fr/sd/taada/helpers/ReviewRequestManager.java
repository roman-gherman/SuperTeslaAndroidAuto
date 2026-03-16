package fr.sd.taada.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ReviewRequestManager {
    private static final int MAX_DECLINE_COUNT = 2;
    private static final int MIN_DAYS_SINCE_FIRST_USE = 2;
    private static final int MIN_SUCCESSFUL_SESSIONS = 3;
    private static final long MIN_TIME_BETWEEN_REQUESTS = TimeUnit.DAYS.toMillis(7);
    private static final int MIN_TOTAL_DURATION_MINUTES = 30;
    private static final String PREF_CURRENT_SESSION_START = "current_session_start_time";
    private static final String PREF_FIRST_SUCCESS_DATE = "first_successful_session_date";
    private static final String PREF_LAST_REVIEW_REQUEST = "last_review_request_date";
    private static final String PREF_PENDING_REVIEW_REQUEST = "pending_review_request";
    private static final String PREF_REVIEW_ALREADY_GIVEN = "user_has_given_review";
    private static final String PREF_REVIEW_DECLINED_COUNT = "review_declined_count";
    private static final String PREF_SESSIONS_COUNT = "successful_sessions_count";
    private static final String PREF_TOTAL_SESSION_DURATION = "total_session_duration_minutes";
    private static final int PREMIUM_MIN_DURATION_MINUTES = 15;
    private static final int PREMIUM_MIN_SESSIONS = 2;
    private static final String TAG = "ReviewRequestManager";
    private static ReviewRequestManager instance;
    private final Context context;
    private final LogManager logManager;
    private final SharedPreferences prefs;
    private ReviewManager reviewManager;

    private ReviewRequestManager(Context context) {
        this.context = context;
        this.prefs = PreferenceManager.getDefaultSharedPreferences(context);
        LogManager logManager = LogManager.getInstance(context);
        this.logManager = logManager;
        Context applicationContext = context.getApplicationContext();
        this.reviewManager = new com.google.android.play.core.review.c(new com.google.android.play.core.review.f(applicationContext != null ? applicationContext : context));
        logManager.logDebug(TAG, "ReviewRequestManager initialized");
    }

    private void evaluateReviewRequest() {
        evaluateReviewRequest(false);
    }

    public static synchronized ReviewRequestManager getInstance(Context context) {
        try {
            if (instance == null) {
                instance = new ReviewRequestManager(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private void incrementDeclineCount() {
        int i = this.prefs.getInt(PREF_REVIEW_DECLINED_COUNT, 0) + 1;
        this.prefs.edit().putInt(PREF_REVIEW_DECLINED_COUNT, i).apply();
        this.logManager.logDebug(TAG, "Review declined, count now: " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processPendingReviewRequest$0(com.google.android.gms.tasks.b bVar) {
        if (bVar.c()) {
            this.logManager.logInfo(TAG, "✅ Review flow completed successfully");
            this.prefs.edit().putBoolean(PREF_REVIEW_ALREADY_GIVEN, true).apply();
        } else {
            this.logManager.logWarning(TAG, "❌ Review flow failed");
            incrementDeclineCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processPendingReviewRequest$1(Activity activity, com.google.android.gms.tasks.b bVar) {
        if (bVar.c()) {
            this.reviewManager.launchReviewFlow(activity, (ReviewInfo) bVar.b()).a(new R0.a(this, 9));
        } else {
            this.logManager.logWarning(TAG, "❌ Failed to request review flow");
            incrementDeclineCount();
        }
    }

    private void requestReview() {
        this.prefs.edit().putLong(PREF_LAST_REVIEW_REQUEST, System.currentTimeMillis()).apply();
        this.prefs.edit().putBoolean(PREF_PENDING_REVIEW_REQUEST, true).apply();
        this.logManager.logInfo(TAG, "✅ Review request scheduled - will show in next Activity");
    }

    public void logCurrentStatus() {
        this.logManager.logInfo(TAG, "=== REVIEW MANAGER STATUS ===");
        this.logManager.logInfo(TAG, "Sessions: " + this.prefs.getInt(PREF_SESSIONS_COUNT, 0));
        this.logManager.logInfo(TAG, "Total duration: " + this.prefs.getInt(PREF_TOTAL_SESSION_DURATION, 0) + " minutes");
        this.logManager.logInfo(TAG, "First use: " + new Date(this.prefs.getLong(PREF_FIRST_SUCCESS_DATE, 0L)));
        this.logManager.logInfo(TAG, "Review given: " + this.prefs.getBoolean(PREF_REVIEW_ALREADY_GIVEN, false));
        this.logManager.logInfo(TAG, "Decline count: " + this.prefs.getInt(PREF_REVIEW_DECLINED_COUNT, 0));
        this.logManager.logInfo(TAG, "Last request: " + new Date(this.prefs.getLong(PREF_LAST_REVIEW_REQUEST, 0L)));
        this.logManager.logInfo(TAG, "Pending request: " + this.prefs.getBoolean(PREF_PENDING_REVIEW_REQUEST, false));
    }

    public void onPremiumPurchaseCompleted() {
        this.logManager.logInfo(TAG, "Premium purchase completed - evaluating early review request");
        evaluateReviewRequest(true);
    }

    public void onSessionEnded(boolean z6) {
        long j6 = this.prefs.getLong(PREF_CURRENT_SESSION_START, 0L);
        if (j6 == 0) {
            this.logManager.logDebug(TAG, "Session end called but no start time recorded");
            return;
        }
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - j6) / 60000);
        if (!z6 || iCurrentTimeMillis < 1) {
            this.logManager.logDebug(TAG, "Session not counted: wasSuccessful=" + z6 + ", duration=" + iCurrentTimeMillis + " minutes");
            this.prefs.edit().remove(PREF_CURRENT_SESSION_START).apply();
            return;
        }
        int i = this.prefs.getInt(PREF_SESSIONS_COUNT, 0) + 1;
        int i3 = this.prefs.getInt(PREF_TOTAL_SESSION_DURATION, 0) + iCurrentTimeMillis;
        this.prefs.edit().putInt(PREF_SESSIONS_COUNT, i).putInt(PREF_TOTAL_SESSION_DURATION, i3).remove(PREF_CURRENT_SESSION_START).apply();
        this.logManager.logInfo(TAG, "Successful session recorded: " + iCurrentTimeMillis + " minutes. Total sessions: " + i + ", Total duration: " + i3 + " minutes");
        evaluateReviewRequest();
    }

    public void onSessionStarted() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.prefs.edit().putLong(PREF_CURRENT_SESSION_START, jCurrentTimeMillis).apply();
        this.logManager.logDebug(TAG, "Session started at: " + new Date(jCurrentTimeMillis));
        if (this.prefs.getLong(PREF_FIRST_SUCCESS_DATE, 0L) == 0) {
            this.prefs.edit().putLong(PREF_FIRST_SUCCESS_DATE, jCurrentTimeMillis).apply();
            this.logManager.logInfo(TAG, "First successful session recorded!");
        }
    }

    public void processPendingReviewRequest(Activity activity) {
        if (this.prefs.getBoolean(PREF_PENDING_REVIEW_REQUEST, false)) {
            this.prefs.edit().putBoolean(PREF_PENDING_REVIEW_REQUEST, false).apply();
            this.logManager.logInfo(TAG, "🎬 Processing pending review request in Activity");
            this.reviewManager.requestReviewFlow().a(new R0.d(4, this, activity));
        }
    }

    public void resetForTesting() {
        this.prefs.edit().remove(PREF_SESSIONS_COUNT).remove(PREF_TOTAL_SESSION_DURATION).remove(PREF_FIRST_SUCCESS_DATE).remove(PREF_LAST_REVIEW_REQUEST).remove(PREF_REVIEW_ALREADY_GIVEN).remove(PREF_REVIEW_DECLINED_COUNT).remove(PREF_CURRENT_SESSION_START).remove(PREF_PENDING_REVIEW_REQUEST).apply();
        this.logManager.logInfo(TAG, "All review data reset for testing");
    }

    private void evaluateReviewRequest(boolean z6) {
        if (this.prefs.getBoolean(PREF_REVIEW_ALREADY_GIVEN, false)) {
            this.logManager.logDebug(TAG, "User already gave a review, skipping");
            return;
        }
        if (this.prefs.getInt(PREF_REVIEW_DECLINED_COUNT, 0) >= 2) {
            this.logManager.logDebug(TAG, "User declined too many times, skipping permanently");
            return;
        }
        long j6 = this.prefs.getLong(PREF_LAST_REVIEW_REQUEST, 0L);
        if (j6 > 0 && System.currentTimeMillis() - j6 < MIN_TIME_BETWEEN_REQUESTS) {
            this.logManager.logDebug(TAG, "Too soon since last request, skipping");
            return;
        }
        int i = this.prefs.getInt(PREF_SESSIONS_COUNT, 0);
        int i3 = this.prefs.getInt(PREF_TOTAL_SESSION_DURATION, 0);
        long j7 = this.prefs.getLong(PREF_FIRST_SUCCESS_DATE, 0L);
        long jCurrentTimeMillis = j7 > 0 ? (System.currentTimeMillis() - j7) / 86400000 : 0L;
        int i4 = z6 ? 2 : 3;
        int i5 = z6 ? 15 : 30;
        this.logManager.logDebug(TAG, "Review evaluation - Sessions: " + i + "/" + i4 + ", Duration: " + i3 + "/" + i5 + ", Days: " + jCurrentTimeMillis + "/2, Premium: " + z6);
        if (i < i4 || i3 < i5 || jCurrentTimeMillis < 2) {
            this.logManager.logDebug(TAG, "Criteria not met yet for review request");
        } else {
            this.logManager.logInfo(TAG, "🌟 All criteria met! Requesting review...");
            requestReview();
        }
    }
}
