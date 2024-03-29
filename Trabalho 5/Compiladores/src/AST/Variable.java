/* 
* Trabalho de Compiladores - Final
* Gustavo Rodrigues RA 489999
* Henrique Teruo Eihara RA 490016
 */
package AST;

public class Variable extends Expr {

    private Type type;
    private String name; // nome da variável no caso feita pelo ident
    private Boolean formals;

    public Variable(String name, Type type, Boolean formals) {
        this.type = type;
        this.name = name;
        this.formals = formals;
    }

    public Type getType() {
        return this.type;
    }

    public String getName() {
        return name;
    }

    public StringBuffer genC(Integer tabs) {
        StringBuffer aux = new StringBuffer();
        StringBuffer tab = new StringBuffer();

        Integer i;
        for (i = 0; i < tabs; i++) {
            tab.append("\t");
        }

        aux.append(tab);
        aux.append(type.genC(0));
        aux.append(" ");
        aux.append(name);
        aux.append(" ");
        if (type.isArray() == true) {
            aux.append("[" + type.getSize() + "]");
        }

        if (formals == false) {
            aux.append(";");
        }

        return aux;
    }
}
