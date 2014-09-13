package net.ringum;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class X816File extends PsiFileBase {
    public X816File(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, X816Language.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return X816FileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "X816 File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}