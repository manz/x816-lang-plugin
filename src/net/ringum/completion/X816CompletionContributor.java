package net.ringum.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import net.ringum.X816File;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PsiJavaPatterns.psiElement;

/**
 * Created by emmanuel on 21/04/2017.
 */
public class X816CompletionContributor extends CompletionContributor {
    public X816CompletionContributor() {
        super();
/*
        extend(CompletionType.BASIC, psiElement().inFile(psiElement(X816File.class)), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
                LookupElementBuilder lookup = LookupElementBuilder.create();

                completionResultSet.addElement(lookup.);
            }
        });
        */
        /*
        extend(CompletionType.BASIC, psiElement().inFile(psiElement(GherkinFile.class)), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters,
                                          ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                final PsiFile psiFile = parameters.getOriginalFile();
                if (psiFile instanceof GherkinFile) {
                    final PsiElement position = parameters.getPosition();

                    // if element isn't under feature declaration - suggest feature in autocompletion
                    // but don't suggest scenario keywords inside steps
                    final PsiElement coveringElement = PsiTreeUtil.getParentOfType(position, GherkinStep.class, GherkinFeature.class, PsiFileSystemItem.class);
                    if (coveringElement instanceof PsiFileSystemItem) {
                        addFeatureKeywords(result, psiFile);
                    } else if (coveringElement instanceof GherkinFeature) {
                        addScenarioKeywords(result, psiFile, position);
                    }
                }
            }
        });*/
    }
}
