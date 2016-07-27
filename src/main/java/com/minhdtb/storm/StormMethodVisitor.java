package com.minhdtb.storm;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

import java.util.ResourceBundle;

class StormMethodVisitor extends AdviceAdapter {

    StormMethodVisitor(int api, String owner, int access, String name, String desc, MethodVisitor mv) {
        super(Opcodes.ASM5, mv, access, name, desc);
    }

    StormMethodVisitor(MethodVisitor mv, int access, String name, String desc) {
        super(Opcodes.ASM5, mv, access, name, desc);
    }

    @Override
    protected void onMethodEnter() {

        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(46, l0);
        mv.visitVarInsn(ALOAD, 1);
        Label l1 = new Label();
        mv.visitJumpInsn(IFNULL, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(47, l2);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitLabel(l1);
        mv.visitLineNumber(49, l1);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

        mv.visitEnd();

    }

    private void testXXX(String value) {
        if (value != null) {
            System.out.println(value);
        }
    }
}
