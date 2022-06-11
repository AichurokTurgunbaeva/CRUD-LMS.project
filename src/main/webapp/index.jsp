<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Dancing+Script:wght@500&family=Inconsolata&family=Macondo&display=swap" rel="stylesheet">
    <style>
        body {
            width: 1200px;
            margin: 0 auto;
            background-repeat: no-repeat;
            background-image: url("https://bipbap.ru/wp-content/uploads/2017/05/1259_more1.jpg");
            background-size: cover;
            background-position: center;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 600px;
            text-align: center;
        }
        .wrapper {
            display: flex;
            flex-direction: column;
            justify-content: center;
            width: 500px;
            height: 200px;
            align-items: center;
        }
        h1 {
            color: crimson;
            font-size: 5rem;
            font-family: 'Courgette', cursive;        }
        button {
            color: black;
            text-decoration: none;
            width: 130px;
            height: 40px;
            text-align: center;
            border-radius: 10px;
            font-size: 20px;
            background-color: darkgreen;
            transition: 1s;
            outline: none;
            border: none;
        }
        button:hover {
            border-radius: 15px;
            box-shadow: 0 0 7px black;
        }
    </style>
</head>
<body>

<div class="wrapper">
    <h1 class="animate__animated animate__backInDown">
        Welcome to Aychushka's project!
    </h1>
    <br/>
    <a href="/api/companies">
        <button>
            START
        </button>
    </a>
</div>
</body>
</html>