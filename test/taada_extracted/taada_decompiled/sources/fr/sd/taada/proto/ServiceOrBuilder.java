package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ServiceOrBuilder extends MessageLiteOrBuilder {
    BluetoothService getBluetoothService();

    GenericNotificationService getGenericNotificationService();

    int getId();

    InputSourceService getInputSourceService();

    MediaBrowserService getMediaBrowserService();

    MediaPlaybackStatusService getMediaPlaybackService();

    MediaSinkService getMediaSinkService();

    MediaSourceService getMediaSourceService();

    NavigationStatusService getNavigationStatusService();

    PhoneStatusService getPhoneStatusService();

    RadioService getRadioService();

    SensorSourceService getSensorSourceService();

    VendorExtensionService getVendorExtensionService();

    WifiProjectionService getWifiProjectionService();

    boolean hasBluetoothService();

    boolean hasGenericNotificationService();

    boolean hasId();

    boolean hasInputSourceService();

    boolean hasMediaBrowserService();

    boolean hasMediaPlaybackService();

    boolean hasMediaSinkService();

    boolean hasMediaSourceService();

    boolean hasNavigationStatusService();

    boolean hasPhoneStatusService();

    boolean hasRadioService();

    boolean hasSensorSourceService();

    boolean hasVendorExtensionService();

    boolean hasWifiProjectionService();
}
