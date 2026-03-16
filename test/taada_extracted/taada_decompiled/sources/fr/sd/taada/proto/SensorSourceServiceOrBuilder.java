package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.SensorSourceService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface SensorSourceServiceOrBuilder extends MessageLiteOrBuilder {
    int getLocationCharacterization();

    SensorSourceService.Sensor getSensors(int i);

    int getSensorsCount();

    List<SensorSourceService.Sensor> getSensorsList();

    EvConnectorType getSupportedEvConnectorTypes(int i);

    int getSupportedEvConnectorTypesCount();

    List<EvConnectorType> getSupportedEvConnectorTypesList();

    FuelType getSupportedFuelTypes(int i);

    int getSupportedFuelTypesCount();

    List<FuelType> getSupportedFuelTypesList();

    boolean hasLocationCharacterization();
}
