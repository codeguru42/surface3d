/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */

package surface3d.function.visitor;

import surface3d.function.AdditionExpression;
import surface3d.function.ConstantExpression;
import surface3d.function.DivisionExpression;
import surface3d.function.ExponentialExpression;
import surface3d.function.Function;
import surface3d.function.MultiplicationExpression;
import surface3d.function.NegativeExpression;
import surface3d.function.SubtractionExpression;
import surface3d.function.VariableExpression;

public interface FunctionVisitor {
	
	public void visit(Function func);
	public void visit(ExponentialExpression exp);
	public void visit(MultiplicationExpression prod);
	public void visit(DivisionExpression quot);
	public void visit(AdditionExpression sum);
	public void visit(SubtractionExpression diff);
	public void visit(NegativeExpression neg);
	public void visit(VariableExpression var);
	public void visit(ConstantExpression val);
	
}
