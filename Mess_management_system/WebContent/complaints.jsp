<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
  font-size: 16px;
  color: #4CAF50;
  font-family: 'Roboto', sans-serif;
  font-weight: 300;
  text-allign: center;
}
#complaint-box {
  position: relative;
  margin: 80px 350px 50px 100px;
  padding: 40px;
  width: 500px;
  height: 100px;
  background: #FFF;
  border-radius: 2px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
}

input[type="text"]{
  display: block;
  box-sizing: border-box;
  margin-bottom: 20px;
  padding: 4px;
  width: 500px;
  height: 32px;
  border: none;
  border-bottom: 1px solid #4CAF50;
  font-family: 'Roboto', sans-serif;
  font-weight: 400;
  font-size: 15px;
  transition: 0.2s ease;
}

input[type="text"]:focus{
  border-bottom: 2px solid #16a085;
  color: #16a085;
  transition: 0.2s ease;
}

input[type="submit"] {
  margin-top: 10px;
  width: 120px;
  height: 32px;
  background: #4CAF50;
  border: none;
  border-radius: 2px;
  color: #FFF;
  font-family: 'Roboto', sans-serif;
  font-weight: 500;
  text-transform: uppercase;
  transition: 0.1s ease;
  cursor: pointer;
}

input[type="submit"]:hover,
input[type="submit"]:focus {
  opacity: 0.8;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
}

input[type="submit"]:active {
  opacity: 1;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
}
</style>
<title>Mess Management System</title>
</head>
<body style="background-image: url('1-05082.jpg'); background-size: cover;">
<h1>Mess Management System</h1>
<div id="complaint-box">
  <form>
    <label>Complaint</label>
    <input type = "text" name = "complaints" Placeholder = "Write your complaint here">
    <input type = "submit" value = "Submit">
  </form>
</div>
</body>
</html>