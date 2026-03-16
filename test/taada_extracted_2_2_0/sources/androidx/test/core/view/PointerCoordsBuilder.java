package androidx.test.core.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class PointerCoordsBuilder {
    private float orientation;
    private float toolMajor;
    private float toolMinor;
    private float touchMajor;
    private float touchMinor;
    private float x = 0.0f;
    private float y = 0.0f;
    private float pressure = 1.0f;
    private float size = 1.0f;

    private PointerCoordsBuilder() {
    }

    public static PointerCoordsBuilder newBuilder() {
        return new PointerCoordsBuilder();
    }

    public MotionEvent.PointerCoords build() {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = this.x;
        pointerCoords.y = this.y;
        pointerCoords.pressure = this.pressure;
        pointerCoords.size = this.size;
        pointerCoords.touchMajor = this.touchMajor;
        pointerCoords.touchMinor = this.touchMinor;
        pointerCoords.toolMajor = this.toolMajor;
        pointerCoords.toolMinor = this.toolMinor;
        pointerCoords.orientation = this.orientation;
        return pointerCoords;
    }

    public PointerCoordsBuilder setCoords(float f6, float f7) {
        this.x = f6;
        this.y = f7;
        return this;
    }

    public PointerCoordsBuilder setOrientation(float f6) {
        this.orientation = f6;
        return this;
    }

    public PointerCoordsBuilder setPressure(float f6) {
        this.pressure = f6;
        return this;
    }

    public PointerCoordsBuilder setSize(float f6) {
        this.size = f6;
        return this;
    }

    public PointerCoordsBuilder setTool(float f6, float f7) {
        this.toolMajor = f6;
        this.toolMinor = f7;
        return this;
    }

    public PointerCoordsBuilder setTouch(float f6, float f7) {
        this.touchMajor = f6;
        this.touchMinor = f7;
        return this;
    }
}
