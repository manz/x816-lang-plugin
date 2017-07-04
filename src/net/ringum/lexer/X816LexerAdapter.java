package net.ringum.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by emmanuel on 03/11/2015.
 */
public class X816LexerAdapter extends FlexAdapter {
    public X816LexerAdapter() {
        super(new X816Lexer((Reader) null));
    }
}
