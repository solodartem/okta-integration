<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Init connection</title>

</head>
<body>
<form action="http://localhost:8080/okta-integration/saml/login?disco=true" method="GET">

    <input type="text" name="idp" id="idp_https://dev-245923.oktapreview.com/app/exka3a4igdwiBfp3V0h7" value="http://www.okta.com/exka3a4igdwiBfp3V0h7"/>
    <br>
    <input class="btn btn-default" type="submit" value="Start single sign-on">
</form>
</body>
</html>