<%@ page session="true" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <!--%@ page import="servlets.Login"%-->
        <%@ page import="java.util.*" %>

        <%@ page import="javax.servlet.*"%>

            <html>

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <link rel="canonical" href="https://aldi.github.io/bulma-login-template/" />
                <title>Login</title>
                <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet" />
                <link rel="stylesheet" href="../../../view/css/bulma.min.css" />
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma-social@1/bin/bulma-social.min.css" />
                <link rel="stylesheet"
                    href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.13.0/css/all.min.css" />
                <link rel="stylesheet" href="../../../view/css/styles.css" />
                <script src="./../../script/variabili.js"></script> 
            </head>

            <body>

                <script>
                    function gotoRegistrazione() {
                        window.location.href = uriServer + "registrazione";
                    }
                </script>


                <section class="hero is-fullheight">
                    <div class="hero-body">
                        <div class="container has-text-centered">
                            <div class="column is-4 is-offset-4">
                                <div class="box">
                                    <img src="./media/comic1.png" width="50">
                                    <p class="subtitle is-4">Accedi per poter iniziare!</p>

                                    <form name="loginForm" method="post" action="../../../login">
                                        <div class="">
                                            <p class="control has-icons-left has-icons-right">
                                                <input class="input is-medium" type="username" placeholder="Username" name="username"
                                                />
                                                <span class="icon is-medium is-left">
                                                    <i class="fas fa-file-user"></i>
                                                    <i style='font-size:24px' class='fas'>&#xf406;</i>
                                                </span>
                                                <span class="icon is-medium is-right">
                                                    <!--i class="fas fa-check"></i-->
                                                </span>
                                            </p>
                                        </div>
                                        <div class="field">
                                            <p class="control has-icons-left">
                                                <input class="input is-medium" type="password" placeholder="Password" name="password"/>
                                                <span class="icon is-small is-left">
                                                    <i class="fas fa-lock"></i>
                                                </span>
                                            </p>
                                        </div>
                                        <!--div class="field">
                    <label class="checkbox">
                      <input type="checkbox" />
                      Remember me
                    </label>
                  </div-->
                                        <button
                                            class="button is-block is-info is-large is-fullwidth is-rounded ">Accedi</button><br />

                                    </form>
                                </div>
                                <!--p class="has-text-grey">
                <a href="#">Sign Up</a>
              </p-->
                                <button
                                    class="button is-block button is-dark  is-small is-fullwidth is-rounded is-outlined"
                                    onclick="gotoRegistrazione()">Registrati</button><br />
                            </div>
                        </div>
                    </div>
                        
                    <% 
                        if (request.getParameter("errore")!=null){
                            String errore = request.getParameter("errore");
                           
                    %>
                            <br>
                            Errore: <%= errore %>
                    <%		
                        }
                    %>

                </section>
            </body>

            </html>