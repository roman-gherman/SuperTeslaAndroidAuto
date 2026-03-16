package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.BluetoothService;
import fr.sd.taada.proto.GenericNotificationService;
import fr.sd.taada.proto.InputSourceService;
import fr.sd.taada.proto.MediaBrowserService;
import fr.sd.taada.proto.MediaPlaybackStatusService;
import fr.sd.taada.proto.MediaSinkService;
import fr.sd.taada.proto.MediaSourceService;
import fr.sd.taada.proto.NavigationStatusService;
import fr.sd.taada.proto.PhoneStatusService;
import fr.sd.taada.proto.RadioService;
import fr.sd.taada.proto.SensorSourceService;
import fr.sd.taada.proto.VendorExtensionService;
import fr.sd.taada.proto.WifiProjectionService;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class Service extends GeneratedMessageLite<Service, Builder> implements ServiceOrBuilder {
    public static final int BLUETOOTH_SERVICE_FIELD_NUMBER = 6;
    private static final Service DEFAULT_INSTANCE;
    public static final int GENERIC_NOTIFICATION_SERVICE_FIELD_NUMBER = 13;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INPUT_SOURCE_SERVICE_FIELD_NUMBER = 4;
    public static final int MEDIA_BROWSER_SERVICE_FIELD_NUMBER = 11;
    public static final int MEDIA_PLAYBACK_SERVICE_FIELD_NUMBER = 9;
    public static final int MEDIA_SINK_SERVICE_FIELD_NUMBER = 3;
    public static final int MEDIA_SOURCE_SERVICE_FIELD_NUMBER = 5;
    public static final int NAVIGATION_STATUS_SERVICE_FIELD_NUMBER = 8;
    private static volatile Parser<Service> PARSER = null;
    public static final int PHONE_STATUS_SERVICE_FIELD_NUMBER = 10;
    public static final int RADIO_SERVICE_FIELD_NUMBER = 7;
    public static final int SENSOR_SOURCE_SERVICE_FIELD_NUMBER = 2;
    public static final int VENDOR_EXTENSION_SERVICE_FIELD_NUMBER = 12;
    public static final int WIFI_PROJECTION_SERVICE_FIELD_NUMBER = 14;
    private int bitField0_;
    private BluetoothService bluetoothService_;
    private GenericNotificationService genericNotificationService_;
    private int id_;
    private InputSourceService inputSourceService_;
    private MediaBrowserService mediaBrowserService_;
    private MediaPlaybackStatusService mediaPlaybackService_;
    private MediaSinkService mediaSinkService_;
    private MediaSourceService mediaSourceService_;
    private byte memoizedIsInitialized = 2;
    private NavigationStatusService navigationStatusService_;
    private PhoneStatusService phoneStatusService_;
    private RadioService radioService_;
    private SensorSourceService sensorSourceService_;
    private VendorExtensionService vendorExtensionService_;
    private WifiProjectionService wifiProjectionService_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.Service$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBluetoothService() {
            copyOnWrite();
            ((Service) this.instance).clearBluetoothService();
            return this;
        }

        public Builder clearGenericNotificationService() {
            copyOnWrite();
            ((Service) this.instance).clearGenericNotificationService();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((Service) this.instance).clearId();
            return this;
        }

        public Builder clearInputSourceService() {
            copyOnWrite();
            ((Service) this.instance).clearInputSourceService();
            return this;
        }

        public Builder clearMediaBrowserService() {
            copyOnWrite();
            ((Service) this.instance).clearMediaBrowserService();
            return this;
        }

        public Builder clearMediaPlaybackService() {
            copyOnWrite();
            ((Service) this.instance).clearMediaPlaybackService();
            return this;
        }

        public Builder clearMediaSinkService() {
            copyOnWrite();
            ((Service) this.instance).clearMediaSinkService();
            return this;
        }

        public Builder clearMediaSourceService() {
            copyOnWrite();
            ((Service) this.instance).clearMediaSourceService();
            return this;
        }

        public Builder clearNavigationStatusService() {
            copyOnWrite();
            ((Service) this.instance).clearNavigationStatusService();
            return this;
        }

        public Builder clearPhoneStatusService() {
            copyOnWrite();
            ((Service) this.instance).clearPhoneStatusService();
            return this;
        }

        public Builder clearRadioService() {
            copyOnWrite();
            ((Service) this.instance).clearRadioService();
            return this;
        }

        public Builder clearSensorSourceService() {
            copyOnWrite();
            ((Service) this.instance).clearSensorSourceService();
            return this;
        }

        public Builder clearVendorExtensionService() {
            copyOnWrite();
            ((Service) this.instance).clearVendorExtensionService();
            return this;
        }

        public Builder clearWifiProjectionService() {
            copyOnWrite();
            ((Service) this.instance).clearWifiProjectionService();
            return this;
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public BluetoothService getBluetoothService() {
            return ((Service) this.instance).getBluetoothService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public GenericNotificationService getGenericNotificationService() {
            return ((Service) this.instance).getGenericNotificationService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public int getId() {
            return ((Service) this.instance).getId();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public InputSourceService getInputSourceService() {
            return ((Service) this.instance).getInputSourceService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public MediaBrowserService getMediaBrowserService() {
            return ((Service) this.instance).getMediaBrowserService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public MediaPlaybackStatusService getMediaPlaybackService() {
            return ((Service) this.instance).getMediaPlaybackService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public MediaSinkService getMediaSinkService() {
            return ((Service) this.instance).getMediaSinkService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public MediaSourceService getMediaSourceService() {
            return ((Service) this.instance).getMediaSourceService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public NavigationStatusService getNavigationStatusService() {
            return ((Service) this.instance).getNavigationStatusService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public PhoneStatusService getPhoneStatusService() {
            return ((Service) this.instance).getPhoneStatusService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public RadioService getRadioService() {
            return ((Service) this.instance).getRadioService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public SensorSourceService getSensorSourceService() {
            return ((Service) this.instance).getSensorSourceService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public VendorExtensionService getVendorExtensionService() {
            return ((Service) this.instance).getVendorExtensionService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public WifiProjectionService getWifiProjectionService() {
            return ((Service) this.instance).getWifiProjectionService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasBluetoothService() {
            return ((Service) this.instance).hasBluetoothService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasGenericNotificationService() {
            return ((Service) this.instance).hasGenericNotificationService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasId() {
            return ((Service) this.instance).hasId();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasInputSourceService() {
            return ((Service) this.instance).hasInputSourceService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasMediaBrowserService() {
            return ((Service) this.instance).hasMediaBrowserService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasMediaPlaybackService() {
            return ((Service) this.instance).hasMediaPlaybackService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasMediaSinkService() {
            return ((Service) this.instance).hasMediaSinkService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasMediaSourceService() {
            return ((Service) this.instance).hasMediaSourceService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasNavigationStatusService() {
            return ((Service) this.instance).hasNavigationStatusService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasPhoneStatusService() {
            return ((Service) this.instance).hasPhoneStatusService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasRadioService() {
            return ((Service) this.instance).hasRadioService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasSensorSourceService() {
            return ((Service) this.instance).hasSensorSourceService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasVendorExtensionService() {
            return ((Service) this.instance).hasVendorExtensionService();
        }

        @Override // fr.sd.taada.proto.ServiceOrBuilder
        public boolean hasWifiProjectionService() {
            return ((Service) this.instance).hasWifiProjectionService();
        }

        public Builder mergeBluetoothService(BluetoothService bluetoothService) {
            copyOnWrite();
            ((Service) this.instance).mergeBluetoothService(bluetoothService);
            return this;
        }

        public Builder mergeGenericNotificationService(GenericNotificationService genericNotificationService) {
            copyOnWrite();
            ((Service) this.instance).mergeGenericNotificationService(genericNotificationService);
            return this;
        }

        public Builder mergeInputSourceService(InputSourceService inputSourceService) {
            copyOnWrite();
            ((Service) this.instance).mergeInputSourceService(inputSourceService);
            return this;
        }

        public Builder mergeMediaBrowserService(MediaBrowserService mediaBrowserService) {
            copyOnWrite();
            ((Service) this.instance).mergeMediaBrowserService(mediaBrowserService);
            return this;
        }

        public Builder mergeMediaPlaybackService(MediaPlaybackStatusService mediaPlaybackStatusService) {
            copyOnWrite();
            ((Service) this.instance).mergeMediaPlaybackService(mediaPlaybackStatusService);
            return this;
        }

        public Builder mergeMediaSinkService(MediaSinkService mediaSinkService) {
            copyOnWrite();
            ((Service) this.instance).mergeMediaSinkService(mediaSinkService);
            return this;
        }

        public Builder mergeMediaSourceService(MediaSourceService mediaSourceService) {
            copyOnWrite();
            ((Service) this.instance).mergeMediaSourceService(mediaSourceService);
            return this;
        }

        public Builder mergeNavigationStatusService(NavigationStatusService navigationStatusService) {
            copyOnWrite();
            ((Service) this.instance).mergeNavigationStatusService(navigationStatusService);
            return this;
        }

        public Builder mergePhoneStatusService(PhoneStatusService phoneStatusService) {
            copyOnWrite();
            ((Service) this.instance).mergePhoneStatusService(phoneStatusService);
            return this;
        }

        public Builder mergeRadioService(RadioService radioService) {
            copyOnWrite();
            ((Service) this.instance).mergeRadioService(radioService);
            return this;
        }

        public Builder mergeSensorSourceService(SensorSourceService sensorSourceService) {
            copyOnWrite();
            ((Service) this.instance).mergeSensorSourceService(sensorSourceService);
            return this;
        }

        public Builder mergeVendorExtensionService(VendorExtensionService vendorExtensionService) {
            copyOnWrite();
            ((Service) this.instance).mergeVendorExtensionService(vendorExtensionService);
            return this;
        }

        public Builder mergeWifiProjectionService(WifiProjectionService wifiProjectionService) {
            copyOnWrite();
            ((Service) this.instance).mergeWifiProjectionService(wifiProjectionService);
            return this;
        }

        public Builder setBluetoothService(BluetoothService bluetoothService) {
            copyOnWrite();
            ((Service) this.instance).setBluetoothService(bluetoothService);
            return this;
        }

        public Builder setGenericNotificationService(GenericNotificationService genericNotificationService) {
            copyOnWrite();
            ((Service) this.instance).setGenericNotificationService(genericNotificationService);
            return this;
        }

        public Builder setId(int i) {
            copyOnWrite();
            ((Service) this.instance).setId(i);
            return this;
        }

        public Builder setInputSourceService(InputSourceService inputSourceService) {
            copyOnWrite();
            ((Service) this.instance).setInputSourceService(inputSourceService);
            return this;
        }

        public Builder setMediaBrowserService(MediaBrowserService mediaBrowserService) {
            copyOnWrite();
            ((Service) this.instance).setMediaBrowserService(mediaBrowserService);
            return this;
        }

        public Builder setMediaPlaybackService(MediaPlaybackStatusService mediaPlaybackStatusService) {
            copyOnWrite();
            ((Service) this.instance).setMediaPlaybackService(mediaPlaybackStatusService);
            return this;
        }

        public Builder setMediaSinkService(MediaSinkService mediaSinkService) {
            copyOnWrite();
            ((Service) this.instance).setMediaSinkService(mediaSinkService);
            return this;
        }

        public Builder setMediaSourceService(MediaSourceService mediaSourceService) {
            copyOnWrite();
            ((Service) this.instance).setMediaSourceService(mediaSourceService);
            return this;
        }

        public Builder setNavigationStatusService(NavigationStatusService navigationStatusService) {
            copyOnWrite();
            ((Service) this.instance).setNavigationStatusService(navigationStatusService);
            return this;
        }

        public Builder setPhoneStatusService(PhoneStatusService phoneStatusService) {
            copyOnWrite();
            ((Service) this.instance).setPhoneStatusService(phoneStatusService);
            return this;
        }

        public Builder setRadioService(RadioService radioService) {
            copyOnWrite();
            ((Service) this.instance).setRadioService(radioService);
            return this;
        }

        public Builder setSensorSourceService(SensorSourceService sensorSourceService) {
            copyOnWrite();
            ((Service) this.instance).setSensorSourceService(sensorSourceService);
            return this;
        }

        public Builder setVendorExtensionService(VendorExtensionService vendorExtensionService) {
            copyOnWrite();
            ((Service) this.instance).setVendorExtensionService(vendorExtensionService);
            return this;
        }

        public Builder setWifiProjectionService(WifiProjectionService wifiProjectionService) {
            copyOnWrite();
            ((Service) this.instance).setWifiProjectionService(wifiProjectionService);
            return this;
        }

        private Builder() {
            super(Service.DEFAULT_INSTANCE);
        }

        public Builder setBluetoothService(BluetoothService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setBluetoothService(builder);
            return this;
        }

        public Builder setGenericNotificationService(GenericNotificationService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setGenericNotificationService(builder);
            return this;
        }

        public Builder setInputSourceService(InputSourceService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setInputSourceService(builder);
            return this;
        }

        public Builder setMediaBrowserService(MediaBrowserService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setMediaBrowserService(builder);
            return this;
        }

        public Builder setMediaPlaybackService(MediaPlaybackStatusService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setMediaPlaybackService(builder);
            return this;
        }

        public Builder setMediaSinkService(MediaSinkService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setMediaSinkService(builder);
            return this;
        }

        public Builder setMediaSourceService(MediaSourceService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setMediaSourceService(builder);
            return this;
        }

        public Builder setNavigationStatusService(NavigationStatusService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setNavigationStatusService(builder);
            return this;
        }

        public Builder setPhoneStatusService(PhoneStatusService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setPhoneStatusService(builder);
            return this;
        }

        public Builder setRadioService(RadioService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setRadioService(builder);
            return this;
        }

        public Builder setSensorSourceService(SensorSourceService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setSensorSourceService(builder);
            return this;
        }

        public Builder setVendorExtensionService(VendorExtensionService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setVendorExtensionService(builder);
            return this;
        }

        public Builder setWifiProjectionService(WifiProjectionService.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setWifiProjectionService(builder);
            return this;
        }
    }

    static {
        Service service = new Service();
        DEFAULT_INSTANCE = service;
        GeneratedMessageLite.registerDefaultInstance(Service.class, service);
    }

    private Service() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBluetoothService() {
        this.bluetoothService_ = null;
        this.bitField0_ &= -33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGenericNotificationService() {
        this.genericNotificationService_ = null;
        this.bitField0_ &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.bitField0_ &= -2;
        this.id_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInputSourceService() {
        this.inputSourceService_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaBrowserService() {
        this.mediaBrowserService_ = null;
        this.bitField0_ &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaPlaybackService() {
        this.mediaPlaybackService_ = null;
        this.bitField0_ &= -257;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaSinkService() {
        this.mediaSinkService_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaSourceService() {
        this.mediaSourceService_ = null;
        this.bitField0_ &= -17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNavigationStatusService() {
        this.navigationStatusService_ = null;
        this.bitField0_ &= -129;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhoneStatusService() {
        this.phoneStatusService_ = null;
        this.bitField0_ &= -513;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioService() {
        this.radioService_ = null;
        this.bitField0_ &= -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSensorSourceService() {
        this.sensorSourceService_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVendorExtensionService() {
        this.vendorExtensionService_ = null;
        this.bitField0_ &= -2049;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWifiProjectionService() {
        this.wifiProjectionService_ = null;
        this.bitField0_ &= -8193;
    }

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBluetoothService(BluetoothService bluetoothService) {
        bluetoothService.getClass();
        BluetoothService bluetoothService2 = this.bluetoothService_;
        if (bluetoothService2 == null || bluetoothService2 == BluetoothService.getDefaultInstance()) {
            this.bluetoothService_ = bluetoothService;
        } else {
            this.bluetoothService_ = BluetoothService.newBuilder(this.bluetoothService_).mergeFrom(bluetoothService).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGenericNotificationService(GenericNotificationService genericNotificationService) {
        genericNotificationService.getClass();
        GenericNotificationService genericNotificationService2 = this.genericNotificationService_;
        if (genericNotificationService2 == null || genericNotificationService2 == GenericNotificationService.getDefaultInstance()) {
            this.genericNotificationService_ = genericNotificationService;
        } else {
            this.genericNotificationService_ = GenericNotificationService.newBuilder(this.genericNotificationService_).mergeFrom(genericNotificationService).buildPartial();
        }
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInputSourceService(InputSourceService inputSourceService) {
        inputSourceService.getClass();
        InputSourceService inputSourceService2 = this.inputSourceService_;
        if (inputSourceService2 == null || inputSourceService2 == InputSourceService.getDefaultInstance()) {
            this.inputSourceService_ = inputSourceService;
        } else {
            this.inputSourceService_ = InputSourceService.newBuilder(this.inputSourceService_).mergeFrom(inputSourceService).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMediaBrowserService(MediaBrowserService mediaBrowserService) {
        mediaBrowserService.getClass();
        MediaBrowserService mediaBrowserService2 = this.mediaBrowserService_;
        if (mediaBrowserService2 == null || mediaBrowserService2 == MediaBrowserService.getDefaultInstance()) {
            this.mediaBrowserService_ = mediaBrowserService;
        } else {
            this.mediaBrowserService_ = MediaBrowserService.newBuilder(this.mediaBrowserService_).mergeFrom(mediaBrowserService).buildPartial();
        }
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMediaPlaybackService(MediaPlaybackStatusService mediaPlaybackStatusService) {
        mediaPlaybackStatusService.getClass();
        MediaPlaybackStatusService mediaPlaybackStatusService2 = this.mediaPlaybackService_;
        if (mediaPlaybackStatusService2 == null || mediaPlaybackStatusService2 == MediaPlaybackStatusService.getDefaultInstance()) {
            this.mediaPlaybackService_ = mediaPlaybackStatusService;
        } else {
            this.mediaPlaybackService_ = MediaPlaybackStatusService.newBuilder(this.mediaPlaybackService_).mergeFrom(mediaPlaybackStatusService).buildPartial();
        }
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMediaSinkService(MediaSinkService mediaSinkService) {
        mediaSinkService.getClass();
        MediaSinkService mediaSinkService2 = this.mediaSinkService_;
        if (mediaSinkService2 == null || mediaSinkService2 == MediaSinkService.getDefaultInstance()) {
            this.mediaSinkService_ = mediaSinkService;
        } else {
            this.mediaSinkService_ = MediaSinkService.newBuilder(this.mediaSinkService_).mergeFrom(mediaSinkService).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMediaSourceService(MediaSourceService mediaSourceService) {
        mediaSourceService.getClass();
        MediaSourceService mediaSourceService2 = this.mediaSourceService_;
        if (mediaSourceService2 == null || mediaSourceService2 == MediaSourceService.getDefaultInstance()) {
            this.mediaSourceService_ = mediaSourceService;
        } else {
            this.mediaSourceService_ = MediaSourceService.newBuilder(this.mediaSourceService_).mergeFrom(mediaSourceService).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNavigationStatusService(NavigationStatusService navigationStatusService) {
        navigationStatusService.getClass();
        NavigationStatusService navigationStatusService2 = this.navigationStatusService_;
        if (navigationStatusService2 == null || navigationStatusService2 == NavigationStatusService.getDefaultInstance()) {
            this.navigationStatusService_ = navigationStatusService;
        } else {
            this.navigationStatusService_ = NavigationStatusService.newBuilder(this.navigationStatusService_).mergeFrom(navigationStatusService).buildPartial();
        }
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePhoneStatusService(PhoneStatusService phoneStatusService) {
        phoneStatusService.getClass();
        PhoneStatusService phoneStatusService2 = this.phoneStatusService_;
        if (phoneStatusService2 == null || phoneStatusService2 == PhoneStatusService.getDefaultInstance()) {
            this.phoneStatusService_ = phoneStatusService;
        } else {
            this.phoneStatusService_ = PhoneStatusService.newBuilder(this.phoneStatusService_).mergeFrom(phoneStatusService).buildPartial();
        }
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRadioService(RadioService radioService) {
        radioService.getClass();
        RadioService radioService2 = this.radioService_;
        if (radioService2 == null || radioService2 == RadioService.getDefaultInstance()) {
            this.radioService_ = radioService;
        } else {
            this.radioService_ = RadioService.newBuilder(this.radioService_).mergeFrom(radioService).buildPartial();
        }
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSensorSourceService(SensorSourceService sensorSourceService) {
        sensorSourceService.getClass();
        SensorSourceService sensorSourceService2 = this.sensorSourceService_;
        if (sensorSourceService2 == null || sensorSourceService2 == SensorSourceService.getDefaultInstance()) {
            this.sensorSourceService_ = sensorSourceService;
        } else {
            this.sensorSourceService_ = SensorSourceService.newBuilder(this.sensorSourceService_).mergeFrom(sensorSourceService).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVendorExtensionService(VendorExtensionService vendorExtensionService) {
        vendorExtensionService.getClass();
        VendorExtensionService vendorExtensionService2 = this.vendorExtensionService_;
        if (vendorExtensionService2 == null || vendorExtensionService2 == VendorExtensionService.getDefaultInstance()) {
            this.vendorExtensionService_ = vendorExtensionService;
        } else {
            this.vendorExtensionService_ = VendorExtensionService.newBuilder(this.vendorExtensionService_).mergeFrom(vendorExtensionService).buildPartial();
        }
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeWifiProjectionService(WifiProjectionService wifiProjectionService) {
        wifiProjectionService.getClass();
        WifiProjectionService wifiProjectionService2 = this.wifiProjectionService_;
        if (wifiProjectionService2 == null || wifiProjectionService2 == WifiProjectionService.getDefaultInstance()) {
            this.wifiProjectionService_ = wifiProjectionService;
        } else {
            this.wifiProjectionService_ = WifiProjectionService.newBuilder(this.wifiProjectionService_).mergeFrom(wifiProjectionService).buildPartial();
        }
        this.bitField0_ |= 8192;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Service parseDelimitedFrom(InputStream inputStream) {
        return (Service) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseFrom(ByteBuffer byteBuffer) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Service> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBluetoothService(BluetoothService bluetoothService) {
        bluetoothService.getClass();
        this.bluetoothService_ = bluetoothService;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGenericNotificationService(GenericNotificationService genericNotificationService) {
        genericNotificationService.getClass();
        this.genericNotificationService_ = genericNotificationService;
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.bitField0_ |= 1;
        this.id_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputSourceService(InputSourceService inputSourceService) {
        inputSourceService.getClass();
        this.inputSourceService_ = inputSourceService;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaBrowserService(MediaBrowserService mediaBrowserService) {
        mediaBrowserService.getClass();
        this.mediaBrowserService_ = mediaBrowserService;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaPlaybackService(MediaPlaybackStatusService mediaPlaybackStatusService) {
        mediaPlaybackStatusService.getClass();
        this.mediaPlaybackService_ = mediaPlaybackStatusService;
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSinkService(MediaSinkService mediaSinkService) {
        mediaSinkService.getClass();
        this.mediaSinkService_ = mediaSinkService;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSourceService(MediaSourceService mediaSourceService) {
        mediaSourceService.getClass();
        this.mediaSourceService_ = mediaSourceService;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationStatusService(NavigationStatusService navigationStatusService) {
        navigationStatusService.getClass();
        this.navigationStatusService_ = navigationStatusService;
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneStatusService(PhoneStatusService phoneStatusService) {
        phoneStatusService.getClass();
        this.phoneStatusService_ = phoneStatusService;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioService(RadioService radioService) {
        radioService.getClass();
        this.radioService_ = radioService;
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensorSourceService(SensorSourceService sensorSourceService) {
        sensorSourceService.getClass();
        this.sensorSourceService_ = sensorSourceService;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVendorExtensionService(VendorExtensionService vendorExtensionService) {
        vendorExtensionService.getClass();
        this.vendorExtensionService_ = vendorExtensionService;
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWifiProjectionService(WifiProjectionService wifiProjectionService) {
        wifiProjectionService.getClass();
        this.wifiProjectionService_ = wifiProjectionService;
        this.bitField0_ |= 8192;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Service();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\t\u0001Ԅ\u0000\u0002Љ\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005Љ\u0004\u0006Љ\u0005\u0007Љ\u0006\bЉ\u0007\t\t\b\n\t\t\u000b\t\n\fЉ\u000b\r\t\f\u000e\t\r", new Object[]{"bitField0_", "id_", "sensorSourceService_", "mediaSinkService_", "inputSourceService_", "mediaSourceService_", "bluetoothService_", "radioService_", "navigationStatusService_", "mediaPlaybackService_", "phoneStatusService_", "mediaBrowserService_", "vendorExtensionService_", "genericNotificationService_", "wifiProjectionService_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Service> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Service.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public BluetoothService getBluetoothService() {
        BluetoothService bluetoothService = this.bluetoothService_;
        return bluetoothService == null ? BluetoothService.getDefaultInstance() : bluetoothService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public GenericNotificationService getGenericNotificationService() {
        GenericNotificationService genericNotificationService = this.genericNotificationService_;
        return genericNotificationService == null ? GenericNotificationService.getDefaultInstance() : genericNotificationService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public int getId() {
        return this.id_;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public InputSourceService getInputSourceService() {
        InputSourceService inputSourceService = this.inputSourceService_;
        return inputSourceService == null ? InputSourceService.getDefaultInstance() : inputSourceService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public MediaBrowserService getMediaBrowserService() {
        MediaBrowserService mediaBrowserService = this.mediaBrowserService_;
        return mediaBrowserService == null ? MediaBrowserService.getDefaultInstance() : mediaBrowserService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public MediaPlaybackStatusService getMediaPlaybackService() {
        MediaPlaybackStatusService mediaPlaybackStatusService = this.mediaPlaybackService_;
        return mediaPlaybackStatusService == null ? MediaPlaybackStatusService.getDefaultInstance() : mediaPlaybackStatusService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public MediaSinkService getMediaSinkService() {
        MediaSinkService mediaSinkService = this.mediaSinkService_;
        return mediaSinkService == null ? MediaSinkService.getDefaultInstance() : mediaSinkService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public MediaSourceService getMediaSourceService() {
        MediaSourceService mediaSourceService = this.mediaSourceService_;
        return mediaSourceService == null ? MediaSourceService.getDefaultInstance() : mediaSourceService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public NavigationStatusService getNavigationStatusService() {
        NavigationStatusService navigationStatusService = this.navigationStatusService_;
        return navigationStatusService == null ? NavigationStatusService.getDefaultInstance() : navigationStatusService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public PhoneStatusService getPhoneStatusService() {
        PhoneStatusService phoneStatusService = this.phoneStatusService_;
        return phoneStatusService == null ? PhoneStatusService.getDefaultInstance() : phoneStatusService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public RadioService getRadioService() {
        RadioService radioService = this.radioService_;
        return radioService == null ? RadioService.getDefaultInstance() : radioService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public SensorSourceService getSensorSourceService() {
        SensorSourceService sensorSourceService = this.sensorSourceService_;
        return sensorSourceService == null ? SensorSourceService.getDefaultInstance() : sensorSourceService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public VendorExtensionService getVendorExtensionService() {
        VendorExtensionService vendorExtensionService = this.vendorExtensionService_;
        return vendorExtensionService == null ? VendorExtensionService.getDefaultInstance() : vendorExtensionService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public WifiProjectionService getWifiProjectionService() {
        WifiProjectionService wifiProjectionService = this.wifiProjectionService_;
        return wifiProjectionService == null ? WifiProjectionService.getDefaultInstance() : wifiProjectionService;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasBluetoothService() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasGenericNotificationService() {
        return (this.bitField0_ & 4096) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasInputSourceService() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasMediaBrowserService() {
        return (this.bitField0_ & 1024) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasMediaPlaybackService() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasMediaSinkService() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasMediaSourceService() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasNavigationStatusService() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasPhoneStatusService() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasRadioService() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasSensorSourceService() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasVendorExtensionService() {
        return (this.bitField0_ & 2048) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceOrBuilder
    public boolean hasWifiProjectionService() {
        return (this.bitField0_ & 8192) != 0;
    }

    public static Builder newBuilder(Service service) {
        return DEFAULT_INSTANCE.createBuilder(service);
    }

    public static Service parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Service parseFrom(ByteString byteString) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Service parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBluetoothService(BluetoothService.Builder builder) {
        this.bluetoothService_ = builder.build();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGenericNotificationService(GenericNotificationService.Builder builder) {
        this.genericNotificationService_ = builder.build();
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputSourceService(InputSourceService.Builder builder) {
        this.inputSourceService_ = builder.build();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaBrowserService(MediaBrowserService.Builder builder) {
        this.mediaBrowserService_ = builder.build();
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaPlaybackService(MediaPlaybackStatusService.Builder builder) {
        this.mediaPlaybackService_ = builder.build();
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSinkService(MediaSinkService.Builder builder) {
        this.mediaSinkService_ = builder.build();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSourceService(MediaSourceService.Builder builder) {
        this.mediaSourceService_ = builder.build();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationStatusService(NavigationStatusService.Builder builder) {
        this.navigationStatusService_ = builder.build();
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneStatusService(PhoneStatusService.Builder builder) {
        this.phoneStatusService_ = builder.build();
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioService(RadioService.Builder builder) {
        this.radioService_ = builder.build();
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensorSourceService(SensorSourceService.Builder builder) {
        this.sensorSourceService_ = builder.build();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVendorExtensionService(VendorExtensionService.Builder builder) {
        this.vendorExtensionService_ = builder.build();
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWifiProjectionService(WifiProjectionService.Builder builder) {
        this.wifiProjectionService_ = builder.build();
        this.bitField0_ |= 8192;
    }

    public static Service parseFrom(byte[] bArr) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Service parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Service parseFrom(InputStream inputStream) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(CodedInputStream codedInputStream) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Service parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
