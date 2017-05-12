<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GamerQuiz</title>
    </head>
    <body>
        <h1>Login</h1>
        <div>
            <form method="POST" action="/postLogin">
                <table>
                    <tbody>
                        <tr><td>Login</td><td><input type="text" name="login"></td></tr>
                        <tr><td>Senha</td><td><input type="text" name="senha"></td></tr>
                        <tr><td colspan="2"><input type="submit" name="submit"></td></tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
