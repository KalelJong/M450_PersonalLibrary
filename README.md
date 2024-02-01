## Testkonzept für BookLibrary-Applikation

### Introduction
Die BookLibrary-Applikation ist eine Software zur Verwaltung von Büchern und Bücherlisten. Benutzer können Listen erstellen, Bücher hinzufügen oder entfernen, den Lesestatus der Bücher ändern und Informationen über Bücher und Listen abrufen.

### Test Items
Die zu testenden Elemente umfassen:
- Die gesamte Funktionalität der BookLibrary-Applikation.
- Jede einzelne Komponente der Architektur, einschliesslich der Klassen `Library`, `BookList`, `Book` und `Main` (die CLI)

### Features to be tested
Die zu testenden Features sind:
1. Erstellung eines neuen Book (`testCreateBook`)
2. Book zur BookList hinzufügen (`testAddBook`)
3. Book von BookList entfernen (`testRemoveBook`)
4. Book von BookList lesen (`testGetBookFromList`)
5. BookList zur Library hinzufügen (`testAddList`)
6. BookList:Name von Library ändern (`testChangeListName`)
7. BookList von Library lesen (`testGetList`)
8. Book zur BookList von Library hinzufügen (`testAddBookToList`)
9. BookList von Library entfernen (`testRemoveList`)
10. Book von BookList von Library ReadStatus ändern (`testChangeReadStatus`)

### Features not to be tested
Nicht getestet werden:
- Nicht-funktionale Aspekte wie Performance, Sicherheit usw.

### Approach
Die Testmethode umfasst:
- Unit-Tests für alle Methoden jeder Klasse.
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
- Unit-Tests für jede Klasse und Methode.

### Environmental Needs
Die Testumgebung erfordert:
- Eine Entwicklungsumgebung mit den erforderlichen Bibliotheken und Frameworks.
- Eine Testumgebung, die die Ausführung von Unit-Tests ermöglicht.

### Schedule
Tests werden als erst geschrieben und werden während der Entwicklung kontinuierlich durchgeführt.  

### Weitere Elemente
Weitere organisatorische Aspekte wie Verantwortlichkeiten, Personal und Abnahmekriterien werden gemäss den Projektanforderungen festgelegt.
