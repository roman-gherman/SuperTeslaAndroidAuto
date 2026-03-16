package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface SensorBatchOrBuilder extends MessageLiteOrBuilder {
    AccelerometerData getAccelerometerData(int i);

    int getAccelerometerDataCount();

    List<AccelerometerData> getAccelerometerDataList();

    CompassData getCompassData(int i);

    int getCompassDataCount();

    List<CompassData> getCompassDataList();

    DeadReckoningData getDeadReckoningData(int i);

    int getDeadReckoningDataCount();

    List<DeadReckoningData> getDeadReckoningDataList();

    DiagnosticsData getDiagnosticsData(int i);

    int getDiagnosticsDataCount();

    List<DiagnosticsData> getDiagnosticsDataList();

    DoorData getDoorData(int i);

    int getDoorDataCount();

    List<DoorData> getDoorDataList();

    DrivingStatusData getDrivingStatusData(int i);

    int getDrivingStatusDataCount();

    List<DrivingStatusData> getDrivingStatusDataList();

    EnvironmentData getEnvironmentData(int i);

    int getEnvironmentDataCount();

    List<EnvironmentData> getEnvironmentDataList();

    FuelData getFuelData(int i);

    int getFuelDataCount();

    List<FuelData> getFuelDataList();

    GearData getGearData(int i);

    int getGearDataCount();

    List<GearData> getGearDataList();

    GpsSatelliteData getGpsSatelliteData(int i);

    int getGpsSatelliteDataCount();

    List<GpsSatelliteData> getGpsSatelliteDataList();

    GyroscopeData getGyroscopeData(int i);

    int getGyroscopeDataCount();

    List<GyroscopeData> getGyroscopeDataList();

    HvacData getHvacData(int i);

    int getHvacDataCount();

    List<HvacData> getHvacDataList();

    LightData getLightData(int i);

    int getLightDataCount();

    List<LightData> getLightDataList();

    LocationData getLocationData(int i);

    int getLocationDataCount();

    List<LocationData> getLocationDataList();

    NightModeData getNightModeData(int i);

    int getNightModeDataCount();

    List<NightModeData> getNightModeDataList();

    OdometerData getOdometerData(int i);

    int getOdometerDataCount();

    List<OdometerData> getOdometerDataList();

    ParkingBrakeData getParkingBrakeData(int i);

    int getParkingBrakeDataCount();

    List<ParkingBrakeData> getParkingBrakeDataList();

    PassengerData getPassengerData(int i);

    int getPassengerDataCount();

    List<PassengerData> getPassengerDataList();

    RpmData getRpmData(int i);

    int getRpmDataCount();

    List<RpmData> getRpmDataList();

    SpeedData getSpeedData(int i);

    int getSpeedDataCount();

    List<SpeedData> getSpeedDataList();

    TirePressureData getTirePressureData(int i);

    int getTirePressureDataCount();

    List<TirePressureData> getTirePressureDataList();

    TollCardData getTollCardData(int i);

    int getTollCardDataCount();

    List<TollCardData> getTollCardDataList();
}
