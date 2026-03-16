package M0;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.internal.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes.dex */
public final class x implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1022a;
    public final /* synthetic */ Serializable b;

    public /* synthetic */ x(Serializable serializable, int i) {
        this.f1022a = i;
        this.b = serializable;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        String str;
        String str2;
        switch (this.f1022a) {
            case 0:
                Field[] declaredFields = ((Class) this.b).getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            default:
                String[] strArr = Z3.c.f1510k;
                Z3.c cVar = (Z3.c) this.b;
                Z3.c.c("org.bouncycastle.jcajce.provider.digest.", strArr);
                Z3.c.c("org.bouncycastle.jcajce.provider.symmetric.", Z3.c.f1506f);
                Z3.c.c("org.bouncycastle.jcajce.provider.symmetric.", Z3.c.f1507g);
                int i = 0;
                while (true) {
                    CryptoServiceProperties[] cryptoServicePropertiesArr = Z3.c.f1508h;
                    if (i == cryptoServicePropertiesArr.length) {
                        Z3.c.c("org.bouncycastle.jcajce.provider.asymmetric.", Z3.c.i);
                        Z3.c.c("org.bouncycastle.jcajce.provider.asymmetric.", Z3.c.f1509j);
                        Z3.c.c("org.bouncycastle.jcajce.provider.keystore.", Z3.c.f1511l);
                        Z3.c.c("org.bouncycastle.jcajce.provider.drbg.", Z3.c.f1512m);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_128s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_128f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_128s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_128f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_128s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_128f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_192s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_192f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_192s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_192f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_192s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_192f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_256s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_256f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_256s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_256f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_256s_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_256f_r3);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_128s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_128f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_128s_r3_simple);
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_128f_r3_simple, new L4.c(7));
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_192s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_192f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_192s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_192f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_256s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_256f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_256s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_256f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_128s);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_sha2_192s);
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_256s, new L4.c(7));
                        B2.b.t(cVar, new C0896n("1.3.9999.6.4.10"));
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_128f);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_192f);
                        B2.b.t(cVar, BCObjectIdentifiers.sphincsPlus_shake_256f);
                        cVar.addKeyInfoConverter(PQCObjectIdentifiers.sphincs256, new L4.c(6));
                        cVar.addKeyInfoConverter(PQCObjectIdentifiers.newHope, new L4.c(3));
                        cVar.addKeyInfoConverter(PQCObjectIdentifiers.xmss, new L4.c(8));
                        cVar.addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmss, new L4.c(8));
                        cVar.addKeyInfoConverter(PQCObjectIdentifiers.xmss_mt, new L4.c(9));
                        cVar.addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmssmt, new L4.c(9));
                        cVar.addKeyInfoConverter(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new L4.c(2));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.picnic_key, new L4.c(5));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.falcon_512, new O4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.falcon_1024, new O4.c());
                        cVar.addKeyInfoConverter(NISTObjectIdentifiers.id_alg_ml_kem_512, new V3.c());
                        cVar.addKeyInfoConverter(NISTObjectIdentifiers.id_alg_ml_kem_768, new V3.c());
                        cVar.addKeyInfoConverter(NISTObjectIdentifiers.id_alg_ml_kem_1024, new V3.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.dilithium2, new N4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.dilithium3, new N4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.dilithium5, new N4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.dilithium2_aes, new N4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.dilithium3_aes, new N4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.dilithium5_aes, new N4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mceliece348864_r3, new L4.c(1));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mceliece460896_r3, new L4.c(1));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mceliece6688128_r3, new L4.c(1));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mceliece6960119_r3, new L4.c(1));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mceliece8192128_r3, new L4.c(1));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.bike128, new L4.c(0));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.bike192, new L4.c(0));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.bike256, new L4.c(0));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.hqc128, new P4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.hqc192, new P4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.hqc256, new P4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.kyber512_aes, new Q4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.kyber768_aes, new Q4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.kyber1024_aes, new Q4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.ntruhps2048509, new L4.c(4));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.ntruhps2048677, new L4.c(4));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.ntruhps4096821, new L4.c(4));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.ntruhrss701, new L4.c(4));
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mayo1, new S4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mayo2, new S4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mayo3, new S4.c());
                        cVar.addKeyInfoConverter(BCObjectIdentifiers.mayo5, new S4.c());
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_4_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_4_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_4_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_4_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_5_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_5_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_5_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_24_5_5_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_25_8_3_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_25_8_3_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_25_8_3_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_25_8_3_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_8_4_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_8_4_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_8_4_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_8_4_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_17_2_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_17_2_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_17_2_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_37_17_2_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_49_11_3_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_49_11_3_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_49_11_3_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_49_11_3_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_56_25_2_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_56_25_2_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_56_25_2_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_56_25_2_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_60_10_4_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_60_10_4_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_60_10_4_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_60_10_4_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_66_15_3_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_66_15_3_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_66_15_3_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_66_15_3_shake_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_75_33_2_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_75_33_2_esk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_75_33_2_shake_ssk);
                        B2.b.q(cVar, BCObjectIdentifiers.snova_75_33_2_shake_esk);
                        cVar.put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
                        cVar.put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
                        cVar.put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
                        cVar.put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
                        cVar.put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
                        cVar.put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
                        cVar.put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
                        cVar.put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
                        cVar.put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
                        cVar.put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
                        cVar.put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
                        cVar.put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
                        cVar.put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
                        cVar.put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
                        cVar.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
                        Class cls = Z3.c.e;
                        cVar.put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
                        cVar.put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
                        if (cls != null) {
                            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
                            cVar.put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
                            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
                        } else {
                            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
                            cVar.put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
                            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
                        }
                        cVar.put("CertPathBuilder.RFC3280", str2);
                        cVar.put("CertPathValidator.PKIX", str);
                        cVar.put("CertPathBuilder.PKIX", str2);
                        cVar.put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
                        cVar.put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
                        cVar.put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
                        cVar.put("Alg.Alias.CertStore.X509LDAP", "LDAP");
                        return null;
                    }
                    CryptoServiceProperties cryptoServiceProperties = cryptoServicePropertiesArr[i];
                    L3.h.a(cryptoServiceProperties);
                    Z3.c.d("org.bouncycastle.jcajce.provider.symmetric.", cryptoServiceProperties.getServiceName());
                    i++;
                }
                break;
        }
    }
}
