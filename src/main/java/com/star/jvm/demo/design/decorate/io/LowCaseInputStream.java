package com.star.jvm.demo.design.decorate.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义io装饰者类 继承FilterInputStream(是inputStream的抽象装饰者)
 */
public class LowCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    public LowCaseInputStream(InputStream in) {
        super(in);
    }

    /**
     * 覆盖字节读取方法
     * @return
     * @throws IOException
     */
    @Override
    public int read() throws IOException {
        int c = super.read();;
        return (c==-1?c:Character.toLowerCase((char) c));
    }

    /**
     * 覆盖字节数组读取方法
     * @param b
     * @param off
     * @param len
     * @return
     * @throws IOException
     */
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int c = super.read(b, off, len);
        for(int i=off;i<off+len;i++){
            b[i] = (byte)Character.toLowerCase((char) b[i]);
        }
        return c;
    }
}
