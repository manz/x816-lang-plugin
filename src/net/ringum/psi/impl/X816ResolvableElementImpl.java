package net.ringum.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiReference;
import net.ringum.X816Reference;


public class X816ResolvableElementImpl extends ASTWrapperPsiElement {
    public X816ResolvableElementImpl(ASTNode astNode) {
        super(astNode);
    }

    @Override
    public PsiReference getReference() {
        return new X816Reference(this, TextRange.allOf(this.getText()));
    }
}
