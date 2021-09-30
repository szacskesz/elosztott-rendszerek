# 1. óra feladata

## Futtatás
- ItelliJ IDEA-val nyissuk meg a projektet
- Várjuk meg amíg letölti a függőségeket
- A szokásos módon indítsuk el az alkalmazást
- (Ha nincs IDEA akkor az `mvn clean package` paranccsal tudjuk elkészíteni a program futtatható JAR fájlját melyet a `java -jar ${filename}` paranccsal tudunk futtatni)

## Használat
- Az elindult alkalmazás a http://localhost:8080 útvonalon érhető el.
- A http://localhost:8080/ végpontra egy GET kérést küldve egy `Hello World` választ kapunk vissza string formátumban.
- A http://localhost:8080/calculator végpontra egy GET kérést küldve, hozzá query paramkéterként megadva két számot és egy operátort a két szám összegét adja vissza JSON formátumban.
  - Pédául GET http://localhost:8080/calculator?operand1=1&operand2=2&operator=+  ->  `3.0`
	
