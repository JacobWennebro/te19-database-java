# TE19Databas
Er uppgift är att skriva ett gränssnitt till någon av era databasprojekt i webbserverkursen (Meeps eller Tasks). Ni använder den existerande datbasen men skapar ett grafiskt gränssnitt som via en controller använder en modell för databaskopplingen.

Ni måste få med följande saker:
- En koppling till er databas, antingen localhost eller via databasservern
- Ett enkelt grafisk gränssnitt som kan visa innehållet i databasen
- Möjlighet att lägga till Meeps eller Tasks
- Möjlighet att ta bort Meeps eller Tasks
- Möjlighet att redigera Meeps eller Tasks
- Det måste finnas en dump av databasen så att andra kan skapa en egen (jag måste kunna testa)
- Det måste finnas möjlighet att lägga in egna inloggningsuppgifter så att den egna databasen kan användas

Ni kan lägga till
- En inloggning så att användaren kopplas till entries i databasen
- Ett snyggare garfisk gränssnitt
- Möjlighet att skapa nya tabeller innifrån programmet
- ...

Tänk på att börja med rätt saker
1. Skapa ett enkelt gui i er MVC, ni kan alltid snygga till det senare
2. Se till att det finns möjlighet att skriva in inloggningsuppgifter och sökvägar
3. Börja med att visa innehållet i databasen, skapa en metod i modellen som hämtar informationen och returnerar det efterfrågade innehållet i lämpligt format.
4. Sedan kan ni lägga till "lägg till" t.ex som en knapp. Informationen kan läggas in på valfritt sätt, JTextFields eller JOptionPanes eller ett separat fönster. Använd samma SQL-kod som ni användt hos Jens! Kolla hur Actionlistenern i controllen kopplas till knappen och aktiverar metoden i modellen.
5. Nästa steg blir "ta bort". Fundera hur du ska välja vilken som ska tas bort. kryssrutor, markeringar eller ange ett id
6. Sista steget blir redigera. Samma som ovan.

Kom ihåg att du måste ha databasen igång när du testar!

Projektet avslutas med ett PM där du utvärderar ditt arbete och berättar vad du tar med dig från det.
Klart torsdag vecka 17.
