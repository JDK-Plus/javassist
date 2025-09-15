import plus.jdk.javassist.ClassPool;
import plus.jdk.javassist.CtClass;
import plus.jdk.javassist.CtMethod;
import plus.jdk.javassist.CtNewMethod;

public class Test {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("test5.DefaultMethod");
        CtMethod m = CtNewMethod.make("public int run(){ return test5.DefaultMethodIntf.super.foo(); }", cc);
        cc.addMethod(m);
        cc.writeFile();
    }
}
