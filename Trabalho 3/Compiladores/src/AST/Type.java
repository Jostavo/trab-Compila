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
public class Type {
	private boolean array;
	private Symbol type;
        private Integer size;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

	public boolean isArray() {
		return array;
	}

	public void setArray(boolean array) {
		this.array = array;
	}

	public Symbol getType() {
		return type;
	}

	public void setType(Symbol type) {
		this.type = type;
	}

	public Type(Symbol type, boolean array, Integer aux){
		this.array = array;
		this.type = type;
                this.size = aux;
	}
}
