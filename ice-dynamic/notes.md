slice2py ./dynamic.ice
## Dynamiczne wykonanie:

Plusy:
- Niepotrzebna wiedza metod w czasie kompilacji klienta.
- Wywołania dynamiczne mogą pozytywnie wpłynąć na efektywność działania powiązanych z Ice rozwiązań - Glacier2(serwis proxy), IceStorm(serwis powiadomień).
- W językach skryptowych używane jest wywołanie dynamiczne, a argumenty są enkodowane interfejsami strumieni.
- Elastyczność, niepotrzebne jest ścisłe powiązanie z interfejsem.
- Można uprościć implementacje, dokonywać pewnych generalizacji.
Minusy:
- Błędy, które mogły zostać wykryte w czasie kompilacji, zostają odkryte w czasie działania programu.
- Ograniczone wsparcie dla streamów w Ice, potrzebnych do użycia w Dynamic Invocation.
- uboga dokumentacja dla Dynamic Invocation.