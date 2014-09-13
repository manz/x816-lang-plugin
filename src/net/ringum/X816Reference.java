package net.ringum;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import net.ringum.psi.X816NamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class X816Reference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String symbol;

    public X816Reference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        symbol = element.getText();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<X816NamedElement> labelsDef = X816Util.findLabelOrSymbolDef(project, symbol);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (X816NamedElement labelDef : labelsDef) {
            results.add(new PsiElementResolveResult(labelDef));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
//        Project project = myElement.getProject();
//        List<SimpleProperty> properties = SimpleUtil.findProperties(project);
//        List<LookupElement> variants = new ArrayList<LookupElement>();
//        for (final SimpleProperty property : properties) {
//            if (property.getKey() != null && property.getKey().length() > 0) {
//                variants.add(LookupElementBuilder.create(property).
//                                withIcon(SimpleIcons.FILE).
//                                withTypeText(property.getContainingFile().getName())
//                );
//            }
//        }
//        return variants.toArray();
        return new Object[]{};
    }
}