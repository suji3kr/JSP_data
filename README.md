 ### 리다이렉션에서 request와 response의 역할 </br></br>
 #### response.sendRedirect():
리다이렉션을 클라이언트에게 지시하는 데 사용됩니다. 이 메서드는 클라이언트의 URL을 새로운 위치로 변경합니다.
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

