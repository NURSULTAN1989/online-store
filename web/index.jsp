<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%@ include file="templates/head.jsp"%>
    </head>
    <body>
        <%@include file="templates/navbar.jsp"%>
        <div class="container">
            <div class="row mt-3">
            <% ArrayList<Items> items=(ArrayList<Items>)request.getAttribute("items");
                if (items!=null){
                    for (Items item:items){ %>

                <div class="col-sm-2">
                    <div class="card" style="width:180px;">
                        <div class="card-body">
                            <h5 class="card-title"><%=item.getName()%></h5>
                            <p class="card-text"><%=item.getPrice()%></p>
                            <a href="/addkorzina?id=<%=item.getId()%>" class="btn btn-primary">ADD TO CARD</a>
                        </div>
                    </div>
                </div>


            <%
                    }
                }
            %>

            </div>
            <% ArrayList<Items> item=(ArrayList<Items>)session.getAttribute("korzina");
                if (item!=null){
                     %>
                <h1>Hello</h1>
            <% } else out.print("<h1>BUY BUY</h1>");%>
        </div>
    </body>
    <%@include file="templates/scripts.jsp"%>
</html>
