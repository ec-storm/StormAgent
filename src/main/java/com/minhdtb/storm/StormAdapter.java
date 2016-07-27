package com.minhdtb.storm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class StormAdapter extends ClassVisitor {

    StormAdapter(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature,
                                     final String[] exceptions) {
        if (name.equals("setText")) {
            MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
            return new StormMethodVisitor(mv, access, name, desc);
        } else {
            return cv.visitMethod(access, name, desc, signature, exceptions);
        }
    }
}
