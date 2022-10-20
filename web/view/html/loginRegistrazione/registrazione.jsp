<%@ page session="true" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <!--%@ page import="servlets.Login"%-->
        <%@ page import="java.util.*" %>

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
            </head>

            <body>
                <section class="hero is-fullheight">
                    <div class="hero-body">
                        <div class="container has-text-centered">
                            <div class="column is-4 is-offset-4">
                                <div class="box">
                                    <img src="../../media/comic1.png" width="50">
                                    <p class="subtitle is-4">Registrati prima di continuare!</p>

                                    <form name="register" method="post" action="Login?req=registration">
                                        <div class="">
                                            <p class="control has-icons-left has-icons-right">
                                                <input class="input is-medium" type="username" placeholder="Username" />
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
                                                <input class="input is-medium" type="password" placeholder="Password" />
                                                <span class="icon is-small is-left">
                                                    <i class="fas fa-lock"></i>
                                                </span>
                                            </p>
                                        </div>
                                        <!--div class="field">
                    <p class="control has-icons-left">
                      <input class="input is-medium" type="password" placeholder="Confirm password" />
                      <span class="icon is-small is-left">
                        <i class="fas fa-lock"></i>
                      </span>
                    </p>
                  </div-->

                                        <fieldse align="center">
                                            <legend>Scegli il tipo di utente:</legend>

                                            </fieldset>

                                            <div class="languages select is-rounded">
                                                <select>
                                                    <option selected>Acquirente</option>
                                                    <option>Negoziante</option>
                                                </select>
                                            </div>
                                </div>

                                <!--div class="field">
                  <label class="checkbox">
                    <input type="checkbox" />
                    Remember me
                  </label>
                </div-->
                                <button
                                    class="button is-block is-info is-large is-fullwidth is-rounded ">Registrati</button><br />

                                </form>
                            </div>
                            <!--p class="has-text-grey">
              <a href="#">Sign Up</a>
            </p-->

                        </div>
                    </div>
                    </div>

                </section>
            </body>

            </html>









