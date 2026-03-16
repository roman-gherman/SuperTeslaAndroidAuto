package net.bytebuddy.jar.asm;

/* JADX INFO: loaded from: classes2.dex */
final class CurrentFrame extends Frame {
    public CurrentFrame(Label label) {
        super(label);
    }

    @Override // net.bytebuddy.jar.asm.Frame
    public void execute(int i, int i3, Symbol symbol, SymbolTable symbolTable) {
        super.execute(i, i3, symbol, symbolTable);
        Frame frame = new Frame(null);
        merge(symbolTable, frame, 0);
        copyFrom(frame);
    }
}
