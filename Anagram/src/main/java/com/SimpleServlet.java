package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;
	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String anagramString = reqest.getParameter("anagramString");
		if(anagramString == null)
		{
			response.getWriter().write("Please use anagramString as parameter. Use similar URL as http://localhost:8080/Anagram/test?anagramString=kk,ll");
			return;
		}
		String tokenString[] = anagramString.split(",");
		JSONObject json = new JSONObject();
		 try{
			 	for(String str:tokenString)
			 		json.put(str, Permutation.generatePermutation(str));
		 } catch (JSONException e) {
			e.printStackTrace();
		 }
		response.getWriter().write(json.toString());
		 //Comment added to test git
		//comment for branch
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}
	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}