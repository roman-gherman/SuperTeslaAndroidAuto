package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    public static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            this.mConstraintID = -1;
            this.mIsLayout = false;
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
                        this.mIsLayout = true;
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
        int mId;
        boolean mIsLayout;
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
            this.mIsLayout = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
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

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void load(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L10:
            if (r3 >= r1) goto L25
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L22
            int r5 = r8.mDefaultState
            int r4 = r0.getResourceId(r4, r5)
            r8.mDefaultState = r4
        L22:
            int r3 = r3 + 1
            goto L10
        L25:
            r0.recycle()
            int r0 = r10.getEventType()     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            r1 = 0
        L2d:
            r3 = 1
            if (r0 == r3) goto Laa
            if (r0 == 0) goto L9b
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L4c
            if (r0 == r5) goto L3c
            goto L9e
        L3c:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            boolean r0 = r4.equals(r0)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            if (r0 == 0) goto L9e
            goto Laa
        L48:
            r9 = move-exception
            goto La3
        L4a:
            r9 = move-exception
            goto La7
        L4c:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            int r7 = r0.hashCode()     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            switch(r7) {
                case 80204913: goto L73;
                case 1301459538: goto L69;
                case 1382829617: goto L62;
                case 1901439077: goto L58;
                default: goto L57;
            }     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
        L57:
            goto L7d
        L58:
            java.lang.String r3 = "Variant"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            if (r0 == 0) goto L7d
            r3 = r5
            goto L7e
        L62:
            boolean r0 = r0.equals(r4)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            if (r0 == 0) goto L7d
            goto L7e
        L69:
            java.lang.String r3 = "LayoutDescription"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            if (r0 == 0) goto L7d
            r3 = r2
            goto L7e
        L73:
            java.lang.String r3 = "State"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            if (r0 == 0) goto L7d
            r3 = r6
            goto L7e
        L7d:
            r3 = -1
        L7e:
            if (r3 == r6) goto L8e
            if (r3 == r5) goto L83
            goto L9e
        L83:
            androidx.constraintlayout.widget.StateSet$Variant r0 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            r0.<init>(r9, r10)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            if (r1 == 0) goto L9e
            r1.add(r0)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            goto L9e
        L8e:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            r1.<init>(r9, r10)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r0 = r8.mStateList     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            int r3 = r1.mId     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            r0.put(r3, r1)     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            goto L9e
        L9b:
            r10.getName()     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
        L9e:
            int r0 = r10.next()     // Catch: java.io.IOException -> L48 org.xmlpull.v1.XmlPullParserException -> L4a
            goto L2d
        La3:
            r9.printStackTrace()
            goto Laa
        La7:
            r9.printStackTrace()
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int convertToConstraintSet(int i, int i3, float f6, float f7) {
        State state = this.mStateList.get(i3);
        if (state == null) {
            return i3;
        }
        if (f6 != -1.0f && f7 != -1.0f) {
            Variant variant = null;
            for (Variant variant2 : state.mVariants) {
                if (variant2.match(f6, f7)) {
                    if (i != variant2.mConstraintID) {
                        variant = variant2;
                    }
                }
            }
            return variant != null ? variant.mConstraintID : state.mConstraintID;
        }
        if (state.mConstraintID != i) {
            Iterator<Variant> it = state.mVariants.iterator();
            while (it.hasNext()) {
                if (i == it.next().mConstraintID) {
                }
            }
            return state.mConstraintID;
        }
        return i;
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

    public int stateGetConstraintID(int i, int i3, int i4) {
        return updateConstraints(-1, i, i3, i4);
    }

    public int updateConstraints(int i, int i3, float f6, float f7) {
        int iFindMatch;
        if (i == i3) {
            State stateValueAt = i3 == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(this.mCurrentStateId);
            if (stateValueAt == null) {
                return -1;
            }
            return ((this.mCurrentConstraintNumber == -1 || !stateValueAt.mVariants.get(i).match(f6, f7)) && i != (iFindMatch = stateValueAt.findMatch(f6, f7))) ? iFindMatch == -1 ? stateValueAt.mConstraintID : stateValueAt.mVariants.get(iFindMatch).mConstraintID : i;
        }
        State state = this.mStateList.get(i3);
        if (state == null) {
            return -1;
        }
        int iFindMatch2 = state.findMatch(f6, f7);
        return iFindMatch2 == -1 ? state.mConstraintID : state.mVariants.get(iFindMatch2).mConstraintID;
    }
}
