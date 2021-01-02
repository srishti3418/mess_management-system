<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mess Management System</title>
<style>
h1{
	text-align: center;
  	color: #4CAF50;
  	font-family: 'Roboto', sans-serif;	
}

.modal button {
  background-color: #4CAF50; /* Green background */
  border: 1px solid green; /* Green border */
  color: white; /* White text */
  padding: 10px 15px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  width: 40%; /* Set a width if needed */
  display: block; /* Make the buttons appear below each other */
  margin:20px 20px 20px 70px;
  
}
.modal input{
	margin: 20px;
	}
.modal input:not(:last-child) {
  border-bottom: none; /* Prevent double borders */
}

/* Add a background color on hover */
.modal button:hover {
  background-color: #3e8e41;
}
#home {
  position: obsolute;
  margin: 100px 50px 150px 100px;
  width: 380px;
  height: 400px;
  background: #FFF;
  border-radius: 2px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  left:10px;
  top:100px;
  right:100x;
}
.animate{
	padding:10px 20px 15px 50px;
	}

h2{
	padding-left: 150px;
	padding-right:50px;
	padding-top: 15px;
	}
</style>
</head>
<body style="background-image: url('1-05082.jpg'); background-size: cover;">
<h1>Mess Management System</h1>
<div id="home">

<div id="id01" class="modal">
  	<h2>LOGIN</h2>
  <form class="animate" action="LoginServlet" method="post">
      <label for="uname"><b>Username:</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label for="psw"><b>Password:</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
       <label>
        <input type="checkbox" checked="checked" name="remember" id="rem">Remember me
      </label> 
      <button type="submit">Login</button>
      
  </form>
</div>
</div>
</body>
</html>
