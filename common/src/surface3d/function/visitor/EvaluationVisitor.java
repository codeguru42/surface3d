/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package surface3d.function.visitor;

import java.util.Map;
import surface3d.function.AdditionExpression;
import surface3d.function.ConstantExpression;
import surface3d.function.DivisionExpression;
import surface3d.function.ExponentialExpression;
import surface3d.function.Function;
import surface3d.function.MultiplicationExpression;
import surface3d.function.NegativeExpression;
import surface3d.function.SubtractionExpression;
import surface3d.function.VariableExpression;

public class EvaluationVisitor implements FunctionVisitor {

    public EvaluationVisitor(Map<String, Double> values) {
        this.values = values;
    }

    public static double evaluate(Function func, Map<String, Double> values) {
        EvaluationVisitor vis = new EvaluationVisitor(values);

        func.accept(vis);

        return vis.getValue();
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public void visit(Function func) {
        func.getExpression().accept(this);
    }

    @Override
    public void visit(ExponentialExpression exp) {
        exp.getLhs().accept(this);
        double base = this.value;
        exp.getRhs().accept(this);
        this.value = Math.pow(base, this.value);
    }

    @Override
    public void visit(MultiplicationExpression prod) {
        prod.getLhs().accept(this);
        double lhs = this.value;
        prod.getRhs().accept(this);
        this.value = lhs * this.value;
    }

    @Override
    public void visit(DivisionExpression quot) {
        quot.getLhs().accept(this);
        double lhs = this.value;
        quot.getRhs().accept(this);
        this.value = lhs / this.value;
    }

    @Override
    public void visit(AdditionExpression sum) {
        sum.getLhs().accept(this);
        double lhs = this.value;
        sum.getRhs().accept(this);
        this.value = lhs + this.value;
    }

    @Override
    public void visit(SubtractionExpression diff) {
        diff.getLhs().accept(this);
        double lhs = this.value;
        diff.getRhs().accept(this);
        this.value = lhs - this.value;
    }

    @Override
    public void visit(NegativeExpression neg) {
        neg.getOperand().accept(this);
        this.value = -this.value;
    }

    @Override
    public void visit(VariableExpression var) {
        this.value = this.values.get(var.getName());
    }

    @Override
    public void visit(ConstantExpression val) {
        this.value = val.getValue();
    }
    private Map<String, Double> values = null;
    private double value = 0.0;
}
