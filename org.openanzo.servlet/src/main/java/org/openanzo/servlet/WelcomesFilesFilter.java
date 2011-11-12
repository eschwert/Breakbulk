/*
 * Copyright 2008 Alin Dreghiciu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openanzo.servlet;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.NullArgumentException;
import org.eclipse.jetty.util.URIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Serves the welcome files if the request path ends with "/".
 * 
 * @author Alin Dreghiciu
 * @since 0.3.0, January 16, 2008
 */
class WelcomeFilesFilter implements Filter {

    private static final Logger      LOG = LoggerFactory.getLogger(WelcomeFilesFilter.class);

    /**
     * Aray of welcome files.
     */
    private final String[]           m_welcomeFiles;

    /**
     * True if the client should be rediected to welcome file or false if forwarded
     */
    private final boolean            m_redirect;

    /**
     * Filter config.
     */
    private FilterConfig             m_filterConfig;

    private final Collection<String> paths;

    /**
     * Creates a welcome files filter.
     * 
     * @param welcomeFiles
     *            array of welcome files
     * @param redirect
     *            true if the client should be rediected to welcome file or false if forwarded
     * 
     * @throws NullArgumentException
     *             if: welcome files array is null or empty entries in array are null or empty entries in array start or end with "/"
     */
    WelcomeFilesFilter(Collection<String> paths, final String[] welcomeFiles, boolean redirect) {
        this.paths = paths;
        if (welcomeFiles.length == 0) {
            throw new NullArgumentException("Welcome files is be empty");
        }
        for (String welcomeFile : welcomeFiles) {
            if (welcomeFile == null || welcomeFile.trim().length() == 0) {
                throw new NullArgumentException("Welcome files entry is null or empty");
            }
            if (welcomeFile.startsWith("/")) {
                throw new NullArgumentException("Welcome files entry [" + welcomeFile + "] starts with '/'");
            }
            if (welcomeFile.endsWith("/")) {
                throw new NullArgumentException("Welcome files entry [" + welcomeFile + "] ends with '/'");
            }
        }
        m_welcomeFiles = welcomeFiles;
        m_redirect = redirect;
    }

    /**
     * Store the filter config.
     * 
     * @see Filter#init(FilterConfig)
     */
    public void init(final FilterConfig filterConfig) throws ServletException {
        m_filterConfig = filterConfig;
    }

    /**
     * Serves the welcome files if request path ends with "/".
     * 
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        LOG.debug("Apply welcome files filter...");
        if (m_welcomeFiles.length > 0 && request instanceof HttpServletRequest) {
            String servletPath = (((HttpServletRequest) request).getServletPath());
            String pathInfo = ((HttpServletRequest) request).getPathInfo();

            LOG.debug("Servlet path: " + servletPath);
            LOG.debug("Path info: " + pathInfo);

            if ((pathInfo != null && pathInfo.endsWith("/")) || (servletPath != null && servletPath.endsWith("/"))) {
                final ServletContext servletContext = m_filterConfig.getServletContext();
                for (String welcomeFile : m_welcomeFiles) {
                    final String welcomePath = URIUtil.addPaths(servletPath, URIUtil.addPaths(pathInfo, welcomeFile));
                    final String welcomeResource = URIUtil.addPaths(pathInfo, welcomeFile);
                    final URL welcomeFileUrl = servletContext.getResource(welcomeResource);
                    if (welcomeFileUrl != null) {
                        if (m_redirect && response instanceof HttpServletResponse) {
                            ((HttpServletResponse) response).sendRedirect(welcomeFile);
                            return;
                        } else {
                            final RequestDispatcher requestDispatcher = request.getRequestDispatcher(welcomePath);
                            if (requestDispatcher != null) {
                                requestDispatcher.forward(request, response);
                                return;
                            }
                        }
                    }
                }
            } else if ((pathInfo == null || pathInfo.length() == 0) && (servletPath != null && paths.contains(servletPath))) {
                final ServletContext servletContext = m_filterConfig.getServletContext();
                for (String welcomeFile : m_welcomeFiles) {
                    final String welcomePath = URIUtil.addPaths(servletPath, welcomeFile);
                    final String welcomeResource = welcomeFile;
                    final URL welcomeFileUrl = servletContext.getResource(welcomeResource);
                    if (welcomeFileUrl != null) {
                        if (m_redirect && response instanceof HttpServletResponse) {
                            ((HttpServletResponse) response).sendRedirect(welcomePath);
                            return;
                        } else {
                            final RequestDispatcher requestDispatcher = request.getRequestDispatcher(welcomePath);
                            if (requestDispatcher != null) {
                                requestDispatcher.forward(request, response);
                                return;
                            }
                        }
                    }
                }
            }
        } else {
            if (m_welcomeFiles.length == 0) {
                LOG.debug("Welcome filter not applied as there are no welcome files configured.");
            }
            if (!(request instanceof HttpServletRequest)) {
                LOG.debug("Welcome filter not applied as the request is not an " + HttpServletRequest.class.getSimpleName());
            }
        }
        // if we are here means that the request was not handled by welcome files filter so, go on
        chain.doFilter(request, response);
    }

    /**
     * Does nothing.
     * 
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // does nothing
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.getClass().getSimpleName()).append("{").append("welcomeFiles=").append(Arrays.toString(m_welcomeFiles)).append("}").toString();
    }
}
