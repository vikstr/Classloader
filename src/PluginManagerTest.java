import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class PluginManagerTest {
    @Test
    public void test1() throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Plugin newPlugin = new MyPlugin();
        newPlugin.getClass().getClassLoader().loadClass("MyPlugin").getMethod("doUseful").invoke(newPlugin);

        PluginManager manager = new PluginManager("file:///Users/vika/IdeaProjects/Classloader/out/production/Classloader/");
        Plugin plugin = manager.load("MyPlugin", "MyPlugin");
        plugin.doUseful();
    }
}