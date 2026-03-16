package net.bytebuddy.jar.asm.signature;

/* JADX INFO: loaded from: classes2.dex */
public class SignatureReader {
    private final String signatureValue;

    public SignatureReader(String str) {
        this.signatureValue = str;
    }

    private static int parseType(String str, int i, SignatureVisitor signatureVisitor) {
        int i3;
        char cCharAt;
        int type = i + 1;
        char cCharAt2 = str.charAt(i);
        if (cCharAt2 != 'F') {
            if (cCharAt2 == 'L') {
                boolean z6 = false;
                boolean z7 = false;
                while (true) {
                    int i4 = type;
                    while (true) {
                        i3 = type + 1;
                        cCharAt = str.charAt(type);
                        if (cCharAt == '.' || cCharAt == ';') {
                            break;
                        }
                        if (cCharAt == '<') {
                            String strSubstring = str.substring(i4, type);
                            if (z7) {
                                signatureVisitor.visitInnerClassType(strSubstring);
                            } else {
                                signatureVisitor.visitClassType(strSubstring);
                            }
                            type = i3;
                            while (true) {
                                char cCharAt3 = str.charAt(type);
                                if (cCharAt3 == '>') {
                                    break;
                                }
                                if (cCharAt3 != '*') {
                                    type = (cCharAt3 == '+' || cCharAt3 == '-') ? parseType(str, type + 1, signatureVisitor.visitTypeArgument(cCharAt3)) : parseType(str, type, signatureVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF));
                                } else {
                                    type++;
                                    signatureVisitor.visitTypeArgument();
                                }
                            }
                            z6 = true;
                        } else {
                            type = i3;
                        }
                    }
                    if (!z6) {
                        String strSubstring2 = str.substring(i4, type);
                        if (z7) {
                            signatureVisitor.visitInnerClassType(strSubstring2);
                        } else {
                            signatureVisitor.visitClassType(strSubstring2);
                        }
                    }
                    if (cCharAt == ';') {
                        signatureVisitor.visitEnd();
                        return i3;
                    }
                    z6 = false;
                    z7 = true;
                    type = i3;
                }
            } else if (cCharAt2 != 'V' && cCharAt2 != 'I' && cCharAt2 != 'J' && cCharAt2 != 'S') {
                if (cCharAt2 == 'T') {
                    int iIndexOf = str.indexOf(59, type);
                    signatureVisitor.visitTypeVariable(str.substring(type, iIndexOf));
                    return iIndexOf + 1;
                }
                if (cCharAt2 != 'Z') {
                    if (cCharAt2 == '[') {
                        return parseType(str, type, signatureVisitor.visitArrayType());
                    }
                    switch (cCharAt2) {
                        case 'B':
                        case 'C':
                        case 'D':
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        signatureVisitor.visitBaseType(cCharAt2);
        return type;
    }

    public void accept(SignatureVisitor signatureVisitor) {
        char cCharAt;
        String str = this.signatureValue;
        int length = str.length();
        int i = 0;
        if (str.charAt(0) == '<') {
            i = 2;
            do {
                int iIndexOf = str.indexOf(58, i);
                signatureVisitor.visitFormalTypeParameter(str.substring(i - 1, iIndexOf));
                int type = iIndexOf + 1;
                char cCharAt2 = str.charAt(type);
                if (cCharAt2 == 'L' || cCharAt2 == '[' || cCharAt2 == 'T') {
                    type = parseType(str, type, signatureVisitor.visitClassBound());
                }
                while (true) {
                    i = type + 1;
                    cCharAt = str.charAt(type);
                    if (cCharAt != ':') {
                        break;
                    } else {
                        type = parseType(str, i, signatureVisitor.visitInterfaceBound());
                    }
                }
            } while (cCharAt != '>');
        }
        if (str.charAt(i) != '(') {
            int type2 = parseType(str, i, signatureVisitor.visitSuperclass());
            while (type2 < length) {
                type2 = parseType(str, type2, signatureVisitor.visitInterface());
            }
        } else {
            int type3 = i + 1;
            while (str.charAt(type3) != ')') {
                type3 = parseType(str, type3, signatureVisitor.visitParameterType());
            }
            int type4 = parseType(str, type3 + 1, signatureVisitor.visitReturnType());
            while (type4 < length) {
                type4 = parseType(str, type4 + 1, signatureVisitor.visitExceptionType());
            }
        }
    }

    public void acceptType(SignatureVisitor signatureVisitor) {
        parseType(this.signatureValue, 0, signatureVisitor);
    }
}
