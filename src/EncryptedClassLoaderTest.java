import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class EncryptedClassLoaderTest {
    @Test
    public void test1() throws ClassCastException, IllegalAccessException, ClassNotFoundException {
        String path = "/Users/vika/IdeaProjects/Classloader/src/";
        String key = "1";
        File dir = new File(path);
        EncryptedClassLoader classLoader = new EncryptedClassLoader(key,dir,getClass().getClassLoader());
        try {
            System.out.println(classLoader.findClass("TestClass").newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}