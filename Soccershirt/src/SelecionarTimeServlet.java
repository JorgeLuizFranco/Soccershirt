import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class SelecionarTimeServlet extends HttpServlet {
  //@Consumes(MediaType.APPLICATION_JSON)
      public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();//get the stream to write the data
            String requestData = request.getReader().lines().collect(Collectors.joining());
            int id= Integer.parseInt(requestData);
            TimeDAO bd= new TimeDAO();
            Time time=bd.getTime(id);
            Json js= new Json();
            pw.print(js.enviaTime(time));
          pw.close();
      }
}
