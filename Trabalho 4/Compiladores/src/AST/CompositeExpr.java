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

	public StringBuffer genC() {
                StringBuffer aux = new StringBuffer();
                StringBuffer simp;
                StringBuffer exp;
                
		simp = simexpr.genC();
                aux.append(simp);
                
                if(relOp != null && expr != null){
                    aux.append(" "+ relOp +" ");
                    exp = expr.genC();
                    aux.append(exp);
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
