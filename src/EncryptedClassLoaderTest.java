import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class EncryptedClassLoaderTest {
    @Test
    public void test1() throws ClassCastException, IllegalAccessException, ClassNotFoundException {
        String path = "/Users/vika/IdeaProjects/Classloader/out/production/Classloader/";
        String key = "1";
        File dir = new File(path);
        EncryptedClassLoader classLoader = new EncryptedClassLoader(key,dir,getClass().getClassLoader());
        try {
            System.out.println(classLoader.findClass("EncryptedClassLoader").newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}