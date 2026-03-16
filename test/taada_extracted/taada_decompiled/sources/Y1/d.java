package y1;

import com.google.gson.internal.s;
import com.google.gson.m;
import com.google.gson.q;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5131a;
    public final /* synthetic */ OutputStreamWriter b;
    public final /* synthetic */ g c;

    public d(OutputStreamWriter outputStreamWriter, g gVar) {
        this.b = outputStreamWriter;
        this.c = gVar;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws IOException {
        Writer sVar;
        Writer sVar2;
        int i = this.f5131a;
        this.f5131a = i + 1;
        if (i < 0) {
            throw new ArithmeticException("Index overflow has happened");
        }
        OutputStreamWriter outputStreamWriter = this.b;
        if (i > 0) {
            outputStreamWriter.write(44);
        }
        m mVar = this.c.f5134a;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            if (outputStreamWriter != null) {
                sVar2 = outputStreamWriter;
            } else {
                try {
                    sVar2 = new s(outputStreamWriter);
                } catch (IOException e) {
                    throw new q(e);
                }
            }
            mVar.j(obj, cls, mVar.g(sVar2));
        } else {
            if (outputStreamWriter != null) {
                sVar = outputStreamWriter;
            } else {
                try {
                    sVar = new s(outputStreamWriter);
                } catch (IOException e6) {
                    throw new q(e6);
                }
            }
            mVar.i(mVar.g(sVar));
        }
        outputStreamWriter.flush();
        return N1.m.f1129a;
    }
}
