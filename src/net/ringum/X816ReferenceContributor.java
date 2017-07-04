package net.ringum;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import javafx.application.Platform;
import net.ringum.psi.X816LabelDef;
import net.ringum.psi.X816MacroDef;
import net.ringum.psi.X816SymbolAffectation;
import net.ringum.psi.X816Types;
import org.jetbrains.annotations.NotNull;

public class X816ReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
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

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(X816MacroDef.class), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement, @NotNull ProcessingContext processingContext) {
                X816MacroDef macroDef = (X816MacroDef) psiElement;

                String name = macroDef.getName();
                if (name != null) {
                    return new PsiReference[]{new X816Reference(psiElement, new TextRange(0, name.length() + 1))};
                }
                else {
                    return PsiReference.EMPTY_ARRAY;
                }
            }
        });

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(X816SymbolAffectation.class), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement, @NotNull ProcessingContext processingContext) {
                X816SymbolAffectation symbolAffectation = (X816SymbolAffectation)psiElement;

                String name = symbolAffectation.getName();
                if (name != null) {
                    return new PsiReference[]{new X816Reference(psiElement, new TextRange(0, name.length() + 1))};
                }
                else {
                    return PsiReference.EMPTY_ARRAY;
                }
            }
        });
    }
}
