package s1;

import N1.m;
import U1.g;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: s1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0808a extends g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4757a;
    public ByteReadChannel b;
    public Function3 c;
    public Object d;
    public byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4760h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f4761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Long f4762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ByteReadChannel f4763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Function3 f4764m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0808a(Long l6, ByteReadChannel byteReadChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f4762k = l6;
        this.f4763l = byteReadChannel;
        this.f4764m = function3;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        C0808a c0808a = new C0808a(this.f4762k, this.f4763l, this.f4764m, continuation);
        c0808a.f4761j = obj;
        return c0808a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0808a) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc A[Catch: all -> 0x00c2, TryCatch #3 {all -> 0x00c2, blocks: (B:41:0x00d6, B:43:0x00dc, B:46:0x00f8, B:58:0x015f, B:62:0x0170, B:32:0x00b6, B:35:0x00bd), top: B:77:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015f A[Catch: all -> 0x00c2, TRY_ENTER, TryCatch #3 {all -> 0x00c2, blocks: (B:41:0x00d6, B:43:0x00dc, B:46:0x00f8, B:58:0x015f, B:62:0x0170, B:32:0x00b6, B:35:0x00bd), top: B:77:0x00b6 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x014e -> B:55:0x0156). Please report as a decompilation issue!!! */
    @Override // U1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.C0808a.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
