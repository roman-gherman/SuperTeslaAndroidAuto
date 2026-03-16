package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    public CamColor(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.mHue = f6;
        this.mChroma = f7;
        this.mJ = f8;
        this.mQ = f9;
        this.mM = f10;
        this.mS = f11;
        this.mJstar = f12;
        this.mAstar = f13;
        this.mBstar = f14;
    }

    private static CamColor findCamByJ(float f6, float f7, float f8) {
        float f9 = 100.0f;
        float f10 = 1000.0f;
        float f11 = 0.0f;
        CamColor camColor = null;
        float f12 = 1000.0f;
        while (Math.abs(f11 - f9) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f13 = ((f9 - f11) / 2.0f) + f11;
            int iViewedInSrgb = fromJch(f13, f7, f6).viewedInSrgb();
            float fLStarFromInt = CamUtils.lStarFromInt(iViewedInSrgb);
            float fAbs = Math.abs(f8 - fLStarFromInt);
            if (fAbs < 0.2f) {
                CamColor camColorFromColor = fromColor(iViewedInSrgb);
                float fDistance = camColorFromColor.distance(fromJch(camColorFromColor.getJ(), camColorFromColor.getChroma(), f6));
                if (fDistance <= 1.0f) {
                    camColor = camColorFromColor;
                    f10 = fAbs;
                    f12 = fDistance;
                }
            }
            if (f10 == 0.0f && f12 == 0.0f) {
                return camColor;
            }
            if (fLStarFromInt < f8) {
                f11 = f13;
            } else {
                f9 = f13;
            }
        }
        return camColor;
    }

    public static CamColor fromColor(int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void fromColorInViewingConditions(int i, ViewingConditions viewingConditions, float[] fArr, float[] fArr2) {
        CamUtils.xyzFromInt(i, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f6 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f7 = fArr4[0] * f6;
        float f8 = fArr2[1];
        float f9 = (fArr4[1] * f8) + f7;
        float f10 = fArr2[2];
        float f11 = (fArr4[2] * f10) + f9;
        float[] fArr5 = fArr3[1];
        float f12 = (fArr5[2] * f10) + (fArr5[1] * f8) + (fArr5[0] * f6);
        float[] fArr6 = fArr3[2];
        float f13 = (f10 * fArr6[2]) + (f8 * fArr6[1]) + (f6 * fArr6[0]);
        float f14 = viewingConditions.getRgbD()[0] * f11;
        float f15 = viewingConditions.getRgbD()[1] * f12;
        float f16 = viewingConditions.getRgbD()[2] * f13;
        float fPow = (float) Math.pow(((double) (Math.abs(f14) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f15) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f16) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f14) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f15) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f16) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f17 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d)) / 11.0f;
        float f18 = ((float) (((double) (fSignum + fSignum2)) - (d * 2.0d))) / 9.0f;
        float f19 = fSignum2 * 20.0f;
        float f20 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f19)) / 20.0f;
        float f21 = (((fSignum * 40.0f) + f19) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f18, f17)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f22 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f21 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(fPow4 / 100.0f)) * viewingConditions.getFlRoot();
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? fAtan2 + 360.0f : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f18 * f18) + (f17 * f17)))) / (f20 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r6 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f23 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
        double d6 = f22;
        float fCos = ((float) Math.cos(d6)) * fLog;
        float fSin = fLog * ((float) Math.sin(d6));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = aw;
            fArr[2] = flRoot;
            fArr[3] = fSqrt2;
            fArr[4] = f23;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    private static CamColor fromJch(float f6, float f7, float f8) {
        return fromJchInFrame(f6, f7, f8, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f6, float f7, float f8, ViewingConditions viewingConditions) {
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(((double) f6) / 100.0d)) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f7;
        float fSqrt = ((float) Math.sqrt(((f7 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f9 = (1.7f * f6) / ((0.007f * f6) + 1.0f);
        float fLog = ((float) Math.log((((double) flRoot) * 0.0228d) + 1.0d)) * 43.85965f;
        double d = (3.1415927f * f8) / 180.0f;
        return new CamColor(f8, f7, f6, aw, flRoot, fSqrt, f9, ((float) Math.cos(d)) * fLog, fLog * ((float) Math.sin(d)));
    }

    public static void getM3HCTfromColor(int i, float[] fArr) {
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i);
    }

    public static int toColor(float f6, float f7, float f8) {
        return toColor(f6, f7, f8, ViewingConditions.DEFAULT);
    }

    public float distance(CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((bStar * bStar) + (aStar * aStar) + (jStar * jStar)), 0.63d) * 1.41d);
    }

    public float getAStar() {
        return this.mAstar;
    }

    public float getBStar() {
        return this.mBstar;
    }

    public float getChroma() {
        return this.mChroma;
    }

    public float getHue() {
        return this.mHue;
    }

    public float getJ() {
        return this.mJ;
    }

    public float getJStar() {
        return this.mJstar;
    }

    public float getM() {
        return this.mM;
    }

    public float getQ() {
        return this.mQ;
    }

    public float getS() {
        return this.mS;
    }

    public int viewed(ViewingConditions viewingConditions) {
        float fPow = (float) Math.pow(((double) ((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) viewingConditions.getC())) / ((double) viewingConditions.getZ())));
        float nc = fCos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float fSin = (float) Math.sin(hue);
        float fCos2 = (float) Math.cos(hue);
        float f6 = (((0.305f + nbb) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + (((11.0f * fPow) * fCos2) + (nc * 23.0f)));
        float f7 = fCos2 * f6;
        float f8 = f6 * fSin;
        float f9 = nbb * 460.0f;
        float f10 = ((288.0f * f8) + ((451.0f * f7) + f9)) / 1403.0f;
        float f11 = ((f9 - (891.0f * f7)) - (261.0f * f8)) / 1403.0f;
        float f12 = ((f9 - (f7 * 220.0f)) - (f8 * 6300.0f)) / 1403.0f;
        float fl = (100.0f / viewingConditions.getFl()) * Math.signum(f10) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f10)) * 27.13d) / (400.0d - ((double) Math.abs(f10)))), 2.380952380952381d));
        float fl2 = (100.0f / viewingConditions.getFl()) * Math.signum(f11) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f11)) * 27.13d) / (400.0d - ((double) Math.abs(f11)))), 2.380952380952381d));
        float fl3 = (100.0f / viewingConditions.getFl()) * Math.signum(f12) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f12)) * 27.13d) / (400.0d - ((double) Math.abs(f12)))), 2.380952380952381d));
        float f13 = fl / viewingConditions.getRgbD()[0];
        float f14 = fl2 / viewingConditions.getRgbD()[1];
        float f15 = fl3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f16 = (fArr2[2] * f15) + (fArr2[1] * f14) + (fArr2[0] * f13);
        float[] fArr3 = fArr[1];
        float f17 = (fArr3[2] * f15) + (fArr3[1] * f14) + (fArr3[0] * f13);
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f16, f17, (f15 * fArr4[2]) + (f14 * fArr4[1]) + (f13 * fArr4[0]));
    }

    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public static int toColor(float f6, float f7, float f8, ViewingConditions viewingConditions) {
        if (f7 < 1.0d || Math.round(f8) <= 0.0d || Math.round(f8) >= 100.0d) {
            return CamUtils.intFromLStar(f8);
        }
        float fMin = f6 < 0.0f ? 0.0f : Math.min(360.0f, f6);
        CamColor camColor = null;
        boolean z6 = true;
        float f9 = 0.0f;
        float f10 = f7;
        while (Math.abs(f9 - f7) >= CHROMA_SEARCH_ENDPOINT) {
            CamColor camColorFindCamByJ = findCamByJ(fMin, f10, f8);
            if (!z6) {
                if (camColorFindCamByJ == null) {
                    f7 = f10;
                } else {
                    f9 = f10;
                    camColor = camColorFindCamByJ;
                }
                f10 = ((f7 - f9) / 2.0f) + f9;
            } else {
                if (camColorFindCamByJ != null) {
                    return camColorFindCamByJ.viewed(viewingConditions);
                }
                f10 = ((f7 - f9) / 2.0f) + f9;
                z6 = false;
            }
        }
        return camColor == null ? CamUtils.intFromLStar(f8) : camColor.viewed(viewingConditions);
    }
}
