package net.ringum.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiElement;
import net.ringum.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class X816PsiImplUtil {

    public static String getLabelName(X816LabelDef element) {
        String symbolName = element.getText();
        return symbolName.substring(0, symbolName.length() - 1);
    }

    public static String getName(X816LabelDef element) {
        return getLabelName(element);
    }

    public static String getName(X816SymbolAffectation element) {
        ASTNode symbol = element.getNode().findChildByType(X816Types.SYMBOL);
        if (symbol != null) {
            return symbol.getText();
        }
        return null;
    }

    public static String getName(X816MacroDef macroDef) {
        ASTNode symbol = macroDef.getNode().findChildByType(X816Types.SYMBOL);
        if (symbol != null) {
            return symbol.getText();
        }
        return null;
    }

    public static String getName(X816MacroDefSymbol macroDefSymbol) {
        return macroDefSymbol.getNode().getText();
    }

    public static String getName(X816NamedScopeDef namedScopeDef) {
        ASTNode symbol = namedScopeDef.getNode().findChildByType(X816Types.SYMBOL);
        if (symbol != null) {
            return symbol.getText();
        }
        return null;
    }

    public static String getName(X816ForDirective forDirective) {
        ASTNode symbol = forDirective.getNode().findChildByType(X816Types.SYMBOL);
        if (symbol != null) {
            return symbol.getText();
        }
        return null;
    }

    public static PsiElement getNameIdentifier(X816LabelDef element) {
        ASTNode keyNode = element.getNode().findChildByType(X816Types.LABEL);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(X816SymbolAffectation element) {
        ASTNode keyNode = element.getNode().findChildByType(X816Types.SYMBOL);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(X816MacroDef element) {
        ASTNode keyNode = element.getNode().findChildByType(X816Types.SYMBOL);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(X816NamedScopeDef element) {
        ASTNode keyNode = element.getNode().findChildByType(X816Types.SYMBOL);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }


    public static PsiElement getNameIdentifier(X816MacroDefSymbol element) {
        ASTNode keyNode = element.getNode();
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(X816ForDirective element) {
        ASTNode keyNode = element.getNode().findChildByType(X816Types.SYMBOL);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement setName(X816LabelDef element, String newName) {
        return element;
    }

    public static PsiElement setName(X816SymbolAffectation element, String newName) {
        return element;
    }

    public static PsiElement setName(X816MacroDef element, String newName) {
        return element;
    }

    public static PsiElement setName(X816MacroDefSymbol element, String newName) {
        return element;
    }

    public static PsiElement setName(X816NamedScopeDef element, String newName) {
        return element;
    }

    public static PsiElement setName(X816ForDirective element, String newName) {
        return element;
    }



    /** Go to contributor ?**/
    public static ItemPresentation getPresentation(final X816NamedElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return IconLoader.getIcon("/net/ringum/icon/yoshi.png");
            }
        };
    }
}
