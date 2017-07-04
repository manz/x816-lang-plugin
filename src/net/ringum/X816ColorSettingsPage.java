package net.ringum;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class X816ColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Label", X816SyntaxHighlighter.LABEL),
            new AttributesDescriptor("Symbol", X816SyntaxHighlighter.SYMBOL),
            new AttributesDescriptor("Comment", X816SyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Opcode", X816SyntaxHighlighter.OPCODE),
            new AttributesDescriptor("Number", X816SyntaxHighlighter.NUMBER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/net/ringum/icon/yoshi.png");
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new X816SyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "; my nice comment\n" +
                "var = 0x00\n"+
                "start_dma_transfer:\n" +
                "pha\n" +
                "lda.b #var\n" +
                "pla\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "X816";
    }
}