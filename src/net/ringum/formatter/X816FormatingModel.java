package net.ringum.formatter;

import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingDocumentModel;
import com.intellij.formatting.FormattingModel;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;

/*
 * Created by emmanuel on 06/10/2014.
 */

public class X816FormatingModel implements FormattingModel {
    @NotNull
    @Override
    public Block getRootBlock() {
        return null;
    }

    @NotNull
    @Override
    public FormattingDocumentModel getDocumentModel() {
        return null;
    }

    @Override
    public TextRange replaceWhiteSpace(TextRange textRange, String s) {
        return null;
    }

    @Override
    public TextRange shiftIndentInsideRange(ASTNode node, TextRange textRange, int i) {
        return null;
    }

    @Override
    public void commitChanges() {

    }
}
