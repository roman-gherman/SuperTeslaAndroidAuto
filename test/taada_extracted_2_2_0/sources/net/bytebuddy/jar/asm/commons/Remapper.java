package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.signature.SignatureReader;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Remapper {
    private Type mapType(Type type) {
        switch (type.getSort()) {
            case 9:
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < type.getDimensions(); i++) {
                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                }
                sb.append(mapType(type.getElementType()).getDescriptor());
                return Type.getType(sb.toString());
            case 10:
                String map = map(type.getInternalName());
                return map != null ? Type.getObjectType(map) : type;
            case 11:
                return Type.getMethodType(mapMethodDesc(type.getDescriptor()));
            default:
                return type;
        }
    }

    @Deprecated
    public SignatureVisitor createRemappingSignatureAdapter(SignatureVisitor signatureVisitor) {
        return createSignatureRemapper(signatureVisitor);
    }

    public SignatureVisitor createSignatureRemapper(SignatureVisitor signatureVisitor) {
        return new SignatureRemapper(signatureVisitor, this);
    }

    public String map(String str) {
        return str;
    }

    public String mapAnnotationAttributeName(String str, String str2) {
        return str2;
    }

    public String mapDesc(String str) {
        return mapType(Type.getType(str)).getDescriptor();
    }

    public String mapFieldName(String str, String str2, String str3) {
        return str2;
    }

    public String mapInnerClassName(String str, String str2, String str3) {
        String strMapType = mapType(str);
        if (!strMapType.equals(str)) {
            int iLastIndexOf = str.lastIndexOf(47);
            int iLastIndexOf2 = strMapType.lastIndexOf(47);
            if ((iLastIndexOf == -1 || iLastIndexOf2 == -1 || !str.substring(iLastIndexOf).equals(strMapType.substring(iLastIndexOf2))) && strMapType.contains("$")) {
                int iLastIndexOf3 = strMapType.lastIndexOf(36);
                do {
                    iLastIndexOf3++;
                    if (iLastIndexOf3 >= strMapType.length()) {
                        break;
                    }
                } while (Character.isDigit(strMapType.charAt(iLastIndexOf3)));
                return strMapType.substring(iLastIndexOf3);
            }
        }
        return str3;
    }

    public String mapInvokeDynamicMethodName(String str, String str2) {
        return str;
    }

    public String mapMethodDesc(String str) {
        if ("()V".equals(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("(");
        for (Type type : Type.getArgumentTypes(str)) {
            sb.append(mapType(type).getDescriptor());
        }
        Type returnType = Type.getReturnType(str);
        if (returnType == Type.VOID_TYPE) {
            sb.append(")V");
        } else {
            sb.append(')');
            sb.append(mapType(returnType).getDescriptor());
        }
        return sb.toString();
    }

    public String mapMethodName(String str, String str2, String str3) {
        return str2;
    }

    public String mapModuleName(String str) {
        return str;
    }

    public String mapPackageName(String str) {
        return str;
    }

    public String mapRecordComponentName(String str, String str2, String str3) {
        return str2;
    }

    public String mapSignature(String str, boolean z6) {
        if (str == null) {
            return null;
        }
        SignatureReader signatureReader = new SignatureReader(str);
        SignatureWriter signatureWriter = new SignatureWriter();
        SignatureVisitor signatureVisitorCreateSignatureRemapper = createSignatureRemapper(signatureWriter);
        if (z6) {
            signatureReader.acceptType(signatureVisitorCreateSignatureRemapper);
        } else {
            signatureReader.accept(signatureVisitorCreateSignatureRemapper);
        }
        return signatureWriter.toString();
    }

    public String[] mapTypes(String[] strArr) {
        String[] strArr2 = null;
        for (int i = 0; i < strArr.length; i++) {
            String strMapType = mapType(strArr[i]);
            if (strMapType != null) {
                if (strArr2 == null) {
                    strArr2 = (String[]) strArr.clone();
                }
                strArr2[i] = strMapType;
            }
        }
        return strArr2 != null ? strArr2 : strArr;
    }

    public Object mapValue(Object obj) {
        if (obj instanceof Type) {
            return mapType((Type) obj);
        }
        if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            i = handle.getTag() <= 4 ? 1 : 0;
            int tag = handle.getTag();
            String strMapType = mapType(handle.getOwner());
            String strMapFieldName = i != 0 ? mapFieldName(handle.getOwner(), handle.getName(), handle.getDesc()) : mapMethodName(handle.getOwner(), handle.getName(), handle.getDesc());
            String desc = handle.getDesc();
            return new Handle(tag, strMapType, strMapFieldName, i != 0 ? mapDesc(desc) : mapMethodDesc(desc), handle.isInterface());
        }
        if (!(obj instanceof ConstantDynamic)) {
            return obj;
        }
        ConstantDynamic constantDynamic = (ConstantDynamic) obj;
        int bootstrapMethodArgumentCount = constantDynamic.getBootstrapMethodArgumentCount();
        Object[] objArr = new Object[bootstrapMethodArgumentCount];
        while (i < bootstrapMethodArgumentCount) {
            objArr[i] = mapValue(constantDynamic.getBootstrapMethodArgument(i));
            i++;
        }
        String descriptor = constantDynamic.getDescriptor();
        return new ConstantDynamic(mapInvokeDynamicMethodName(constantDynamic.getName(), descriptor), mapDesc(descriptor), (Handle) mapValue(constantDynamic.getBootstrapMethod()), objArr);
    }

    public String mapType(String str) {
        if (str == null) {
            return null;
        }
        return mapType(Type.getObjectType(str)).getInternalName();
    }
}
