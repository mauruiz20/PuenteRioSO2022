# PuenteRioSO2022

<p>Coches que vienen del norte y del sur pretenden cruzar un puente sobre un río. Sólo existe un carril sobre dicho puente. Por lo tanto, en un momento dado, sólo puede ser cruzado por uno o más coches en la misma dirección (pero no en direcciones opuestas). </p>
<p>Resolver el problema suponiendo que llega un coche del norte (sur) y cruza el puente si no hay otro coche del sur (norte) cruzando el puente en ese momento.</p>

<h3>Solución propuesta utilizando synchronize wait() y notify() en Java</h3>

<p><b>Problema de inanición:</b><br>Se presenta el problema de que pasa si constantemente se encuentran llegando autos que quieren ir del norte a sur de manera que nunca se vacíe el puente de autos cruzando en ese sentido
</p>
<b>Posibles soluciones</b>
<ul>
  <li>Un timer que actúe como un semáforo en el puente</li>
  <li>Un tiempo de espera maximo comun para los autos</li>
</ul>
