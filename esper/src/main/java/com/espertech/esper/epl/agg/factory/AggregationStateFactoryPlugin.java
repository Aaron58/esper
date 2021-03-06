/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.epl.agg.factory;

import com.espertech.esper.epl.agg.access.AggregationServicePassThru;
import com.espertech.esper.epl.agg.access.AggregationState;
import com.espertech.esper.epl.agg.service.AggregationStateFactory;
import com.espertech.esper.epl.expression.accessagg.ExprPlugInAggMultiFunctionNodeFactory;
import com.espertech.esper.epl.expression.core.ExprNode;
import com.espertech.esper.plugin.PlugInAggregationMultiFunctionStateContext;
import com.espertech.esper.plugin.PlugInAggregationMultiFunctionStateFactory;

public class AggregationStateFactoryPlugin implements AggregationStateFactory {

    protected final ExprPlugInAggMultiFunctionNodeFactory parent;
    protected final PlugInAggregationMultiFunctionStateFactory stateFactory;

    public AggregationStateFactoryPlugin(ExprPlugInAggMultiFunctionNodeFactory parent) {
        this.parent = parent;
        this.stateFactory = parent.getHandlerPlugin().getStateFactory();
    }

    public AggregationState createAccess(int agentInstanceId, boolean join, Object groupBy, AggregationServicePassThru passThru) {
        PlugInAggregationMultiFunctionStateContext context = new PlugInAggregationMultiFunctionStateContext(agentInstanceId, groupBy);
        return stateFactory.makeAggregationState(context);
    }

    public ExprNode getAggregationExpression() {
        return parent.getAggregationExpression();
    }
}
