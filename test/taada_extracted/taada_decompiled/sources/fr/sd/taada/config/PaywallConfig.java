package fr.sd.taada.config;

/* JADX INFO: loaded from: classes2.dex */
public class PaywallConfig {
    private String variantId = "control_default";
    private String headerTitle = null;
    private String headerSubtitle = null;
    private String monthlyTitle = null;
    private String monthlyBadge = null;
    private String monthlySubtitle = null;
    private String annualTitle = null;
    private String annualBadge = null;
    private String annualSubtitle = null;
    private String annualCallToAction = null;
    private String lifetimeTitle = null;
    private String lifetimeBadge = null;
    private String lifetimeSubtitle = null;
    private boolean showLifetimeOption = true;
    private boolean highlightAnnualPlan = true;
    private boolean showTrustBadges = true;

    public String getAnnualBadge() {
        return this.annualBadge;
    }

    public String getAnnualCallToAction() {
        return this.annualCallToAction;
    }

    public String getAnnualSubtitle() {
        return this.annualSubtitle;
    }

    public String getAnnualTitle() {
        return this.annualTitle;
    }

    public String getHeaderSubtitle() {
        return this.headerSubtitle;
    }

    public String getHeaderTitle() {
        return this.headerTitle;
    }

    public String getLifetimeBadge() {
        return this.lifetimeBadge;
    }

    public String getLifetimeSubtitle() {
        return this.lifetimeSubtitle;
    }

    public String getLifetimeTitle() {
        return this.lifetimeTitle;
    }

    public String getMonthlyBadge() {
        return this.monthlyBadge;
    }

    public String getMonthlySubtitle() {
        return this.monthlySubtitle;
    }

    public String getMonthlyTitle() {
        return this.monthlyTitle;
    }

    public String getVariantId() {
        return this.variantId;
    }

    public boolean isHighlightAnnualPlan() {
        return this.highlightAnnualPlan;
    }

    public boolean isShowLifetimeOption() {
        return this.showLifetimeOption;
    }

    public boolean isShowTrustBadges() {
        return this.showTrustBadges;
    }

    public void setAnnualBadge(String str) {
        this.annualBadge = str;
    }

    public void setAnnualCallToAction(String str) {
        this.annualCallToAction = str;
    }

    public void setAnnualSubtitle(String str) {
        this.annualSubtitle = str;
    }

    public void setAnnualTitle(String str) {
        this.annualTitle = str;
    }

    public void setHeaderSubtitle(String str) {
        this.headerSubtitle = str;
    }

    public void setHeaderTitle(String str) {
        this.headerTitle = str;
    }

    public void setHighlightAnnualPlan(boolean z6) {
        this.highlightAnnualPlan = z6;
    }

    public void setLifetimeBadge(String str) {
        this.lifetimeBadge = str;
    }

    public void setLifetimeSubtitle(String str) {
        this.lifetimeSubtitle = str;
    }

    public void setLifetimeTitle(String str) {
        this.lifetimeTitle = str;
    }

    public void setMonthlyBadge(String str) {
        this.monthlyBadge = str;
    }

    public void setMonthlySubtitle(String str) {
        this.monthlySubtitle = str;
    }

    public void setMonthlyTitle(String str) {
        this.monthlyTitle = str;
    }

    public void setShowLifetimeOption(boolean z6) {
        this.showLifetimeOption = z6;
    }

    public void setShowTrustBadges(boolean z6) {
        this.showTrustBadges = z6;
    }

    public void setVariantId(String str) {
        this.variantId = str;
    }
}
