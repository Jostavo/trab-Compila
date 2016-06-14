/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST;

import Lexer.Symbol;

/**
 *
 * @author ricke
 */
public class CompositeExpr extends Expr{
	private SimExpr simexpr;
	private String relOp;
	private CompositeExpr expr;

	public CompositeExpr(SimExpr simexpr, String relOp, CompositeExpr expr, Symbol type) {
		this.simexpr = simexpr;
		this.relOp = relOp;
		this.expr = expr;
		this.type = type;
	}
	
	public boolean onlySimExpr(){
		return (expr == null)&&(simexpr != null) ? true: false;
	}

	public SimExpr getSimexpr() {
		return simexpr;
	}

	public String getRelOp() {
		return relOp;
	}

	public CompositeExpr getExpr() {
		return expr;
	}

	public StringBuffer genC(Integer tabs) {
                StringBuffer aux = new StringBuffer();
                StringBuffer tab = new StringBuffer();
                Integer i;
                
                for (i = 0; i < tabs; i++) {
                    tab.append("\t");
		}
                
                aux.append(tab);
                aux.append(simexpr.genC(0));
                
                if(relOp != null && expr != null){
                    aux.append(" "+ relOp +" ");
                    aux.append(expr.genC(0));
                }
                
                return aux;
	}
	
	private Symbol type;

	public Symbol getType() {
		return type;
	}

	public void setType(Symbol type) {
		this.type = type;
	}
	
}
