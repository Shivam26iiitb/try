package com.iiitb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testser
 */
@WebServlet("/testser")
public class testser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public testser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String to,subject,body,from,pass;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
		out.println("hi");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("fkdgfjhdghdoiikdjl");
	        try {
	            to="nirav.bakori@iiitb.org";
	            subject="Test mail java";
	            body="Mail java success";
	            HttpSession ses=request.getSession();
	            from="shivam.upadhyay26@gmail.com";
	            pass="abesenggcollege";
	        //    fname=request.getParameter("file");
	            Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class",
		 			"javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");
	 
		    Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication 
	                                        getPasswordAuthentication() {
						return new PasswordAuthentication(from,pass);
					}
				});
	 
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(body);
	                       
	                       // setFileAsAttachment(message,fname);
	 
				Transport.send(message);
	 
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	            out.println("<html>");
	            out.println("<head>");
	            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Message Sent</h1>");
	            out.println("</body>");
	            out.println("</html>");
	        } finally {            
	            out.close();
	        }
	}

}
