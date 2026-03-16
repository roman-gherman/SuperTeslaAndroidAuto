package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import G2.C0113m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import n2.EnumC0709a;
import q2.C0773j;
import q2.v;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends C0773j implements DeserializedCallableMemberDescriptor {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final C0113m f3888F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final NameResolver f3889G;
    public final I2.f H;
    public final I2.g I;
    public final E2.g J;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public b(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r13, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r14, boolean r15, n2.EnumC0709a r16, G2.C0113m r17, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r18, I2.f r19, I2.g r20, E2.g r21, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r22) {
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
            r11.f3888F = r7
            r11.f3889G = r8
            r11.H = r9
            r11.I = r10
            r1 = r21
            r11.J = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, boolean, n2.a, G2.m, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, I2.f, I2.g, E2.g, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final DeserializedContainerSource getContainerSource() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final NameResolver getNameResolver() {
        return this.f3889G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final MessageLite getProto() {
        return this.f3888F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final I2.f getTypeTable() {
        return this.H;
    }

    @Override // q2.C0773j, q2.v
    public final /* bridge */ /* synthetic */ v i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        return v(declarationDescriptor, functionDescriptor, enumC0709a, annotations, sourceElement);
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return false;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isSuspend() {
        return false;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isTailrec() {
        return false;
    }

    @Override // q2.C0773j
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ C0773j i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        return v(declarationDescriptor, functionDescriptor, enumC0709a, annotations, sourceElement);
    }

    public final b v(DeclarationDescriptor newOwner, FunctionDescriptor functionDescriptor, EnumC0709a kind, Annotations annotations, SourceElement sourceElement) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(annotations, "annotations");
        b bVar = new b((ClassDescriptor) newOwner, (ConstructorDescriptor) functionDescriptor, annotations, this.E, kind, this.f3888F, this.f3889G, this.H, this.I, this.J, sourceElement);
        bVar.f4643w = this.f4643w;
        return bVar;
    }
}
