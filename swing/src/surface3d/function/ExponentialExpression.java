package surface3d.function;

import surface3d.function.visitor.FunctionVisitor;

public class ExponentialExpression extends BinaryExpression {

	public ExponentialExpression(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(FunctionVisitor vis) {
		vis.visit(this);
	}

}
