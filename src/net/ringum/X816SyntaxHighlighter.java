package net.ringum;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.ui.JBColor;
import net.ringum.lexer.X816LexerAdapter;
import net.ringum.psi.X816Types;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class X816SyntaxHighlighter extends SyntaxHighlighterBase {
    private Map<IElementType, TextAttributesKey> keys;


    public static final TextAttributesKey EQUAL = createTextAttributesKey("EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey LABEL = createTextAttributesKey("LABEL", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey SYMBOL = createTextAttributesKey("SYMBOL", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey OPCODE = createTextAttributesKey("OPCODE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER",
            new TextAttributes(JBColor.RED, null, null, null, Font.BOLD));

    public static final TextAttributesKey STRING = createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey MACRO_CALL = createTextAttributesKey("MACRO_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey MACRO_DEF = createTextAttributesKey("MACRO_DEF", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    private static final TokenSet assembler_directives = TokenSet.create(
            X816Types.INCLUDE,
            X816Types.INCBIN,
            X816Types.MACRO,
            X816Types.DB,
            X816Types.DW,
            X816Types.DL,
            X816Types.NAMED_SCOPE,
            X816Types.POINTER,
            X816Types.STAREQ,
            X816Types.TABLE,
            X816Types.TEXT,
            X816Types.FOR,
            X816Types.IF,
            X816Types.ELSE,
            X816Types.ENDIF
    );

    private static final TokenSet numbers = TokenSet.create(
            X816Types.DECNUMBER,
            X816Types.HEXNUMBER,
            X816Types.BINARYNUMBER
    );

    public X816SyntaxHighlighter() {
        this.keys = new HashMap<IElementType, TextAttributesKey>();

        fillMap(this.keys, assembler_directives, KEYWORD);
        fillMap(this.keys, numbers, NUMBER);

        this.keys.put(X816Types.SYMBOL, SYMBOL);
        this.keys.put(X816Types.OPCODE, OPCODE);
        this.keys.put(X816Types.LABEL, LABEL);
        this.keys.put(X816Types.EQUAL, EQUAL);
        this.keys.put(X816Types.COMMENT, COMMENT);
        this.keys.put(X816Types.QUOTED_STRING, STRING);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new X816LexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(this.keys.get(tokenType));
    }
}