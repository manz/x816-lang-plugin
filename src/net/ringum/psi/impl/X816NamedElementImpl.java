package net.ringum.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import net.ringum.psi.X816NamedElement;

public abstract class X816NamedElementImpl extends ASTWrapperPsiElement implements X816NamedElement {
    public X816NamedElementImpl(ASTNode astNode) {
        super(astNode);
    }
}
