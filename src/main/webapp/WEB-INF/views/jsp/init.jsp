<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Init connection</title>

</head>
<body>
<form action="/okta-integration/opened/redirectToWebSSO" method="GET">

    <input type="text" width="100%" name="metadataURL" value="https://dev-245923.oktapreview.com/app/exka3a4igdwiBfp3V0h7/sso/saml/metadata"/>
    <br>
    <input class="btn btn-default" type="submit" value="Start single sign-on">
</form>
</body>
</html>