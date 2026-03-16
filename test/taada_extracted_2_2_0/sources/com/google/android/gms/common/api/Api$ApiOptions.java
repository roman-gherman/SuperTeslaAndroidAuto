package com.google.android.gms.common.api;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public interface Api$ApiOptions {
    public static final a NO_OPTIONS = new a();

    public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
        Account getAccount();
    }

    public interface HasGoogleSignInAccountOptions extends HasOptions {
        GoogleSignInAccount getGoogleSignInAccount();
    }

    public interface HasOptions extends Api$ApiOptions {
    }

    public interface NotRequiredOptions extends Api$ApiOptions {
    }

    public interface Optional extends HasOptions, NotRequiredOptions {
    }
}
