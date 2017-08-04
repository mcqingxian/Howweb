package com.hoau.how.module.bse.server.xss;

import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.ng.ExecuteOperations;
import org.apache.struts2.dispatcher.ng.HostConfig;
import org.apache.struts2.dispatcher.ng.InitOperations;
import org.apache.struts2.dispatcher.ng.PrepareOperations;
import org.apache.struts2.dispatcher.ng.filter.FilterHostConfig;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MStrutsPrepareAndExecuteFilter extends StrutsPrepareAndExecuteFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        InitOperations init = new InitOperations();
        Dispatcher dispatcher = null;
        try {
            FilterHostConfig config = new FilterHostConfig(filterConfig);
            init.initLogging(config);
            dispatcher = initDispatcher(config);
            init.initStaticContentLoader(config, dispatcher);

            prepare = new PrepareOperations( dispatcher);
            execute = new ExecuteOperations( dispatcher);
            this.excludedPatterns = init.buildExcludedPatternsList(dispatcher);

            postInit(dispatcher, filterConfig);
        } finally {
            if (dispatcher != null) {
                dispatcher.cleanUpAfterInit();
            }
            init.cleanup();
        }
    }

    /**
     * Creates and initializes the dispatcher
     */
    public Dispatcher initDispatcher(HostConfig filterConfig) {
        Dispatcher dispatcher = createDispatcher(filterConfig);
        dispatcher.init();
        return dispatcher;
    }

    /**
     * Create a {@link Dispatcher}
     */
    private Dispatcher createDispatcher(HostConfig filterConfig) {
        Map<String, String> params = new HashMap<String, String>();
        for (Iterator e = filterConfig.getInitParameterNames(); e.hasNext();) {
            String name = (String) e.next();
            String value = filterConfig.getInitParameter(name);
            params.put(name, value);
        }
        return new MDispatcher(filterConfig.getServletContext(), params);
    }

}
