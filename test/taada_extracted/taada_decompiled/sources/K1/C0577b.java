package k1;

import java.net.HttpURLConnection;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: k1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0577b extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3691a;
    public Object b;
    public C1.b c;
    public HttpURLConnection d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0578c f3692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3693g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0577b(C0578c c0578c, Continuation continuation) {
        super(continuation);
        this.f3692f = c0578c;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f3693g |= Integer.MIN_VALUE;
        return this.f3692f.execute(null, this);
    }
}
