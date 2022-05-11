Softwaretechnologie: Java 2

# Übung 6


Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.

## Aufgabe 1

Im Spiel ["Türme von Hanoi"](https://de.wikipedia.org/wiki/Türme_von_Hanoi) besteht die Aufgabe darin, einen Stapel scheiben vom linken auf den rechten Stab zu befördern. Dazu darf ein dritter Stab in der Mitte verwendet werden. In jedem Zug darf eine Scheibe auf einen anderen Stab gelegt werden, allerdings darf niemals eine größere auf einer kleineren Scheibe liegen.

![](https://upload.wikimedia.org/wikipedia/commons/0/07/Tower_of_Hanoi.jpeg)

In der Klasse `idh.java.Hanoi` finden Sie eine Rumpfimplementierung für das Spiel, wobei die Stäbe hier waagerecht dargestellt werden, und die Scheibengröße nur durch Zahlen repräsentiert werden. Eine gültige Situation im Spiel sieht in der Fassung so aus:

```
  | 
 l|9 8 7 6
  |
 m|5 4
  |
 r|3 2 1
  |
```

Der Benutzer gibt dabei immer zwei Buchstaben ein, einen für die Quelle (von wo eine Scheibe entnommen wird) und eine für den Zielstab (wo die Scheibe abgelegt wird), also z.B. `lm` für "Nimm die oberste Scheibe vom linken Stab und lege sie auf den mittleren".

Ihre Aufgabe besteht darin, die Klasse so fertig zu implementieren, dass das Spiel spielbar ist. Dazu müssen Sie eine geeignete Datenstruktur auswählen und in allen mit `TODO: Implement` markierten Methoden verwenden. Außerdem sollten Sie die Datenstruktur initialisieren, so dass am Anfang Scheiben der Größen 9 bis 1 auf dem linken Stab liegen.

## Aufgabe 2



----

Wenn Sie fertig sind, committen Sie alle Ihre Änderungen am Quellcode, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 