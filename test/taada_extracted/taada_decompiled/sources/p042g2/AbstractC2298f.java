package p042g2;

import fr.sd.taada.proto.DrivingStatusData;
import fr.sd.taada.proto.MessageStatus;
import fr.sd.taada.proto.ParkingBrakeData;
import fr.sd.taada.proto.SensorBatch;
import fr.sd.taada.proto.SensorRequest;
import fr.sd.taada.proto.SensorResponse;
import fr.sd.taada.proto.SensorType;
import org.greenrobot.eventbus.EventBus;
import p024d2.ProtocolMessage;
import p024d2.ProtocolMessagePool;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2298f {
    private static ProtocolMessagePool messagePool = ProtocolMessagePool.getInstance();

    public static ProtocolMessage m3192a(ProtocolMessage protocolMessage) {
        SensorRequest from;
        ProtocolMessage protocolMessageCreateMessage;
        SensorBatch.Builder builderNewBuilder;
        EventBus eventBus;
        String str;
        if (protocolMessage.getMessageType() == 32769) {
            protocolMessage.trimMessageTypeBytes();
            ProtocolMessage protocolMessageCreateMessage2 = messagePool.createMessage((byte) 2, (byte) 3, 32770);
            protocolMessageCreateMessage2.setPayloadFromProto(SensorResponse.newBuilder().setStatus(MessageStatus.STATUS_SUCCESS));
            EventBus.getDefault().post(protocolMessageCreateMessage2);
            try {
                from = SensorRequest.parseFrom(protocolMessage.getPayload());
            } catch (Exception e) {
                e.printStackTrace();
                from = null;
            }
            if (from.getType() == SensorType.SENSOR_DRIVING_STATUS_DATA) {
                protocolMessageCreateMessage = messagePool.createMessage((byte) 2, (byte) 3, 32771);
                builderNewBuilder = SensorBatch.newBuilder();
                builderNewBuilder.addDrivingStatusData(DrivingStatusData.newBuilder().setStatus(0).build());
            } else {
                if (from.getType() != SensorType.SENSOR_PARKING_BRAKE) {
                    if (from.getType() == SensorType.SENSOR_LOCATION) {
                        eventBus = EventBus.getDefault();
                        str = "gb.xxy.hr.startGPS";
                    } else if (from.getType() == SensorType.SENSOR_SPEED) {
                        eventBus = EventBus.getDefault();
                        str = "gb.xxy.hr.startSpeed";
                    } else {
                        if (from.getType() != SensorType.SENSOR_NIGHT_MODE) {
                            return null;
                        }
                        eventBus = EventBus.getDefault();
                        str = "gb.xxy.hr.startNight";
                    }
                    eventBus.post(str);
                    return null;
                }
                protocolMessageCreateMessage = messagePool.createMessage((byte) 2, (byte) 3, 32771);
                builderNewBuilder = SensorBatch.newBuilder();
                builderNewBuilder.addParkingBrakeData(ParkingBrakeData.newBuilder().setParkingBrake(true).build());
            }
            protocolMessageCreateMessage.setPayloadFromProto(builderNewBuilder);
            EventBus.getDefault().post(protocolMessageCreateMessage);
        }
        return null;
    }
}
