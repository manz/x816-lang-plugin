package net.ringum;
import com.intellij.formatting.FormattingDocumentModel;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiFile;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import org.jetbrains.annotations.NotNull;

/**
 * Created by emmanuel on 21/04/2017.
 */
public class X816FormatingDocumentModel extends FormattingDocumentModelImpl {
    public X816FormatingDocumentModel(@NotNull Document document, PsiFile file) {
        super(document, file);
    }
}
