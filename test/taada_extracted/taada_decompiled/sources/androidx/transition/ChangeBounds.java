package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static RectEvaluator sRectEvaluator = new RectEvaluator();

    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i;
            if (this.mTopLeftCalls == i) {
                setLeftTopRightBottom();
            }
        }

        public void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i;
            if (i == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(cls, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
            private Rect mBounds = new Rect();

            @Override // android.util.Property
            public PointF get(Drawable drawable) {
                drawable.copyBounds(this.mBounds);
                Rect rect = this.mBounds;
                return new PointF(rect.left, rect.top);
            }

            @Override // android.util.Property
            public void set(Drawable drawable, PointF pointF) {
                drawable.copyBounds(this.mBounds);
                this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(this.mBounds);
            }
        };
        String str = "topLeft";
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(cls, str) { // from class: androidx.transition.ChangeBounds.2
            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setTopLeft(pointF);
            }
        };
        String str2 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(cls, str2) { // from class: androidx.transition.ChangeBounds.3
            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setBottomRight(pointF);
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(cls, str2) { // from class: androidx.transition.ChangeBounds.4
            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(cls, str) { // from class: androidx.transition.ChangeBounds.5
            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>(cls, "position") { // from class: androidx.transition.ChangeBounds.6
            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public void set(View view, PointF pointF) {
                int iRound = Math.round(pointF.x);
                int iRound2 = Math.round(pointF.y);
                ViewUtils.setLeftTopRightBottom(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
            }
        };
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (!ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        if (this.mReparent) {
            transitionValues.view.getLocationInWindow(this.mTempLocation);
            transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
            transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
        }
        if (this.mResizeClip) {
            transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view));
        }
    }

    private boolean parentMatches(View view, View view2) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        return matchedTransitionValues == null ? view == view2 : view2 == matchedTransitionValues.view;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Animator animator;
        int i;
        int i3;
        Rect rect;
        View view;
        ObjectAnimator objectAnimator;
        Animator animatorMergeAnimators;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = transitionValues2.view;
        if (parentMatches(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect3 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            int i4 = rect2.left;
            final int i5 = rect3.left;
            int i6 = rect2.top;
            final int i7 = rect3.top;
            int i8 = rect2.right;
            final int i9 = rect3.right;
            int i10 = rect2.bottom;
            final int i11 = rect3.bottom;
            animator = null;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
            final Rect rect5 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i = 0;
            } else {
                i = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                if (this.mResizeClip) {
                    ViewUtils.setLeftTopRightBottom(view2, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                    ObjectAnimator objectAnimatorOfPointF = (i4 == i5 && i6 == i7) ? null : ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i4, i6, i5, i7));
                    if (rect4 == null) {
                        i3 = 0;
                        rect = new Rect(0, 0, i12, i13);
                    } else {
                        i3 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                    if (rect.equals(rect6)) {
                        view = view2;
                        objectAnimator = null;
                    } else {
                        ViewCompat.setClipBounds(view2, rect);
                        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view2, "clipBounds", sRectEvaluator, rect, rect6);
                        view = view2;
                        objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8
                            private boolean mIsCanceled;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                                this.mIsCanceled = true;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                if (this.mIsCanceled) {
                                    return;
                                }
                                ViewCompat.setClipBounds(view2, rect5);
                                ViewUtils.setLeftTopRightBottom(view2, i5, i7, i9, i11);
                            }
                        });
                        objectAnimator = objectAnimatorOfObject;
                    }
                    animatorMergeAnimators = TransitionUtils.mergeAnimators(objectAnimatorOfPointF, objectAnimator);
                } else {
                    ViewUtils.setLeftTopRightBottom(view2, i4, i6, i8, i10);
                    if (i != 2) {
                        animatorMergeAnimators = (i4 == i5 && i6 == i7) ? ObjectAnimatorUtils.ofPointF(view2, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i8, i10, i9, i11)) : ObjectAnimatorUtils.ofPointF(view2, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i4, i6, i5, i7));
                    } else if (i12 == i14 && i13 == i15) {
                        animatorMergeAnimators = ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i4, i6, i5, i7));
                    } else {
                        ViewBounds viewBounds = new ViewBounds(view2);
                        ObjectAnimator objectAnimatorOfPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i4, i6, i5, i7));
                        ObjectAnimator objectAnimatorOfPointF3 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i8, i10, i9, i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorOfPointF2, objectAnimatorOfPointF3);
                        animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7
                            private ViewBounds mViewBounds;
                            final /* synthetic */ ViewBounds val$viewBounds;

                            {
                                this.val$viewBounds = viewBounds;
                                this.mViewBounds = viewBounds;
                            }
                        });
                        animatorMergeAnimators = animatorSet;
                    }
                    view = view2;
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ViewGroupUtils.suppressLayout(viewGroup4, true);
                    addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                        boolean mCanceled = false;

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionCancel(Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                            this.mCanceled = true;
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionEnd(Transition transition) {
                            if (!this.mCanceled) {
                                ViewGroupUtils.suppressLayout(viewGroup4, false);
                            }
                            transition.removeListener(this);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionPause(Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionResume(Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, true);
                        }
                    });
                }
                return animatorMergeAnimators;
            }
        } else {
            animator = null;
            int iIntValue = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
            int iIntValue2 = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
            int iIntValue3 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
            int iIntValue4 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
            if (iIntValue != iIntValue3 || iIntValue2 != iIntValue4) {
                viewGroup.getLocationInWindow(this.mTempLocation);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                view2.draw(new Canvas(bitmapCreateBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                final float transitionAlpha = ViewUtils.getTransitionAlpha(view2);
                ViewUtils.setTransitionAlpha(view2, 0.0f);
                ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
                PathMotion pathMotion = getPathMotion();
                int[] iArr = this.mTempLocation;
                int i16 = iArr[0];
                int i17 = iArr[1];
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath(iIntValue - i16, iIntValue2 - i17, iIntValue3 - i16, iIntValue4 - i17)));
                objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        ViewUtils.getOverlay(viewGroup).remove(bitmapDrawable);
                        ViewUtils.setTransitionAlpha(view2, transitionAlpha);
                    }
                });
                return objectAnimatorOfPropertyValuesHolder;
            }
        }
        return animator;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z6) {
        this.mResizeClip = z6;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
