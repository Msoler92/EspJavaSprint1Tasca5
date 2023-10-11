Tasca 5, nivell 1, exercici 5

"Els exercicis dels 3 nivells han d'executar-se des de la línia de comandos, i no sols des de l'editor. Crea un fitxer anomenat “readme.txt” per explicar el comando a executar a cada exercici."

Ara el programa ha de serialitzar un Objecte Java a un fitxer .ser i després l’ha de desserialitzar.

Llista de comandos:
Compilar:
javac n1exercici5\App.java

Executar:
Llistar els continguts d'un directori: java n1exercici5.App log [directory path to be listed] [.txt file to print to]
- Per exemple: java n1exercici5.App log C:\Users\username\IdeaProjects\EspJavaS1T5 C:\Users\username\docs\ouput.txt
- Si l'arxiu .txt no existeix, se'n crea un de nou. Si ja existeix, se sobreescriu.

Llegir un arxiu .txt: java n1exercici5.App read [.txt file to read]
- Per exemple: java n1exercici5.App read C:\Users\username\docs\input.txt

Serialitzar un objecte: java n1exercici5.App testserialize
- Aquesta funcionalitat crea una instància d'un objecte dummy i el serialitza a un fitxer .ser

Deserialitzar un objecte: java n1exercici5.App testdeserialize
- Aquesta funcionalitat deserialitza un fitxer .ser i imprimeix l'objecte resultant per consola