package fr.sd.taada.analytics.telemetry;

import C5.f;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b<\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>¨\u0006?"}, d2 = {"Lfr/sd/taada/analytics/telemetry/FunnelEvent;", "", "eventName", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "APP_INSTALLED", "APP_OPENED", "APP_QUIT", "AUTO_START_BLUETOOTH", "BT_RECEIVER_TRIGGERED", "BT_AUTO_START_BLOCKED", "BT_AUTO_START_FAILED", "BT_DISCONNECTED", "SESSION_START_ATTEMPT", "SESSION_START", "SESSION_END", "ONBOARDING_STARTED", "ONBOARDING_COMPLETED", "TESLA_DETECTED", "AA_HANDSHAKE_SUCCESS", "HTTP_SERVER_CONNECTED", "WEBSOCKET_CONNECTED", "VPN_CONNECTED", "VPN_DISCONNECTED", "VPN_CONNECTION_FAILED", "CONNECTION_FAILURE", "FIRST_FRAME_RECEIVED", "BLUETOOTH_SCAN_STARTED", "BLUETOOTH_SCAN_COMPLETED", "BLUETOOTH_DEVICE_FOUND", "BLUETOOTH_DEVICE_SELECTED", "BLUETOOTH_CONNECTING", "BLUETOOTH_CONNECTED", "BLUETOOTH_DISCONNECTED", "BLUETOOTH_CONNECTION_FAILED", "STREAM_REQUESTED", "STREAM_STARTED", "STREAM_FPS_SAMPLED", "STREAM_PAUSED", "STREAM_RESUMED", "STREAM_STOPPED", "STREAM_FAILED", "KEYFRAME_REQUESTED", "PAYWALL_VIEWED", "PAYWALL_CTA_CLICKED", "PAYWALL_DISMISSED", "PURCHASE_INITIATED", "PURCHASE_COMPLETED", "PURCHASE_FAILED", "PURCHASE_CANCELLED", "PURCHASE_RESTORED", "DEMO_REARMED", "TRIAL_STARTED", "TRIAL_ENDED", "SUBSCRIPTION_STARTED", "SUBSCRIPTION_RENEWED", "SUBSCRIPTION_CANCELLED", "SUBSCRIPTION_EXPIRED", "FEATURE_USED", "ERROR_OCCURRED", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunnelEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FunnelEvent[] $VALUES;

    @NotNull
    private final String eventName;
    public static final FunnelEvent APP_INSTALLED = new FunnelEvent("APP_INSTALLED", 0, "app_installed");
    public static final FunnelEvent APP_OPENED = new FunnelEvent("APP_OPENED", 1, "app_opened");
    public static final FunnelEvent APP_QUIT = new FunnelEvent("APP_QUIT", 2, "app_quit");
    public static final FunnelEvent AUTO_START_BLUETOOTH = new FunnelEvent("AUTO_START_BLUETOOTH", 3, "auto_start_bluetooth");
    public static final FunnelEvent BT_RECEIVER_TRIGGERED = new FunnelEvent("BT_RECEIVER_TRIGGERED", 4, "bt_receiver_triggered");
    public static final FunnelEvent BT_AUTO_START_BLOCKED = new FunnelEvent("BT_AUTO_START_BLOCKED", 5, "bt_auto_start_blocked");
    public static final FunnelEvent BT_AUTO_START_FAILED = new FunnelEvent("BT_AUTO_START_FAILED", 6, "bt_auto_start_failed");
    public static final FunnelEvent BT_DISCONNECTED = new FunnelEvent("BT_DISCONNECTED", 7, "bt_disconnected");
    public static final FunnelEvent SESSION_START_ATTEMPT = new FunnelEvent("SESSION_START_ATTEMPT", 8, "session_start_attempt");
    public static final FunnelEvent SESSION_START = new FunnelEvent("SESSION_START", 9, "session_start");
    public static final FunnelEvent SESSION_END = new FunnelEvent("SESSION_END", 10, "session_end");
    public static final FunnelEvent ONBOARDING_STARTED = new FunnelEvent("ONBOARDING_STARTED", 11, "onboarding_started");
    public static final FunnelEvent ONBOARDING_COMPLETED = new FunnelEvent("ONBOARDING_COMPLETED", 12, "onboarding_completed");
    public static final FunnelEvent TESLA_DETECTED = new FunnelEvent("TESLA_DETECTED", 13, "tesla_detected");
    public static final FunnelEvent AA_HANDSHAKE_SUCCESS = new FunnelEvent("AA_HANDSHAKE_SUCCESS", 14, "aa_handshake_success");
    public static final FunnelEvent HTTP_SERVER_CONNECTED = new FunnelEvent("HTTP_SERVER_CONNECTED", 15, "http_server_connected");
    public static final FunnelEvent WEBSOCKET_CONNECTED = new FunnelEvent("WEBSOCKET_CONNECTED", 16, "websocket_connected");
    public static final FunnelEvent VPN_CONNECTED = new FunnelEvent("VPN_CONNECTED", 17, "vpn_connected");
    public static final FunnelEvent VPN_DISCONNECTED = new FunnelEvent("VPN_DISCONNECTED", 18, "vpn_disconnected");
    public static final FunnelEvent VPN_CONNECTION_FAILED = new FunnelEvent("VPN_CONNECTION_FAILED", 19, "vpn_connection_failed");
    public static final FunnelEvent CONNECTION_FAILURE = new FunnelEvent("CONNECTION_FAILURE", 20, "connection_failure");
    public static final FunnelEvent FIRST_FRAME_RECEIVED = new FunnelEvent("FIRST_FRAME_RECEIVED", 21, "first_frame_received");
    public static final FunnelEvent BLUETOOTH_SCAN_STARTED = new FunnelEvent("BLUETOOTH_SCAN_STARTED", 22, "bluetooth_scan_started");
    public static final FunnelEvent BLUETOOTH_SCAN_COMPLETED = new FunnelEvent("BLUETOOTH_SCAN_COMPLETED", 23, "bluetooth_scan_completed");
    public static final FunnelEvent BLUETOOTH_DEVICE_FOUND = new FunnelEvent("BLUETOOTH_DEVICE_FOUND", 24, "bluetooth_device_found");
    public static final FunnelEvent BLUETOOTH_DEVICE_SELECTED = new FunnelEvent("BLUETOOTH_DEVICE_SELECTED", 25, "bluetooth_device_selected");
    public static final FunnelEvent BLUETOOTH_CONNECTING = new FunnelEvent("BLUETOOTH_CONNECTING", 26, "bluetooth_connecting");
    public static final FunnelEvent BLUETOOTH_CONNECTED = new FunnelEvent("BLUETOOTH_CONNECTED", 27, "bluetooth_connected");
    public static final FunnelEvent BLUETOOTH_DISCONNECTED = new FunnelEvent("BLUETOOTH_DISCONNECTED", 28, "bluetooth_disconnected");
    public static final FunnelEvent BLUETOOTH_CONNECTION_FAILED = new FunnelEvent("BLUETOOTH_CONNECTION_FAILED", 29, "bluetooth_connection_failed");
    public static final FunnelEvent STREAM_REQUESTED = new FunnelEvent("STREAM_REQUESTED", 30, "stream_requested");
    public static final FunnelEvent STREAM_STARTED = new FunnelEvent("STREAM_STARTED", 31, "stream_started");
    public static final FunnelEvent STREAM_FPS_SAMPLED = new FunnelEvent("STREAM_FPS_SAMPLED", 32, "stream_fps_sampled");
    public static final FunnelEvent STREAM_PAUSED = new FunnelEvent("STREAM_PAUSED", 33, "stream_paused");
    public static final FunnelEvent STREAM_RESUMED = new FunnelEvent("STREAM_RESUMED", 34, "stream_resumed");
    public static final FunnelEvent STREAM_STOPPED = new FunnelEvent("STREAM_STOPPED", 35, "stream_stopped");
    public static final FunnelEvent STREAM_FAILED = new FunnelEvent("STREAM_FAILED", 36, "stream_failed");
    public static final FunnelEvent KEYFRAME_REQUESTED = new FunnelEvent("KEYFRAME_REQUESTED", 37, "keyframe_requested");
    public static final FunnelEvent PAYWALL_VIEWED = new FunnelEvent("PAYWALL_VIEWED", 38, "paywall_viewed");
    public static final FunnelEvent PAYWALL_CTA_CLICKED = new FunnelEvent("PAYWALL_CTA_CLICKED", 39, "paywall_cta_clicked");
    public static final FunnelEvent PAYWALL_DISMISSED = new FunnelEvent("PAYWALL_DISMISSED", 40, "paywall_dismissed");
    public static final FunnelEvent PURCHASE_INITIATED = new FunnelEvent("PURCHASE_INITIATED", 41, "purchase_initiated");
    public static final FunnelEvent PURCHASE_COMPLETED = new FunnelEvent("PURCHASE_COMPLETED", 42, "purchase_completed");
    public static final FunnelEvent PURCHASE_FAILED = new FunnelEvent("PURCHASE_FAILED", 43, "purchase_failed");
    public static final FunnelEvent PURCHASE_CANCELLED = new FunnelEvent("PURCHASE_CANCELLED", 44, "purchase_cancelled");
    public static final FunnelEvent PURCHASE_RESTORED = new FunnelEvent("PURCHASE_RESTORED", 45, "purchase_restored");
    public static final FunnelEvent DEMO_REARMED = new FunnelEvent("DEMO_REARMED", 46, "demo_rearmed");
    public static final FunnelEvent TRIAL_STARTED = new FunnelEvent("TRIAL_STARTED", 47, "trial_started");
    public static final FunnelEvent TRIAL_ENDED = new FunnelEvent("TRIAL_ENDED", 48, "trial_ended");
    public static final FunnelEvent SUBSCRIPTION_STARTED = new FunnelEvent("SUBSCRIPTION_STARTED", 49, "subscription_started");
    public static final FunnelEvent SUBSCRIPTION_RENEWED = new FunnelEvent("SUBSCRIPTION_RENEWED", 50, "subscription_renewed");
    public static final FunnelEvent SUBSCRIPTION_CANCELLED = new FunnelEvent("SUBSCRIPTION_CANCELLED", 51, "subscription_cancelled");
    public static final FunnelEvent SUBSCRIPTION_EXPIRED = new FunnelEvent("SUBSCRIPTION_EXPIRED", 52, "subscription_expired");
    public static final FunnelEvent FEATURE_USED = new FunnelEvent("FEATURE_USED", 53, "feature_used");
    public static final FunnelEvent ERROR_OCCURRED = new FunnelEvent("ERROR_OCCURRED", 54, "error_occurred");

    private static final /* synthetic */ FunnelEvent[] $values() {
        return new FunnelEvent[]{APP_INSTALLED, APP_OPENED, APP_QUIT, AUTO_START_BLUETOOTH, BT_RECEIVER_TRIGGERED, BT_AUTO_START_BLOCKED, BT_AUTO_START_FAILED, BT_DISCONNECTED, SESSION_START_ATTEMPT, SESSION_START, SESSION_END, ONBOARDING_STARTED, ONBOARDING_COMPLETED, TESLA_DETECTED, AA_HANDSHAKE_SUCCESS, HTTP_SERVER_CONNECTED, WEBSOCKET_CONNECTED, VPN_CONNECTED, VPN_DISCONNECTED, VPN_CONNECTION_FAILED, CONNECTION_FAILURE, FIRST_FRAME_RECEIVED, BLUETOOTH_SCAN_STARTED, BLUETOOTH_SCAN_COMPLETED, BLUETOOTH_DEVICE_FOUND, BLUETOOTH_DEVICE_SELECTED, BLUETOOTH_CONNECTING, BLUETOOTH_CONNECTED, BLUETOOTH_DISCONNECTED, BLUETOOTH_CONNECTION_FAILED, STREAM_REQUESTED, STREAM_STARTED, STREAM_FPS_SAMPLED, STREAM_PAUSED, STREAM_RESUMED, STREAM_STOPPED, STREAM_FAILED, KEYFRAME_REQUESTED, PAYWALL_VIEWED, PAYWALL_CTA_CLICKED, PAYWALL_DISMISSED, PURCHASE_INITIATED, PURCHASE_COMPLETED, PURCHASE_FAILED, PURCHASE_CANCELLED, PURCHASE_RESTORED, DEMO_REARMED, TRIAL_STARTED, TRIAL_ENDED, SUBSCRIPTION_STARTED, SUBSCRIPTION_RENEWED, SUBSCRIPTION_CANCELLED, SUBSCRIPTION_EXPIRED, FEATURE_USED, ERROR_OCCURRED};
    }

    static {
        FunnelEvent[] funnelEventArr$values = $values();
        $VALUES = funnelEventArr$values;
        $ENTRIES = f.w(funnelEventArr$values);
    }

    private FunnelEvent(String str, int i, String str2) {
        this.eventName = str2;
    }

    @NotNull
    public static EnumEntries<FunnelEvent> getEntries() {
        return $ENTRIES;
    }

    public static FunnelEvent valueOf(String str) {
        return (FunnelEvent) Enum.valueOf(FunnelEvent.class, str);
    }

    public static FunnelEvent[] values() {
        return (FunnelEvent[]) $VALUES.clone();
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }
}
