# X816 build instructions

Install `Grammar-Kit`, `JFlex` and `PsiViewer`.

Right click on X816.bnf and select `Generate Parser Code`, right click on X816.flex and select `Run JFlex Generator`.
This should generate the lexer and the grammar.
Now you can build the `x816-lang-plugin` and have some fun with `a816`.

Notes:
The symbol resolution does not support scoped symbols (`scope`.`symbol name`).
