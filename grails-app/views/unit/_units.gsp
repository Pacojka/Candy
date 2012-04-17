<g:if test="${!unit.away()}">
  <div id="table">
    <table cellspacing="0">
      <tr>
        <td width="200px"  bgcolor="#969696">
          
          
          
          
          <h2><g:link action="unitview" params="[unitid:unit.id]">${unit.name}</g:link></h2>
          
          <img src="../images/chars/Chars/c1.png" alt="Tanzmaus">
          
        </td>
        <td width="340px" bgcolor="#969696">
          
          
          <!--
          <div id="hpbalken">
            <div style="background-color:#969696; z-index:1; width:${unit.curhppr}%;face="Arial">&nbsp</font> </div>
          </div>

          <div id="hp">
             ${unit.curhp}/${unit.maxhp}
          </div>
         -->
          
      
          
          
         
         
         
         
         
         
         
         
         
         
         
         Zufriedenheit
      <div id="hpbalken">
        
        <div style="background-color:#4e4e4e; z-index:1; width:${unit.curhppr}%;face="Arial">&nbsp</font> </div>
      </div>
         </br>   
         </br> 
          Energie
      <div id="hpbalken">
        
        <div style="background-color:#4e4e4e; z-index:1; width:${unit.curhppr}%;face="Arial">&nbsp</font> </div>
      </div>

      <div id="hp">
        ${unit.curhp}/${unit.maxhp}
      </div>
          </br>
          </br>
          </br>
      <div id="table" >
        <table cellspacing="0">

          <tr>
            <td bgcolor="#969696">Staerke
              <div id="balken">
                <div style="background-color:#440000; width:${unit.strToNext}%;face="Arial"> ${unit.str}</font></div> </div>
            </td>


            <td bgcolor="#969696">List
              <div id="balken">
                <div style="background-color:#440000; width:${unit.gesToNext}%;face="Arial">${unit.ges}</font></div> </div>
            </td>


            <td bgcolor="#969696">Coolness
              <div id="balken">
                <div style="background-color:#440000; width:${unit.inzToNext}%;face="Arial">  ${unit.inz}</font></div> </div>
            </td>

          </tr>

          
          </tr>
        </table>
      </div>
      
      
      
      </br>
     
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
          
          
          
          
          
          
          
          
          
          
          
        </td>
        
        
        
        
        
        
      </tr>
    </table>

  </div>
</g:if>






