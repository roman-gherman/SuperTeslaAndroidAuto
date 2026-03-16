package fr.sd.taada.protocol;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BinaryTouchDecoder {
    public static final int ACTION_MULTITOUCH_DOWN = 0;
    public static final int ACTION_MULTITOUCH_MOVE = 1;
    public static final int ACTION_MULTITOUCH_UP = 2;
    public static final int ACTION_TOUCH = 3;
    private long lastTimestamp = System.currentTimeMillis();

    public static class TouchEvent {
        public final int action;
        public final List<TouchPoint> allTouches;
        public final long timestamp;
        public final List<TouchPoint> touches;

        public TouchEvent(int i, List<TouchPoint> list, List<TouchPoint> list2, long j6) {
            this.action = i;
            this.touches = list;
            this.allTouches = list2;
            this.timestamp = j6;
        }

        public String getActionName() {
            int i = this.action;
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "TOUCH" : "MULTITOUCH_UP" : "MULTITOUCH_MOVE" : "MULTITOUCH_DOWN";
        }

        public String toString() {
            return String.format("TouchEvent[action=%s, touches=%d, allTouches=%d, timestamp=%d]", getActionName(), Integer.valueOf(this.touches.size()), Integer.valueOf(this.allTouches.size()), Long.valueOf(this.timestamp));
        }
    }

    public static class TouchPoint {
        public final int id;
        public final int x;
        public final int y;

        public TouchPoint(int i, int i3, int i4) {
            this.id = i;
            this.x = i3;
            this.y = i4;
        }

        public String toString() {
            return String.format("Touch[id=%d, x=%d, y=%d]", Integer.valueOf(this.id), Integer.valueOf(this.x), Integer.valueOf(this.y));
        }
    }

    public static boolean isBinaryFormat(byte[] bArr) {
        return bArr != null && bArr.length >= 8 && (bArr[0] & 255) <= 3 && (bArr[1] & 255) <= 10;
    }

    public static void main(String[] strArr) {
        try {
            TouchEvent touchEventDecode = new BinaryTouchDecoder().decode(new byte[]{1, 1, 0, 0, 2, 0, 1, -128, 2, 0, 0, 2, 0, 1, -128, 0, 1, 3, 0, 2, 0, 0, 0, 0, 16});
            System.out.println("Decoded: " + touchEventDecode);
            System.out.println("Touches that moved: " + touchEventDecode.touches.size());
            System.out.println("All active touches: " + touchEventDecode.allTouches.size());
            for (TouchPoint touchPoint : touchEventDecode.allTouches) {
                System.out.println("  " + touchPoint);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Decode error: " + e.getMessage());
        }
    }

    public TouchEvent decode(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            throw new IllegalArgumentException("Invalid touch data: too short (min 8 bytes)");
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        int i = byteBufferWrap.get() & 255;
        int i3 = byteBufferWrap.get() & 255;
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(new TouchPoint(byteBufferWrap.getShort() & 65535, byteBufferWrap.getShort() & 65535, 65535 & byteBufferWrap.getShort()));
        }
        int i5 = byteBufferWrap.get() & 255;
        ArrayList arrayList2 = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList2.add(new TouchPoint(byteBufferWrap.getShort() & 65535, byteBufferWrap.getShort() & 65535, byteBufferWrap.getShort() & 65535));
        }
        if (byteBufferWrap.remaining() < 4) {
            throw new IllegalArgumentException(String.format("Invalid touch data: missing timestamp (expected 4 bytes, got %d)", Integer.valueOf(byteBufferWrap.remaining())));
        }
        long j6 = this.lastTimestamp + (((long) byteBufferWrap.getInt()) & 4294967295L);
        this.lastTimestamp = j6;
        return new TouchEvent(i, arrayList, arrayList2, j6);
    }

    public void reset() {
        this.lastTimestamp = System.currentTimeMillis();
    }
}
