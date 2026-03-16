package u1;

import kotlin.jvm.functions.Function1;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: renamed from: u1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0836a extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StringBuilder f4858a;
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0836a(StringBuilder sb, boolean z6) {
        super(1);
        this.f4858a = sb;
        this.b = z6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte bByteValue = ((Number) obj).byteValue();
        boolean zContains = AbstractC0837b.f4859a.contains(Byte.valueOf(bByteValue));
        StringBuilder sb = this.f4858a;
        if (zContains || AbstractC0837b.d.contains(Byte.valueOf(bByteValue))) {
            sb.append((char) bByteValue);
        } else if (this.b && bByteValue == 32) {
            sb.append(SignatureVisitor.EXTENDS);
        } else {
            sb.append(AbstractC0837b.a(bByteValue));
        }
        return N1.m.f1129a;
    }
}
