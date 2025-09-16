package plus.jdk.javassist.tools.reflect;


import junit.framework.*;
import plus.jdk.javassist.ClassPool;
import plus.jdk.javassist.CtClass;
import plus.jdk.javassist.CtMethod;

public class LoaderTest extends TestCase {
    private Loader loader;

    public LoaderTest(String name) {
         super(name);
    }

    public void setUp() throws Exception {
        loader = new Loader();
    }

    public void testAttemptReflectInterface() throws Exception {
        try {
            loader.makeReflective("plus.jdk.javassist.ClassPath",
                                  "plus.jdk.javassist.tools.reflect.Metaobject",
                                  "plus.jdk.javassist.tools.reflect.ClassMetaobject");
            fail("Attempting to reflect an interface should throw a CannotReflectException");
        } catch (CannotReflectException e) {
            // expected
        }
    }

    public void testAttemptReflectClassMetaobject() throws Exception {
        try {
            loader.makeReflective("plus.jdk.javassist.tools.reflect.ClassMetaobject",
                                  "plus.jdk.javassist.tools.reflect.Metaobject",
                                  "plus.jdk.javassist.tools.reflect.ClassMetaobject");
            fail("Attempting to reflect a ClassMetaobject should throw a CannotReflectException");
        } catch (CannotReflectException e) {
            // expected
        }
    }

    public void testAttemptReflectMetaobject() throws Exception {
        try {
            loader.makeReflective("plus.jdk.javassist.tools.reflect.Metaobject",
                                  "plus.jdk.javassist.tools.reflect.Metaobject",
                                  "plus.jdk.javassist.tools.reflect.ClassMetaobject");
            fail("Attempting to reflect a Metaobject should throw a CannotReflectException");
        } catch (CannotReflectException e) {
            // expected
        }
    }

    public void testFinalMethod() throws Throwable {
        loader.makeReflective("plus.jdk.javassist.tools.reflect.SuperClass",
                              "plus.jdk.javassist.tools.reflect.Metaobject",
                              "plus.jdk.javassist.tools.reflect.ClassMetaobject");

        ClassPool cp = ClassPool.getDefault();

        CtClass cc2 = cp.get("plus.jdk.javassist.tools.reflect.SuperClass");
        cc2.debugWriteFile("reflected/");

        CtClass cc = cp.get("plus.jdk.javassist.tools.reflect.SubClass");

        CtMethod[] ms = cc.getMethods();
        for (int i = 0; i < ms.length; ++i)
            System.out.println(ms[i] + " in "
                               + ms[i].getDeclaringClass().getName());

        loader.makeReflective("plus.jdk.javassist.tools.reflect.SubClass",
                              "plus.jdk.javassist.tools.reflect.Metaobject",
                              "plus.jdk.javassist.tools.reflect.ClassMetaobject");

        loader.run("plus.jdk.javassist.tools.reflect.SubClass", new String[] {});
    }
}
