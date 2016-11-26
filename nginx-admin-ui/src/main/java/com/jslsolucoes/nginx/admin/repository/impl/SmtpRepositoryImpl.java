/*******************************************************************************
 * Copyright 2016 JSL Solucoes LTDA - https://jslsolucoes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.jslsolucoes.nginx.admin.repository.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.jslsolucoes.nginx.admin.model.Smtp;
import com.jslsolucoes.nginx.admin.repository.SmtpRepository;

@RequestScoped
public class SmtpRepositoryImpl extends RepositoryImpl<Smtp> implements SmtpRepository {

	public SmtpRepositoryImpl() {

	}

	@Inject
	public SmtpRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Smtp smtp() {
		try {
			Query query = entityManager.createQuery("from Smtp");
			return (Smtp) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}