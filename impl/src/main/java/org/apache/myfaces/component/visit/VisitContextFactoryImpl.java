/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.myfaces.component.visit;

import java.util.Collection;
import java.util.Set;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitContextFactory;
import javax.faces.component.visit.VisitHint;
import javax.faces.context.FacesContext;

/**
 * @author Werner Punz (latest modification by $Author$)
 * @version $Rev$ $Date$ 
 * Implementation of the VisitContextFactory!
 */
public class VisitContextFactoryImpl extends VisitContextFactory
{

    public VisitContextFactoryImpl()
    {
    }

    @Override
    public VisitContext getVisitContext(FacesContext context, Collection<String> ids, Set<VisitHint> hints)
    {
        if (ids == null || ids.isEmpty())
        {
            return new FullVisitContext(context, hints);
        }
        else
        {
            return new PartialVisitContext(context, ids, hints);
        }
    }
}
