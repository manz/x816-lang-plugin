package net.ringum;

import com.intellij.testFramework.ParsingTestCase;


public class X816ParsingTest extends ParsingTestCase {
    public X816ParsingTest() {
        super("", "s", new X816ParserDefinition());
    }

    public void testSimpleCode() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return "testData";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}
