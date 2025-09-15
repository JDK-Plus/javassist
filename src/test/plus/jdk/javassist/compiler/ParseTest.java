package plus.jdk.javassist.compiler;


import plus.jdk.javassist.compiler.ast.Stmnt;

public class ParseTest implements TokenId {
    public static void main(String[] args) throws CompileError {
	Parser p = new Parser(new Lex(args[0]));
	SymbolTable stb = new SymbolTable();
	// MethodDecl s = (MethodDecl)p.parseMember(stb);
	Stmnt s = p.parseStatement(stb);
	System.out.println(s == null ? "null" : s.toString());
    }
}
