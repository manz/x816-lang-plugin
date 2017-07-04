package net.ringum.formatter;

import com.intellij.formatting.*;
import com.intellij.json.formatter.JsonBlock;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by emmanuel on 06/10/2014.
 */
public class X816FormattingModelBuilder implements FormattingModelBuilder {

    @NotNull
    public FormattingModel createModel(PsiElement psiElement, CodeStyleSettings codeStyleSettings) {
        JsonBlock jsonBlock = new JsonBlock((JsonBlock)null, psiElement.getNode(), codeStyleSettings, (Alignment)null, Indent.getNoneIndent(), (Wrap)null);
        return FormattingModelProvider.createFormattingModelForPsiFile(psiElement.getContainingFile(), jsonBlock, codeStyleSettings);
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile psiFile, int i, ASTNode astNode) {
        return null;
    }
}
