package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.constraintlayout.core.motion.a;
import java.util.ArrayList;
import net.bytebuddy.asm.Advice;

/* JADX INFO: loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            PathDataNode pathDataNode = pathDataNodeArr[i];
            char c = pathDataNode.mType;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i];
            if (c != pathDataNode2.mType || pathDataNode.mParams.length != pathDataNode2.mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i3) {
        if (i > i3) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = i3 - i;
        int iMin = Math.min(i4, length - i);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i3 = 0;
        while (i < str.length()) {
            int iNextStart = nextStart(str, i);
            String strTrim = str.substring(i3, iNextStart).trim();
            if (strTrim.length() > 0) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i3 = iNextStart;
            i = iNextStart + 1;
        }
        if (i - i3 == 1 && i3 < str.length()) {
            addNode(arrayList, str.charAt(i3), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] pathDataNodeArrCreateNodesFromPathData = createNodesFromPathData(str);
        if (pathDataNodeArrCreateNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(pathDataNodeArrCreateNodesFromPathData, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(a.p("Error in parsing ", str), e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i3 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i4 = extractFloatResult.mEndPosition;
                if (i < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i, i4));
                    i3++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i4 : i4 + 1;
            }
            return copyOfRange(fArr, 0, i3);
        } catch (NumberFormatException e) {
            throw new RuntimeException(a.q("error in parsing \"", str, "\""), e);
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f6) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f6);
        }
        return true;
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                }
                i++;
            }
            if (cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            int i3 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i].mParams;
                if (i3 < fArr.length) {
                    pathDataNodeArr[i].mParams[i3] = fArr[i3];
                    i3++;
                }
            }
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(Path path, float[] fArr, char c, char c6, float[] fArr2) {
            int i;
            int i3;
            boolean z6;
            boolean z7;
            char c7;
            char c8;
            int i4;
            float f6;
            boolean z8;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            boolean z9;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            Path path2 = path;
            boolean z10 = false;
            float f22 = fArr[0];
            boolean z11 = true;
            float f23 = fArr[1];
            char c9 = 2;
            float f24 = fArr[2];
            char c10 = 3;
            float f25 = fArr[3];
            float f26 = fArr[4];
            float f27 = fArr[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i = 7;
                    i3 = i;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    i3 = i;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i3 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i3 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i3 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f26, f27);
                    f22 = f26;
                    f24 = f22;
                    f23 = f27;
                    f25 = f23;
                    i3 = 2;
                    break;
            }
            float f28 = f22;
            float f29 = f23;
            float f30 = f26;
            float f31 = f27;
            int i5 = 0;
            char c11 = c;
            while (i5 < fArr2.length) {
                if (c6 == 'A') {
                    float f32 = f28;
                    float f33 = f29;
                    z6 = z10;
                    z7 = z11;
                    c7 = c9;
                    c8 = c10;
                    i4 = i5;
                    int i6 = i4 + 5;
                    float f34 = fArr2[i6];
                    int i7 = i4 + 6;
                    float f35 = fArr2[i7];
                    float f36 = fArr2[i4];
                    float f37 = fArr2[i4 + 1];
                    float f38 = fArr2[i4 + 2];
                    if (fArr2[i4 + 3] != 0.0f) {
                        f6 = 0.0f;
                        z8 = z7;
                    } else {
                        f6 = 0.0f;
                        z8 = z6;
                    }
                    drawArc(path, f32, f33, f34, f35, f36, f37, f38, z8, fArr2[i4 + 4] != f6 ? z7 : z6);
                    f24 = fArr2[i6];
                    f28 = f24;
                    f25 = fArr2[i7];
                    f29 = f25;
                } else if (c6 == 'C') {
                    z6 = z10;
                    z7 = z11;
                    c7 = c9;
                    c8 = c10;
                    i4 = i5;
                    int i8 = i4 + 2;
                    int i9 = i4 + 3;
                    int i10 = i4 + 4;
                    int i11 = i4 + 5;
                    path2.cubicTo(fArr2[i4], fArr2[i4 + 1], fArr2[i8], fArr2[i9], fArr2[i10], fArr2[i11]);
                    float f39 = fArr2[i10];
                    float f40 = fArr2[i11];
                    float f41 = fArr2[i8];
                    float f42 = fArr2[i9];
                    f28 = f39;
                    f29 = f40;
                    f25 = f42;
                    f24 = f41;
                } else if (c6 != 'H') {
                    if (c6 != 'Q') {
                        z6 = z10;
                        if (c6 == 'V') {
                            z7 = z11;
                            c7 = c9;
                            c8 = c10;
                            i4 = i5;
                            path2.lineTo(f28, fArr2[i4]);
                            f9 = fArr2[i4];
                        } else if (c6 != 'a') {
                            if (c6 != 'c') {
                                z7 = z11;
                                if (c6 != 'h') {
                                    if (c6 != 'q') {
                                        c7 = c9;
                                        if (c6 != 'v') {
                                            if (c6 != 'L') {
                                                if (c6 != 'M') {
                                                    c8 = c10;
                                                    if (c6 == 'S') {
                                                        if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                                            f28 = (f28 * 2.0f) - f24;
                                                            f29 = (f29 * 2.0f) - f25;
                                                        }
                                                        float f43 = f28;
                                                        float f44 = f29;
                                                        int i12 = i5 + 1;
                                                        int i13 = i5 + 2;
                                                        int i14 = i5 + 3;
                                                        path2.cubicTo(f43, f44, fArr2[i5], fArr2[i12], fArr2[i13], fArr2[i14]);
                                                        f7 = fArr2[i5];
                                                        f8 = fArr2[i12];
                                                        f28 = fArr2[i13];
                                                        f29 = fArr2[i14];
                                                        i4 = i5;
                                                    } else if (c6 == 'T') {
                                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                            f28 = (f28 * 2.0f) - f24;
                                                            f29 = (f29 * 2.0f) - f25;
                                                        }
                                                        int i15 = i5 + 1;
                                                        path2.quadTo(f28, f29, fArr2[i5], fArr2[i15]);
                                                        float f45 = fArr2[i5];
                                                        f9 = fArr2[i15];
                                                        f24 = f28;
                                                        f25 = f29;
                                                        i4 = i5;
                                                        f28 = f45;
                                                    } else if (c6 == 'l') {
                                                        int i16 = i5 + 1;
                                                        path2.rLineTo(fArr2[i5], fArr2[i16]);
                                                        f28 += fArr2[i5];
                                                        f15 = fArr2[i16];
                                                    } else if (c6 == 'm') {
                                                        float f46 = fArr2[i5];
                                                        f28 += f46;
                                                        float f47 = fArr2[i5 + 1];
                                                        f29 += f47;
                                                        if (i5 > 0) {
                                                            path2.rLineTo(f46, f47);
                                                        } else {
                                                            path2.rMoveTo(f46, f47);
                                                            f30 = f28;
                                                        }
                                                    } else if (c6 == 's') {
                                                        if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                                            f18 = f29 - f25;
                                                            f19 = f28 - f24;
                                                        } else {
                                                            f19 = 0.0f;
                                                            f18 = 0.0f;
                                                        }
                                                        int i17 = i5 + 1;
                                                        int i18 = i5 + 2;
                                                        int i19 = i5 + 3;
                                                        path2.rCubicTo(f19, f18, fArr2[i5], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                        f12 = fArr2[i5] + f28;
                                                        f13 = fArr2[i17] + f29;
                                                        f28 += fArr2[i18];
                                                        f14 = fArr2[i19];
                                                    } else if (c6 == 't') {
                                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                            f20 = f28 - f24;
                                                            f21 = f29 - f25;
                                                        } else {
                                                            f21 = 0.0f;
                                                            f20 = 0.0f;
                                                        }
                                                        int i20 = i5 + 1;
                                                        path2.rQuadTo(f20, f21, fArr2[i5], fArr2[i20]);
                                                        float f48 = f20 + f28;
                                                        float f49 = f21 + f29;
                                                        f28 += fArr2[i5];
                                                        f29 += fArr2[i20];
                                                        f25 = f49;
                                                        f24 = f48;
                                                    }
                                                } else {
                                                    c8 = c10;
                                                    f16 = fArr2[i5];
                                                    f17 = fArr2[i5 + 1];
                                                    if (i5 > 0) {
                                                        path2.lineTo(f16, f17);
                                                    } else {
                                                        path2.moveTo(f16, f17);
                                                        f28 = f16;
                                                        f30 = f28;
                                                        f29 = f17;
                                                    }
                                                }
                                                f31 = f29;
                                            } else {
                                                c8 = c10;
                                                int i21 = i5 + 1;
                                                path2.lineTo(fArr2[i5], fArr2[i21]);
                                                f16 = fArr2[i5];
                                                f17 = fArr2[i21];
                                            }
                                            f28 = f16;
                                            f29 = f17;
                                        } else {
                                            c8 = c10;
                                            path2.rLineTo(0.0f, fArr2[i5]);
                                            f15 = fArr2[i5];
                                        }
                                        f29 += f15;
                                    } else {
                                        c7 = c9;
                                        c8 = c10;
                                        int i22 = i5 + 1;
                                        int i23 = i5 + 2;
                                        int i24 = i5 + 3;
                                        path2.rQuadTo(fArr2[i5], fArr2[i22], fArr2[i23], fArr2[i24]);
                                        f12 = fArr2[i5] + f28;
                                        f13 = fArr2[i22] + f29;
                                        f28 += fArr2[i23];
                                        f14 = fArr2[i24];
                                    }
                                    f29 += f14;
                                    f24 = f12;
                                    f25 = f13;
                                } else {
                                    c7 = c9;
                                    c8 = c10;
                                    path2.rLineTo(fArr2[i5], 0.0f);
                                    f28 += fArr2[i5];
                                }
                            } else {
                                z7 = z11;
                                c7 = c9;
                                c8 = c10;
                                int i25 = i5 + 2;
                                int i26 = i5 + 3;
                                int i27 = i5 + 4;
                                int i28 = i5 + 5;
                                path2.rCubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i25], fArr2[i26], fArr2[i27], fArr2[i28]);
                                float f50 = fArr2[i25] + f28;
                                float f51 = fArr2[i26] + f29;
                                f28 += fArr2[i27];
                                f29 += fArr2[i28];
                                f24 = f50;
                                f25 = f51;
                            }
                            i4 = i5;
                        } else {
                            z7 = z11;
                            c7 = c9;
                            c8 = c10;
                            int i29 = i5 + 5;
                            float f52 = fArr2[i29] + f28;
                            int i30 = i5 + 6;
                            float f53 = fArr2[i30] + f29;
                            float f54 = fArr2[i5];
                            float f55 = fArr2[i5 + 1];
                            float f56 = fArr2[i5 + 2];
                            if (fArr2[i5 + 3] != 0.0f) {
                                f10 = 0.0f;
                                f11 = f29;
                                z9 = z7;
                            } else {
                                f10 = 0.0f;
                                f11 = f29;
                                z9 = z6;
                            }
                            i4 = i5;
                            boolean z12 = fArr2[i5 + 4] != f10 ? z7 : z6;
                            float f57 = f28;
                            drawArc(path, f57, f11, f52, f53, f54, f55, f56, z9, z12);
                            f28 = f57 + fArr2[i29];
                            f29 = f11 + fArr2[i30];
                            f24 = f28;
                            f25 = f29;
                        }
                        f29 = f9;
                    } else {
                        z6 = z10;
                        z7 = z11;
                        c7 = c9;
                        c8 = c10;
                        i4 = i5;
                        int i31 = i4 + 1;
                        int i32 = i4 + 2;
                        int i33 = i4 + 3;
                        path2.quadTo(fArr2[i4], fArr2[i31], fArr2[i32], fArr2[i33]);
                        f7 = fArr2[i4];
                        f8 = fArr2[i31];
                        f28 = fArr2[i32];
                        f29 = fArr2[i33];
                    }
                    f24 = f7;
                    f25 = f8;
                } else {
                    z6 = z10;
                    z7 = z11;
                    c7 = c9;
                    c8 = c10;
                    i4 = i5;
                    path2.lineTo(fArr2[i4], f29);
                    f28 = fArr2[i4];
                }
                i5 = i4 + i3;
                path2 = path;
                c11 = c6;
                z10 = z6;
                z11 = z7;
                c9 = c7;
                c10 = c8;
            }
            fArr[z10 ? 1 : 0] = f28;
            fArr[z11 ? 1 : 0] = f29;
            fArr[c9] = f24;
            fArr[c10] = f25;
            fArr[4] = f30;
            fArr[5] = f31;
        }

        private static void arcToBezier(Path path, double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
            double d14 = d7;
            int iCeil = (int) Math.ceil(Math.abs((d13 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d11);
            double dSin = Math.sin(d11);
            double dCos2 = Math.cos(d12);
            double dSin2 = Math.sin(d12);
            double d15 = -d14;
            double d16 = d15 * dCos;
            double d17 = d8 * dSin;
            double d18 = (d16 * dSin2) - (d17 * dCos2);
            double d19 = d15 * dSin;
            double d20 = d8 * dCos;
            double d21 = (dCos2 * d20) + (dSin2 * d19);
            double d22 = d13 / ((double) iCeil);
            double d23 = d21;
            double d24 = d18;
            int i = 0;
            double d25 = d9;
            double d26 = d10;
            double d27 = d12;
            while (i < iCeil) {
                double d28 = d27 + d22;
                double dSin3 = Math.sin(d28);
                double dCos3 = Math.cos(d28);
                double d29 = (((d14 * dCos) * dCos3) + d) - (d17 * dSin3);
                int i3 = i;
                double d30 = (d20 * dSin3) + (d7 * dSin * dCos3) + d6;
                double d31 = (d16 * dSin3) - (d17 * dCos3);
                double d32 = (dCos3 * d20) + (dSin3 * d19);
                double d33 = d28 - d27;
                double dTan = Math.tan(d33 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d33)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d24 * dSqrt) + d25), (float) ((d23 * dSqrt) + d26), (float) (d29 - (dSqrt * d31)), (float) (d30 - (dSqrt * d32)), (float) d29, (float) d30);
                dSin = dSin;
                d22 = d22;
                d25 = d29;
                d19 = d19;
                dCos = dCos;
                d23 = d32;
                d24 = d31;
                d14 = d7;
                d26 = d30;
                i = i3 + 1;
                iCeil = iCeil;
                d27 = d28;
            }
        }

        private static void drawArc(Path path, float f6, float f7, float f8, float f9, float f10, float f11, float f12, boolean z6, boolean z7) {
            double d;
            double d6;
            double radians = Math.toRadians(f12);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d7 = f6;
            double d8 = f7;
            double d9 = f10;
            double d10 = ((d8 * dSin) + (d7 * dCos)) / d9;
            double d11 = f11;
            double d12 = ((d8 * dCos) + (((double) (-f6)) * dSin)) / d11;
            double d13 = f9;
            double d14 = ((d13 * dSin) + (((double) f8) * dCos)) / d9;
            double d15 = ((d13 * dCos) + (((double) (-f8)) * dSin)) / d11;
            double d16 = d10 - d14;
            double d17 = d12 - d15;
            double d18 = (d10 + d14) / 2.0d;
            double d19 = (d12 + d15) / 2.0d;
            double d20 = (d17 * d17) + (d16 * d16);
            if (d20 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d21 = (1.0d / d20) - 0.25d;
            if (d21 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d20);
                float fSqrt = (float) (Math.sqrt(d20) / 1.99999d);
                drawArc(path, f6, f7, f8, f9, f10 * fSqrt, fSqrt * f11, f12, z6, z7);
                return;
            }
            double dSqrt = Math.sqrt(d21);
            double d22 = dSqrt * d16;
            double d23 = dSqrt * d17;
            if (z6 == z7) {
                d = d18 - d23;
                d6 = d19 + d22;
            } else {
                d = d18 + d23;
                d6 = d19 - d22;
            }
            double dAtan2 = Math.atan2(d12 - d6, d10 - d);
            double dAtan22 = Math.atan2(d15 - d6, d14 - d) - dAtan2;
            if (z7 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d24 = d * d9;
            double d25 = d6 * d11;
            arcToBezier(path, (d24 * dCos) - (d25 * dSin), (d25 * dCos) + (d24 * dSin), d9, d11, d7, d8, radians, dAtan2, dAtan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL;
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                PathDataNode pathDataNode = pathDataNodeArr[i];
                addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f6) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (pathDataNode2.mParams[i] * f6) + ((1.0f - f6) * fArr[i]);
                i++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }
}
