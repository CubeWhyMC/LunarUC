package org.cubewhy.lunarcn

import org.objectweb.asm.tree.ClassNode

abstract class Patch {
    abstract fun transform(cn: ClassNode): Boolean
}