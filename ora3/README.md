# 3. óra feladata

## Használat
- Indítsuk el a docker-t.
- A `kafka-broker` mappában futassuk le a `docker-compose up -d` parancsot. Ez elindítja a kafka broker-t és a hozzá szükséges dolokat dockerizált környezetben.
  - Az indításhoz / leállításhoz találhatók a mappában további script fájlok is.
- A `kafka-producer` mappában található maven projectet indítsuk el valamely módon (pl.: IntelliJ IDEA-val).
- A `kafka-consumer` mappában található maven projectet indítsuk el valamely módon (pl.: IntelliJ IDEA-val).
- Ezt követően a ha beküldünk POST-ként a http://localhost:8081/send-message végpontra egy az alább látható adattagokból álló JSON üzenetet akkor ezt a `kafka-producer` alkalmazás kezelni fogja, majd továbbküldi a `kafka-broker`-ba amiből pedig végül a `kafka-consumer` alkalmazás kiolvassa és feldolgozza. 
  ```
	private String message;
	private String from;
	private String room;
  ```
  - A `scripts` mappában található scriptettel tudunk példa üzenetet küldeni (Windows).
    - POST http://localhost:8081/send-message BODY: `{ "from": "me", "message": "nothing important" }`
  - Az üzeneteket a két springboot alkalmazás (producer, consumer) az stdout-jára logolja, hogy látható legyen a működésük.