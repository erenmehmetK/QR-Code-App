package nl.delphinity.qr_goats;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

   public String execute() throws Exception {
	   System.out.println("test");
      return "success";
   }
}