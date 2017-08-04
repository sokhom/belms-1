/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.repo.SqlSessionFactoryMngt;

public class ServiceProvider {

	private static ServiceProvider serviceProvider;

	private Map<String, ServiceFactory> serviceFactories = new HashMap<String, ServiceFactory>();
	private SqlSessionFactoryMngt factoryMngt;
	
	private ServiceProvider() {
		ServiceLoader<ServiceFactory> loader = ServiceLoader.load(ServiceFactory.class);
		try {
			Iterator<ServiceFactory> serviceFactorys = loader.iterator();
			while (serviceFactorys.hasNext()) {
				ServiceFactory serviceFactory =  serviceFactorys.next();
				serviceFactories.put(serviceFactory.getId(), serviceFactory);
			}
		} catch (ServiceConfigurationError serviceError) {
			serviceError.printStackTrace();
		}
		
		
		ServiceLoader<SqlSessionFactoryMngt> repoServiceLoader =  ServiceLoader.load(SqlSessionFactoryMngt.class);
			if(repoServiceLoader.iterator().hasNext()) {
				factoryMngt = repoServiceLoader.iterator().next();
			}
		
		try {
			
		} catch (ServiceConfigurationError serviceError) {
			serviceError.printStackTrace();

		}
		
	}	
	
	public SqlSessionFactoryMngt getFactoryMngt() {
		return factoryMngt;
	}

	public Map<String, ServiceFactory> getServiceFactories() {
		return serviceFactories;
	}

	
	public static ProcessingService getProcessingService(String serviceId) {
		return get(serviceId).getService();
	}
	
	public static <E,T extends BasedModel>LookupService<E,T> getLookupService(String serviceId){
		return get(serviceId).getLookupService();
	}
	
	public static ServiceFactory get(String serviceId) {
		if (serviceProvider == null) {
			serviceProvider = new ServiceProvider();
		}
		
		if(!serviceProvider.getServiceFactories().containsKey(serviceId)){
			throw new RuntimeException(String.format("%s not found ", serviceId));
		}
		
		return serviceProvider.getServiceFactories().get(serviceId);
	}
	
	public static SqlSessionFactoryMngt getSessionFactory() {
		if (serviceProvider == null) {
			serviceProvider = new ServiceProvider();
		}
		
		if(serviceProvider.getFactoryMngt()  == null) {
			throw new RuntimeException("No SQL session factory management is found");
		}
		return serviceProvider.getFactoryMngt();
		
	}
	
	public static SqlSession newSession() {
		return getSessionFactory().newSession();
	}
}
