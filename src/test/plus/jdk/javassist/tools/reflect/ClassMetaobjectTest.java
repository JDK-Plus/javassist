package plus.jdk.javassist.tools.reflect;

/**
 * @author Brett Randall
 */
public class ClassMetaobjectTest {
    public static void main(String[] args) throws Throwable {
        Loader loader = new Loader();
        loader.makeReflective("plus.jdk.javassist.tools.reflect.Person",
                              "plus.jdk.javassist.tools.reflect.Metaobject",
                              "plus.jdk.javassist.tools.reflect.ClassMetaobject");
        loader.run("plus.jdk.javassist.tools.reflect.Person", new String[] {});
    }
}
