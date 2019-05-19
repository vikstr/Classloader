import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;

    private final File dir;
    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }
    @Override
    protected Class<?> findClass(String name) {
        int hashKey= key.hashCode();
        Path file = Paths.get(dir.getPath() + "/" + name.replace('.', '/') + ".class");
        byte[] cypher = new byte[0];
        try {
            cypher = Files.readAllBytes(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        long len = cypher.length;
        for (int i = 0; i < len; i++) {
            cypher[i] = (byte) (cypher[i] + hashKey);
        }
        return defineClass(name, cypher, 0, cypher.length);
    }
}
