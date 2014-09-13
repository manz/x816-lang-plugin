package net.ringum.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import net.ringum.psi.X816Types;
import com.intellij.psi.TokenType;

%%

%class X816Lexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%ignorecase
//%eof{  return;
//%eof}

DECNUMBER=[0-9]+
BINARYNUMBER=0b[01]+
HEXNUMBER=0x[0-9a-fA-F]+
QUOTED_STRING='[^']*'
LABEL=[_a-zA-Z][_a-zA-Z0-9]*:
LPAREN=\(
RPAREN=\)
RBRACE=\}
LBRACE=\{
LBRAKET=\[
RBRAKET=\]
SHARP=\#
SYMBOL=[_a-zA-Z][_a-zA-Z0-9]*
OPCODE_NAKED=(cpx|php|trb|clc|dey|pea|pla|inx|plb|asl|ldy|bpl|tay|plx|rtl|txa|plp|pha|dex|dec|tdc|tsb|iny|sed|tcd|sty|wai|phx|bra|xba|txs|tax|ror|cmp|cpy|ply|xce|sbc|ldx|inc|tsc|stz|beq|stx|stp|adc|txy|rts|phy|bne|bit|tya|brk|sta|sei|sec|ora|bcc|tcs|bcs|rep|rti|and|tyx|nop|lda|rol|lsr|jmp|tsx|jsr|phb|sep|bmi)

OPCODE_WITH_SIZE=(cpx|php|trb|clc|dey|pea|pla|inx|plb|asl|ldy|bpl|tay|plx|rtl|txa|plp|pha|dex|dec|tdc|tsb|iny|sed|tcd|sty|wai|phx|bra|xba|txs|tax|ror|cmp|cpy|ply|xce|sbc|ldx|inc|tsc|stz|beq|stx|stp|adc|txy|rts|phy|bne|bit|tya|brk|sta|sei|sec|ora|bcc|tcs|bcs|rep|rti|and|tyx|nop|lda|rol|lsr|jmp|tsx|jsr|phb|sep|bmi)\.[bBwWlL]

POINTER=\.pointer
INCBIN=\.incbin
STAREQ=\*=
TABLE=\.table
DB=\.db
INCLUDE=\.include
TEXT=\.text
DW=\.dw

MACRO=\.macro
COMMA=,
INDEX=,\ ?[XxYySs]
AND=&
EQUAL==
WHITE_SPACE=[ \t]+
NEWLINE=\n+

PLUS=\+
MINUS=\-
MULT=\*
RSHIFT=>>
LSHIFT=<<
//%state WAITING_VALUE

COMMENT=;[^\n]*
%%


{LABEL}                                                     { return X816Types.LABEL;}
{OPCODE_NAKED}                                              { return X816Types.OPCODE_NAKED;}
{OPCODE_WITH_SIZE}                                          { return X816Types.OPCODE_WITH_SIZE;}
{INDEX}                                                     { return X816Types.INDEX;}

{POINTER}                                                   {return X816Types.POINTER;}
{INCBIN}                                                    {return X816Types.INCBIN;}
{STAREQ}                                                    {return X816Types.STAREQ;}
{TABLE}                                                     {return X816Types.TABLE;}
{DB}                                                        {return X816Types.DB;}
{INCLUDE}                                                   {return X816Types.INCLUDE;}
{TEXT}                                                      {return X816Types.TEXT;}
{DW}                                                        {return X816Types.DW;}


{MACRO}                                                     {return X816Types.MACRO;}
{COMMA}                                                     {return X816Types.COMMA;}

{RBRACE}                                                    { return X816Types.RBRACE; }
{LBRACE}                                                    { return X816Types.LBRACE; }
{RPAREN}                                                    { return X816Types.RPAREN; }
{LPAREN}                                                    { return X816Types.LPAREN; }

{RBRAKET}                                                   { return X816Types.RBRAKET; }
{LBRAKET}                                                   { return X816Types.LBRAKET; }

{SYMBOL}                                                    { return X816Types.SYMBOL;}

{EQUAL}                                                     { return X816Types.EQUAL;}

{DECNUMBER}                                                 { return X816Types.DECNUMBER;}
{BINARYNUMBER}                                              { return X816Types.BINARYNUMBER;}
{HEXNUMBER}                                                 { return X816Types.HEXNUMBER;}

{COMMENT}                                                   { return X816Types.COMMENT;}

{SHARP}                                                     { return X816Types.SHARP;}
{WHITE_SPACE}                                               { return TokenType.WHITE_SPACE;}
{NEWLINE}                                                   { return X816Types.NEWLINE;}

{QUOTED_STRING} { return X816Types.QUOTED_STRING;}

{PLUS}          { return X816Types.PLUS; }
{MINUS}         { return X816Types.MINUS; }
{MULT}          { return X816Types.MULT; }
{RSHIFT}        { return X816Types.RSHIFT;}
{LSHIFT}        { return X816Types.LSHIFT;}
{AND}        { return X816Types.AND;}


.                                                           { return TokenType.BAD_CHARACTER; }

/*
<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return SimpleTypes.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return SimpleTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return SimpleTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}                                     { yybegin(YYINITIAL); return SimpleTypes.CRLF; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return SimpleTypes.VALUE; }

{CRLF}                                                     { yybegin(YYINITIAL); return SimpleTypes.CRLF; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }*/
