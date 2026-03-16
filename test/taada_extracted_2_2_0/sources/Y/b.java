package Y;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.o;
import fr.sd.taada.R;
import java.io.IOException;
import java.util.Locale;
import k0.AbstractC0573c;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BadgeState$State f1470a;
    public final BadgeState$State b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f1471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f1472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f1473h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1476l;

    public b(Context context, BadgeState$State badgeState$State) {
        AttributeSet attributeSet;
        int styleAttribute;
        int next;
        BadgeState$State badgeState$State2 = new BadgeState$State();
        badgeState$State2.i = 255;
        badgeState$State2.f2189j = -2;
        badgeState$State2.f2190k = -2;
        badgeState$State2.q = Boolean.TRUE;
        this.b = badgeState$State2;
        int i = badgeState$State.f2185a;
        if (i != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                attributeSet = attributeSetAsAttributeSet;
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(androidx.constraintlayout.core.motion.a.h(i, new StringBuilder("Can't load badge resource ID #0x")));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayD = o.d(context, attributeSet, V.a.f1352a, R.attr.badgeStyle, styleAttribute == 0 ? R.style.Widget_MaterialComponents_Badge : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.c = typedArrayD.getDimensionPixelSize(3, -1);
        this.i = typedArrayD.getDimensionPixelSize(8, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        this.f1474j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.f1475k = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.d = typedArrayD.getDimensionPixelSize(11, -1);
        this.e = typedArrayD.getDimension(9, resources.getDimension(R.dimen.m3_badge_size));
        this.f1472g = typedArrayD.getDimension(14, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f1471f = typedArrayD.getDimension(2, resources.getDimension(R.dimen.m3_badge_size));
        this.f1473h = typedArrayD.getDimension(10, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f1476l = typedArrayD.getInt(19, 1);
        BadgeState$State badgeState$State3 = this.b;
        int i3 = badgeState$State.i;
        badgeState$State3.i = i3 == -2 ? 255 : i3;
        CharSequence charSequence = badgeState$State.f2192m;
        badgeState$State3.f2192m = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        BadgeState$State badgeState$State4 = this.b;
        int i4 = badgeState$State.f2193n;
        badgeState$State4.f2193n = i4 == 0 ? R.plurals.mtrl_badge_content_description : i4;
        int i5 = badgeState$State.f2194o;
        badgeState$State4.f2194o = i5 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i5;
        Boolean bool = badgeState$State.q;
        badgeState$State4.q = Boolean.valueOf(bool == null || bool.booleanValue());
        BadgeState$State badgeState$State5 = this.b;
        int i6 = badgeState$State.f2190k;
        badgeState$State5.f2190k = i6 == -2 ? typedArrayD.getInt(17, 4) : i6;
        int i7 = badgeState$State.f2189j;
        if (i7 != -2) {
            this.b.f2189j = i7;
        } else if (typedArrayD.hasValue(18)) {
            this.b.f2189j = typedArrayD.getInt(18, 0);
        } else {
            this.b.f2189j = -1;
        }
        BadgeState$State badgeState$State6 = this.b;
        Integer num = badgeState$State.e;
        badgeState$State6.e = Integer.valueOf(num == null ? typedArrayD.getResourceId(4, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        BadgeState$State badgeState$State7 = this.b;
        Integer num2 = badgeState$State.f2186f;
        badgeState$State7.f2186f = Integer.valueOf(num2 == null ? typedArrayD.getResourceId(5, 0) : num2.intValue());
        BadgeState$State badgeState$State8 = this.b;
        Integer num3 = badgeState$State.f2187g;
        badgeState$State8.f2187g = Integer.valueOf(num3 == null ? typedArrayD.getResourceId(12, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        BadgeState$State badgeState$State9 = this.b;
        Integer num4 = badgeState$State.f2188h;
        badgeState$State9.f2188h = Integer.valueOf(num4 == null ? typedArrayD.getResourceId(13, 0) : num4.intValue());
        BadgeState$State badgeState$State10 = this.b;
        Integer num5 = badgeState$State.b;
        badgeState$State10.b = Integer.valueOf(num5 == null ? AbstractC0573c.a(context, typedArrayD, 0).getDefaultColor() : num5.intValue());
        BadgeState$State badgeState$State11 = this.b;
        Integer num6 = badgeState$State.d;
        badgeState$State11.d = Integer.valueOf(num6 == null ? typedArrayD.getResourceId(6, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = badgeState$State.c;
        if (num7 != null) {
            this.b.c = num7;
        } else if (typedArrayD.hasValue(7)) {
            this.b.c = Integer.valueOf(AbstractC0573c.a(context, typedArrayD, 7).getDefaultColor());
        } else {
            int iIntValue = this.b.d.intValue();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iIntValue, V.a.E);
            typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
            ColorStateList colorStateListA = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 3);
            AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 4);
            AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 5);
            typedArrayObtainStyledAttributes.getInt(2, 0);
            typedArrayObtainStyledAttributes.getInt(1, 1);
            int i8 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
            typedArrayObtainStyledAttributes.getResourceId(i8, 0);
            typedArrayObtainStyledAttributes.getString(i8);
            typedArrayObtainStyledAttributes.getBoolean(14, false);
            AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 6);
            typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iIntValue, V.a.u);
            typedArrayObtainStyledAttributes2.hasValue(0);
            typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
            this.b.c = Integer.valueOf(colorStateListA.getDefaultColor());
        }
        BadgeState$State badgeState$State12 = this.b;
        Integer num8 = badgeState$State.f2195p;
        badgeState$State12.f2195p = Integer.valueOf(num8 == null ? typedArrayD.getInt(1, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END) : num8.intValue());
        BadgeState$State badgeState$State13 = this.b;
        Integer num9 = badgeState$State.f2196r;
        badgeState$State13.f2196r = Integer.valueOf(num9 == null ? typedArrayD.getDimensionPixelOffset(15, 0) : num9.intValue());
        BadgeState$State badgeState$State14 = this.b;
        Integer num10 = badgeState$State.f2197s;
        badgeState$State14.f2197s = Integer.valueOf(num10 == null ? typedArrayD.getDimensionPixelOffset(20, 0) : num10.intValue());
        BadgeState$State badgeState$State15 = this.b;
        Integer num11 = badgeState$State.f2198t;
        badgeState$State15.f2198t = Integer.valueOf(num11 == null ? typedArrayD.getDimensionPixelOffset(16, badgeState$State15.f2196r.intValue()) : num11.intValue());
        BadgeState$State badgeState$State16 = this.b;
        Integer num12 = badgeState$State.u;
        badgeState$State16.u = Integer.valueOf(num12 == null ? typedArrayD.getDimensionPixelOffset(21, badgeState$State16.f2197s.intValue()) : num12.intValue());
        BadgeState$State badgeState$State17 = this.b;
        Integer num13 = badgeState$State.f2199v;
        badgeState$State17.f2199v = Integer.valueOf(num13 == null ? 0 : num13.intValue());
        BadgeState$State badgeState$State18 = this.b;
        Integer num14 = badgeState$State.f2200w;
        badgeState$State18.f2200w = Integer.valueOf(num14 != null ? num14.intValue() : 0);
        typedArrayD.recycle();
        Locale locale = badgeState$State.f2191l;
        if (locale == null) {
            this.b.f2191l = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            this.b.f2191l = locale;
        }
        this.f1470a = badgeState$State;
    }

    public final boolean a() {
        return this.b.f2189j != -1;
    }
}
