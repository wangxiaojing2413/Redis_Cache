////////////////////////////////////////////////////////////////////////////////
// CountryDAOTest: $Source$
// TODO Class summary goes here
//
// Created : 26 oct. 2005 by jfsmart
// Last modified $Date$ by $Author$
// Revision: $Revision$
// Version : $ID$
// Copyright (c) 2005
////////////////////////////////////////////////////////////////////////////////

package testHibernateCache;

import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Transaction;

import demo.dao.CountryDAO;
import demo.dao.SessionManager;

public class CountryDAOTest extends TestCase {

	/*
	 * Test method for 'com.wakaleo.articles.caching.dao.CountryDAO.getCountries()'
	 */
	public void testGetCountries() {
		CountryDAO dao = new CountryDAO();
		for(int i = 1; i <= 5; i++) {
			Transaction tx = SessionManager.getSession().beginTransaction();
			TestTimer timer = new TestTimer("testGetCountries");
			List countries = dao.getCountries();
			tx.commit();
			timer.done();
			SessionManager.closeSession();
			assertNotNull(countries);
			assertEquals(countries.size(),229);			
		}
	}
}
