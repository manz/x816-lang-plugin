package net.ringum;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import net.ringum.psi.X816LabelDef;
import net.ringum.psi.X816Types;
import org.jetbrains.annotations.NotNull;

public class X816ReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(X816LabelDef.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {

                        String text = element.getText();
                        if (element.getNode().getElementType().equals(X816Types.LABEL_DEF)) {
                            return new PsiReference[]{new X816Reference(element, new TextRange(0, text.length() + 1))};
                        }
                        return new PsiReference[0];
                    }
                });
    }
}
