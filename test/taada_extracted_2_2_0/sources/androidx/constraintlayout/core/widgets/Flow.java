package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i3;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i = this.mCount;
            for (int i3 = 0; i3 < i && this.mStartIndex + i3 < Flow.this.mDisplayedWidgetsCount; i3++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i3];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i4 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.mWidth = width + i4 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i5 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i5 = 0;
                    }
                    this.mHeight = widgetHeight2 + i5 + this.mHeight;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth = widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0) + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight = widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0) + this.mHeight;
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z6, int i, boolean z7) {
            ConstraintWidget constraintWidget;
            int i3;
            char c;
            float f6;
            float f7;
            int i4 = this.mCount;
            for (int i5 = 0; i5 < i4 && this.mStartIndex + i5 < Flow.this.mDisplayedWidgetsCount; i5++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i5];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i4 == 0 || this.biggest == null) {
                return;
            }
            boolean z8 = z7 && i == 0;
            int i6 = -1;
            int i7 = -1;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = z6 ? (i4 - 1) - i8 : i8;
                if (this.mStartIndex + i9 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget3 = Flow.this.mDisplayedWidgets[this.mStartIndex + i9];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                    if (i6 == -1) {
                        i6 = i8;
                    }
                    i7 = i8;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget5 = this.biggest;
                constraintWidget5.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i10 = this.mPaddingLeft;
                if (i > 0) {
                    i10 += Flow.this.mHorizontalGap;
                }
                if (z6) {
                    constraintWidget5.mRight.connect(this.mRight, i10);
                    if (z7) {
                        constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget5.mRight, 0);
                    }
                } else {
                    constraintWidget5.mLeft.connect(this.mLeft, i10);
                    if (z7) {
                        constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget5.mLeft, 0);
                    }
                }
                for (int i11 = 0; i11 < i4 && this.mStartIndex + i11 < Flow.this.mDisplayedWidgetsCount; i11++) {
                    ConstraintWidget constraintWidget6 = Flow.this.mDisplayedWidgets[this.mStartIndex + i11];
                    if (constraintWidget6 != null) {
                        if (i11 == 0) {
                            constraintWidget6.connect(constraintWidget6.mTop, this.mTop, this.mPaddingTop);
                            int i12 = Flow.this.mVerticalStyle;
                            float f8 = Flow.this.mVerticalBias;
                            if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                                i12 = Flow.this.mFirstVerticalStyle;
                                f8 = Flow.this.mFirstVerticalBias;
                            } else if (z7 && Flow.this.mLastVerticalStyle != -1) {
                                i12 = Flow.this.mLastVerticalStyle;
                                f8 = Flow.this.mLastVerticalBias;
                            }
                            constraintWidget6.setVerticalChainStyle(i12);
                            constraintWidget6.setVerticalBiasPercent(f8);
                        }
                        if (i11 == i4 - 1) {
                            constraintWidget6.connect(constraintWidget6.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.mTop.connect(constraintWidget4.mBottom, Flow.this.mVerticalGap);
                            if (i11 == i6) {
                                constraintWidget6.mTop.setGoneMargin(this.mPaddingTop);
                            }
                            constraintWidget4.mBottom.connect(constraintWidget6.mTop, 0);
                            if (i11 == i7 + 1) {
                                constraintWidget4.mBottom.setGoneMargin(this.mPaddingBottom);
                            }
                        }
                        if (constraintWidget6 == constraintWidget5) {
                            constraintWidget4 = constraintWidget6;
                        } else if (z6) {
                            int i13 = Flow.this.mHorizontalAlign;
                            if (i13 == 0) {
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            } else if (i13 == 1) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                            } else if (i13 == 2) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            }
                            constraintWidget4 = constraintWidget6;
                        } else {
                            int i14 = Flow.this.mHorizontalAlign;
                            if (i14 == 0) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                            } else if (i14 == 1) {
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            } else if (i14 == 2) {
                                if (z8) {
                                    constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                }
                            }
                            constraintWidget4 = constraintWidget6;
                        }
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.biggest;
            constraintWidget7.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i15 = this.mPaddingTop;
            if (i > 0) {
                i15 += Flow.this.mVerticalGap;
            }
            constraintWidget7.mTop.connect(this.mTop, i15);
            if (z7) {
                constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget7.mTop, 0);
            }
            char c6 = 3;
            if (Flow.this.mVerticalAlign != 3 || constraintWidget7.hasBaseline()) {
                constraintWidget = constraintWidget7;
            } else {
                for (int i16 = 0; i16 < i4; i16++) {
                    int i17 = z6 ? (i4 - 1) - i16 : i16;
                    if (this.mStartIndex + i17 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i17];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget7;
            }
            int i18 = 0;
            while (i18 < i4) {
                int i19 = z6 ? (i4 - 1) - i18 : i18;
                if (this.mStartIndex + i19 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget8 = Flow.this.mDisplayedWidgets[this.mStartIndex + i19];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                    c = c6;
                } else {
                    if (i18 == 0) {
                        i3 = 1;
                        constraintWidget8.connect(constraintWidget8.mLeft, this.mLeft, this.mPaddingLeft);
                    } else {
                        i3 = 1;
                    }
                    if (i19 == 0) {
                        int i20 = Flow.this.mHorizontalStyle;
                        float f9 = Flow.this.mHorizontalBias;
                        if (z6) {
                            f9 = 1.0f - f9;
                        }
                        if (this.mStartIndex != 0 || Flow.this.mFirstHorizontalStyle == -1) {
                            if (z7 && Flow.this.mLastHorizontalStyle != -1) {
                                i20 = Flow.this.mLastHorizontalStyle;
                                if (z6) {
                                    f7 = Flow.this.mLastHorizontalBias;
                                    f6 = 1.0f - f7;
                                    f9 = f6;
                                } else {
                                    f6 = Flow.this.mLastHorizontalBias;
                                    f9 = f6;
                                }
                            }
                            constraintWidget8.setHorizontalChainStyle(i20);
                            constraintWidget8.setHorizontalBiasPercent(f9);
                        } else {
                            i20 = Flow.this.mFirstHorizontalStyle;
                            if (z6) {
                                f7 = Flow.this.mFirstHorizontalBias;
                                f6 = 1.0f - f7;
                                f9 = f6;
                                constraintWidget8.setHorizontalChainStyle(i20);
                                constraintWidget8.setHorizontalBiasPercent(f9);
                            } else {
                                f6 = Flow.this.mFirstHorizontalBias;
                                f9 = f6;
                                constraintWidget8.setHorizontalChainStyle(i20);
                                constraintWidget8.setHorizontalBiasPercent(f9);
                            }
                        }
                    }
                    if (i18 == i4 - 1) {
                        constraintWidget8.connect(constraintWidget8.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.mLeft.connect(constraintWidget4.mRight, Flow.this.mHorizontalGap);
                        if (i18 == i6) {
                            constraintWidget8.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget4.mRight.connect(constraintWidget8.mLeft, 0);
                        if (i18 == i7 + 1) {
                            constraintWidget4.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        c = 3;
                        if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget8 != constraintWidget && constraintWidget8.hasBaseline()) {
                            constraintWidget8.mBaseline.connect(constraintWidget.mBaseline, 0);
                        } else {
                            int i21 = Flow.this.mVerticalAlign;
                            if (i21 == 0) {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                            } else if (i21 == i3) {
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            } else if (z8) {
                                constraintWidget8.mTop.connect(this.mTop, this.mPaddingTop);
                                constraintWidget8.mBottom.connect(this.mBottom, this.mPaddingBottom);
                            } else {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            }
                        }
                    } else {
                        c = 3;
                    }
                }
                i18++;
                c6 = c;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i) {
            int i3 = this.mNbMatchConstraintsWidgets;
            if (i3 == 0) {
                return;
            }
            int i4 = this.mCount;
            int i5 = i / i3;
            for (int i6 = 0; i6 < i4 && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i7 = i5;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i7);
                    i5 = i7;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i3;
            this.mPaddingTop = i4;
            this.mPaddingRight = i5;
            this.mPaddingBottom = i6;
            this.mMax = i7;
        }
    }

    private void createAlignedConstraints(boolean z6) {
        ConstraintWidget constraintWidget;
        float f6;
        int i;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i3 = 0; i3 < this.mDisplayedWidgetsCount; i3++) {
            this.mDisplayedWidgets[i3].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i4 = iArr[0];
        int i5 = iArr[1];
        float f7 = this.mHorizontalBias;
        ConstraintWidget constraintWidget2 = null;
        int i6 = 0;
        while (i6 < i4) {
            if (z6) {
                i = (i4 - i6) - 1;
                f6 = 1.0f - this.mHorizontalBias;
            } else {
                f6 = f7;
                i = i6;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i6 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f6);
                }
                if (i6 == i4 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i6 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i6++;
            f7 = f6;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i7];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i7 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i7 == i5 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i7 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = (i9 * i4) + i8;
                if (this.mOrientation == 1) {
                    i10 = (i8 * i5) + i9;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i10 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i10]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i8];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i9];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i4 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
                }
                return i4;
            }
            constraintWidget2 = constraintWidget;
            if (i3 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i4 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i4;
            }
            constraintWidget2 = constraintWidget;
            if (i3 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i, int i3, int i4, int[] iArr) {
        int i5;
        Flow flow;
        int i6;
        ConstraintAnchor constraintAnchor;
        int i7;
        Flow flow2 = this;
        if (i == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i8 = i4;
        WidgetsList widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
        flow2.mChainList.add(widgetsList);
        if (i3 == 0) {
            i5 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i10];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i8);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i11 = i5;
                boolean z6 = (i9 == i8 || (flow2.mHorizontalGap + i9) + widgetWidth > i8) && widgetsList.biggest != null;
                if (!z6 && i10 > 0 && (i7 = flow2.mMaxElementsWrap) > 0 && i10 % i7 == 0) {
                    z6 = true;
                }
                if (z6) {
                    widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
                    widgetsList.setStartIndex(i10);
                    flow2.mChainList.add(widgetsList);
                } else {
                    if (i10 > 0) {
                        i9 = flow2.mHorizontalGap + widgetWidth + i9;
                    }
                    widgetsList.add(constraintWidget);
                    i10++;
                    i5 = i11;
                }
                i9 = widgetWidth;
                widgetsList.add(constraintWidget);
                i10++;
                i5 = i11;
            }
        } else {
            i5 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i13 < i) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i13];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i8);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i14 = i5;
                boolean z7 = (i12 == i8 || (flow2.mVerticalGap + i12) + widgetHeight > i8) && widgetsList.biggest != null;
                if (!z7 && i13 > 0 && (i6 = flow2.mMaxElementsWrap) > 0 && i13 % i6 == 0) {
                    z7 = true;
                }
                if (z7) {
                    widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
                    flow = flow2;
                    widgetsList.setStartIndex(i13);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i13 > 0) {
                        i12 = flow.mVerticalGap + widgetHeight + i12;
                    }
                    widgetsList.add(constraintWidget2);
                    i13++;
                    i8 = i4;
                    i5 = i14;
                    flow2 = flow;
                }
                i12 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i13++;
                i8 = i4;
                i5 = i14;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z8 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i5 > 0 && z8) {
            for (int i15 = 0; i15 < size; i15++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i15);
                if (i3 == 0) {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int paddingBottom2 = paddingBottom;
        int i16 = 0;
        int paddingRight2 = paddingRight;
        int i17 = paddingTop;
        int i18 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i19 = 0;
        for (int i20 = 0; i20 < size; i20++) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i20);
            if (i3 == 0) {
                if (i20 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i20 + 1).biggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.biggest.mBottom;
                int i21 = i19;
                widgetsList3.setup(i3, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i18, i17, paddingRight2, paddingBottom2, i4);
                int iMax = Math.max(i16, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i21;
                if (i20 > 0) {
                    height += flow3.mVerticalGap;
                }
                i19 = height;
                i16 = iMax;
                constraintAnchor9 = constraintAnchor10;
                i17 = 0;
            } else {
                int i22 = i16;
                int i23 = i19;
                if (i20 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i20 + 1).biggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i3, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i18, i17, paddingRight2, paddingBottom2, i4);
                int width = widgetsList3.getWidth() + i22;
                int iMax2 = Math.max(i23, widgetsList3.getHeight());
                if (i20 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i24 = width;
                i19 = iMax2;
                i16 = i24;
                i18 = 0;
                constraintAnchor6 = constraintAnchor11;
            }
        }
        iArr[0] = i16;
        iArr[1] = i19;
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i, int i3, int i4, int[] iArr) {
        int i5;
        Flow flow;
        int i6;
        boolean z6;
        ConstraintAnchor constraintAnchor;
        int i7;
        Flow flow2 = this;
        if (i == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i8 = i4;
        WidgetsList widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
        flow2.mChainList.add(widgetsList);
        boolean z7 = true;
        if (i3 == 0) {
            int i9 = 0;
            i5 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i11 < i) {
                int i12 = i9 + 1;
                ConstraintWidget constraintWidget = constraintWidgetArr[i11];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i8);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i13 = i5;
                boolean z8 = (i10 == i8 || (flow2.mHorizontalGap + i10) + widgetWidth > i8) && widgetsList.biggest != null;
                if (!z8 && i11 > 0 && (i7 = flow2.mMaxElementsWrap) > 0 && i12 > i7) {
                    z8 = true;
                }
                if (z8) {
                    widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
                    widgetsList.setStartIndex(i11);
                    flow2.mChainList.add(widgetsList);
                    i9 = i12;
                    i10 = widgetWidth;
                } else {
                    i10 = i11 > 0 ? flow2.mHorizontalGap + widgetWidth + i10 : widgetWidth;
                    i9 = 0;
                }
                widgetsList.add(constraintWidget);
                i11++;
                i5 = i13;
            }
        } else {
            int i14 = 0;
            i5 = 0;
            int i15 = 0;
            while (i15 < i) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i15];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i8);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i16 = i5;
                boolean z9 = (i14 == i8 || (flow2.mVerticalGap + i14) + widgetHeight > i8) && widgetsList.biggest != null;
                if (!z9 && i15 > 0 && (i6 = flow2.mMaxElementsWrap) > 0 && i6 < 0) {
                    z9 = true;
                }
                if (z9) {
                    widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
                    flow = flow2;
                    widgetsList.setStartIndex(i15);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i15 > 0) {
                        i14 = flow.mVerticalGap + widgetHeight + i14;
                    }
                    widgetsList.add(constraintWidget2);
                    i15++;
                    i8 = i4;
                    i5 = i16;
                    flow2 = flow;
                }
                i14 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i15++;
                i8 = i4;
                i5 = i16;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z10 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i5 > 0 && z10) {
            for (int i17 = 0; i17 < size; i17++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i17);
                if (i3 == 0) {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor3;
        int paddingBottom2 = paddingBottom;
        int i18 = 0;
        int i19 = 0;
        int paddingRight2 = paddingRight;
        int i20 = paddingTop;
        int i21 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor2;
        int i22 = 0;
        while (i19 < size) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i19);
            if (i3 == 0) {
                if (i19 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i19 + 1).biggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                z6 = z7;
                ConstraintAnchor constraintAnchor10 = widgetsList3.biggest.mBottom;
                int i23 = i18;
                widgetsList3.setup(i3, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i21, i20, paddingRight2, paddingBottom2, i4);
                int iMax = Math.max(i22, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i23;
                if (i19 > 0) {
                    height += flow3.mVerticalGap;
                }
                i18 = height;
                i22 = iMax;
                constraintAnchor6 = constraintAnchor10;
                i20 = 0;
            } else {
                int i24 = i22;
                z6 = z7;
                int i25 = i18;
                if (i19 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i19 + 1).biggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i3, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i21, i20, paddingRight2, paddingBottom2, i4);
                int width = widgetsList3.getWidth() + i24;
                int iMax2 = Math.max(i25, widgetsList3.getHeight());
                if (i19 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i26 = width;
                i18 = iMax2;
                i22 = i26;
                i21 = 0;
                constraintAnchor9 = constraintAnchor11;
            }
            i19++;
            z7 = z6;
        }
        iArr[0] = i22;
        iArr[z7 ? 1 : 0] = i18;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i, int i3, int i4, int[] iArr) {
        WidgetsList widgetsList;
        if (i == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i4);
            widgetsList = widgetsList2;
        }
        for (int i5 = 0; i5 < i; i5++) {
            widgetsList.add(constraintWidgetArr[i5]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z6) {
        super.addToSolver(linearSystem, z6);
        boolean z7 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i3 = 0;
                while (i3 < size) {
                    this.mChainList.get(i3).createConstraints(z7, i3, i3 == size + (-1));
                    i3++;
                }
            } else if (i == 2) {
                createAlignedConstraints(z7);
            } else if (i == 3) {
                int size2 = this.mChainList.size();
                int i4 = 0;
                while (i4 < size2) {
                    this.mChainList.get(i4).createConstraints(z7, i4, i4 == size2 + (-1));
                    i4++;
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z7, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i3, int i4, int i5) {
        int i6;
        ConstraintWidget[] constraintWidgetArr;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i7 = (i3 - paddingLeft) - paddingRight;
        int i8 = this.mOrientation;
        if (i8 == 1) {
            i7 = (i5 - paddingTop) - paddingBottom;
        }
        int i9 = i7;
        if (i8 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i6 = this.mWidgetsCount;
            if (i10 >= i6) {
                break;
            }
            if (this.mWidgets[i10].getVisibility() == 8) {
                i11++;
            }
            i10++;
        }
        if (i11 > 0) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[i6 - i11];
            int i12 = 0;
            i6 = 0;
            while (i12 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget = this.mWidgets[i12];
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr4[i6] = constraintWidget;
                    i6++;
                }
                i12++;
                constraintWidgetArr3 = constraintWidgetArr4;
            }
            constraintWidgetArr = constraintWidgetArr3;
        } else {
            constraintWidgetArr = constraintWidgetArr2;
        }
        int i13 = i6;
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i13;
        int i14 = this.mWrapMode;
        if (i14 == 0) {
            measureNoWrap(constraintWidgetArr, i13, this.mOrientation, i9, iArr);
        } else if (i14 == 1) {
            measureChainWrap(constraintWidgetArr, i13, this.mOrientation, i9, iArr);
        } else if (i14 == 2) {
            measureAligned(constraintWidgetArr, i13, this.mOrientation, i9, iArr);
        } else if (i14 == 3) {
            measureChainWrap_new(constraintWidgetArr, i13, this.mOrientation, i9, iArr);
        }
        int iMin = iArr[0] + paddingLeft + paddingRight;
        int iMin2 = iArr[1] + paddingTop + paddingBottom;
        if (i == 1073741824) {
            iMin = i3;
        } else if (i == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i3);
        } else if (i != 0) {
            iMin = 0;
        }
        if (i4 == 1073741824) {
            iMin2 = i5;
        } else if (i4 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i5);
        } else if (i4 != 0) {
            iMin2 = 0;
        }
        setMeasure(iMin, iMin2);
        setWidth(iMin);
        setHeight(iMin2);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }

    public void setFirstHorizontalBias(float f6) {
        this.mFirstHorizontalBias = f6;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalBias(float f6) {
        this.mFirstVerticalBias = f6;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setHorizontalBias(float f6) {
        this.mHorizontalBias = f6;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setLastHorizontalBias(float f6) {
        this.mLastHorizontalBias = f6;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalBias(float f6) {
        this.mLastVerticalBias = f6;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setVerticalBias(float f6) {
        this.mVerticalBias = f6;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }
}
