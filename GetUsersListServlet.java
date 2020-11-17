package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class GetUsersListServlet extends HttpServlet {
    private UserList uList=UserList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String json=uList.toJSON();
        if(json!=null){
            try(OutputStream os=resp.getOutputStream()){
                byte[] buf=json.getBytes(StandardCharsets.UTF_8);
                os.write(buf);
            }
        }
    }
}
