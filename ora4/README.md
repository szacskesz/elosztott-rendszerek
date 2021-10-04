# 4. óra feladata

## Használat
- Az `eureka` mappában található maven projectet indítsuk el valamely módon (pl.: IntelliJ IDEA-val).
- Az `gateway-service` mappában található maven projectet indítsuk el valamely módon (pl.: IntelliJ IDEA-val).
- Az `storage-service` mappában található maven projectet indítsuk el valamely módon (pl.: IntelliJ IDEA-val).
- Az `storage-service2` mappában található maven projectet indítsuk el valamely módon (pl.: IntelliJ IDEA-val).
- Az `order` mappában található maven projectet indítsuk el valamely módon (pl.: IntelliJ IDEA-val).

- Ezt követően a http://localhost:8761/ végponton megtekinthető az eureka server, amin lehet ellenőrizni elindult-e a többi server / node.
- A http://localhost:8080/order végpontot meghívva az order service válaszát láthatjuk. Többször meghívásra a "Remaining products" rész után két különböző értéket láthatunk hívásonként csökkenni. Ez azért van mert az "order-service" egyszer az egyik "storage-service"-t máskor a másikat hívja meg, melyeknek különböző állapota van.
- A http://localhost:8081/deliver végponton a "storage-service" első példánya található, ami csökkenti és visszaadja a megmaradt termékek mennyiségét.
- A http://localhost:8082/deliver végponton a "storage-service" második példánya található. működése megegyezik az másik példányéval.
- A http://localhost:8000 címen a "gateway-service" érhető el, ami loadbalancer-ként funkciónál. Így rajta keresztül meghívható a többi publikus szervíz is, esetünkben az "order-service": http://localhost:8000/order
