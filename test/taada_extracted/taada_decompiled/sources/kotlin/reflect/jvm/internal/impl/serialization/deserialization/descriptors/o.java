package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import G2.C0125z;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import n2.EnumC0709a;
import q2.L;
import q2.v;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends L implements DeserializedCallableMemberDescriptor {
    public final C0125z E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final NameResolver f3924F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final I2.f f3925G;
    public final I2.g H;
    public final E2.g I;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public o(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r12, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r13, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r14, L2.f r15, n2.EnumC0709a r16, G2.C0125z r17, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r18, I2.f r19, I2.g r20, E2.g r21, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r22) {
        /*
            r11 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "containingDeclaration"
            kotlin.jvm.internal.h.f(r12, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.h.f(r14, r0)
            java.lang.String r0 = "kind"
            r5 = r16
            kotlin.jvm.internal.h.f(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.h.f(r7, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.h.f(r8, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.h.f(r9, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.h.f(r10, r0)
            if (r22 != 0) goto L38
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r0 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L3f
        L38:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L3f:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.E = r7
            r11.f3924F = r8
            r11.f3925G = r9
            r11.H = r10
            r1 = r21
            r11.I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, L2.f, n2.a, G2.z, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, I2.f, I2.g, E2.g, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final DeserializedContainerSource getContainerSource() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final NameResolver getNameResolver() {
        return this.f3924F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final MessageLite getProto() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final I2.f getTypeTable() {
        return this.f3925G;
    }

    @Override // q2.L, q2.v
    public final v i(L2.f name, DeclarationDescriptor newOwner, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a kind) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(annotations, "annotations");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            name = getName();
            kotlin.jvm.internal.h.e(name, "name");
        }
        o oVar = new o(newOwner, simpleFunctionDescriptor, annotations, name, kind, this.E, this.f3924F, this.f3925G, this.H, this.I, sourceElement);
        oVar.f4642w = this.f4642w;
        return oVar;
    }
}
