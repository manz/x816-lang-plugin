package net.ringum.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import net.ringum.psi.X816NamedElement;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class X816NamedElementImpl extends ASTWrapperPsiElement implements X816NamedElement {
    public X816NamedElementImpl(ASTNode astNode) {
        super(astNode);
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
