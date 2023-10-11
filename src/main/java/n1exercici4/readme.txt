Tasca 5, nivell 1, exercici 4

"Els exercicis dels 3 nivells han d'executar-se des de la línia de comandos, i no sols des de l'editor. Crea un fitxer anomenat “readme.txt” per explicar el comando a executar a cada exercici."

"Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola."

Llista de comandos:
Compilar:
javac n1exercici4\App.java

Executar:
Llistar els continguts d'un directori: java n1exercici4.App log [directory path to be listed] [.txt file to print to]
- Per exemple: java n1exercici4.App log C:\Users\username\IdeaProjects\EspJavaS1T5 C:\Users\username\docs\ouput.txt
- Si l'arxiu .txt no existeix, se'n crea un de nou. Si ja existeix, se sobreescriu.

Llegir un arxiu .txt: java n1exercici4.App read [.txt file to read]
- Per exemple: java n1exercici4.App read C:\Users\username\docs\input.txt