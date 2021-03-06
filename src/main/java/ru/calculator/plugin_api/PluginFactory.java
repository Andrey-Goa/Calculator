package ru.calculator.plugin_api;

import ru.calculator.model.Operation;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class PluginFactory{
    public static ArrayList<Operation> getPlugins() {
        ArrayList<Operation> rez = new ArrayList<>();
        File pluginDir = new File("plugins");

        File[] jars = pluginDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".jar");
            }
        });

        for (int i = 0; i < jars.length; i++) {
            try {
                URL jarURL = jars[i].toURI().toURL();
                URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL});
                JarFile jf = new JarFile(jars[i]);
                Enumeration<JarEntry> entries = jf.entries();
                while (entries.hasMoreElements()) {
                    String e = entries.nextElement().getName();
                    if (!e.endsWith(".class")) continue;
                    e = e.replaceAll("/", ".");
                    e = e.replaceAll(".class", "");
                    Class<?> plugCan = classLoader.loadClass(e);
                    Class<?>[] interfaces = plugCan.getInterfaces();
                    for (Class interf : interfaces) {
                        if (interf.getName().endsWith(".Operation")) {
                            Class c = classLoader.loadClass(plugCan.getName());
                            Object inst = c.newInstance();
                            rez.add((Operation) inst);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
        return rez;

    }



}

