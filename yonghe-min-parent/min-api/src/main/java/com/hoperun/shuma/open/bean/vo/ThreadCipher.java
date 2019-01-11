package com.hoperun.shuma.open.bean.vo;

import javax.crypto.Cipher;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 11/1/2018
 * Time: 02:51 PM
 */
public class ThreadCipher {

    private static final ThreadLocal<Cipher> threadLocal = new ThreadLocal<Cipher>();

    public static void set( Cipher cipher) throws Exception {

        threadLocal.set(cipher);
    }

    public static Cipher get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
