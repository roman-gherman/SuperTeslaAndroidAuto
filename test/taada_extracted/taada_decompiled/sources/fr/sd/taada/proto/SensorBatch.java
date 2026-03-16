package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.AccelerometerData;
import fr.sd.taada.proto.CompassData;
import fr.sd.taada.proto.DeadReckoningData;
import fr.sd.taada.proto.DiagnosticsData;
import fr.sd.taada.proto.DoorData;
import fr.sd.taada.proto.DrivingStatusData;
import fr.sd.taada.proto.EnvironmentData;
import fr.sd.taada.proto.FuelData;
import fr.sd.taada.proto.GearData;
import fr.sd.taada.proto.GpsSatelliteData;
import fr.sd.taada.proto.GyroscopeData;
import fr.sd.taada.proto.HvacData;
import fr.sd.taada.proto.LightData;
import fr.sd.taada.proto.LocationData;
import fr.sd.taada.proto.NightModeData;
import fr.sd.taada.proto.OdometerData;
import fr.sd.taada.proto.ParkingBrakeData;
import fr.sd.taada.proto.PassengerData;
import fr.sd.taada.proto.RpmData;
import fr.sd.taada.proto.SpeedData;
import fr.sd.taada.proto.TirePressureData;
import fr.sd.taada.proto.TollCardData;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SensorBatch extends GeneratedMessageLite<SensorBatch, Builder> implements SensorBatchOrBuilder {
    public static final int ACCELEROMETER_DATA_FIELD_NUMBER = 19;
    public static final int COMPASS_DATA_FIELD_NUMBER = 2;
    public static final int DEAD_RECKONING_DATA_FIELD_NUMBER = 14;
    private static final SensorBatch DEFAULT_INSTANCE;
    public static final int DIAGNOSTICS_DATA_FIELD_NUMBER = 9;
    public static final int DOOR_DATA_FIELD_NUMBER = 16;
    public static final int DRIVING_STATUS_DATA_FIELD_NUMBER = 13;
    public static final int ENVIRONMENT_DATA_FIELD_NUMBER = 11;
    public static final int FUEL_DATA_FIELD_NUMBER = 6;
    public static final int GEAR_DATA_FIELD_NUMBER = 8;
    public static final int GPS_SATELLITE_DATA_FIELD_NUMBER = 21;
    public static final int GYROSCOPE_DATA_FIELD_NUMBER = 20;
    public static final int HVAC_DATA_FIELD_NUMBER = 12;
    public static final int LIGHT_DATA_FIELD_NUMBER = 17;
    public static final int LOCATION_DATA_FIELD_NUMBER = 1;
    public static final int NIGHT_MODE_DATA_FIELD_NUMBER = 10;
    public static final int ODOMETER_DATA_FIELD_NUMBER = 5;
    public static final int PARKING_BRAKE_DATA_FIELD_NUMBER = 7;
    private static volatile Parser<SensorBatch> PARSER = null;
    public static final int PASSENGER_DATA_FIELD_NUMBER = 15;
    public static final int RPM_DATA_FIELD_NUMBER = 4;
    public static final int SPEED_DATA_FIELD_NUMBER = 3;
    public static final int TIRE_PRESSURE_DATA_FIELD_NUMBER = 18;
    public static final int TOLL_CARD_DATA_FIELD_NUMBER = 22;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<LocationData> locationData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<CompassData> compassData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<SpeedData> speedData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<RpmData> rpmData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<OdometerData> odometerData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<FuelData> fuelData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<ParkingBrakeData> parkingBrakeData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GearData> gearData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<DiagnosticsData> diagnosticsData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<NightModeData> nightModeData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<EnvironmentData> environmentData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<HvacData> hvacData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<DrivingStatusData> drivingStatusData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<DeadReckoningData> deadReckoningData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<PassengerData> passengerData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<DoorData> doorData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<LightData> lightData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<TirePressureData> tirePressureData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<AccelerometerData> accelerometerData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GyroscopeData> gyroscopeData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GpsSatelliteData> gpsSatelliteData_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<TollCardData> tollCardData_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.SensorBatch$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SensorBatch, Builder> implements SensorBatchOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAccelerometerData(AccelerometerData accelerometerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAccelerometerData(accelerometerData);
            return this;
        }

        public Builder addAllAccelerometerData(Iterable<? extends AccelerometerData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllAccelerometerData(iterable);
            return this;
        }

        public Builder addAllCompassData(Iterable<? extends CompassData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllCompassData(iterable);
            return this;
        }

        public Builder addAllDeadReckoningData(Iterable<? extends DeadReckoningData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllDeadReckoningData(iterable);
            return this;
        }

        public Builder addAllDiagnosticsData(Iterable<? extends DiagnosticsData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllDiagnosticsData(iterable);
            return this;
        }

        public Builder addAllDoorData(Iterable<? extends DoorData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllDoorData(iterable);
            return this;
        }

        public Builder addAllDrivingStatusData(Iterable<? extends DrivingStatusData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllDrivingStatusData(iterable);
            return this;
        }

        public Builder addAllEnvironmentData(Iterable<? extends EnvironmentData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllEnvironmentData(iterable);
            return this;
        }

        public Builder addAllFuelData(Iterable<? extends FuelData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllFuelData(iterable);
            return this;
        }

        public Builder addAllGearData(Iterable<? extends GearData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllGearData(iterable);
            return this;
        }

        public Builder addAllGpsSatelliteData(Iterable<? extends GpsSatelliteData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllGpsSatelliteData(iterable);
            return this;
        }

        public Builder addAllGyroscopeData(Iterable<? extends GyroscopeData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllGyroscopeData(iterable);
            return this;
        }

        public Builder addAllHvacData(Iterable<? extends HvacData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllHvacData(iterable);
            return this;
        }

        public Builder addAllLightData(Iterable<? extends LightData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllLightData(iterable);
            return this;
        }

        public Builder addAllLocationData(Iterable<? extends LocationData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllLocationData(iterable);
            return this;
        }

        public Builder addAllNightModeData(Iterable<? extends NightModeData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllNightModeData(iterable);
            return this;
        }

        public Builder addAllOdometerData(Iterable<? extends OdometerData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllOdometerData(iterable);
            return this;
        }

        public Builder addAllParkingBrakeData(Iterable<? extends ParkingBrakeData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllParkingBrakeData(iterable);
            return this;
        }

        public Builder addAllPassengerData(Iterable<? extends PassengerData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllPassengerData(iterable);
            return this;
        }

        public Builder addAllRpmData(Iterable<? extends RpmData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllRpmData(iterable);
            return this;
        }

        public Builder addAllSpeedData(Iterable<? extends SpeedData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllSpeedData(iterable);
            return this;
        }

        public Builder addAllTirePressureData(Iterable<? extends TirePressureData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllTirePressureData(iterable);
            return this;
        }

        public Builder addAllTollCardData(Iterable<? extends TollCardData> iterable) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAllTollCardData(iterable);
            return this;
        }

        public Builder addCompassData(CompassData compassData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addCompassData(compassData);
            return this;
        }

        public Builder addDeadReckoningData(DeadReckoningData deadReckoningData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDeadReckoningData(deadReckoningData);
            return this;
        }

        public Builder addDiagnosticsData(DiagnosticsData diagnosticsData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDiagnosticsData(diagnosticsData);
            return this;
        }

        public Builder addDoorData(DoorData doorData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDoorData(doorData);
            return this;
        }

        public Builder addDrivingStatusData(DrivingStatusData drivingStatusData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDrivingStatusData(drivingStatusData);
            return this;
        }

        public Builder addEnvironmentData(EnvironmentData environmentData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addEnvironmentData(environmentData);
            return this;
        }

        public Builder addFuelData(FuelData fuelData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addFuelData(fuelData);
            return this;
        }

        public Builder addGearData(GearData gearData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGearData(gearData);
            return this;
        }

        public Builder addGpsSatelliteData(GpsSatelliteData gpsSatelliteData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGpsSatelliteData(gpsSatelliteData);
            return this;
        }

        public Builder addGyroscopeData(GyroscopeData gyroscopeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGyroscopeData(gyroscopeData);
            return this;
        }

        public Builder addHvacData(HvacData hvacData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addHvacData(hvacData);
            return this;
        }

        public Builder addLightData(LightData lightData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLightData(lightData);
            return this;
        }

        public Builder addLocationData(LocationData locationData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLocationData(locationData);
            return this;
        }

        public Builder addNightModeData(NightModeData nightModeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addNightModeData(nightModeData);
            return this;
        }

        public Builder addOdometerData(OdometerData odometerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addOdometerData(odometerData);
            return this;
        }

        public Builder addParkingBrakeData(ParkingBrakeData parkingBrakeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addParkingBrakeData(parkingBrakeData);
            return this;
        }

        public Builder addPassengerData(PassengerData passengerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addPassengerData(passengerData);
            return this;
        }

        public Builder addRpmData(RpmData rpmData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addRpmData(rpmData);
            return this;
        }

        public Builder addSpeedData(SpeedData speedData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addSpeedData(speedData);
            return this;
        }

        public Builder addTirePressureData(TirePressureData tirePressureData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTirePressureData(tirePressureData);
            return this;
        }

        public Builder addTollCardData(TollCardData tollCardData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTollCardData(tollCardData);
            return this;
        }

        public Builder clearAccelerometerData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearAccelerometerData();
            return this;
        }

        public Builder clearCompassData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearCompassData();
            return this;
        }

        public Builder clearDeadReckoningData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearDeadReckoningData();
            return this;
        }

        public Builder clearDiagnosticsData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearDiagnosticsData();
            return this;
        }

        public Builder clearDoorData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearDoorData();
            return this;
        }

        public Builder clearDrivingStatusData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearDrivingStatusData();
            return this;
        }

        public Builder clearEnvironmentData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearEnvironmentData();
            return this;
        }

        public Builder clearFuelData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearFuelData();
            return this;
        }

        public Builder clearGearData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearGearData();
            return this;
        }

        public Builder clearGpsSatelliteData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearGpsSatelliteData();
            return this;
        }

        public Builder clearGyroscopeData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearGyroscopeData();
            return this;
        }

        public Builder clearHvacData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearHvacData();
            return this;
        }

        public Builder clearLightData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearLightData();
            return this;
        }

        public Builder clearLocationData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearLocationData();
            return this;
        }

        public Builder clearNightModeData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearNightModeData();
            return this;
        }

        public Builder clearOdometerData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearOdometerData();
            return this;
        }

        public Builder clearParkingBrakeData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearParkingBrakeData();
            return this;
        }

        public Builder clearPassengerData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearPassengerData();
            return this;
        }

        public Builder clearRpmData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearRpmData();
            return this;
        }

        public Builder clearSpeedData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearSpeedData();
            return this;
        }

        public Builder clearTirePressureData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearTirePressureData();
            return this;
        }

        public Builder clearTollCardData() {
            copyOnWrite();
            ((SensorBatch) this.instance).clearTollCardData();
            return this;
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public AccelerometerData getAccelerometerData(int i) {
            return ((SensorBatch) this.instance).getAccelerometerData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getAccelerometerDataCount() {
            return ((SensorBatch) this.instance).getAccelerometerDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<AccelerometerData> getAccelerometerDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getAccelerometerDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public CompassData getCompassData(int i) {
            return ((SensorBatch) this.instance).getCompassData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getCompassDataCount() {
            return ((SensorBatch) this.instance).getCompassDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<CompassData> getCompassDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getCompassDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public DeadReckoningData getDeadReckoningData(int i) {
            return ((SensorBatch) this.instance).getDeadReckoningData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getDeadReckoningDataCount() {
            return ((SensorBatch) this.instance).getDeadReckoningDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<DeadReckoningData> getDeadReckoningDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getDeadReckoningDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public DiagnosticsData getDiagnosticsData(int i) {
            return ((SensorBatch) this.instance).getDiagnosticsData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getDiagnosticsDataCount() {
            return ((SensorBatch) this.instance).getDiagnosticsDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<DiagnosticsData> getDiagnosticsDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getDiagnosticsDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public DoorData getDoorData(int i) {
            return ((SensorBatch) this.instance).getDoorData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getDoorDataCount() {
            return ((SensorBatch) this.instance).getDoorDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<DoorData> getDoorDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getDoorDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public DrivingStatusData getDrivingStatusData(int i) {
            return ((SensorBatch) this.instance).getDrivingStatusData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getDrivingStatusDataCount() {
            return ((SensorBatch) this.instance).getDrivingStatusDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<DrivingStatusData> getDrivingStatusDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getDrivingStatusDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public EnvironmentData getEnvironmentData(int i) {
            return ((SensorBatch) this.instance).getEnvironmentData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getEnvironmentDataCount() {
            return ((SensorBatch) this.instance).getEnvironmentDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<EnvironmentData> getEnvironmentDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getEnvironmentDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public FuelData getFuelData(int i) {
            return ((SensorBatch) this.instance).getFuelData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getFuelDataCount() {
            return ((SensorBatch) this.instance).getFuelDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<FuelData> getFuelDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getFuelDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public GearData getGearData(int i) {
            return ((SensorBatch) this.instance).getGearData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getGearDataCount() {
            return ((SensorBatch) this.instance).getGearDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<GearData> getGearDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getGearDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public GpsSatelliteData getGpsSatelliteData(int i) {
            return ((SensorBatch) this.instance).getGpsSatelliteData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getGpsSatelliteDataCount() {
            return ((SensorBatch) this.instance).getGpsSatelliteDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<GpsSatelliteData> getGpsSatelliteDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getGpsSatelliteDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public GyroscopeData getGyroscopeData(int i) {
            return ((SensorBatch) this.instance).getGyroscopeData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getGyroscopeDataCount() {
            return ((SensorBatch) this.instance).getGyroscopeDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<GyroscopeData> getGyroscopeDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getGyroscopeDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public HvacData getHvacData(int i) {
            return ((SensorBatch) this.instance).getHvacData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getHvacDataCount() {
            return ((SensorBatch) this.instance).getHvacDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<HvacData> getHvacDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getHvacDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public LightData getLightData(int i) {
            return ((SensorBatch) this.instance).getLightData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getLightDataCount() {
            return ((SensorBatch) this.instance).getLightDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<LightData> getLightDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getLightDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public LocationData getLocationData(int i) {
            return ((SensorBatch) this.instance).getLocationData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getLocationDataCount() {
            return ((SensorBatch) this.instance).getLocationDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<LocationData> getLocationDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getLocationDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public NightModeData getNightModeData(int i) {
            return ((SensorBatch) this.instance).getNightModeData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getNightModeDataCount() {
            return ((SensorBatch) this.instance).getNightModeDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<NightModeData> getNightModeDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getNightModeDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public OdometerData getOdometerData(int i) {
            return ((SensorBatch) this.instance).getOdometerData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getOdometerDataCount() {
            return ((SensorBatch) this.instance).getOdometerDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<OdometerData> getOdometerDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getOdometerDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public ParkingBrakeData getParkingBrakeData(int i) {
            return ((SensorBatch) this.instance).getParkingBrakeData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getParkingBrakeDataCount() {
            return ((SensorBatch) this.instance).getParkingBrakeDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<ParkingBrakeData> getParkingBrakeDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getParkingBrakeDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public PassengerData getPassengerData(int i) {
            return ((SensorBatch) this.instance).getPassengerData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getPassengerDataCount() {
            return ((SensorBatch) this.instance).getPassengerDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<PassengerData> getPassengerDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getPassengerDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public RpmData getRpmData(int i) {
            return ((SensorBatch) this.instance).getRpmData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getRpmDataCount() {
            return ((SensorBatch) this.instance).getRpmDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<RpmData> getRpmDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getRpmDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public SpeedData getSpeedData(int i) {
            return ((SensorBatch) this.instance).getSpeedData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getSpeedDataCount() {
            return ((SensorBatch) this.instance).getSpeedDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<SpeedData> getSpeedDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getSpeedDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public TirePressureData getTirePressureData(int i) {
            return ((SensorBatch) this.instance).getTirePressureData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getTirePressureDataCount() {
            return ((SensorBatch) this.instance).getTirePressureDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<TirePressureData> getTirePressureDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getTirePressureDataList());
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public TollCardData getTollCardData(int i) {
            return ((SensorBatch) this.instance).getTollCardData(i);
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public int getTollCardDataCount() {
            return ((SensorBatch) this.instance).getTollCardDataCount();
        }

        @Override // fr.sd.taada.proto.SensorBatchOrBuilder
        public List<TollCardData> getTollCardDataList() {
            return Collections.unmodifiableList(((SensorBatch) this.instance).getTollCardDataList());
        }

        public Builder removeAccelerometerData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeAccelerometerData(i);
            return this;
        }

        public Builder removeCompassData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeCompassData(i);
            return this;
        }

        public Builder removeDeadReckoningData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeDeadReckoningData(i);
            return this;
        }

        public Builder removeDiagnosticsData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeDiagnosticsData(i);
            return this;
        }

        public Builder removeDoorData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeDoorData(i);
            return this;
        }

        public Builder removeDrivingStatusData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeDrivingStatusData(i);
            return this;
        }

        public Builder removeEnvironmentData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeEnvironmentData(i);
            return this;
        }

        public Builder removeFuelData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeFuelData(i);
            return this;
        }

        public Builder removeGearData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeGearData(i);
            return this;
        }

        public Builder removeGpsSatelliteData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeGpsSatelliteData(i);
            return this;
        }

        public Builder removeGyroscopeData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeGyroscopeData(i);
            return this;
        }

        public Builder removeHvacData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeHvacData(i);
            return this;
        }

        public Builder removeLightData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeLightData(i);
            return this;
        }

        public Builder removeLocationData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeLocationData(i);
            return this;
        }

        public Builder removeNightModeData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeNightModeData(i);
            return this;
        }

        public Builder removeOdometerData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeOdometerData(i);
            return this;
        }

        public Builder removeParkingBrakeData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeParkingBrakeData(i);
            return this;
        }

        public Builder removePassengerData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removePassengerData(i);
            return this;
        }

        public Builder removeRpmData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeRpmData(i);
            return this;
        }

        public Builder removeSpeedData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeSpeedData(i);
            return this;
        }

        public Builder removeTirePressureData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeTirePressureData(i);
            return this;
        }

        public Builder removeTollCardData(int i) {
            copyOnWrite();
            ((SensorBatch) this.instance).removeTollCardData(i);
            return this;
        }

        public Builder setAccelerometerData(int i, AccelerometerData accelerometerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setAccelerometerData(i, accelerometerData);
            return this;
        }

        public Builder setCompassData(int i, CompassData compassData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setCompassData(i, compassData);
            return this;
        }

        public Builder setDeadReckoningData(int i, DeadReckoningData deadReckoningData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDeadReckoningData(i, deadReckoningData);
            return this;
        }

        public Builder setDiagnosticsData(int i, DiagnosticsData diagnosticsData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDiagnosticsData(i, diagnosticsData);
            return this;
        }

        public Builder setDoorData(int i, DoorData doorData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDoorData(i, doorData);
            return this;
        }

        public Builder setDrivingStatusData(int i, DrivingStatusData drivingStatusData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDrivingStatusData(i, drivingStatusData);
            return this;
        }

        public Builder setEnvironmentData(int i, EnvironmentData environmentData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setEnvironmentData(i, environmentData);
            return this;
        }

        public Builder setFuelData(int i, FuelData fuelData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setFuelData(i, fuelData);
            return this;
        }

        public Builder setGearData(int i, GearData gearData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setGearData(i, gearData);
            return this;
        }

        public Builder setGpsSatelliteData(int i, GpsSatelliteData gpsSatelliteData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setGpsSatelliteData(i, gpsSatelliteData);
            return this;
        }

        public Builder setGyroscopeData(int i, GyroscopeData gyroscopeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setGyroscopeData(i, gyroscopeData);
            return this;
        }

        public Builder setHvacData(int i, HvacData hvacData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setHvacData(i, hvacData);
            return this;
        }

        public Builder setLightData(int i, LightData lightData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setLightData(i, lightData);
            return this;
        }

        public Builder setLocationData(int i, LocationData locationData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setLocationData(i, locationData);
            return this;
        }

        public Builder setNightModeData(int i, NightModeData nightModeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setNightModeData(i, nightModeData);
            return this;
        }

        public Builder setOdometerData(int i, OdometerData odometerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setOdometerData(i, odometerData);
            return this;
        }

        public Builder setParkingBrakeData(int i, ParkingBrakeData parkingBrakeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setParkingBrakeData(i, parkingBrakeData);
            return this;
        }

        public Builder setPassengerData(int i, PassengerData passengerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setPassengerData(i, passengerData);
            return this;
        }

        public Builder setRpmData(int i, RpmData rpmData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setRpmData(i, rpmData);
            return this;
        }

        public Builder setSpeedData(int i, SpeedData speedData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setSpeedData(i, speedData);
            return this;
        }

        public Builder setTirePressureData(int i, TirePressureData tirePressureData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setTirePressureData(i, tirePressureData);
            return this;
        }

        public Builder setTollCardData(int i, TollCardData tollCardData) {
            copyOnWrite();
            ((SensorBatch) this.instance).setTollCardData(i, tollCardData);
            return this;
        }

        private Builder() {
            super(SensorBatch.DEFAULT_INSTANCE);
        }

        public Builder addAccelerometerData(int i, AccelerometerData accelerometerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAccelerometerData(i, accelerometerData);
            return this;
        }

        public Builder addCompassData(int i, CompassData compassData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addCompassData(i, compassData);
            return this;
        }

        public Builder addDeadReckoningData(int i, DeadReckoningData deadReckoningData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDeadReckoningData(i, deadReckoningData);
            return this;
        }

        public Builder addDiagnosticsData(int i, DiagnosticsData diagnosticsData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDiagnosticsData(i, diagnosticsData);
            return this;
        }

        public Builder addDoorData(int i, DoorData doorData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDoorData(i, doorData);
            return this;
        }

        public Builder addDrivingStatusData(int i, DrivingStatusData drivingStatusData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDrivingStatusData(i, drivingStatusData);
            return this;
        }

        public Builder addEnvironmentData(int i, EnvironmentData environmentData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addEnvironmentData(i, environmentData);
            return this;
        }

        public Builder addFuelData(int i, FuelData fuelData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addFuelData(i, fuelData);
            return this;
        }

        public Builder addGearData(int i, GearData gearData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGearData(i, gearData);
            return this;
        }

        public Builder addGpsSatelliteData(int i, GpsSatelliteData gpsSatelliteData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGpsSatelliteData(i, gpsSatelliteData);
            return this;
        }

        public Builder addGyroscopeData(int i, GyroscopeData gyroscopeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGyroscopeData(i, gyroscopeData);
            return this;
        }

        public Builder addHvacData(int i, HvacData hvacData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addHvacData(i, hvacData);
            return this;
        }

        public Builder addLightData(int i, LightData lightData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLightData(i, lightData);
            return this;
        }

        public Builder addLocationData(int i, LocationData locationData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLocationData(i, locationData);
            return this;
        }

        public Builder addNightModeData(int i, NightModeData nightModeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addNightModeData(i, nightModeData);
            return this;
        }

        public Builder addOdometerData(int i, OdometerData odometerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addOdometerData(i, odometerData);
            return this;
        }

        public Builder addParkingBrakeData(int i, ParkingBrakeData parkingBrakeData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addParkingBrakeData(i, parkingBrakeData);
            return this;
        }

        public Builder addPassengerData(int i, PassengerData passengerData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addPassengerData(i, passengerData);
            return this;
        }

        public Builder addRpmData(int i, RpmData rpmData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addRpmData(i, rpmData);
            return this;
        }

        public Builder addSpeedData(int i, SpeedData speedData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addSpeedData(i, speedData);
            return this;
        }

        public Builder addTirePressureData(int i, TirePressureData tirePressureData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTirePressureData(i, tirePressureData);
            return this;
        }

        public Builder addTollCardData(int i, TollCardData tollCardData) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTollCardData(i, tollCardData);
            return this;
        }

        public Builder setAccelerometerData(int i, AccelerometerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setAccelerometerData(i, builder);
            return this;
        }

        public Builder setCompassData(int i, CompassData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setCompassData(i, builder);
            return this;
        }

        public Builder setDeadReckoningData(int i, DeadReckoningData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDeadReckoningData(i, builder);
            return this;
        }

        public Builder setDiagnosticsData(int i, DiagnosticsData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDiagnosticsData(i, builder);
            return this;
        }

        public Builder setDoorData(int i, DoorData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDoorData(i, builder);
            return this;
        }

        public Builder setDrivingStatusData(int i, DrivingStatusData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setDrivingStatusData(i, builder);
            return this;
        }

        public Builder setEnvironmentData(int i, EnvironmentData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setEnvironmentData(i, builder);
            return this;
        }

        public Builder setFuelData(int i, FuelData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setFuelData(i, builder);
            return this;
        }

        public Builder setGearData(int i, GearData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setGearData(i, builder);
            return this;
        }

        public Builder setGpsSatelliteData(int i, GpsSatelliteData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setGpsSatelliteData(i, builder);
            return this;
        }

        public Builder setGyroscopeData(int i, GyroscopeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setGyroscopeData(i, builder);
            return this;
        }

        public Builder setHvacData(int i, HvacData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setHvacData(i, builder);
            return this;
        }

        public Builder setLightData(int i, LightData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setLightData(i, builder);
            return this;
        }

        public Builder setLocationData(int i, LocationData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setLocationData(i, builder);
            return this;
        }

        public Builder setNightModeData(int i, NightModeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setNightModeData(i, builder);
            return this;
        }

        public Builder setOdometerData(int i, OdometerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setOdometerData(i, builder);
            return this;
        }

        public Builder setParkingBrakeData(int i, ParkingBrakeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setParkingBrakeData(i, builder);
            return this;
        }

        public Builder setPassengerData(int i, PassengerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setPassengerData(i, builder);
            return this;
        }

        public Builder setRpmData(int i, RpmData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setRpmData(i, builder);
            return this;
        }

        public Builder setSpeedData(int i, SpeedData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setSpeedData(i, builder);
            return this;
        }

        public Builder setTirePressureData(int i, TirePressureData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setTirePressureData(i, builder);
            return this;
        }

        public Builder setTollCardData(int i, TollCardData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).setTollCardData(i, builder);
            return this;
        }

        public Builder addAccelerometerData(AccelerometerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAccelerometerData(builder);
            return this;
        }

        public Builder addCompassData(CompassData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addCompassData(builder);
            return this;
        }

        public Builder addDeadReckoningData(DeadReckoningData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDeadReckoningData(builder);
            return this;
        }

        public Builder addDiagnosticsData(DiagnosticsData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDiagnosticsData(builder);
            return this;
        }

        public Builder addDoorData(DoorData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDoorData(builder);
            return this;
        }

        public Builder addDrivingStatusData(DrivingStatusData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDrivingStatusData(builder);
            return this;
        }

        public Builder addEnvironmentData(EnvironmentData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addEnvironmentData(builder);
            return this;
        }

        public Builder addFuelData(FuelData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addFuelData(builder);
            return this;
        }

        public Builder addGearData(GearData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGearData(builder);
            return this;
        }

        public Builder addGpsSatelliteData(GpsSatelliteData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGpsSatelliteData(builder);
            return this;
        }

        public Builder addGyroscopeData(GyroscopeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGyroscopeData(builder);
            return this;
        }

        public Builder addHvacData(HvacData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addHvacData(builder);
            return this;
        }

        public Builder addLightData(LightData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLightData(builder);
            return this;
        }

        public Builder addLocationData(LocationData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLocationData(builder);
            return this;
        }

        public Builder addNightModeData(NightModeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addNightModeData(builder);
            return this;
        }

        public Builder addOdometerData(OdometerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addOdometerData(builder);
            return this;
        }

        public Builder addParkingBrakeData(ParkingBrakeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addParkingBrakeData(builder);
            return this;
        }

        public Builder addPassengerData(PassengerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addPassengerData(builder);
            return this;
        }

        public Builder addRpmData(RpmData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addRpmData(builder);
            return this;
        }

        public Builder addSpeedData(SpeedData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addSpeedData(builder);
            return this;
        }

        public Builder addTirePressureData(TirePressureData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTirePressureData(builder);
            return this;
        }

        public Builder addTollCardData(TollCardData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTollCardData(builder);
            return this;
        }

        public Builder addAccelerometerData(int i, AccelerometerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addAccelerometerData(i, builder);
            return this;
        }

        public Builder addCompassData(int i, CompassData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addCompassData(i, builder);
            return this;
        }

        public Builder addDeadReckoningData(int i, DeadReckoningData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDeadReckoningData(i, builder);
            return this;
        }

        public Builder addDiagnosticsData(int i, DiagnosticsData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDiagnosticsData(i, builder);
            return this;
        }

        public Builder addDoorData(int i, DoorData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDoorData(i, builder);
            return this;
        }

        public Builder addDrivingStatusData(int i, DrivingStatusData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addDrivingStatusData(i, builder);
            return this;
        }

        public Builder addEnvironmentData(int i, EnvironmentData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addEnvironmentData(i, builder);
            return this;
        }

        public Builder addFuelData(int i, FuelData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addFuelData(i, builder);
            return this;
        }

        public Builder addGearData(int i, GearData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGearData(i, builder);
            return this;
        }

        public Builder addGpsSatelliteData(int i, GpsSatelliteData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGpsSatelliteData(i, builder);
            return this;
        }

        public Builder addGyroscopeData(int i, GyroscopeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addGyroscopeData(i, builder);
            return this;
        }

        public Builder addHvacData(int i, HvacData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addHvacData(i, builder);
            return this;
        }

        public Builder addLightData(int i, LightData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLightData(i, builder);
            return this;
        }

        public Builder addLocationData(int i, LocationData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addLocationData(i, builder);
            return this;
        }

        public Builder addNightModeData(int i, NightModeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addNightModeData(i, builder);
            return this;
        }

        public Builder addOdometerData(int i, OdometerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addOdometerData(i, builder);
            return this;
        }

        public Builder addParkingBrakeData(int i, ParkingBrakeData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addParkingBrakeData(i, builder);
            return this;
        }

        public Builder addPassengerData(int i, PassengerData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addPassengerData(i, builder);
            return this;
        }

        public Builder addRpmData(int i, RpmData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addRpmData(i, builder);
            return this;
        }

        public Builder addSpeedData(int i, SpeedData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addSpeedData(i, builder);
            return this;
        }

        public Builder addTirePressureData(int i, TirePressureData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTirePressureData(i, builder);
            return this;
        }

        public Builder addTollCardData(int i, TollCardData.Builder builder) {
            copyOnWrite();
            ((SensorBatch) this.instance).addTollCardData(i, builder);
            return this;
        }
    }

    static {
        SensorBatch sensorBatch = new SensorBatch();
        DEFAULT_INSTANCE = sensorBatch;
        GeneratedMessageLite.registerDefaultInstance(SensorBatch.class, sensorBatch);
    }

    private SensorBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAccelerometerData(AccelerometerData accelerometerData) {
        accelerometerData.getClass();
        ensureAccelerometerDataIsMutable();
        this.accelerometerData_.add(accelerometerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAccelerometerData(Iterable<? extends AccelerometerData> iterable) {
        ensureAccelerometerDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.accelerometerData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCompassData(Iterable<? extends CompassData> iterable) {
        ensureCompassDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.compassData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDeadReckoningData(Iterable<? extends DeadReckoningData> iterable) {
        ensureDeadReckoningDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.deadReckoningData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDiagnosticsData(Iterable<? extends DiagnosticsData> iterable) {
        ensureDiagnosticsDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.diagnosticsData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDoorData(Iterable<? extends DoorData> iterable) {
        ensureDoorDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.doorData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDrivingStatusData(Iterable<? extends DrivingStatusData> iterable) {
        ensureDrivingStatusDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.drivingStatusData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnvironmentData(Iterable<? extends EnvironmentData> iterable) {
        ensureEnvironmentDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.environmentData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFuelData(Iterable<? extends FuelData> iterable) {
        ensureFuelDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.fuelData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllGearData(Iterable<? extends GearData> iterable) {
        ensureGearDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.gearData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllGpsSatelliteData(Iterable<? extends GpsSatelliteData> iterable) {
        ensureGpsSatelliteDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.gpsSatelliteData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllGyroscopeData(Iterable<? extends GyroscopeData> iterable) {
        ensureGyroscopeDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.gyroscopeData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllHvacData(Iterable<? extends HvacData> iterable) {
        ensureHvacDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.hvacData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLightData(Iterable<? extends LightData> iterable) {
        ensureLightDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.lightData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLocationData(Iterable<? extends LocationData> iterable) {
        ensureLocationDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.locationData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllNightModeData(Iterable<? extends NightModeData> iterable) {
        ensureNightModeDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.nightModeData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOdometerData(Iterable<? extends OdometerData> iterable) {
        ensureOdometerDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.odometerData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParkingBrakeData(Iterable<? extends ParkingBrakeData> iterable) {
        ensureParkingBrakeDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.parkingBrakeData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPassengerData(Iterable<? extends PassengerData> iterable) {
        ensurePassengerDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.passengerData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRpmData(Iterable<? extends RpmData> iterable) {
        ensureRpmDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.rpmData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSpeedData(Iterable<? extends SpeedData> iterable) {
        ensureSpeedDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.speedData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTirePressureData(Iterable<? extends TirePressureData> iterable) {
        ensureTirePressureDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.tirePressureData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTollCardData(Iterable<? extends TollCardData> iterable) {
        ensureTollCardDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.tollCardData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCompassData(CompassData compassData) {
        compassData.getClass();
        ensureCompassDataIsMutable();
        this.compassData_.add(compassData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDeadReckoningData(DeadReckoningData deadReckoningData) {
        deadReckoningData.getClass();
        ensureDeadReckoningDataIsMutable();
        this.deadReckoningData_.add(deadReckoningData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDiagnosticsData(DiagnosticsData diagnosticsData) {
        diagnosticsData.getClass();
        ensureDiagnosticsDataIsMutable();
        this.diagnosticsData_.add(diagnosticsData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDoorData(DoorData doorData) {
        doorData.getClass();
        ensureDoorDataIsMutable();
        this.doorData_.add(doorData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDrivingStatusData(DrivingStatusData drivingStatusData) {
        drivingStatusData.getClass();
        ensureDrivingStatusDataIsMutable();
        this.drivingStatusData_.add(drivingStatusData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnvironmentData(EnvironmentData environmentData) {
        environmentData.getClass();
        ensureEnvironmentDataIsMutable();
        this.environmentData_.add(environmentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFuelData(FuelData fuelData) {
        fuelData.getClass();
        ensureFuelDataIsMutable();
        this.fuelData_.add(fuelData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGearData(GearData gearData) {
        gearData.getClass();
        ensureGearDataIsMutable();
        this.gearData_.add(gearData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGpsSatelliteData(GpsSatelliteData gpsSatelliteData) {
        gpsSatelliteData.getClass();
        ensureGpsSatelliteDataIsMutable();
        this.gpsSatelliteData_.add(gpsSatelliteData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGyroscopeData(GyroscopeData gyroscopeData) {
        gyroscopeData.getClass();
        ensureGyroscopeDataIsMutable();
        this.gyroscopeData_.add(gyroscopeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHvacData(HvacData hvacData) {
        hvacData.getClass();
        ensureHvacDataIsMutable();
        this.hvacData_.add(hvacData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLightData(LightData lightData) {
        lightData.getClass();
        ensureLightDataIsMutable();
        this.lightData_.add(lightData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocationData(LocationData locationData) {
        locationData.getClass();
        ensureLocationDataIsMutable();
        this.locationData_.add(locationData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNightModeData(NightModeData nightModeData) {
        nightModeData.getClass();
        ensureNightModeDataIsMutable();
        this.nightModeData_.add(nightModeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOdometerData(OdometerData odometerData) {
        odometerData.getClass();
        ensureOdometerDataIsMutable();
        this.odometerData_.add(odometerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParkingBrakeData(ParkingBrakeData parkingBrakeData) {
        parkingBrakeData.getClass();
        ensureParkingBrakeDataIsMutable();
        this.parkingBrakeData_.add(parkingBrakeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPassengerData(PassengerData passengerData) {
        passengerData.getClass();
        ensurePassengerDataIsMutable();
        this.passengerData_.add(passengerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRpmData(RpmData rpmData) {
        rpmData.getClass();
        ensureRpmDataIsMutable();
        this.rpmData_.add(rpmData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSpeedData(SpeedData speedData) {
        speedData.getClass();
        ensureSpeedDataIsMutable();
        this.speedData_.add(speedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTirePressureData(TirePressureData tirePressureData) {
        tirePressureData.getClass();
        ensureTirePressureDataIsMutable();
        this.tirePressureData_.add(tirePressureData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTollCardData(TollCardData tollCardData) {
        tollCardData.getClass();
        ensureTollCardDataIsMutable();
        this.tollCardData_.add(tollCardData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccelerometerData() {
        this.accelerometerData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCompassData() {
        this.compassData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeadReckoningData() {
        this.deadReckoningData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDiagnosticsData() {
        this.diagnosticsData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDoorData() {
        this.doorData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDrivingStatusData() {
        this.drivingStatusData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnvironmentData() {
        this.environmentData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFuelData() {
        this.fuelData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGearData() {
        this.gearData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGpsSatelliteData() {
        this.gpsSatelliteData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGyroscopeData() {
        this.gyroscopeData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHvacData() {
        this.hvacData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLightData() {
        this.lightData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocationData() {
        this.locationData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNightModeData() {
        this.nightModeData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOdometerData() {
        this.odometerData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParkingBrakeData() {
        this.parkingBrakeData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPassengerData() {
        this.passengerData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRpmData() {
        this.rpmData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpeedData() {
        this.speedData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTirePressureData() {
        this.tirePressureData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTollCardData() {
        this.tollCardData_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAccelerometerDataIsMutable() {
        if (this.accelerometerData_.isModifiable()) {
            return;
        }
        this.accelerometerData_ = GeneratedMessageLite.mutableCopy(this.accelerometerData_);
    }

    private void ensureCompassDataIsMutable() {
        if (this.compassData_.isModifiable()) {
            return;
        }
        this.compassData_ = GeneratedMessageLite.mutableCopy(this.compassData_);
    }

    private void ensureDeadReckoningDataIsMutable() {
        if (this.deadReckoningData_.isModifiable()) {
            return;
        }
        this.deadReckoningData_ = GeneratedMessageLite.mutableCopy(this.deadReckoningData_);
    }

    private void ensureDiagnosticsDataIsMutable() {
        if (this.diagnosticsData_.isModifiable()) {
            return;
        }
        this.diagnosticsData_ = GeneratedMessageLite.mutableCopy(this.diagnosticsData_);
    }

    private void ensureDoorDataIsMutable() {
        if (this.doorData_.isModifiable()) {
            return;
        }
        this.doorData_ = GeneratedMessageLite.mutableCopy(this.doorData_);
    }

    private void ensureDrivingStatusDataIsMutable() {
        if (this.drivingStatusData_.isModifiable()) {
            return;
        }
        this.drivingStatusData_ = GeneratedMessageLite.mutableCopy(this.drivingStatusData_);
    }

    private void ensureEnvironmentDataIsMutable() {
        if (this.environmentData_.isModifiable()) {
            return;
        }
        this.environmentData_ = GeneratedMessageLite.mutableCopy(this.environmentData_);
    }

    private void ensureFuelDataIsMutable() {
        if (this.fuelData_.isModifiable()) {
            return;
        }
        this.fuelData_ = GeneratedMessageLite.mutableCopy(this.fuelData_);
    }

    private void ensureGearDataIsMutable() {
        if (this.gearData_.isModifiable()) {
            return;
        }
        this.gearData_ = GeneratedMessageLite.mutableCopy(this.gearData_);
    }

    private void ensureGpsSatelliteDataIsMutable() {
        if (this.gpsSatelliteData_.isModifiable()) {
            return;
        }
        this.gpsSatelliteData_ = GeneratedMessageLite.mutableCopy(this.gpsSatelliteData_);
    }

    private void ensureGyroscopeDataIsMutable() {
        if (this.gyroscopeData_.isModifiable()) {
            return;
        }
        this.gyroscopeData_ = GeneratedMessageLite.mutableCopy(this.gyroscopeData_);
    }

    private void ensureHvacDataIsMutable() {
        if (this.hvacData_.isModifiable()) {
            return;
        }
        this.hvacData_ = GeneratedMessageLite.mutableCopy(this.hvacData_);
    }

    private void ensureLightDataIsMutable() {
        if (this.lightData_.isModifiable()) {
            return;
        }
        this.lightData_ = GeneratedMessageLite.mutableCopy(this.lightData_);
    }

    private void ensureLocationDataIsMutable() {
        if (this.locationData_.isModifiable()) {
            return;
        }
        this.locationData_ = GeneratedMessageLite.mutableCopy(this.locationData_);
    }

    private void ensureNightModeDataIsMutable() {
        if (this.nightModeData_.isModifiable()) {
            return;
        }
        this.nightModeData_ = GeneratedMessageLite.mutableCopy(this.nightModeData_);
    }

    private void ensureOdometerDataIsMutable() {
        if (this.odometerData_.isModifiable()) {
            return;
        }
        this.odometerData_ = GeneratedMessageLite.mutableCopy(this.odometerData_);
    }

    private void ensureParkingBrakeDataIsMutable() {
        if (this.parkingBrakeData_.isModifiable()) {
            return;
        }
        this.parkingBrakeData_ = GeneratedMessageLite.mutableCopy(this.parkingBrakeData_);
    }

    private void ensurePassengerDataIsMutable() {
        if (this.passengerData_.isModifiable()) {
            return;
        }
        this.passengerData_ = GeneratedMessageLite.mutableCopy(this.passengerData_);
    }

    private void ensureRpmDataIsMutable() {
        if (this.rpmData_.isModifiable()) {
            return;
        }
        this.rpmData_ = GeneratedMessageLite.mutableCopy(this.rpmData_);
    }

    private void ensureSpeedDataIsMutable() {
        if (this.speedData_.isModifiable()) {
            return;
        }
        this.speedData_ = GeneratedMessageLite.mutableCopy(this.speedData_);
    }

    private void ensureTirePressureDataIsMutable() {
        if (this.tirePressureData_.isModifiable()) {
            return;
        }
        this.tirePressureData_ = GeneratedMessageLite.mutableCopy(this.tirePressureData_);
    }

    private void ensureTollCardDataIsMutable() {
        if (this.tollCardData_.isModifiable()) {
            return;
        }
        this.tollCardData_ = GeneratedMessageLite.mutableCopy(this.tollCardData_);
    }

    public static SensorBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SensorBatch parseDelimitedFrom(InputStream inputStream) {
        return (SensorBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorBatch parseFrom(ByteBuffer byteBuffer) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SensorBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAccelerometerData(int i) {
        ensureAccelerometerDataIsMutable();
        this.accelerometerData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCompassData(int i) {
        ensureCompassDataIsMutable();
        this.compassData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDeadReckoningData(int i) {
        ensureDeadReckoningDataIsMutable();
        this.deadReckoningData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDiagnosticsData(int i) {
        ensureDiagnosticsDataIsMutable();
        this.diagnosticsData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDoorData(int i) {
        ensureDoorDataIsMutable();
        this.doorData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDrivingStatusData(int i) {
        ensureDrivingStatusDataIsMutable();
        this.drivingStatusData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEnvironmentData(int i) {
        ensureEnvironmentDataIsMutable();
        this.environmentData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFuelData(int i) {
        ensureFuelDataIsMutable();
        this.fuelData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGearData(int i) {
        ensureGearDataIsMutable();
        this.gearData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGpsSatelliteData(int i) {
        ensureGpsSatelliteDataIsMutable();
        this.gpsSatelliteData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGyroscopeData(int i) {
        ensureGyroscopeDataIsMutable();
        this.gyroscopeData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeHvacData(int i) {
        ensureHvacDataIsMutable();
        this.hvacData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLightData(int i) {
        ensureLightDataIsMutable();
        this.lightData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLocationData(int i) {
        ensureLocationDataIsMutable();
        this.locationData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNightModeData(int i) {
        ensureNightModeDataIsMutable();
        this.nightModeData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOdometerData(int i) {
        ensureOdometerDataIsMutable();
        this.odometerData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParkingBrakeData(int i) {
        ensureParkingBrakeDataIsMutable();
        this.parkingBrakeData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePassengerData(int i) {
        ensurePassengerDataIsMutable();
        this.passengerData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRpmData(int i) {
        ensureRpmDataIsMutable();
        this.rpmData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSpeedData(int i) {
        ensureSpeedDataIsMutable();
        this.speedData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTirePressureData(int i) {
        ensureTirePressureDataIsMutable();
        this.tirePressureData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTollCardData(int i) {
        ensureTollCardDataIsMutable();
        this.tollCardData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccelerometerData(int i, AccelerometerData accelerometerData) {
        accelerometerData.getClass();
        ensureAccelerometerDataIsMutable();
        this.accelerometerData_.set(i, accelerometerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompassData(int i, CompassData compassData) {
        compassData.getClass();
        ensureCompassDataIsMutable();
        this.compassData_.set(i, compassData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeadReckoningData(int i, DeadReckoningData deadReckoningData) {
        deadReckoningData.getClass();
        ensureDeadReckoningDataIsMutable();
        this.deadReckoningData_.set(i, deadReckoningData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDiagnosticsData(int i, DiagnosticsData diagnosticsData) {
        diagnosticsData.getClass();
        ensureDiagnosticsDataIsMutable();
        this.diagnosticsData_.set(i, diagnosticsData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDoorData(int i, DoorData doorData) {
        doorData.getClass();
        ensureDoorDataIsMutable();
        this.doorData_.set(i, doorData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrivingStatusData(int i, DrivingStatusData drivingStatusData) {
        drivingStatusData.getClass();
        ensureDrivingStatusDataIsMutable();
        this.drivingStatusData_.set(i, drivingStatusData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnvironmentData(int i, EnvironmentData environmentData) {
        environmentData.getClass();
        ensureEnvironmentDataIsMutable();
        this.environmentData_.set(i, environmentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFuelData(int i, FuelData fuelData) {
        fuelData.getClass();
        ensureFuelDataIsMutable();
        this.fuelData_.set(i, fuelData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGearData(int i, GearData gearData) {
        gearData.getClass();
        ensureGearDataIsMutable();
        this.gearData_.set(i, gearData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGpsSatelliteData(int i, GpsSatelliteData gpsSatelliteData) {
        gpsSatelliteData.getClass();
        ensureGpsSatelliteDataIsMutable();
        this.gpsSatelliteData_.set(i, gpsSatelliteData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGyroscopeData(int i, GyroscopeData gyroscopeData) {
        gyroscopeData.getClass();
        ensureGyroscopeDataIsMutable();
        this.gyroscopeData_.set(i, gyroscopeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHvacData(int i, HvacData hvacData) {
        hvacData.getClass();
        ensureHvacDataIsMutable();
        this.hvacData_.set(i, hvacData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLightData(int i, LightData lightData) {
        lightData.getClass();
        ensureLightDataIsMutable();
        this.lightData_.set(i, lightData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationData(int i, LocationData locationData) {
        locationData.getClass();
        ensureLocationDataIsMutable();
        this.locationData_.set(i, locationData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNightModeData(int i, NightModeData nightModeData) {
        nightModeData.getClass();
        ensureNightModeDataIsMutable();
        this.nightModeData_.set(i, nightModeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOdometerData(int i, OdometerData odometerData) {
        odometerData.getClass();
        ensureOdometerDataIsMutable();
        this.odometerData_.set(i, odometerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParkingBrakeData(int i, ParkingBrakeData parkingBrakeData) {
        parkingBrakeData.getClass();
        ensureParkingBrakeDataIsMutable();
        this.parkingBrakeData_.set(i, parkingBrakeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPassengerData(int i, PassengerData passengerData) {
        passengerData.getClass();
        ensurePassengerDataIsMutable();
        this.passengerData_.set(i, passengerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRpmData(int i, RpmData rpmData) {
        rpmData.getClass();
        ensureRpmDataIsMutable();
        this.rpmData_.set(i, rpmData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeedData(int i, SpeedData speedData) {
        speedData.getClass();
        ensureSpeedDataIsMutable();
        this.speedData_.set(i, speedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTirePressureData(int i, TirePressureData tirePressureData) {
        tirePressureData.getClass();
        ensureTirePressureDataIsMutable();
        this.tirePressureData_.set(i, tirePressureData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTollCardData(int i, TollCardData tollCardData) {
        tollCardData.getClass();
        ensureTollCardDataIsMutable();
        this.tollCardData_.set(i, tollCardData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SensorBatch();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0016\u0000\u0000\u0001\u0016\u0016\u0000\u0016\n\u0001Л\u0002Л\u0003Л\u0004Л\u0005Л\u0006\u001b\u0007Л\bЛ\t\u001b\n\u001b\u000b\u001b\f\u001b\rЛ\u000e\u001b\u000f\u001b\u0010\u001b\u0011\u001b\u0012\u001b\u0013\u001b\u0014\u001b\u0015Л\u0016Л", new Object[]{"locationData_", LocationData.class, "compassData_", CompassData.class, "speedData_", SpeedData.class, "rpmData_", RpmData.class, "odometerData_", OdometerData.class, "fuelData_", FuelData.class, "parkingBrakeData_", ParkingBrakeData.class, "gearData_", GearData.class, "diagnosticsData_", DiagnosticsData.class, "nightModeData_", NightModeData.class, "environmentData_", EnvironmentData.class, "hvacData_", HvacData.class, "drivingStatusData_", DrivingStatusData.class, "deadReckoningData_", DeadReckoningData.class, "passengerData_", PassengerData.class, "doorData_", DoorData.class, "lightData_", LightData.class, "tirePressureData_", TirePressureData.class, "accelerometerData_", AccelerometerData.class, "gyroscopeData_", GyroscopeData.class, "gpsSatelliteData_", GpsSatelliteData.class, "tollCardData_", TollCardData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SensorBatch> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SensorBatch.class) {
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

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public AccelerometerData getAccelerometerData(int i) {
        return this.accelerometerData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getAccelerometerDataCount() {
        return this.accelerometerData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<AccelerometerData> getAccelerometerDataList() {
        return this.accelerometerData_;
    }

    public AccelerometerDataOrBuilder getAccelerometerDataOrBuilder(int i) {
        return this.accelerometerData_.get(i);
    }

    public List<? extends AccelerometerDataOrBuilder> getAccelerometerDataOrBuilderList() {
        return this.accelerometerData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public CompassData getCompassData(int i) {
        return this.compassData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getCompassDataCount() {
        return this.compassData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<CompassData> getCompassDataList() {
        return this.compassData_;
    }

    public CompassDataOrBuilder getCompassDataOrBuilder(int i) {
        return this.compassData_.get(i);
    }

    public List<? extends CompassDataOrBuilder> getCompassDataOrBuilderList() {
        return this.compassData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public DeadReckoningData getDeadReckoningData(int i) {
        return this.deadReckoningData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getDeadReckoningDataCount() {
        return this.deadReckoningData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<DeadReckoningData> getDeadReckoningDataList() {
        return this.deadReckoningData_;
    }

    public DeadReckoningDataOrBuilder getDeadReckoningDataOrBuilder(int i) {
        return this.deadReckoningData_.get(i);
    }

    public List<? extends DeadReckoningDataOrBuilder> getDeadReckoningDataOrBuilderList() {
        return this.deadReckoningData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public DiagnosticsData getDiagnosticsData(int i) {
        return this.diagnosticsData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getDiagnosticsDataCount() {
        return this.diagnosticsData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<DiagnosticsData> getDiagnosticsDataList() {
        return this.diagnosticsData_;
    }

    public DiagnosticsDataOrBuilder getDiagnosticsDataOrBuilder(int i) {
        return this.diagnosticsData_.get(i);
    }

    public List<? extends DiagnosticsDataOrBuilder> getDiagnosticsDataOrBuilderList() {
        return this.diagnosticsData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public DoorData getDoorData(int i) {
        return this.doorData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getDoorDataCount() {
        return this.doorData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<DoorData> getDoorDataList() {
        return this.doorData_;
    }

    public DoorDataOrBuilder getDoorDataOrBuilder(int i) {
        return this.doorData_.get(i);
    }

    public List<? extends DoorDataOrBuilder> getDoorDataOrBuilderList() {
        return this.doorData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public DrivingStatusData getDrivingStatusData(int i) {
        return this.drivingStatusData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getDrivingStatusDataCount() {
        return this.drivingStatusData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<DrivingStatusData> getDrivingStatusDataList() {
        return this.drivingStatusData_;
    }

    public DrivingStatusDataOrBuilder getDrivingStatusDataOrBuilder(int i) {
        return this.drivingStatusData_.get(i);
    }

    public List<? extends DrivingStatusDataOrBuilder> getDrivingStatusDataOrBuilderList() {
        return this.drivingStatusData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public EnvironmentData getEnvironmentData(int i) {
        return this.environmentData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getEnvironmentDataCount() {
        return this.environmentData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<EnvironmentData> getEnvironmentDataList() {
        return this.environmentData_;
    }

    public EnvironmentDataOrBuilder getEnvironmentDataOrBuilder(int i) {
        return this.environmentData_.get(i);
    }

    public List<? extends EnvironmentDataOrBuilder> getEnvironmentDataOrBuilderList() {
        return this.environmentData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public FuelData getFuelData(int i) {
        return this.fuelData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getFuelDataCount() {
        return this.fuelData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<FuelData> getFuelDataList() {
        return this.fuelData_;
    }

    public FuelDataOrBuilder getFuelDataOrBuilder(int i) {
        return this.fuelData_.get(i);
    }

    public List<? extends FuelDataOrBuilder> getFuelDataOrBuilderList() {
        return this.fuelData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public GearData getGearData(int i) {
        return this.gearData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getGearDataCount() {
        return this.gearData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<GearData> getGearDataList() {
        return this.gearData_;
    }

    public GearDataOrBuilder getGearDataOrBuilder(int i) {
        return this.gearData_.get(i);
    }

    public List<? extends GearDataOrBuilder> getGearDataOrBuilderList() {
        return this.gearData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public GpsSatelliteData getGpsSatelliteData(int i) {
        return this.gpsSatelliteData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getGpsSatelliteDataCount() {
        return this.gpsSatelliteData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<GpsSatelliteData> getGpsSatelliteDataList() {
        return this.gpsSatelliteData_;
    }

    public GpsSatelliteDataOrBuilder getGpsSatelliteDataOrBuilder(int i) {
        return this.gpsSatelliteData_.get(i);
    }

    public List<? extends GpsSatelliteDataOrBuilder> getGpsSatelliteDataOrBuilderList() {
        return this.gpsSatelliteData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public GyroscopeData getGyroscopeData(int i) {
        return this.gyroscopeData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getGyroscopeDataCount() {
        return this.gyroscopeData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<GyroscopeData> getGyroscopeDataList() {
        return this.gyroscopeData_;
    }

    public GyroscopeDataOrBuilder getGyroscopeDataOrBuilder(int i) {
        return this.gyroscopeData_.get(i);
    }

    public List<? extends GyroscopeDataOrBuilder> getGyroscopeDataOrBuilderList() {
        return this.gyroscopeData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public HvacData getHvacData(int i) {
        return this.hvacData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getHvacDataCount() {
        return this.hvacData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<HvacData> getHvacDataList() {
        return this.hvacData_;
    }

    public HvacDataOrBuilder getHvacDataOrBuilder(int i) {
        return this.hvacData_.get(i);
    }

    public List<? extends HvacDataOrBuilder> getHvacDataOrBuilderList() {
        return this.hvacData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public LightData getLightData(int i) {
        return this.lightData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getLightDataCount() {
        return this.lightData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<LightData> getLightDataList() {
        return this.lightData_;
    }

    public LightDataOrBuilder getLightDataOrBuilder(int i) {
        return this.lightData_.get(i);
    }

    public List<? extends LightDataOrBuilder> getLightDataOrBuilderList() {
        return this.lightData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public LocationData getLocationData(int i) {
        return this.locationData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getLocationDataCount() {
        return this.locationData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<LocationData> getLocationDataList() {
        return this.locationData_;
    }

    public LocationDataOrBuilder getLocationDataOrBuilder(int i) {
        return this.locationData_.get(i);
    }

    public List<? extends LocationDataOrBuilder> getLocationDataOrBuilderList() {
        return this.locationData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public NightModeData getNightModeData(int i) {
        return this.nightModeData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getNightModeDataCount() {
        return this.nightModeData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<NightModeData> getNightModeDataList() {
        return this.nightModeData_;
    }

    public NightModeDataOrBuilder getNightModeDataOrBuilder(int i) {
        return this.nightModeData_.get(i);
    }

    public List<? extends NightModeDataOrBuilder> getNightModeDataOrBuilderList() {
        return this.nightModeData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public OdometerData getOdometerData(int i) {
        return this.odometerData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getOdometerDataCount() {
        return this.odometerData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<OdometerData> getOdometerDataList() {
        return this.odometerData_;
    }

    public OdometerDataOrBuilder getOdometerDataOrBuilder(int i) {
        return this.odometerData_.get(i);
    }

    public List<? extends OdometerDataOrBuilder> getOdometerDataOrBuilderList() {
        return this.odometerData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public ParkingBrakeData getParkingBrakeData(int i) {
        return this.parkingBrakeData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getParkingBrakeDataCount() {
        return this.parkingBrakeData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<ParkingBrakeData> getParkingBrakeDataList() {
        return this.parkingBrakeData_;
    }

    public ParkingBrakeDataOrBuilder getParkingBrakeDataOrBuilder(int i) {
        return this.parkingBrakeData_.get(i);
    }

    public List<? extends ParkingBrakeDataOrBuilder> getParkingBrakeDataOrBuilderList() {
        return this.parkingBrakeData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public PassengerData getPassengerData(int i) {
        return this.passengerData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getPassengerDataCount() {
        return this.passengerData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<PassengerData> getPassengerDataList() {
        return this.passengerData_;
    }

    public PassengerDataOrBuilder getPassengerDataOrBuilder(int i) {
        return this.passengerData_.get(i);
    }

    public List<? extends PassengerDataOrBuilder> getPassengerDataOrBuilderList() {
        return this.passengerData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public RpmData getRpmData(int i) {
        return this.rpmData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getRpmDataCount() {
        return this.rpmData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<RpmData> getRpmDataList() {
        return this.rpmData_;
    }

    public RpmDataOrBuilder getRpmDataOrBuilder(int i) {
        return this.rpmData_.get(i);
    }

    public List<? extends RpmDataOrBuilder> getRpmDataOrBuilderList() {
        return this.rpmData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public SpeedData getSpeedData(int i) {
        return this.speedData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getSpeedDataCount() {
        return this.speedData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<SpeedData> getSpeedDataList() {
        return this.speedData_;
    }

    public SpeedDataOrBuilder getSpeedDataOrBuilder(int i) {
        return this.speedData_.get(i);
    }

    public List<? extends SpeedDataOrBuilder> getSpeedDataOrBuilderList() {
        return this.speedData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public TirePressureData getTirePressureData(int i) {
        return this.tirePressureData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getTirePressureDataCount() {
        return this.tirePressureData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<TirePressureData> getTirePressureDataList() {
        return this.tirePressureData_;
    }

    public TirePressureDataOrBuilder getTirePressureDataOrBuilder(int i) {
        return this.tirePressureData_.get(i);
    }

    public List<? extends TirePressureDataOrBuilder> getTirePressureDataOrBuilderList() {
        return this.tirePressureData_;
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public TollCardData getTollCardData(int i) {
        return this.tollCardData_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public int getTollCardDataCount() {
        return this.tollCardData_.size();
    }

    @Override // fr.sd.taada.proto.SensorBatchOrBuilder
    public List<TollCardData> getTollCardDataList() {
        return this.tollCardData_;
    }

    public TollCardDataOrBuilder getTollCardDataOrBuilder(int i) {
        return this.tollCardData_.get(i);
    }

    public List<? extends TollCardDataOrBuilder> getTollCardDataOrBuilderList() {
        return this.tollCardData_;
    }

    public static Builder newBuilder(SensorBatch sensorBatch) {
        return DEFAULT_INSTANCE.createBuilder(sensorBatch);
    }

    public static SensorBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorBatch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SensorBatch parseFrom(ByteString byteString) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAccelerometerData(int i, AccelerometerData accelerometerData) {
        accelerometerData.getClass();
        ensureAccelerometerDataIsMutable();
        this.accelerometerData_.add(i, accelerometerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCompassData(int i, CompassData compassData) {
        compassData.getClass();
        ensureCompassDataIsMutable();
        this.compassData_.add(i, compassData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDeadReckoningData(int i, DeadReckoningData deadReckoningData) {
        deadReckoningData.getClass();
        ensureDeadReckoningDataIsMutable();
        this.deadReckoningData_.add(i, deadReckoningData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDiagnosticsData(int i, DiagnosticsData diagnosticsData) {
        diagnosticsData.getClass();
        ensureDiagnosticsDataIsMutable();
        this.diagnosticsData_.add(i, diagnosticsData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDoorData(int i, DoorData doorData) {
        doorData.getClass();
        ensureDoorDataIsMutable();
        this.doorData_.add(i, doorData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDrivingStatusData(int i, DrivingStatusData drivingStatusData) {
        drivingStatusData.getClass();
        ensureDrivingStatusDataIsMutable();
        this.drivingStatusData_.add(i, drivingStatusData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnvironmentData(int i, EnvironmentData environmentData) {
        environmentData.getClass();
        ensureEnvironmentDataIsMutable();
        this.environmentData_.add(i, environmentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFuelData(int i, FuelData fuelData) {
        fuelData.getClass();
        ensureFuelDataIsMutable();
        this.fuelData_.add(i, fuelData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGearData(int i, GearData gearData) {
        gearData.getClass();
        ensureGearDataIsMutable();
        this.gearData_.add(i, gearData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGpsSatelliteData(int i, GpsSatelliteData gpsSatelliteData) {
        gpsSatelliteData.getClass();
        ensureGpsSatelliteDataIsMutable();
        this.gpsSatelliteData_.add(i, gpsSatelliteData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGyroscopeData(int i, GyroscopeData gyroscopeData) {
        gyroscopeData.getClass();
        ensureGyroscopeDataIsMutable();
        this.gyroscopeData_.add(i, gyroscopeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHvacData(int i, HvacData hvacData) {
        hvacData.getClass();
        ensureHvacDataIsMutable();
        this.hvacData_.add(i, hvacData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLightData(int i, LightData lightData) {
        lightData.getClass();
        ensureLightDataIsMutable();
        this.lightData_.add(i, lightData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocationData(int i, LocationData locationData) {
        locationData.getClass();
        ensureLocationDataIsMutable();
        this.locationData_.add(i, locationData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNightModeData(int i, NightModeData nightModeData) {
        nightModeData.getClass();
        ensureNightModeDataIsMutable();
        this.nightModeData_.add(i, nightModeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOdometerData(int i, OdometerData odometerData) {
        odometerData.getClass();
        ensureOdometerDataIsMutable();
        this.odometerData_.add(i, odometerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParkingBrakeData(int i, ParkingBrakeData parkingBrakeData) {
        parkingBrakeData.getClass();
        ensureParkingBrakeDataIsMutable();
        this.parkingBrakeData_.add(i, parkingBrakeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPassengerData(int i, PassengerData passengerData) {
        passengerData.getClass();
        ensurePassengerDataIsMutable();
        this.passengerData_.add(i, passengerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRpmData(int i, RpmData rpmData) {
        rpmData.getClass();
        ensureRpmDataIsMutable();
        this.rpmData_.add(i, rpmData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSpeedData(int i, SpeedData speedData) {
        speedData.getClass();
        ensureSpeedDataIsMutable();
        this.speedData_.add(i, speedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTirePressureData(int i, TirePressureData tirePressureData) {
        tirePressureData.getClass();
        ensureTirePressureDataIsMutable();
        this.tirePressureData_.add(i, tirePressureData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTollCardData(int i, TollCardData tollCardData) {
        tollCardData.getClass();
        ensureTollCardDataIsMutable();
        this.tollCardData_.add(i, tollCardData);
    }

    public static SensorBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccelerometerData(int i, AccelerometerData.Builder builder) {
        ensureAccelerometerDataIsMutable();
        this.accelerometerData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompassData(int i, CompassData.Builder builder) {
        ensureCompassDataIsMutable();
        this.compassData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeadReckoningData(int i, DeadReckoningData.Builder builder) {
        ensureDeadReckoningDataIsMutable();
        this.deadReckoningData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDiagnosticsData(int i, DiagnosticsData.Builder builder) {
        ensureDiagnosticsDataIsMutable();
        this.diagnosticsData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDoorData(int i, DoorData.Builder builder) {
        ensureDoorDataIsMutable();
        this.doorData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrivingStatusData(int i, DrivingStatusData.Builder builder) {
        ensureDrivingStatusDataIsMutable();
        this.drivingStatusData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnvironmentData(int i, EnvironmentData.Builder builder) {
        ensureEnvironmentDataIsMutable();
        this.environmentData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFuelData(int i, FuelData.Builder builder) {
        ensureFuelDataIsMutable();
        this.fuelData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGearData(int i, GearData.Builder builder) {
        ensureGearDataIsMutable();
        this.gearData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGpsSatelliteData(int i, GpsSatelliteData.Builder builder) {
        ensureGpsSatelliteDataIsMutable();
        this.gpsSatelliteData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGyroscopeData(int i, GyroscopeData.Builder builder) {
        ensureGyroscopeDataIsMutable();
        this.gyroscopeData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHvacData(int i, HvacData.Builder builder) {
        ensureHvacDataIsMutable();
        this.hvacData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLightData(int i, LightData.Builder builder) {
        ensureLightDataIsMutable();
        this.lightData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationData(int i, LocationData.Builder builder) {
        ensureLocationDataIsMutable();
        this.locationData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNightModeData(int i, NightModeData.Builder builder) {
        ensureNightModeDataIsMutable();
        this.nightModeData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOdometerData(int i, OdometerData.Builder builder) {
        ensureOdometerDataIsMutable();
        this.odometerData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParkingBrakeData(int i, ParkingBrakeData.Builder builder) {
        ensureParkingBrakeDataIsMutable();
        this.parkingBrakeData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPassengerData(int i, PassengerData.Builder builder) {
        ensurePassengerDataIsMutable();
        this.passengerData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRpmData(int i, RpmData.Builder builder) {
        ensureRpmDataIsMutable();
        this.rpmData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeedData(int i, SpeedData.Builder builder) {
        ensureSpeedDataIsMutable();
        this.speedData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTirePressureData(int i, TirePressureData.Builder builder) {
        ensureTirePressureDataIsMutable();
        this.tirePressureData_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTollCardData(int i, TollCardData.Builder builder) {
        ensureTollCardDataIsMutable();
        this.tollCardData_.set(i, builder.build());
    }

    public static SensorBatch parseFrom(byte[] bArr) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SensorBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAccelerometerData(AccelerometerData.Builder builder) {
        ensureAccelerometerDataIsMutable();
        this.accelerometerData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCompassData(CompassData.Builder builder) {
        ensureCompassDataIsMutable();
        this.compassData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDeadReckoningData(DeadReckoningData.Builder builder) {
        ensureDeadReckoningDataIsMutable();
        this.deadReckoningData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDiagnosticsData(DiagnosticsData.Builder builder) {
        ensureDiagnosticsDataIsMutable();
        this.diagnosticsData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDoorData(DoorData.Builder builder) {
        ensureDoorDataIsMutable();
        this.doorData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDrivingStatusData(DrivingStatusData.Builder builder) {
        ensureDrivingStatusDataIsMutable();
        this.drivingStatusData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnvironmentData(EnvironmentData.Builder builder) {
        ensureEnvironmentDataIsMutable();
        this.environmentData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFuelData(FuelData.Builder builder) {
        ensureFuelDataIsMutable();
        this.fuelData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGearData(GearData.Builder builder) {
        ensureGearDataIsMutable();
        this.gearData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGpsSatelliteData(GpsSatelliteData.Builder builder) {
        ensureGpsSatelliteDataIsMutable();
        this.gpsSatelliteData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGyroscopeData(GyroscopeData.Builder builder) {
        ensureGyroscopeDataIsMutable();
        this.gyroscopeData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHvacData(HvacData.Builder builder) {
        ensureHvacDataIsMutable();
        this.hvacData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLightData(LightData.Builder builder) {
        ensureLightDataIsMutable();
        this.lightData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocationData(LocationData.Builder builder) {
        ensureLocationDataIsMutable();
        this.locationData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNightModeData(NightModeData.Builder builder) {
        ensureNightModeDataIsMutable();
        this.nightModeData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOdometerData(OdometerData.Builder builder) {
        ensureOdometerDataIsMutable();
        this.odometerData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParkingBrakeData(ParkingBrakeData.Builder builder) {
        ensureParkingBrakeDataIsMutable();
        this.parkingBrakeData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPassengerData(PassengerData.Builder builder) {
        ensurePassengerDataIsMutable();
        this.passengerData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRpmData(RpmData.Builder builder) {
        ensureRpmDataIsMutable();
        this.rpmData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSpeedData(SpeedData.Builder builder) {
        ensureSpeedDataIsMutable();
        this.speedData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTirePressureData(TirePressureData.Builder builder) {
        ensureTirePressureDataIsMutable();
        this.tirePressureData_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTollCardData(TollCardData.Builder builder) {
        ensureTollCardDataIsMutable();
        this.tollCardData_.add(builder.build());
    }

    public static SensorBatch parseFrom(InputStream inputStream) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAccelerometerData(int i, AccelerometerData.Builder builder) {
        ensureAccelerometerDataIsMutable();
        this.accelerometerData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCompassData(int i, CompassData.Builder builder) {
        ensureCompassDataIsMutable();
        this.compassData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDeadReckoningData(int i, DeadReckoningData.Builder builder) {
        ensureDeadReckoningDataIsMutable();
        this.deadReckoningData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDiagnosticsData(int i, DiagnosticsData.Builder builder) {
        ensureDiagnosticsDataIsMutable();
        this.diagnosticsData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDoorData(int i, DoorData.Builder builder) {
        ensureDoorDataIsMutable();
        this.doorData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDrivingStatusData(int i, DrivingStatusData.Builder builder) {
        ensureDrivingStatusDataIsMutable();
        this.drivingStatusData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnvironmentData(int i, EnvironmentData.Builder builder) {
        ensureEnvironmentDataIsMutable();
        this.environmentData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFuelData(int i, FuelData.Builder builder) {
        ensureFuelDataIsMutable();
        this.fuelData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGearData(int i, GearData.Builder builder) {
        ensureGearDataIsMutable();
        this.gearData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGpsSatelliteData(int i, GpsSatelliteData.Builder builder) {
        ensureGpsSatelliteDataIsMutable();
        this.gpsSatelliteData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGyroscopeData(int i, GyroscopeData.Builder builder) {
        ensureGyroscopeDataIsMutable();
        this.gyroscopeData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHvacData(int i, HvacData.Builder builder) {
        ensureHvacDataIsMutable();
        this.hvacData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLightData(int i, LightData.Builder builder) {
        ensureLightDataIsMutable();
        this.lightData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocationData(int i, LocationData.Builder builder) {
        ensureLocationDataIsMutable();
        this.locationData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNightModeData(int i, NightModeData.Builder builder) {
        ensureNightModeDataIsMutable();
        this.nightModeData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOdometerData(int i, OdometerData.Builder builder) {
        ensureOdometerDataIsMutable();
        this.odometerData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParkingBrakeData(int i, ParkingBrakeData.Builder builder) {
        ensureParkingBrakeDataIsMutable();
        this.parkingBrakeData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPassengerData(int i, PassengerData.Builder builder) {
        ensurePassengerDataIsMutable();
        this.passengerData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRpmData(int i, RpmData.Builder builder) {
        ensureRpmDataIsMutable();
        this.rpmData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSpeedData(int i, SpeedData.Builder builder) {
        ensureSpeedDataIsMutable();
        this.speedData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTirePressureData(int i, TirePressureData.Builder builder) {
        ensureTirePressureDataIsMutable();
        this.tirePressureData_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTollCardData(int i, TollCardData.Builder builder) {
        ensureTollCardDataIsMutable();
        this.tollCardData_.add(i, builder.build());
    }

    public static SensorBatch parseFrom(CodedInputStream codedInputStream) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SensorBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
