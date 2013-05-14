package com.strategicgains.restexpress.loader.config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.strategicgains.restexpress.RestExpress;

/**
 * Load Service Instance and binding the route
 * 
 * @author dev
 * 
 */
public class ServiceLoader {
	private static final Logger LOG = LoggerFactory.getLogger(ServiceLoader.class);

	private static Map<String, Object> controllers = new HashMap<String, Object>();
	private static Map<String, Class<?>> controllerClazzs = new HashMap<String, Class<?>>();

	private RestExpress server;

	public void init(AppConfiguration conf, RestExpress server) throws ClassNotFoundException {
		this.server = server;
		loadClass(conf.getServiceClasses());
		routeBind();
	}

	public void loadExMapper(String exceptionMapper) {
		if (StringUtils.isEmpty(exceptionMapper)){
			LOG.info("No exception Mapper in the config");
			return;
		}
		REExceptionMapper exMapper = makeClassInstance(exceptionMapper);
		exMapper.mapExceptions(server);
	}

	public void loadClass(List<String> clazzs) throws ClassNotFoundException {
		for (String clazz : clazzs) {
			controllerClazzs.put(clazz, Class.forName(clazz));
		}
	}

	private void routeBind() {
		for (Map.Entry<String, Class<?>> entry : controllerClazzs.entrySet()) {
			Path rootPath = AnnotationUtils.getClassAnnotation(entry.getValue(), Path.class);
			String clazzName = entry.getValue().getName();
			
			for (Method m : entry.getValue().getMethods()) {
				Method annotatedMethod = AnnotationUtils.getAnnotatedMethod(m);
				String httpMethod = AnnotationUtils
						.getHttpMethodValue(annotatedMethod);
				Path path = AnnotationUtils.getMethodAnnotation(
						annotatedMethod, Path.class);
				
				Produces produces = AnnotationUtils.getMethodAnnotation(
						annotatedMethod, Produces.class);

				if (httpMethod != null || path != null) {
					String fullPath = rootPath!=null ? rootPath.value() + path.value() : path.value();
					OperationInfo op = createOperation(m.getName(),
							new HttpMethod(httpMethod), fullPath,
							entry.getKey(), clazzName+"." + m.getName(), produces);
					routeBuild(op);
				}
			}
		}
	}

	private OperationInfo createOperation(String action,
			HttpMethod httpMethod, String path, String svcClass, String name, Produces produces) {
		OperationInfo op = null;
		if (null == produces){
			op = new OperationInfo(action, httpMethod, path,
					svcClass, name, null);
			
		}else {
			List<String> mediaTypes = getMediaTypes(produces.value());
			
			if(mediaTypes.size() ==1){
				String oneType = mediaTypes.get(0);
				op = new OperationInfo(action, httpMethod, path,
						svcClass, name, oneType);
				
			}else{
				op = new OperationInfo(action, httpMethod, path,
						svcClass, name, null);
			}
		}
		
		return op;
	}
	
	public static List<String> getMediaTypes(String[] values) {
        List<String> supportedMimeTypes = new ArrayList<String>(values.length);
        for (int i = 0; i < values.length; i++) {
            supportedMimeTypes.add(values[i]);    
        }
        return supportedMimeTypes;
    }


	public void routeBuild(OperationInfo op) {
		LOG.info(op.getPath() +":" + op.getAction() + ":" + op.getHttpMethod() +":" + op.getName());
		if ("text/plain".equals(op.getProduces())){
			server.uri(op.getPath(), loadControllerInstance(op.getSvcClass()))
			.action(op.getAction(), op.getHttpMethod()).name(op.getName()).noSerialization();
			
		}else{
			server.uri(op.getPath(), loadControllerInstance(op.getSvcClass()))
			.action(op.getAction(), op.getHttpMethod()).name(op.getName());
		}
		
	}

	@SuppressWarnings("unchecked")
	private <T> T loadControllerInstance(String className) {
		Object obj = controllers.get(className);
		try {
			if (null == obj) {
				obj = controllerClazzs.get(className).newInstance();
				controllers.put(className, obj);
			}
		} catch (InstantiationException e) {
			LOG.error("Failed to load service instance", e);
		} catch (IllegalAccessException e) {
			LOG.error("Failed to load service instance", e);
		}
		return(T)obj;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T makeClassInstance(String clazz){
		T obj=null;
		try {
				obj =(T) Class.forName(clazz).newInstance();
		} catch (InstantiationException e) {
			LOG.error("Failed to load service instance", e);
		} catch (IllegalAccessException e) {
			LOG.error("Failed to load service instance", e);
		} catch (ClassNotFoundException e) {
			LOG.error("Class not found", e);
		}
		
		return obj;
	}

}
