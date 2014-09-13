package net.ringum;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class X816TokenType extends IElementType {
    public X816TokenType(@NotNull @NonNls String debugName) {
        super(debugName, X816Language.INSTANCE);
    }

    @Override
    public String toString() {
        return "X816:" + super.toString();
    }
}
