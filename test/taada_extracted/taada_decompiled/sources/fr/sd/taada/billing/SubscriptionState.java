package fr.sd.taada.billing;

/* JADX INFO: loaded from: classes2.dex */
public enum SubscriptionState {
    NO_SUBSCRIPTION("Aucun abonnement"),
    FREE_TRIAL("Essai gratuit"),
    SUBSCRIBED("Abonné"),
    LIFETIME("Accès à vie"),
    EXPIRED_IN_GRACE_PERIOD("Expiré - Période de grâce"),
    SUSPENDED("Suspendu"),
    CANCELLED("Annulé"),
    EXPIRED("Expiré"),
    CHECKING("Vérification...");

    private final String displayName;

    SubscriptionState(String str) {
        this.displayName = str;
    }

    public boolean allowsAppAccess() {
        return this == FREE_TRIAL || this == SUBSCRIBED || this == LIFETIME || this == EXPIRED_IN_GRACE_PERIOD;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean requiresUserAction() {
        return this == NO_SUBSCRIPTION || this == SUSPENDED || this == CANCELLED || this == EXPIRED;
    }
}
