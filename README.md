## Testkonzept für BookLibrary-Applikation

### Introduction
Die BookLibrary-Applikation ist eine Software zur Verwaltung von Büchern und Bücherlisten. Benutzer können Listen erstellen, Bücher hinzufügen oder entfernen, den Lesestatus der Bücher ändern und Informationen über Bücher und Listen abrufen.

### Test Items
Die zu testenden Elemente umfassen:
- Die gesamte Funktionalität der BookLibrary-Applikation.
- Jede einzelne Komponente der Architektur, einschliesslich der Klassen `Library`, `BookList`, `Book` und `Main` (die CLI)

### Features to be tested
Die zu testenden Features sind:
1. Erstellung neuer Bücherlisten (`NewBookList`)
2. Entfernen von Bücherlisten (`RemoveBookList`)
3. Ändern des Namens von Bücherlisten (`ChangeListName`)
4. Hinzufügen von Büchern zu einer Liste (`AddBook`)
5. Entfernen von Büchern aus einer Liste (`RemoveBook`)
6. Ändern des Lesestatus eines Buchs (`ChangeReadStatus`)
7. 

### Features not to be tested
Nicht getestet werden:
- Nicht-funktionale Aspekte wie Performance, Sicherheit usw.

### Approach
Die Testmethode umfasst:
- Unit-Tests für alle Methoden jeder Klasse (ausser Getters/Setters).
- Manuelle Tests zur Überprüfung der Benutzeroberfläche und Benutzerinteraktion.

### Item pass / fail criteria
- Ein Test gilt als erfolgreich, wenn die erwarteten Ergebnisse erreicht werden und keine schwerwiegenden Fehler auftreten.
- Ein Test gilt als fehlgeschlagen, wenn die erwarteten Ergebnisse nicht erreicht werden oder schwerwiegende Fehler auftreten.

### Test Deliverables
Test-Artefakte umfassen:
- Testkonzept
- Unit-Test-Skripte
- Mockito Dokumentation
  
### Testing Tasks
Die Teststufen umfassen:
1. Unit-Tests für jede Klasse und Methode.
2. Integrationstests für die Zusammenarbeit der Komponenten.

### Environmental Needs
Die Testumgebung erfordert:
- Eine Entwicklungsumgebung mit den erforderlichen Bibliotheken und Frameworks.
- Eine Testumgebung, die die Ausführung von Unit- und Integrationstests ermöglicht.

### Schedule
Die Tests werden gemäss folgendem Zeitplan durchgeführt:
1. Unit-Tests werden während der Entwicklung kontinuierlich durchgeführt.
2. Integrationstests werden durchgeführt, sobald die einzelnen Komponenten implementiert sind.

### Weitere Elemente
Weitere organisatorische Aspekte wie Verantwortlichkeiten, Personal und Abnahmekriterien werden gemäss den Projektanforderungen festgelegt.
