/*
Copyright 2017 Rice University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package edu.rice.cs.caper.bayou.application.dom_driver;

import com.google.gson.annotations.Expose;
import edu.rice.cs.caper.bayou.core.dsl.DSubTree;
import org.eclipse.jdt.core.dom.ReturnStatement;

public class DOMReturnStatement extends DOMStatement implements Handler {

    final ReturnStatement statement;

    @Expose
    final String node = "DOMReturnStatement";

    @Expose
    final DOMExpression _expression;

    public DOMReturnStatement(ReturnStatement statement) {
        this.statement = statement;
        this._expression = statement.getExpression() != null?
                new DOMExpression(statement.getExpression()).handleAML() : null;
    }

    @Override
    public DSubTree handle() {
        return new DOMExpression(statement.getExpression()).handle();
    }

    @Override
    public DOMReturnStatement handleAML() {
        return this;
    }
}
