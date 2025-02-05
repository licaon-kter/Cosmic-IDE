/*
 * This file is part of Cosmic IDE.
 * Cosmic IDE is a free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * Cosmic IDE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with Cosmic IDE. If not, see <https://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Cosmic IDE.
 * Cosmic IDE is a free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * Cosmic IDE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with Cosmic IDE. If not, see <https://www.gnu.org/licenses/>.
 */

/*
 *  This file is part of CodeAssist.
 *
 *  CodeAssist is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  CodeAssist is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with CodeAssist.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.tyron.javacompletion.parser.classfile;

import com.google.auto.value.AutoValue;

/**
 * cp_info structure in a .class file.
 *
 * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4">...</a>
 */
public class ConstantPoolInfo {

    /**
     * CONSTANT_Class_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.1">...</a>
     */
    @AutoValue
    public abstract static class ConstantClassInfo extends ConstantPoolInfo {
        public static ConstantClassInfo create(int nameIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantClassInfo(nameIndex);
        }

        /**
         * An index into the constant pool table for the class name.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantUtf8Info} representing a
         * valid binary class or interface name encoded in internal form.
         */
        public abstract int getNameIndex();
    }

    /**
     * ConstantFieldRefInfo structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.2">...</a>
     */
    @AutoValue
    public abstract static class ConstantFieldRefInfo extends ConstantPoolInfo {
        public static ConstantFieldRefInfo create(int classIndex, int nameAndTypeIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantFieldRefInfo(classIndex, nameAndTypeIndex);
        }

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantClassInfo}.
         */
        public abstract int getClassIndex();

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantNameAndTypeInfo}.
         */
        public abstract int getNameAndTypeIndex();
    }

    /**
     * CONSTANT_Methodref_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.2">...</a>
     */
    @AutoValue
    public abstract static class ConstantMethodrefInfo extends ConstantPoolInfo {
        public static ConstantMethodrefInfo create(int classIndex, int nameAndTypeIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantMethodrefInfo(classIndex, nameAndTypeIndex);
        }

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantClassInfo}.
         */
        public abstract int getClassIndex();

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantNameAndTypeInfo}.
         */
        public abstract int getNameAndTypeIndex();
    }

    /**
     * CONSTANT_InterfaceMethodref_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.2">...</a>
     */
    @AutoValue
    public abstract static class ConstantInterfaceMethodrefInfo extends ConstantPoolInfo {
        public static ConstantInterfaceMethodrefInfo create(int classIndex, int nameAndTypeIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantInterfaceMethodrefInfo(
                    classIndex, nameAndTypeIndex);
        }

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantClassInfo}.
         */
        public abstract int getClassIndex();

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantNameAndTypeInfo}.
         */
        public abstract int getNameAndTypeIndex();
    }

    /**
     * CONSTANT_String_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.3">...</a>
     */
    @AutoValue
    public abstract static class ConstantStringInfo extends ConstantPoolInfo {
        public static ConstantStringInfo create(int stringIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantStringInfo(stringIndex);
        }

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantUtf8Info}.
         */
        public abstract int getStringIndex();
    }

    /**
     * CONSTANT_Integer_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.4">...</a>
     */
    @AutoValue
    public abstract static class ConstantIntegerInfo extends ConstantPoolInfo {
        public static ConstantIntegerInfo create(int value) {
            return new AutoValue_ConstantPoolInfo_ConstantIntegerInfo(value);
        }

        /**
         * The value of the integer.
         */
        public abstract int getValue();
    }

    /**
     * CONSTANT_Float_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.4">...</a>
     */
    @AutoValue
    public abstract static class ConstantFloatInfo extends ConstantPoolInfo {
        public static ConstantFloatInfo create(float value) {
            return new AutoValue_ConstantPoolInfo_ConstantFloatInfo(value);
        }

        /**
         * The value of the float.
         */
        public abstract float getValue();
    }

    /**
     * CONSTANT_Long_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.5">...</a>
     */
    @AutoValue
    public abstract static class ConstantLongInfo extends ConstantPoolInfo {
        public static ConstantLongInfo create(long value) {
            return new AutoValue_ConstantPoolInfo_ConstantLongInfo(value);
        }

        /**
         * The value of the long.
         */
        public abstract long getValue();
    }

    /**
     * CONSTANT_Double_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.5">...</a>
     */
    @AutoValue
    public abstract static class ConstantDoubleInfo extends ConstantPoolInfo {
        public static ConstantDoubleInfo create(double value) {
            return new AutoValue_ConstantPoolInfo_ConstantDoubleInfo(value);
        }

        /**
         * The value of the double.
         */
        public abstract double getValue();
    }

    /**
     * CONSTANT_NameAndType_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.6">...</a>
     */
    @AutoValue
    public abstract static class ConstantNameAndTypeInfo extends ConstantPoolInfo {
        public static ConstantNameAndTypeInfo create(int nameIndex, int descriptorIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantNameAndTypeInfo(nameIndex, descriptorIndex);
        }

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantUtf8Info}. It's either a
         * special method name {@code <init>}, or a valid unqualified name denoting a field or method.
         */
        public abstract int getNameIndex();

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantUtf8Info} representing a
         * valid field descriptor or method descriptor.
         */
        public abstract int getDescriptorIndex();
    }

    /**
     * CONSTANT_Utf8_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.7">...</a>
     */
    @AutoValue
    public abstract static class ConstantUtf8Info extends ConstantPoolInfo {
        public static ConstantUtf8Info create(String value) {
            return new AutoValue_ConstantPoolInfo_ConstantUtf8Info(value);
        }

        /**
         * The value of the UTF-8 string.
         */
        public abstract String getValue();
    }

    /**
     * CONSTANT_MethodHandle_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.8">...</a>
     */
    @AutoValue
    public abstract static class ConstantMethodHandleInfo extends ConstantPoolInfo {
        public static ConstantMethodHandleInfo create(byte referenceKind, int referenceIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantMethodHandleInfo(referenceKind, referenceIndex);
        }

        /**
         * The kind of this method handle, which characterizes its bytecode behavior.
         */
        public abstract byte getReferenceKind();

        /**
         * An index into the constant pool table.
         *
         * <p>The constant pool entry at that index must be as follows:
         *
         * <ol>
         *   <li>If the value of the {@link #getReferenceKind()} is 1 (REF_getField), 2 (REF_getStatic),
         *       3 (REF_putField), or 4 (REF_putStatic), then the constant pool entry at that index must
         *       be a {@link ConstantFieldRefInfo} structure representing a field for which a method
         *       handle is to be created.
         *   <li>If the value of the {@link #getReferenceKind()} is 5 (REF_invokeVirtual) or 8
         *       (REF_newInvokeSpecial), then the constant pool entry at that index must be a {@link
         *       ConstantMethodrefInfo} structure (§4.4.2) representing a class's method or constructor
         *       (§2.9) for which a method handle is to be created.
         *   <li>If the value of the {@link #getReferenceKind()} is 6 (REF_invokeStatic) or 7
         *       (REF_invokeSpecial), then if the class file version number is less than 52.0, the
         *       constant pool entry at that index must be a {@link ConstantMethodrefInfo} structure
         *       representing a class's method for which a method handle is to be created; if the class
         *       file version number is 52.0 or above, the constant_pool entry at that index must be
         *       either a {@link ConstantMethodrefInfo} structure or a {@link
         *       ConstantInterfaceMethodrefInfo} structure (§4.4.2) representing a class's or
         *       interface's method for which a method handle is to be created.
         *   <li>If the value of the {@link #getReferenceKind()} is 9 (REF_invokeInterface), then the
         *       constant_pool entry at that index must be a {@link ConstantInterfaceMethodrefInfo}
         *       structure representing an interface's method for which a method handle is to be
         *       created.
         * </ol>
         *
         * <p>If the value of the {@link #getReferenceKind()} is 5 (REF_invokeVirtual), 6
         * (REF_invokeStatic), 7 (REF_invokeSpecial), or 9 (REF_invokeInterface), the name of the method
         * represented by a {@link ConstantMethodrefInfo} structure or a {@link
         * ConstantInterfaceMethodrefInfo} structure must not be {@code <init>} or {@code <clinit>}.
         *
         * <p>If the value is 8 (REF_newInvokeSpecial), the name of the method represented by a {@link
         * ConstantMethodrefInfo} structure must be <init>.
         */
        public abstract int getReferenceIndex();
    }

    /**
     * CONSTANT_MethodType_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.9">...</a>
     */
    @AutoValue
    public abstract static class ConstantMethodTypeInfo extends ConstantPoolInfo {
        public static ConstantMethodTypeInfo create(int descriptorIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantMethodTypeInfo(descriptorIndex);
        }

        /**
         * An index into the constant pool table for the class name.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantUtf8Info}.
         */
        public abstract int getDescriptorIndex();
    }

    /**
     * CONSTANT_InvokeDynamic_info structure.
     *
     * <p>See <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.9">...</a>
     */
    @AutoValue
    public abstract static class ConstantInvokeDynamicInfo extends ConstantPoolInfo {
        public static ConstantInvokeDynamicInfo create(
                int boostrapMethodAttrIndex, int nameAndTypeIndex) {
            return new AutoValue_ConstantPoolInfo_ConstantInvokeDynamicInfo(
                    boostrapMethodAttrIndex, nameAndTypeIndex);
        }

        /**
         * A valid index into the bootstrap methods array of the bootstrap method table.
         */
        public abstract int getBootstrapMethodAttrIndex();

        /**
         * An index into the constant pool table for the class name.
         *
         * <p>The constant pool entry at the index must be a {@link ConstantNameAndTypeInfo}.
         */
        public abstract int getNameAndTypeIndex();
    }
}