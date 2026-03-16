package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    ConstraintSet mDefaultConstraintSet;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    public static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            this.mConstraintID = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.mId = typedArrayObtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f6, float f7) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(f6, f7)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static class Variant {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMinWidth);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean match(float f6, float f7) {
            if (!Float.isNaN(this.mMinWidth) && f6 < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f7 < this.mMinHeight) {
                return false;
            }
            if (Float.isNaN(this.mMaxWidth) || f6 <= this.mMaxWidth) {
                return Float.isNaN(this.mMaxHeight) || f7 <= this.mMaxHeight;
            }
            return false;
        }
    }

    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        this.mConstraintLayout = constraintLayout;
        load(context, i);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void load(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r1 = 0
        Ld:
            r2 = 1
            if (r0 == r2) goto L8d
            if (r0 == 0) goto L7e
            r3 = 2
            if (r0 == r3) goto L17
            goto L81
        L17:
            java.lang.String r0 = r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            int r4 = r0.hashCode()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L50;
                case 80204913: goto L46;
                case 1382829617: goto L3d;
                case 1657696882: goto L33;
                case 1901439077: goto L25;
                default: goto L24;
            }     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
        L24:
            goto L5a
        L25:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r6
            goto L5b
        L2f:
            r8 = move-exception
            goto L86
        L31:
            r8 = move-exception
            goto L8a
        L33:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = 0
            goto L5b
        L3d:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            goto L5b
        L46:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r3
            goto L5b
        L50:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r5
            goto L5b
        L5a:
            r2 = -1
        L5b:
            if (r2 == r3) goto L71
            if (r2 == r6) goto L66
            if (r2 == r5) goto L62
            goto L81
        L62:
            r7.parseConstraintSet(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L66:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r0 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r0.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r1 == 0) goto L81
            r1.add(r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L71:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r1 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r1.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$State> r0 = r7.mStateList     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            int r2 = r1.mId     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r0.put(r2, r1)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L7e:
            r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
        L81:
            int r0 = r9.next()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto Ld
        L86:
            r8.printStackTrace()
            goto L8d
        L8a:
            r8.printStackTrace()
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.load(android.content.Context, int):void");
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(identifier, constraintSet);
                return;
            }
        }
    }

    public boolean needsToChange(int i, float f6, float f7) {
        int i3 = this.mCurrentStateId;
        if (i3 != i) {
            return true;
        }
        State stateValueAt = i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i3);
        int i4 = this.mCurrentConstraintNumber;
        return (i4 == -1 || !stateValueAt.mVariants.get(i4).match(f6, f7)) && this.mCurrentConstraintNumber != stateValueAt.findMatch(f6, f7);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public void updateConstraints(int i, float f6, float f7) {
        int iFindMatch;
        int i3 = this.mCurrentStateId;
        if (i3 != i) {
            this.mCurrentStateId = i;
            State state = this.mStateList.get(i);
            int iFindMatch2 = state.findMatch(f6, f7);
            ConstraintSet constraintSet = iFindMatch2 == -1 ? state.mConstraintSet : state.mVariants.get(iFindMatch2).mConstraintSet;
            int i4 = iFindMatch2 == -1 ? state.mConstraintID : state.mVariants.get(iFindMatch2).mConstraintID;
            if (constraintSet == null) {
                return;
            }
            this.mCurrentConstraintNumber = iFindMatch2;
            ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
            if (constraintsChangedListener != null) {
                constraintsChangedListener.preLayoutChange(i, i4);
            }
            constraintSet.applyTo(this.mConstraintLayout);
            ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
            if (constraintsChangedListener2 != null) {
                constraintsChangedListener2.postLayoutChange(i, i4);
                return;
            }
            return;
        }
        State stateValueAt = i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i3);
        int i5 = this.mCurrentConstraintNumber;
        if ((i5 == -1 || !stateValueAt.mVariants.get(i5).match(f6, f7)) && this.mCurrentConstraintNumber != (iFindMatch = stateValueAt.findMatch(f6, f7))) {
            ConstraintSet constraintSet2 = iFindMatch == -1 ? this.mDefaultConstraintSet : stateValueAt.mVariants.get(iFindMatch).mConstraintSet;
            int i6 = iFindMatch == -1 ? stateValueAt.mConstraintID : stateValueAt.mVariants.get(iFindMatch).mConstraintID;
            if (constraintSet2 == null) {
                return;
            }
            this.mCurrentConstraintNumber = iFindMatch;
            ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
            if (constraintsChangedListener3 != null) {
                constraintsChangedListener3.preLayoutChange(-1, i6);
            }
            constraintSet2.applyTo(this.mConstraintLayout);
            ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
            if (constraintsChangedListener4 != null) {
                constraintsChangedListener4.postLayoutChange(-1, i6);
            }
        }
    }
}
