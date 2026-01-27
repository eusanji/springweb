package com.springweb.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.springweb.dao.CarDao;
import com.springweb.model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CarController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/car.jsp";
	    private static String LIST_USER = "/listCar.jsp";
	    private CarDao dao;
	    ApplicationContext context;

	    public CarController() {
	        super();
	        context = new ClassPathXmlApplicationContext("spring.xml");
	        dao = (CarDao) context.getBean("CarDao");
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward = "";
	        String action = request.getParameter("action");
	        try {
	            if(action.equalsIgnoreCase("delete")){
	                int CardId = Integer.parseInt(request.getParameter("cardId"));
	                dao.deleteCar(CardId);
	                forward = LIST_USER;
	                request.setAttribute("cars", dao.getAllCars());
	            } else if (action.equalsIgnoreCase("edit")) {
	                forward = INSERT_OR_EDIT;
	                int CardId = Integer.parseInt(request.getParameter("cardId"));
	                Car car = dao.getCarById(CardId);
	                request.setAttribute("car", car);
	            } else if (action.equalsIgnoreCase("listCar")){
	                forward = LIST_USER;
	                request.setAttribute("cars", dao.getAllCars() );
	            } else {
	                forward = INSERT_OR_EDIT;
	            }
	            RequestDispatcher view = request.getRequestDispatcher(forward);
	            view.forward(request,response);
	        } catch (SQLException e){
	            e.printStackTrace();
	        }

	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	    	Car car = (Car) context.getBean("Car");
	    	car.setManufacturer(request.getParameter("manufacturer"));
	    	car.setModel(Integer.parseInt(request.getParameter("model")));
	    	String carId = request.getParameter("carId");
	    	try {
	    		if (carId == null || carId.isEmpty()){
		    		dao.insertCar(car);
					
				} else {
					car.setCarId(Integer.parseInt(carId));
					dao.updateCar(car);
				}
	    	} catch (SQLException e) {
	    		e.printStackTrace();
			}
	    	
	    	RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	    	try {
				request.setAttribute("cars", dao.getAllCars());
				view.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}	    		    	
	    }
}
