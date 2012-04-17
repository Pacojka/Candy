<html>
  <div id="nav">
    </br>
    
    <g:link controller='unit' action='index'>Bande</g:link>
    &nbsp;&nbsp;&nbsp;
    <g:link controller='unit' action='items'>Kiste</g:link>
   &nbsp;&nbsp;&nbsp;

    <g:link controller='unit' action='healer'>Heiler</g:link>
   &nbsp;&nbsp;&nbsp;
    <g:link controller='unit' action='createUnit'>Kinder Knechten</g:link>
    &nbsp;&nbsp;&nbsp;
    <g:link controller='unit' action='map'>Karte</g:link>     
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    
  
  </div>
  
  
  
  
  
  <div id="login">
    <sec:ifLoggedIn>

    Candy:  ${gold}  <g:link controller='logout' action='index'>(Logout)</g:link>
      </sec:ifLoggedIn>
      <sec:ifNotLoggedIn>
        <g:link controller='unit' action='index'>Login</g:link>
    </sec:ifNotLoggedIn>
    </div>
</html>