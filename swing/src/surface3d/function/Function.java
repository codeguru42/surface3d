/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */

package surface3d.function;

import java.util.Collections;
import java.util.List;

import surface3d.function.visitor.FunctionVisitor;

public class Function {
	
	public Function(String name, List<String> vars, Expression exp) {
		this.name = name;
		this.vars = vars;
		this.exp = exp;
	}

	public void accept(FunctionVisitor vis) {
		vis.visit(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getVariables() {
		return Collections.unmodifiableList(vars);
	}
	
	public Expression getExpression() {
		return exp;
	}
	
	private String name = null;
	private List<String> vars = null;
	private Expression exp = null;

}
