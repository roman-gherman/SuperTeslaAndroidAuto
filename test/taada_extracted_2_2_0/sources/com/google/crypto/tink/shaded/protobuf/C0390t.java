package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0390t implements Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0388s f2915a;
    public int b;
    public int c;
    public int d = 0;

    public C0390t(AbstractC0388s abstractC0388s) {
        T.a(abstractC0388s, "input");
        this.f2915a = abstractC0388s;
        abstractC0388s.b = this;
    }

    public static void g(int i) throws V {
        if ((i & 3) != 0) {
            throw V.f();
        }
    }

    public static void h(int i) throws V {
        if ((i & 7) != 0) {
            throw V.f();
        }
    }

    public final void a(Object obj, Schema schema, D d) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            schema.mergeFrom(obj, this, d);
            if (this.b == this.c) {
            } else {
                throw V.f();
            }
        } finally {
            this.c = i;
        }
    }

    public final void b(Object obj, Schema schema, D d) throws V {
        AbstractC0388s abstractC0388s = this.f2915a;
        int iB = abstractC0388s.B();
        if (abstractC0388s.f2914a >= 100) {
            throw new V("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iJ = abstractC0388s.j(iB);
        abstractC0388s.f2914a++;
        schema.mergeFrom(obj, this, d);
        abstractC0388s.a(0);
        abstractC0388s.f2914a--;
        abstractC0388s.i(iJ);
    }

    public final Object c(c1 c1Var, Class cls, D d) {
        switch (c1Var.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(readInt64());
            case 3:
                return Long.valueOf(readUInt64());
            case 4:
                return Integer.valueOf(readInt32());
            case 5:
                return Long.valueOf(readFixed64());
            case 6:
                return Integer.valueOf(readFixed32());
            case 7:
                return Boolean.valueOf(readBool());
            case 8:
                return readStringRequireUtf8();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                return readMessage(cls, d);
            case 11:
                return readBytes();
            case 12:
                return Integer.valueOf(readUInt32());
            case 13:
                return Integer.valueOf(readEnum());
            case 14:
                return Integer.valueOf(readSFixed32());
            case 15:
                return Long.valueOf(readSFixed64());
            case 16:
                return Integer.valueOf(readSInt32());
            case 17:
                return Long.valueOf(readSInt64());
        }
    }

    public final void d(List list, boolean z6) throws U {
        int iA;
        int iA2;
        if ((this.b & 7) != 2) {
            throw V.c();
        }
        boolean z7 = list instanceof LazyStringList;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z7 || z6) {
            do {
                list.add(z6 ? readStringRequireUtf8() : readString());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA = abstractC0388s.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        do {
            lazyStringList.add(readBytes());
            if (abstractC0388s.e()) {
                return;
            } else {
                iA2 = abstractC0388s.A();
            }
        } while (iA2 == this.b);
        this.d = iA2;
    }

    public final void e(int i) throws V {
        if (this.f2915a.d() != i) {
            throw V.g();
        }
    }

    public final void f(int i) throws U {
        if ((this.b & 7) != i) {
            throw V.c();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int getFieldNumber() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f2915a.A();
        }
        int i3 = this.b;
        if (i3 == 0 || i3 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int getTag() {
        return this.b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void mergeGroupField(Object obj, Schema schema, D d) throws U {
        f(3);
        a(obj, schema, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void mergeMessageField(Object obj, Schema schema, D d) throws V {
        f(2);
        b(obj, schema, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final boolean readBool() throws U {
        f(0);
        return this.f2915a.k();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readBoolList(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof AbstractC0371j;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(abstractC0388s.k()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Boolean.valueOf(abstractC0388s.k()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        AbstractC0371j abstractC0371j = (AbstractC0371j) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                abstractC0371j.addBoolean(abstractC0388s.k());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            abstractC0371j.addBoolean(abstractC0388s.k());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final AbstractC0381o readBytes() throws U {
        f(2);
        return this.f2915a.l();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readBytesList(List list) throws U {
        int iA;
        if ((this.b & 7) != 2) {
            throw V.c();
        }
        do {
            list.add(readBytes());
            AbstractC0388s abstractC0388s = this.f2915a;
            if (abstractC0388s.e()) {
                return;
            } else {
                iA = abstractC0388s.A();
            }
        } while (iA == this.b);
        this.d = iA;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final double readDouble() throws U {
        f(1);
        return this.f2915a.m();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readDoubleList(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof AbstractC0402z;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Double.valueOf(abstractC0388s.m()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iB = abstractC0388s.B();
            h(iB);
            int iD = abstractC0388s.d() + iB;
            do {
                list.add(Double.valueOf(abstractC0388s.m()));
            } while (abstractC0388s.d() < iD);
            return;
        }
        AbstractC0402z abstractC0402z = (AbstractC0402z) list;
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                abstractC0402z.addDouble(abstractC0388s.m());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iB2 = abstractC0388s.B();
        h(iB2);
        int iD2 = abstractC0388s.d() + iB2;
        do {
            abstractC0402z.addDouble(abstractC0388s.m());
        } while (abstractC0388s.d() < iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readEnum() throws U {
        f(0);
        return this.f2915a.n();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readEnumList(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof S;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0388s.n()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Integer.valueOf(abstractC0388s.n()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        S s3 = (S) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                s3.addInt(abstractC0388s.n());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            s3.addInt(abstractC0388s.n());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readFixed32() throws U {
        f(5);
        return this.f2915a.o();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readFixed32List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof S;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 2) {
                int iB = abstractC0388s.B();
                g(iB);
                int iD = abstractC0388s.d() + iB;
                do {
                    list.add(Integer.valueOf(abstractC0388s.o()));
                } while (abstractC0388s.d() < iD);
                return;
            }
            if (i != 5) {
                throw V.c();
            }
            do {
                list.add(Integer.valueOf(abstractC0388s.o()));
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA = abstractC0388s.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        S s3 = (S) list;
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iB2 = abstractC0388s.B();
            g(iB2);
            int iD2 = abstractC0388s.d() + iB2;
            do {
                s3.addInt(abstractC0388s.o());
            } while (abstractC0388s.d() < iD2);
            return;
        }
        if (i3 != 5) {
            throw V.c();
        }
        do {
            s3.addInt(abstractC0388s.o());
            if (abstractC0388s.e()) {
                return;
            } else {
                iA2 = abstractC0388s.A();
            }
        } while (iA2 == this.b);
        this.d = iA2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readFixed64() throws U {
        f(1);
        return this.f2915a.p();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readFixed64List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof AbstractC0360d0;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(abstractC0388s.p()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iB = abstractC0388s.B();
            h(iB);
            int iD = abstractC0388s.d() + iB;
            do {
                list.add(Long.valueOf(abstractC0388s.p()));
            } while (abstractC0388s.d() < iD);
            return;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                abstractC0360d0.addLong(abstractC0388s.p());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iB2 = abstractC0388s.B();
        h(iB2);
        int iD2 = abstractC0388s.d() + iB2;
        do {
            abstractC0360d0.addLong(abstractC0388s.p());
        } while (abstractC0388s.d() < iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final float readFloat() throws U {
        f(5);
        return this.f2915a.q();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readFloatList(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof M;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 2) {
                int iB = abstractC0388s.B();
                g(iB);
                int iD = abstractC0388s.d() + iB;
                do {
                    list.add(Float.valueOf(abstractC0388s.q()));
                } while (abstractC0388s.d() < iD);
                return;
            }
            if (i != 5) {
                throw V.c();
            }
            do {
                list.add(Float.valueOf(abstractC0388s.q()));
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA = abstractC0388s.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        M m6 = (M) list;
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iB2 = abstractC0388s.B();
            g(iB2);
            int iD2 = abstractC0388s.d() + iB2;
            do {
                m6.addFloat(abstractC0388s.q());
            } while (abstractC0388s.d() < iD2);
            return;
        }
        if (i3 != 5) {
            throw V.c();
        }
        do {
            m6.addFloat(abstractC0388s.q());
            if (abstractC0388s.e()) {
                return;
            } else {
                iA2 = abstractC0388s.A();
            }
        } while (iA2 == this.b);
        this.d = iA2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final Object readGroup(Class cls, D d) throws U {
        f(3);
        Schema schemaA = C0393u0.c.a(cls);
        Object objNewInstance = schemaA.newInstance();
        a(objNewInstance, schemaA, d);
        schemaA.makeImmutable(objNewInstance);
        return objNewInstance;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final Object readGroupBySchemaWithCheck(Schema schema, D d) throws U {
        f(3);
        Object objNewInstance = schema.newInstance();
        a(objNewInstance, schema, d);
        schema.makeImmutable(objNewInstance);
        return objNewInstance;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readGroupList(List list, Class cls, D d) throws U {
        readGroupList(list, C0393u0.c.a(cls), d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readInt32() throws U {
        f(0);
        return this.f2915a.r();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readInt32List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof S;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0388s.r()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Integer.valueOf(abstractC0388s.r()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        S s3 = (S) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                s3.addInt(abstractC0388s.r());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            s3.addInt(abstractC0388s.r());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readInt64() throws U {
        f(0);
        return this.f2915a.s();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readInt64List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof AbstractC0360d0;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(abstractC0388s.s()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Long.valueOf(abstractC0388s.s()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                abstractC0360d0.addLong(abstractC0388s.s());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            abstractC0360d0.addLong(abstractC0388s.s());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r10.put(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r1.i(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return;
     */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void readMap(java.util.Map r10, com.google.crypto.tink.shaded.protobuf.C0364f0 r11, com.google.crypto.tink.shaded.protobuf.D r12) throws com.google.crypto.tink.shaded.protobuf.U {
        /*
            r9 = this;
            r0 = 2
            r9.f(r0)
            com.google.crypto.tink.shaded.protobuf.s r1 = r9.f2915a
            int r2 = r1.B()
            int r2 = r1.j(r2)
            r11.getClass()
            java.lang.String r3 = ""
            com.google.crypto.tink.shaded.protobuf.X0 r4 = r11.c
            r5 = r4
        L16:
            int r6 = r9.getFieldNumber()     // Catch: java.lang.Throwable -> L3a
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L5c
            boolean r7 = r1.e()     // Catch: java.lang.Throwable -> L3a
            if (r7 == 0) goto L26
            goto L5c
        L26:
            r7 = 1
            java.lang.String r8 = "Unable to parse map entry."
            if (r6 == r7) goto L47
            if (r6 == r0) goto L3c
            boolean r6 = r9.skipField()     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            if (r6 == 0) goto L34
            goto L16
        L34:
            com.google.crypto.tink.shaded.protobuf.V r6 = new com.google.crypto.tink.shaded.protobuf.V     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            throw r6     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
        L3a:
            r10 = move-exception
            goto L63
        L3c:
            com.google.crypto.tink.shaded.protobuf.a1 r6 = r11.b     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            java.lang.Class r7 = r4.getClass()     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            java.lang.Object r5 = r9.c(r6, r7, r12)     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            goto L16
        L47:
            com.google.crypto.tink.shaded.protobuf.Y0 r6 = r11.f2878a     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            r7 = 0
            java.lang.Object r3 = r9.c(r6, r7, r7)     // Catch: java.lang.Throwable -> L3a com.google.crypto.tink.shaded.protobuf.U -> L4f
            goto L16
        L4f:
            boolean r6 = r9.skipField()     // Catch: java.lang.Throwable -> L3a
            if (r6 == 0) goto L56
            goto L16
        L56:
            com.google.crypto.tink.shaded.protobuf.V r10 = new com.google.crypto.tink.shaded.protobuf.V     // Catch: java.lang.Throwable -> L3a
            r10.<init>(r8)     // Catch: java.lang.Throwable -> L3a
            throw r10     // Catch: java.lang.Throwable -> L3a
        L5c:
            r10.put(r3, r5)     // Catch: java.lang.Throwable -> L3a
            r1.i(r2)
            return
        L63:
            r1.i(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C0390t.readMap(java.util.Map, com.google.crypto.tink.shaded.protobuf.f0, com.google.crypto.tink.shaded.protobuf.D):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final Object readMessage(Class cls, D d) throws V {
        f(2);
        Schema schemaA = C0393u0.c.a(cls);
        Object objNewInstance = schemaA.newInstance();
        b(objNewInstance, schemaA, d);
        schemaA.makeImmutable(objNewInstance);
        return objNewInstance;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final Object readMessageBySchemaWithCheck(Schema schema, D d) throws V {
        f(2);
        Object objNewInstance = schema.newInstance();
        b(objNewInstance, schema, d);
        schema.makeImmutable(objNewInstance);
        return objNewInstance;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readMessageList(List list, Class cls, D d) throws V {
        readMessageList(list, C0393u0.c.a(cls), d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readSFixed32() throws U {
        f(5);
        return this.f2915a.u();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSFixed32List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof S;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 2) {
                int iB = abstractC0388s.B();
                g(iB);
                int iD = abstractC0388s.d() + iB;
                do {
                    list.add(Integer.valueOf(abstractC0388s.u()));
                } while (abstractC0388s.d() < iD);
                return;
            }
            if (i != 5) {
                throw V.c();
            }
            do {
                list.add(Integer.valueOf(abstractC0388s.u()));
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA = abstractC0388s.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        S s3 = (S) list;
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iB2 = abstractC0388s.B();
            g(iB2);
            int iD2 = abstractC0388s.d() + iB2;
            do {
                s3.addInt(abstractC0388s.u());
            } while (abstractC0388s.d() < iD2);
            return;
        }
        if (i3 != 5) {
            throw V.c();
        }
        do {
            s3.addInt(abstractC0388s.u());
            if (abstractC0388s.e()) {
                return;
            } else {
                iA2 = abstractC0388s.A();
            }
        } while (iA2 == this.b);
        this.d = iA2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readSFixed64() throws U {
        f(1);
        return this.f2915a.v();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSFixed64List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof AbstractC0360d0;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(abstractC0388s.v()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iB = abstractC0388s.B();
            h(iB);
            int iD = abstractC0388s.d() + iB;
            do {
                list.add(Long.valueOf(abstractC0388s.v()));
            } while (abstractC0388s.d() < iD);
            return;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                abstractC0360d0.addLong(abstractC0388s.v());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iB2 = abstractC0388s.B();
        h(iB2);
        int iD2 = abstractC0388s.d() + iB2;
        do {
            abstractC0360d0.addLong(abstractC0388s.v());
        } while (abstractC0388s.d() < iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readSInt32() throws U {
        f(0);
        return this.f2915a.w();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSInt32List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof S;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0388s.w()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Integer.valueOf(abstractC0388s.w()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        S s3 = (S) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                s3.addInt(abstractC0388s.w());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            s3.addInt(abstractC0388s.w());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readSInt64() throws U {
        f(0);
        return this.f2915a.x();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSInt64List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof AbstractC0360d0;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(abstractC0388s.x()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Long.valueOf(abstractC0388s.x()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                abstractC0360d0.addLong(abstractC0388s.x());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            abstractC0360d0.addLong(abstractC0388s.x());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final String readString() throws U {
        f(2);
        return this.f2915a.y();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readStringList(List list) throws U {
        d(list, false);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readStringListRequireUtf8(List list) throws U {
        d(list, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final String readStringRequireUtf8() throws U {
        f(2);
        return this.f2915a.z();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readUInt32() throws U {
        f(0);
        return this.f2915a.B();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readUInt32List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof S;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0388s.B()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Integer.valueOf(abstractC0388s.B()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        S s3 = (S) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                s3.addInt(abstractC0388s.B());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            s3.addInt(abstractC0388s.B());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readUInt64() throws U {
        f(0);
        return this.f2915a.C();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readUInt64List(List list) throws V {
        int iA;
        int iA2;
        boolean z6 = list instanceof AbstractC0360d0;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (!z6) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(abstractC0388s.C()));
                    if (abstractC0388s.e()) {
                        return;
                    } else {
                        iA = abstractC0388s.A();
                    }
                } while (iA == this.b);
                this.d = iA;
                return;
            }
            if (i != 2) {
                throw V.c();
            }
            int iD = abstractC0388s.d() + abstractC0388s.B();
            do {
                list.add(Long.valueOf(abstractC0388s.C()));
            } while (abstractC0388s.d() < iD);
            e(iD);
            return;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                abstractC0360d0.addLong(abstractC0388s.C());
                if (abstractC0388s.e()) {
                    return;
                } else {
                    iA2 = abstractC0388s.A();
                }
            } while (iA2 == this.b);
            this.d = iA2;
            return;
        }
        if (i3 != 2) {
            throw V.c();
        }
        int iD2 = abstractC0388s.d() + abstractC0388s.B();
        do {
            abstractC0360d0.addLong(abstractC0388s.C());
        } while (abstractC0388s.d() < iD2);
        e(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final boolean shouldDiscardUnknownFields() {
        this.f2915a.getClass();
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final boolean skipField() {
        int i;
        AbstractC0388s abstractC0388s = this.f2915a;
        if (abstractC0388s.e() || (i = this.b) == this.c) {
            return false;
        }
        return abstractC0388s.D(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readGroupList(List list, Schema schema, D d) throws U {
        int iA;
        int i = this.b;
        if ((i & 7) == 3) {
            do {
                Object objNewInstance = schema.newInstance();
                a(objNewInstance, schema, d);
                schema.makeImmutable(objNewInstance);
                list.add(objNewInstance);
                AbstractC0388s abstractC0388s = this.f2915a;
                if (abstractC0388s.e() || this.d != 0) {
                    return;
                } else {
                    iA = abstractC0388s.A();
                }
            } while (iA == i);
            this.d = iA;
            return;
        }
        throw V.c();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readMessageList(List list, Schema schema, D d) throws V {
        int iA;
        int i = this.b;
        if ((i & 7) == 2) {
            do {
                Object objNewInstance = schema.newInstance();
                b(objNewInstance, schema, d);
                schema.makeImmutable(objNewInstance);
                list.add(objNewInstance);
                AbstractC0388s abstractC0388s = this.f2915a;
                if (abstractC0388s.e() || this.d != 0) {
                    return;
                } else {
                    iA = abstractC0388s.A();
                }
            } while (iA == i);
            this.d = iA;
            return;
        }
        throw V.c();
    }
}
