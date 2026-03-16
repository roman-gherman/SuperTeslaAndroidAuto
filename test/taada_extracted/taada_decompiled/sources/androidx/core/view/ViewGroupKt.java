package androidx.core.view;

import N1.m;
import android.view.View;
import android.view.ViewGroup;
import e2.C0430f;
import java.util.Iterator;
import k3.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\r\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\u0007*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0007*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0010\u0010\u000f\u001a7\u0010\u0015\u001a\u00020\n*\u00020\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0011H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016\u001aL\u0010\u0018\u001a\u00020\n*\u00020\u000026\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0017H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001f\u001a\u00020\n*\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u001f\u0010 \u001a<\u0010%\u001a\u00020\n*\u00020\u001d2\b\b\u0003\u0010!\u001a\u00020\u00012\b\b\u0003\u0010\"\u001a\u00020\u00012\b\b\u0003\u0010#\u001a\u00020\u00012\b\b\u0003\u0010$\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b%\u0010&\u001a<\u0010)\u001a\u00020\n*\u00020\u001d2\b\b\u0003\u0010'\u001a\u00020\u00012\b\b\u0003\u0010\"\u001a\u00020\u00012\b\b\u0003\u0010(\u001a\u00020\u00012\b\b\u0003\u0010$\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b)\u0010&\"\u0016\u0010\u001e\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0016\u0010/\u001a\u00020,*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u001b\u00103\u001a\b\u0012\u0004\u0012\u00020\u000300*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b1\u00102\"\u001b\u00105\u001a\b\u0012\u0004\u0012\u00020\u000300*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b4\u00102¨\u00066"}, d2 = {"Landroid/view/ViewGroup;", "", "index", "Landroid/view/View;", "get", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "view", "", "contains", "(Landroid/view/ViewGroup;Landroid/view/View;)Z", "LN1/m;", "plusAssign", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "minusAssign", "isEmpty", "(Landroid/view/ViewGroup;)Z", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "forEachIndexed", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "", "iterator", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "Landroid/view/ViewGroup$MarginLayoutParams;", "size", "setMargins", "(Landroid/view/ViewGroup$MarginLayoutParams;I)V", "left", "top", "right", "bottom", "updateMargins", "(Landroid/view/ViewGroup$MarginLayoutParams;IIII)V", "start", "end", "updateMarginsRelative", "getSize", "(Landroid/view/ViewGroup;)I", "Le2/f;", "getIndices", "(Landroid/view/ViewGroup;)Le2/f;", "indices", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "children", "getDescendants", "descendants", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "", "hasNext", "()Z", "next", "()Landroid/view/View;", "LN1/m;", "remove", "()V", "", "index", "I", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<View>, KMutableIterator {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            viewGroup.removeViewAt(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(ViewGroup viewGroup, View view) {
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, Function1<? super View, m> function1) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            function1.invoke(viewGroup.getChildAt(i));
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, Function2<? super Integer, ? super View, m> function2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            function2.mo5invoke(Integer.valueOf(i), viewGroup.getChildAt(i));
        }
    }

    public static final View get(ViewGroup viewGroup, int i) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sbJ = B2.b.j(i, "Index: ", ", Size: ");
        sbJ.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sbJ.toString());
    }

    public static final Sequence<View> getChildren(final ViewGroup viewGroup) {
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final Sequence<View> getDescendants(ViewGroup viewGroup) {
        return new n(new ViewGroupKt$descendants$1(viewGroup, null));
    }

    public static final C0430f getIndices(ViewGroup viewGroup) {
        return E1.k.s0(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i3, int i4, int i5) {
        marginLayoutParams.setMargins(i, i3, i4, i5);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i, i3, i4, i5);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i3, int i4, int i5) {
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
