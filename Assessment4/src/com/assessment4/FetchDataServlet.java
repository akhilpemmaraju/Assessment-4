package com.assessment4;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.assessment4.ConnectionManager;
import com.assessment4.Ad;


@WebServlet("/FetchDataServlet")
public class FetchDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchDataServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("YourAd");
		MongoCollection<Document> collection = db.getCollection("ads");

		MongoCursor<Document> cursor = collection.find().iterator();
		List<Ad> dataList = new LinkedList<>();
		
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();
			Ad a = new Ad();
			a.setId(d.getInteger("id"));
			a.setCategory(d.getString("cat"));
			a.setTitle(d.getString("title"));
			a.setCity(d.getString("city"));
			a.setZip(d.getString("zip"));
			a.setDesc(d.getString("desc"));
			a.setEmail(d.getString("email"));
			a.setPhone(d.getString("phone"));
			dataList.add(a);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("list", dataList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("YourAd");
		MongoCollection<Document> collection = db.getCollection("ads");
		List<Ad> dataList = new LinkedList<>();
		request.setAttribute("list", dataList);
		
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		String category = request.getParameter("cat");
		String title = request.getParameter("title");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String desc = request.getParameter("desc");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Document document = new Document("id", id1).append("category", category).append("title", title).append("city",
				city).append("zip", zip).append("desc", desc).append("email", email).append("phone", phone);
		
		String button = request.getParameter("viewads");
		if(button.equals("Add details")) {
			collection.insertOne(document);
			List<Ad> dataList2 = show(collection);
			request.setAttribute("list", dataList2);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}
	List<Ad> show(MongoCollection<Document> collection) {
		List<Ad> dataList = new LinkedList<>();
		MongoCursor<Document> cursor = collection.find().limit(10).iterator();
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();
			Ad ad = new Ad();
			ad.setId(d.getInteger("id"));
			ad.setCategory(d.getString("cat"));
			ad.setTitle(d.getString("title"));
			ad.setCity(d.getString("city"));
			ad.setZip(d.getString("zip"));
			ad.setDesc(d.getString("desc"));
			ad.setEmail(d.getString("email"));
			ad.setPhone(d.getString("phone"));
			dataList.add(ad);
		}
		return dataList;
		
		
	}

}
