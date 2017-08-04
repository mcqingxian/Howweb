package com.hoau.how.module.bse.server.xss;

import com.opensymphony.xwork2.LocaleProvider;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;
import org.apache.struts2.dispatcher.multipart.MultiPartRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MDispatcher extends Dispatcher {

    private static final Logger LOG = LoggerFactory.getLogger(MDispatcher.class);

    private boolean disableRequestAttributeValueStackLookup;

    private ServletContext servletContext;
    private Map<String, String> initParams;

    private String multipartSaveDir;

    /**
     * Store state of StrutsConstants.STRUTS_DEVMODE setting.
     */
    private boolean devMode;

    public MDispatcher(ServletContext servletContext, Map<String, String> initParams) {
        super(servletContext, initParams);
        this.servletContext = servletContext;
        this.initParams = initParams;
    }

    @Override
    public HttpServletRequest wrapRequest(HttpServletRequest request) throws IOException {
        // don't wrap more than once
        if (request instanceof StrutsRequestWrapper) {
            return request;
        }

        String content_type = request.getContentType();
        if (content_type != null && content_type.contains("multipart/form-data")) {
            MultiPartRequest mpr = getMultiPartRequest();
            LocaleProvider provider = getContainer().getInstance(LocaleProvider.class);
            request = new MMultiPartRequestWrapper(mpr, request, getSaveDir(), provider, disableRequestAttributeValueStackLookup);
        } else {
            request = new MStrutsRequestWrapper(request, disableRequestAttributeValueStackLookup);
        }

        return request;
    }

    private String getSaveDir() {
        String saveDir = multipartSaveDir.trim();

        if (saveDir.equals("")) {
            File tempdir = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            if (LOG.isInfoEnabled()) {
                LOG.info("Unable to find 'struts.multipart.saveDir' property setting. Defaulting to javax.servlet.context.tempdir");
            }

            if (tempdir != null) {
                saveDir = tempdir.toString();
                setMultipartSaveDir(saveDir);
            }
        } else {
            File multipartSaveDir = new File(saveDir);

            if (!multipartSaveDir.exists()) {
                if (!multipartSaveDir.mkdirs()) {
                    String logMessage;
                    try {
                        logMessage = "Could not find create multipart save directory '" + multipartSaveDir.getCanonicalPath() + "'.";
                    } catch (IOException e) {
                        logMessage = "Could not find create multipart save directory '" + multipartSaveDir.toString() + "'.";
                    }
                    if (devMode) {
                        LOG.error(logMessage);
                    } else {
                        if (LOG.isWarnEnabled()) {
                            LOG.warn(logMessage);
                        }
                    }
                }
            }
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("saveDir=" + saveDir);
        }

        return saveDir;
    }

    /**
     * Modify state of StrutsConstants.STRUTS_MULTIPART_SAVEDIR setting.
     * @param val New setting
     */
    @Override
    @Inject(StrutsConstants.STRUTS_MULTIPART_SAVEDIR)
    public void setMultipartSaveDir(String val) {
        multipartSaveDir = val;
    }

    /**
     * Modify state of StrutsConstants.STRUTS_DEVMODE setting.
     * @param mode New setting
     */
    @Override
    @Inject(StrutsConstants.STRUTS_DEVMODE)
    public void setDevMode(String mode) {
        devMode = "true".equals(mode);
    }
}
