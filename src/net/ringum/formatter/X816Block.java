package net.ringum.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by emmanuel on 04/11/2015.
 */
public class X816Block implements ASTBlock {

    @Override
    public ASTNode getNode() {
        return null;
    }

    @NotNull
    @Override
    public TextRange getTextRange() {
        return null;
    }

    @NotNull
    @Override
    public List<Block> getSubBlocks() {
        return null;
    }

    @Nullable
    @Override
    public Wrap getWrap() {
        return null;
    }

    @Nullable
    @Override
    public Indent getIndent() {
        return null;
    }

    @Nullable
    @Override
    public Alignment getAlignment() {
        return null;
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block block, @NotNull Block block1) {
        return null;
    }

    @NotNull
    @Override
    public ChildAttributes getChildAttributes(int i) {
        return null;
    }

    @Override
    public boolean isIncomplete() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
