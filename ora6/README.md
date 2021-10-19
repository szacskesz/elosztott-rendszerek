# 6. óra feladata

## Használat
- Az indítsuk el az elasticsearch docker konténert a `scripts` mappában található `start-elastic-search.bat` segítségével
- Ezt követően a http://localhost:9200/ végponton fog futni az elasticseach
- Indítsuk el a gyökérmappában található maven projectet valamely módon (pl.: IntelliJ IDEA-val).
- Ezt követően a http://localhost:8080/ végponton lesz elérhető a szerver, ami az indulása közben kapcsolódni fog az előbb elindított elasticseach-hez.
  - Amennyiben nem indítottuk el az elasticseach-t, a szerver nem fog tudni elindulni.
- A http://localhost:8080/chat végpontra beküldött POST üzenet body-ját, amennyiben megfelel a ChatMessageDto struktúrájának, elmenti a rendszer az elasticseach-be.
- A http://localhost:8080/chat végpontra küldött GET kérésre, amennyiben a body rendelkezik egy `query` adattaggal, a rendszer visszaadja azokat az elasticsearch-ben tárolt ChatMessage-eket, amelyeknek a `sender` mezője megegyezik a beküldött értékkel.
- A http://localhost:8080/chat/by-messsage végpontra küldött GET kérésre, amennyiben a body rendelkezik egy `query` adattaggal, a rendszer visszaadja azokat az elasticsearch-ben tárolt ChatMessage-eket, amelyeknek a `message` mezője megegyezik a beküldött értékkel.
- Néhány üzenetre látható példa a `message-examples.txt` fájlban.

