package com.util;

import com.dao.Dao;
import com.dao.MySQLDao;
import com.service.IServiceImpl;
import com.service.Service;

public class SessionFactory {
//	private static ControllerServlet controller;
	private static Service service;
	private static Dao dao;

	private SessionFactory() {
	}

//	public static ControllerServlet getController() {
//		if (controller == null)
//			controller = new IControllerImpl();
//		return controller;
//	}

	public static Service getService() {
		if (service == null)
			service = new IServiceImpl();
		return service;
	}

	public static Dao getDao() {
		if (dao == null)
			dao = new MySQLDao();
		return dao;
	}
}
