/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.strategicgains.restexpress.loader.dto;

import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;
import com.strategicgains.restexpress.loader.config.AppConfiguration;

import com.strategicgains.syntaxe.ValidationEngine;
import com.strategicgains.syntaxe.ValidationException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.jboss.netty.handler.codec.http.HttpMethod;

import org.reflections.Reflections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import java.net.URL;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class DtoAssembler {
    //~ Static fields/initializers =====================================================================================

    private static final Logger LOG = LoggerFactory.getLogger(DtoAssembler.class);
    static Map<Class<?>, List<String>> Query_Map = new HashMap<Class<?>, List<String>>();
    static Map<Class<?>, List<String>> Path_Map = new HashMap<Class<?>, List<String>>();
    static Map<Class<?>, List<String>> Body_Map = new HashMap<Class<?>, List<String>>();

    //~ Methods ========================================================================================================

    private Set<Class<?>> findClasses(String packagename) {
        final Reflections reflections = new Reflections(packagename);
        Set<Class<?>> subTypes = reflections.getTypesAnnotatedWith(RestDto.class);

        return subTypes;
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory The base directory
     * @param packageName The package name for classes found inside the base directory
     *
     * @return The classes
     *
     * @throws ClassNotFoundException
     */
    private List<Class<?>> findClasses(File directory, String packageName)
        throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();

        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }

        return classes;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the body_Map
     */
    public static Map<Class<?>, List<String>> getBody_Map() {
        return Body_Map;
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and
     * subpackages.
     *
     * @param packageName The base package
     *
     * @return The classes
     *
     * @throws ClassNotFoundException
     * @throws IOException
     */
    protected List<Class<?>> getClasses(String packageName)
        throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        List<Class<?>> classes = new ArrayList<Class<?>>();

        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }

        return classes;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the path_Map
     */
    public static Map<Class<?>, List<String>> getPath_Map() {
        return Path_Map;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the query_Map
     */
    public static Map<Class<?>, List<String>> getQuery_Map() {
        return Query_Map;
    }

    public void init(AppConfiguration config) throws ClassNotFoundException, IOException {
        if (StringUtils.isNotEmpty(config.getDtoPackage())) {
            init(config.getDtoPackage());
        }
    }

    public void init(String pkgName) throws ClassNotFoundException, IOException {
        Set<Class<?>> clazzs = findClasses(pkgName);

        for (Class<?> clazz : clazzs) {
            scanActionDto(clazz);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug(Query_Map.toString());
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug(Path_Map.toString());
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug(Body_Map.toString());
        }
    }

    public static <T> T mapAndValidate(final Request request, final Response response, final Class<T> actClazz) {
        T actionDto = null;

        if (request.getHttpMethod().equals(HttpMethod.PUT) || request.getHttpMethod().equals(HttpMethod.POST)) {
            actionDto = request.getBodyAs(actClazz, "Action details not provided");
        }

        try {
            if (null == actionDto) {
                actionDto = actClazz.newInstance();
            }

            for (String name : DtoAssembler.getPath_Map().get(actClazz)) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(name);
                }

                BeanUtils.setProperty(actionDto, name, request.getHeader(name));
            }

            for (String name : DtoAssembler.getQuery_Map().get(actClazz)) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(name);
                }

                BeanUtils.setProperty(actionDto, name, request.getHeader(name));
            }

            ValidationEngine.validateAndThrow(actionDto);
        } catch (Exception ex) {
            if (ValidationException.class.isInstance(ex)) {
                throw (ValidationException) ex;
            } else {
                LOG.error("Failed to handle the request dto", ex);
                throw new ValidationException(ex.getMessage());
            }
        }

        return actionDto;
    }

    /**
     * Scan the dto annotation to fill all the mapper strategy
     *
     * @param clazz DOCUMENT ME!
     */
    public void scanActionDto(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        List<String> annotatedPathFileds = new ArrayList<String>();
        List<String> annotatedQueryFileds = new ArrayList<String>();
        List<String> allFields = new ArrayList<String>();

        for (Field field : fields) {
            allFields.add(field.getName());

            Annotation[] annotations = field.getAnnotations();

            for (Annotation annotation : annotations) {
                if (PathParam.class.isInstance(annotation)) {
                    annotatedPathFileds.add(field.getName());
                } else if (QueryParam.class.isInstance(annotation)) {
                    annotatedQueryFileds.add(field.getName());
                }
            }
        }

        Body_Map.put(clazz, allFields);
        Path_Map.put(clazz, annotatedPathFileds);
        Query_Map.put(clazz, annotatedQueryFileds);
    }
}
