package net.ringum;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class X816FileType extends LanguageFileType {
    public static final X816FileType INSTANCE = new X816FileType();

    private X816FileType() {
        super(X816Language.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "X816 file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "X816 language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "s";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/net/ringum/icon/yoshi.png");
    }
}
