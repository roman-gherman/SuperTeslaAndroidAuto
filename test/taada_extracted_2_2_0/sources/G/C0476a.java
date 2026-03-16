package g;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: renamed from: g.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0476a extends RuntimeException {
    private StringBuffer context;

    public C0476a(String str, Throwable th) {
        super(str == null ? th != null ? th.getMessage() : null : str, th);
        if (!(th instanceof C0476a)) {
            this.context = new StringBuffer(200);
            return;
        }
        String string = ((C0476a) th).context.toString();
        StringBuffer stringBuffer = new StringBuffer(string.length() + 200);
        this.context = stringBuffer;
        stringBuffer.append(string);
    }

    public static C0476a withContext(Throwable th, String str) {
        C0476a c0476a = th instanceof C0476a ? (C0476a) th : new C0476a(null, th);
        c0476a.addContext(str);
        return c0476a;
    }

    public void addContext(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.context.append(str);
        if (str.endsWith("\n")) {
            return;
        }
        this.context.append('\n');
    }

    public String getContext() {
        return this.context.toString();
    }

    public void printContext(PrintStream printStream) {
        printStream.println(getMessage());
        printStream.print(this.context);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.context);
    }

    public void printContext(PrintWriter printWriter) {
        printWriter.println(getMessage());
        printWriter.print(this.context);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.context);
    }
}
