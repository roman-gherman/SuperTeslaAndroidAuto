package q2;

import a3.Z;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;

/* JADX INFO: renamed from: q2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0773j extends v implements ClassConstructorDescriptor {
    public final boolean E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0773j(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z6, EnumC0709a enumC0709a, SourceElement sourceElement) {
        super(L2.h.e, classDescriptor, constructorDescriptor, sourceElement, annotations, enumC0709a);
        if (classDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations == null) {
            a(1);
            throw null;
        }
        if (enumC0709a == null) {
            a(2);
            throw null;
        }
        if (sourceElement == null) {
            a(3);
            throw null;
        }
        this.E = z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r8) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.C0773j.a(int):void");
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitConstructorDescriptor(this, obj);
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, boolean z6) {
        return (ClassConstructorDescriptor) g(declarationDescriptor, enumC0719k, abstractC0714f, enumC0709a, z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public final ClassDescriptor getConstructedClass() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        a(18);
        throw null;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Collection getOverriddenDescriptors() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        a(21);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public final boolean isPrimary() {
        return this.E;
    }

    @Override // q2.v
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0773j i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        if (declarationDescriptor == null) {
            a(23);
            throw null;
        }
        if (enumC0709a == null) {
            a(24);
            throw null;
        }
        if (annotations == null) {
            a(25);
            throw null;
        }
        EnumC0709a enumC0709a2 = EnumC0709a.f4226a;
        if (enumC0709a == enumC0709a2 || enumC0709a == EnumC0709a.d) {
            return new C0773j((ClassDescriptor) declarationDescriptor, this, annotations, this.E, enumC0709a2, sourceElement);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + declarationDescriptor + "\nkind: " + enumC0709a);
    }

    @Override // q2.AbstractC0778o, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final ClassDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = (ClassDescriptor) super.getContainingDeclaration();
        if (classDescriptor != null) {
            return classDescriptor;
        }
        a(17);
        throw null;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final void setOverriddenDescriptors(Collection collection) {
        if (collection != null) {
            return;
        }
        a(22);
        throw null;
    }

    public final void t(List list, AbstractC0714f abstractC0714f) {
        if (list == null) {
            a(13);
            throw null;
        }
        if (abstractC0714f != null) {
            u(list, abstractC0714f, getContainingDeclaration().getDeclaredTypeParameters());
        } else {
            a(14);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.util.List r12, n2.AbstractC0714f r13, java.util.List r14) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L61
            if (r13 == 0) goto L5b
            if (r14 == 0) goto L55
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = r11.getContainingDeclaration()
            boolean r2 = r1.isInner()
            if (r2 == 0) goto L21
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration()
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 == 0) goto L21
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r1.getThisAsReceiverParameter()
            r4 = r1
            goto L22
        L21:
            r4 = r0
        L22:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = r11.getContainingDeclaration()
            java.util.List r2 = r1.getContextReceivers()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L3e
            java.util.List r1 = r1.getContextReceivers()
            if (r1 == 0) goto L38
        L36:
            r5 = r1
            goto L43
        L38:
            r12 = 15
            a(r12)
            throw r0
        L3e:
            java.util.List r1 = java.util.Collections.EMPTY_LIST
            if (r1 == 0) goto L4f
            goto L36
        L43:
            n2.k r9 = n2.EnumC0719k.f4247a
            r3 = 0
            r8 = 0
            r2 = r11
            r7 = r12
            r10 = r13
            r6 = r14
            r2.l(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        L4f:
            r12 = 16
            a(r12)
            throw r0
        L55:
            r12 = 12
            a(r12)
            throw r0
        L5b:
            r12 = 11
            a(r12)
            throw r0
        L61:
            r12 = 10
            a(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.C0773j.u(java.util.List, n2.f, java.util.List):void");
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final ClassConstructorDescriptor substitute(Z z6) {
        if (z6 != null) {
            return (ClassConstructorDescriptor) super.substitute(z6);
        }
        a(20);
        throw null;
    }

    @Override // q2.v, q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.getOriginal();
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        a(19);
        throw null;
    }
}
