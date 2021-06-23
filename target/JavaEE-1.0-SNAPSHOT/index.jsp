
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script>
        function digitalClock() {
            var date = new Date();
            var hours = date.getHours();
            var minutes = date.getMinutes();
            var seconds = date.getSeconds();
            //* добавление ведущих нулей */
            if (hours < 10) hours = "0" + hours;
            if (minutes < 10) minutes = "0" + minutes;
            if (seconds < 10) seconds = "0" + seconds;
            document.getElementById("id_clock").innerHTML = hours + ":" + minutes + ":" + seconds;
            setTimeout("digitalClock()", 1000);
        }
    </script>
</head><link rel="stylesheet" href="style.css">


<body background="https://files.fm/thumb_show.php?i=v5wggapg6">
<a id="id_clock"></a>
<script>digitalClock();</script>


        <div class="topnav">

            <a href="register.jsp">Register</a>
            <a href="person-servlet">All User</a>
            <a href="/user/delete.jsp">Delete User</a>
            <a href="/user/deleteByName.jsp">Delete User By Name</a>
            <a href="/user/add.jsp">Bye Mariuana</a>
        </div>




<div id="h3">Welcome to project SIBANAK</div>



<br/>

</body  >




</html>