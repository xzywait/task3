package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Book;

import dao.impl.BookDaoImpl;

public class BookServlet extends HttpServlet {

	public BookServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String redirect = "";
		String action = request.getParameter("action");
		if ("save".equals(action)) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			String bid1 = request.getParameter("bid");
			String bid = new String(bid1.getBytes("ISO-8859-1"), "utf-8");

			System.out.println(bid);

			String name1 = request.getParameter("name");
			String name = new String(name1.getBytes("ISO-8859-1"), "utf-8");

			System.out.println(name);

			String author1 = request.getParameter("author");
			String author = new String(author1.getBytes("ISO-8859-1"), "utf-8");

			System.out.println(author);

			String publisher1 = request.getParameter("publisher");
			String publisher = new String(publisher1.getBytes("ISO-8859-1"),
					"utf-8");

			System.out.println(publisher);

			String publishdate1 = request.getParameter("publishdate");
			String publishdate = new String(
					publishdate1.getBytes("ISO-8859-1"), "utf-8");

			System.out.println(publishdate);

			String price1 = request.getParameter("price");
			String price = new String(price1.getBytes("ISO-8859-1"), "utf-8");

			System.out.println(price);

			String isedit1 = request.getParameter("isedit");
			String isedit = new String(isedit1.getBytes("ISO-8859-1"), "utf-8");
			
			System.out.println(isedit);

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Book book = new Book();
			try {
				book = new Book(Integer.parseInt(bid), name, author, publisher,
						format.parse(publishdate), Float.parseFloat(price));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BookDaoImpl bookDaoImpl = new BookDaoImpl();
			System.out.println(book);
			if ("true".equals(isedit)) {
				bookDaoImpl.update(book);
			} else {

				bookDaoImpl.add(book);
			}
			redirect = "success.jsp";

		} else if ("delete".equals(action)) {
			String bid1 = request.getParameter("id");
			String bid = new String(bid1.getBytes("ISO-8859-1"), "utf-8");
			BookDaoImpl bookDaoImpl = new BookDaoImpl();

			System.out.println(bid);

			int id = Integer.parseInt(bid);

			bookDaoImpl.deleteById(id);
			redirect = "index.jsp";
		} else if ("query".equals(action)) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String name1 = request.getParameter("name");
			String name = new String(name1.getBytes("ISO-8859-1"), "utf-8");
			System.out.println(name);
			BookDaoImpl bookDaoImpl = new BookDaoImpl();
			Book book = bookDaoImpl.findByName(name);
			List<Book> bookList = new ArrayList<Book>();
			bookList.add(book);
			request.setAttribute("bookList", bookList);

			forward = "index.jsp";
		} else if ("edit".equals(action)) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String name1 = request.getParameter("name");
			String name = new String(name1.getBytes("ISO-8859-1"), "utf-8");
			System.out.println(name);
			BookDaoImpl bookDaoImpl = new BookDaoImpl();
			Book book = bookDaoImpl.findByName(name);

			request.setAttribute("book", book);
			request.setAttribute("isedit", "true");

			forward = "edit.jsp";
		} else {
			BookDaoImpl bookDaoImpl = new BookDaoImpl();
			List<Book> bookList = bookDaoImpl.getAll();
			request.setAttribute("bookList", bookList);
			forward = "index.jsp";
		}
		if ("".equals(redirect)) {
			request.getRequestDispatcher(forward).forward(request, response);

		} else {
			response.sendRedirect(redirect);
		}

	}

}
