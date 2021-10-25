# 7. óra 2. feladata (redis-cache)

## Használat
- Indítsuk el a dockert
- Indítsuk el a redis szervert a következő parancs segítségével: `docker run -p 16379:6379 -d redis:6.0 redis-server --requirepass "mypass"`
- Indítsuk el a mappában található maven projectet valamely módon (pl.: IntelliJ IDEA-val).
- Ezt követően az alkalmatzáshoz generált swagger ui elérhető a `http://localhost:8080/swagger-ui.html` címen.
- Küldjünk be az alábbi példa üzenetet a swagger ui segítségével a "/person" endpointra POST-ként:
`
{
    "id": "id-1",
    "firstname": "Egy",
    "lastname": "Kettő"
}
`
- A swagger ui segítségével kérdezzük le az alőbb megadott ID-hoz tartozó üzenetet a "/person/{id}" endpointra küldve egy GET kérést.
  - Ekkor visszakapjuk az előbb beküldött értéket.
- Küldjünk be az előzőleg megadott id-val egy másikd üzenetet, majd kérdezzük le újra.
  -  Ekkor visszakpjuk a módosított üzenetet.
- Kérdezzünk le egy nem létező id-hoz tartozó üzenetet (pl id-2).
  - Ekkor HTTP 500-at kapunk vissza és a BE logjai között látható, hogy keletkezett egy EntityNotExistException.
