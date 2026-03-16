package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes2.dex */
public interface ASN1TaggedObjectParser extends ASN1Encodable, InMemoryRepresentable {
    int getTagClass();

    int getTagNo();

    boolean hasContextTag();

    boolean hasContextTag(int i);

    boolean hasTag(int i, int i3);

    boolean hasTagClass(int i);

    ASN1Encodable parseBaseUniversal(boolean z6, int i);

    ASN1Encodable parseExplicitBaseObject();

    ASN1TaggedObjectParser parseExplicitBaseTagged();

    ASN1TaggedObjectParser parseImplicitBaseTagged(int i, int i3);
}
