#                         **JAVA登陆注册**

### 1.1、注册功能

1. 获取注册页面提交的username、password和repeatPassword；
2. 判断password和 repeatPassword是否一致，一致就继续执行程序，不一致则结束程序；
3. 遍历数据库中tb_user，查看数据库中是否存在username，存在则结束程序，不存在则继续进行程序，实现注册功能；

### 1.2、登录功能

1. 获取登录页面的username和password；
2. 遍历数据库中tb_user，是否存在username，存在则继续执行程序，不存在，则结束程序；
3. 遍历数据库中tb_user，查找对应username的password，判断password是否与登录页面的password一致，一致则完成登录，不一致则跳出。

##### Servlet实现交互式浏览和修改数据

1) 客户端发送请求至服务器端；
2) 服务器将请求信息发送至 Servlet；
3) Servlet 生成响应内容并将其传给服务器。响应内容动态生成，通常取决于客户端的请求；
4) 服务器将响应返回给客户端。

**Servlet的jar包导入idea**

​	1、选中项目（在IntelliJ中称为Module）；
​	2、点击右键，选择open modual settings（或者直接按F4）；
​	3、在弹出的窗口左端选择Libraries；
​	4、点击顶端的一个类似加号“+”的图标，选择java；
​	5、在弹出的窗口中选择tomcat所在的目录，进入里面的lib目录，寻找servlet-api.jar这个jar包（如果JSP页面也有相关的JavaWeb对象，则还要寻找jsp-api.jar；如果只有Servlet，则只选择servlet-api.jar）；
​	6、选中上述jar包，依次点击OK。

**request.setCharacterEncoding("UTF-8")**;
    用来确保发往服务器的参数以汉字的编码来提取，设置从request中取得的值或从数据库中取出的值。
    指定后可以通过request.getParameter()获取自己想要的字符串；
    该方法只对post请求有效，对get请求无效；

**遍历tb_user表，将数据库中所有username存入集合中**
    st = conn.createStatement();
    rs = st.executeQuery(selectUsername);
    String selectUsername = "select username from tb_user";
    List<String> usernameList = new ArrayList<String>();
        while (rs.next()) {
        usernameList.add(rs.getString(1));
    }
其中selectUsername是一个String类型的变量，用来存储查询语句sql；

**参考文档：**
<br>总项目设计 https://www.cnblogs.com/martin0319/p/7780449.html<br>
Servlet相关文档 https://developer.aliyun.com/article/1316019<br>
ResultSet类详解 https://cloud.tencent.com/developer/article/2339433<br>
PreparedStatement 详解 https://cloud.tencent.com/developer/article/2339451<br>
**其他登陆注册页面：**
<br>https://blog.csdn.net/l_zl2021/article/details/126503684<br>
https://blog.csdn.net/qq_57747969/article/details/132656450<br>
https://blog.csdn.net/wuyomhchang/article/details/134401683<br>
https://blog.csdn.net/Rouer_jia/article/details/135257672<br>
**上传GitHub**
<br>https://blog.csdn.net/qq_45432276/article/details/132109657<br>
https://blog.csdn.net/qq_37954460/article/details/120628439<br>https://blog.csdn.net/l_zl2021/article/details/126503684<br>
