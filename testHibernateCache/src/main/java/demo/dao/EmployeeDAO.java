////////////////////////////////////////////////////////////////////////////////
// CountryDAO: $Source$
// TODO Class summary goes here
//
// Created : 26 oct. 2005 by jfsmart
// Last modified $Date$ by $Author$
// Revision: $Revision$
// Version : $ID$
// Copyright (c) 2005
////////////////////////////////////////////////////////////////////////////////

package demo.dao;

import java.util.List;

import demo.pojo.Country;

public class EmployeeDAO {

	public List getEmployeesByCountry(Country country) {
		return SessionManager.currentSession()
		 .createQuery(
		  "from Employee as e where e.country = :country "
        + " order by e.surname, e.firstname")
		  .setParameter("country",country)
		  .list();
	}
}
