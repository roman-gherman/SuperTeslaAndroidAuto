package fr.sd.taada.ui.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes2.dex */
public class TeslaPricingCard extends MaterialCardView {
    private TextView badgeText;
    private CardVariant currentVariant;
    private boolean isSelected;
    private TextView planPeriod;
    private TextView planPrice;
    private TextView planSubtitle;
    private TextView planTitle;
    private ImageView selectionIndicator;

    /* JADX INFO: renamed from: fr.sd.taada.ui.components.TeslaPricingCard$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$fr$sd$taada$ui$components$TeslaPricingCard$CardVariant;

        static {
            int[] iArr = new int[CardVariant.values().length];
            $SwitchMap$fr$sd$taada$ui$components$TeslaPricingCard$CardVariant = iArr;
            try {
                iArr[CardVariant.GOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$fr$sd$taada$ui$components$TeslaPricingCard$CardVariant[CardVariant.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum CardVariant {
        DEFAULT,
        GOLD
    }

    public TeslaPricingCard(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
        this.currentVariant = CardVariant.DEFAULT;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_tesla_pricing, (ViewGroup) this, true);
        this.badgeText = (TextView) findViewById(R.id.badgeText);
        this.planTitle = (TextView) findViewById(R.id.planTitle);
        this.planPrice = (TextView) findViewById(R.id.planPrice);
        this.planPeriod = (TextView) findViewById(R.id.planPeriod);
        this.planSubtitle = (TextView) findViewById(R.id.planSubtitle);
        this.selectionIndicator = (ImageView) findViewById(R.id.selectionIndicator);
        setCardBackgroundColor(ContextCompat.getColor(context, R.color.tesla_bg_surface));
        setRadius(getResources().getDimension(R.dimen.card_corner_radius));
        setCardElevation(0.0f);
        updateSelectionState();
    }

    private void updateSelectionState() {
        int i;
        if (this.isSelected) {
            if (AnonymousClass1.$SwitchMap$fr$sd$taada$ui$components$TeslaPricingCard$CardVariant[this.currentVariant.ordinal()] != 1) {
                i = R.color.tesla_blue_primary;
                this.badgeText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.tesla_blue_primary));
                this.badgeText.setTextColor(ContextCompat.getColor(getContext(), R.color.tesla_text_primary));
            } else {
                i = R.color.tesla_gold;
                this.badgeText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.tesla_gold));
                this.badgeText.setTextColor(ContextCompat.getColor(getContext(), R.color.tesla_bg_deep_black));
            }
            setStrokeColor(ContextCompat.getColor(getContext(), i));
            setStrokeWidth((int) (getResources().getDisplayMetrics().density * 2.0f));
            setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.tesla_bg_surface_highlight));
            this.selectionIndicator.setVisibility(0);
            return;
        }
        if (this.currentVariant == CardVariant.GOLD) {
            setStrokeColor(ContextCompat.getColor(getContext(), R.color.tesla_gold));
            setStrokeWidth((int) (getResources().getDisplayMetrics().density * 1.0f));
            setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.tesla_bg_surface));
            this.badgeText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.tesla_gold));
            this.badgeText.setTextColor(ContextCompat.getColor(getContext(), R.color.tesla_bg_deep_black));
        } else {
            setStrokeColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            setStrokeWidth(0);
            setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.tesla_bg_surface));
            this.badgeText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.tesla_blue_primary));
            this.badgeText.setTextColor(ContextCompat.getColor(getContext(), R.color.tesla_text_primary));
        }
        this.selectionIndicator.setVisibility(4);
    }

    @Override // com.google.android.material.card.MaterialCardView, androidx.cardview.widget.CardView
    public float getRadius() {
        if (super.getRadius() == 0.0f) {
            return 30.0f;
        }
        return super.getRadius();
    }

    public boolean getSelectedState() {
        return this.isSelected;
    }

    public void setContent(String str, String str2, String str3, String str4, String str5) {
        this.planTitle.setText(str);
        this.planPrice.setText(str2);
        this.planPeriod.setText(str3);
        this.planSubtitle.setText(str4);
        if (str5 == null || str5.isEmpty()) {
            this.badgeText.setVisibility(8);
        } else {
            this.badgeText.setText(str5);
            this.badgeText.setVisibility(0);
        }
    }

    public void setSelectedState(boolean z6) {
        this.isSelected = z6;
        updateSelectionState();
    }

    public void setVariant(CardVariant cardVariant) {
        this.currentVariant = cardVariant;
        updateSelectionState();
    }

    public TeslaPricingCard(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
        this.currentVariant = CardVariant.DEFAULT;
        init(context);
    }

    public TeslaPricingCard(@NonNull Context context) {
        super(context, null);
        this.isSelected = false;
        this.currentVariant = CardVariant.DEFAULT;
        init(context);
    }
}
