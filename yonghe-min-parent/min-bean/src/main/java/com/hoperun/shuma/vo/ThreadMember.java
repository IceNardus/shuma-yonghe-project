package com.hoperun.shuma.vo;

import com.hoperun.shuma.vo.par.MinMember;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 7/4/2018
 * Time: 3:28 PM
 */
public class ThreadMember {
    private static final ThreadLocal<MinMember> threadLocalMember = new ThreadLocal<>();

    public static void set(MinMember MinMember) {
        threadLocalMember.set(MinMember);
    }

    public static MinMember get() {
        return threadLocalMember.get();
    }

    public static void remove() {
        threadLocalMember.remove();
    }
}
