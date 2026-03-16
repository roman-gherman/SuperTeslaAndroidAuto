package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.ConnectionConfiguration;
import fr.sd.taada.proto.HeadUnitInfo;
import fr.sd.taada.proto.Service;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceDiscoveryResponse extends GeneratedMessageLite<ServiceDiscoveryResponse, Builder> implements ServiceDiscoveryResponseOrBuilder {
    public static final int CAN_PLAY_NATIVE_MEDIA_DURING_VR_FIELD_NUMBER = 11;
    public static final int CONNECTION_CONFIGURATION_FIELD_NUMBER = 16;
    private static final ServiceDiscoveryResponse DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 14;
    public static final int DRIVER_POSITION_FIELD_NUMBER = 6;
    public static final int HEADUNIT_INFO_FIELD_NUMBER = 17;
    public static final int HEAD_UNIT_MAKE_FIELD_NUMBER = 7;
    public static final int HEAD_UNIT_MODEL_FIELD_NUMBER = 8;
    public static final int HEAD_UNIT_SOFTWARE_BUILD_FIELD_NUMBER = 9;
    public static final int HEAD_UNIT_SOFTWARE_VERSION_FIELD_NUMBER = 10;
    public static final int MAKE_FIELD_NUMBER = 2;
    public static final int MODEL_FIELD_NUMBER = 3;
    private static volatile Parser<ServiceDiscoveryResponse> PARSER = null;
    public static final int PROBE_FOR_SUPPORT_FIELD_NUMBER = 15;
    public static final int SERVICES_FIELD_NUMBER = 1;
    public static final int SESSION_CONFIGURATION_FIELD_NUMBER = 13;
    public static final int VEHICLE_ID_FIELD_NUMBER = 5;
    public static final int YEAR_FIELD_NUMBER = 4;
    private int bitField0_;
    private boolean canPlayNativeMediaDuringVr_;
    private ConnectionConfiguration connectionConfiguration_;
    private int driverPosition_;
    private HeadUnitInfo headunitInfo_;
    private boolean probeForSupport_;
    private int sessionConfiguration_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Service> services_ = GeneratedMessageLite.emptyProtobufList();
    private String make_ = "";
    private String model_ = "";
    private String year_ = "";
    private String vehicleId_ = "";
    private String headUnitMake_ = "";
    private String headUnitModel_ = "";
    private String headUnitSoftwareBuild_ = "";
    private String headUnitSoftwareVersion_ = "";
    private String displayName_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.ServiceDiscoveryResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ServiceDiscoveryResponse, Builder> implements ServiceDiscoveryResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllServices(Iterable<? extends Service> iterable) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).addAllServices(iterable);
            return this;
        }

        public Builder addServices(Service service) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).addServices(service);
            return this;
        }

        @Deprecated
        public Builder clearCanPlayNativeMediaDuringVr() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearCanPlayNativeMediaDuringVr();
            return this;
        }

        public Builder clearConnectionConfiguration() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearConnectionConfiguration();
            return this;
        }

        public Builder clearDisplayName() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearDisplayName();
            return this;
        }

        public Builder clearDriverPosition() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearDriverPosition();
            return this;
        }

        @Deprecated
        public Builder clearHeadUnitMake() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearHeadUnitMake();
            return this;
        }

        @Deprecated
        public Builder clearHeadUnitModel() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearHeadUnitModel();
            return this;
        }

        @Deprecated
        public Builder clearHeadUnitSoftwareBuild() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearHeadUnitSoftwareBuild();
            return this;
        }

        @Deprecated
        public Builder clearHeadUnitSoftwareVersion() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearHeadUnitSoftwareVersion();
            return this;
        }

        public Builder clearHeadunitInfo() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearHeadunitInfo();
            return this;
        }

        @Deprecated
        public Builder clearMake() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearMake();
            return this;
        }

        @Deprecated
        public Builder clearModel() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearModel();
            return this;
        }

        public Builder clearProbeForSupport() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearProbeForSupport();
            return this;
        }

        public Builder clearServices() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearServices();
            return this;
        }

        public Builder clearSessionConfiguration() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearSessionConfiguration();
            return this;
        }

        @Deprecated
        public Builder clearVehicleId() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearVehicleId();
            return this;
        }

        @Deprecated
        public Builder clearYear() {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).clearYear();
            return this;
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean getCanPlayNativeMediaDuringVr() {
            return ((ServiceDiscoveryResponse) this.instance).getCanPlayNativeMediaDuringVr();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public ConnectionConfiguration getConnectionConfiguration() {
            return ((ServiceDiscoveryResponse) this.instance).getConnectionConfiguration();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public String getDisplayName() {
            return ((ServiceDiscoveryResponse) this.instance).getDisplayName();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getDisplayNameBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public DriverPosition getDriverPosition() {
            return ((ServiceDiscoveryResponse) this.instance).getDriverPosition();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getHeadUnitMake() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitMake();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getHeadUnitMakeBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitMakeBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getHeadUnitModel() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitModel();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getHeadUnitModelBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitModelBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getHeadUnitSoftwareBuild() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitSoftwareBuild();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getHeadUnitSoftwareBuildBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitSoftwareBuildBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getHeadUnitSoftwareVersion() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitSoftwareVersion();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getHeadUnitSoftwareVersionBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadUnitSoftwareVersionBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public HeadUnitInfo getHeadunitInfo() {
            return ((ServiceDiscoveryResponse) this.instance).getHeadunitInfo();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getMake() {
            return ((ServiceDiscoveryResponse) this.instance).getMake();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getMakeBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getMakeBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getModel() {
            return ((ServiceDiscoveryResponse) this.instance).getModel();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getModelBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getModelBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public boolean getProbeForSupport() {
            return ((ServiceDiscoveryResponse) this.instance).getProbeForSupport();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public Service getServices(int i) {
            return ((ServiceDiscoveryResponse) this.instance).getServices(i);
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public int getServicesCount() {
            return ((ServiceDiscoveryResponse) this.instance).getServicesCount();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public List<Service> getServicesList() {
            return Collections.unmodifiableList(((ServiceDiscoveryResponse) this.instance).getServicesList());
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public int getSessionConfiguration() {
            return ((ServiceDiscoveryResponse) this.instance).getSessionConfiguration();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getVehicleId() {
            return ((ServiceDiscoveryResponse) this.instance).getVehicleId();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getVehicleIdBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getVehicleIdBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public String getYear() {
            return ((ServiceDiscoveryResponse) this.instance).getYear();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public ByteString getYearBytes() {
            return ((ServiceDiscoveryResponse) this.instance).getYearBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasCanPlayNativeMediaDuringVr() {
            return ((ServiceDiscoveryResponse) this.instance).hasCanPlayNativeMediaDuringVr();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public boolean hasConnectionConfiguration() {
            return ((ServiceDiscoveryResponse) this.instance).hasConnectionConfiguration();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public boolean hasDisplayName() {
            return ((ServiceDiscoveryResponse) this.instance).hasDisplayName();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public boolean hasDriverPosition() {
            return ((ServiceDiscoveryResponse) this.instance).hasDriverPosition();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasHeadUnitMake() {
            return ((ServiceDiscoveryResponse) this.instance).hasHeadUnitMake();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasHeadUnitModel() {
            return ((ServiceDiscoveryResponse) this.instance).hasHeadUnitModel();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasHeadUnitSoftwareBuild() {
            return ((ServiceDiscoveryResponse) this.instance).hasHeadUnitSoftwareBuild();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasHeadUnitSoftwareVersion() {
            return ((ServiceDiscoveryResponse) this.instance).hasHeadUnitSoftwareVersion();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public boolean hasHeadunitInfo() {
            return ((ServiceDiscoveryResponse) this.instance).hasHeadunitInfo();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasMake() {
            return ((ServiceDiscoveryResponse) this.instance).hasMake();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasModel() {
            return ((ServiceDiscoveryResponse) this.instance).hasModel();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public boolean hasProbeForSupport() {
            return ((ServiceDiscoveryResponse) this.instance).hasProbeForSupport();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        public boolean hasSessionConfiguration() {
            return ((ServiceDiscoveryResponse) this.instance).hasSessionConfiguration();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasVehicleId() {
            return ((ServiceDiscoveryResponse) this.instance).hasVehicleId();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
        @Deprecated
        public boolean hasYear() {
            return ((ServiceDiscoveryResponse) this.instance).hasYear();
        }

        public Builder mergeConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).mergeConnectionConfiguration(connectionConfiguration);
            return this;
        }

        public Builder mergeHeadunitInfo(HeadUnitInfo headUnitInfo) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).mergeHeadunitInfo(headUnitInfo);
            return this;
        }

        public Builder removeServices(int i) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).removeServices(i);
            return this;
        }

        @Deprecated
        public Builder setCanPlayNativeMediaDuringVr(boolean z6) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setCanPlayNativeMediaDuringVr(z6);
            return this;
        }

        public Builder setConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setConnectionConfiguration(connectionConfiguration);
            return this;
        }

        public Builder setDisplayName(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setDisplayName(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setDisplayNameBytes(byteString);
            return this;
        }

        public Builder setDriverPosition(DriverPosition driverPosition) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setDriverPosition(driverPosition);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitMake(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitMake(str);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitMakeBytes(byteString);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitModel(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitModel(str);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitModelBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitModelBytes(byteString);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitSoftwareBuild(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitSoftwareBuild(str);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitSoftwareBuildBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitSoftwareBuildBytes(byteString);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitSoftwareVersion(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitSoftwareVersion(str);
            return this;
        }

        @Deprecated
        public Builder setHeadUnitSoftwareVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadUnitSoftwareVersionBytes(byteString);
            return this;
        }

        public Builder setHeadunitInfo(HeadUnitInfo headUnitInfo) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadunitInfo(headUnitInfo);
            return this;
        }

        @Deprecated
        public Builder setMake(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setMake(str);
            return this;
        }

        @Deprecated
        public Builder setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setMakeBytes(byteString);
            return this;
        }

        @Deprecated
        public Builder setModel(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setModel(str);
            return this;
        }

        @Deprecated
        public Builder setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setModelBytes(byteString);
            return this;
        }

        public Builder setProbeForSupport(boolean z6) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setProbeForSupport(z6);
            return this;
        }

        public Builder setServices(int i, Service service) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setServices(i, service);
            return this;
        }

        public Builder setSessionConfiguration(int i) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setSessionConfiguration(i);
            return this;
        }

        @Deprecated
        public Builder setVehicleId(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setVehicleId(str);
            return this;
        }

        @Deprecated
        public Builder setVehicleIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setVehicleIdBytes(byteString);
            return this;
        }

        @Deprecated
        public Builder setYear(String str) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setYear(str);
            return this;
        }

        @Deprecated
        public Builder setYearBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setYearBytes(byteString);
            return this;
        }

        private Builder() {
            super(ServiceDiscoveryResponse.DEFAULT_INSTANCE);
        }

        public Builder addServices(int i, Service service) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).addServices(i, service);
            return this;
        }

        public Builder setConnectionConfiguration(ConnectionConfiguration.Builder builder) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setConnectionConfiguration(builder);
            return this;
        }

        public Builder setHeadunitInfo(HeadUnitInfo.Builder builder) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setHeadunitInfo(builder);
            return this;
        }

        public Builder setServices(int i, Service.Builder builder) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).setServices(i, builder);
            return this;
        }

        public Builder addServices(Service.Builder builder) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).addServices(builder);
            return this;
        }

        public Builder addServices(int i, Service.Builder builder) {
            copyOnWrite();
            ((ServiceDiscoveryResponse) this.instance).addServices(i, builder);
            return this;
        }
    }

    static {
        ServiceDiscoveryResponse serviceDiscoveryResponse = new ServiceDiscoveryResponse();
        DEFAULT_INSTANCE = serviceDiscoveryResponse;
        GeneratedMessageLite.registerDefaultInstance(ServiceDiscoveryResponse.class, serviceDiscoveryResponse);
    }

    private ServiceDiscoveryResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllServices(Iterable<? extends Service> iterable) {
        ensureServicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.services_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addServices(Service service) {
        service.getClass();
        ensureServicesIsMutable();
        this.services_.add(service);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanPlayNativeMediaDuringVr() {
        this.bitField0_ &= -513;
        this.canPlayNativeMediaDuringVr_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionConfiguration() {
        this.connectionConfiguration_ = null;
        this.bitField0_ &= -8193;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayName() {
        this.bitField0_ &= -2049;
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDriverPosition() {
        this.bitField0_ &= -17;
        this.driverPosition_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitMake() {
        this.bitField0_ &= -33;
        this.headUnitMake_ = getDefaultInstance().getHeadUnitMake();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitModel() {
        this.bitField0_ &= -65;
        this.headUnitModel_ = getDefaultInstance().getHeadUnitModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitSoftwareBuild() {
        this.bitField0_ &= -129;
        this.headUnitSoftwareBuild_ = getDefaultInstance().getHeadUnitSoftwareBuild();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitSoftwareVersion() {
        this.bitField0_ &= -257;
        this.headUnitSoftwareVersion_ = getDefaultInstance().getHeadUnitSoftwareVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadunitInfo() {
        this.headunitInfo_ = null;
        this.bitField0_ &= -16385;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMake() {
        this.bitField0_ &= -2;
        this.make_ = getDefaultInstance().getMake();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModel() {
        this.bitField0_ &= -3;
        this.model_ = getDefaultInstance().getModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProbeForSupport() {
        this.bitField0_ &= -4097;
        this.probeForSupport_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServices() {
        this.services_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionConfiguration() {
        this.bitField0_ &= -1025;
        this.sessionConfiguration_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVehicleId() {
        this.bitField0_ &= -9;
        this.vehicleId_ = getDefaultInstance().getVehicleId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearYear() {
        this.bitField0_ &= -5;
        this.year_ = getDefaultInstance().getYear();
    }

    private void ensureServicesIsMutable() {
        if (this.services_.isModifiable()) {
            return;
        }
        this.services_ = GeneratedMessageLite.mutableCopy(this.services_);
    }

    public static ServiceDiscoveryResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
        connectionConfiguration.getClass();
        ConnectionConfiguration connectionConfiguration2 = this.connectionConfiguration_;
        if (connectionConfiguration2 == null || connectionConfiguration2 == ConnectionConfiguration.getDefaultInstance()) {
            this.connectionConfiguration_ = connectionConfiguration;
        } else {
            this.connectionConfiguration_ = ConnectionConfiguration.newBuilder(this.connectionConfiguration_).mergeFrom(connectionConfiguration).buildPartial();
        }
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHeadunitInfo(HeadUnitInfo headUnitInfo) {
        headUnitInfo.getClass();
        HeadUnitInfo headUnitInfo2 = this.headunitInfo_;
        if (headUnitInfo2 == null || headUnitInfo2 == HeadUnitInfo.getDefaultInstance()) {
            this.headunitInfo_ = headUnitInfo;
        } else {
            this.headunitInfo_ = HeadUnitInfo.newBuilder(this.headunitInfo_).mergeFrom(headUnitInfo).buildPartial();
        }
        this.bitField0_ |= 16384;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ServiceDiscoveryResponse parseDelimitedFrom(InputStream inputStream) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServiceDiscoveryResponse parseFrom(ByteBuffer byteBuffer) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ServiceDiscoveryResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeServices(int i) {
        ensureServicesIsMutable();
        this.services_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanPlayNativeMediaDuringVr(boolean z6) {
        this.bitField0_ |= 512;
        this.canPlayNativeMediaDuringVr_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
        connectionConfiguration.getClass();
        this.connectionConfiguration_ = connectionConfiguration;
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayName(String str) {
        str.getClass();
        this.bitField0_ |= 2048;
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2048;
        this.displayName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDriverPosition(DriverPosition driverPosition) {
        driverPosition.getClass();
        this.bitField0_ |= 16;
        this.driverPosition_ = driverPosition.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitMake(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.headUnitMake_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitMakeBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 32;
        this.headUnitMake_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitModel(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.headUnitModel_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitModelBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 64;
        this.headUnitModel_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareBuild(String str) {
        str.getClass();
        this.bitField0_ |= 128;
        this.headUnitSoftwareBuild_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareBuildBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 128;
        this.headUnitSoftwareBuild_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareVersion(String str) {
        str.getClass();
        this.bitField0_ |= 256;
        this.headUnitSoftwareVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareVersionBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 256;
        this.headUnitSoftwareVersion_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadunitInfo(HeadUnitInfo headUnitInfo) {
        headUnitInfo.getClass();
        this.headunitInfo_ = headUnitInfo;
        this.bitField0_ |= 16384;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMake(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.make_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.make_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModel(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.model_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.model_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProbeForSupport(boolean z6) {
        this.bitField0_ |= 4096;
        this.probeForSupport_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServices(int i, Service service) {
        service.getClass();
        ensureServicesIsMutable();
        this.services_.set(i, service);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionConfiguration(int i) {
        this.bitField0_ |= 1024;
        this.sessionConfiguration_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVehicleId(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.vehicleId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVehicleIdBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.vehicleId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setYear(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.year_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setYearBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.year_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ServiceDiscoveryResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0010\u0000\u0001\u0001\u0011\u0010\u0000\u0001\u0001\u0001Л\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\f\u0004\u0007\b\u0005\b\b\u0006\t\b\u0007\n\b\b\u000b\u0007\t\r\u0004\n\u000e\b\u000b\u000f\u0007\f\u0010\t\r\u0011\t\u000e", new Object[]{"bitField0_", "services_", Service.class, "make_", "model_", "year_", "vehicleId_", "driverPosition_", DriverPosition.internalGetVerifier(), "headUnitMake_", "headUnitModel_", "headUnitSoftwareBuild_", "headUnitSoftwareVersion_", "canPlayNativeMediaDuringVr_", "sessionConfiguration_", "displayName_", "probeForSupport_", "connectionConfiguration_", "headunitInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ServiceDiscoveryResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ServiceDiscoveryResponse.class) {
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

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean getCanPlayNativeMediaDuringVr() {
        return this.canPlayNativeMediaDuringVr_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public ConnectionConfiguration getConnectionConfiguration() {
        ConnectionConfiguration connectionConfiguration = this.connectionConfiguration_;
        return connectionConfiguration == null ? ConnectionConfiguration.getDefaultInstance() : connectionConfiguration;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public DriverPosition getDriverPosition() {
        DriverPosition driverPositionForNumber = DriverPosition.forNumber(this.driverPosition_);
        return driverPositionForNumber == null ? DriverPosition.DRIVER_POSITION_LEFT : driverPositionForNumber;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getHeadUnitMake() {
        return this.headUnitMake_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getHeadUnitMakeBytes() {
        return ByteString.copyFromUtf8(this.headUnitMake_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getHeadUnitModel() {
        return this.headUnitModel_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getHeadUnitModelBytes() {
        return ByteString.copyFromUtf8(this.headUnitModel_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getHeadUnitSoftwareBuild() {
        return this.headUnitSoftwareBuild_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getHeadUnitSoftwareBuildBytes() {
        return ByteString.copyFromUtf8(this.headUnitSoftwareBuild_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getHeadUnitSoftwareVersion() {
        return this.headUnitSoftwareVersion_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getHeadUnitSoftwareVersionBytes() {
        return ByteString.copyFromUtf8(this.headUnitSoftwareVersion_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public HeadUnitInfo getHeadunitInfo() {
        HeadUnitInfo headUnitInfo = this.headunitInfo_;
        return headUnitInfo == null ? HeadUnitInfo.getDefaultInstance() : headUnitInfo;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getMake() {
        return this.make_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getMakeBytes() {
        return ByteString.copyFromUtf8(this.make_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getModel() {
        return this.model_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public boolean getProbeForSupport() {
        return this.probeForSupport_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public Service getServices(int i) {
        return this.services_.get(i);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public int getServicesCount() {
        return this.services_.size();
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public List<Service> getServicesList() {
        return this.services_;
    }

    public ServiceOrBuilder getServicesOrBuilder(int i) {
        return this.services_.get(i);
    }

    public List<? extends ServiceOrBuilder> getServicesOrBuilderList() {
        return this.services_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public int getSessionConfiguration() {
        return this.sessionConfiguration_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getVehicleId() {
        return this.vehicleId_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getVehicleIdBytes() {
        return ByteString.copyFromUtf8(this.vehicleId_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public String getYear() {
        return this.year_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public ByteString getYearBytes() {
        return ByteString.copyFromUtf8(this.year_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasCanPlayNativeMediaDuringVr() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public boolean hasConnectionConfiguration() {
        return (this.bitField0_ & 8192) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public boolean hasDisplayName() {
        return (this.bitField0_ & 2048) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public boolean hasDriverPosition() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasHeadUnitMake() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasHeadUnitModel() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasHeadUnitSoftwareBuild() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasHeadUnitSoftwareVersion() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public boolean hasHeadunitInfo() {
        return (this.bitField0_ & 16384) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasMake() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasModel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public boolean hasProbeForSupport() {
        return (this.bitField0_ & 4096) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    public boolean hasSessionConfiguration() {
        return (this.bitField0_ & 1024) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasVehicleId() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryResponseOrBuilder
    @Deprecated
    public boolean hasYear() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(ServiceDiscoveryResponse serviceDiscoveryResponse) {
        return DEFAULT_INSTANCE.createBuilder(serviceDiscoveryResponse);
    }

    public static ServiceDiscoveryResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ServiceDiscoveryResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ServiceDiscoveryResponse parseFrom(ByteString byteString) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addServices(int i, Service service) {
        service.getClass();
        ensureServicesIsMutable();
        this.services_.add(i, service);
    }

    public static ServiceDiscoveryResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionConfiguration(ConnectionConfiguration.Builder builder) {
        this.connectionConfiguration_ = builder.build();
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadunitInfo(HeadUnitInfo.Builder builder) {
        this.headunitInfo_ = builder.build();
        this.bitField0_ |= 16384;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServices(int i, Service.Builder builder) {
        ensureServicesIsMutable();
        this.services_.set(i, builder.build());
    }

    public static ServiceDiscoveryResponse parseFrom(byte[] bArr) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ServiceDiscoveryResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addServices(Service.Builder builder) {
        ensureServicesIsMutable();
        this.services_.add(builder.build());
    }

    public static ServiceDiscoveryResponse parseFrom(InputStream inputStream) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServiceDiscoveryResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addServices(int i, Service.Builder builder) {
        ensureServicesIsMutable();
        this.services_.add(i, builder.build());
    }

    public static ServiceDiscoveryResponse parseFrom(CodedInputStream codedInputStream) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ServiceDiscoveryResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
