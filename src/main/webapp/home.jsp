<html>
<head>
    <title>Spring Tutorial</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body>
    <h2>Add an element</h2>
    <form action="addAlien" method="get">
        Enter Alien id : <input type="text" name="aid"><br/><br/>
        Enter Alien Name : <input type="text" name="aname"><br/><br/>
        <input type="submit"/>
    </form>
    <br/><br/>
    <h2>Search an element</h2>
    <form action="getAlien" method="get">
        Enter Alien id : <input type="text" name="aid"><br/><br/>
        <input type="submit"/>
    </form>
    <br/><br/>
    <h2>Delete an element</h2>
    <form action="delAlien" method="get">
        Enter Alien id : <input type="text" name="aid"><br/><br/>
        <input type="submit"/>
    </form>
    <br/><br/>
    <h2>Update an element</h2>
    <form action="delAlien2" method="get">
        Enter Old Alien id : <input type="text" name="aid"><br/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
