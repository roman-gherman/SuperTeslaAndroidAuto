package com.google.crypto.tink;

import G0.A1;
import G0.C0073m1;
import G0.C0076n1;
import G0.C0079o1;
import G0.EnumC0052f1;
import G0.p1;
import G0.q1;
import G0.r1;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2806a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static r1 a(C0076n1 c0076n1) {
        C0079o1 c0079o1W = r1.w();
        int primaryKeyId = c0076n1.getPrimaryKeyId();
        c0079o1W.p();
        r1.t((r1) c0079o1W.b, primaryKeyId);
        for (C0073m1 c0073m1 : c0076n1.getKeyList()) {
            p1 p1VarX = q1.x();
            String typeUrl = c0073m1.getKeyData().getTypeUrl();
            p1VarX.p();
            q1.t((q1) p1VarX.b, typeUrl);
            EnumC0052f1 status = c0073m1.getStatus();
            p1VarX.p();
            q1.v((q1) p1VarX.b, status);
            A1 outputPrefixType = c0073m1.getOutputPrefixType();
            p1VarX.p();
            q1.u((q1) p1VarX.b, outputPrefixType);
            int keyId = c0073m1.getKeyId();
            p1VarX.p();
            q1.w((q1) p1VarX.b, keyId);
            q1 q1Var = (q1) p1VarX.build();
            c0079o1W.p();
            r1.u((r1) c0079o1W.b, q1Var);
        }
        return (r1) c0079o1W.build();
    }
}
