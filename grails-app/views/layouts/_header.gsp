<html>
  <div id="header">

    <div id="loginheader">
      <sec:ifLoggedIn>

<h2>Jo <sec:loggedInUserInfo field="username"/><g:link controller='logout' action='index'>(Logout)</g:link></h2>
      </sec:ifLoggedIn>
      <sec:ifNotLoggedIn>
        <h2><g:link controller='unit' action='index'>Login</g:link></h2>
      </sec:ifNotLoggedIn>
    </div>


  </div>
</html> 