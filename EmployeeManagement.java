package com.Employees;

import com.google.gson.Gson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/Details")

public class EmployeeManagement  extends HttpServlet {

    static ArrayList <Employees> employees=new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter=resp.getWriter();

//   for(Employees emp:employees)
//   {
//
//       printWriter.println("<h3>name:"+emp.getName()+"<h3>");
//       printWriter.println("<h3>id:"+emp.getId()+"<h3>");
//       printWriter.println("Data Retireved Done..");
//   }
//

        resp.setContentType("application/json");
      Gson gson=new Gson();
      String s= gson.toJson(employees);
      printWriter.println(s);



    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String name=req.getParameter("name");
        String id=req.getParameter("id");

      employees.add(new Employees(name,id));

        PrintWriter printWriter=resp.getWriter();
        printWriter.println("Data Added successfully!!");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id=req.getParameter("id");
        PrintWriter printWriter=resp.getWriter();
        for(Employees emp:employees)
        {
            if(id.equals(emp.getId())){
                employees.remove(emp);
                printWriter.println("Deleted Succesfully!!!");

            }

        }

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String id=req.getParameter("id");
        PrintWriter printWriter=resp.getWriter();



        for(Employees emp:employees)
        {
            if(id.equals(emp.getId())){

                emp.setName(name);
                printWriter.println("updated!!");
            }

        }



        }


    }

