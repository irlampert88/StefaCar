package com.stefanini.stefacar.infra.dao.transactional;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.controller.shared.MessengerSystem;

@Interceptor 
@Transactional
public class TransactionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object intercept(InvocationContext context){
		Object resultado = null;

		try {
			entityManager.getTransaction().begin();

			resultado = context.proceed();

			entityManager.getTransaction().commit();

		} catch (Exception e) {

			entityManager.getTransaction().rollback();

			MessengerSystem.notifyError("Erro - ",
				"Detalhes do erro: " + e.getClass().getName() + " - " + e.getMessage());

			e.printStackTrace();
			
			throw new RuntimeException(e);
		}

		return resultado;
	}
}
