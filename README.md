 ### 리다이렉션에서 request와 response의 역할 </br></br>
 #### response.sendRedirect():
리다이렉션을 클라이언트에게 지시하는 데 사용됩니다. 해당 메서드는 클라이언트의 URL을 새로운 위치로 변경합니다.
response 객체의 메서드로, 리다이렉션 상태 코드(302, 301 등)와 새로운 URL을 설정합니다.
> ### request 객체:
리다이렉션을 하는 과정에서 직접적으로 사용되지는 않지만, 리다이렉션 전에 request 객체에 데이터를 설정할 수 있습니다.
예를 들어, 리다이렉트된 URL에 쿼리 스트링을 추가하거나, 세션에 데이터를 저장하여 다른 서블릿에서 데이터를 받을 수 있습니다.</br></br>

---------------------
 ## 리다이렉션과 포워딩 차이점</br></br>
* ##### 리다이렉션 (Redirection):

클라이언트에게 새로운 URL로 이동하라는 지시를 내리는 것입니다. 클라이언트는 서버에서 새로운 요청을 보내게 됩니다.
URL이 변경되며, 클라이언트가 새로운 요청을 보냅니다.
예: response.sendRedirect("newURL")</br>

* ##### 포워딩 (Forwarding):

서버 내에서 요청을 다른 리소스로 전달하는 것입니다. 클라이언트는 URL 변경을 인식하지 못합니다.
서버 내부에서 처리되며, URL은 변하지 않습니다.
예: request.getRequestDispatcher("anotherPage").forward(request, response)
결론
리다이렉션에서 **request**와 **response** 객체는 다음과 같이 사용됩니다:

**response** 객체는 리다이렉션을 수행하는 데 직접 사용됩니다. response.sendRedirect() 메서드를 호출하여 클라이언트를 새로운 URL로 리다이렉트합니다.
**request** 객체는 리다이렉션 전에 필요한 데이터를 저장하거나, 쿼리 스트링과 세션을 통해 리다이렉트 후 전달할 데이터를 준비하는 데 사용됩니다.
따라서, 리다이렉션 과정에서 response가 주로 사용되며, request는 데이터 전달을 위한 보조 역할을 합니다.</br></br>

----------------------------

</br></br>
***1.Forward***


    - request +  .forward 
![화면 캡처 2024-11-12 163247](https://github.com/user-attachments/assets/0cc660c8-346a-40ca-9c67-b81bd4be5ad5)



------------------------------------------------------------------------------------------------------------
</br></br>
***2.Redirect***

     -response 주로 쓰임 +request
![화면 캡처 2024-11-12 163459](https://github.com/user-attachments/assets/0f2f432a-d266-4390-8be9-4918ff9c4b3c)




--------------------------------------------------------------------------------------------------------------
</br></br>
## ***.setAttribute***


#### 1. 요청(Request) 객체에 데이터 바인딩<br>
>* HttpServletRequest 객체에 데이터를 바인딩하면, 해당 데이터는 요청이 서버에 도달하는 동안만 유효합니다. <br>
주로 폼 데이터를 서버로 전송할 때 사용됩니다.

      -java
      request.setAttribute("attributeName", value);
      attributeName: 바인딩하려는 속성의 이름
      value: 바인딩할 값 (객체, 문자열 등)
      
      request.setAttribute("username", "JohnDoe");

##### 서블릿에서 JSP로 데이터 전달 <br>
>* 서블릿에서 JSP로 데이터를 전달하려면 request.setAttribute를 사용한 후 RequestDispatcher를 통해 전달할 수 있습니다.

     -servlet
     request.setAttribute("username", "JohnDoe");
     RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
     dispatcher.forward(request, response);
>* JSP에서 데이터 사용: JSP에서는 ${} 구문을 사용하여 전달된 데이터를 사용할 수 있습니다.

     -jsp
     <p>User: ${username}</p> 

<br><br>
     
#### 2. 세션(Session) 객체에 데이터 바인딩 <br>
>* 세션 객체에 데이터를 바인딩하면, 브라우저가 종료될 때까지 또는 세션이 만료될 때까지 유효합니다. <br>
사용자 인증 정보나 장바구니 같은 데이터를 저장할 때 유용합니다.

     -java
     HttpSession session = request.getSession();
     session.setAttribute("attributeName", value);
    
     -java
     HttpSession session = request.getSession();
     session.setAttribute("userId", "john123");


>* 세션에서 데이터 읽기:
     
     -java
     String userId = (String) session.getAttribute("userId");

<br><br>

#### 3. 서블릿 컨텍스트(ServletContext) 객체에 데이터 바인딩 <br>

>* 서블릿 컨텍스트는 웹 애플리케이션 전체에서 공유되는 데이터를 저장하는 곳입니다. <br>
일반적으로 애플리케이션 레벨의 설정이나 공유 데이터를 저장할 때 사용됩니다.
     
     -java
     ServletContext context = getServletContext();
     context.setAttribute("attributeName", value);
     
     -java
     ServletContext context = getServletContext();
     context.setAttribute("appName", "MyWebApp");

<br>

>* 서블릿 컨텍스트에서 데이터 읽기:

     -java
     String appName = (String) context.getAttribute("appName");

<br>

##### 예시코드 <br>

>* 서블릿 코드 (데이터 바인딩 후 JSP로 포워드)

     -java
     @WebServlet("/example")
     public class ExampleServlet extends HttpServlet {
         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             // 데이터 바인딩
             request.setAttribute("username", "JohnDoe");
             request.setAttribute("userAge", 25);
     
             // JSP로 포워드
             RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
             dispatcher.forward(request, response);
         }
     }

<br>

>* JSP 코드 (데이터 읽기)

      -jsp
      <html>
      <body>
          <h2>Welcome, ${username}!</h2>
          <p>Age: ${userAge}</p>
      </body>
      </html>

<br>


</br></br>
* ### .***정리***

request.setAttribute: 요청 범위에서 데이터를 바인딩, 요청이 끝날 때까지 유효. <br>
session.setAttribute: 세션 범위에서 데이터를 바인딩, 브라우저 세션이 유지되는 동안 유효. <br>
context.setAttribute: 애플리케이션 범위에서 데이터를 바인딩, 애플리케이션이 종료될 때까지 유효. <br> 
각각의 setAttribute는 데이터의 유효 범위(scope)에 차이가 있으므로, 적절한 범위를 선택하여 사용해야 합니다. <br>


<br><br>
