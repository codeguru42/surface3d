/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package surface3d.function;

import surface3d.function.visitor.FunctionVisitor;

public class AdditionExpression extends BinaryExpression {

    public AdditionExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public void accept(FunctionVisitor vis) {
        vis.visit(this);
    }
}
