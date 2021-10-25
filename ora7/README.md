# 7. óra 1. feladata (websocket-chat)

## Használat
- Indítsuk el a mappában található maven projectet valamely módon (pl.: IntelliJ IDEA-val).
- Ennek hatására elindul a webszerver, ami egyrész kiszolgálja a statikus kéréseket, másrészt a websocket kéréseket.
  - A websocket a `/gs-guide-websocket` végpontra történő csatlakaozással érhető el.
  - Websocket üzenetet a "/app/chat" végpontra tudunk küldeni.
  - Websocket üzenetet a "/chat/messages" végpontra feliratkozva tudunk kapni.
  - Az alkalmazás a fogadott üzenetet továbbítja az összes kapcsolódott felhasználó felé.
- Böngészőből a `http://localhost:8080/` url-t megnyita elérhetjük az alkalmazáshoz készült statikus felületet.
  - A "Connect" gombra kattintva tudunk csatlakozni a websocket szerverhez.
  - A "Disconnetn" gombra kattintva le tudunk csatlakozni a websocket szerverről.
  - A "Message?" cím alatti mező és a "Send" gombok segítségével tudunk üzenetet küldeni.
  - Ha csatalkoztunk a WS-re és küldtünkn egy üzenetet, azt ~1 másodperc műlva vissza fogja küldeni nekünk a szerver ami a felületen is mef fog jelenni a "Messages" cím alatti részben.
