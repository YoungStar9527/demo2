package com.star.jvm.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{

    private String myName = "";

    public MyClassLoader(String myName){
        this.myName = myName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        return defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String clsName){
        byte[] data = null;
        InputStream in = null;

        clsName = clsName.replace(".","/");
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();){
            in = new FileInputStream(new File("classes/"+clsName+".class"));
            int a = 0;
            while ((a = in.read())!=-1){
                out.write(a);
            }
            data = out.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
