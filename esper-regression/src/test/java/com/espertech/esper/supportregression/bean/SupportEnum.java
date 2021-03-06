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
package com.espertech.esper.supportregression.bean;

public enum SupportEnum
{
    ENUM_VALUE_1,
    ENUM_VALUE_2,
    ENUM_VALUE_3;

    public static SupportEnum getValueForEnum(int count)
    {
        return SupportEnum.values()[count]; 
    }

}
